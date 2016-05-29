package ch.fhnw.edu.emoba.lab6;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MessageActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("", "create message activity");
        setContentView(R.layout.message);
    }
}
