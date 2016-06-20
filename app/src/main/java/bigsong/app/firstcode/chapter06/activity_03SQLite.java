package bigsong.app.firstcode.chapter06;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import bigsong.app.firstcode.R;
import bigsong.app.firstcode.chapter06.db.MyDatabaseHelper;

/**
 * Created by Jesse on 2016/6/11.
 */
public class activity_03SQLite extends AppCompatActivity {

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
    }
}