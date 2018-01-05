package mycustomview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;


/**
 * Created by Administrator on 2017/11/24.
 * 带有标记的textview
 */

public class MyBadgeTextView extends android.support.v7.widget.AppCompatTextView {
    //要显示的数量
    private int num=0;
    //红色圆圈的半径
    private float radius;
    //圆圈内数字半径
    private float testSize;
    //右边和上边的内边距
    private int paddingTop;
    //数字的最大 最小字体
    private int smallTextSize,bigTextSize;
    //初始化画笔
    private Paint mpaint;

    public MyBadgeTextView(Context context) {
        super(context);
        init(context);
    }

    public MyBadgeTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        mpaint=new Paint();
        smallTextSize=dip2px(context,8);
        bigTextSize=dip2px(context,9);
        mpaint.setTypeface(Typeface.DEFAULT_BOLD);
        mpaint.setAntiAlias(true);
        mpaint.setStyle(Paint.Style.FILL);
    }

    /**
     * 设置显示数量
     * @param num
     */
    public void setNum(int num){
        this.num=num;
        //重新绘制
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(num>0){
            //初始化半径
            if (radius<=0){
                radius=paddingTop/2;
            }
            //初始化字体大小
            testSize=(num<=99)?bigTextSize:smallTextSize;
            //设置字体大小
            mpaint.setTextSize(testSize);
            paddingTop=getPaddingTop();
            String mNum= String.valueOf(num);
            if (num>99){
                mNum="99+";
            }
            //画圆，设置红色
            mpaint.setColor(0xffff4444);
            canvas.drawCircle(getWidth()-paddingTop,paddingTop,paddingTop/2,mpaint);
            //画文字 设置白色
            mpaint.setColor(0xffffffff);
            float width=mpaint.measureText(mNum);
            int count=canvas.save();
            float size=radius*2;
            Rect mRect=new Rect(0,0,(int)size,(int)size);
            Paint.FontMetricsInt fontMetrics=mpaint.getFontMetricsInt();
            int baseline=(mRect.bottom+mRect.top - fontMetrics.bottom - fontMetrics.top)/2;
            canvas.translate(getWidth()-size+(size-width)/2,baseline);
            canvas.drawText(mNum,0,0,mpaint);
            canvas.restoreToCount(count);

        }
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
