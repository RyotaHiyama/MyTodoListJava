package com.hiyama.mytodolistjava;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddList extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addlist);

        EditText addListTxt = findViewById(R.id.addListText);

        Button addBtn = findViewById(R.id.addButton);
        Button backBtn = findViewById(R.id.backButton);

        addBtn.setOnClickListener( v -> {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("list",String.valueOf(addListTxt.getText()));
            Log.i("list", String.valueOf(addListTxt.getText()));
            setResult(Activity.RESULT_OK, resultIntent);
            finish();
        });

        backBtn.setOnClickListener( view -> {
            finish();
        });
    }
}
