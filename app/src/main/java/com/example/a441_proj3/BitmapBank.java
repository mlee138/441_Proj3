package com.example.a441_proj3;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapBank {

    Bitmap background;

    public BitmapBank(Resources res){
        background = BitmapFactory.decodeResource(res, R.drawable.background);
    }

    public Bitmap getBackground(){
        return background;
    }

    public int getBackgroundWidth(){
        return background.getWidth();
    }

    public int getBackgroundHeight(){
        return background.getHeight();
    }
}
