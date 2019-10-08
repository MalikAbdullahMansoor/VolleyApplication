package android.urraan.com.volleyapplication.VolleyClasses;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetAllData implements CharSequence {
    Context context;

    public GetAllData(Context context){
        this.context=context;
    }
    public void GetAllDataFunction(){

        Response.Listener<String>listener= new Response.Listener<String>(){

            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    String message=jsonObject.getString("message");
                    boolean isSuccess=jsonObject.getBoolean("success");

                    List<ModelObject> list=new ArrayList<>();

                    JSONArray jsonArray=jsonObject.getJSONArray("full_info");

                    if(jsonArray !=null && jsonArray.length()>0){
                        for(int i=0; i<jsonArray.length();i++){
                            JSONObject object=jsonArray.getJSONObject(i);
                            ModelObject modelObject= new ModelObject();
                            String id=object.getString("id");
                            String Family_Cast=object.getString("Family_Cast");
                            String Name=object.getString("Name");
                            String Age=object.getString("Age");
                            String Gender=object.getString("Gender");
                            list.add(modelObject);

                            modelObject.setId(id);
                            modelObject.setFamily_Cast(Family_Cast);
                            modelObject.setName(Name);
                            modelObject.setAge(Age);
                            modelObject.setGender(Gender);

                            Log.d("GetAllDataFunctionLog","id :"+id);
                            Log.d("GetAllDataFunctionLog","Family :"+Family_Cast);
                            Log.d("GetAllDataFunctionLog","Name :"+Name);
                            Log.d("GetAllDataFunctionLog","Age :"+Age);
                            Log.d("GetAllDataFunctionLog","Gender :"+Gender);



                        }
                        Log.d("GetAllDataFunctionLog","list :"+list.size());

                    }

                    if(isSuccess){
                        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        };


        GetAllDataRequest getalldataRequest= new GetAllDataRequest(listener);
        RequestQueue queue=Volley.newRequestQueue(context);
        queue.add(getalldataRequest);


    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public char charAt(int index) {
        return 0;
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }






    public class GetAllDataRequest extends StringRequest {

        private Map<String,String> params;
        public GetAllDataRequest(Response.Listener<String> listener) {
            super(Method.POST,ServerUrls.GETAll,listener,null);
            setRetryPolicy(new DefaultRetryPolicy(3000,0,1));
            params=new HashMap<>();

        }


        public Map<String, String> getParams()
        {
            return params;
        }
    }
}

