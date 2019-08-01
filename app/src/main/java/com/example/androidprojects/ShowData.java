package com.example.androidprojects;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidprojects.model.Student;

public class ShowData extends AppCompatActivity {

    TextView idstu,namestu,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        idstu = (TextView) findViewById(R.id.stuId);
        namestu = (TextView) findViewById(R.id.stuName);
        email = (TextView) findViewById(R.id.stuEmail);

        Bundle mBundle = getIntent().getExtras();
//        String name = mBundle.getString("name");
//        int id = mBundle.getInt("id");
        Student s = (Student)mBundle.getParcelable("student");

        idstu.setText(s.getId());
        namestu.setText(s.getName());
        email.setText(s.getEmail());




    }
}
