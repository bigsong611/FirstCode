package bigsong.app.firstcode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private String[] data = {"1", "2", "3", "第4章 Fragment", "5", "第6章 数据存储方案，详解持久化技术", "7", "8", "9", "10", "11", "12", "13", "14", "15"};

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
                    case 4:
                        intent = new Intent(MainActivity.this, bigsong.app.firstcode.chapter04.MainActivity.class);
                        break;
                    case 6:
                        intent = new Intent(MainActivity.this, bigsong.app.firstcode.chapter06.MainActivity.class);
                        break;
                        //Toast.makeText(MainActivity.this, data[position], Toast.LENGTH_SHORT).show();
                }
                startActivity(intent);
            }
        });
    }
}
