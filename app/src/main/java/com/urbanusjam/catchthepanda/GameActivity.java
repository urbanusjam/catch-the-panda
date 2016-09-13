package com.urbanusjam.catchthepanda;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ImageButton panda = (ImageButton) findViewById(R.id.panda_image);

        final Display display = getWindowManager().getDefaultDisplay();
        final Rect screenSize = new Rect();
        display.getRectSize(screenSize);

        panda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Rect bounds = panda.getDrawable().getBounds();

                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) panda.getLayoutParams();

                Random random = new Random();
                int topMargin = random.nextInt(screenSize.height() - panda.getHeight());
                int leftMargin = random.nextInt(screenSize.width() - panda.getWidth());
//                panda.setX(topMargin);
//                panda.setY(leftMargin);
                layoutParams.setMargins(leftMargin, topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                panda.setLayoutParams(layoutParams);

            }
        });

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

//    private void setMargins(View view, int left, int top, int right, int bottom) {
//        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//        lp.setMargins(left, top, right, bottom);
//        view.setLayoutParams(lp);
//
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
