package com.example.rkilaparthi.listviewexample;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    ListView listview;
    Context context = MainActivity.this;
    ArrayList myList = new ArrayList();

    String[] title = new String[]{
            "Title 1", "Title 2", "Title 3", "Title 4",
            "Title 5", "Title 6", "Title 7", "Title 8"
    };
    String[] desc = new String[]{
            "Desc 1", "Desc 2", "Desc 3", "Desc 4",
            "Desc 5", "Desc 6", "Desc 7", "Desc 8"
    };
    int[] img = new int[]{
            R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4,
            R.drawable.img5, R.drawable.img6, R.drawable.img7, R.drawable.img8
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView) findViewById(R.id.list_view);
        getDataInList();
        listview.setAdapter(new BaseAdapterActivity(context, myList));
    }

    private void getDataInList() {
        for (int i = 0; i <title.length; i++) {
            ListData ld = new ListData();
            ld.setTitle(title[i]);
            ld.setDescription(desc[i]);
            ld.setImage(img[i]);
            myList.add(ld);
        }
    }

}