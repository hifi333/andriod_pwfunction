package com.skill.pwfunciton;

import android.app.Application;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by eviewlake on 2019/2/9.
 */

public class FunctionGraphView extends View {

    FWApplication fwApplication = null;

    int horizontalXexamples_quadrant1 = 10;  //length map to : widht/2
    int verticalYexamples_quadrant1 = 20;   //length map to: heidth/2

    int horizontalXexamples_quadrant1_sin = 540;  //length map to : widht/2
    int verticalYexamples_quadrant1_sin = 8;   //length map to: heidth/2



    int width =0;
    int height =0;
    Paint mainPaint;

    public FunctionGraphView(Context context) {
        super(context);

        mainPaint = new Paint(1);
        mainPaint.setColor(Color.BLACK);


     //   this.setBackgroundColor(Color.GRAY);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        width = this.getWidth();
        height = this.getHeight();

        horizontalXexamples_quadrant1_sin = width/2;
        System.out.println("FunctionGraphView:" + width+"," + height);

        Point centeral = new Point(width/2,height/2);
        Point leftcenter = new Point(0,height/2);
        Point rightcenter = new Point(width,height/2);

        Point topcenter = new Point(width/2,0);
        Point bottomcenter = new Point(width/2,height);



        canvas.drawLine(leftcenter.x,leftcenter.y,rightcenter.x,rightcenter.y,mainPaint);
        canvas.drawLine(topcenter.x,topcenter.y,bottomcenter.x,bottomcenter.y,mainPaint);


        String msg = "sin transformation";
        if(!this.fwApplication.singraph)
             msg = "liner transformation";

        mainPaint.setTextSize(50);
        canvas.drawText(msg,(int)10,(int)height/8,mainPaint);

        canvas.drawText("--pw 2019 Feb. 11",(int)120,(int)height/8+100,mainPaint);


        mainPaint.setTextSize(10);


        if( fwApplication.singraph)
            drawGraph_sin(canvas);
        else
           drawlinerGraph(canvas);



    }

    private void drawlinerGraph(Canvas canvas){

        ArrayList coordinate_horizontal = new ArrayList();
        for(int i=-horizontalXexamples_quadrant1;i<=horizontalXexamples_quadrant1;i++) {
            Point tempdrawpoint = getXY(i, 0);
            coordinate_horizontal.add(tempdrawpoint);

            if(i!=0) {
                canvas.drawText("" + i, tempdrawpoint.x-5, tempdrawpoint.y + 20, mainPaint);
                canvas.drawCircle(tempdrawpoint.x,tempdrawpoint.y,3,mainPaint);

            }

        }
        drawlinerGraph(canvas,coordinate_horizontal,mainPaint);

        ArrayList coordinate_vertical = new ArrayList();
        for(int i=-verticalYexamples_quadrant1;i<=verticalYexamples_quadrant1;i++) {
            Point tempdrawpoint = getXY(0, i);
            coordinate_vertical.add(tempdrawpoint);
            if(i!=0) {
                canvas.drawText("" + i, tempdrawpoint.x + 20, tempdrawpoint.y+5, mainPaint);
                canvas.drawCircle(tempdrawpoint.x,tempdrawpoint.y,3,mainPaint);

            }
        }
        drawlinerGraph(canvas,coordinate_vertical,mainPaint);


        //开始画rootfunction graph

        ArrayList linepoints = new ArrayList();
        for(int i=-horizontalXexamples_quadrant1;i<=horizontalXexamples_quadrant1;i++) {
            float y = rootfunction(i);
            if(Math.abs(y) <= verticalYexamples_quadrant1) {
                Point tempdrawpoint = getXY(i, y);
                // canvas.drawCircle(tempdrawpoint.x,tempdrawpoint.y,7,mainPaint);
                linepoints.add(tempdrawpoint);
            }
        }

        Paint paint = new Paint();
        paint.setColor(Color.GRAY);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(6f);

        drawlinerGraph(canvas,linepoints,paint);

        //开始画transformation 的funciton


        ArrayList linepoints_transformation = new ArrayList();
        for(int i=-horizontalXexamples_quadrant1;i<=horizontalXexamples_quadrant1;i++) {
            float y = transformationfunction_of_rootfunction(i);
            if(Math.abs(y) <= verticalYexamples_quadrant1) {
                Point tempdrawpoint = getXY(i, y);
                // canvas.drawCircle(tempdrawpoint.x,tempdrawpoint.y,7,mainPaint);
                linepoints_transformation.add(tempdrawpoint);
            }
        }

        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(6f);

        drawlinerGraph(canvas,linepoints_transformation,paint);


    }

    private void drawGraph_sin(Canvas canvas){

        mainPaint.setTextSize(15);

        ArrayList coordinate_horizontal = new ArrayList();
        for(int i=50;i<=horizontalXexamples_quadrant1_sin;i=i+50) {
            Point tempdrawpoint = getXY_sin(i, 0);
            coordinate_horizontal.add(tempdrawpoint);

            // i means  pi/100, to show  pi/2 shoud mutiply 50

            canvas.drawText(""+ 0.5 * i/50 , tempdrawpoint.x - 5, tempdrawpoint.y + 20, mainPaint);
            canvas.drawText("pi", tempdrawpoint.x - 5, tempdrawpoint.y + 40, mainPaint);
            canvas.drawCircle(tempdrawpoint.x, tempdrawpoint.y, 3, mainPaint);



            tempdrawpoint = getXY_sin(-i, 0);
            coordinate_horizontal.add(tempdrawpoint);

            // i means  pi/100, to show  pi/2 shoud mutiply 50

            canvas.drawText("-"+ 0.5 * i/50 , tempdrawpoint.x - 5, tempdrawpoint.y + 20, mainPaint);
            canvas.drawText("pi", tempdrawpoint.x - 5, tempdrawpoint.y + 40, mainPaint);
            canvas.drawCircle(tempdrawpoint.x, tempdrawpoint.y, 3, mainPaint);




        }
        drawlinerGraph(canvas,coordinate_horizontal,mainPaint);

        ArrayList coordinate_vertical = new ArrayList();
        for(int i=-verticalYexamples_quadrant1_sin;i<=verticalYexamples_quadrant1_sin;i++) {
            Point tempdrawpoint = getXY_sin(0, i);
            coordinate_vertical.add(tempdrawpoint);
            if(i!=0) {
                canvas.drawText("" + i, tempdrawpoint.x + 20, tempdrawpoint.y+5, mainPaint);
                canvas.drawCircle(tempdrawpoint.x,tempdrawpoint.y,3,mainPaint);

            }
        }
        drawlinerGraph(canvas,coordinate_vertical,mainPaint);


        //11开始画rootfunction graph
        ArrayList linepoints = new ArrayList();
        for(int i=-horizontalXexamples_quadrant1_sin;i<=horizontalXexamples_quadrant1_sin;i++) {
            double y = rootfunction_sin(i*Math.PI/100);
            if(Math.abs(y) <= verticalYexamples_quadrant1_sin) {
                Point tempdrawpoint = getXY_sin(i, (float) y);
//                 canvas.drawCircle(tempdrawpoint.x,tempdrawpoint.y,1,mainPaint);
                linepoints.add(tempdrawpoint);
            }
        }

        Paint paint = new Paint();
        paint.setColor(Color.GRAY);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(6f);

        drawlinerGraph(canvas,linepoints,paint);

       // 22开始画transformation 的funciton
        ArrayList linepoints_transformation = new ArrayList();
        for(int i=-horizontalXexamples_quadrant1_sin;i<=horizontalXexamples_quadrant1_sin;i++) {
            double y = transformationfunction_of_rootfunction_sin(i*Math.PI/100);
            if(Math.abs(y) <= verticalYexamples_quadrant1_sin) {
                Point tempdrawpoint = getXY_sin(i, (float) y);
                // canvas.drawCircle(tempdrawpoint.x,tempdrawpoint.y,7,mainPaint);
                linepoints_transformation.add(tempdrawpoint);
            }
        }

        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(6f);

       drawlinerGraph(canvas,linepoints_transformation,paint);


    }


    private float rootfunction(float x){

        //y=bx+k;
        float y = fwApplication.slob *x + fwApplication.intercept;

        return y;
    }

    private double rootfunction_sin(double x){

        //y=b*sin(x) +k;
        double y = fwApplication.sin_slob *Math.sin(x) + fwApplication.sin_intercept;

        return y;
    }

    private float transformationfunction_of_rootfunction(float x){

        //y1 = g(x) = af(b(x-h)) +k

        float y1 = fwApplication.g_a * rootfunction(fwApplication.g_b*(x-fwApplication.g_h)) + fwApplication.g_k;

        return y1;
    }



    private double transformationfunction_of_rootfunction_sin(double x){

        //y1 = g(x) = af(b(x-h)) +k

        double y1 = fwApplication.sin_g_a * rootfunction_sin(fwApplication.sin_g_b*(x-fwApplication.sin_g_h)) + fwApplication.sin_g_k;

        return y1;
    }


    private void drawlinerGraph(Canvas canvas,ArrayList linepoints,Paint paint){

        Path path= new Path();



        for(int i=0;i<linepoints.size();i++){
            Point onePoint = (Point)linepoints.get(i);
           if(i==0)   path.moveTo(onePoint.x,onePoint.y);
            else  path.lineTo(onePoint.x,onePoint.y);
        }

        canvas.drawPath(path,paint);
    }


    private Point getXY(float domain,float range){

        float drawx =0;
        float drawy =0;
        if( domain >=0 && domain <= horizontalXexamples_quadrant1)
             drawx = width/2 +  (width/2/horizontalXexamples_quadrant1 * domain);
        else if( domain <0 && Math.abs(domain) <= horizontalXexamples_quadrant1)
             drawx =width/2/horizontalXexamples_quadrant1 * (horizontalXexamples_quadrant1-( Math.abs(domain)));

        if( range >=0 && range <= verticalYexamples_quadrant1)
            drawy = height/2- height/2/verticalYexamples_quadrant1 * range;
        else if( range <0 && Math.abs(range) <= verticalYexamples_quadrant1)
            drawy =height/2 + height/2/verticalYexamples_quadrant1 *  Math.abs(range);


        System.out.println("domain,range:" + domain+"," + range + " ==>X,Y:" + drawx + "," + drawy);

        return new Point((int)drawx,(int)drawy);

    }


    private Point getXY_sin(float domain,float range){

        float drawx =0;
        float drawy =0;
        if( domain >=0 && domain <= horizontalXexamples_quadrant1_sin)
            drawx = width/2 +  (width/2/horizontalXexamples_quadrant1_sin * domain);
        else if( domain <0 && Math.abs(domain) <= horizontalXexamples_quadrant1_sin)
            drawx =width/2/horizontalXexamples_quadrant1_sin * (horizontalXexamples_quadrant1_sin-( Math.abs(domain)));

        if( range >=0 && range <= verticalYexamples_quadrant1_sin)
            drawy = height/2- height/2/verticalYexamples_quadrant1_sin * range;
        else if( range <0 && Math.abs(range) <= verticalYexamples_quadrant1_sin)
            drawy =height/2 + height/2/verticalYexamples_quadrant1_sin *  Math.abs(range);


        System.out.println(width +"/"+ height +" domain,range:" + domain+"  ,  " + range + " ==>X, Y:" + drawx + "  ,  " + drawy);

        return new Point((int)drawx,(int)drawy);

    }

    public void setApplication(Application mainapp){
        this.fwApplication = (FWApplication) mainapp;

    }
}
