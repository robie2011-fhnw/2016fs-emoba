package ch.robie.android.examples.intentexamples;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class MyIntentService extends IntentService {
    public MyIntentService() {
        super(MyIntentService.class.getName());
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(Thread.currentThread().getName(), "IntentService started");
    }
}
