package com.example.administrator.bazipaipan.db;import android.content.Context;import android.database.sqlite.SQLiteDatabase;import android.database.sqlite.SQLiteDatabase.CursorFactory;import android.database.sqlite.SQLiteOpenHelper;public class DBOpenHelper extends SQLiteOpenHelper {	private final static int VERSION = 1;	public DBOpenHelper(Context context, String name, CursorFactory factory,			int version) {		super(context, name, factory, version);	}	public DBOpenHelper(Context context, String name, CursorFactory factory) {		this(context, name, null, VERSION);	}	public DBOpenHelper(Context context, String name) {		this(context, name, null);	}	public DBOpenHelper(Context context) {		this(context, DBConfig.DB_NAME, null);	}	@Override	public void onCreate(SQLiteDatabase db) {		db.execSQL("CREATE TABLE T_Province(ProSort text PRIMARY KEY,ProName text)");		db.execSQL("CREATE TABLE T_City(CitySort text PRIMARY KEY,CityName text,ProID text)");		db.execSQL("CREATE TABLE T_Zone(ZoneID text PRIMARY KEY,ZoneName text,CityID text)");	}	@Override	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {		db.execSQL("DROP TABLE IF EXISTS T_Province");		db.execSQL("DROP TABLE IF EXISTS T_City");		db.execSQL("DROP TABLE IF EXISTS T_Zone");		onCreate(db);	}}