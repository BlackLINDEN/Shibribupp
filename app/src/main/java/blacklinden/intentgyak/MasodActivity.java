package blacklinden.intentgyak;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

public class MasodActivity extends Activity implements SensorEventListener {

    Button gmb;
    ProgressBar progressBar;
    private SensorManager manager;
    private Sensor fenySzenzor;
    private String lightSensorReading;
    private String eredmeny;
    private HardwareAdapter hardwareAdapter;
    private ListView lightSensorListView;
    private List<HardwareObject> lSensor;
    private ImageView iv;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masod);

        iv=(ImageView)findViewById(R.id.kndr);
        @SuppressLint("RestrictedApi") final ContextThemeWrapper wrapper = new ContextThemeWrapper(this, R.style.BaubleSmall);
        valtsSzint(wrapper.getTheme());

        gmb=(Button)findViewById(R.id.button);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        progressBar.setMax(2000);

        gmb.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        manager = (SensorManager)getSystemService(SENSOR_SERVICE);
        fenySzenzor = manager.getDefaultSensor(Sensor.TYPE_LIGHT);

        System.out.println("Sensor Name " + fenySzenzor.getName()+" power "+fenySzenzor.getPower()+" mxrange "+fenySzenzor.getMaximumRange()+fenySzenzor.getReportingMode());

        if(fenySzenzor != null){
            manager.registerListener(this, fenySzenzor, SensorManager.SENSOR_DELAY_NORMAL);
        }




    }

    @Override
    protected void onResume() {
        super.onResume();
        manager.registerListener(this, fenySzenzor, SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onPause() {
        super.onPause();
        manager.unregisterListener(this);
    }


    @Override
    public void onSensorChanged(SensorEvent event) {


        if(event.sensor.getType() == Sensor.TYPE_LIGHT){
            lightSensorReading = String.valueOf(event.values[0]);
            eredmEny(lightSensorReading);
            progressBar.setProgress((int)event.values[0]);
            lSensor = new ArrayList<HardwareObject>();
            lSensor.add(new HardwareObject("SI Lux", lightSensorReading));
            lSensor.add(new HardwareObject("Result",eredmeny));
            hardwareAdapter = new HardwareAdapter(MasodActivity.this, lSensor);
            lightSensorListView = (ListView)findViewById(R.id.light_sensor);
            lightSensorListView.setAdapter(hardwareAdapter);
        }
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    private void eredmEny(String s){
        final Resources.Theme theme =getResources().newTheme();
        float szam=Float.parseFloat(s);
        if(szam<=3500){
            eredmeny="weak";
            theme.applyStyle(R.style.BaubleSmall,false);
        }

        if(szam>3500&&szam<=8000){
            eredmeny="good";
            theme.applyStyle(R.style.BaubleRound,false);
        }
        if(szam>8000){
            eredmeny="too much";
            theme.applyStyle(R.style.Sok,false);
        }

        valtsSzint(theme);

    }



    public void valtsSzint(Resources.Theme theme){
        final Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_leaf, theme);

        iv.setImageDrawable(drawable);


    }

    /*
    int frameHeight1 = camera.getParameters().getPreviewSize().height;
    int frameWidth1 = camera.getParameters().getPreviewSize().width;
    int rgb1[] = new int[frameWidth * frameHeight];
    decodeYUV420SP(rgb1, data, frameWidth, frameHeight);
    Bitmap bmp1 = Bitmap.createBitmap(rgb, frameWidth1, frameHeight1, Config.ARGB_8888);
    int pixel = bmp1.getPixel( x,y );
    int redValue1 = Color.red(pixel);
    int blueValue1 = Color.blue(pixel);
    int greenValue1 = Color.green(pixel);
    int thiscolor1 = Color.rgb(redValue1, greenValue1, blueValue1);
    */
}
