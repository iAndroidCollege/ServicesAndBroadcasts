package college.edu.tomer.servicesandbroadcasts;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;


public class DownloadService extends IntentService {

    public static final String ACTION_DOWNLOAD_FINISHED = "college.edu.tomer.servicesandbroadcasts.DOWNLOAD_FINISHED";

    public DownloadService() {
        super("DownloadService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        System.out.println("Hello, From Service");
        doFakeWork();
        notifyListeners();
    }

    private void notifyListeners() {
        Intent intent = new Intent(ACTION_DOWNLOAD_FINISHED);
        intent.putExtra("result", "This is the file");
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    private void doFakeWork() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
