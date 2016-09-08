package net.sabamiso.android.androidnotificationtest;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

public class DummyService extends Service {
    static final String TAG = "DummyService";

    ///////////////////////////////////////////////////////////////////////
    //
    // binder
    //
    private final IBinder mBinder = new DummyServiceeBinder();

    public class DummyServiceeBinder extends Binder {
        DummyService getService() {
            return DummyService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }


    ///////////////////////////////////////////////////////////////////////

    @Override
    public void onCreate() {
        createNotification();
    }

    private void createNotification() {
        Toast.makeText(getApplicationContext(), "DummyService.createNotification()", Toast.LENGTH_LONG).show();

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext());
        builder.setAutoCancel(false); // タップしたときの通知を消す設定
        builder.setOngoing(true);     // 通知を横スワイプしても消せないようにする設定
        builder.setSmallIcon(R.drawable.icon);
        builder.setContentTitle("AndroidNotificationTest");
        builder.setContentText("タップをするとActivityが表示されます");

        Intent intent = new Intent(this, DummyActivity.class);

        PendingIntent contentIntent = PendingIntent.getActivity(getApplicationContext(), 123, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        NotificationManagerCompat manager = NotificationManagerCompat.from(getApplicationContext());
        manager.notify(123, builder.build());
    }
}
