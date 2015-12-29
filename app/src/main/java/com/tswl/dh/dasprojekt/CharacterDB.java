package com.tswl.dh.dasprojekt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import javax.net.ssl.HttpsURLConnection;

public class CharacterDB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String player_name = "Player1";
        String method = "char";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_db);

        BackgroundTask backgroundTask = new BackgroundTask(this);
        try {
            String text = backgroundTask.execute(method, player_name).get();
            TextView tv = new TextView(this);
            tv.setText(text);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }



    }
}
