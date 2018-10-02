package edu.upf.smartpills;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    //TextView to display developers information
    TextView about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        //Create and set the String containing the persistent information about the developers.
        about = findViewById(R.id.aboutTextView);
        String ab = "<b>" + "SmartPills" + "</b> <br>App Version 1.0<br>" +
                "Copyright © 2018<br>" +
                "All rights reserved<br>" +
                "Owned by SmartPills Corp<br>" +
                "smartpills@info.com<br>" +
                "Used GitHub Library<br>" +
                "Used Android Library<br>" +
                "<br>" + "<b>Created and Designed by:</b> <br> - Jorge Córdova <br> - Arnau Garcia <br> - Marti Guasch" +
                "<br> - Miquel Puerto";
        about.setText(Html.fromHtml(ab,Html.FROM_HTML_SEPARATOR_LINE_BREAK_BLOCKQUOTE));
    }

}
