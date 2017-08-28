package com.example.rajataswal.fruits;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
CheckBox CBarr;Button addB;String strA= new String();
int i=0;
//View v1 = (View) R.layout.activity_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(strA.isEmpty()){
            //do nothing
        }

        addB = (Button) findViewById(R.id.button);

        addB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText t1 = new EditText(this);
                t1 = (EditText) findViewById(R.id.editText));
                strA = strA+"*"+t1.getText();
                if(strA == "*"){
                    //do nothing
                }
                else {
                    String[] split = strA.split("*");
                    for( int j =0 ; j < split.length ; j++){

                    }
                }

            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

        //here code to save the CBarr and i will come
    }
}
