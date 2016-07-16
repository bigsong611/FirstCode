package bigsong.app.firstcode.chapter09;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import bigsong.app.firstcode.R;

/**
 * Created by BigSong on 16/7/9.
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter09_main);
    }

    public void onCLick_androidTreadTest(View view){
        startActivity(new Intent(MainActivity.this,AnroidThreaTestActivity.class));
    }
}
