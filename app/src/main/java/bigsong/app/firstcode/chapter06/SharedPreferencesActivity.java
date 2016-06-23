package bigsong.app.firstcode.chapter06;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import bigsong.app.firstcode.R;

/**
 * Created by Jesse on 2016/6/11.
 */
public class SharedPreferencesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter06_02sharedpreferences);

        Button saveBtn = (Button) findViewById(R.id.btn_0602savedata);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
                editor.putString("name", "Tom");
                editor.putInt("age", 28);
                editor.putBoolean("married", false);
                editor.commit();
            }
        });

        Button restoreBtn = (Button) findViewById(R.id.btn_0602restoredata);
        restoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getSharedPreferences("data", MODE_PRIVATE);
                String name = pref.getString("name", "");
                int age = pref.getInt("age", 0);
                boolean married = pref.getBoolean("married", false);
                Log.d("Activity_SharedPreferences", "name is " + name);
                Log.d("Activity_SharedPreferences", "age is " + age);
                Log.d("Activity_SharedPreferences", "married is " + married);
            }
        });
    }
}
