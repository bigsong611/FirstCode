package bigsong.app.firstcode.chapter09;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import bigsong.app.firstcode.R;

/**
 * Created by BigSong on 16/7/9.
 */
public class AnroidThreaTestActivity extends AppCompatActivity {

    public static final int UPDATE_TEXT = 1;

    private TextView textView;

    private Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case UPDATE_TEXT:
                    textView.setText("This ti new Text");
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter09_androidthreadtest);
        textView = (TextView) findViewById(R.id.text);
    }

    public void onClick_changeText(View view){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message message = new Message();
                message.what = UPDATE_TEXT;
                handler.sendMessage(message);
            }
        }).start();
    }
}
