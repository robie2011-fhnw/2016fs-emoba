package ch.robie.android.examples.asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private final String Tag = "ExampleAppp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new ExampleAsync().execute(10);
    }

    // Types for: Input, Progress, Output
    class ExampleAsync extends AsyncTask<Integer, Integer, String>{
        @Override // executing in worker thread
        protected String doInBackground(Integer... params) {
            int max = params[0];
            for (int i = 0; i < max; i++){
                Log.d(Thread.currentThread().getName(), "Sleeping 1s");
                publishProgress(i*100/max); // not this: publishing to worker thread
                try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
            }
            return "Complicated calculated result";
        }

        @Override // executing in main thread
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            Log.d(Thread.currentThread().getName(),"update received: "  + values[0] + "%");
        }

        @Override // executing in main thread
        protected void onPostExecute(String s) {

            super.onPostExecute(s);
            Log.d(Thread.currentThread().getName(), "Endresult received: " + s);
        }
    }
}
