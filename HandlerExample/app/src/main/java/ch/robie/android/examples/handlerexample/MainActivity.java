package ch.robie.android.examples.handlerexample;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private static Handler handlerToMainThread;
    private static MyThread myThreadInstance;
    private static MainActivity mainActivityThis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handlerThreadExample();
        //threadExample();
    }


    public class MyThread extends Thread{
        @Override
        public void run() {
            for (int i = 1; i < 3 ; i++){
                Log.d(Thread.currentThread().getName(), "send Message");
                handlerToMainThread.sendEmptyMessage(0);
                handlerToMainThread.post(new Runnable() {
                    @Override
                    public void run() {
                        ((TextView) mainActivityThis.findViewById(R.id.myText))
                                .setText((new Date()).toString());
                    }
                });

                try {Thread.sleep(2000);}
                catch (InterruptedException e) {e.printStackTrace();}
            }

        }
    }

    private void threadExample(){
        mainActivityThis = this;
        handlerToMainThread = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                Log.d(Thread.currentThread().getName(), "Message received!");
            }
        };

        if (myThreadInstance == null || !myThreadInstance.isAlive()){
            myThreadInstance = new MyThread();
            myThreadInstance.run();
        }
    }



    private void handlerThreadExample(){
        HandlerThread ht = new HandlerThread("MySuperAwesomeHandlerThread");
        ht.start();
        Handler h = new Handler(ht.getLooper()) {
            public void handleMessage(Message msg) {
                Log.d("blabla", "handleMessage " + msg.what + " in " + Thread.currentThread());
            };
        };
        for (int i = 0; i < 5; i++) {
            Log.d("Tatata", "sending " + i + " in " + Thread.currentThread());
            h.sendEmptyMessageDelayed(i, 3000 + i * 1000);
        }
    }
}
