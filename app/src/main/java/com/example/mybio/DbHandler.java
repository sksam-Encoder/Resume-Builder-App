package com.example.mybio;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.mybio.Activites.MainActivity;

public class DbHandler extends SQLiteOpenHelper {
    public DbHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE RESUMEBIO(ID TEXT PRIMARY KEY,NAME TEXT, EMAIL TEXT,PHONE TEXT,WORK_PLAT TEXT,ADDRESS TEXT,WORK_EXP TEXT," +
                "ADD_ACTIVITES TEXT, LANGUAGE TEXT,GENDER VARCHAR2(8),SOCIAL_LINK TEXT,DATE1 TEXT,DATE2 TEXT,EDU1 TEXT,EDU2 TEXT,IMAGE BLOB)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public boolean insertData(user us) {
        String b, a[] = us.getLanguage();
        b="";
        for (int i=0;i<a.length;i++)
        {
            b=b+" "+a[i];

        }

        b = a[0] + " " + a[1] + " " + a[2] + " " + a[3] + " " + a[4] + " ";
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", us.getName());
        contentValues.put("EMAIL", us.getEmail());
        contentValues.put("PHONE", us.getPhone());
        contentValues.put("WORK_PLAT", us.getWork_plat());
        contentValues.put("ADDRESS ", us.getAddress());
        contentValues.put("WORK_EXP", us.getWork_expericenc());
        contentValues.put("ADD_ACTIVITES", us.getAdd_activities());
        contentValues.put("LANGUAGE", b);
        contentValues.put("GENDER ", us.getGender());
        contentValues.put("SOCIAL_LINK ", us.getSocial());
        contentValues.put("DATE1", us.getDate1());
        contentValues.put("DATE2", us.getDate2());
        contentValues.put("EDU1", us.getEdu1());
        contentValues.put("EDU2", us.getEdu2());
        contentValues.put("IMAGE", MainActivity.img);

        Long result = sqLiteDatabase.insert("RESUMEBIO", null, contentValues);
        if (result == -1) {

            return false;


        } else
            return true;
    }
}
