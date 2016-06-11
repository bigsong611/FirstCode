package bigsong.app.firstcode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import bigsong.app.firstcode.chapter06.MainActivity_chapter06;

public class MainActivity extends AppCompatActivity {

    private String[] data = {"1", "2", "3", "4", "5", "第6章 数据存储方案，详解持久化技术", "7", "8", "9", "10", "11", "12", "13", "14", "15"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView mainListView = (ListView) findViewById(R.id.list_main);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, data);
        mainListView.setAdapter(adapter);
        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MainActivity.this,data[position],Toast.LENGTH_SHORT).show();
                Log.d("postion", position + "");
                Intent intent = null;
                switch (position + 1) {
                    case 6:
                        intent = new Intent(MainActivity.this, MainActivity_chapter06.class);
                        //Toast.makeText(MainActivity.this, data[position], Toast.LENGTH_SHORT).show();
                }
                startActivity(intent);
            }
        });
    }
}
