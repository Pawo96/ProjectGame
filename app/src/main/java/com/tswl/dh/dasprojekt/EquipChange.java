package com.tswl.dh.dasprojekt;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class EquipChange extends AppCompatActivity {

    private ImageView image;
    private String[] states;
    private Spinner spinner;
    protected TypedArray imgs;
    public int attack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equip_change);

        Spinner sw = (Spinner)findViewById(R.id.spinnerweapon);

        sw.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView tW1 = (TextView) findViewById(R.id.weapon1);
                tW1.setText("Attack:");
                TextView tW2 = (TextView) findViewById(R.id.weapon2);
                TextView tW3 = (TextView) findViewById(R.id.weapon3);
                tW3.setText("Defense:");
                TextView tW4 = (TextView) findViewById(R.id.weapon4);
                TextView tW5 = (TextView) findViewById(R.id.weapon5);
                tW5.setText("Mind:");
                TextView tW6 = (TextView) findViewById(R.id.weapon6);
                TextView tW7 = (TextView) findViewById(R.id.weapon7);
                tW7.setText("Speed:");
                TextView tW8 = (TextView) findViewById(R.id.weapon8);
                TextView tW9 = (TextView) findViewById(R.id.weapon9);
                tW9.setText("Max HP:");
                TextView tW10 = (TextView) findViewById(R.id.weapon10);
                TextView tW11 = (TextView) findViewById(R.id.weapon11);
                tW11.setText("Max MP:");
                TextView tW12 = (TextView) findViewById(R.id.weapon12);

                if (parent.getSelectedItem().toString().equals("Axe")) {
                    tW2.setText(Integer.toString(5));
                    tW4.setText(Integer.toString(5));
                    tW6.setText(Integer.toString(0));
                    tW8.setText(Integer.toString(1));
                    tW10.setText(Integer.toString(20));
                    tW12.setText(Integer.toString(0));
                }

                if (parent.getSelectedItem().toString().equals("Staff")) {
                    tW2.setText(Integer.toString(1));
                    tW4.setText(Integer.toString(2));
                    tW6.setText(Integer.toString(5));
                    tW8.setText(Integer.toString(4));
                    tW10.setText(Integer.toString(0));
                    tW12.setText(Integer.toString(20));
                }

                if (parent.getSelectedItem().toString().equals("Sword")) {
                    tW2.setText(Integer.toString(4));
                    tW4.setText(Integer.toString(4));
                    tW6.setText(Integer.toString(0));
                    tW8.setText(Integer.toString(4));
                    tW10.setText(Integer.toString(10));
                    tW12.setText(Integer.toString(0));
                }

                if (parent.getSelectedItem().toString().equals("none")) {
                    tW2.setText(Integer.toString(0));
                    tW4.setText(Integer.toString(0));
                    tW6.setText(Integer.toString(0));
                    tW8.setText(Integer.toString(0));
                    tW10.setText(Integer.toString(0));
                    tW12.setText(Integer.toString(0));
                }

                Toast.makeText(EquipChange.this, parent.getSelectedItem().toString() + " equiped", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Spinner sa = (Spinner)findViewById(R.id.spinnerarmor);

        sa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView tA1 = (TextView) findViewById(R.id.armor1);
                tA1.setText("Attack:");
                TextView tA2 = (TextView) findViewById(R.id.armor2);
                TextView tA3 = (TextView) findViewById(R.id.armor3);
                tA3.setText("Defense:");
                TextView tA4 = (TextView) findViewById(R.id.armor4);
                TextView tA5 = (TextView) findViewById(R.id.armor5);
                tA5.setText("Mind:");
                TextView tA6 = (TextView) findViewById(R.id.armor6);
                TextView tA7 = (TextView) findViewById(R.id.armor7);
                tA7.setText("Speed:");
                TextView tA8 = (TextView) findViewById(R.id.armor8);
                TextView tA9 = (TextView) findViewById(R.id.armor9);
                tA9.setText("Max HP:");
                TextView tA10 = (TextView) findViewById(R.id.armor10);
                TextView tA11 = (TextView) findViewById(R.id.armor11);
                tA11.setText("Max MP:");
                TextView tA12 = (TextView) findViewById(R.id.armor12);

                if (parent.getSelectedItem().toString().equals("Plate Armor")) {
                    tA2.setText(Integer.toString(5));
                    tA4.setText(Integer.toString(20));
                    tA6.setText(Integer.toString(0));
                    tA8.setText(Integer.toString(0));
                    tA10.setText(Integer.toString(20));
                    tA12.setText(Integer.toString(0));
                }

                if (parent.getSelectedItem().toString().equals("Cloth Robe")) {
                    tA2.setText(Integer.toString(0));
                    tA4.setText(Integer.toString(6));
                    tA6.setText(Integer.toString(20));
                    tA8.setText(Integer.toString(10));
                    tA10.setText(Integer.toString(5));
                    tA12.setText(Integer.toString(30));
                }

                if (parent.getSelectedItem().toString().equals("Leather Armor")) {
                    tA2.setText(Integer.toString(3));
                    tA4.setText(Integer.toString(13));
                    tA6.setText(Integer.toString(0));
                    tA8.setText(Integer.toString(10));
                    tA10.setText(Integer.toString(10));
                    tA12.setText(Integer.toString(0));
                }

                if (parent.getSelectedItem().toString().equals("none")) {
                    tA2.setText(Integer.toString(0));
                    tA4.setText(Integer.toString(0));
                    tA6.setText(Integer.toString(0));
                    tA8.setText(Integer.toString(0));
                    tA10.setText(Integer.toString(0));
                    tA12.setText(Integer.toString(0));
                }

                Toast.makeText(EquipChange.this, parent.getSelectedItem().toString() + " equiped", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        Spinner sb = (Spinner)findViewById(R.id.spinnerboot);

        sb.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView tB1 = (TextView) findViewById(R.id.boot1);
                tB1.setText("Attack:");
                TextView tB2 = (TextView) findViewById(R.id.boot2);
                TextView tB3 = (TextView) findViewById(R.id.boot3);
                tB3.setText("Defense:");
                TextView tB4 = (TextView) findViewById(R.id.boot4);
                TextView tB5 = (TextView) findViewById(R.id.boot5);
                tB5.setText("Mind:");
                TextView tB6 = (TextView) findViewById(R.id.boot6);
                TextView tB7 = (TextView) findViewById(R.id.boot7);
                tB7.setText("Speed:");
                TextView tB8 = (TextView) findViewById(R.id.boot8);
                TextView tB9 = (TextView) findViewById(R.id.boot9);
                tB9.setText("Max HP:");
                TextView tB10 = (TextView) findViewById(R.id.boot10);
                TextView tB11 = (TextView) findViewById(R.id.boot11);
                tB11.setText("Max MP:");
                TextView tB12 = (TextView) findViewById(R.id.boot12);

                if (parent.getSelectedItem().toString().equals("Plate Boot")) {
                    tB2.setText(Integer.toString(1));
                    tB4.setText(Integer.toString(3));
                    tB6.setText(Integer.toString(0));
                    tB8.setText(Integer.toString(0));
                    tB10.setText(Integer.toString(3));
                    tB12.setText(Integer.toString(0));
                }

                if (parent.getSelectedItem().toString().equals("Cloth Boot")) {
                    tB2.setText(Integer.toString(0));
                    tB4.setText(Integer.toString(1));
                    tB6.setText(Integer.toString(1));
                    tB8.setText(Integer.toString(2));
                    tB10.setText(Integer.toString(1));
                    tB12.setText(Integer.toString(2));
                }

                if (parent.getSelectedItem().toString().equals("Leather Boot")) {
                    tB2.setText(Integer.toString(2));
                    tB4.setText(Integer.toString(2));
                    tB6.setText(Integer.toString(0));
                    tB8.setText(Integer.toString(1));
                    tB10.setText(Integer.toString(1));
                    tB12.setText(Integer.toString(0));
                }

                if (parent.getSelectedItem().toString().equals("none")) {
                    tB2.setText(Integer.toString(0));
                    tB4.setText(Integer.toString(0));
                    tB6.setText(Integer.toString(0));
                    tB8.setText(Integer.toString(0));
                    tB10.setText(Integer.toString(0));
                    tB12.setText(Integer.toString(0));
                }

                Toast.makeText(EquipChange.this, parent.getSelectedItem().toString() + " equiped", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });







    }
}