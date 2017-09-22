package com.example.emj.selfstudyandroid_calculator;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView formulaTextView;
    TextView resultTextView;
    String displayNumber = "";
    double result = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setBackgroundColor(Color.WHITE);
        layout.setGravity(Gravity.TOP);

        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);

        layout.addView(formulaTextView = makeTextView("formula", displayNumber));
        layout.addView(resultTextView = makeTextView("result", String.valueOf(result)));



        TableLayout layout_b = new TableLayout(this);
        layout_b.setGravity(Gravity.BOTTOM);

        // ボタン配置
        TableRow tableRow = new TableRow(this);
        tableRow.addView(makeButton("(", "("));
        tableRow.addView(makeButton(")", ")"));
        tableRow.addView(makeButton("%", "%"));
        tableRow.addView(makeButton("AC", "AC"));
        layout_b.addView(tableRow);
        tableRow = new TableRow(this);
        tableRow.addView(makeButton("7", "7"));
        tableRow.addView(makeButton("8", "8"));
        tableRow.addView(makeButton("9", "9"));
        tableRow.addView(makeButton("/", "/"));
        layout_b.addView(tableRow);
        tableRow = new TableRow(this);
        tableRow.addView(makeButton("4", "4"));
        tableRow.addView(makeButton("5", "5"));
        tableRow.addView(makeButton("6", "6"));
        tableRow.addView(makeButton("*", "*"));
        layout_b.addView(tableRow);
        tableRow = new TableRow(this);
        tableRow.addView(makeButton("1", "1"));
        tableRow.addView(makeButton("2", "2"));
        tableRow.addView(makeButton("3", "3"));
        tableRow.addView(makeButton("-", "-"));
        layout_b.addView(tableRow);
        tableRow = new TableRow(this);
        tableRow.addView(makeButton("0", "0"));
        tableRow.addView(makeButton(".", "."));
        tableRow.addView(makeButton("=", "="));
        tableRow.addView(makeButton("+", "+"));
        layout_b.addView(tableRow);

        layout.addView(layout_b);
    }

    public Button makeButton(String tag, String text) {

        Button button = new Button(this);
        button.setText(text);
        button.setTag(tag);
        button.setOnClickListener(this);
        return button;
    }


    public TextView makeTextView(String tag, String text) {
        TextView textView = new TextView(this);
        textView.setTag(tag);
        textView.setText(text);
        return textView;
    }

    public void onClick(View view) {
        Log.d("Info", "Click Button:" + (String)view.getTag());

        if (view.getTag().equals("0") || view.getTag().equals("1") || view.getTag().equals("2")
                || view.getTag().equals("3") || view.getTag().equals("4") || view.getTag().equals("5")
                || view.getTag().equals("6") || view.getTag().equals("7") || view.getTag().equals("8")
                || view.getTag().equals("9") || view.getTag().equals("+") || view.getTag().equals("-")
                || view.getTag().equals("%") || view.getTag().equals("/") || view.getTag().equals("*")
                || view.getTag().equals(".") || view.getTag().equals("(") || view.getTag().equals(")")) {
            displayNumber = displayNumber + view.getTag();
        } else if (view.getTag().equals("AC")) {
            result = 0.0;
            displayNumber = "";
        } else if (view.getTag().equals("=")) {
            result = calculate(displayNumber);
            resultTextView.setText(String.valueOf(result));
        }
        formulaTextView.setText(displayNumber);
    }

    public double calculate(String formula) {
        Expression ex = new ExpressionBuilder(formula).build();
        return ex.evaluate();
    }
}
