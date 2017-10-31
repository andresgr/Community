package com.asgr.community;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.andres.myapplication.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {
//        EditText editText = findViewById(R.id.editText);
//        System.out.println("editText.getText() = " + editText.getText());
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        String message = "editText.getText().toString()";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

}
