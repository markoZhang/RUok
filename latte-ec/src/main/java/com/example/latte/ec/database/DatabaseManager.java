package com.example.latte.ec.database;

import android.content.Context;

import org.greenrobot.greendao.database.Database;


/**
 * @author Marko
 * @date 2018/12/13
 */

public class DatabaseManager {

    private DaoSession mDaoSession = null;
    private UserProfileDao mDao = null;

    private DatabaseManager(){

    }
    public DatabaseManager init(Context context){
        initDao(context);
        return this;
    }
    private static final class Holder{
        private static final DatabaseManager INSTANCE = new DatabaseManager();
    }
    public static DatabaseManager getInstance(){
        return Holder.INSTANCE;
    }
    private void initDao(Context context){
        final ReleaseOpenHelper helper = new ReleaseOpenHelper(context,"fast_ec.db");
        final Database database = helper.getWritableDb();
        mDaoSession = new DaoMaster(database).newSession();
        mDao = mDaoSession.getUserProfileDao();
    }
    public final UserProfileDao getDao(){
        return mDao;
    }
}
