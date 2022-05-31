package com.example.nailmanna;

import android.app.ActivityOptions;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PhotoupdateActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_photoupdate);

        TextView phototitle = (TextView) findViewById(R.id.phototitle);
        ImageView MyPhoto = (ImageView) findViewById(R.id.MyPhoto);
        LottieAnimationView animationView = findViewById(R.id.deletee);
        animationView.bringToFront();

        Glide.with(PhotoupdateActivity.this).load(commonData.getInstance().GetMyPhoto()).into(MyPhoto);
        phototitle.setText(commonData.getInstance().GetMyPhotoTitle());

        //네일북으로 버튼 선택 시 액티비티 전환
        Button gonailbook = (Button) findViewById(R.id.gonailbook);
        gonailbook.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),NailBookActivity.class);
                startActivity(intent);
            }
        });

        //수정 버튼 선택 시
        Button update = (Button) findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),TitleupdateActivity.class);
                startActivity(intent);
            }
        });

        //삭제 버튼 선택 시 대화상자 노출
        ImageView delete = (ImageView) findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(PhotoupdateActivity.this);
                dlg.setTitle("네일 만나"); //제목
                dlg.setMessage(" \""+commonData.getInstance().GetMyPhotoTitle()+"\" 이미지를 삭제하시겠습니까?"); // 메시지
                dlg.setIcon(R.drawable.manicuresplash); // 아이콘 설정
//                버튼 클릭시 동작
                dlg.setPositiveButton("확인",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int i) {
                        PhotoDel(commonData.getInstance().GetLastAccess(), commonData.getInstance().GetMyPhotoTitle());
                        MyUpload(commonData.getInstance().GetLastAccess());

                        animationView.setVisibility(View.VISIBLE);
                        animationView.playAnimation();
                        //토스트 메시지
                        Toast.makeText(getApplicationContext(), commonData.getInstance().GetMyPhotoTitle()+"(이)가 삭제되었습니다. ", Toast.LENGTH_SHORT).show();
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(PhotoupdateActivity.this, NailBookActivity.class); //화면 전환
//                                startActivityForResult(intent, 22);
                                startActivity(intent);
                                finish();
                            }
                        }, 1500);
                    }
                });
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), commonData.getInstance().GetMyPhotoTitle()+"(이)가 삭제 취소 되었습니다. ", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show();
            }
        });

    }
    // 내가 업로드한 파일
    public void MyUpload(String token){
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
                    int j = 0;
                    //정보 담을 배열 생성
                    HashMap<String, String> hashMap = new HashMap<>();
                    for(int i = 0; i < response.body().size(); i++ ){

                        hashMap.put(response.body().get(i).getMyphototitle(), response.body().get(i).getMyphoto());

                    }
                    commonData.getInstance().SetPhotoMade(hashMap);
                    int f = 0;
                    for(Map.Entry<String, String> i : commonData.getInstance().GetPhotoInfo().entrySet() ){
                        f += 1;
                        Log.i("say", "PhotoTitle = [ "+ i.getKey() +"] Photo = [" + i.getValue() +"] ");
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

    // 내가 올린 사진 삭제
    public void PhotoDel(String token, String my_photo_title){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://43.200.13.213:8000/like/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        String m_token = "Bearer "+token;
        RequestBody m_my_photo_title = RequestBody.create(MediaType.parse("multipart/form-data"), my_photo_title);

        UserService userService = retrofit.create(UserService.class);
        Call<AddCustomerRes> PhotoDel = userService.PhotoDel(m_token, m_my_photo_title);
        Log.e("m_token cheak photoDel" , "====="+m_token);
        PhotoDel.enqueue(new Callback<AddCustomerRes>() {
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
}
