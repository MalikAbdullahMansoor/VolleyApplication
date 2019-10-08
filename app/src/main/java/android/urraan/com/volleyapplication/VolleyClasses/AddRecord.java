package android.urraan.com.volleyapplication.VolleyClasses;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AddRecord {
    Context context;

    public AddRecord(Context context){
        this.context=context;
    }
    public void AddRecordFunction(String Family_Cast,String Name,String Age,String Gender){

        Response.Listener<String>listener= new Response.Listener<String>(){

            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    String message=jsonObject.getString("message");
                    boolean isSuccess=jsonObject.getBoolean("Success");
                    if(isSuccess){
                        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.d("AddRecordFunctionLog","Response :"+response);
            }
        };


        AddRecordRequest addRecordRequest= new AddRecordRequest(Family_Cast,Name,Age,Gender,listener);
        RequestQueue queue=Volley.newRequestQueue(context);
        queue.add(addRecordRequest);


    }

    public class AddRecordRequest extends StringRequest{

        private Map<String,String> params;
        public AddRecordRequest(String Family_Cast,String Name, String Age, String Gender, Response.Listener<String> listener) {
            super(Method.POST,ServerUrls.Insertion,listener,null);
            params=new HashMap<>();
            params.put("Family_Cast",Family_Cast);
            params.put("Name",Name);
            params.put("Age",Age);
            params.put("Gender",Gender);
        }


        public Map<String, String> getParams()
        {
            return params;
        }
    }
}
