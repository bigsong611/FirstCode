package bigsong.app.firstcode.chapter09;

import android.app.IntentService;
import android.content.Intent;

/**
 * 更简单的创建一个异步的、会自动停止的服务
 * Created by Jesse on 2016/7/17.
 */
public class MyIntentService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public MyIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }
}
