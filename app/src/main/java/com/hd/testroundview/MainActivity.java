package com.hd.testroundview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Checkable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.btnClick).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setEnabled(false);
            }
        });


        findViewById(R.id.btnClick2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Checkable checkable= (Checkable) view;
                checkable.toggle();
            }
        });
    }
}
