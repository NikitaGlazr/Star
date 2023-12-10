package com.example.star;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView objectImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objectImageView = findViewById(R.id.imageView);
        ImageView earthImageView = findViewById(R.id.earth);
        ImageView marsImageView = findViewById(R.id.mars);
        // Углы начальной и конечной позиций анимации вокруг солнца (в градусах)
        float startAngle = 0.0f;
        float endAngle = 360.0f;

        // Создание анимации вращения вокруг солнца
        RotateAnimation rotateAroundSunAnimation = new RotateAnimation(startAngle, endAngle,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAroundSunAnimation.setInterpolator(new LinearInterpolator());
        rotateAroundSunAnimation.setDuration(9000);
        rotateAroundSunAnimation.setRepeatCount(Animation.INFINITE);
        rotateAroundSunAnimation.setFillAfter(true);

        // Запуск анимации вращения вокруг солнца
        objectImageView.startAnimation(rotateAroundSunAnimation);

        // Параметры для трансляции анимации вокруг солнца
        float xStart = 300.0f;
        float xEnd = 500.0f;
        float yStart = 500.0f;
        float yEnd = 300.0f;

        // Создание анимации трансляции вокруг солнца
        TranslateAnimation translateAroundSunAnimation = new TranslateAnimation(xStart, xEnd, yStart, yEnd);
        translateAroundSunAnimation.setInterpolator(new LinearInterpolator());
        translateAroundSunAnimation.setDuration(30000);
        translateAroundSunAnimation.setRepeatCount(Animation.INFINITE);
        translateAroundSunAnimation.setFillAfter(true);

        // Создание объекта AnimationSet для объединения обеих анимаций
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(translateAroundSunAnimation);
        animationSet.addAnimation(rotateAroundSunAnimation);

        // Запуск анимации трансляции и вращения вокруг солнца на объекте Земли
        earthImageView.startAnimation(animationSet);


        // Создание анимации вращения вокруг солнца для объекта Марс
        RotateAnimation rotateAroundSunAnimationMars = new RotateAnimation(startAngle, endAngle,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAroundSunAnimationMars.setInterpolator(new LinearInterpolator());
        rotateAroundSunAnimationMars.setDuration(4000);
        rotateAroundSunAnimationMars.setRepeatCount(Animation.INFINITE);
        rotateAroundSunAnimationMars.setFillAfter(true);

// Запуск анимации вращения вокруг солнца для объекта Марс
        marsImageView.startAnimation(rotateAroundSunAnimationMars);

// Параметры для трансляции анимации вокруг солнца для объекта Марс
        float xStartMars = 50.0f;
        float xEndMars = 300.0f;
        float yStartMars = 300.0f;
        float yEndMars = 50.0f;

// Создание анимации трансляции вокруг солнца для объекта Марс
        TranslateAnimation translateAroundSunAnimationMars = new TranslateAnimation(xStartMars, xEndMars, yStartMars, yEndMars);
        translateAroundSunAnimationMars.setInterpolator(new LinearInterpolator());
        translateAroundSunAnimationMars.setDuration(10000);
        translateAroundSunAnimationMars.setRepeatCount(Animation.INFINITE);
        translateAroundSunAnimationMars.setFillAfter(true);

// Создание нового объекта AnimationSet для объединения анимаций вращения и трансляции для объекта Марс
        AnimationSet animationSetMars = new AnimationSet(true);
        animationSetMars.addAnimation(translateAroundSunAnimationMars);
        animationSetMars.addAnimation(rotateAroundSunAnimationMars);

// Запуск анимации трансляции и вращения вокруг солнца на объекте Марс
        marsImageView.startAnimation(animationSetMars);
    }
}