package mycustomview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import java.util.Locale;

/**
 * Created by Administrator on 2017/12/20.
 */

public class MyTestView extends View {
    Paint mPaint;

    public MyTestView(Context context) {
        super(context);
        init();
    }

    public MyTestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
//        ColorFilter lightingColorFilter = new LightingColorFilter(0x00ffff, 0x000000);
//        mPaint.setColorFilter(lightingColorFilter);
    }

    public MyTestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        Bitmap bitmap= BitmapFactory.decodeResource(getResources(), R.mipmap.ico);
//       canvas.drawBitmap(bitmap,0,0,mPaint);
//mPaint.setTextSize(40);
//        mPaint.setShadowLayer(10,0,0, Color.RED);
        String text = "你在说什么中国";
        mPaint.setTextSize(30);
        //是否加删除线
        mPaint.setStrikeThruText(true);
        //是否加下划线
        mPaint.setUnderlineText(true);
        //设置文字倾斜角度
        mPaint.setTextSkewX(0.5f);
        canvas.drawText(text, 0, 100, mPaint);
        //设置缩放
        mPaint.setTextScaleX(1);
        canvas.drawText(text, 0, 200, mPaint);
        mPaint.setTextScaleX(1.5f);
        canvas.drawText(text, 0, 300, mPaint);
        //设置字符间距 默认为0
        mPaint.setLetterSpacing(0.5f);
        canvas.drawText(text, 0, 400, mPaint);
//用 CSS 的 font-feature-settings 的方式来设置文字。
        mPaint.setFontFeatureSettings("smcp");
        canvas.drawText("Hello HenCoder", 0, 500, mPaint);
        //设置对齐方式
        mPaint.setTextAlign(Paint.Align.LEFT);
        canvas.drawText(text, 200, 600, mPaint);
        mPaint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(text, 200, 700, mPaint);
        mPaint.setTextAlign(Paint.Align.RIGHT);
        canvas.drawText(text, 200, 800, mPaint);
        //设置地域
        mPaint.setTextAlign(Paint.Align.LEFT);
        mPaint.setTextLocale(Locale.TAIWAN);
        canvas.drawText(text, 0, 850, mPaint);

        mPaint.reset();
        mPaint.setColor(Color.RED);
        String str = "说多了都是泪啊";
        canvas.drawText(str, 10, 900, mPaint);
        Rect bound = new Rect();
        mPaint.getTextBounds(str, 0, str.length(), bound);
        bound.left+=10;
        bound.top+=10;
        bound.right+=10;
        bound.bottom+=10;
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLACK);
        canvas.drawRect(bound,mPaint);
    }
}
