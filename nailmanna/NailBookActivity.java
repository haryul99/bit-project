package com.example.nailmanna;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ComponentActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
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

public class NailBookActivity extends AppCompatActivity {
    //새로고침 생성
    private SwipeRefreshLayout swipeRefreshLayout;

    //그리드 뷰 생성
    private String TAG = NailBookActivity.class.getSimpleName();
    private GridView gridView = null;
    private GridViewAdapter adapter = null;



    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setRequestedOrientation( ActivityInfo.SCREEN_ORIENTATION_PORTRAIT );
        setContentView( R.layout.activity_nailbook );

        // 뒤로 버튼 클릭 시 home화면으로 전환
        Button back = (Button) findViewById( R.id.back );
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( getApplicationContext(), HomeActivity.class );
                startActivity( intent );
            }
        });

        //마이페이지 아이콘 선택 시 액티비티 전환
        ImageView mypageicon = (ImageView) findViewById(R.id.mypageicon);
        mypageicon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) { //.putExtra 추가..1


                Intent intent = new Intent(getApplicationContext(),MypageActivity.class);

                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View,String>(mypageicon, "imgTransition");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(NailBookActivity.this,pairs);
                startActivity(intent, options.toBundle());


            }
        });

        //좋아요 텍스트뷰 선택 시 내가 좋아요한 화면으로 전환
        TextView liked = (TextView) findViewById(R.id.liked);
        liked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent( NailBookActivity.this, IlikeActivity.class ) );
                overridePendingTransition(0, 0);
            }
        });



        //리프레쉬
        swipeRefreshLayout=(SwipeRefreshLayout)findViewById(R.id.refresh_layout);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                MyUpload(commonData.getInstance().GetLastAccess());
                //그리드 뷰
                gridView = (GridView) findViewById(R.id.gridview);
                adapter = new GridViewAdapter();
                //정보 담기
                Integer j = 0;
                for (Map.Entry<String, String> i : commonData.getInstance().GetPhotoMade().entrySet()) {
                    j += 1;
                    adapter.addItem(new NailItem(j+"", i.getKey(), i.getValue()));
                }
                //리스트뷰에 Adapter설정
                gridView.setAdapter(adapter);

                swipeRefreshLayout.setRefreshing(false);
            }
        });

        //그리드 뷰
        gridView = (GridView) findViewById(R.id.gridview);
        adapter = new GridViewAdapter();
        //정보 담기
        Integer j = 0;
        for(Map.Entry<String, String> i : commonData.getInstance().GetPhotoMade().entrySet() ) {
            j += 1;
            //임시 수정 5.27
            adapter.addItem(new NailItem(j+"", i.getKey(), i.getValue()));
            Log.i("say", "IlikeAct = [ "+ i.getKey() +"] Photo = [" + i.getValue() +"] ");
        }
        //리스트뷰에 adapter설정
        gridView.setAdapter(adapter);

        LikePhoto(commonData.getInstance().GetLastAccess());


   }

   //  그리드뷰 어댑터
    class GridViewAdapter extends BaseAdapter{
        ArrayList<NailItem> items = new ArrayList<NailItem>();

        @Override
       public int getCount(){ return items.size(); }
       public void addItem(NailItem item){
            items.add(item);
        }
        @Override
       public Object getItem(int position){
            return items.get(position);
        }
        @Override
       public long getItemId(int position) {
            return position;
        }
        @Override
       public View getView(int position, View convertView, ViewGroup viewGroup){
            final Context context = viewGroup.getContext();
            final NailItem nailItem = items.get(position);

            // gridView 셋팅
            if(convertView == null){
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.gridview_list_item, viewGroup, false);

                TextView tv_num = (TextView) convertView.findViewById(R.id.tv_num);
                TextView tv_id = (TextView) convertView.findViewById(R.id.tv_id);
                ImageView iv_photo = (ImageView) convertView.findViewById(R.id.iv_photo);

                //여기에 instance넣으면 될듯
                tv_num.setText(nailItem.getNum());
                tv_id.setText(nailItem.getId());
                Glide.with(NailBookActivity.this).load(nailItem.getResId()).into(iv_photo);

                Log.d(TAG, "getView() -["+position+"]"+nailItem.getId() );

            } else {
                View view = new View(context);
                view = (View) convertView;
            }

            //각 아이템 선택 event
            convertView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){

                    //불러올 값 셋팅
                    commonData.getInstance().SetMyPhoto(nailItem.getResId());
                    commonData.getInstance().SetMyPhotoTitle(nailItem.getId());
                    // 값 확인__확인완료
//                    Log.i("select photo check","===>"+commonData.getInstance().GetMyPhoto());
//                    Log.i("select photo check","===>"+commonData.getInstance().GetMyPhotoTitle());

                    Intent intent = new Intent(getApplicationContext(),PhotoupdateActivity.class);
                    startActivityForResult(intent, 22);

                }
            });

            return convertView; //뷰 객체 반환
        }
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

    // 내가 좋아요 한 파일
    public void LikePhoto(String token){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://43.200.13.213:8000/like/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        UserService userService = retrofit.create(UserService.class);
        String l_token = "Bearer "+token;
        Call<List<AddCustomerRes>> Likephoto = userService.LikePhoto(l_token);
        Log.e("m_token cheak" , "====="+l_token);
        Likephoto.enqueue(new Callback< List<AddCustomerRes> >() {
            @Override
            public void onResponse(Call<List<AddCustomerRes>> call, Response<List<AddCustomerRes>> response) {
                if( response.isSuccessful() ){
                    int j = 0;
                    //정보 담을 배열 생성
                    HashMap<String, String> hashMap = new HashMap<>();
                    for(int i = 0; i < response.body().size(); i++ ){
                        Log.i("say i like","============================================================================");
                        Log.i("say"," [ "+ i + " ] response myphototitle = "+ response.body().get(i).getMyphototitle()  );
                        Log.i("say"," [ "+ i + " ] response myphoto = "+ response.body().get(i).getMyphoto() );

                        hashMap.put(response.body().get(i).getMyphototitle(), response.body().get(i).getMyphoto());

                    }
                    commonData.getInstance().SetPhotoLike(hashMap);

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




    // 뒤로가기 버튼 setting
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        Intent intent = new Intent(NailBookActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

}