package android.urraan.com.volleyapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.urraan.com.volleyapplication.VolleyClasses.ServerUrls;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    public EditText names;
    public Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        names=findViewById(R.id.textView1);
        login=(Button)findViewById(R.id.button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name=names.getText().toString().trim();
                if(!Name.isEmpty()){
                    Login(Name);
                }else{
                    names.setError("Please Enter your Name");
                }
            }
        });
    }
    public void Login(final String Name){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, ServerUrls.Login1, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject= new JSONObject(response);
                    String success=jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("Login1");
                    if(success.equals("1")){
                        for(int i=0; i< jsonArray.length();i++){
                            JSONObject object=jsonArray.getJSONObject(i);
                            String Name=object.getString("Name").trim();
                            String Age=object.getString("Age").trim();
                            String Gender=object.getString("Gender").trim();
                            Toast.makeText(LoginActivity.this, "Success Login\n Your Name : "+Name+"\nYour Age :"+Age+"\nYour Gender :"+Gender, Toast.LENGTH_SHORT).show();
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(LoginActivity.this, "Error"+e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LoginActivity.this, "Error"+error.toString(), Toast.LENGTH_SHORT).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String>params=new HashMap<>();
                params.put("Name", String.valueOf(Name));
                return params;
            }
        };
        RequestQueue queue=Volley.newRequestQueue(this);
        queue.add(stringRequest);
    }
}
