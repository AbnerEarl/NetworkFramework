package com.example.frank.networkframework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.frank.networkframework.client.HttpICallbackImpl;
import com.example.frank.networkframework.proxy.HttpHelper;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private String url="http://c.3g.163.com/photo/api/set/0001%2F2250173.json";
    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.button);
        textView=findViewById(R.id.textView);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String,Object> params=new HashMap<>();
                HttpHelper.getInstance().post(url, params, new HttpICallbackImpl<String>() {

                    @Override
                    public void onSuccess(String s) {
                        textView.setText(s);

                    }

                    @Override
                    public void onFailure(String e) {
                        Toast.makeText(MainActivity.this,e,Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}
