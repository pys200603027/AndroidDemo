package com.example.canvasdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CanvasDemoView extends View {
    Paint paint;

    public CanvasDemoView(Context context) {
        super(context);
        init();
    }

    public CanvasDemoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(5);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawBackground(canvas);
        drawCoordinate(canvas);
        drawCircle(canvas);
        drawRect(canvas);
        drawRoundRect(canvas);
        drawOval(canvas);
    }


    /**
     * 画背景
     *
     * @param canvas
     */
    private void drawBackground(Canvas canvas) {
        canvas.drawColor(Color.LTGRAY);
    }

    /**
     * 画坐标轴
     *
     * @param canvas
     */
    private void drawCoordinate(Canvas canvas) {


        float[] xy = new float[]{
                //x
                0, getHeight() / 2, getWidth(), getHeight() / 2,
                //y
                getWidth() / 2, 0, getWidth() / 2, getHeight()
        };

        canvas.drawLines(xy, paint);
    }


    private void drawCircle(Canvas canvas) {
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 4, paint);


        //勾股定理
        double r = Math.sqrt(Math.pow(getWidth() / 4.0, 2) * 2);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, (float) r, paint);
    }

    private void drawRect(Canvas canvas) {
        paint.setStyle(Paint.Style.STROKE);

        canvas.save();
        canvas.translate(getWidth() / 4, getHeight() / 4 + (getHeight() / 4 - getWidth() / 4));
        Rect rect = new Rect(0, 0, getWidth() / 2, getWidth() / 2);
        canvas.drawRect(rect, paint);

        canvas.restore();
    }

    private void drawRoundRect(Canvas canvas) {

        //勾股定理
        double r = Math.sqrt(Math.pow(getWidth() / 4.0, 2) * 2);
        paint.setStyle(Paint.Style.STROKE);

        canvas.save();
        canvas.translate((float) (getWidth() / 2 - r), (float) (getHeight() / 2 - r));

        RectF rectF = new RectF(0, 0, (float) r * 2, (float) r * 2);
        canvas.drawRoundRect(rectF, 50, 50, paint);

        canvas.restore();
    }

    private void drawOval(Canvas canvas) {

        //画横向
        canvas.save();
        canvas.translate(getWidth() / 4, getHeight() / 2 - getWidth() / 16);
        RectF rectF = new RectF(0, 0, getWidth() / 2, getWidth() / 8);
        canvas.drawOval(rectF, paint);
        canvas.restore();

        //画竖直
        canvas.save();
        canvas.translate(getWidth() / 2 - getWidth() / 16, getHeight() / 2 - getWidth() / 4);
        RectF f = new RectF(0, 0, getWidth() / 8, getWidth() / 2);
        canvas.drawOval(f, paint);
        canvas.restore();
    }


}
