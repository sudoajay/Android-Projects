package com.example.sudoajay.ondraw_testing;

/**
 * Created by sudoajay on 2/5/18.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class Draw_View extends View {
    Paint paint = new Paint();

    private void init() {

    }

    public Draw_View(Context context) {
        super(context);
        init();
    }

    @Override
    public void onDraw(Canvas c) {
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(10);
        c.drawLine(0, 0, 200, 200, paint);
        c.drawLine(200, 0, 0, 200, paint);
    }

}
