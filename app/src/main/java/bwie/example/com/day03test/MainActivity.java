package bwie.example.com.day03test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;

import java.util.List;

import bwie.example.com.day03test.bean.ItemBean;
import bwie.example.com.day03test.bean.ListBean;
import bwie.example.com.day03test.greendao.DaoSession;
import bwie.example.com.day03test.utils.NetworkUtils;
import bwie.example.com.day03test.utils.SqlHelper;
import bwie.example.com.day03test.utils.SqlLiteUtils;
import bwie.example.com.day03test.utils.Sqlutils;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycle_main;
    private Sqlutils sqlutils;
    private SqlLiteUtils sqlLiteUtils;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycle_main = (RecyclerView) findViewById(R.id.recycle_main);
//        sqlutils = new Sqlutils(MainActivity.this);
        sqlLiteUtils = new SqlLiteUtils();
        sqlLiteUtils.init(this);
//        SimpleDraweeView draweeView=(SimpleDraweeView)findViewById(R.id.draw);
//        draweeView.setImageURI("https://img.huxiucdn.com/article/cover/201810/29/153108448766.jpg");

        if (NetworkUtils.isConnected(this)) {
            doHttp();
        } else {
//            String select = sqlutils.select();
//            ListBean listBean = new Gson().fromJson(select, ListBean.class);
//            List<ItemBean> items = listBean.getItems();
////                Toast.makeText(MainActivity.this, ""+items.size(), Toast.LENGTH_SHORT).show();
//            MyAdapter myAdapter = new MyAdapter(items, MainActivity.this);
//            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
//            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//            recycle_main.setLayoutManager(linearLayoutManager);
//            recycle_main.setAdapter(myAdapter);

            String data = sqlLiteUtils.select().get(0).getData();

            ListBean listBean = new Gson().fromJson(data, ListBean.class);
            List<ItemBean> items = listBean.getItems();
//                Toast.makeText(MainActivity.this, ""+items.size(), Toast.LENGTH_SHORT).show();
            MyAdapter myAdapter = new MyAdapter(items, MainActivity.this);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recycle_main.setLayoutManager(linearLayoutManager);
            recycle_main.setAdapter(myAdapter);

        }


    }

    private void doHttp() {
        new OkUtils("https://code.aliyun.com/598254259/FristProject/raw/master/bw_test.txt").setOkLisener(new OkUtils.OkListener() {
            @Override
            public void success(String data) {
//                sqlLiteUtils.insert();
//                sqlutils.insert(data);
                ItemBean itemBean = new ItemBean();
                itemBean.setData(data);
                sqlLiteUtils.insert(itemBean);//存储数据


                ListBean listBean = new Gson().fromJson(data, ListBean.class);
                List<ItemBean> items = listBean.getItems();
//                Toast.makeText(MainActivity.this, ""+items.size(), Toast.LENGTH_SHORT).show();
                MyAdapter myAdapter = new MyAdapter(items, MainActivity.this);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recycle_main.setLayoutManager(linearLayoutManager);
                recycle_main.setAdapter(myAdapter);
            }
        });
    }


}
