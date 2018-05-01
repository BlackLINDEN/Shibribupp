package blacklinden.intentgyak;

import android.app.Activity;
import android.graphics.Bitmap;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

import eszk.IO;
import eszk.URL;

public class Magvak2Act extends Activity implements BaseSliderView.OnSliderClickListener,ViewPagerEx.OnPageChangeListener {

    private String szöveg;
    private Bitmap kép;
    private TextView tv;
    private ImageView iv;
    private IO io;
    private SliderLayout sl;
    HashMap<String,String> hashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magvak2);

        sl = (SliderLayout)findViewById(R.id.slider);
        szöveg = getIntent().getStringExtra("title");

        hashMap = new HashMap<>();

        urlVálasztó();

        for(String név:hashMap.keySet()){
            TextSliderView tsv = new TextSliderView(Magvak2Act.this);
            tsv
                    .description(név)
                    .image(hashMap.get(név))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);
            tsv.bundle(new Bundle());
            tsv.getBundle().putString("extra",név);
            sl.addSlider(tsv);
        }
        sl.setPresetTransformer(SliderLayout.Transformer.DepthPage);
        sl.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sl.setDuration(3000);
        sl.addOnPageChangeListener(this);

        io = new IO();

        tv = (TextView) findViewById(R.id.szöveg);
       // iv = (ImageView) findViewById(R.id.kenderkép);




        kiválasztó(szöveg);
    }

    @Override
    protected void onStop(){
        sl.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView bsv){
        Toast.makeText(this,bsv.getBundle().get("extra")+"",Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int poz){
        Log.d("slider","lapozott: "+poz);
    }


    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void kiválasztó(String thong){
        switch (thong){
            case "kecskeszaros": tv.setText(io.io(this,"manifesto.txt"));
            break;
            case "szerb": tv.setText(io.io(this,"bluedream.txt"));
            break;
            default:  tv.setText(io.io_html(getString(R.string.html)));

        }
    }

    private void urlVálasztó(){
        if(szöveg.equalsIgnoreCase("AK47")) {
            hashMap.put("1", URL.AK47.url());
            hashMap.put("2", URL.AK47a.url());

        }else if(szöveg.equalsIgnoreCase("Blueberry")){
            hashMap.put("1", URL.BLUEBERRY.url());
            hashMap.put("2", URL.BLUEBERRYa.url());

        }else if(szöveg.equalsIgnoreCase("Cheese Autoflower")){
            hashMap.put("1", URL.CHEESE.url());
            hashMap.put("2", URL.CHEESEa.url());

        }else if(szöveg.equalsIgnoreCase("OG Kush")){
            hashMap.put("1", URL.KUSH.url());
            hashMap.put("2", URL.KUSHa.url());
            hashMap.put("3", URL.KUSHb.url());

        }else if(szöveg.equalsIgnoreCase("Cindrella")){
            hashMap.put("1", URL.CINDRELLA.url());

        }else if(szöveg.equalsIgnoreCase("Critical 47")){
            hashMap.put("1", URL.CRITICAL47.url());

        }else if(szöveg.equalsIgnoreCase("Moby Dick")){
            hashMap.put("1", URL.MOBYDICK.url());

        }else if(szöveg.equalsIgnoreCase("Red Dwarf")){
            hashMap.put("1", URL.REDDWARF.url());

        }else if(szöveg.equalsIgnoreCase("Real Killa Skunk")){
            hashMap.put("1", URL.RKS.url());
            hashMap.put("2", URL.RKSa.url());

        }else if(szöveg.equalsIgnoreCase("Tangerine Dream")){
            hashMap.put("1", URL.TANGERINE.url());
            hashMap.put("2", URL.TANGERINEa.url());
            hashMap.put("3", URL.TANGERINEb.url());
        }
    }



}
