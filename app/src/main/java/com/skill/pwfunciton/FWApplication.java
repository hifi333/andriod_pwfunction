package com.skill.pwfunciton;

import android.app.Application;

/**
 * Created by eviewlake on 2019/2/9.
 */

public class FWApplication extends Application {

    public float  slob=1;
    public float  intercept=0;
    public float  g_a=2;
    public float  g_b=3;
    public float  g_h=1;
    public float  g_k=2;



    public float  sin_slob=1;
    public float  sin_intercept=0;
    public float  sin_g_a=2;
    public float  sin_g_b=3;
    public float  sin_g_h=1;
    public float  sin_g_k=2;


    public boolean singraph = false;


    FunctionGraphView functionGraphView =null;

    @Override
    public void onCreate() {
        super.onCreate();
    }

}
