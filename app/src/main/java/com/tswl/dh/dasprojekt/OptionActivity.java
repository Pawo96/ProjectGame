package com.tswl.dh.dasprojekt;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.SeekBar.OnSeekBarChangeListener;

import com.tswl.dh.dasprojekt.Settings;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class OptionActivity extends ActionBarActivity implements OnSeekBarChangeListener {
    private SeekBar seekBarTextSize, redSeekBarBG, greenSeekBarBG, blueSeekBarBG, redSeekBarTC, greenSeekBarTC, blueSeekBarTC;
    private int seekBG_R, seekBG_G, seekBG_B, seekTC_R, seekTC_G, seekTC_B;
    private TextView textView4, textView5, textView6;
    private LinearLayout mScreen;
    private static final String suffix_ser_object = "_object.bin";
    Settings person = new Settings();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);



        redSeekBarBG = (SeekBar) findViewById(R.id.seekBarBGColor_R);
        greenSeekBarBG = (SeekBar) findViewById(R.id.seekBarBGColor_G);
        blueSeekBarBG = (SeekBar) findViewById(R.id.seekBarBGColor_B);
        mScreen = (LinearLayout) findViewById(R.id.myScreen);
        textView4 = (TextView) findViewById(R.id.textViewValueRBG);
        textView5 = (TextView) findViewById(R.id.textViewValueGBG);
        textView6 = (TextView) findViewById(R.id.textViewValueBBG);
        redSeekBarBG.setOnSeekBarChangeListener(this);
        greenSeekBarBG.setOnSeekBarChangeListener(this);
        blueSeekBarBG.setOnSeekBarChangeListener(this);
        redSeekBarBG.setProgress(256);
        greenSeekBarBG.setProgress(256);
        blueSeekBarBG.setProgress(256);
        updateBackground();
    }

    private void updateBackground() {
        seekBG_R = redSeekBarBG.getProgress();
        seekBG_G = greenSeekBarBG.getProgress();
        seekBG_B = blueSeekBarBG.getProgress();
        mScreen.setBackgroundColor(
                0xff000000
                        + seekBG_R * 0x10000
                        + seekBG_G * 0x100
                        + seekBG_B
        );

    }

    public void onToggleClicked(View view) {

        boolean on = ((ToggleButton) view).isChecked();

        // Standardeinstellungen wie beim Starten der App
        if (on) {


            redSeekBarBG.setProgress(128);
            greenSeekBarBG.setProgress(128);
            blueSeekBarBG.setProgress(128);


            // Alternativeinstelllungen
        } else {


            redSeekBarBG.setProgress(0);
            greenSeekBarBG.setProgress(0);
            blueSeekBarBG.setProgress(0);

        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (seekBar.getId() == R.id.seekBarBGColor_R || seekBar.getId() == R.id.seekBarBGColor_G || seekBar.getId() == R.id.seekBarBGColor_B) {
            updateBackground();
        }

        textView4 = (TextView) findViewById(R.id.textViewValueRBG);
        textView5 = (TextView) findViewById(R.id.textViewValueGBG);
        textView6 = (TextView) findViewById(R.id.textViewValueBBG);


        textView4.setText("Rot(" + redSeekBarBG.getProgress() + ")");
        textView5.setText("Grün(" + greenSeekBarBG.getProgress() + ")");
        textView6.setText("Blau(" + blueSeekBarBG.getProgress() + ")");

    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generatFed method stub

    }


    public void onStopTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub

    }

    public void save(){

        person.redBG = redSeekBarBG.getProgress();
        person.blueBG = blueSeekBarBG.getProgress();
        person.greenBG = greenSeekBarBG.getProgress();
        //saveObject(person, "Data");




    }

    public void reset () {


        redSeekBarBG.setProgress(255);
        blueSeekBarBG.setProgress(255);
        greenSeekBarBG.setProgress(255);
        mScreen.setBackgroundColor(
                0xffffffff);

    }
    // Speichern eines Objects
    /*public void saveObject(Settings p, String filename) {
        try
        {
            ObjectOutputStream oos = new ObjectOutputStream(openFileOutput(filename + suffix_ser_object, Context.MODE_PRIVATE)); // Select where you wish to save the file...
            oos.writeObject(p); // write the class as an 'object'
            oos.flush(); // flush the stream to insure all of the information was written to 'save_object.bin'
            oos.close();// close the stream

        } catch (Exception ex)
        {
            Log.v("Serialization Save Error : ", ex.getMessage());
            ex.printStackTrace();
        }
    }

    // Laden eines Objekts
    public Settings loadSerializedObject(String filename)
    {
        Settings person = null;
        try
        {
            ObjectInputStream ois = new ObjectInputStream(openFileInput(filename + suffix_ser_object));
            Object o = ois.readObject();
            person = (Settings) o;

        } catch (Exception ex)
        {
            Log.v("Serialization Read Error : ", ex.getMessage());
            ex.printStackTrace();

        }
        return person;
    }*/

    public void gohome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}


