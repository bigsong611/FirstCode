package bigsong.app.firstcode.chapter09;

import android.os.AsyncTask;

/**
 * Created by BigSong on 16/7/10.
 */
public class DownloadTask extends AsyncTask<Void,Integer,Boolean> {

    /**
     * 后台任务开始前调用,用于初始化一些操作
     */
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    /**
     * 核心方法,其中所有的代码将在子线程中运行,可以调用publishProgress来更新进度UI
     * @param params
     * @return
     */
    @Override
    protected Boolean doInBackground(Void... params) {
        return null;
//        publishProgress();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    /**
     * 后台任务执行结束后调用
     * @param aBoolean
     */
    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
    }
}
