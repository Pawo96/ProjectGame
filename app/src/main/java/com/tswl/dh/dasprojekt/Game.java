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

import java.util.Arrays;
import java.util.concurrent.ExecutionException;

public class Game extends AppCompatActivity {

    int[] position = {4 ,5};
    int[] map1 = new int[1];
    int[] map2 = new int[1];
    String[] feld1 = new String[1];
    String[] feld2 = new String[1];
    int rows1;
    int rows2;
    int columns1;
    int columns2;
    int n = 1;

    double felder_hoch = Math.floor((rows1+1)/6);
    double felder_rechts = Math.floor(columns1+1)/14;

    double felder_hoch_pos = Math.floor((position[0]+1)/6)+1;
    double felder_rechts_pos = Math.floor((position[1]+1)/14)+1;

    String text1;
    String text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        //Datenbankverbindung
        BackgroundTask backgroundTask1 = new BackgroundTask(this);
        BackgroundTask backgroundTask2 = new BackgroundTask(this);
        try {
            text1 = backgroundTask1.execute("map", "A").get();
            text2 = backgroundTask2.execute("map", "B").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //Stringhandling
        map1[0]=0;
        for(int i = 0;i < text1.length();i++){
            if(text1.charAt(i) == ';'){map1=extendArraySize(map1);map1[n]=i;n++;}
        }

        rows1 = Integer.parseInt(text1.substring(map1[0]+1,map1[1]));
        columns1 = Integer.parseInt(text1.substring(map1[1]+1,map1[2]));

       for (int i = 0;i < map1.length-3; i++){
           feld1=Arrays.copyOf(feld1,feld1.length+1);
           feld1[i]=text1.substring(map1[i+2]+1,map1[i+3]);
        }

        n=1;


        //Stringhandling
        map2[0]=0;
        for(int i = 0;i < text2.length();i++){
            if(text2.charAt(i) == ';'){map2=extendArraySize(map2);map2[n]=i;n++;}
        }

        rows2 = Integer.parseInt(text2.substring(map2[0]+1,map2[1]));
        columns2 = Integer.parseInt(text2.substring(map2[1]+1,map2[2]));

        for (int i = 0;i < map2.length-3; i++){
            feld2=Arrays.copyOf(feld2,feld2.length+1);
            feld2[i]=text2.substring(map2[i+2]+1,map2[i+3]);
        }


        //Map erstellen
        createTable(rows1, columns1, "down", feld1, feld2);



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
                if (position[0] - 1 >= 0 && feld2[(position[0] - 1) * (columns1) + position[1]].equals("a")) {
                    int[] newposition = {position[0] - 1, position[1]};
                    if (newposition[0] == felder_hoch_pos * 6) {
                        felder_hoch_pos--;
                    }
                    setPosition(newposition);

                }

                linearLayout.removeAllViews();
                createTable(rows1, columns1, "up", feld1, feld2);
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
                if (position[1] + 1 < columns1 && feld2[(position[0]) * (columns1) + position[1] + 1].equals("a")) {
                    int[] newposition = {position[0], position[1] + 1};
                    if (newposition[1] == felder_rechts_pos * 14) {
                        felder_rechts_pos++;
                    }
                    setPosition(newposition);
                }

                linearLayout.removeAllViews();
                createTable(rows1, columns1, "right", feld1, feld2);
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
                if (position[0] + 1 < rows1 && feld2[(position[0] + 1) * (columns1) + position[1]].equals("a")) {
                    int[] newposition = {position[0] + 1, position[1]};
                    if (newposition[0] == felder_hoch_pos * 6) {
                        felder_hoch_pos++;
                    }

                    setPosition(newposition);
                }

                linearLayout.removeAllViews();
                createTable(rows1, columns1, "down", feld1, feld2);
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
                if (position[1] - 1 >= 0 && feld2[(position[0]) * (columns1) + position[1] - 1].equals("a")) {
                    int[] newposition = {position[0], position[1] - 1};
                    if (newposition[1] == felder_rechts_pos * 14) {
                        felder_rechts_pos--;
                    }
                    setPosition(newposition);
                }


                linearLayout.removeAllViews();
                createTable(rows1, columns1, "left", feld1, feld2);
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

    public void createTable(int i1, int j1,String dir,String[] feld1,String[] feld2){

        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.gametable);
        TableLayout tableLayout = new TableLayout(this);
        TableLayout.LayoutParams tableParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, 0, .7f);
        tableLayout.setLayoutParams(tableParams);
        tableLayout.setBackgroundColor(Color.BLACK);
        int[]pos = getPosition();

        for (int x = 0;x < i1 && x < 7;x++){

            TableRow tableRow = new TableRow(this);
            tableRow.setGravity(Gravity.CENTER_HORIZONTAL);

            for (int y = 0;y < j1 && y < 15;y++){
                ImageView imageView = new ImageView(this);

                if(feld1[(int)felder_hoch_pos*(x*j1)+(int)felder_rechts_pos*y].equals("tilea2_00_00")){
                    imageView.setBackgroundResource(R.drawable.tilea2_00_00);
                }
                else if(feld1[(int)felder_hoch_pos*(x*j1)+(int)felder_rechts_pos*y].equals("tilea1_00_00")){
                    imageView.setBackgroundResource(R.drawable.tilea1_00_00);
                }

                if(feld2[(int)felder_hoch_pos*(x*j1)+(int)felder_rechts_pos*y].equals("tilea3_02_02")){
                    imageView.setBackgroundResource(R.drawable.tilea3_02_02);
                }
                else if(feld2[(int)felder_hoch_pos*(x*j1)+(int)felder_rechts_pos*y].equals("tilea3_02_03")){
                    imageView.setBackgroundResource(R.drawable.tilea3_02_03);
                }
                else if(feld2[(int)felder_hoch_pos*(x*j1)+(int)felder_rechts_pos*y].equals("tilec_01_01")){
                    imageView.setBackgroundResource(R.drawable.tilec_01_01);
                }


                if(feld2[(int)felder_hoch_pos*(x*j1)+(int)felder_rechts_pos*y].equals("tilea2_08_03")){
                    imageView.setImageResource(R.drawable.tilea2_08_03);
                }




                if ((x==pos[0])&&(y==pos[1])){
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
