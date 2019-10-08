package android.urraan.com.volleyapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.urraan.com.volleyapplication.VolleyClasses.DeleteRecord;
import android.urraan.com.volleyapplication.VolleyClasses.UpdateRecord;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateRecordActivity extends AppCompatActivity {
    EditText family1,names,age,gender,id;
    Button btnSave,btnclear,btnDelete,btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_record);
        id=findViewById(R.id.textView2);
        family1=findViewById(R.id.textView1);
        names=findViewById(R.id.textView4);
        age=findViewById(R.id.textView3);
        gender=findViewById(R.id.textView5);
        btnSave=findViewById(R.id.button);
        btnclear=findViewById(R.id.button2);
        btnDelete=findViewById(R.id.button1);
       // btnNext=findViewById(R.id.button4);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Uid=id.getText().toString();
                String Ufamily=family1.getText().toString();
                String Uname=names.getText().toString();
                String Uage=age.getText().toString();
                String Ugender=gender.getText().toString();

                UpdateRecord updateRecord=new UpdateRecord(UpdateRecordActivity.this);
                updateRecord.UpdateRecordFunction(Uid,Ufamily,Uname,Uage,Ugender);
                Toast.makeText(UpdateRecordActivity.this, "Record Update Successfully", Toast.LENGTH_SHORT).show();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Uid=id.getText().toString();
                DeleteRecord deleteRecord=new DeleteRecord(UpdateRecordActivity.this);
                deleteRecord.DeleteRecordFunction(Uid);
                Toast.makeText(UpdateRecordActivity.this, "Delete Record Successfully", Toast.LENGTH_SHORT).show();
            }
        });
        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id.setText("");
                family1.setText("");
                names.setText("");
                age.setText("");
                gender.setText("");
            }
        });
    }

}
