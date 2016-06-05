package com.tswl.dh.dasprojekt;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
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

    String text1;
    String text2;

    int felder_hoch;
    int felder_rechts;

    int felder_hoch_pos = (int)Math.floor((position[0] + 1) / 6)+1;
    int felder_rechts_pos = (int)Math.floor((position[1] + 1) / 14)+1;

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

        felder_hoch = (int)Math.floor((rows1+1)/6);
        felder_rechts = (int)Math.floor(columns1 + 1)/14;

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
        control.setBackgroundColor(Color.DKGRAY);
        ImageButton up = new ImageButton(this);
        up.setX(5);
        up.setY(5);
        up.setImageResource(R.drawable.arrow_up);
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] position = getPosition();
                if (position[0] - 1 >= 0 && feld2[(position[0] - 1) * (columns1) + position[1]].equals("a")) {
                    int[] newposition = {position[0] - 1, position[1]};
                    if ((newposition[0] == (getFelder_hoch_pos() - 1) * 7 - 1) && (getFelder_hoch_pos() != 1)) {
                        setFelder_hoch_pos(getFelder_hoch_pos() - 1);
                    }
                    setPosition(newposition);

                }

                linearLayout.removeAllViews();
                createTable(rows1, columns1, "up", feld1, feld2);
                linearLayout.addView(control);
            }
        });


        ImageButton right = new ImageButton(this);
        right.setImageResource(R.drawable.arrow_right);
        right.setX(-155);
        right.setY(75);
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] position = getPosition();
                if (position[1] + 1 < columns1 && feld2[(position[0]) * (columns1) + position[1] + 1].equals("a")) {
                    int[] newposition = {position[0], position[1] + 1};
                    if (newposition[1] == getFelder_rechts_pos() * 15) {
                        setFelder_rechts_pos(getFelder_rechts_pos() + 1);
                    }
                    setPosition(newposition);
                }

                linearLayout.removeAllViews();
                createTable(rows1, columns1, "right", feld1, feld2);
                linearLayout.addView(control);
            }
        });


        ImageButton down = new ImageButton(this);
        down.setImageResource(R.drawable.arrow_down);
        down.setX(-161);
        down.setY(155);
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] position = getPosition();
                if (position[0] + 1 < rows1 && feld2[(position[0] + 1) * (columns1) + position[1]].equals("a")) {
                    int[] newposition = {position[0] + 1, position[1]};
                    if ((newposition[0] == getFelder_hoch_pos() * 7)) {
                        setFelder_hoch_pos(getFelder_hoch_pos() + 1);
                    }

                    setPosition(newposition);
                }

                linearLayout.removeAllViews();
                createTable(rows1, columns1, "down", feld1, feld2);
                linearLayout.addView(control);
            }
        });


        ImageButton left = new ImageButton(this);
        left.setImageResource(R.drawable.arrow_left);
        left.setY(75);
        left.setX(5);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] position = getPosition();
                if (position[1] - 1 >= 0 && feld2[(position[0]) * (columns1) + position[1] - 1].equals("a")) {
                    int[] newposition = {position[0], position[1] - 1};
                    if (newposition[1] == (getFelder_rechts_pos() - 1) * 15 - 1) {
                        setFelder_rechts_pos(getFelder_rechts_pos() - 1);
                    }
                    setPosition(newposition);
                }


                linearLayout.removeAllViews();
                createTable(rows1, columns1, "left", feld1, feld2);
                linearLayout.addView(control);
            }
        });
        control.addView(left);
        control.addView(up);
        control.addView(down);
        control.addView(right);

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
        linearLayout.setBackgroundColor(Color.BLACK);

        TableLayout tableLayout = new TableLayout(this);
        TableLayout.LayoutParams tableParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, 0, .7f);
        tableLayout.setLayoutParams(tableParams);
        tableLayout.setBackgroundColor(Color.BLACK);
        int[]pos = getPosition();

        int sollx;
        int solly;


        if(i1+felder_hoch-1 >= felder_hoch_pos*7) {sollx = 7;}
        else {sollx = felder_hoch_pos*7 - i1 - 5;}

        if(j1+felder_rechts-1 >= felder_rechts_pos*15) {solly = 15;}
        else { solly = felder_rechts_pos*15 - j1 - 13;}



        for (int x = 0;x < sollx;x++){

            TableRow tableRow = new TableRow(this);
            tableRow.setGravity(Gravity.CENTER_HORIZONTAL);

            for (int y = 0;y < solly;y++){
                ImageView imageView = new ImageView(this);

                if(feld1[((felder_hoch_pos-1)*7+x)*j1+y+(felder_rechts_pos-1)*15].equals("tilea2_00_00")){
                    imageView.setBackgroundResource(R.drawable.tilea2_00_00);
                }
                else if(feld1[((felder_hoch_pos-1)*7+x)*j1+y+(felder_rechts_pos-1)*15].equals("tilea1_00_00")){
                    imageView.setBackgroundResource(R.drawable.tilea1_00_00);
                }
                else if(feld1[((felder_hoch_pos-1)*7+x)*j1+y+(felder_rechts_pos-1)*15].equals("weg_links")){
                    imageView.setBackgroundResource(R.drawable.weg_links);
                }
                else if(feld1[((felder_hoch_pos-1)*7+x)*j1+y+(felder_rechts_pos-1)*15].equals("weg_links_oben")){
                    imageView.setBackgroundResource(R.drawable.weg_links_oben);
                }
                else if(feld1[((felder_hoch_pos-1)*7+x)*j1+y+(felder_rechts_pos-1)*15].equals("weg_links_unten")){
                    imageView.setBackgroundResource(R.drawable.weg_links_unten);
                }
                else if(feld1[((felder_hoch_pos-1)*7+x)*j1+y+(felder_rechts_pos-1)*15].equals("weg_oben")){
                    imageView.setBackgroundResource(R.drawable.weg_oben);
                }
                else if(feld1[((felder_hoch_pos-1)*7+x)*j1+y+(felder_rechts_pos-1)*15].equals("weg_rechts")){
                    imageView.setBackgroundResource(R.drawable.weg_rechts);
                }
                else if(feld1[((felder_hoch_pos-1)*7+x)*j1+y+(felder_rechts_pos-1)*15].equals("weg_rechts_oben")){
                    imageView.setBackgroundResource(R.drawable.weg_rechts_oben);
                }
                else if(feld1[((felder_hoch_pos-1)*7+x)*j1+y+(felder_rechts_pos-1)*15].equals("weg_rechts_unten")){
                    imageView.setBackgroundResource(R.drawable.weg_rechts_unten);
                }
                else if(feld1[((felder_hoch_pos-1)*7+x)*j1+y+(felder_rechts_pos-1)*15].equals("weg_unten")){
                    imageView.setBackgroundResource(R.drawable.weg_unten);
                }
                else if(feld1[((felder_hoch_pos-1)*7+x)*j1+y+(felder_rechts_pos-1)*15].equals("weg_voll")){
                    imageView.setBackgroundResource(R.drawable.weg_voll);
                }
                else if(feld1[((felder_hoch_pos-1)*7+x)*j1+y+(felder_rechts_pos-1)*15].equals("blume")){
                    imageView.setBackgroundResource(R.drawable.blume);
                }
                if(feld2[((felder_hoch_pos-1)*7+x)*j1+y+(felder_rechts_pos-1)*15].equals("dach")){
                    imageView.setBackgroundResource(R.drawable.dach);
                }
                else if(feld2[((felder_hoch_pos-1)*7+x)*j1+y+(felder_rechts_pos-1)*15].equals("wand")){
                    imageView.setBackgroundResource(R.drawable.wand);
                }
                else if(feld2[((felder_hoch_pos-1)*7+x)*j1+y+(felder_rechts_pos-1)*15].equals("loch")){
                    imageView.setBackgroundResource(R.drawable.loch);
                }
                if(feld2[((felder_hoch_pos-1)*7+x)*j1+y+(felder_rechts_pos-1)*15].equals("tilea2_08_03")){
                    imageView.setImageResource(R.drawable.tilea2_08_03);
                }
                if(feld2[((felder_hoch_pos-1)*7+x)*j1+y+(felder_rechts_pos-1)*15].equals("baum_multi")){
                    imageView.setImageResource(R.drawable.baum_multi);
                }
                if(feld2[((felder_hoch_pos-1)*7+x)*j1+y+(felder_rechts_pos-1)*15].equals("baum_oben")){
                    imageView.setImageResource(R.drawable.baum_oben);
                }
                if(feld2[((felder_hoch_pos-1)*7+x)*j1+y+(felder_rechts_pos-1)*15].equals("baum_unten")){
                    imageView.setImageResource(R.drawable.baum_unten);
                }
                if(feld2[((felder_hoch_pos-1)*7+x)*j1+y+(felder_rechts_pos-1)*15].equals("busch")){
                    imageView.setImageResource(R.drawable.busch);
                }




                if (((getFelder_hoch_pos()-1)*7+x==pos[0])&&((felder_rechts_pos-1)*15+y==pos[1])){
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

    public int getFelder_hoch_pos(){
        return felder_hoch_pos;
    }

    public  void setFelder_hoch_pos(int fhp){
        felder_hoch_pos = fhp;
    }

    public int getFelder_rechts_pos(){
        return felder_rechts_pos;
    }

    public  void setFelder_rechts_pos(int frp){
        felder_rechts_pos = frp;
    }

    public void setPosition(int[] position){
        this.position = position;
        //felder_hoch_pos = (int)Math.floor((position[0] + 1) / 6)+1;
        //felder_rechts_pos = (int)Math.floor((position[1] + 1) / 14)+1;

    }

    public int[] extendArraySize(int[] array){
        int[] temp = array.clone();
        array = new int[array.length + 1];
        System.arraycopy(temp, 0, array, 0, temp.length);
        return array;
    }



}
