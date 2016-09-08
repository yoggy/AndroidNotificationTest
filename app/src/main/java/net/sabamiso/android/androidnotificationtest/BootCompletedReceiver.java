package net.sabamiso.android.androidnotificationtest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootCompletedReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)){
            Intent i = new Intent(context, DummyService.class);
            i.setAction(Intent.ACTION_BOOT_COMPLETED);
            context.startService(i);
        }
    }
}
