package com.example.testapp1;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button_open_form2);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                TextView editor = (TextView) findViewById(R.id.textView);
                EditText answerText = (EditText) findViewById(R.id.answerFirstText);
                Integer newnum= Integer.parseInt(answerText.getText().toString());
                newnum+=Integer.parseInt( editor.getText().toString());
                editor.setText(newnum.toString());
                intent.putExtra("message", newnum.toString());
                startActivityForResult(intent, 10);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10) {
            if (resultCode == Activity.RESULT_OK) {
                String result = data.getStringExtra("result");
                TextView editor = (TextView) findViewById(R.id.textView);
                Integer newnum= Integer.parseInt(result);
                newnum+=Integer.parseInt( editor.getText().toString());
                editor.setText(newnum.toString());
                EditText answerText = (EditText) findViewById(R.id.answerFirstText);
                answerText.setText("");
            }
        }
    }

}