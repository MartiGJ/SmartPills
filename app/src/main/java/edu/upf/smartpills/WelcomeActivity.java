package edu.upf.smartpills;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class WelcomeActivity extends AppCompatActivity {
    //This activity shows the apps logo an initializes the database
    private static int SPLASH_TIME_OUT = 1000;
    private ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_welcome);

        //Logo Image
        logo = findViewById(R.id.logo);
        //Logo animation
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.logo_transition);
        logo.startAnimation(myanim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //If a user already exists in the database we jump directly to the Calendar Activity
                //otherwise we go to Welcome Activity so that a user can be added

                Intent homeIntent = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(homeIntent);

                finish();

            }
        }, SPLASH_TIME_OUT);
    }
}
