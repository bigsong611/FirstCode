package bigsong.app.firstcode.chapter09;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Jesse on 2016/7/17.
 */
public class AlarmReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent mIntent = new Intent(context,LongRunningService.class);
        context.startService(mIntent);
    }
}
