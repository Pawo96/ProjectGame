package com.tswl.dh.dasprojekt;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import android.widget.SeekBar;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import android.widget.LinearLayout;

public class ManageDataActivity extends ActionBarActivity {
    private Settings person = new Settings();
    private static final String suffix_ser_object = "_object.bin";
    //OptionActivity optionActivity = new OptionActivity();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_data);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }


    public void save(View v) {

        //Toast.makeText(getApplicationContext(), "Benutzerdefinierte Notiz wurde gespeichert",
                //Toast.LENGTH_LONG).show();
        Toast.makeText(ManageDataActivity.this, "Einstellungen wurden gespeichert", Toast.LENGTH_SHORT).show();


    }

    public void reset(View v) {



        Toast.makeText(ManageDataActivity.this, "Einstellungen wurden zurückgesetzt", Toast.LENGTH_SHORT).show();

    }

}

