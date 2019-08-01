package com.example.androidprojects;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText userEmail,userPassword;
    Button btnLogin;
    SharedPreferences msharedPreferences;
    CheckBox rememberMe;
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
        msharedPreferences = this.getSharedPreferences("login",MODE_PRIVATE);
        if (msharedPreferences.contains("UserEmail")){
            userEmail.setText(msharedPreferences.getString("UserEmail",""));
            userPassword.setText(msharedPreferences.getString("UserPassword",""));
        }


    }

    private void initView(){
        userEmail = (EditText) findViewById(R.id.edtUserEmail);
        userPassword = (EditText) findViewById(R.id.edtUserPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        rememberMe =(CheckBox)findViewById(R.id.rememberMe);

    }
    private void login(){
        String email = userEmail.getText().toString();
        String password = userPassword.getText().toString();

        // for error.....
//        if (email.isEmpty() || email.trim().length() == 0 ) {
//
//            userEmail.setError("Enter Email ID");
//        }

            if (email.equals("Admin") && password.equals("admin")) {
                               SharedPreferences.Editor myEditor = msharedPreferences.edit();

                if(rememberMe.isChecked()) {
                    myEditor.putString("UserEmail", email);
                    myEditor.putString("UserPassword", password);
                    rememberMe.setChecked(true);
                }else{
                    myEditor.remove("UserEmail");
                    myEditor.remove("UserPassword");
                    rememberMe.setChecked(false);
                }

                myEditor.apply();



                //Toast.makeText(getApplicationContext(), "Logged In", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(),HomeActivity.class);
                i.putExtra("email",email);

//                Bundle mBundle = new Bundle();
//                mBundle.putInt("id",100);
//                mBundle.putString("email",email);
//                i.putExtra("all",mBundle);
                startActivity(i);
                //finish();
            }
            else {
                Toast.makeText(getApplicationContext(), "Error Wrong Email or Password", Toast.LENGTH_SHORT).show();
            }

    }
}
