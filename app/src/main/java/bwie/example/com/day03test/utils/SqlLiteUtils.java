package bwie.example.com.day03test.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import bwie.example.com.day03test.bean.ItemBean;
import bwie.example.com.day03test.greendao.DaoMaster;
import bwie.example.com.day03test.greendao.DaoSession;

public class SqlLiteUtils {

    private DaoSession daoSession;
    private DaoMaster daoMaster;
    private SQLiteDatabase db;

    //初始化数据库
    public void init(Context context){
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "lin");
        db = helper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    //添加
    public void insert(ItemBean itemBean){
        daoSession.getItemBeanDao().insert(itemBean);
    }



    //查询
    public  List<ItemBean> select(){
        List<ItemBean> itemBeans = daoSession.getItemBeanDao().loadAll();
        return itemBeans;
    }


}
