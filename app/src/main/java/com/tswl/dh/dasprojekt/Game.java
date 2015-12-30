package com.tswl.dh.dasprojekt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

public class Game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Integer rows = 5;
        Integer collums = 6;
        createTable(rows,collums);
    }

    public void createTable(Integer i,Integer j){

        TableLayout tableLayout = new TableLayout(this);

        for (Integer x = 0;x < i;x++){

            TableRow tableRow = new TableRow(this);

            for (Integer y = 0;y < j;y++){

                ImageView imageView = new ImageView(this);

                imageView.setBackgroundResource(R.drawable.tilea1_0_0);

                tableRow.addView(imageView);

            }

            tableLayout.addView(tableRow);
        }

        setContentView(tableLayout);



    }
}
