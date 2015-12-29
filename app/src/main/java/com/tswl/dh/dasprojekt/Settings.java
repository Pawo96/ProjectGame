package com.tswl.dh.dasprojekt;

import java.io.Serializable;

public class Settings implements Serializable {

    public String name = "";
    public String betreff = "";
    public int backgroundcolor, textcolor, redBG, blueBG, greenBG, redTC, blueTC, greenTC, textsize;
    public boolean checkboxB, checkboxI, checkboxU;
    public int spinneritem;
    private static final long serialVersionUID = 46543445;




    public void setRedBG(int redBG) {
        this.redBG = redBG;
    }

    public void setBlueRG(int blueBG) {
        this.blueBG = blueBG;
    }

    public void setGreenBG(int greenBG) {
        this.greenBG = greenBG;
    }



    public String getRedBG() {
        return "" + redBG;
    }

    public String getGreenBG() {
        return "" + greenBG;
    }

    public String getBlueBG() {
        return "" + blueBG;
    }


}