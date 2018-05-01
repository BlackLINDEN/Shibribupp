package blacklinden.intentgyak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Vitya on 2017. 08. 22..
 */

public class ExpandableList {
    public static HashMap<String, List<String>> getData(){
        HashMap<String, List<String>> expListReszlet = new HashMap<String,List<String>>();

        List<String> a = new ArrayList<String>();
        a.add("Coco fiber");
        a.add("Black soil");
        a.add("Composted shit");

        List<String> b = new ArrayList<String>();
        b.add("Bubbleponics");
        b.add("Aquaponics");
        b.add("Some other that I need to research");
        expListReszlet.put("Soil",a);
        expListReszlet.put("Hydropoincs",b);
        return expListReszlet;
    }
}
