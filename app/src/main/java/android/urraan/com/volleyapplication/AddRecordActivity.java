package android.urraan.com.volleyapplication;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.urraan.com.volleyapplication.VolleyClasses.AddRecord;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

public class AddRecordActivity extends AppCompatActivity {
    EditText family1, names, age, gender;
    Button btnSave, btnclear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);



        family1 = findViewById(R.id.textView2);
        names = findViewById(R.id.textView4);
        age = findViewById(R.id.textView3);
        gender = findViewById(R.id.textView5);

        btnSave = findViewById(R.id.button);
        btnclear = findViewById(R.id.button2);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddRecord addRecord=new AddRecord(AddRecordActivity.this);
                addRecord.AddRecordFunction(family1.getText().toString(),names.getText().toString(),age.getText().toString(),gender.getText().toString());
                Toast.makeText(AddRecordActivity.this, "User Registered Successfully", Toast.LENGTH_SHORT).show();
            }
        });


    }
}