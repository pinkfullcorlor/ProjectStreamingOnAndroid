package com.example.menu.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewFlipper;



import com.example.menu.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewFlipper viewFlipper;
    RecyclerView recyclerViewtrangchu;
    NavigationView navigationView;
    ListView listView;
    DrawerLayout drawerLayout;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Trangchinh();
        ActionBar();
        ActionViewFlipper();

        BottomNavigationView bottomNavigationView = findViewById(R.id.botton_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.action_home:
                        Toast.makeText(MainActivity.this,"Home", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_favorite:
                        Toast.makeText(MainActivity.this,"Stream", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_camera:
                        Toast.makeText(MainActivity.this,"Live", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_info:
                        Toast.makeText(MainActivity.this,"Info", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_setting:
                        Toast.makeText(MainActivity.this,"Setting", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }

        });
        {}
    }



    private void ActionViewFlipper()
    {
        ArrayList<String> mangquangcao = new ArrayList<>();
        mangquangcao.add("https://genk.mediacdn.vn/k:thumb_w/640/2015/2-1441093607514/bi-fan-che-trach-nhung-the-amazing-spiderman-van-lam-tiep-phan-3.jpg");
        mangquangcao.add("https://static2.vieon.vn/vieplay-image/carousel_web_v4/2021/06/29/h7x55cvn_1920x1080-venom_1920_1080.jpg");
        mangquangcao.add("https://vtv1.mediacdn.vn/thumb_w/640/2018/9/13/this-fall-on-the-cw-the-cw-youtube-1536821904355273157036.jpg");
        for(int i = 0; i < mangquangcao.size(); i++)
        {
            ImageView imageView = new ImageView(getApplicationContext());
            //Picasso.with(getApplicationContext()).load(mangquangcao.get(i)).into(imageView);
            Picasso.get().load(mangquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);
        Animation animation_slide_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);
        Animation animation_slide_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out_right);
        viewFlipper.setInAnimation(animation_slide_in);
        viewFlipper.setOutAnimation(animation_slide_out);
    }

    private void ActionBar()
    {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }



    private void Trangchinh()
    {
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.botton_nav);
        toolbar = (Toolbar) findViewById(R.id.tlbtrangchu);
        viewFlipper = (ViewFlipper) findViewById(R.id.vftrangchu);
        recyclerViewtrangchu = (RecyclerView) findViewById(R.id.rcvtrangchu);
        navigationView = (NavigationView) findViewById(R.id.nvgttrangchu);
        listView = (ListView) findViewById(R.id.ltvwtrangchu);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayouttrangchu);
    }
}