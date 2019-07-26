package com.example.day1basics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvData;
    Button btnShowAlert;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initViews();
//        Intent i = getIntent();
//        name = i.getStringExtra("email");
//        tvData.setText(name);

        btnShowAlert.setOnClickListener(this);
        // alternative method....
        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null && mBundle.containsKey("email")){
            String name1 = mBundle.getString("email");
            tvData.setText(name1);
        }

    }
    private void initViews(){
        tvData = (TextView)findViewById(R.id.tvFromPrevious);
        btnShowAlert = (Button)findViewById(R.id.btnAlert);
    }

    @Override
    public void onClick(View view) {
        showAlertBox();
    }
    private void showAlertBox(){

    }
}
