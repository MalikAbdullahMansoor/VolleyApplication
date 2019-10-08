package android.urraan.com.volleyapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.urraan.com.volleyapplication.VolleyClasses.GetAllData;
import android.urraan.com.volleyapplication.VolleyClasses.ModelObject;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class GetAllRecordActivity extends AppCompatActivity {
TextView record;
Button getall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_all_record);

        record=findViewById(R.id.textView6);
        getall=findViewById(R.id.button);

        getall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetAllData getAllData= new GetAllData(GetAllRecordActivity.this);
                getAllData.GetAllDataFunction();
         //       record.setText( getAllData);
                record.append( getAllData);
             //   record.append( List<ModelObject>.list);

            }
        });
    }
}
