package com.example.kristoffrey.dayoftheweek;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonRun(View view){
        Integer mm, yyyy, day, m, y, c, d;
        String year, sy, sc, output;
        EditText idd, imm, iyyyy;
        TextView out;
        out = (TextView)findViewById(R.id.text_Out);
        idd = (EditText)findViewById(R.id.in_dd);
        imm = (EditText)findViewById(R.id.in_mm);
        iyyyy = (EditText)findViewById(R.id.in_yyyy);
        day = Integer.parseInt(idd.getText().toString());    //doesn't need to be adjusted according to the formula
        mm = Integer.parseInt(imm.getText().toString());
        yyyy = Integer.parseInt(iyyyy.getText().toString());
        if((mm==1) || (mm==2)){     //checks if we are on the "previous year"
            yyyy=yyyy-1;
            m=mm+12;
        }
        else{
            m=mm;
        }
        year = yyyy.toString();
        sy = year.substring(2, 4);
        sc = year.substring(0, 2);
        y = Integer.parseInt(sy);
        c = Integer.parseInt(sc);
        d = (day+ (26*m+26)/(10) + y + y/4 +c/4 +5*c)%7;
        output = "The date " + imm.getText().toString() +"/"+idd.getText().toString()+"/"+ iyyyy.getText().toString()+ " ";
        switch(d){
            case 2:
                output = output.concat("is on a Monday");
                break;
            case 3:
                output = output.concat("is on a Tuesday");
                break;
            case 4:
                output = output.concat("is on a Wednesday");
                break;
            case 5:
                output = output.concat("is on a Thursday");
                break;
            case 6:
                output = output.concat("is on a Friday");
                break;
            case 0:
                output = output.concat("is on a Saturday");
                break;
            case 1:
                output = output.concat("is on a Sunday");
                break;
        }
        out.setText(output);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
