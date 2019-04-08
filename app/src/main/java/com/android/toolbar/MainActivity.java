package com.android.toolbar;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spin_one;
    private Context mContext;
    //判断是否为刚进去时触发onItemSelected的标志
    private boolean one_selected = false;
    private BaseAdapter myAdadpter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;
        bindViews();
    }


    private void bindViews() {
        spin_one = (Spinner) findViewById(R.id.spin_one);
        spin_one.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()){
            case R.id.spin_one:
                if(one_selected){
                    Toast.makeText(mContext,"您选择的是~：" + parent.getItemAtPosition(position).toString(),
                            Toast.LENGTH_SHORT).show();
                }else one_selected = true;
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}



/*
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity {

    private String[] mStrs = {"kk", "kk", "wskx", "wksx"};
    private SearchView mSearchView;
    private ListView lListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSearchView = (SearchView) findViewById(R.id.searchView);
        lListView = (ListView) findViewById(R.id.listView);
        lListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mStrs));
        lListView.setTextFilterEnabled(true);

        // 设置搜索文本监听
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            // 当点击搜索按钮时触发该方法
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            // 当搜索内容改变时触发该方法
            @Override
            public boolean onQueryTextChange(String newText) {
                if (!TextUtils.isEmpty(newText)){
                    lListView.setFilterText(newText);
                }else{
                    lListView.clearTextFilter();
                }
                return false;
            }
        });

    }

}*/