package com.example.se_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
/**
 * The MainActivity class, used to demonstrate the Main activity of the App
 */
public class MainActivity extends AppCompatActivity {
    /**
     * The TextView trial used to show the content on the page of App
     */
    public static TextView trial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //hi
        trial = (TextView)findViewById(R.id.trial);
        new GetPM25().execute();
    }
}
