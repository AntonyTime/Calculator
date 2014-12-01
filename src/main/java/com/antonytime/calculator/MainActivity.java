package com.antonytime.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    private EditText scr;
    private float numberBf;
    private String operation;
    private Boolean isResultshow = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        scr = (EditText) findViewById(R.id.display);
    }

    public void mMath(String str){
        numberBf = Float.parseFloat(scr.getText().toString());
        operation = str;
        scr.setText("0");
    }

    public void mResult(){
        float numAf = Float.parseFloat(scr.getText().toString());
        float result = 0;

        if(operation.equals("+")){
            result = numAf + numberBf;
        }
        if(operation.equals("-")){
            result = numberBf - numAf;
        }
        if(operation.equals("*")){
            result = numAf * numberBf;
        }
        if(operation.equals("/")){
            result = numberBf / numAf;
        }
        scr.setText(String.valueOf(result));
        isResultshow = true;

    }

    private void getKeyboard(String str){
        String scrCurrent = scr.getText().toString();
        if(scrCurrent.equals("0"))
            scrCurrent = "";
        scrCurrent += str;
        scr.setText(scrCurrent);
    }

    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnC:
                scr.setText("0");
                numberBf = 0;
                operation = "";
                break;
            case R.id.btnPlus:
                mMath("+");
                break;
            case R.id.btnMinus:
                mMath("-");
                break;
            case R.id.btnMul:
                mMath("*");
                break;
            case R.id.btnDiv:
                mMath("/");
                break;
            case R.id.btnEqual:
                mResult();
                break;
            default:

                String numb = ((Button) view).getText().toString();
                getKeyboard(numb);
                if (isResultshow){
                    scr.setText("0");
                    isResultshow = false;
                }
                break;

            }
        }
    }


