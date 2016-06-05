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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//import com.basteldroid.framework.FileIO;

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


/*public class Settings {

    // Hier werden die Variablen erstellt, welche wir zum speichern benötigen

    public static boolean soundEnabled = true;
    public static int[] highscores = new int[]{1951, 800, 120, 75, 3};
    public static int currentLevel = 0;

    public static void save(FileIO files) {
        BufferedWriter out = null;
        try {

            // Erstellt eine Datei auf der Speicherkarte .savedata
            out = new BufferedWriter(new OutputStreamWriter(
                    files.writeFile(".savedata")));

            // Zeile bei Zeile, wird jeder Wert jeder Variable in der Datei gespeichert
            // "\n" erstellt eine neue Zeile
            out.write(Boolean.toString(soundEnabled));
            out.write("\n");

            out.write(Integer.toString(currentLevel));
            out.write("\n");

            // Benutzt eine For Schleife um 5 Nummern zur Datei hinzu zufügen
            for (int i = 0; i & lt; 5 ;
            i++){
                out.write(Integer.toString(highscores[i]));
                out.write("\n");
            }

            // Hier werden Fehler beim Dateisystem gehandhabt

        } catch (IOException e) {
        } finally {
            try {
                if (out != null)
                    out.close();
            } catch (IOException e) {
            }
        }
    }

    public static void load(FileIO files) {
        BufferedReader in = null;
        try {
            // liest die Datei .savedata
            in = new BufferedReader(new InputStreamReader(
                    files.readFile(".savedata")));

            // Lädt die Werte der Variablen und ersetzt die Standartwerte
            soundEnabled = Boolean.parseBoolean(in.readLine());
            currentLevel = Integer.parseInt(in.readLine());

            // Benutzt eine For Schleife um die 5 Zahlen der Highscore zu ersetzen
            for (int i = 0; i & lt; 5 ;
            i++){
                highscores[i] = Integer.parseInt(in.readLine());
            }

        } catch (IOException e) {

        } catch (NumberFormatException e) {

        } finally {
            try {
                if (in != null)
                    in.close();
            } catch (IOException e) {
            }
        }
    }

    // Benutzt diese Methode um die 5 Zahlen der Highscore zu ersetzen
    public static void addScore(int score) {
        for (int i = 0; i & lt; 5 ;
        i++){
            if ( highscores[i] & lt;
            score){
                for (int j = 4; j & gt; i ;
                j--)
                highscores[j] = highscores[j - 1];
                highscores[i] = score;
                break;
            }
        }
    }
}
*/