package mycustomview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/11/29.
 */

public class MyTaiJIView extends View{
    private Paint whitePaint;//白色画笔
    private Paint blackPaint;//黑色画笔
    private int degree=0;    //旋转的角度

    public MyTaiJIView(Context context) {
       this(context,null);
    }

    public MyTaiJIView(Context context, @Nullable AttributeSet attrs) {
       this(context,attrs,0);
    }

    public MyTaiJIView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaints();
    }

    //初始化画笔函数
    private void initPaints() {
        whitePaint=new Paint();
        whitePaint.setAntiAlias(true);
        whitePaint.setColor(Color.WHITE);

        blackPaint=new Paint(whitePaint);
        blackPaint.setColor(Color.BLACK);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width=this.getWidth();        //画布宽带
        int height=this.getHeight();      //画布高度

        canvas.translate(width/2,height/2); //移动左边圆点到画布中心

        canvas.drawColor(Color.GRAY);       //画布背景
        canvas.rotate(degree);              //旋转画布

        //绘制俩个半圆
        int radius=Math.min(width,height)/2-100;
        RectF rect=new RectF(-radius,-radius,radius,radius);
        canvas.drawArc(rect,90,180,true,blackPaint);    //绘制的矩形，开始的角度 扫过的角度 是否以矩形的中心为中心，画笔
        canvas.drawArc(rect,-90,180,true,whitePaint);   //绘制白色半圆

        //绘制两个半圆
        canvas.drawCircle(0,-radius/2,radius/2,blackPaint);
        canvas.drawCircle(0,radius/2,radius/2,whitePaint);

        //绘制小眼睛
        int smallRadius=radius/8;
        canvas.drawCircle(0,-radius/2,smallRadius,whitePaint);
        canvas.drawCircle(0,radius/2,smallRadius,blackPaint);


    }
    public void setDegree(int degree){
        this.degree=degree;
        invalidate();
    }
}
