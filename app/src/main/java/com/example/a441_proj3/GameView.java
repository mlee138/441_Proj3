package com.example.a441_proj3;


import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.util.Log;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

public class GameView extends View {

//    GameThread gameThread;

    Handler handler;
    Runnable runnable;
    final int UPDATE_MS = 30;
    Bitmap background;
    Display display;
    Point point;
    int dWidth, dHeight;
    Rect rect;

    Bitmap[] orbs;
    int orbFrame = 0;

    public GameView(Context context){
        super(context);
//        initView();
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                invalidate();
            }
        };
        background = BitmapFactory.decodeResource(getResources(),R.drawable.background);
        display = ((Activity)getContext()).getWindowManager().getDefaultDisplay();
        point = new Point();
        display.getSize(point);
        dWidth = point.x;
        dHeight = point.y;
        rect = new Rect(0,0,dWidth,dHeight);
        orbs = new Bitmap[2];
        orbs[0] = BitmapFactory.decodeResource(getResources(), R.drawable.orb);
        orbs[1] = BitmapFactory.decodeResource(getResources(), R.drawable.orb2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //canvas.drawBitmap(background,0,0,null);
        canvas.drawBitmap(background,null,rect,null);
        if(orbFrame == 0){
            orbFrame = 1;
        } else {
            orbFrame = 0;
        }

        canvas.drawBitmap(orbs[orbFrame],dWidth/2 - orbs[0].getWidth(), dHeight/2-orbs[0].getHeight()/2,null);
        handler.postDelayed(runnable,UPDATE_MS);
    }

    /*void initView(){
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        setFocusable(true);
        gameThread = new GameThread(holder);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        if(!gameThread.isRunning()){
            gameThread = new GameThread(holder);
            gameThread.start();
        } else{
            gameThread.start();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        if (gameThread.isRunning()){
            gameThread.setIsRunning(false);
            boolean retry = true;
            while(retry){
                try {
                    gameThread.join();
                    retry = false;
                } catch (InterruptedException e){
                    Log.e("Interrupted","Interrupted while joining");
                }
            }
        }
    }
*/
}