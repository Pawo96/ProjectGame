package com.tswl.dh.dasprojekt;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class Battle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int enemy_attack = 1;
        final int enemy_defense = 1;
        int enemy_hp = 10;
        final int enemy_speed = 1;
        int enemy_mind = 1;
        int enemy_mp= 10;

        final int own_attack = 10;
        int own_defense = 10;
        int own_hp = 100;
        int own_speed = 10;
        int own_mind = 10;
        int own_mp= 100;

        String text = null;
        setContentView(R.layout.activity_battle);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        LinearLayout battlelayout = (LinearLayout)findViewById(R.id.battlelayout);
        battlelayout.setBackgroundResource(R.drawable.battlebackground1);
        RelativeLayout controllayout = (RelativeLayout)findViewById(R.id.controllayout);
        final TextView enemyhp = new TextView(this);
        enemyhp.setText(Integer.toString(enemy_hp));
        battlelayout.addView(enemyhp);
        ImageView enemy = new ImageView(this);
        enemy.setMaxHeight(100);
        enemy.setMaxWidth(100);
        enemy.setImageResource(R.drawable.greenslime_walk);
        battlelayout.addView(enemy);
        final float scale = getResources().getDisplayMetrics().density;
        int pixel = (int) (200*scale+.5f);
        Button attack = new Button(this);
        attack.setText("ATTACK");
        attack.setWidth(pixel);
        attack.setHeight(50);
        attack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int damage = own_attack / 2 * enemy_defense;
                int newenemyhp = Integer.parseInt(enemyhp.getText().toString()) - damage;
                enemyhp.setText(Integer.toString(newenemyhp));
            }
        });
        Button skill = new Button(this);
        skill.setText("SKILL");
        skill.setX(500);
        skill.setWidth(pixel);
        skill.setHeight(50);
        Button item = new Button(this);
        item.setText("ITEM");
        item.setY(100);
        item.setWidth(pixel);
        item.setHeight(50);
        Button flee = new Button(this);
        flee.setText("FLEE");
        flee.setWidth(pixel);
        flee.setHeight(50);
        flee.setY(100);
        flee.setX(500);




        BackgroundTask backgroundTask = new BackgroundTask(this);
        try {
            text = backgroundTask.execute("monster", "Slime").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }



        flee.setText(text);

        controllayout.addView(attack);
        controllayout.addView(skill);
        controllayout.addView(item);
        controllayout.addView(flee);
    }

    public interface VariableChangeListener{
        public void onVarialeChanged(Object enemyhp);
    }
}
