package com.hiyama.mytodolistjava;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String data = "";
    List<String> todoList = new ArrayList<String>();
//    TextView testTxt = findViewById(R.id.testText);
//    LinearLayout todoListLayout = findViewById(R.id.linearLayout);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        LinearLayout todoListLayout = findViewById(R.id.linearLayout);
        Button goAddListBtn = findViewById(R.id.goAddList);
        goAddListBtn.setOnClickListener( v -> {
            Intent addList = new Intent(MainActivity.this, AddList.class);
            activityResultLauncher.launch(addList);
        });

    }

    private final ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
       if (result.getResultCode() == RESULT_OK){
           Intent resultIntent = result.getData();
           todoList.add(resultIntent.getStringExtra("list"));
           data = resultIntent.getStringExtra("list");
           addTodoList(data);
           Log.i("data",data);
           Toast.makeText(this, data, Toast.LENGTH_LONG).show();
       }
    });

    private void addTodoList(String todoList){
        LinearLayout todoListLayout = findViewById(R.id.linearLayout);
        TextView text = new TextView(this);
        text.setText(todoList);
        todoListLayout.addView(text);
    }
}