package mycustomview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by Administrator on 2017/12/25.
 */

public class MyTextView extends android.support.v7.widget.AppCompatTextView {
    private Paint paint;
    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint=new Paint();
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.RED);
        super.onDraw(canvas);
    }
}
