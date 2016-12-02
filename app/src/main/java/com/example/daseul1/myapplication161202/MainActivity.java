package com.example.daseul1.myapplication161202;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import java.util.Calendar;
public class MainActivity extends AppCompatActivity {

    Button b1,b2;
    Chronometer c1;
    RadioButton r1,r2;
    TimePicker t1;
    CalendarView cv1;
    TextView tv1;
    String year,month,day,hour,min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        c1 = (Chronometer) findViewById(R.id.chronometer3);
        r1 = (RadioButton) findViewById(R.id.radioButton);
        r2 = (RadioButton) findViewById(R.id.radioButton2);
        t1 = (TimePicker) findViewById(R.id.timePicker);
        cv1 = (CalendarView) findViewById(R.id.calendarView);
        tv1 = (TextView) findViewById(R.id.textView2);
        t1.setVisibility(View.INVISIBLE);
        cv1.setVisibility(View.INVISIBLE);

        r1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                t1.setVisibility(View.INVISIBLE);
                cv1.setVisibility(View.VISIBLE);
            }
        });

        r2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                t1.setVisibility(View.VISIBLE);
                cv1.setVisibility(View.INVISIBLE);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                c1.setBase(SystemClock.elapsedRealtime());
                c1.start();
                c1.setTextColor(Color.RED);
            }


        });

        b2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                c1.stop();
                c1.setTextColor(Color.BLUE);

                java.util.Calendar curDate = java.util.Calendar.getInstance();
                curDate.setTimeInMillis(cv1.getDate());

                year = Integer.toString(curDate.get(Calendar.YEAR));
                month = Integer.toString(1 + curDate.get(Calendar.MONTH));
                day = Integer.toString(curDate.get(Calendar.DATE));

                hour = Integer.toString(t1.getCurrentHour());
                min = Integer.toString(t1.getCurrentMinute());

                tv1.setText(year+"/"+month+"/"+day+"/"+hour+"/"+min+"/");
            }
        });
    }
}







