package mycustomview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2017/12/25.
 */

public class MySpottedLinearLayout extends LinearLayout {
    Paint paint;

    public MySpottedLinearLayout(Context context) {
        super(context);
    }

    public MySpottedLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
    }

    public MySpottedLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //针对viewGroup 的子View的绘制会调用这个方法
    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.drawCircle(100,200,30,paint);
        canvas.drawCircle(50,250,20,paint);
        canvas.drawCircle(150,300,50,paint);
    }
//绘制滑动条渐变和前景颜色
    @Override
    public void onDrawForeground(Canvas canvas) {
        super.onDrawForeground(canvas);
    }
}
