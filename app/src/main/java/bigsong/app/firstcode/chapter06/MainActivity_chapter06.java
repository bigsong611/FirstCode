package bigsong.app.firstcode.chapter06;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import bigsong.app.firstcode.R;

/**
 * Created by Jesse on 2016/6/10.
 */
public class MainActivity_chapter06 extends AppCompatActivity {

    String[] data = {"1.文件存储", "2.SharedPrefrence存储", "3.数据库存储"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter06_main);
        ListView listView = (ListView) findViewById(R.id.list_main_chapter06);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity_chapter06.this, android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;
                switch (position) {
                    case 0:
                        intent = new Intent(MainActivity_chapter06.this, activity_01context.class);
                    case 1:
                        intent = new Intent(MainActivity_chapter06.this,activity_02sharedPreferences.class);
                    case 2:
                        intent = new Intent(MainActivity_chapter06.this,activity_03SQLite.class);
                }
                startActivity(intent);
            }
        });
    }
}
