package net.sabamiso.android.androidnotificationtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;

public class DummyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy);

        Intent intent = new Intent(this, DummyService.class);
        startService(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
