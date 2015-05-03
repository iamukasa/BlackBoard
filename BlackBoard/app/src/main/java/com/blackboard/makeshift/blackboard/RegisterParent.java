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


public class RegisterParent extends Constants {
    SharedPreferences mBlackBoardSettings;
    EditText entChldAdmin,entChldSchool,entChldClass;
    Button chldSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_parent);
        mBlackBoardSettings =
                getSharedPreferences(BLACKBOARD_PREFERENCES, Context.MODE_PRIVATE);
        entChldAdmin=(EditText)findViewById(R.id.regParentEntAdmin);
        entChldSchool=(EditText)findViewById(R.id.regParentEntSchool);
        entChldClass=(EditText)findViewById(R.id.regParentEntClass);
        chldSave=(Button)findViewById(R.id.regParentBtnSave);

        chldSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String admin=entChldAdmin.getText().toString();
                String cls=entChldClass.getText().toString();
                String schl=entChldSchool.getText().toString();

                SharedPreferences.Editor editor = mBlackBoardSettings.edit();
                editor.putString(BLACKBOARD_STUDENT_ADMIN,admin );
                editor.commit();

                SharedPreferences.Editor editor2 = mBlackBoardSettings.edit();
                editor2.putString(BLACKBOARD_STUDENT_SCHOOL,schl );
                editor2.commit();

                SharedPreferences.Editor editor3= mBlackBoardSettings.edit();
                editor3.putString(BLACKBOARD_STUDENT_CLASS,cls );
                editor3.commit();





                Intent i=new Intent(getApplicationContext(),MyChildDetails.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"Details Saved",Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register_parent, menu);
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
