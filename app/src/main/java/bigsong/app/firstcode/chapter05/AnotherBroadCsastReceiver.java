package bigsong.app.firstcode.chapter05;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/7/4.
 */
public class AnotherBroadCsastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "received in AnotherBroadCsastReceiver", Toast.LENGTH_SHORT).show();
    }
}
