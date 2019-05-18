package com.example.hw2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;


import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuBuilder;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.text.method.KeyListener;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import android.support.design.widget.BottomNavigationView;
public class MainActivity extends AppCompatActivity  implements  BottomNavigationView.OnNavigationItemSelectedListener{
     EditText number;
    TextView l,l1,l2,l3;
    Object d="0";
boolean c1=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try{
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            l=findViewById  ( R.id.enter );
            l1=findViewById ( R.id.enter1);
            l2=findViewById ( R.id.enter2);
            l3=findViewById ( R.id.enter3);


            number=findViewById ( R.id.number );





            ActionBar m= getSupportActionBar ();
            m.setDisplayHomeAsUpEnabled ( true );
            BottomNavigationView  kk= findViewById ( R.id.bot1 );
            kk.setItemIconTintList ( null );

            kk.setOnNavigationItemSelectedListener ( this );



        }catch(Exception e){
            Log.i("yy",""+e);

        }
        number.addTextChangedListener ( new TextWatcher () {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }


            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                number.callOnClick();
                l.callOnClick();
                l1.callOnClick();
                l2.callOnClick();
                l3.callOnClick();
                if(number.getText ().toString ().isEmpty()){

                     l.setText(" ");
                    l1.setText(" ");
                    l2.setText(" ");
                    l3.setText(" ");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        } );

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        String s= number.getText ().toString ();
        if (menuItem.getItemId() == R.id.B){
            number.setKeyListener(DigitsKeyListener.getInstance("01"));
        }
       else if (menuItem.getItemId() == R.id.d) {
            number.setKeyListener(DigitsKeyListener.getInstance("0123456789"));
        }
        else if (menuItem.getItemId() == R.id.O) {
            number.setKeyListener(DigitsKeyListener.getInstance("01234567"));
        }
        else if (menuItem.getItemId() == R.id.H ) {
            number.setKeyListener(DigitsKeyListener.getInstance("0123456789abcdefABCDEF"));
        }



        if (menuItem.getItemId() == R.id.B && !s.isEmpty()) {

            d="1";
        l.setText(number.getText());
        l1.setText("" + Long.parseLong(String.valueOf(number.getText()), 2));
        l2.setText(Long.toOctalString(Long.parseLong(String.valueOf(number.getText()), 2)));
        l3.setText(Long.toHexString(Long.parseLong(String.valueOf(number.getText()), 2)));


    }

   else if (menuItem.getItemId() == R.id.d && !s.isEmpty()) {

        d = "2";
        if (d == "1")
            number.setText("" + Long.parseLong(String.valueOf(number.getText()), 2));
        else if (d == "3")
            number.setText("" + Long.parseLong(String.valueOf(number.getText()), 8));
        else if (d == "4")
            number.setText("" + Long.parseLong(String.valueOf(number.getText()), 16));

        l1.setText(number.getText());
        l.setText(Long.toBinaryString(Long.parseLong(String.valueOf(l1.getText()))));
        l2.setText(Long.toOctalString(Long.parseLong(String.valueOf(l.getText()), 2)));
        l3.setText(Long.toHexString(Long.parseLong(String.valueOf(l.getText()), 2)));
    }
    else if (menuItem.getItemId() == R.id.O && !s.isEmpty()) {

        d = "3";
        if (d == "1")
            number.setText(Long.toOctalString(Long.parseLong(String.valueOf(number.getText()), 2)));
        else if (d == "2")
            number.setText(Long.toOctalString(Long.parseLong(String.valueOf(number.getText()))));
        else if (d == "4")
            number.setText(Long.toOctalString(Long.parseLong(String.valueOf(number.getText()), 16)));

        l2.setText(number.getText());
        l.setText(Long.toBinaryString(Long.parseLong(String.valueOf(l2.getText()), 8)));
        l1.setText("" + Long.parseLong(String.valueOf(l.getText()), 2));
        l3.setText(Long.toHexString(Long.parseLong(String.valueOf(l.getText()), 2)));
    }
    else if (menuItem.getItemId() == R.id.H && !s.isEmpty()) {
        number.setKeyListener(DigitsKeyListener.getInstance("0123456789abcdefABCDEF"));
        d = "4";
        if (d == "1")
            number.setText(Long.toHexString(Long.parseLong(String.valueOf(number.getText()), 2)));
        else if (d == "2")
            number.setText(Long.toHexString(Long.parseLong(String.valueOf(number.getText()))));
        else if (d == "3")
            number.setText(Long.toHexString(Long.parseLong(String.valueOf(number.getText()), 8)));

        l3.setText(number.getText());
        l.setText(Long.toBinaryString(Long.parseLong(String.valueOf(l3.getText()), 16)));
        l2.setText(Long.toOctalString(Long.parseLong(String.valueOf(l.getText()), 2)));
        l1.setText("" + Long.parseLong(String.valueOf(l.getText()), 2));
    }

    if (menuItem.getItemId() == R.id.B && s.isEmpty()) {
        number.setHint("Binary");

    }
    else if (menuItem.getItemId() == R.id.d && s.isEmpty()) {
        number.setHint("Decimal ");
    }
   else if (menuItem.getItemId() == R.id.O && s.isEmpty()) {
        number.setHint("Octal  ");
    }
    else if (menuItem.getItemId() == R.id.H && s.isEmpty()) {
        number.setHint("Hexadecimal ");
    }


return true;
    }


}
