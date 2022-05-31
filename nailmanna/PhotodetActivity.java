package com.example.nailmanna;

import android.Manifest;
import android.animation.Animator;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PhotodetActivity extends AppCompatActivity {

    Button saveimage;
    ImageView MyPhoto;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_photodet);

        TextView phototitle = (TextView) findViewById(R.id.phototitle);
        MyPhoto = (ImageView) findViewById(R.id.MyPhoto);
        Button goIlike = (Button) findViewById(R.id.goIlike);
        saveimage = (Button) findViewById(R.id.saveimage);
        Button shareButton = (Button) findViewById(R.id.shareButton);
        LottieAnimationView animationView = findViewById(R.id.likeani);
        animationView.bringToFront();

        LottieAnimationView animationView2 = findViewById(R.id.save);



        ActivityCompat.requestPermissions(PhotodetActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        ActivityCompat.requestPermissions(PhotodetActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);

        //이미지와 타이틀 세팅
        Glide.with(PhotodetActivity.this).load(commonData.getInstance().GetMyPhoto()).into(MyPhoto);
        phototitle.setText(commonData.getInstance().GetMyPhotoTitle());

        //갤러리 저장
        saveimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveToGallery();

                Toast.makeText(getApplicationContext(), commonData.getInstance().GetMyPhotoTitle()+"(이)가 \"Nailmanna\" 파일에 저장 되었습니다. ", Toast.LENGTH_SHORT).show();

                animationView2.setVisibility(View.VISIBLE);
                animationView2.playAnimation();
            }
        });

        animationView.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                animationView.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

        animationView2.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                animationView2.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

        // 공유하기
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.addCategory(Intent.CATEGORY_DEFAULT);
                intent.setType("image/*");


                startActivity(Intent.createChooser(intent,null));
            }
        });

        //오늘네일 버튼 선택 시 액티비티 전환
        Button gonailnotice = (Button) findViewById(R.id.gonailnotice);
        gonailnotice.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),NailnoticeActivity.class);
                startActivity(intent);
            }
        });

        //좋아요 목록으로 가기 버튼 선택 시 액티비티 전환
        goIlike.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                LikePhoto(commonData.getInstance().GetLastAccess());
                Intent intent = new Intent(getApplicationContext(),IlikeActivity.class);
                startActivity(intent);
            }
        });

        //좋아요 이미지뷰 선택 시 대화상자 노출
        ImageView like = (ImageView) findViewById(R.id.like);
        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //좋아요 버튼 클릭이벤트 설정
                AlertDialog.Builder dlg = new AlertDialog.Builder(PhotodetActivity.this);
                dlg.setTitle("네일 만나"); //제목
                dlg.setMessage(" \""+commonData.getInstance().GetMyPhotoTitle()+"\" 이미지를 좋아요 하시겠습니까? \n ※ 기존 좋아요 한 목록이라면 좋아요가 삭제됩니다."); // 메시지
                dlg.setIcon(R.drawable.manicuresplash); // 아이콘 설정
                //버튼 클릭 시 동작
                dlg.setPositiveButton("확인",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int i) {
                        PhotoLike(commonData.getInstance().GetLastAccess(), commonData.getInstance().GetMyPhotoTitle());
                        animationView.setVisibility(View.VISIBLE);
                        animationView.playAnimation();
                        //토스트 메시지
                        Toast.makeText(getApplicationContext(), commonData.getInstance().GetMyPhotoTitle()+"(이)가 좋아요 목록에 추가되었습니다. ", Toast.LENGTH_SHORT).show();
                        goIlike.setVisibility(View.VISIBLE);
                        LikePhoto(commonData.getInstance().GetLastAccess());
                    }
                });
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), commonData.getInstance().GetMyPhotoTitle()+"(이)가 좋아요 목록 등록 취소 되었습니다. ", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show();
            }
        });
        LikePhoto(commonData.getInstance().GetLastAccess());
    }

    //이미지를 갤러리에 저장하는 함수 생성
    public void saveToGallery(){
        BitmapDrawable bitmapDrawable = (BitmapDrawable)MyPhoto.getDrawable();
        Bitmap bitmap = bitmapDrawable.getBitmap();

        FileOutputStream outputStream = null;
        File file = Environment.getExternalStorageDirectory();
        File dir = new File(file.getAbsolutePath()+ "/Nailmanna");
        dir.mkdirs();

        String filename = String.format("%d.jpg", System.currentTimeMillis());
        File outFiles = new File(dir, filename);
        try{
            outputStream = new FileOutputStream(outFiles);
        }catch (Exception e){
            e.printStackTrace();
        }
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
        try{
            outputStream.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            outputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // 좋아요 적용
    public void PhotoLike(String token, String my_photo_title){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://43.200.13.213:8000/like/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        UserService userService = retrofit.create(UserService.class);

        String m_token = "Bearer "+token;
//        RequestBody m_my_photo_title = RequestBody.create(MediaType.parse("multipart/form-data"), my_photo_title);
        Call<AddCustomerRes> PhotoLike = userService.PhotoLike(m_token, my_photo_title);
        Log.e("m_token cheak" , "====="+m_token);
        PhotoLike.enqueue(new Callback<AddCustomerRes>() {
            @Override
            public void onResponse(Call<AddCustomerRes> call, Response<AddCustomerRes> response) {
                if( response.isSuccessful() ){
                    Log.i("say photo name cheak", ">>>"+ my_photo_title);
                }else {
                    Log.i("say","response nononono "+response.code());
                }
            }

            @Override
            public void onFailure(Call<AddCustomerRes> call, Throwable t) {
                Log.i("say","failure" + t.getMessage());
            }
        });

    }

    // 내가 좋아요한 파일
    public void LikePhoto(String token){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://43.200.13.213:8000/like/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        UserService userService = retrofit.create(UserService.class);
        String m_token = "Bearer "+token;
        Call<List<AddCustomerRes>> TestHeader = userService.MyUpload(m_token);
        Log.e("m_token cheak" , "====="+m_token);
        TestHeader.enqueue(new Callback< List<AddCustomerRes> >() {
            @Override
            public void onResponse(Call<List<AddCustomerRes>> call, Response<List<AddCustomerRes>> response) {
                if( response.isSuccessful() ){
                    //정보 담을 배열 생성
                    HashMap<String, String> hashMap = new HashMap<>();
                    for(int i = 0; i < response.body().size(); i++ ){

                        hashMap.put(response.body().get(i).getMyphototitle(), response.body().get(i).getMyphoto());
                    }
                    commonData.getInstance().SetPhotoLike(hashMap);

                    // 정보 세팅
                    for(Map.Entry<String, String> i : commonData.getInstance().GetPhotoInfo().entrySet() ){
                        Log.i("say", "MylikeTitle = [ "+ i.getKey() +"] Photo = [" + i.getValue() +"] ");
                    }

                }else {
                    Log.i("say","response nononono "+response.code());
                }
            }

            @Override
            public void onFailure(Call<List<AddCustomerRes>> call, Throwable t) {
                Log.i("say","failure" + t.getMessage());
            }
        });

    }
}
