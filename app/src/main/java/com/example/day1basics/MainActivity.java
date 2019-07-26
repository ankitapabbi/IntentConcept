package com.example.day1basics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText userEmail,userPassword;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             login();
            }
        });
    }

    private void initView(){
        userEmail = (EditText) findViewById(R.id.edtUserEmail);
        userPassword = (EditText) findViewById(R.id.edtUserPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);

    }
    private void login(){
        String email = userEmail.getText().toString();
        String password = userPassword.getText().toString();
        if (email.isEmpty() || email.trim().length() == 0 ) {

            userEmail.setError("Enter Email ID");
        }

            if (email.equals("Admin") && password.equals("admin")) {
                //Toast.makeText(getApplicationContext(), "Logged In", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(),HomeActivity.class);
                i.putExtra("email",email);

//                Bundle mBundle = new Bundle();
//                mBundle.putInt("id",100);
//                mBundle.putString("email",email);
//                i.putExtra("all",mBundle);
                startActivity(i);
                //finish();
            } else {
                Toast.makeText(getApplicationContext(), "Error Wrong Email or Password", Toast.LENGTH_SHORT).show();
            }

    }
}
