package blacklinden.intentgyak;

import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import eszk.Számológép;
import frag.PPM;

public class TapActivity extends FragmentActivity {



    public static int index;
    String[] spn = {"Convert PPM.7","Convert PPM.5","Convert EC/mS","Convert EC uS"};
    //String[] actvv = {"White Widow","Tangerine","RílKila","White Dwarf"};
    EditText et;
    TextView hét;

    Button mButton3;
    private AutoCompleteTextView actv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.rotate,R.anim.translate);
        setContentView(R.layout.activity_tap);



         et = (EditText)findViewById(R.id.et);

        hét = (TextView)findViewById(R.id.hetek);



        Button gmb = (Button)findViewById(R.id.számolj);

        //actv = (AutoCompleteTextView) findViewById(R.id.seed);


      /*  Spinner spn1 = (Spinner)findViewById(R.id.spinner1);


        ArrayAdapter<String> adapt0 = new ArrayAdapter<String>(TapActivity.this,android.R.layout.simple_spinner_item,spn);
        adapt0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spn1.setAdapter(adapt0);*/



       /* ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.simple_list_item_1,actvv);
        actv.setAdapter(adapter);
        actv.setThreshold(1);

        actv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Számológép.mag=(String)parent.getItemAtPosition(position);
            }
        });*/



/*        gmb.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                beküldés();

            }
        });

        */

       /* spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Számológép.errőlerre=spn[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        */

        mButton3 = (Button) findViewById(R.id.button_3);
        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialogFragment bottomSheetDialogFragment = new PPM();
                bottomSheetDialogFragment.show(getSupportFragmentManager(), bottomSheetDialogFragment.getTag());
            }
        });




    }
    @Override
    protected void onPause()
    {
        super.onPause();
        //zárja a váltóanimot
        overridePendingTransition(R.anim.translate,R.anim.rotate);
    }
    @Override
    public void finish(){
       super.finish();
        overridePendingTransition(R.anim.translate,R.anim.rotate);
    }


    private void beküldés() {
        Számológép.érték=et.getText().toString();
        if (Számológép.érték != null) {
            hét.setText(Számológép.fogalmazó());
            Toast.makeText(TapActivity.this, "shibribupp", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(TapActivity.this, "pick seed", Toast.LENGTH_SHORT).show();
        }
    }
    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        }
    }

}
