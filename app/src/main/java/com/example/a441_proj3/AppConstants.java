package com.example.a441_proj3;

import android.content.Context;

public class AppConstants {

    static BitmapBank bitmapBank;
//    static GameEngine;

    public static void initialization(Context context){
        bitmapBank = new BitmapBank(context.getResources());
//        gameEngine
    }

    public static BitmapBank getBitmapBank(){
        return bitmapBank;
    }

    /*public static GameEngine getGameEngine(){
        return bitmapBank;
    }*/
}
