package ch.robie.android.examples.intentexamples;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sendRequestCodeExample();
        //sendBroadcastExample();
    }

    private final int reqCode = 13;
    private void sendRequestCodeExample(){
        startActivityForResult(new Intent("MyIntent.T1"), reqCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == reqCode){
            Log.d("R", "Request result received");
        }
    }

    private void sendBroadcastExample(){
        Intent i = new Intent();
        i.setAction("robie.TEST1");
        Log.d("main", "send intent");
        sendBroadcast(i);
    }
}
