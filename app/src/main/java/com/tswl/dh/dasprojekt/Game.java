package com.tswl.dh.dasprojekt;

import android.app.AlertDialog;
import android.content.Context;
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

import java.util.Arrays;
import java.util.concurrent.ExecutionException;

public class Game extends AppCompatActivity {

    int[] position = {4 ,5};
    int[] map = new int[1];
    String[] feld = new String[1];
    int rows;
    int columns;
    int n = 1;

    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        //Datenbankverbindung
        BackgroundTask backgroundTask = new BackgroundTask(this);
        try {
            text = backgroundTask.execute("map", "A").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //Stringhandling
        map[0]=0;
        for(int i = 0;i < text.length();i++){
            if(text.charAt(i) == ';'){map=extendArraySize(map);map[n]=i;n++;}
        }

        rows = Integer.parseInt(text.substring(map[0]+1,map[1]));
        columns = Integer.parseInt(text.substring(map[1]+1,map[2]));

       for (int i = 0;i < map.length-3; i++){
           feld=Arrays.copyOf(feld,feld.length+1);
           feld[i]=text.substring(map[i+2]+1,map[i+3]);
        }

        //Map erstellen
        createTable(rows, columns, position, "down",feld);


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
                createTable(rows, columns, newposition, "up",feld);
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
                createTable(rows, columns, newposition, "right",feld);
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
                createTable(rows, columns, newposition, "down",feld);
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
                createTable(rows, columns, newposition, "left",feld);
                linearLayout.addView(control);
            }
        });
        control.addView(left);

        Button b = new Button(this);
        b.setText("B");
        control.addView(b);

        Button a = new Button(this);
        a.setText("A");
        control.addView(a);



        LinearLayout.LayoutParams controlParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,0,.3f);
        control.setLayoutParams(controlParams);


    }

    public void createTable(int i,int j,int[] position,String dir,String[] feld){

        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.gametable);
        TableLayout tableLayout = new TableLayout(this);
        TableLayout.LayoutParams tableParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,0,.7f);
        tableLayout.setLayoutParams(tableParams);
        tableLayout.setBackgroundColor(Color.BLACK);

        for (int x = 0;x < i;x++){

            TableRow tableRow = new TableRow(this);
            tableRow.setGravity(Gravity.CENTER_HORIZONTAL);

            for (int y = 0;y < j;y++){
                ImageView imageView = new ImageView(this);

                if(feld[x*j+y].equals("tilea2_00_00")){
                    imageView.setBackgroundResource(R.drawable.tilea2_00_00);
                }
                else imageView.setBackgroundResource(R.drawable.tilea1_0_0);

                if ((x==position[0])&&(y==position[1])){
                    if(dir.equals("down")){
                        imageView.setImageResource(R.drawable.vx_characters_1_0);
                    }
                    else if (dir.equals("left")){
                        imageView.setImageResource(R.drawable.vx_characters_1_1);
                    }
                    else if (dir.equals("up")){
                        imageView.setImageResource(R.drawable.vx_characters_1_3);
                    }
                    else if (dir.equals("right")){
                        imageView.setImageResource(R.drawable.vx_characters_1_2);
                    }

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

    public int[] extendArraySize(int[] array){
        int[] temp = array.clone();
        array = new int[array.length + 1];
        System.arraycopy(temp, 0, array, 0, temp.length);
        return array;
    }



}
