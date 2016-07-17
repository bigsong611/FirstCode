package bigsong.app.firstcode.chapter09;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;

import bigsong.app.firstcode.*;
import bigsong.app.firstcode.MainActivity;

/**
 * Created by BigSong on 16/7/10.
 */
public class MyService extends Service {

    private DownloadBinder binder = new DownloadBinder();

    class DownloadBinder extends Binder {
        public void startDownload() {
            Log.d("MyService", "startDownload");
        }

        public int getProgress() {
            Log.d("MyService", "getProgress");
            return 0;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("MyService", "onCreate");
       /* Notification notification = new Notification(R.mipmap.ic_launcher,"Notification comes",System.currentTimeMillis());
        Intent notificationIntent = new Intent(this, bigsong.app.firstcode.MainActivity.class);
        PendingIntent pendingIntent= PendingIntent.getActivity(this,0,notificationIntent,0);
        notification.*/
       /* NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this);
        notificationBuilder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        notificationBuilder.setContentTitle("This is title");
        notificationBuilder.setContentText("This is text");
        notificationBuilder.setTicker("New message");
        notificationBuilder.setAutoCancel(true);
        notificationBuilder.setNumber(12);
//        notificationBuilder.setDefaults(Notification.DEFAULT_ALL);
        Intent resultIntent = new Intent(this, bigsong.app.firstcode.MainActivity.class);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(this,0,resultIntent,PendingIntent.FLAG_UPDATE_CURRENT);
        notificationBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(0,notificationBuilder.build());*/
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setTicker("This is Ticker");
        mBuilder.setSmallIcon(R.mipmap.ic_launcher);
        mBuilder.setContentTitle("This is ContentTitle");
        mBuilder.setContentText("This is ContentText");
        mBuilder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.wtf));
        mBuilder.setNumber(6);
//        mBuilder.setOngoing(true);
        mBuilder.setAutoCancel(true);
        Intent resultIntent = new Intent(this, bigsong.app.firstcode.MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent pIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(pIntent);
        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(1, mBuilder.build());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("MyService", "onStartCommand");
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MyService", "onDestroy");
    }
}
