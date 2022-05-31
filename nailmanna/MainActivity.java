package com.example.nailmanna;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kotlin.jvm.internal.CharSpreadBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    Button btn_login, btn_register2;
    EditText et_id, et_pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);

        btn_login = findViewById(R.id.btn_login);
        btn_register2 = findViewById(R.id.btn_register2);
        et_id = findViewById(R.id.et_id);
        et_pass = findViewById(R.id.et_pass);
        
        et_id.setText("haryulpark");
        et_pass.setText("@a37983705");



        // 회원가입 버튼 클릭
        btn_register2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
                overridePendingTransition(0, 0);
            }
        });

        // 로그인 버튼 클릭
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(et_id.getText().toString()) || TextUtils.isEmpty(et_pass.getText().toString())){

                    String message = "입력정보가 정확하지 않습니다";
                    Toast.makeText(MainActivity.this, message,Toast.LENGTH_SHORT).show();

                }else{
                    LoginRequest loginRequest = new LoginRequest();
                    //마지막 ID가지고 오기
                    commonData.getInstance().SetLastLoginID(et_id.getText().toString());

                    loginRequest.setUsername(et_id.getText().toString());
                    loginRequest.setPassword(et_pass.getText().toString());

                    loginUser(loginRequest);
                }


            }
        });

    }

    public void loginUser(LoginRequest loginRequest){
        Call<LoginResponse> loginResponseCall = ApiClient.getService().loginUser(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                if(response.isSuccessful()){
                    LoginResponse loginResponse = response.body();
                    Log.i("logcheck","response = "+response.body().getUsername());
                    Log.i("logcheck", "ID = "+loginResponse.getUsername());
                    Log.i("token insert before", "token ===="+loginResponse.getAccess());
                    //토큰 넣기

                    commonData.getInstance().setLastAccess(loginResponse.getAccess());
                    commonData.getInstance().SetLastLoginID( response.body().getUsername() );
                    commonData.getInstance().SetLastLoginNickname( loginResponse.getNickname() );

                    startActivity(new Intent(MainActivity.this, HomeActivity.class).putExtra("data", loginResponse));

                    finish();
                }else {
                    String message = "잘못된 아이디 혹은 비밀번호를 입력하셨습니다.";
                    Toast.makeText(MainActivity.this, message,Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

                String message = t.getLocalizedMessage();
                Toast.makeText(MainActivity.this, message,Toast.LENGTH_SHORT).show();
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
                        Log.i("say first","============================================================================");
                        Log.i("say"," [ "+ i + " ] response myphototitle = "+ response.body().get(i).getMyphototitle()  );
                        Log.i("say"," [ "+ i + " ] response myphoto = "+ response.body().get(i).getMyphoto() );

                        hashMap.put(response.body().get(i).getMyphototitle(), "http://43.200.13.213:8000"+response.body().get(i).getMyphoto());
                    }
                    commonData.getInstance().SetPhotoInfo(hashMap);

                    //
                    for(Map.Entry<String, String> i : commonData.getInstance().GetPhotoInfo().entrySet() ){
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


//    // 내가 좋아요 한 파일
//    public void LikePhoto(String token){
//        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://15.164.103.153:8000/like/")
//                .addConverterFactory(GsonConverterFactory.create()).build();
//        UserService userService = retrofit.create(UserService.class);
//        String l_token = "Bearer "+token;
//        Call<List<AddCustomerRes>> Likephoto = userService.LikePhoto(l_token);
//        Log.e("m_token cheak" , "====="+l_token);
//        Likephoto.enqueue(new Callback< List<AddCustomerRes> >() {
//            @Override
//            public void onResponse(Call<List<AddCustomerRes>> call, Response<List<AddCustomerRes>> response) {
//                if( response.isSuccessful() ){
//                    int j = 0;
//                    //정보 담을 배열 생성
//                    HashMap<String, String> hashMap = new HashMap<>();
//                    for(int i = 0; i < response.body().size(); i++ ){
//                        Log.i("say i like","============================================================================");
//                        Log.i("say"," [ "+ i + " ] response myphototitle = "+ response.body().get(i).getMyphototitle()  );
//                        Log.i("say"," [ "+ i + " ] response myphoto = "+ response.body().get(i).getMyphoto() );
//
//                        hashMap.put(response.body().get(i).getMyphototitle(), "http://15.164.103.153:8000"+response.body().get(i).getMyphoto());
//
//                        commonData.getInstance().SetMyPhotoTitle(response.body().get(2).getMyphototitle());
//                        commonData.getInstance().SetMyPhoto("http://15.164.103.153:8000"+response.body().get(2).getMyphoto());
//                        j = j + 1;
//                        System.out.println(j+ "입니다.");
//                    }
//                    commonData.getInstance().SetPhotoInfo(hashMap);
//
//                    //
//                    for(Map.Entry<String, String> i : commonData.getInstance().GetPhotoInfo().entrySet() ){
//                        Log.i("say", "PhotoTitle = [ "+ i.getKey() +"] Photo = [" + i.getValue() +"] ");
//                    }
//
//                }else {
//                    Log.i("say","response nononono "+response.code());
//                }
//            }
//            @Override
//            public void onFailure(Call<List<AddCustomerRes>> call, Throwable t) {
//                Log.i("say","failure" + t.getMessage());
//            }
//        });
//
//    }

}