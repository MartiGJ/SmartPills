package edu.upf.smartpills;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class LoginActivity extends AppCompatActivity {
    private EditText usernameInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        //Initiate variable to create an animation
        final ViewGroup transitionsContainer = findViewById(R.id.transitions_container);
        final Button button = transitionsContainer.findViewById(R.id.button_nom);
        usernameInput = findViewById(R.id.input_username);

        //On click start the animation and change activity
        button.setOnClickListener(new View.OnClickListener() {
            ViewGroup submit = (ViewGroup) button.getParent();
            ViewGroup nameInput = (ViewGroup) usernameInput.getParent();
            String username;

            public void onClick(View v) {
                //Error if the user name is empty
                if (TextUtils.isEmpty(usernameInput.getText())) {
                    usernameInput.setError("First name is required!");
                    Toast.makeText(getApplicationContext(), "User name is empty", Toast.LENGTH_SHORT).show();
                } else {
                    //Greet the user and add the user name to the DataBase
                    username = usernameInput.getText().toString();
                    //db.myDao().insertUsers(new User(username));
                    submit.removeView(button);
                    nameInput.removeView(usernameInput);

                    TextView myTextView = findViewById(R.id.greeting);
                    myTextView.setText("Hello, " + username);

                    //Change to Calendar activity after 0.5 seconds
                    new Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {
                            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                            finish();
                        }
                    }, 500);
                }


            }

        });
    }
}
