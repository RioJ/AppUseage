package com.jrh.appusage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper {
	public DBOpenHelper(Context context) {
		super(context, "appcount.db",null,2);  // �ļ����ݣ�  ���ݿ��ļ������α깤�����汾�ţ�
	}

	public void onCreate(SQLiteDatabase db) {  // �������ݿ�ÿ�α�������ʱ����õ�
		db.execSQL("CREATE TABLE appInfo(appid integer primary key autoincrement, pkgName varchar(40), label VARCHAR(12),total integer)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("ALTER TABLE appInfo ADD img ");
	}
	
	@Override
	public synchronized void close() {
		// TODO Auto-generated method stub
		super.close();
	}
}