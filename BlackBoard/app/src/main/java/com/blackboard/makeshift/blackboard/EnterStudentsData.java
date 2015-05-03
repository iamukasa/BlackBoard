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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;


public class EnterStudentsData extends Constants{
    Button save,done;
    EditText editAdmin,editName,editClass,editMath,editEnglish,editKiswahili,editScience,editSocial,
            editCre,editComments;
ArrayList <StudentsDetailsObject> er;


    SharedPreferences mBlackBoardSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_students_data);
        mBlackBoardSettings =
                getSharedPreferences(BLACKBOARD_PREFERENCES, Context.MODE_PRIVATE);

er=new ArrayList<StudentsDetailsObject>();
       save=(Button)findViewById(R.id.btneditSave);
        done=(Button)findViewById(R.id.btneditDone);

        editAdmin=(EditText)findViewById(R.id.teditAdmin);
        editName=(EditText)findViewById(R.id.teditName);
        editClass=(EditText)findViewById(R.id.teditClass);
        editMath=(EditText)findViewById(R.id.teditMath);
        editEnglish=(EditText)findViewById(R.id.teditEnglish);
        editKiswahili=(EditText)findViewById(R.id.teditKiswahili);
        editScience=(EditText)findViewById(R.id.teditScience);
        editSocial=(EditText)findViewById(R.id.teditSocial);
        editCre=(EditText)findViewById(R.id.teditCre);
        editComments=(EditText)findViewById(R.id.teditComments);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
 String tAdmin=editAdmin.getText().toString();
 String tName=editName.getText().toString();
 String tClass=editClass.getText().toString();
 String tMath=editMath.getText().toString();
 String tEnglish=editEnglish.getText().toString();
 String tKiswahili=editKiswahili.getText().toString();
 String tScience=editScience.getText().toString();
  String tSocial=editSocial.getText().toString();
    String tCre=editCre.getText().toString();
      String tComments=editCre.getText().toString();



   er.add(new StudentsDetailsObject(tAdmin,
         tName,
        tClass,tMath,
        tEnglish,
        tKiswahili,
        tScience,
        tSocial,
        tCre,
        tComments));

           editAdmin.clearComposingText();
                editName.clearComposingText();
                editClass.clearComposingText();
                editMath.clearComposingText();
                editEnglish.clearComposingText();
                editKiswahili.clearComposingText();
                editScience.clearComposingText();
                editSocial.clearComposingText();
                editCre.clearComposingText();
                editComments.clearComposingText();



            }
        });

   done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gson gson = new Gson();
                String jsonMembers= gson.toJson(er);
                SharedPreferences.Editor editor = mBlackBoardSettings.edit();
                editor.putString(BLACKBOARD_STUDENT_DETAILS,jsonMembers );
                editor.commit();


                Intent i=new Intent(getApplicationContext(),ListStudents.class);
                startActivity(i);

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_enter_students_data, menu);
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
    public  void onStart(){
        if(mBlackBoardSettings.contains(BLACKBOARD_STUDENT_DETAILS)){
            String jsonAllMembers=mBlackBoardSettings.getString(BLACKBOARD_STUDENT_DETAILS,null);
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<StudentsDetailsObject>>() {}.getType();
            er= gson.fromJson(jsonAllMembers, listType);
        }
        super.onStart();
    }
}
