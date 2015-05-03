package com.blackboard.makeshift.blackboard;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class RegisterTeacher extends Constants {
    SharedPreferences mBlackBoardSettings;
    EditText tchName,tchEmpNo;
    Button tsave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_teacher);
        mBlackBoardSettings =
                getSharedPreferences(BLACKBOARD_PREFERENCES, Context.MODE_PRIVATE);
        tchName=(EditText)findViewById(R.id.regTeacherEditName);
        tchEmpNo=(EditText)findViewById(R.id.regTeacherEditEmpNo);
        tsave=(Button)findViewById(R.id.regTeacherBtnSave);
        tsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=tchName.getText().toString();
                String b=tchEmpNo.getText().toString();
                SharedPreferences.Editor editor = mBlackBoardSettings.edit();
                editor.putString(BLACKBOARD_TEACHER_NAME,a );
                editor.commit();

                SharedPreferences.Editor editor2= mBlackBoardSettings.edit();
                editor2.putString(BLACKBOARD_TEACHER_EMPLOYEE_NO,b );
                editor2.commit();

                Intent i=new Intent(getApplicationContext(),EnterStudentsData.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"Saved",Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register_teacher, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
