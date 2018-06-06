package com.example.day1rk;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by lenovo on 2018/6/6.
 */

public class Second1 extends AppCompatActivity {

    private Button but;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item1);
        but = findViewById(R.id.but);

but.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(Second1.this, MainActivity.class);
        startActivity(intent);
    }
});

    }
}
