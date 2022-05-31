package com.example.nailmanna;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
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

public class TitleupdateActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_titleupdate);

        LottieAnimationView animationView = findViewById(R.id.revise);
        animationView.bringToFront();

        //타이틀 기존 phototitle 세팅
        EditText phototitle = (EditText) findViewById(R.id.phototitle);
        phototitle.setHint(commonData.getInstance().GetMyPhotoTitle());

        //ImageView 세팅
        ImageView MyPhoto = (ImageView) findViewById(R.id.MyPhoto);
        Glide.with(TitleupdateActivity.this).load(commonData.getInstance().GetMyPhoto()).into(MyPhoto);

        //수정취소 버튼 선택 시 액티비티 전환
        Button cancel = (Button) findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),PhotoupdateActivity.class);
                startActivity(intent);
            }
        });

        //수정완료 버튼 선택 시 put 실행 및 Myupload 재 실행  + lottie 실행 + 비어있을경우 안넘어감+액티비티 전환
        Button done = (Button) findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                commonData.getInstance().SetRePhotoTitle(commonData.getInstance().GetMyPhotoTitle());
                Log.e("RePhotoTitle", "=====>"+commonData.getInstance().GetRePhotoTitle());
                PhotoUpdate(commonData.getInstance().GetLastAccess(), commonData.getInstance().GetRePhotoTitle(), commonData.getInstance().GetRePhotoTitle());
//                MyUpload(commonData.getInstance().GetLastAccess());
//
//                animationView.setVisibility(View.VISIBLE);
//                animationView.playAnimation();

//                commonData.getInstance().SetMyPhotoTitle(phototitle.getText().toString());
            }
        });

    }

    // 내가 올린 사진 수정
    public void PhotoUpdate(String token, String my_photo_title, String new_title){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://43.200.13.213:8000/like/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        String m_token = "Bearer "+token;
        RequestBody m_my_photo_tit = RequestBody.create(MediaType.parse("multipart/form-data"), new_title);

        UserService userService = retrofit.create(UserService.class);
//        Log.e("typeche", "===>"+userService.getClass().getName());
        Call<AddCustomerRes> PhotoUpdate = userService.PhotoUpdate(m_token, my_photo_title, new_title);
        Log.e("m_token cheak Update" , "====="+m_token);
        PhotoUpdate.enqueue(new Callback<AddCustomerRes>() {
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

                    //
                    for(Map.Entry<String, String> i : commonData.getInstance().GetPhotoMade().entrySet() ){
                        Log.i("sayhomemyupload", "PhotoTitle = [ "+ i.getKey() +"] Photo = [" + i.getValue() +"] ");
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
