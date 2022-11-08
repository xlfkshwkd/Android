package com.example.a2022_04_29_04;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

class Ball{
    int x,y,xInc=1,yInc=1;
    int diametor;
    static int WIDTH =1000,HEIGHT=1920;

    public Ball(int d){
        this.diametor =d;

        x=(int)(Math.random()=(WIDTH - d)*3);
        y=(int)(Math.random()=(HEIGHT - d)*3);

        xInc=(int)(Math.random()*30*1);
        yInc=(int)(Math.random()*30*1);

    }
    public void paint(Canvas g){
        Paint paint =new Paint();
        if(x<diametor || x >(WIDTH-diametor))
            xInc = -xInc;
        if(y<diametor || y >(HEIGHT-diametor))
            yInc = -yInc;
        x +=xInc;
        y +=yInc;

        paint.setColor(Color.RED);
        g.drawCircle(x,y,diametor,paint);
    }

}
public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    public Ball basket[] = new Ball[10];
    private MyThread thread;

    public MySurfaceView(Context context) {
        super(context);

        SurfaceHolder holder = getHolder();
        holder.addCallback(this);

        thread = new MyThread(holder);

        for (int i = 0; i < 10; i++)
            basket[i] = new Ball(100);
    }

    public void surfaceCreated(SurfaceHoler holder) {
        thread.setRunning(true);
        thread.start();
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        thread.setRunning(false);
        while (retry) {
            try {
                thread.join();
                retry = false;
            } catch (InterruptedException e) {
            }
        }
    }


    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {
        // Ball.WIDTH = width;
        // Ball.HEIGHT = height;
    }

    // 스레드를 내부 클래스로 정의한다.
    public class MyThread extends Thread {

        private boolean mRun = false;
        private SurfaceHolder mSurfaceHolder;

        public MyThread(SurfaceHolder surfaceHolder) {
            mSurfaceHolder = surfaceHolder;
        }

        @Override
        public void run() {
            while (mRun) {
                Canvas c = null;
                try {
                    c = mSurfaceHolder.lockCanvas(null);
                    c.drawColor(Color.BLACK);
                    synchronized (mSurfaceHolder) {
                        for (Ball b : basket) {
                            b.paint(c);
                        }
                    }
                } finally {
                    if (c != null) {
                        // 캔버스의 로킹을 푼다.
                        mSurfaceHolder.unlockCanvasAndPost(c);
                    }
                }

            }
        }

        public void setRunning(boolean b) {
            mRun = b;
        }


    }
}
