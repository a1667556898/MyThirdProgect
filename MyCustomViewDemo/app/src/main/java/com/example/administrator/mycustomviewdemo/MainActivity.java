package com.example.administrator.mycustomviewdemo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final TextView tv_test = (TextView) findViewById(R.id.tv_test);
        tv_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_test.setLayerType(View.LAYER_TYPE_HARDWARE,null);
                ObjectAnimator animator=ObjectAnimator.ofFloat(tv_test,"rotationY",200);
                animator.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        tv_test.setLayerType(View.LAYER_TYPE_NONE,null);
                    }
                });
                animator.start();
            }
        });


    }
}
