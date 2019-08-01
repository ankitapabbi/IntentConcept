package com.example.androidprojects;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidprojects.model.Student;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvData;
    Button btnShowAlert,submitData;
    String name;
    EditText studentId,studentName,studentEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initViews();
//        Intent i = getIntent();
//        name = i.getStringExtra("email");
//        tvData.setText(name);

        final Student mStudent = new Student();


        btnShowAlert.setOnClickListener(this);
        // alternative method....
        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null && mBundle.containsKey("email")){
            String name1 = mBundle.getString("email");
            tvData.setText(name1);
        }

        submitData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stuId = studentId.getText().toString().trim();
                String stuName = studentName.getText().toString().trim();
                String stuEmail = studentEmail.getText().toString().trim();

                Intent i = new Intent(HomeActivity.this,ShowData.class);
                i.putExtra("id",stuId);
                i.putExtra("name",stuName);
                i.putExtra("email",stuEmail);
                mStudent.setId(stuId);
                mStudent.setName(stuName);
                mStudent.setEmail(stuEmail);
                i.putExtra("student",mStudent);
                startActivity(i);



            }
        });

    }
    private void initViews(){
        tvData = (TextView)findViewById(R.id.tvFromPrevious);
        btnShowAlert = (Button)findViewById(R.id.btnAlert);
        studentId = (EditText) findViewById(R.id.studentId);
        studentEmail = (EditText)findViewById(R.id.studentEmail);
        studentName = (EditText) findViewById(R.id.studentName);
        submitData = (Button)findViewById(R.id.submitData);
    }

    @Override
    public void onClick(View view) {
       // showAlertBox();
        showListAlertDialog();



    }
    private void showAlertBox(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Message");
        alertDialogBuilder.setIcon(R.drawable.ic_action_name);
        alertDialogBuilder.setMessage("Showing the Alert Dialog");
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


            }
        });
        alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDialogBuilder.setNeutralButton("Ignore", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        // STEP 4 Alert Dialog using builder
        AlertDialog mAlertDialog = alertDialogBuilder.create();
        // STEP 5 Show alert dialog
        mAlertDialog.show();
    }

    private  void showListAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
        builder.setTitle("Pick the color")

                .setItems(R.array.color_array, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // The 'which' argument contains the index position
                        // of the selected item
                        String [] colors = getResources().getStringArray(R.array.color_array);
                        Toast.makeText(HomeActivity.this,"You Clicked " + colors[which],Toast.LENGTH_SHORT).show();
                    }
                });
        AlertDialog mAlertDialog = builder.create();
        mAlertDialog.show();
    }

    private void checkAlertBox(){

    }
}
