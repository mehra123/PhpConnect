package com.example.mehra.phpconnect;

import android.app.DownloadManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    TextView t1;
    TextView t2;
    String URL_POST="https://servetechnoresearch.com/Emotion/hupreg.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hup);

        Button b1=findViewById(R.id.button);
        t1=findViewById(R.id.textView);
         t2=findViewById(R.id.textView2);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsertSV();
            }
        });
    }

        private void InsertSV(){

            StringRequest stringRequest=new StringRequest(Request.Method.POST,URL_POST,new Response.Listener<String>(){
                @Override
                public void onResponse(String response){
                    Toast.makeText(MainActivity.this,response,Toast.LENGTH_SHORT).show();
                }
            },new Response.ErrorListener(){
                @Override
                public void onErrorResponse(VolleyError error){
                    Toast.makeText(MainActivity.this,"error",Toast.LENGTH_SHORT).show();
                }

            }){
                @Override
                protected Map<String,String> getParams()throws AuthFailureError{
                    Map<String,String> params=new HashMap<String,String>();
                    String value1=t1.getText().toString();
                    String value2=t2.getText().toString();

                    params.put("NAME",value1);
                    params.put("EMAIL",value2);
                    return params;

                }
            };



RequestQueue requestQueue= Volley.newRequestQueue(this);
    requestQueue.add(stringRequest);
    }
}
