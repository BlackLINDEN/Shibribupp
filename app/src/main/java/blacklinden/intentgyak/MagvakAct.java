package blacklinden.intentgyak;

import android.app.Activity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

import eszk.GridAdapter;
import eszk.ImageItem;


/**
 * Created by Vitya on 2017. 11. 11..
 */

public class MagvakAct extends Activity {
    private GridView gridView;
    private GridAdapter gridAdapter;
    private String[]
            nevek={"AK47","Blueberry",
            "Cheese Autoflower","OG Kush",
            "Cindrella","Critical 47",
            "Moby Dick","Red Dwarf",
            "Real Killa Skunk","Tangerine Dream"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.magvactivity);

        gridView = (GridView) findViewById(R.id.gridview);
        gridAdapter = new GridAdapter(this, R.layout.grid_item, getData());
        gridView.setAdapter(gridAdapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                ImageItem item = (ImageItem) parent.getItemAtPosition(position);

                Intent intent = new Intent(getApplicationContext(), Magvak2Act.class);
                intent.putExtra("title", item.getTitle());



                startActivity(intent);}
        });

    }


    private ArrayList<ImageItem> getData() {
        final ArrayList<ImageItem> imageItems = new ArrayList<>();
        TypedArray imgs = getResources().obtainTypedArray(R.array.img);
        for (int i = 0; i < imgs.length(); i++) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(i, -1));
            imageItems.add(new ImageItem(bitmap, nevek[i]));
        }
        imgs.recycle();
        return imageItems;
    }
}