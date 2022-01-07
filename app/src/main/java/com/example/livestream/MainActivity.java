package com.example.livestream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<SectionDataModel> allSampleData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        allSampleData = new ArrayList<SectionDataModel>();

        createDummyData();
        RecyclerView myRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        myRecyclerView.setHasFixedSize(true);
        MyDataAdapter adapter = new MyDataAdapter(this, allSampleData);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        myRecyclerView.setAdapter(adapter);
    }
    //Tạo dữ liệu
    public void createDummyData() {
        for (int i = 1; i <= 5; i++) {

            SectionDataModel dm = new SectionDataModel();
            if(i==1){
                dm.setHeaderTitle("Nổi bật");
            }
            if(i==2){
                dm.setHeaderTitle("Kem trộn");
            }
            if(i==3){
                dm.setHeaderTitle("Đồ đôn chề");
            }
            if(i==4){
                dm.setHeaderTitle("Stream game");
            }
            if(i==5){
                dm.setHeaderTitle("Giải trí");
            }



            ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();
            for (int j = 0; j <= 5; j++) {
                singleItem.add(new SingleItemModel("Item " + j, "URL " + j));
            }

            dm.setAllItemsInSection(singleItem);

            allSampleData.add(dm);

        }
        
//        String[] items = {"item1", "item2", "item3"};
//        VideoView videoView = findViewById(R.id.video_view);
//        String videopath = "android.resource://" + getPackageName() + "/" + R.raw.video;
//        Uri uri = Uri.parse(videopath);
//        videoView.setVideoURI(uri);
//
//        MediaController mediaController = new MediaController(this);
//        videoView.setMediaController(mediaController);
//        mediaController.setAnchorView(videoView);
    }
}