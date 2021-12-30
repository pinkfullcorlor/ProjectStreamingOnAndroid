package com.example.menu.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.example.menu.R;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import androidx.fragment.app.FragmentActivity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    Toolbar toolbar;
    ViewFlipper viewFlipper;
    RecyclerView recyclerViewtrangchu;
    NavigationView navigationView;
    ListView listView;
    DrawerLayout drawerLayout;
    ViewPager viewPager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Trangchinh();
//        ActionBar();
//        ActionViewFlipper();

        View view = inflater.inflate(R.layout.home, container, false);
        return view;


    }

    //dính 1 cái i su đó là trong phờ rắc mành nó méo nhận mấy cái từ thư viện AppCompatActivity
    //điển hình là cái getApplicationContext nó bị sai


//    private void ActionViewFlipper()
//    {
//        ArrayList<String> mangquangcao = new ArrayList<>();
//        mangquangcao.add("https://genk.mediacdn.vn/k:thumb_w/640/2015/2-1441093607514/bi-fan-che-trach-nhung-the-amazing-spiderman-van-lam-tiep-phan-3.jpg");
//        mangquangcao.add("https://static2.vieon.vn/vieplay-image/carousel_web_v4/2021/06/29/h7x55cvn_1920x1080-venom_1920_1080.jpg");
//        mangquangcao.add("https://vtv1.mediacdn.vn/thumb_w/640/2018/9/13/this-fall-on-the-cw-the-cw-youtube-1536821904355273157036.jpg");
//        for(int i = 0; i < mangquangcao.size(); i++)
//        {
//            ImageView imageView = new ImageView(getContext().getApplicationContext());
//            //Picasso.with(getApplicationContext()).load(mangquangcao.get(i)).into(imageView);
//            Picasso.get().load(mangquangcao.get(i)).into(imageView);
//            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
//            viewFlipper.addView(imageView);
//        }
//        viewFlipper.setFlipInterval(4000);
//        viewFlipper.setAutoStart(true);
//        Animation animation_slide_in = AnimationUtils.loadAnimation(getContext(),R.anim.slide_in_right);
//        Animation animation_slide_out = AnimationUtils.loadAnimation(getContext(),R.anim.slide_out_right);
//        viewFlipper.setInAnimation(animation_slide_in);
//        viewFlipper.setOutAnimation(animation_slide_out);
//    }

//    private void ActionBar()
//    {
//        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
//        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                drawerLayout.openDrawer(GravityCompat.START);
//            }
//        });
//    }

    private void Trangchinh()
    {
        toolbar = (Toolbar) getActivity().findViewById(R.id.tlbtrangchu);
        viewFlipper = (ViewFlipper) getActivity().findViewById(R.id.vftrangchu);
        recyclerViewtrangchu = (RecyclerView) getActivity().findViewById(R.id.rcvtrangchu);
        navigationView = (NavigationView) getActivity().findViewById(R.id.nvgttrangchu);
        listView = (ListView) getActivity().findViewById(R.id.ltvwtrangchu);
        drawerLayout = (DrawerLayout) getActivity().findViewById(R.id.drawerlayouttrangchu);
        viewPager = (ViewPager) getActivity().findViewById(R.id.view_paper);
    }


}
