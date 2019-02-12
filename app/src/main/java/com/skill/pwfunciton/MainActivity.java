package com.skill.pwfunciton;

import android.app.Application;
import android.arch.lifecycle.Lifecycle;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        LinearLayout mainlayoutpanel = new LinearLayout(this.getApplicationContext());
        mainlayoutpanel.setOrientation(LinearLayout.VERTICAL);
        setContentView(mainlayoutpanel);


        FunctionGraphView functionGraphView =new FunctionGraphView(this.getApplicationContext());

        functionGraphView.setApplication(this.getApplication());

        ((FWApplication)this.getApplication()).functionGraphView = functionGraphView;

        LinearLayout.LayoutParams p1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT,1);
        mainlayoutpanel.addView(functionGraphView,p1);

        GraphConfigPanel graphConfigPanel = new GraphConfigPanel(this.getApplicationContext());

        graphConfigPanel.setApplication(this.getApplication());


//        LayoutInflater layoutInflater=this.getLayoutInflater();
//        View configpanel =layoutInflater.inflate(R.layout.graphconfig,null);
//

        LinearLayout.LayoutParams p2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,590,0);
        mainlayoutpanel.addView(graphConfigPanel,p2);

        graphConfigPanel.setApplication(this.getApplication());


    }

}
