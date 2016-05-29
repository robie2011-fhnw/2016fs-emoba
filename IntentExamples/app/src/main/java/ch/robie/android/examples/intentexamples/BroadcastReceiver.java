package ch.robie.android.examples.intentexamples;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Robie on 28.05.2016.
 */
public class BroadcastReceiver extends android.content.BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(Thread.currentThread().getName(), "Intent received");
    }
}
