package blacklinden.intentgyak;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.graphics.drawable.Animatable2Compat;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;



public class MainActivity extends Activity {

    ImageButton egyes, kettes, harmas;
    Button gomb1,gomb2,gomb3;
    HorizontalScrollView sv;
    TextView tv;
    ImageView pipa, molekula;
    AnimatedVectorDrawable animatedVectorDrawable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView)findViewById(R.id.tv);
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/athene.otf");
        tv.setTextColor(getResources().getColor(R.color.colorPrimary,null));
        tv.setTypeface(tf);
        sv=(HorizontalScrollView)findViewById(R.id.ScrollView);
        sv.setSmoothScrollingEnabled(true);
        egyes=(ImageButton)findViewById(R.id.egy);
        kettes=(ImageButton)findViewById(R.id.ket);
        harmas=(ImageButton)findViewById(R.id.harm);

        final Animation fel = AnimationUtils.loadAnimation(this,R.anim.translate);
        final Animation nagy = AnimationUtils.loadAnimation(this,R.anim.scale);
        final Animation rng = AnimationUtils.loadAnimation(this,R.anim.rotate);

        pipa = (ImageView)findViewById(R.id.pipa);
        animatedVectorDrawable = (AnimatedVectorDrawable)getDrawable(R.drawable.animvekt);
        pipa.setImageDrawable(animatedVectorDrawable);
        animatedVectorDrawable.start();

        molekula = (ImageView)findViewById(R.id.imageView2);
        molekula.startAnimation(fel);



        gomb1 = (Button)findViewById(R.id.gomb1);
        gomb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(),MasodActivity.class);
                startActivity(i);
            }
        });
        gomb2 = (Button)findViewById(R.id.gomb2);
        gomb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getBaseContext(),TapActivity.class);
                startActivity(i);
            }
        });
        gomb3 = (Button)findViewById(R.id.gomb3);
        gomb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(),Simulator.class);
                startActivity(i);
            }
        });

        egyes.setOnClickListener(new View.OnClickListener(){

            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                v.startAnimation(fel);
                Intent intent = new Intent(getBaseContext(),MagvakAct.class);
               startActivity(intent);
            }
        });

        kettes.setOnClickListener(new View.OnClickListener(){

            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                v.startAnimation(nagy);
               Intent i = new Intent(getBaseContext(),KenderActivity.class);
               startActivity(i);
            }
        });

        harmas.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
               v.startAnimation(rng);






                //Intent intent = new Intent(getApplicationContext(), TapActivity.class);
                //startActivity(intent);
            }
        });


    }


}
