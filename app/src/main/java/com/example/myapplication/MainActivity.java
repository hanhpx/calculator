package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.input);
        display.setShowSoftInputOnFocus(false);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getString(R.string.display).equals(display.getText().toString()))
                {
                    display.setText("");
                }
            }
        });
    }

    private void updateText(String strToAdd)
    {
        String oldstr = display.getText().toString();
        int cursorpPos = display.getSelectionStart();
        String leftstr = oldstr.substring(0, cursorpPos);
        String rightstr = oldstr.substring(cursorpPos);
        display.setText(String.format("%s%s%S",leftstr,strToAdd,rightstr));
        display.setSelection(cursorpPos+1);
    }

    public void clearBT (View view){
        display.setText("");
    }
    public void zeroBT (View view){
        updateText("0");
    }
    public void oneBT (View view){
        updateText("1");
    }
    public void twoBT (View view){
        updateText("2");
    }
    public void threeBT (View view){
        updateText("3");
    }
    public void fourBT (View view){
        updateText("4");
    }
    public void fiveBT (View view){
        updateText("5");
    }
    public void sixBT (View view){
        updateText("6");
    }
    public void sevenBT (View view){
        updateText("7");
    }
    public void eightBT (View view){
        updateText("8");
    }
    public void nineBT (View view){
        updateText("9");
    }
    public void divideBT (View view){
        updateText("÷");
    }
    public void multiplyBT (View view){
        updateText("×");
    }
    public void addBT (View view){
        updateText("+");
    }
    public void subtractBT (View view){
        updateText("-");
    }
    public void plusminusBT (View view){
        updateText("-");
    }
    public void commaBT (View view){
        updateText(",");
    }
    public void percentBT (View view){
        updateText("%");
    }
    public void equalsBT (View view){
        String userexp = display.getText().toString();
        userexp = userexp.replace("÷", "/");
        userexp = userexp.replace("×", "*");

        Expression exp = new Expression(userexp);

        String result = String.valueOf((exp.calculate()));

        display.setText(result);
        display.setSelection((result.length()));
    }
}