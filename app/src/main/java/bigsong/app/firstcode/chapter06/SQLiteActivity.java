package bigsong.app.firstcode.chapter06;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import bigsong.app.firstcode.R;
import bigsong.app.firstcode.chapter06.db.MyDatabaseHelper;

/**
 * Created by Jesse on 2016/6/11.
 */
public class SQLiteActivity extends AppCompatActivity {

    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter06_03sqlite);
        /**
         * 通过修改第4个参数，代表版本号，比以前的大的话就会执行onUpgrade()
         */
//        dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 1);
        dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 2);
        Button createdatabaseBtn = (Button) findViewById(R.id.btn_0602createdatabase);
        createdatabaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.getWritableDatabase();
            }
        });

        Button addDataBtn = (Button) findViewById(R.id.btn_0602add_data);
        addDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                /*ContentValues values = new ContentValues();
                values.put("name", "The Da Vinci COde");
                values.put("author", "Dan Brown");
                values.put("pages", 454);
                values.put("price", 16.96);
                db.insert("Book", null, values);
                values.clear();
                values.put("name", "The Lost Symbol");
                values.put("author", "Xue Song");
                values.put("pages", 510);
                values.put("price", 19.95);
                db.insert("Book", null, values);*/
                db.execSQL("insert into Book(name,author,pages,price) values(?,?,?,?)", new String[]{"Tian Shu", "Xue Song", "1000", "99.99"});
            }
        });

        Button updateDataBtn = (Button) findViewById(R.id.btn_0602update_data);
        updateDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
//                ContentValues values = new ContentValues();
//                values.put("author", "fanfan");
//                db.update("Book", values, "name=?", new String[]{"The Lost Symbol"});
                db.execSQL("update Book set price = ? where pages = ?", new String[]{"5", "1000"});
            }
        });

        Button deleteDataBtn = (Button) findViewById(R.id.btn_0602delete_data);
        deleteDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
//                db.delete("Book", "author=?", new String[]{"fanfan"});
                db.execSQL("delete from Book where author = ?", new String[]{"Xue Song"});
            }
        });

        Button queryDataBtn = (Button) findViewById(R.id.btn_0602query_data);
        queryDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
//                Cursor cursor = db.query("Book", null, null, null, null, null, null);
                Cursor cursor = db.rawQuery("select * from Book", null);
                if (cursor.moveToFirst()) {
                    do {
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        float price = cursor.getFloat(cursor.getColumnIndex("price"));
                        Log.d("MyBookInfo", name + " , " + author + " , " + pages + " , " + price);
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
        });
    }

}
