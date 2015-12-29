package com.tswl.dh.dasprojekt;

/**
 * Created by Pascal Wolf on 09.12.2015.
 */
public class Logic {
    public String playername = "Player1";
    public int playerattack = 10;
    public int playerdefense = 10;
    public int playermind = 10;
    public int playerspeed = 10;
    public int playerhp = 99;
    public int playermaxhp = 100;
    public int playermp = 49;
    public int playermaxmp = 50;

    public void setPlayerName(String name){
        playername = name;
    }

    public String getPlayerName(){
        return playername;
    }

    public void setPlayerAttack(int attack){
        playerattack = attack;
    }

    public int getPlayerAttack(){
        return playerattack;
    }

    public void setPlayerDefense(int defense){
        playerdefense = defense;
    }

    public int getPlayerDefense(){
        return playerdefense;
    }

    public void setPlayerMind(int mind){
        playermind = mind;
    }

    public int getPlayerMind(){
        return playermind;
    }

    public void setPlayerSpeed(int speed){
        playerspeed = speed;
    }

    public int getPlayerSpeed(){
        return playerspeed;
    }

    public void setPlayerHP(int hp){
        playerhp = hp;
    }

    public int getPlayerHP(){
        return playerhp;
    }

    public void setPlayerMaxHP(int maxhp){
        playermaxhp = maxhp;
    }

    public int getPlayerMaxHP(){
        return playermaxhp;
    }

    public void setPlayerMP(int mp){
        playermp = mp;
    }

    public int getPlayerMP(){
        return playermp;
    }

    public void setPlayerMaxMP(int maxmp){
        playermaxmp = maxmp;
    }

    public int getPlayerMaxMP(){
        return playermaxmp;
    }
}
