package ch.robie.android.examples.fragmentcs;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.container2);
        // in landscape mode this layout is available. in portrait mode not.
        if (frameLayout != null)
        {
            FragmentManager fragmentManager = getFragmentManager();
            Fragment f = fragmentManager.findFragmentById(R.id.container2);
            if (f == null){
                FragmentTransaction tx = fragmentManager.beginTransaction();
                tx.add(R.id.container2, new Part2Fragment());
                tx.addToBackStack(null);
                tx.commit();
            }
        }
    }
}
