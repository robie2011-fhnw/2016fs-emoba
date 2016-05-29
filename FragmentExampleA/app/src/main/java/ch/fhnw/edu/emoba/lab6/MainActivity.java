package ch.fhnw.edu.emoba.lab6;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";
    private final String KEY_MYVALUE= "value";
    private int value;

    private boolean isTwoPaneMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        long start = System.nanoTime();
        super.onCreate(savedInstanceState);
        Log.d("", "create main activity");
        //Log.d("HelloWorld", "onCreate() called " + savedInstanceState);
        setContentView(R.layout.activity_main);
        long duration = System.nanoTime() - start;
        Log.d(TAG, "Duration " + duration + " nanoseconds");

        isTwoPaneMode = findViewById(R.id.helloworld_container) != null;
    }

    public void onButtonClick(View v) {
        // call activity using an implicit intent
//        Intent intent = new Intent("ch.fhnw.edu.helloworld.HELLOWORLD");
        // call activity using an explicit intent

        if (isTwoPaneMode){
            FragmentManager fm = getFragmentManager();
            Fragment f = fm.findFragmentById(R.id.helloworld_container);
            if (f == null){
                FragmentTransaction transaction = fm.beginTransaction();
                android.app.Fragment fragment = new MessageFragment();
                transaction.add(R.id.helloworld_container, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        }
        else{
            Intent intent = new Intent(this, MessageActivity.class);
            startActivity(intent);
        }
    }
}
