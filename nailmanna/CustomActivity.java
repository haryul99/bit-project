package com.example.nailmanna;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import yuku.ambilwarna.AmbilWarnaDialog;

public class CustomActivity extends AppCompatActivity {
    // Nailcustom 화면

    LoginResponse loginResponse;

    // 무광 switch
    public TextView matte;
    // 큐빅 이동 code
    public enum TOUCH_MODE {
        NONE, //터치 안 했을 떄
        SINGLE, // 한 손가락 터치
        MULTI //두손가락 터치
    }
    private ImageView imageView;
    private TOUCH_MODE touchMode;

    private Matrix matrix; // 기존의 매트릭스
    private Matrix savedMatrix; // 작업 후 이미지에 매핑할 매트릭스
    private PointF startPoint; //한손가락 터치 이동 포인트
    private PointF midPoint; //두손가락 터치 시 중심 포인트
    private float oldDistance; //터치 시 두손가락 사이의 거리
    private double oldDegree = 0; // 두 손가락의 각도

    //프래그먼트 화면
    private static final int NUM_PAGES=3;  //페이지 수
    private ViewPager2 pager;
    private FragmentStateAdapter pagerAdapter;

    // text view variable to set the color for GFG text
    private TextView gfgTextView;

    // two buttons to open color picker dialog and one to
    // set the color for GFG text
    private Button mSetColorButton, mPickColorButton;

    // view box to preview the selected color
    private View mColorPreview;

    // this is the default color of the preview box
    private int mDefaultColor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_custom);

        //닉네임 값 가지고 오기
        Intent intent = getIntent();
        if(intent.getExtras() != null) {
            loginResponse = (LoginResponse) intent.getSerializableExtra("data");
        }
        // 아이디 값 가지고 오기
        if(intent.getExtras() != null) {
            loginResponse = (LoginResponse) intent.getSerializableExtra("data");
            Log.e("getUserid", "=" + loginResponse.getUsername());
        }

        // 선택완료 선택 시 activity 전환
        Button done = (Button) findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),FinishActivity.class).putExtra("data", loginResponse);
                startActivity(intent);
            }
        });

        // 로딩화면 삽입

//        뷰페이저 기능 삭제 고려
//        pager=findViewById(R.id.pager);
//        pagerAdapter=new ScreeSlidePagerAdapter(this);
//        pager.setAdapter(pagerAdapter);



        //무광 스위치
        matte = findViewById(R.id.matte);
        SwitchCompat change_sw = findViewById(R.id.change_sw);

        change_sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    matte.setBackgroundColor(Color.parseColor("#1A000000"));
                }else{matte.setBackgroundColor(Color.parseColor("#00000000"));}
            }
        });


        // 손 인식 Cubic crop

        matrix = new Matrix();
        savedMatrix = new Matrix();

        imageView = findViewById(R.id.preview_selected_color);
        imageView.setOnTouchListener(onTouch);
        imageView.setScaleType(ImageView.ScaleType.MATRIX); // 스케일 타입을 매트릭스로 해줘야 움직인다.



        //colorpicker code

        // register the GFG text with appropriate ID
        gfgTextView = findViewById(R.id.gfg_heading);

        // register two of the buttons with their
        // appropriate IDs
        mPickColorButton = findViewById(R.id.pick_color_button);
        mSetColorButton = findViewById(R.id.set_color_button);

        // and also register the view which shows the
        // preview of the color chosen by the user
        mColorPreview = findViewById(R.id.preview_selected_color);

        // set the default color to 0 as it is black
        mDefaultColor = 0;

        // button open the AmbilWanra color picker dialog.
        mPickColorButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // to make code look cleaner the color
                        // picker dialog functionality are
                        // handled in openColorPickerDialogue()
                        // function
                        openColorPickerDialogue();
                    }
                });

        // button to set the color GFG text
        mSetColorButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // as the mDefaultColor is the global
                        // variable its value will be changed as
                        // soon as ok button is clicked from the
                        // color picker dialog.
                        gfgTextView.setTextColor(mDefaultColor);
                    }
                });

    }
    // the dialog functionality is handled separately
    // using openColorPickerDialog this is triggered as
    // soon as the user clicks on the Pick Color button And
    // the AmbilWarnaDialog has 2 methods to be overridden
    // those are onCancel and onOk which handle the "Cancel"
    // and "OK" button of color picker dialog
    public void openColorPickerDialogue() {

        // the AmbilWarnaDialog callback needs 3 parameters
        // one is the context, second is default color,
        final AmbilWarnaDialog colorPickerDialogue = new AmbilWarnaDialog(this, mDefaultColor,
                new AmbilWarnaDialog.OnAmbilWarnaListener() {
                    @Override
                    public void onCancel(AmbilWarnaDialog dialog) {
                        // leave this function body as
                        // blank, as the dialog
                        // automatically closes when
                        // clicked on cancel button
                    }

                    @Override
                    public void onOk(AmbilWarnaDialog dialog, int color) {
                        // change the mDefaultColor to
                        // change the GFG text color as
                        // it is returned when the OK
                        // button is clicked from the
                        // color picker dialog
                        toRGBString(color);
                        mDefaultColor = color;

                        // now change the picked color
                        // preview box to mDefaultColor
                        Log.e("colorch", "====>"+toRGBString(color));
                        mColorPreview.setBackgroundColor(mDefaultColor);
                    }
                });
        colorPickerDialogue.show();
    }


        public String toRGBString(int color) {
            // format: #RRGGBB
            String red = Integer.toHexString(Color.red(color));
            String green = Integer.toHexString(Color.green(color));
            String blue = Integer.toHexString(Color.blue(color));
            if (red.length() == 1)
                red = "0" + red;
            if (green.length() == 1)
                green = "0" + green;
            if (blue.length() == 1)
                blue = "0" + blue;
            return "#" + red + green + blue;

        }//from w ww. j a  v  a  2 s . co  m


    //뒤로가기 눌렀을때 처리
//뷰페이저2 동작하는 것과 상관 없으므로 (onBackPressed 메소드)생략 가능
    @Override
    public void onBackPressed() {
        if(pager.getCurrentItem()==0){
            Toast.makeText(this, "뒤로가기가 눌렸습니다.", Toast.LENGTH_SHORT).show();
            super.onBackPressed();
        }else{
            pager.setCurrentItem(pager.getCurrentItem()-1);
        }
    }



    // Cubic handle
    private View.OnTouchListener onTouch = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (v.equals(imageView)) {
                int action = event.getAction();
                switch (action & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_DOWN:
                        touchMode = TOUCH_MODE.SINGLE;
                        donwSingleEvent(event);
                        break;
                    case MotionEvent.ACTION_POINTER_DOWN:
                        if (event.getPointerCount() == 2) { // 두손가락 터치를 했을 때
                            touchMode = TOUCH_MODE.MULTI;
                            downMultiEvent(event);
                        }
                        break;
                    case MotionEvent.ACTION_MOVE:
                        if (touchMode == TOUCH_MODE.SINGLE) {
                            moveSingleEvent(event);
                        } else if (touchMode == TOUCH_MODE.MULTI) {
                            moveMultiEvent(event);
                        }
                        break;

                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_POINTER_UP:
                        touchMode = TOUCH_MODE.NONE;
                        break;
                }
            }


            return true;
        }
    };
    private PointF getMidPoint(MotionEvent e) {

        float x = (e.getX(0) + e.getX(1)) / 2;
        float y = (e.getY(0) + e.getY(1)) / 2;

        return new PointF(x, y);
    }

    private float getDistance(MotionEvent e) {
        float x = e.getX(0) - e.getX(1);
        float y = e.getY(0) - e.getY(1);
        return (float) Math.sqrt(x * x + y * y);
    }
    private void donwSingleEvent(MotionEvent event) {
        savedMatrix.set(matrix);
        startPoint = new PointF(event.getX(), event.getY());
    }
    private void downMultiEvent(MotionEvent event) {
        oldDistance = getDistance(event);
        if (oldDistance > 5f) {
            savedMatrix.set(matrix);
            midPoint = getMidPoint(event);
            double radian = Math.atan2(event.getY() - midPoint.y, event.getX() - midPoint.x);
            oldDegree = (radian * 180) / Math.PI;
        }
    }
    private void moveSingleEvent(MotionEvent event) {
        matrix.set(savedMatrix);
        matrix.postTranslate(event.getX() - startPoint.x, event.getY() - startPoint.y);
        imageView.setImageMatrix(matrix);
    }
    private void moveMultiEvent(MotionEvent event) {
        float newDistance = getDistance(event);
        if (newDistance > 5f) {
            matrix.set(savedMatrix);
            float scale = newDistance / oldDistance;
            matrix.postScale(scale, scale, midPoint.x, midPoint.y);

            double nowRadian = Math.atan2(event.getY() - midPoint.y, event.getX() - midPoint.x);
            double nowDegress = (nowRadian * 180) / Math.PI;
            float degree = (float) (nowDegress - oldDegree);
            matrix.postRotate(degree, midPoint.x, midPoint.y);


            imageView.setImageMatrix(matrix);

        }
    }
}
