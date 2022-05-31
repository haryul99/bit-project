package com.example.nailmanna;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class SelecthandActivity extends AppCompatActivity {

    // 손가락 or 전체 선택 화면
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_selecthand);

        //사진 불러오기
        if( commonData.getInstance().GetLastImageURL() != ""){
            ImageView showImage = (ImageView) findViewById(R.id.show_image);
            Uri uri = Uri.parse("file:///" + commonData.getInstance().GetLastImageURL() );
            showImage.setImageURI(uri);
        }

        // back 버튼 클릭 시 cam화면으로 전환
        Button back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( getApplicationContext(), CamActivity.class );
                startActivity(intent);
            }
        });

        // 모두동일 버튼 클릭 시 custom화면으로 전환
        Button allsame = (Button) findViewById(R.id.allsame);
        allsame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( getApplicationContext(), SamecustomActivity.class );
                startActivity(intent);
            }
        });

        //손가락에따른 버튼 클릭 시 액티비티 전환
        Button test = (Button) findViewById(R.id.test);
        test.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( getApplicationContext(), CustomActivity.class );
                startActivity(intent);
            }
        });

        //손가락에따른 버튼 클릭 시 액티비티 전환
        Button test1 = (Button) findViewById(R.id.test1);
        test1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( getApplicationContext(), CustomActivity.class );
                startActivity(intent);
            }
        });

        //손가락에따른 버튼 클릭 시 액티비티 전환
        Button test2 = (Button) findViewById(R.id.test2);
        test2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( getApplicationContext(), CustomActivity.class );
                startActivity(intent);
            }
        });

    }
}