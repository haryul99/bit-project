package com.example.nailmanna;

import android.Manifest;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {
    LoginResponse loginResponse;
    TextView username;
    ImageView mypageicon;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_home);

        mypageicon = (ImageView) findViewById(R.id.mypageicon);

        username = findViewById(R.id.username);
        username.setText("안녕하세요 "+commonData.getInstance().GetLastLoginNickname()+"님");

        //마이페이지 아이콘 선택 시 액티비티 전환
        ImageView mypageicon = (ImageView) findViewById(R.id.mypageicon);
        mypageicon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MypageActivity.class);

                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View,String>(mypageicon, "imgTransition");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(HomeActivity.this,pairs);
                startActivity(intent, options.toBundle());
            }
        });


        //카메라 이미지뷰 클릭 시 액티비티 전환
        ImageView camera = (ImageView) findViewById(R.id.camera);
            camera.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),DirectionActivity.class);
                startActivity(intent);
            }
        });

        //네일북 이미지뷰 클릭 시 액티비티 전환
        ImageView nailbook = (ImageView) findViewById(R.id.nailbook);
        nailbook.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),NailBookActivity.class);
                startActivity(intent);
            }
        });

        //notice 이미지뷰 클릭 시 액티비티 전환
        ImageView noticeboard = (ImageView) findViewById(R.id.noticeboard);
        noticeboard.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),NailnoticeActivity.class);
                startActivity(intent);
            }
        });

        Context context = getApplicationContext();
        CharSequence text = "원하는 버튼을 선택해보세요!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        PhotoAll(commonData.getInstance().GetLastAccess());
        MyUpload(commonData.getInstance().GetLastAccess());

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

    // 전체 유저가 업로드한 파일
    public void PhotoAll(String token){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://43.200.13.213:8000/like/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        UserService userService = retrofit.create(UserService.class);
        String m_token = "Bearer "+token;
        Call<List<AddCustomerRes>> TestHeader = userService.PhotoAll(m_token);
        Log.e("m_token cheak" , "====="+m_token);
        TestHeader.enqueue(new Callback< List<AddCustomerRes> >() {
            @Override
            public void onResponse(Call<List<AddCustomerRes>> call, Response<List<AddCustomerRes>> response) {
                if( response.isSuccessful() ){
                    int j = 0;
                    //정보 담을 배열 생성
                    HashMap<String, String> hashMap = new LinkedHashMap<>();
                    ArrayList<Integer> arrayList = new ArrayList<>();

                    for(int i = 0; i < response.body().size(); i++ ){
                        Log.i("sayHomecheck","============================================================================");
                        Log.i("sayphotoall"," [ "+ i + " ] response myphototitle = "+ response.body().get(i).getMyphototitle()  );
                        Log.i("say"," [ "+ i + " ] response myphoto = "+ response.body().get(i).getMyphoto() );
                        Log.i("saynoti", "[ "+ i + " ] response like"+response.body().get(i).getLike_count());

                        hashMap.put(response.body().get(i).getMyphototitle(), response.body().get(i).getMyphoto());
                        arrayList.add(new Integer(response.body().get(i).getLike_count()));

                    }
                    commonData.getInstance().SetPhotoInfo(hashMap);
                    commonData.getInstance().SetLikeCount(arrayList);

                    //
                    for(Map.Entry<String, String> i : commonData.getInstance().GetPhotoInfo().entrySet() ){
                        Log.i("sayphoto", "PhotoTitle = [ "+ i.getKey() +"] Photo = [" + i.getValue() +"] ");
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

    //백버튼
    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }
}

