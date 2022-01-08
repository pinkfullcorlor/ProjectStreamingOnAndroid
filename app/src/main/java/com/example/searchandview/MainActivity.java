package com.example.searchandview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class MainActivity extends AppCompatActivity {
//    ListView listView;
//    ArrayList<String> stringArrayList = new ArrayList<>();
//    ArrayAdapter<String> adapter;
//    ListView listView;
//    String[] name = {"aaa", "asd", "asda"};
//    ArrayAdapter<String> arrayAdapter;
    private RecyclerView rscvideo;
    private videoadapter videoadapter;
    private androidx.appcompat.widget.SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        listView = findViewById(R.id.lv_listview);
//        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,name);
//        listView.setAdapter(arrayAdapter);
//        listView = findViewById(R.id.lv_listview);
//        for(int i=0; i<100; i++){
//            stringArrayList.add("Item" +i);
//        }
//
//        adapter = new ArrayAdapter<>(MainActivity.this,
//                android.R.layout.simple_list_item_1,stringArrayList);
//
//        listView.setAdapter(adapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getApplicationContext(),
//                        adapter.getItem(Posion), Toast.LENGTH_LONG).show();
//            }
//        });
        rscvideo = findViewById(R.id.rsv_video);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rscvideo.setLayoutManager(linearLayoutManager);

        videoadapter = new videoadapter(getlistvideo());
        rscvideo.setAdapter(videoadapter);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rscvideo.addItemDecoration(itemDecoration);
        
    }

    private List<videos> getlistvideo() {
        List<videos> list = new ArrayList<>();
        list.add(new videos(R.drawable.domixi, "Do mixi can vu tru"));
        list.add(new videos(R.drawable.pewdiepie, "noku no pico"));
        list.add(new videos(R.drawable.viruss, "huong dan dau tu coin"));
        list.add(new videos(R.drawable.pewpew, "tu van tinh cam: Người iu dạo này hư quá em không biết phải nàm sao ạ"));
        list.add(new videos(R.drawable.pewpew, "tu van tinh cam: Anh ơi người iu em lúc nào cũng dỗi thì giờ phải làm sao ạ?"));
        list.add(new videos(R.drawable.pewpew, "tu van tinh cam: Thất tình"));
        list.add(new videos(R.drawable.pewpew, "tu van tinh cam: Cắm sừng"));
        list.add(new videos(R.drawable.pewpew, "tu van tinh cam: Bạn thân là con trai"));
        list.add(new videos(R.drawable.pewpew, "tu van tinh cam: Bền lâu"));
        list.add(new videos(R.drawable.pewpew, "tu van tinh cam: Yêu xa"));
        return list;
    }

    // truyen du lieu va xu ly vao thanh tim kiem video
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.nav_menu,menu);
        MenuItem menuItem = menu.findItem(R.id.nav_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Tìm kiếm videos");
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.nav_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                videoadapter.getFilter().filter(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String so) {
                videoadapter.getFilter().filter(so);
                return false;
            }
        });
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//
//                return false;
//            }
//        });
        return true;
    }

// dung de back tro lai thanh search ban dau thay vi thoat luon
    @Override
    public void onBackPressed() {
        if(!searchView.isIconified())
        {
            searchView.setIconified(true);
            return;
        }
        super.onBackPressed();
    }
}