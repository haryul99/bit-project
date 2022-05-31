package com.example.nailmanna;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class DirectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_direction);

        //오른손 카드뷰 클릭 시 액티비티 전환
        CardView right = (CardView) findViewById(R.id.right);
        right.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),CamActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        //홈으로 버튼 클릭 시 액티비티 전환
        Button gohome = (Button) findViewById(R.id.gohome);
        gohome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });
    }

}
