package frag;

/**
 * Created by Vitya on 2017. 12. 28..
 */

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import blacklinden.intentgyak.R;
import eszk.Számológép;

public class PPM extends BottomSheetDialogFragment {
    String[] spn = {"Convert PPM.7","Convert PPM.5","Convert EC/mS","Convert EC uS"};
    EditText et;
    TextView hét;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @SuppressLint("RestrictedApi")
    @Override
    public void setupDialog(final Dialog dialog, int style) {
        super.setupDialog(dialog, style);
        View contentView = View.inflate(getContext(), R.layout.fragment_bottomsheet3, null);
        dialog.setContentView(contentView);

        et = (EditText)contentView.findViewById(R.id.et);

        hét = (TextView)contentView.findViewById(R.id.hetek);



        Button gmb = (Button)contentView.findViewById(R.id.számolj);

        Spinner spn1 = (Spinner)contentView.findViewById(R.id.spinner1);


        ArrayAdapter<String> adapt0 = new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_spinner_item,spn);
        adapt0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spn1.setAdapter(adapt0);


        gmb.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                beküldés();

            }
        });


        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Számológép.errőlerre=spn[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }



    private void beküldés() {

        Számológép.érték=et.getText().toString();

        if (!Számológép.érték.matches("")) {
            hét.setText(Számológép.fogalmazó());
            Toast.makeText(getActivity().getApplicationContext(), "shibribupp", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getActivity().getApplicationContext(), "pick seed", Toast.LENGTH_SHORT).show();
            et.setHintTextColor(Color.RED);
        }
    }
}
