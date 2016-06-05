package com.tswl.dh.dasprojekt;

import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import java.util.ArrayList;
import android.view.View;
import android.view.View.OnClickListener;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.GridView;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends Activity {

    MediaPlayer music;
    MediaPlayer click;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Typeface face=Typeface.createFromAsset(getAssets(),"fonts/immoral.ttf");
        TextView txtV = (TextView)findViewById(R.id.menuTitle);
        txtV.setTypeface(face);
        music = MediaPlayer.create(this, R.raw.menu);
        click = MediaPlayer.create(this, R.raw.click);
        Intent intent = getIntent();
        Integer position = intent.getIntExtra("position", 0);
        music.seekTo(position);
        music.start();
        music.setLooping(true);

    }

    public void showoption(View view) {
        Intent intent = new Intent(this, OptionActivity.class);
        click.start();
        intent.putExtra("position",music.getCurrentPosition());
        music.stop();
        startActivity(intent);
        finish();
    }

    public void showequipment(View view) {
        Intent intent = new Intent(this, EquipChange.class);
        click.start();
        music.stop();
        startActivity(intent);
        finish();
    }

    public void showcharacter(View view) {
        Intent intent = new Intent(this, CharacterDB.class);
        click.start();
        music.stop();
        startActivity(intent);
        finish();
    }

    public void showdata(View view) {
        Intent intent = new Intent(this, ManageDataActivity.class);
        click.start();
        music.stop();
        startActivity(intent);
        finish();
    }

    public void battle(View view) {
        Intent intent = new Intent(this, Battle.class);
        click.start();
        music.stop();
        startActivity(intent);
        finish();
    }

    public void play(View view) {
        Intent intent = new Intent(this, Game.class);
        click.start();
        music.stop();
        startActivity(intent);
        finish();
    }

    public void exit(View v) {
        click.start();
        finish();
        System.exit(0);
    }

}