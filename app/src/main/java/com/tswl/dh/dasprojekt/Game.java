package com.tswl.dh.dasprojekt;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Game extends AppCompatActivity {

    int[] position = {4 ,5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        final int rows = 7;
        final int columns = 15;

        createTable(rows, columns, position);


        final LinearLayout control = new LinearLayout(this);
        final LinearLayout linearLayout = (LinearLayout)findViewById(R.id.gametable);
        linearLayout.addView(control);
        control.setBackgroundColor(Color.BLUE);
        Button up = new Button(this);
        up.setText("UP");
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] position = getPosition();
                int[] newposition = {position[0] - 1, position[1]};
                setPosition(newposition);
                linearLayout.removeAllViews();
                createTable(rows, columns, newposition);
                linearLayout.addView(control);
            }
        });
        control.addView(up);

        Button right = new Button(this);
        right.setText("RIGHT");
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] position = getPosition();
                int[] newposition = {position[0], position[1] + 1};
                setPosition(newposition);
                linearLayout.removeAllViews();
                createTable(rows, columns, newposition);
                linearLayout.addView(control);
            }
        });
        control.addView(right);

        Button down = new Button(this);
        down.setText("DOWN");
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] position = getPosition();
                int[] newposition = {position[0] + 1, position[1]};
                setPosition(newposition);
                linearLayout.removeAllViews();
                createTable(rows, columns, newposition);
                linearLayout.addView(control);
            }
        });
        control.addView(down);

        Button left = new Button(this);
        left.setText("LEFT");
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] position = getPosition();
                int[] newposition = {position[0], position[1] - 1};
                setPosition(newposition);
                linearLayout.removeAllViews();
                createTable(rows, columns, newposition);
                linearLayout.addView(control);
            }
        });
        control.addView(left);



        LinearLayout.LayoutParams controlParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,0,.3f);
        control.setLayoutParams(controlParams);


    }

    public void createTable(int i,int j,int[] position){

        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.gametable);
        TableLayout tableLayout = new TableLayout(this);
        TableLayout.LayoutParams tableParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,0,.7f);
        tableLayout.setLayoutParams(tableParams);
        tableLayout.setBackgroundColor(Color.BLACK);

        for (Integer x = 0;x < i;x++){

            TableRow tableRow = new TableRow(this);
            tableRow.setGravity(Gravity.CENTER_HORIZONTAL);

            for (Integer y = 0;y < j;y++){

                ImageView imageView = new ImageView(this);

                imageView.setBackgroundResource(R.drawable.tilea2_00_00);

                if ((x==position[0])&&(y==position[1])){
                    imageView.setImageResource(R.drawable.vx_characters_0_0);
                }

                tableRow.addView(imageView);

            }

            tableLayout.addView(tableRow);
        }

        linearLayout.addView(tableLayout);


    }

    public int[] getPosition(){
        return position;
    }

    public void setPosition(int[] position){
        this.position = position;
    }

}
