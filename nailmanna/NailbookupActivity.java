package com.example.nailmanna;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.example.nailmanna.databinding.ActivityMainBinding;
import com.example.nailmanna.databinding.ActivityNailbookupBinding;

import java.io.File;
import java.text.SimpleDateFormat;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NailbookupActivity extends AppCompatActivity {

    ActivityNailbookupBinding binding;
    String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNailbookupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        // 돌아가기 선택 시 activity 전환
        Button nailbookgo = (Button) findViewById(R.id.nailbookgo);
        nailbookgo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),NailnoticeActivity.class);
                startActivity(intent);
            }
        });
        clickListeners();
    }

    private void clickListeners() {
        binding.selectImage.setOnClickListener(v->{
            if(ContextCompat.checkSelfPermission(getApplicationContext(),
                    Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 10);
            }else{
                ActivityCompat.requestPermissions(NailbookupActivity.this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);

            }
        });

        binding.save.setOnClickListener(v->{
            //title check  및 토큰값 가지고 오기

            addCustomer(commonData.getInstance().GetLastAccess(), binding.myphototitle.getText().toString());
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 10 && resultCode == Activity.RESULT_OK){
            Uri uri = data.getData();
            Context context = NailbookupActivity.this;
            path = RealPathUtil.getRealPath(context, uri);
            Bitmap bitmap = BitmapFactory.decodeFile(path);

            try {
                Bitmap rotatedBitmap = getRotatedBitmap(bitmap, 90);
                binding.imageView.setImageBitmap(rotatedBitmap);

            } catch (Exception e) {
                e.printStackTrace();
            }




        }
    }
    //String token추가
    public void addCustomer(String token, String my_photo_title){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://43.200.13.213:8000/like/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        String m_token = "Bearer " + token;
        File file = new File(path);
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        // 오류 시 get Name 확인  >  getUser()
        MultipartBody.Part body = MultipartBody.Part.createFormData("my_photo", file.getName(),requestFile);
        // 오류 시 cus_name 의 속성 check
        RequestBody cus_reference = RequestBody.create(MediaType.parse("multipart/form-data"), my_photo_title);

        UserService userService = retrofit.create(UserService.class);

        Call<AddCustomerRes> call = userService.addCustomer(m_token, body, cus_reference);
        Log.e("m_token cheak" , "====="+m_token);
        call.enqueue(new Callback<AddCustomerRes>() {
            @Override
            public void onResponse(Call<AddCustomerRes> call, Response<AddCustomerRes> response) {
                Log.e("response cheak", "======"+response);
                if(response.isSuccessful()){
                    if(response.body().getMyphoto()!= null){
                        Toast.makeText(getApplicationContext(), "등록이 완료 되었습니다.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),NailnoticeActivity.class);
                        startActivity(intent);
                        Log.e("response check", "======="+response.body());
                    }else{
                        Toast.makeText(getApplicationContext(), "not Added", Toast.LENGTH_SHORT).show();
                        Log.e("log check", "="+response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<AddCustomerRes> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_SHORT).show();
                Log.e("response cheak", "======"+t);
                Toast.makeText(getApplicationContext(), "등록이 완료 되었습니다.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),NailnoticeActivity.class);
                startActivity(intent);
            }
        });
    }
    public Bitmap getRotatedBitmap(Bitmap bitmap, int degrees) throws Exception {
        if(bitmap == null) return null;
        if (degrees == 0) return bitmap;
        Matrix m = new Matrix();
        m.setRotate(degrees, (float) bitmap.getWidth() / 2, (float) bitmap.getHeight() / 2);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), m, true);
    }

}
