package college.edu.tomer.servicesandbroadcasts;

import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
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

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);


        builder.setSmallIcon(R.mipmap.ic_launcher).
                setContentTitle("Title").
                setContentText("This is the content").
                setContentIntent(getPendingIntent()).
                setDefaults(NotificationCompat.DEFAULT_ALL)
                .setStyle(new NotificationCompat.
                        BigTextStyle().
                        bigText("Large Text"))
                .addAction(R.drawable.ic_stat_name, "Add", getPendingIntent())
                .addAction(R.drawable.ic_done_24dp, "Remove", getPendingIntent());


        Notification notification = builder.build();

        NotificationManagerCompat.from(this).notify(3, notification);

    }

    private PendingIntent getPendingIntent() {

        Intent mainActivityIntent = new Intent(this, MainActivity.class);
        return PendingIntent.getActivity(this, 2, mainActivityIntent, PendingIntent.FLAG_UPDATE_CURRENT);

    }

    private void doFakeWork() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
