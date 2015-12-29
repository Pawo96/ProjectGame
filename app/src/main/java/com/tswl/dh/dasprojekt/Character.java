package com.tswl.dh.dasprojekt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Character extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);

        Logic character = new Logic();

        TableLayout table = new TableLayout(this);


        TableRow tR1 = new TableRow(this);
        TextView t1 = new TextView(this);
        TextView t2 = new TextView(this);
        t1.setText("Name:");
        t2.setText(character.getPlayerName());
        tR1.addView(t1);
        tR1.addView(t2);
        table.addView(tR1);

        TableRow tR2 = new TableRow(this);
        TextView t3 = new TextView(this);
        TextView t4 = new TextView(this);
        t3.setText("Attack:");
        t4.setText(Integer.toString(character.getPlayerAttack()));
        tR2.addView(t3);
        tR2.addView(t4);
        table.addView(tR2);

        TableRow tR3 = new TableRow(this);
        TextView t5 = new TextView(this);
        TextView t6 = new TextView(this);
        t5.setText("Defense:");
        t6.setText(Integer.toString(character.getPlayerDefense()));
        tR3.addView(t5);
        tR3.addView(t6);
        table.addView(tR3);

        TableRow tR4 = new TableRow(this);
        TextView t7 = new TextView(this);
        TextView t8 = new TextView(this);
        t7.setText("Mind:");
        t8.setText(Integer.toString(character.getPlayerMind()));
        tR4.addView(t7);
        tR4.addView(t8);
        table.addView(tR4);

        TableRow tR5 = new TableRow(this);
        TextView t9 = new TextView(this);
        TextView t10 = new TextView(this);
        t9.setText("Speed:");
        t10.setText(Integer.toString(character.getPlayerSpeed()));
        tR5.addView(t9);
        tR5.addView(t10);
        table.addView(tR5);

        TableRow tR6 = new TableRow(this);
        TextView t11 = new TextView(this);
        TextView t12 = new TextView(this);
        t11.setText("HP:");
        t12.setText(Integer.toString(character.getPlayerHP()));
        tR6.addView(t11);
        tR6.addView(t12);
        table.addView(tR6);

        TableRow tR7 = new TableRow(this);
        TextView t13 = new TextView(this);
        TextView t14 = new TextView(this);
        t13.setText("Max_HP:");
        t14.setText(Integer.toString(character.getPlayerMaxHP()));
        tR7.addView(t13);
        tR7.addView(t14);
        table.addView(tR7);


        TableRow tR8 = new TableRow(this);
        TextView t15 = new TextView(this);
        TextView t16 = new TextView(this);
        t15.setText("MP:");
        t16.setText(Integer.toString(character.getPlayerMP()));
        tR8.addView(t15);
        tR8.addView(t16);
        table.addView(tR8);

        TableRow tR9 = new TableRow(this);
        TextView t17 = new TextView(this);
        TextView t18 = new TextView(this);
        t17.setText("Max_MP:");
        t18.setText(Integer.toString(character.getPlayerMaxMP()));
        tR9.addView(t17);
        tR9.addView(t18);
        table.addView(tR9);

        setContentView(table);

    }

    public void gohome(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
