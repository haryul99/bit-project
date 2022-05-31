package com.example.nailmanna;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MypageActivity extends Activity {
    TextView nicknamere;
    TextView idinfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_mypage);

        //닉네임 값 가지고 오기
        nicknamere = findViewById(R.id.nicknamere);
        nicknamere.setText(commonData.getInstance().GetLastLoginNickname()+"님");

        // 아이디 값 가지고 오기
        idinfo = findViewById(R.id.idinfo);
        idinfo.setText(commonData.getInstance().GetLastLoginID()+" ");

        // 홈으로 버튼 선택 시 activity 전환
        Button back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(intent);
            }
        });

        // 커스텀네일 보러가기 버튼 선택 시 activity 전환
        TextView customednail = (TextView) findViewById(R.id.customednail);
        customednail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),NailnoticeActivity.class);
                startActivity(intent);
            }
        });

        // 내가찜한목록 보러가기 버튼 선택 시 activity 전환
        TextView likenail = (TextView) findViewById(R.id.likenail);
        likenail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),IlikeActivity.class);
                startActivity(intent);
            }
        });

        // 로그아웃 버튼 선택 시 activity 전환
        Button logoutbutton = (Button) findViewById(R.id.logoutbutton);
        logoutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        LikePhoto(commonData.getInstance().GetLastAccess());

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
