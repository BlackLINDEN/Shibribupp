package eszk;

import android.content.Intent;
import android.provider.CalendarContract;
import android.widget.CalendarView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * Created by Vitya on 2017. 09. 24..
 */

public class Naptar {

    public static HashMap<String,List<String>> getTap(){
        HashMap<String, List<String>> tapok = new HashMap<>();
        List<String> coco = new ArrayList<>();
        coco.add("feed");
        coco.add("50ml Cal");

        tapok.put("tap",coco);
        return tapok;
    }

    public void TapNaptar(int index, Intent ii, CalendarView calendarView){

        ii.setData(CalendarContract.Events.CONTENT_URI);
        ii.putExtra(CalendarContract.Events.TITLE,"Garden Duty");
        ii.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,calendarView.getDate());
        ii.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,calendarView.getDate()+"P70D");
        ii.putExtra(CalendarContract.Events.DURATION,"P70D");
        ii.putExtra(CalendarContract.Events.RRULE,"FREQ=WEEKLY;");
        ii.putExtra(CalendarContract.Events.EXRULE,"FREQ=MONTHLY");

        ii.putExtra(CalendarContract.Events.DESCRIPTION,Naptar.getTap().get("tap").get(index));

    }




}
