package college.edu.tomer.servicesandbroadcasts;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.google.gson.Gson;

public class ParsePushBroadcastReciever extends BroadcastReceiver {


    private Context context;

    @Override
    public void onReceive(Context context, Intent intent) {
        String json = intent.getStringExtra("com.parse.Data");
        Gson gson = new Gson();
        System.out.println(json);
        ParseMessage message = gson.fromJson(json, ParseMessage.class);
        this.context = context;
        sendNotification(message.getTitle(), message.getMessage());
    }

    private void sendNotification(String title, String message) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);


        builder.setSmallIcon(R.drawable.ic_stat_name2).
                setContentTitle(title).
                setContentText(message).
                setContentIntent(getPendingIntent()).
                setDefaults(NotificationCompat.DEFAULT_ALL)
                .setStyle(new NotificationCompat.
                        BigTextStyle().
                        bigText(message))
                .addAction(R.drawable.ic_stat_name, "Add", getPendingIntent())
                .addAction(R.drawable.ic_done_24dp, "Remove", getPendingIntent());


        Notification notification = builder.build();

        NotificationManagerCompat.from(context).notify(3, notification);
    }


    private PendingIntent getPendingIntent() {

        Intent mainActivityIntent = new Intent(context, MainActivity.class);
        return PendingIntent.getActivity(context, 2, mainActivityIntent, PendingIntent.FLAG_UPDATE_CURRENT);

    }
}
