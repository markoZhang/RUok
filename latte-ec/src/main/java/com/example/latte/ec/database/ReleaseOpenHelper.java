package com.example.latte.ec.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * @author Marko
 * @date 2018/12/13
 */

public class ReleaseOpenHelper extends DaoMaster.OpenHelper{

    public ReleaseOpenHelper(Context context, String name) {
        super(context, name);
    }

    public ReleaseOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }
}
