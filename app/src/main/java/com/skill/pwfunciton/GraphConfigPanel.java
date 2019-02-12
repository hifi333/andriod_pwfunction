package com.skill.pwfunciton;

import android.app.Application;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * Created by eviewlake on 2019/2/9.
 */

public class GraphConfigPanel extends RelativeLayout implements View.OnClickListener {

    FWApplication fwApplication = null;

    EditText slopX = null;
    EditText intercept = null;
    EditText slop_functionG_a = null;
    EditText slop_functionG_b = null;
    EditText functionG_x_intercept_h = null;
    EditText functionG_y_intercept_k = null;


    EditText sin_slopX = null;
    EditText sin_intercept = null;
    EditText sin_slop_functionG_a = null;
    EditText sin_slop_functionG_b = null;
    EditText sin_functionG_x_intercept_h = null;
    EditText sin_functionG_y_intercept_k = null;

    int fontsize = 15;
    int fontsize_g = 15;

    public GraphConfigPanel(Context context) {
        super(context);

        this.setBackgroundColor(Color.LTGRAY);

        TextView functionY = new TextView(this.getContext());
        functionY.setText("y = f(x) = ");
        functionY.setTextSize(fontsize);
        functionY.setId(View.generateViewId());
       // functionY.setBackgroundColor(Color.RED);

        slopX = new EditText(this.getContext());
        slopX.setEnabled(false);
        slopX.setId(View.generateViewId());
        slopX.setTextSize(fontsize);
       // slopX.setBackgroundColor(Color.RED);


        TextView x = new TextView(this.getContext());
        x.setText(" x + ");
        x.setId(View.generateViewId());
        x.setTextSize(fontsize);


        intercept = new EditText(this.getContext());
        intercept.setEnabled(false);
        intercept.setId(View.generateViewId());
        intercept.setTextSize(fontsize);


        RelativeLayout.LayoutParams p1 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        p1.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        p1.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        p1.setMargins(10, 120, 0, 0);

        this.addView(functionY, p1);


        RelativeLayout.LayoutParams p2 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        p2.addRule(RelativeLayout.RIGHT_OF, functionY.getId());
        p2.addRule(RelativeLayout.ALIGN_BASELINE, functionY.getId());
        this.addView(slopX, p2);


        RelativeLayout.LayoutParams p3 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        p3.addRule(RelativeLayout.RIGHT_OF, slopX.getId());
        p3.addRule(RelativeLayout.ALIGN_BASELINE, slopX.getId());

        this.addView(x, p3);

        RelativeLayout.LayoutParams p4 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        p4.addRule(RelativeLayout.RIGHT_OF, x.getId());
        p4.addRule(RelativeLayout.ALIGN_BASELINE, x.getId());

        this.addView(intercept, p4);


        Button button_slopup = new Button(this.getContext());
        button_slopup.setId(R.id.button_slopup);
        button_slopup.setText("U");

        RelativeLayout.LayoutParams p5 = new RelativeLayout.LayoutParams(110, 110);
        p5.addRule(RelativeLayout.ALIGN_LEFT, slopX.getId());
        p5.addRule(RelativeLayout.ABOVE, slopX.getId());
       // p5.setMarginStart(-30);
        p5.setMargins(-35,0,0,-50);
        this.addView(button_slopup, p5);


        Button button_slopdown = new Button(this.getContext());
        button_slopdown.setId(R.id.button_slowdown);
        button_slopdown.setText("D");
        RelativeLayout.LayoutParams p6 = new RelativeLayout.LayoutParams(110, 110);
        p6.addRule(RelativeLayout.ALIGN_LEFT, slopX.getId());
        p6.addRule(RelativeLayout.BELOW, slopX.getId());
        p6.setMargins(-35,-50,0,0);

        this.addView(button_slopdown, p6);


        Button button_interceptup = new Button(this.getContext());
        button_interceptup.setId(R.id.button_interceptup);
        button_interceptup.setText("U");

        RelativeLayout.LayoutParams p7 = new RelativeLayout.LayoutParams(110, 110);
        p7.addRule(RelativeLayout.ALIGN_LEFT, intercept.getId());
        p7.addRule(RelativeLayout.ABOVE, intercept.getId());
        //p7.setMarginStart(-20);
        p7.setMargins(-35,0,0,-50);

        this.addView(button_interceptup, p7);


        Button button_interceptdown = new Button(this.getContext());
        button_interceptdown.setText("D");

        button_interceptdown.setId(R.id.button_interceptdown);
        RelativeLayout.LayoutParams p8 = new RelativeLayout.LayoutParams(110, 110);
        p8.addRule(RelativeLayout.ALIGN_LEFT, intercept.getId());
        p8.addRule(RelativeLayout.BELOW, intercept.getId());
        p8.setMargins(-35,-50,0,0);

        this.addView(button_interceptdown, p8);


        button_slopup.setOnClickListener(this);
        button_slopdown.setOnClickListener(this);

        button_interceptup.setOnClickListener(this);
        button_interceptdown.setOnClickListener(this);

/////////////////////////////////////////////////////////////////////////////////////////////////

        TextView functionG = new TextView(this.getContext());
        functionG.setText("y1 = g(x) = ");
        functionG.setTextSize(fontsize_g);
        functionG.setTextColor(Color.BLUE);
        functionG.setId(View.generateViewId());

        slop_functionG_a = new EditText(this.getContext());
        slop_functionG_a.setEnabled(false);
        slop_functionG_a.setId(View.generateViewId());
        slop_functionG_a.setTextSize(fontsize_g);
       // slop_functionG_a.setText("a");
        slop_functionG_a.setTextColor(Color.RED);

        TextView functionf = new TextView(this.getContext());
        functionf.setText("f(");
        functionf.setTextSize(fontsize_g+10);
        functionf.setId(View.generateViewId());
        functionf.setTextColor(Color.BLACK);


        slop_functionG_b = new EditText(this.getContext());
        slop_functionG_b.setEnabled(false);
        slop_functionG_b.setId(View.generateViewId());
        slop_functionG_b.setTextSize(fontsize_g);
       // slop_functionG_b.setText("b");
        slop_functionG_b.setTextColor(Color.RED);

        TextView functionfkuahu = new TextView(this.getContext());
        functionfkuahu.setText("(");
        functionfkuahu.setTextSize(fontsize_g);
        functionfkuahu.setId(View.generateViewId());
        functionfkuahu.setTextColor(Color.BLUE);


        TextView functionfx = new TextView(this.getContext());
        functionfx.setText("x");
        functionfx.setTextSize(fontsize_g);
        functionfx.setId(View.generateViewId());
        functionfx.setTextColor(Color.BLUE);


        TextView functionfplus = new TextView(this.getContext());
        functionfplus.setText("-");
        functionfplus.setTextSize(fontsize_g);
        functionfplus.setId(View.generateViewId());
        functionfplus.setTextColor(Color.BLUE);



        functionG_x_intercept_h = new EditText(this.getContext());
        functionG_x_intercept_h.setEnabled(false);
        functionG_x_intercept_h.setId(View.generateViewId());
        functionG_x_intercept_h.setTextSize(fontsize_g);
//        functionG_x_intercept_h.setText("h");
        functionG_x_intercept_h.setTextColor(Color.YELLOW);





        TextView functionfxend = new TextView(this.getContext());
        functionfxend.setText(")");
        functionfxend.setTextSize(fontsize_g);
        functionfxend.setId(View.generateViewId());
        functionfxend.setTextColor(Color.BLUE);


        TextView functionfxend1 = new TextView(this.getContext());
        functionfxend1.setText(")");
        functionfxend1.setTextSize(fontsize_g+10);
        functionfxend1.setId(View.generateViewId());
        functionfxend1.setTextColor(Color.BLACK);



        TextView functionfplus2 = new TextView(this.getContext());
        functionfplus2.setText("+");
        functionfplus2.setTextSize(fontsize_g);
        functionfplus2.setId(View.generateViewId());
        functionfplus2.setTextColor(Color.BLUE);





        functionG_y_intercept_k = new EditText(this.getContext());
        functionG_y_intercept_k.setEnabled(false);
        functionG_y_intercept_k.setId(View.generateViewId());
        functionG_y_intercept_k.setTextSize(fontsize_g);
//        functionG_y_intercept_k.setText("k");
        functionG_y_intercept_k.setTextColor(Color.YELLOW);



        RelativeLayout.LayoutParams g1 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
//        g1.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
//        g1.addRule(RelativeLayout.ALIGN_PARENT_TOP);
//        g1.setMargins(450, 130, 0, 0);



        g1.addRule(RelativeLayout.RIGHT_OF, intercept.getId());
        g1.addRule(RelativeLayout.ALIGN_BASELINE, intercept.getId());

        this.addView(functionG, g1);



        RelativeLayout.LayoutParams g2 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        g2.addRule(RelativeLayout.RIGHT_OF, functionG.getId());
        g2.addRule(RelativeLayout.ALIGN_BASELINE, functionG.getId());
        g2.setMarginStart(-10);

        this.addView(slop_functionG_a, g2);

        RelativeLayout.LayoutParams g3 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        g3.addRule(RelativeLayout.RIGHT_OF, slop_functionG_a.getId());
        g3.addRule(RelativeLayout.ALIGN_BASELINE, slop_functionG_a.getId());

        this.addView(functionf, g3);


        RelativeLayout.LayoutParams g4 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        g4.addRule(RelativeLayout.RIGHT_OF, functionf.getId());
        g4.addRule(RelativeLayout.ALIGN_BASELINE, functionf.getId());
        this.addView(slop_functionG_b, g4);


        RelativeLayout.LayoutParams g5 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        g5.addRule(RelativeLayout.RIGHT_OF, slop_functionG_b.getId());
        g5.addRule(RelativeLayout.ALIGN_BASELINE, slop_functionG_b.getId());
        this.addView(functionfkuahu, g5);


        RelativeLayout.LayoutParams g6 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        g6.addRule(RelativeLayout.RIGHT_OF, functionfkuahu.getId());
        g6.addRule(RelativeLayout.ALIGN_BASELINE, functionfkuahu.getId());
        this.addView(functionfx, g6);



        RelativeLayout.LayoutParams g7 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        g7.addRule(RelativeLayout.RIGHT_OF, functionfx.getId());
        g7.addRule(RelativeLayout.ALIGN_BASELINE, functionfx.getId());
        this.addView(functionfplus, g7);



        RelativeLayout.LayoutParams g8 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        g8.addRule(RelativeLayout.RIGHT_OF, functionfplus.getId());
        g8.addRule(RelativeLayout.ALIGN_BASELINE, functionfplus.getId());
        this.addView(functionG_x_intercept_h, g8);


        RelativeLayout.LayoutParams g9 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        g9.addRule(RelativeLayout.RIGHT_OF, functionG_x_intercept_h.getId());
        g9.addRule(RelativeLayout.ALIGN_BASELINE, functionG_x_intercept_h.getId());
        this.addView(functionfxend, g9);




        RelativeLayout.LayoutParams g10 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        g10.addRule(RelativeLayout.RIGHT_OF, functionfxend.getId());
        g10.addRule(RelativeLayout.ALIGN_BASELINE, functionfxend.getId());
        this.addView(functionfxend1, g10);

        RelativeLayout.LayoutParams g10_ = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        g10_.addRule(RelativeLayout.RIGHT_OF, functionfxend1.getId());
        g10_.addRule(RelativeLayout.ALIGN_BASELINE, functionfxend1.getId());
        this.addView(functionfplus2, g10_);


        RelativeLayout.LayoutParams g11 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        g11.addRule(RelativeLayout.RIGHT_OF, functionfplus2.getId());
        g11.addRule(RelativeLayout.ALIGN_BASELINE, functionfplus2.getId());
        this.addView(functionG_y_intercept_k, g11);





        Button button_a_up = new Button(this.getContext());
        button_a_up.setId(R.id.button_a_up);
        button_a_up.setText("U");

        RelativeLayout.LayoutParams paup = new RelativeLayout.LayoutParams(110, 110);
        paup.addRule(RelativeLayout.ALIGN_LEFT, slop_functionG_a.getId());
        paup.addRule(RelativeLayout.ABOVE, slop_functionG_a.getId());
        paup.setMargins(-45,0,0,-20);
        this.addView(button_a_up, paup);




        Button button_a_down = new Button(this.getContext());
        button_a_down.setId(R.id.button_a_down);
        button_a_down.setText("D");

        RelativeLayout.LayoutParams padown = new RelativeLayout.LayoutParams(110, 110);
        padown.addRule(RelativeLayout.ALIGN_LEFT, slop_functionG_a.getId());
        padown.addRule(RelativeLayout.BELOW, slop_functionG_a.getId());
        padown.setMargins(-45,-40,0,0);
        this.addView(button_a_down, padown);


        Button button_b_up = new Button(this.getContext());
        button_b_up.setId(R.id.button_b_up);
        button_b_up.setText("U");

        RelativeLayout.LayoutParams pbup = new RelativeLayout.LayoutParams(110, 110);
        pbup.addRule(RelativeLayout.ALIGN_LEFT, slop_functionG_b.getId());
        pbup.addRule(RelativeLayout.ABOVE, slop_functionG_b.getId());
        pbup.setMargins(-45,0,0,-20);
        this.addView(button_b_up, pbup);




        Button button_b_down = new Button(this.getContext());
        button_b_down.setId(R.id.button_b_down);
        button_b_down.setText("D");

        RelativeLayout.LayoutParams pbdown = new RelativeLayout.LayoutParams(110, 110);
        pbdown.addRule(RelativeLayout.ALIGN_LEFT, slop_functionG_b.getId());
        pbdown.addRule(RelativeLayout.BELOW, slop_functionG_b.getId());
        pbdown.setMargins(-45,-40,0,0);
        this.addView(button_b_down, pbdown);





        Button button_h_up = new Button(this.getContext());
        button_h_up.setId(R.id.button_h_up);
        button_h_up.setText("U");

        RelativeLayout.LayoutParams phup = new RelativeLayout.LayoutParams(110, 110);
        phup.addRule(RelativeLayout.ALIGN_LEFT, functionG_x_intercept_h.getId());
        phup.addRule(RelativeLayout.ABOVE, functionG_x_intercept_h.getId());
        phup.setMargins(-35,0,0,-20);
        this.addView(button_h_up, phup);




        Button button_h_down = new Button(this.getContext());
        button_h_down.setId(R.id.button_h_down);
        button_h_down.setText("D");

        RelativeLayout.LayoutParams phdown = new RelativeLayout.LayoutParams(110, 110);
        phdown.addRule(RelativeLayout.ALIGN_LEFT, functionG_x_intercept_h.getId());
        phdown.addRule(RelativeLayout.BELOW, functionG_x_intercept_h.getId());
        phdown.setMargins(-35,-40,0,0);
        this.addView(button_h_down, phdown);






        Button button_k_up = new Button(this.getContext());
        button_k_up.setId(R.id.button_k_up);
        button_k_up.setText("U");

        RelativeLayout.LayoutParams pkup = new RelativeLayout.LayoutParams(110, 110);
        pkup.addRule(RelativeLayout.ALIGN_LEFT, functionG_y_intercept_k.getId());
        pkup.addRule(RelativeLayout.ABOVE, functionG_y_intercept_k.getId());
        pkup.setMargins(-35,0,0,-20);
        this.addView(button_k_up, pkup);




        Button button_k_down = new Button(this.getContext());
        button_k_down.setId(R.id.button_k_down);
        button_k_down.setText("D");

        RelativeLayout.LayoutParams pkdown = new RelativeLayout.LayoutParams(110, 110);
        pkdown.addRule(RelativeLayout.ALIGN_LEFT, functionG_y_intercept_k.getId());
        pkdown.addRule(RelativeLayout.BELOW, functionG_y_intercept_k.getId());
        pkdown.setMargins(-35,-40,0,0);
        this.addView(button_k_down, pkdown);




        button_a_up.setOnClickListener(this);
        button_b_up.setOnClickListener(this);
        button_h_up.setOnClickListener(this);
        button_k_up.setOnClickListener(this);



        button_a_down.setOnClickListener(this);
        button_b_down.setOnClickListener(this);
        button_h_down.setOnClickListener(this);
        button_k_down.setOnClickListener(this);




        makeSinPanel();

    }


    public void setApplication(Application mainapp) {
        this.fwApplication = (FWApplication) mainapp;

        updateParameterTextField();

    }


    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.button_slopup) {
            this.fwApplication.singraph = false;

            if (Math.abs(this.fwApplication.slob) <1)
                this.fwApplication.slob = this.fwApplication.slob + (float) 0.1;
            else
            this.fwApplication.slob++;
        }

        if (view.getId() == R.id.button_slowdown) {
            this.fwApplication.singraph = false;

            if (Math.abs(this.fwApplication.slob) <= 1)
                this.fwApplication.slob = this.fwApplication.slob - (float) 0.1;
            else
                this.fwApplication.slob--;

        }


        if (view.getId() == R.id.button_interceptup) {
            this.fwApplication.singraph = false;

            this.fwApplication.intercept++;

        }

        if (view.getId() == R.id.button_interceptdown) {
            this.fwApplication.singraph = false;

            this.fwApplication.intercept--;
        }



        if (view.getId() == R.id.button_a_up) {
            this.fwApplication.singraph = false;

            if (Math.abs(this.fwApplication.g_a) <1 )
                this.fwApplication.g_a = this.fwApplication.g_a + (float) 0.1;
            else
            this.fwApplication.g_a++;

        }

        if (view.getId() == R.id.button_a_down) {
            this.fwApplication.singraph = false;

            if (Math.abs(this.fwApplication.g_a) <=1 )
                this.fwApplication.g_a = this.fwApplication.g_a - (float) 0.1;
            else
            this.fwApplication.g_a--;
        }



        if (view.getId() == R.id.button_b_up) {
            this.fwApplication.singraph = false;

            if (Math.abs(this.fwApplication.g_b) <1 )
                this.fwApplication.g_b = this.fwApplication.g_b + (float) 0.1;
            else
            this.fwApplication.g_b++;

        }

        if (view.getId() == R.id.button_b_down) {
            this.fwApplication.singraph = false;

            if (Math.abs(this.fwApplication.g_b) <=1 )
                this.fwApplication.g_b = this.fwApplication.g_b - (float) 0.1;
            else
            this.fwApplication.g_b--;
        }




        if (view.getId() == R.id.button_h_up) {
            this.fwApplication.singraph = false;

            this.fwApplication.g_h++;

        }

        if (view.getId() == R.id.button_h_down) {
            this.fwApplication.singraph = false;

            this.fwApplication.g_h--;
        }



        if (view.getId() == R.id.button_k_up) {
            this.fwApplication.singraph = false;

            this.fwApplication.g_k++;

        }

        if (view.getId() == R.id.button_k_down) {
            this.fwApplication.singraph = false;

            this.fwApplication.g_k--;
        }




        //////////////////////////sin ////////////

        if (view.getId() == R.id.button_slopup_sin) {
            this.fwApplication.singraph = true;


            if (Math.abs(this.fwApplication.sin_slob) <1 )
                this.fwApplication.sin_slob = this.fwApplication.sin_slob + (float) 0.1;
            else
            this.fwApplication.sin_slob++;
        }

        if (view.getId() == R.id.button_slowdown_sin) {
            this.fwApplication.singraph = true;


            if (Math.abs(this.fwApplication.sin_slob) <=1 )
                this.fwApplication.sin_slob = this.fwApplication.sin_slob - (float) 0.1;
            else
                this.fwApplication.sin_slob--;

        }


        if (view.getId() == R.id.button_interceptup_sin) {
            this.fwApplication.singraph = true;

            this.fwApplication.sin_intercept++;

        }

        if (view.getId() == R.id.button_interceptdown_sin) {
            this.fwApplication.singraph = true;

            this.fwApplication.sin_intercept--;
        }



        if (view.getId() == R.id.button_a_up_sin) {
            this.fwApplication.singraph = true;

            if (Math.abs(this.fwApplication.sin_g_a) <1 )
                this.fwApplication.sin_g_a = this.fwApplication.sin_g_a + (float) 0.1;
            else
            this.fwApplication.sin_g_a++;

        }

        if (view.getId() == R.id.button_a_down_sin) {

            this.fwApplication.singraph = true;


            if (Math.abs(this.fwApplication.sin_g_a) <=1 )
                this.fwApplication.sin_g_a = this.fwApplication.sin_g_a - (float) 0.1;
            else
            this.fwApplication.sin_g_a--;
        }



        if (view.getId() == R.id.button_b_up_sin) {
            this.fwApplication.singraph = true;


            if (Math.abs(this.fwApplication.sin_g_b) <1 )
                this.fwApplication.sin_g_b = this.fwApplication.sin_g_b + (float) 0.1;
            else
            this.fwApplication.sin_g_b++;

        }

        if (view.getId() == R.id.button_b_down_sin) {
            this.fwApplication.singraph = true;


            if (Math.abs(this.fwApplication.sin_g_b) <1 )
                this.fwApplication.sin_g_b = this.fwApplication.sin_g_b - (float) 0.1;
            else
            this.fwApplication.sin_g_b--;
        }




        if (view.getId() == R.id.button_h_up_sin) {
            this.fwApplication.singraph = true;

            this.fwApplication.sin_g_h++;

        }

        if (view.getId() == R.id.button_h_down_sin) {
            this.fwApplication.singraph = true;

            this.fwApplication.sin_g_h--;
        }



        if (view.getId() == R.id.button_k_up_sin) {
            this.fwApplication.singraph = true;

            this.fwApplication.sin_g_k++;

        }

        if (view.getId() == R.id.button_k_down_sin) {
            this.fwApplication.singraph = true;
            this.fwApplication.sin_g_k--;
        }





        updateParameterTextField();

        this.fwApplication.functionGraphView.invalidate();


    }

    private void updateParameterTextField(){


        NumberFormat ddf1 = NumberFormat.getNumberInstance();
        ddf1.setMaximumFractionDigits(1);


        slopX.setText(ddf1.format(this.fwApplication.slob));
        slop_functionG_a.setText(ddf1.format(this.fwApplication.g_a));
        slop_functionG_b.setText(ddf1.format(this.fwApplication.g_b));
        intercept.setText(ddf1.format(this.fwApplication.intercept));
        functionG_x_intercept_h.setText(ddf1.format(this.fwApplication.g_h));
        functionG_y_intercept_k.setText(ddf1.format(this.fwApplication.g_k));



        sin_slopX.setText(ddf1.format(this.fwApplication.sin_slob));
        sin_slop_functionG_a.setText(ddf1.format(this.fwApplication.sin_g_a));
        sin_slop_functionG_b.setText(ddf1.format(this.fwApplication.sin_g_b));
        sin_intercept.setText(ddf1.format(this.fwApplication.sin_intercept));
        sin_functionG_x_intercept_h.setText(ddf1.format(this.fwApplication.sin_g_h));
        sin_functionG_y_intercept_k.setText(ddf1.format(this.fwApplication.sin_g_k));


    }




    private void makeSinPanel(){


        TextView functionY = new TextView(this.getContext());
        functionY.setText("w(x) = ");
        functionY.setTextSize(fontsize);
        functionY.setId(View.generateViewId());
        // functionY.setBackgroundColor(Color.RED);

        sin_slopX = new EditText(this.getContext());
        sin_slopX.setEnabled(false);
        sin_slopX.setId(View.generateViewId());
        sin_slopX.setTextSize(fontsize);
        // slopX.setBackgroundColor(Color.RED);


        TextView x = new TextView(this.getContext());
        x.setText("sinx + ");
        x.setId(View.generateViewId());
        x.setTextColor(Color.MAGENTA);
        x.setTextSize(fontsize);


        sin_intercept = new EditText(this.getContext());
        sin_intercept.setEnabled(false);
        sin_intercept.setId(View.generateViewId());
        sin_intercept.setTextSize(fontsize);


        RelativeLayout.LayoutParams p1 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        p1.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        p1.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        p1.setMargins(1, 420, 0, 0);

        this.addView(functionY, p1);


        RelativeLayout.LayoutParams p2 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        p2.addRule(RelativeLayout.RIGHT_OF, functionY.getId());
        p2.addRule(RelativeLayout.ALIGN_BASELINE, functionY.getId());
        this.addView(sin_slopX, p2);


        RelativeLayout.LayoutParams p3 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        p3.addRule(RelativeLayout.RIGHT_OF, sin_slopX.getId());
        p3.addRule(RelativeLayout.ALIGN_BASELINE, sin_slopX.getId());

        this.addView(x, p3);

        RelativeLayout.LayoutParams p4 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        p4.addRule(RelativeLayout.RIGHT_OF, x.getId());
        p4.addRule(RelativeLayout.ALIGN_BASELINE, x.getId());

        this.addView(sin_intercept, p4);


        Button button_slopup = new Button(this.getContext());
        button_slopup.setId(R.id.button_slopup_sin);
        button_slopup.setText("U");

        RelativeLayout.LayoutParams p5 = new RelativeLayout.LayoutParams(110, 110);
        p5.addRule(RelativeLayout.ALIGN_LEFT, sin_slopX.getId());
        p5.addRule(RelativeLayout.ABOVE, sin_slopX.getId());
        // p5.setMarginStart(-30);
        p5.setMargins(-35,0,0,-50);
        this.addView(button_slopup, p5);


        Button button_slopdown = new Button(this.getContext());
        button_slopdown.setId(R.id.button_slowdown_sin);
        button_slopdown.setText("D");
        RelativeLayout.LayoutParams p6 = new RelativeLayout.LayoutParams(110, 110);
        p6.addRule(RelativeLayout.ALIGN_LEFT, sin_slopX.getId());
        p6.addRule(RelativeLayout.BELOW, sin_slopX.getId());
        p6.setMargins(-35,-50,0,0);

        this.addView(button_slopdown, p6);


        Button button_interceptup = new Button(this.getContext());
        button_interceptup.setId(R.id.button_interceptup_sin);
        button_interceptup.setText("U");

        RelativeLayout.LayoutParams p7 = new RelativeLayout.LayoutParams(110, 110);
        p7.addRule(RelativeLayout.ALIGN_LEFT, sin_intercept.getId());
        p7.addRule(RelativeLayout.ABOVE, sin_intercept.getId());
        //p7.setMarginStart(-20);
        p7.setMargins(-35,0,0,-50);

        this.addView(button_interceptup, p7);


        Button button_interceptdown = new Button(this.getContext());
        button_interceptdown.setText("D");

        button_interceptdown.setId(R.id.button_interceptdown_sin);
        RelativeLayout.LayoutParams p8 = new RelativeLayout.LayoutParams(110, 110);
        p8.addRule(RelativeLayout.ALIGN_LEFT, sin_intercept.getId());
        p8.addRule(RelativeLayout.BELOW, sin_intercept.getId());
        p8.setMargins(-35,-50,0,0);

        this.addView(button_interceptdown, p8);


        button_slopup.setOnClickListener(this);
        button_slopdown.setOnClickListener(this);

        button_interceptup.setOnClickListener(this);
        button_interceptdown.setOnClickListener(this);


/////////////////////////////////////////////////////////////////////////////////////////////////



        TextView functionG = new TextView(this.getContext());
        functionG.setText("y2 = p(x) = ");
        functionG.setTextSize(fontsize_g);
        functionG.setTextColor(Color.BLUE);
        functionG.setId(View.generateViewId());

        sin_slop_functionG_a = new EditText(this.getContext());
        sin_slop_functionG_a.setEnabled(false);
        sin_slop_functionG_a.setId(View.generateViewId());
        sin_slop_functionG_a.setTextSize(fontsize_g);
        // slop_functionG_a.setText("a");
        sin_slop_functionG_a.setTextColor(Color.RED);

        TextView functionf = new TextView(this.getContext());
        functionf.setText("w(");
        functionf.setTextSize(fontsize_g+10);
        functionf.setId(View.generateViewId());
        functionf.setTextColor(Color.BLACK);


        sin_slop_functionG_b = new EditText(this.getContext());
        sin_slop_functionG_b.setEnabled(false);
        sin_slop_functionG_b.setId(View.generateViewId());
        sin_slop_functionG_b.setTextSize(fontsize_g);
        // sin_slop_functionG_b.setText("b");
        sin_slop_functionG_b.setTextColor(Color.RED);

        TextView functionfkuahu = new TextView(this.getContext());
        functionfkuahu.setText("(");
        functionfkuahu.setTextSize(fontsize_g);
        functionfkuahu.setId(View.generateViewId());
        functionfkuahu.setTextColor(Color.BLUE);


        TextView functionfx = new TextView(this.getContext());
        functionfx.setText("x");
        functionfx.setTextSize(fontsize_g);
        functionfx.setId(View.generateViewId());
        functionfx.setTextColor(Color.BLUE);


        TextView functionfplus = new TextView(this.getContext());
        functionfplus.setText("-");
        functionfplus.setTextSize(fontsize_g);
        functionfplus.setId(View.generateViewId());
        functionfplus.setTextColor(Color.BLUE);



        sin_functionG_x_intercept_h = new EditText(this.getContext());
        sin_functionG_x_intercept_h.setEnabled(false);
        sin_functionG_x_intercept_h.setId(View.generateViewId());
        sin_functionG_x_intercept_h.setTextSize(fontsize_g);
//        sin_functionG_x_intercept_h.setText("h");
        sin_functionG_x_intercept_h.setTextColor(Color.YELLOW);





        TextView functionfxend = new TextView(this.getContext());
        functionfxend.setText(")");
        functionfxend.setTextSize(fontsize_g);
        functionfxend.setId(View.generateViewId());
        functionfxend.setTextColor(Color.BLUE);


        TextView functionfxend1 = new TextView(this.getContext());
        functionfxend1.setText(")");
        functionfxend1.setTextSize(fontsize_g+10);
        functionfxend1.setId(View.generateViewId());
        functionfxend1.setTextColor(Color.BLACK);



        TextView functionfplus2 = new TextView(this.getContext());
        functionfplus2.setText("+");
        functionfplus2.setTextSize(fontsize_g);
        functionfplus2.setId(View.generateViewId());
        functionfplus2.setTextColor(Color.BLUE);





        sin_functionG_y_intercept_k = new EditText(this.getContext());
        sin_functionG_y_intercept_k.setEnabled(false);
        sin_functionG_y_intercept_k.setId(View.generateViewId());
        sin_functionG_y_intercept_k.setTextSize(fontsize_g);
//        sin_functionG_y_intercept_k.setText("k");
        sin_functionG_y_intercept_k.setTextColor(Color.YELLOW);



        RelativeLayout.LayoutParams g1 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
//        g1.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
//        g1.addRule(RelativeLayout.ALIGN_PARENT_TOP);
//        g1.setMargins(420, 420, 0, 0);

        g1.addRule(RelativeLayout.RIGHT_OF, sin_intercept.getId());
        g1.addRule(RelativeLayout.ALIGN_BASELINE, sin_intercept.getId());


        this.addView(functionG, g1);

        RelativeLayout.LayoutParams g2 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        g2.addRule(RelativeLayout.RIGHT_OF, functionG.getId());
        g2.addRule(RelativeLayout.ALIGN_BASELINE, functionG.getId());
        g2.setMarginStart(-10);

        this.addView(sin_slop_functionG_a, g2);

        RelativeLayout.LayoutParams g3 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        g3.addRule(RelativeLayout.RIGHT_OF, sin_slop_functionG_a.getId());
        g3.addRule(RelativeLayout.ALIGN_BASELINE, sin_slop_functionG_a.getId());

        this.addView(functionf, g3);


        RelativeLayout.LayoutParams g4 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        g4.addRule(RelativeLayout.RIGHT_OF, functionf.getId());
        g4.addRule(RelativeLayout.ALIGN_BASELINE, functionf.getId());
        this.addView(sin_slop_functionG_b, g4);


        RelativeLayout.LayoutParams g5 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        g5.addRule(RelativeLayout.RIGHT_OF, sin_slop_functionG_b.getId());
        g5.addRule(RelativeLayout.ALIGN_BASELINE, sin_slop_functionG_b.getId());
        this.addView(functionfkuahu, g5);


        RelativeLayout.LayoutParams g6 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        g6.addRule(RelativeLayout.RIGHT_OF, functionfkuahu.getId());
        g6.addRule(RelativeLayout.ALIGN_BASELINE, functionfkuahu.getId());
        this.addView(functionfx, g6);



        RelativeLayout.LayoutParams g7 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        g7.addRule(RelativeLayout.RIGHT_OF, functionfx.getId());
        g7.addRule(RelativeLayout.ALIGN_BASELINE, functionfx.getId());
        this.addView(functionfplus, g7);



        RelativeLayout.LayoutParams g8 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        g8.addRule(RelativeLayout.RIGHT_OF, functionfplus.getId());
        g8.addRule(RelativeLayout.ALIGN_BASELINE, functionfplus.getId());
        this.addView(sin_functionG_x_intercept_h, g8);


        RelativeLayout.LayoutParams g9 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        g9.addRule(RelativeLayout.RIGHT_OF, sin_functionG_x_intercept_h.getId());
        g9.addRule(RelativeLayout.ALIGN_BASELINE, sin_functionG_x_intercept_h.getId());
        this.addView(functionfxend, g9);




        RelativeLayout.LayoutParams g10 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        g10.addRule(RelativeLayout.RIGHT_OF, functionfxend.getId());
        g10.addRule(RelativeLayout.ALIGN_BASELINE, functionfxend.getId());
        this.addView(functionfxend1, g10);

        RelativeLayout.LayoutParams g10_ = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        g10_.addRule(RelativeLayout.RIGHT_OF, functionfxend1.getId());
        g10_.addRule(RelativeLayout.ALIGN_BASELINE, functionfxend1.getId());
        this.addView(functionfplus2, g10_);


        RelativeLayout.LayoutParams g11 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        g11.addRule(RelativeLayout.RIGHT_OF, functionfplus2.getId());
        g11.addRule(RelativeLayout.ALIGN_BASELINE, functionfplus2.getId());
        this.addView(sin_functionG_y_intercept_k, g11);





        Button button_a_up = new Button(this.getContext());
        button_a_up.setId(R.id.button_a_up_sin);
        button_a_up.setText("a");

        RelativeLayout.LayoutParams paup = new RelativeLayout.LayoutParams(110, 110);
        paup.addRule(RelativeLayout.ALIGN_LEFT, sin_slop_functionG_a.getId());
        paup.addRule(RelativeLayout.ABOVE, sin_slop_functionG_a.getId());
        paup.setMargins(-45,0,0,-30);
        this.addView(button_a_up, paup);




        Button button_a_down = new Button(this.getContext());
        button_a_down.setId(R.id.button_a_down_sin);
        button_a_down.setText("a");

        RelativeLayout.LayoutParams padown = new RelativeLayout.LayoutParams(110, 110);
        padown.addRule(RelativeLayout.ALIGN_LEFT, sin_slop_functionG_a.getId());
        padown.addRule(RelativeLayout.BELOW, sin_slop_functionG_a.getId());
        padown.setMargins(-45,-40,0,0);
        this.addView(button_a_down, padown);


        Button button_b_up = new Button(this.getContext());
        button_b_up.setId(R.id.button_b_up_sin);
        button_b_up.setText("b");

        RelativeLayout.LayoutParams pbup = new RelativeLayout.LayoutParams(110, 110);
        pbup.addRule(RelativeLayout.ALIGN_LEFT, sin_slop_functionG_b.getId());
        pbup.addRule(RelativeLayout.ABOVE, sin_slop_functionG_b.getId());
        pbup.setMargins(-45,0,0,-30);
        this.addView(button_b_up, pbup);




        Button button_b_down = new Button(this.getContext());
        button_b_down.setId(R.id.button_b_down_sin);
        button_b_down.setText("b");

        RelativeLayout.LayoutParams pbdown = new RelativeLayout.LayoutParams(110, 110);
        pbdown.addRule(RelativeLayout.ALIGN_LEFT, sin_slop_functionG_b.getId());
        pbdown.addRule(RelativeLayout.BELOW, sin_slop_functionG_b.getId());
        pbdown.setMargins(-45,-40,0,0);
        this.addView(button_b_down, pbdown);





        Button button_h_up = new Button(this.getContext());
        button_h_up.setId(R.id.button_h_up_sin);
        button_h_up.setText("h");

        RelativeLayout.LayoutParams phup = new RelativeLayout.LayoutParams(110, 110);
        phup.addRule(RelativeLayout.ALIGN_LEFT, sin_functionG_x_intercept_h.getId());
        phup.addRule(RelativeLayout.ABOVE, sin_functionG_x_intercept_h.getId());
        phup.setMargins(-35,0,0,-30);
        this.addView(button_h_up, phup);




        Button button_h_down = new Button(this.getContext());
        button_h_down.setId(R.id.button_h_down_sin);
        button_h_down.setText("h");

        RelativeLayout.LayoutParams phdown = new RelativeLayout.LayoutParams(110, 110);
        phdown.addRule(RelativeLayout.ALIGN_LEFT, sin_functionG_x_intercept_h.getId());
        phdown.addRule(RelativeLayout.BELOW, sin_functionG_x_intercept_h.getId());
        phdown.setMargins(-35,-40,0,0);
        this.addView(button_h_down, phdown);






        Button button_k_up = new Button(this.getContext());
        button_k_up.setId(R.id.button_k_up_sin);
        button_k_up.setText("k");

        RelativeLayout.LayoutParams pkup = new RelativeLayout.LayoutParams(110, 110);
        pkup.addRule(RelativeLayout.ALIGN_LEFT, sin_functionG_y_intercept_k.getId());
        pkup.addRule(RelativeLayout.ABOVE, sin_functionG_y_intercept_k.getId());
        pkup.setMargins(-35,0,0,-30);
        this.addView(button_k_up, pkup);




        Button button_k_down = new Button(this.getContext());
        button_k_down.setId(R.id.button_k_down_sin);
        button_k_down.setText("k");

        RelativeLayout.LayoutParams pkdown = new RelativeLayout.LayoutParams(110, 110);
        pkdown.addRule(RelativeLayout.ALIGN_LEFT, sin_functionG_y_intercept_k.getId());
        pkdown.addRule(RelativeLayout.BELOW, sin_functionG_y_intercept_k.getId());
        pkdown.setMargins(-35,-40,0,0);
        this.addView(button_k_down, pkdown);




        button_a_up.setOnClickListener(this);
        button_b_up.setOnClickListener(this);
        button_h_up.setOnClickListener(this);
        button_k_up.setOnClickListener(this);



        button_a_down.setOnClickListener(this);
        button_b_down.setOnClickListener(this);
        button_h_down.setOnClickListener(this);
        button_k_down.setOnClickListener(this);



    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3f);

        canvas.drawCircle(285,130,100,paint);
        canvas.drawCircle(255,450,130,paint);

        paint.setStrokeWidth(8f);
        paint.setColor(Color.GRAY);


        canvas.drawLine(0,290,this.getWidth(),290,paint);

    }
}