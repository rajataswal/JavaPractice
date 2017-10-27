package com.example.rajataswal.fruits;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TableLayout;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static com.example.rajataswal.fruits.R.id.wrap_content;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    Button addB;String strA= new String();String[] split= new String[500];int gid=0;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //deleteFile("myfile");
        try {
            FileInputStream fileInput = openFileInput("myfile");
            Log.w("taggg","inside try bolock of input stream");

            // String aaa = fileInput.toString();
            // Log.w("tagggPrint aaa",String.valueOf(aaa));///check after lunch
            int a;
            while ((a = fileInput.read()) != -1) {
                // convert to char and display it
                Log.w("taggg","inside reading character by character");

                strA = strA + (char) a;
                Log.w("taggg strA=",strA);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.w("taggg","inside catch bolock of input stream");

        } catch (IOException e) {
            e.printStackTrace();
            Log.w("taggg","inside catch bolock of ioexeception stream");

        }
        //setting on click listner on button present in xml file
        addB = (Button) findViewById(R.id.button);
        addB.setOnClickListener(this);
        //--------------

        //below block will display all the check boxes according to strA
        {
            TableLayout TL = (TableLayout) findViewById(R.id.tableLL);
            //LinearLayout LL = (LinearLayout) findViewById(R.id.linear);
            //LL.setBackgroundColor(Color.BLACK);this done in xml file
            CheckBox checkbox;
            // strA = "_rajat_aswal_star";
            split = strA.split("_#");
            Log.w("taggg", "split length=" + split.length);

            for (int i = 1; i < split.length; i++) {
                checkbox = new CheckBox(getApplicationContext());

                if (split[i] == "") {
                    //do nothing
                } else {
                    checkbox.setText(split[i]);
                    //checkbox.setOnClickListener(this);
                    checkbox.setId(++gid);
                    checkbox.setOnCheckedChangeListener(this);
                    TL.addView(checkbox);
                }
            }
        }
        //-----------


    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //here code to save the CBarr and i will come
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput("myfile", Context.MODE_PRIVATE);
            outputStream.write(strA.getBytes());
            outputStream.close();
            Log.w("taggg","in tryblock of saving file");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.button:

                EditText ed1 = (EditText) findViewById(R.id.editText);

                Log.w("taggg", String.valueOf(ed1.getText()));
                strA = strA + "_#" + String.valueOf(ed1.getText());
                Log.w("taggg", strA);


                //LinearLayout LL = (LinearLayout) findViewById(R.id.linear);
                TableLayout TL = (TableLayout) findViewById(R.id.tableLL);
                CheckBox checkbox2 = new CheckBox(getApplicationContext());

                checkbox2.setText(String.valueOf(ed1.getText()));
                checkbox2.setId(++gid);
                checkbox2.setOnCheckedChangeListener(this);
                //LL.addView(checkbox2);
                TL.addView(checkbox2);
                ed1.setText("");
                break;

        }
    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

        CheckBox cb = (CheckBox) findViewById(compoundButton.getId());
        if(cb.isChecked()){
            //cb.setVisibility(View.GONE);
            cb.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            Log.w("taggg","in default switch");

            String seqToDel = (String) cb.getText();
            Log.w("taggg seq to del", seqToDel);
            String[] split=strA.split("_#");

            int k=0;
            strA = "";
            for (int i=1 ; i < split.length ; i++){
                if(seqToDel.equals(split[i]) && k !=1) {
                    split[i]= null;k=1;
                }
                else
                    strA = strA + "_#" + split[i];
            }
        }

    }
}
