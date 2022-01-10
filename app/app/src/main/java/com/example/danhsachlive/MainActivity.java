package com.example.danhsachlive;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcvLive;
    private LiveAdapter mLiveAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvLive = findViewById(R.id.rcv_live);
        mLiveAdapter = new LiveAdapter(this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1);
        rcvLive.setLayoutManager(gridLayoutManager);

        mLiveAdapter.setData(getlistLive());
        rcvLive.setAdapter(mLiveAdapter);
    }

    private List<Live> getlistLive(){
        List<Live> list = new ArrayList<>();
        list.add(new Live(R.drawable.canhdonglua));



        list.add(new Live(R.drawable.images1));



        list.add(new Live(R.drawable.images2));

        return list;
    }
}