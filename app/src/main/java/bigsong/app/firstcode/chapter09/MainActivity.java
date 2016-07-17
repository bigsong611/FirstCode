package bigsong.app.firstcode.chapter09;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import bigsong.app.firstcode.R;

/**
 * Created by BigSong on 16/7/9.
 */
public class MainActivity extends AppCompatActivity {

    private MyService.DownloadBinder downloadBinder;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            downloadBinder = (MyService.DownloadBinder) service;
            downloadBinder.startDownload();
            downloadBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter09_main);
    }

    public void onCLick_androidTreadTest(View view) {
        startActivity(new Intent(MainActivity.this, AnroidThreaTestActivity.class));
    }

    public void onClick_startService(View view) {
        Intent startIntent = new Intent(this, MyService.class);
        startService(startIntent);
    }

    public void onClick_stopService(View view) {
        Intent stopIntent = new Intent(this, MyService.class);
        stopService(stopIntent);
    }

    public void onClick_bindService(View view) {
        Intent intent = new Intent(this, MyService.class);
        bindService(intent, connection, BIND_AUTO_CREATE);
    }

    public void onClick_unbindService(View view) {
        unbindService(connection);
    }

    public void onClick_startLongRunningService(View view){
        Intent intent = new Intent(this,LongRunningService.class);
        startService(intent);
    }

}
