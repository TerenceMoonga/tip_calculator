package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    private EditText enterendBill;
    private SeekBar myseekbar;
    private TextView seekbartvshow;
    private Button tipbuttonfinder;
    private TextView tipvaluetv;
    private TextView totaltipvaluetv;
    //variables used in the function mathematicals are below
    private float billpercentage;
    private float billfloat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enterendBill=(EditText)findViewById(R.id.enterBillid);
        myseekbar=(SeekBar)findViewById(R.id.seekBarID);
        seekbartvshow=(TextView)findViewById(R.id.seekbarreadTvID);
        tipbuttonfinder=(Button)findViewById(R.id.tipcalcButtonID);
        tipvaluetv=(TextView)findViewById(R.id.tipTvID);
        totaltipvaluetv=(TextView)findViewById(R.id.totaltipvalueID);
        tipbuttonfinder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tipfunction();

            }
        });
        myseekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                seekbartvshow.setText(String.valueOf(myseekbar.getProgress()+"%") );
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
              billpercentage=myseekbar.getProgress();
            }
        });
    }
    public void Tipfunction(){
        if(!enterendBill.getText().toString().equals("")){
            //resultipval is a variable created to store the value of the calculation for the tip
            float resultipval= 0.0f;
            float TotaltipResult=0.0f;
            billfloat=Float.parseFloat(enterendBill.getText().toString());
            resultipval= billpercentage *billfloat/100;
            tipvaluetv.setText("your tip is:"+" "+"K"+String.valueOf(resultipval));
            //   TotaltipResult is a variable created to store the value of the calculation for the total tip
            TotaltipResult=billfloat + resultipval;
            totaltipvaluetv.setText("Total Bill Is:"+" "+"K"+String.valueOf(TotaltipResult));
        }else{
            Toast.makeText(MainActivity.this,"Please Enter The Bill Amount",Toast.LENGTH_LONG).show();
        }


    }

}