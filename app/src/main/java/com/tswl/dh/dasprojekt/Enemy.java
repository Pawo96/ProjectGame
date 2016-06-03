package com.tswl.dh.dasprojekt;

/**
 * Created by Pascal Wolf on 21.04.2016.
 */
public class Enemy {


    private String name = new String();
    private int attack = 0;
    private int defense = 0;
    private int mind = 0;
    private int speed = 0;
    private int max_hp = 0;
    private int max_mp = 0;


    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack){
        this.attack= attack;
    }

    public int getMind() {
        return mind;
    }

    public void setMind(int mind){
        this.mind= mind;
    }
    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense){
        this.defense= defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed){
        this.speed= speed;
    }

    public int getMax_hp() {
        return max_hp;
    }

    public void setMax_hp(int max_hp){
        this.max_hp= max_hp;
    }

    public int getMax_mp() {
        return max_mp;
    }

    public void setMax_mp(int max_mp){
        this.max_mp= max_mp;
    }


}
