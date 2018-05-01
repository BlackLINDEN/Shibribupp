package blacklinden.intentgyak;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;

import android.os.Bundle;

import frag.BalFrag;
import frag.JobbFrag;

public class KenderActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kender);
        Configuration config = getResources().getConfiguration();

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        /**
         * Check the device orientation and act accordingly
         */

        if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            /**
             * vízszintes
             */
            JobbFrag jobbFrag = new JobbFrag();
            fragmentTransaction.replace(android.R.id.content, jobbFrag);

        }else{
            /**
             * függőleges
             */
            BalFrag balFrag = new BalFrag();
            fragmentTransaction.replace(android.R.id.content, balFrag);
        }
        fragmentTransaction.commit();
    }


    }

