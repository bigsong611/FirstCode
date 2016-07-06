package bigsong.app.firstcode.chapter05;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import bigsong.app.firstcode.R;

/**
 * Created by BigSong on 16/6/26.
 */
public class MainActivity extends AppCompatActivity {

    private IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter05_main);
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver, intentFilter);
    }

    public void sendBroadcastOnClick (View view){
        Intent intent = new Intent("com.example.broadcast.MY_BROADCAST");
//        sendBroadcast(intent);
        sendOrderedBroadcast(intent, null);
    }

    public void openLocalBroadCast(View view){
        startActivity(new Intent(MainActivity.this,LocalBroadCastReceiverActivity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
    }

    class NetworkChangeReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isAvailable()){
                Toast.makeText(context,"network is avaliable",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(context,"network is unavaliable",Toast.LENGTH_SHORT).show();
            }
//            Toast.makeText(context, "network change", Toast.LENGTH_SHORT).show();
        }
    }
}
