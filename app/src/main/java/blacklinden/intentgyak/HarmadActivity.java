package blacklinden.intentgyak;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.util.Calendar;
import android.icu.util.GregorianCalendar;
import android.net.Uri;
import android.provider.CalendarContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

import java.io.IOException;
import java.util.Date;

import eszk.Naptar;

public class HarmadActivity extends Activity {

    CalendarView calendarView;
    Switch s;
    Button b;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harmad);

        calendarView = new CalendarView(this);
        calendarView = (CalendarView) findViewById(R.id.calendarView2);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Calendar nptr = Calendar.getInstance();
                nptr.set(year,month,dayOfMonth);
               calendarView.setDate(nptr.getTimeInMillis(),true,true);
            }
        });

        s = (Switch) findViewById(R.id.switch1);
        b = (Button) findViewById(R.id.button3);

        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Intent ii = new Intent(Intent.ACTION_INSERT);
                Naptar n = new Naptar();
                n.TapNaptar(TapActivity.index,ii,calendarView);


                Intent i = new Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI);
               if(isChecked) startActivity(ii);
            }
        });

    }
}
