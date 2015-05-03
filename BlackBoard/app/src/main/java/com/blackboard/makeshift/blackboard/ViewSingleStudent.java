package com.blackboard.makeshift.blackboard;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;


public class ViewSingleStudent extends Constants{
    SharedPreferences mBlackBoardSettings;
    ArrayList<StudentsDetailsObject> studentsdetails;
    TextView editAdmin,editName,editClass,editMath,editEnglish,editKiswahili,editScience,editSocial,
            editCre,editComments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_single_student);
        mBlackBoardSettings =
                getSharedPreferences(BLACKBOARD_PREFERENCES, Context.MODE_PRIVATE);


        String jsonAllMembers=mBlackBoardSettings.getString(BLACKBOARD_STUDENT_DETAILS,null);
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<StudentsDetailsObject>>() {}.getType();
        studentsdetails= gson.fromJson(jsonAllMembers, listType);
        Intent i = getIntent();
        // Selected image id
        int position = i.getExtras().getInt("id");

      String admin_no=studentsdetails.get(position).getAdminno();
      String name=studentsdetails.get(position).getName();
      String stdClass=studentsdetails.get(position).getSclass();
        String sMath=studentsdetails.get(position).getMath();
        String  sEnglish=studentsdetails.get(position).getEnglish();
        String sKiswahili=studentsdetails.get(position).getKiswahili();
        String sScience=studentsdetails.get(position).getScience();
        String sSocial=studentsdetails.get(position).getSocial();
        String sCre=studentsdetails.get(position).getCre();
        String sComments=studentsdetails.get(position).getTchcomments();

        editAdmin=(TextView)findViewById(R.id.stvAdmin);
        editName=(TextView)findViewById(R.id.stvName);
        editClass=(TextView)findViewById(R.id.stvClass);
        editMath=(TextView)findViewById(R.id.stvMath);
        editEnglish=(TextView)findViewById(R.id.stvEnglish);
        editKiswahili=(TextView)findViewById(R.id.stvKiswahili);
        editScience=(TextView)findViewById(R.id.stvScience);
        editSocial=(TextView)findViewById(R.id.stvSocial);
        editCre=(TextView)findViewById(R.id.stvCre);
        editComments=(TextView)findViewById(R.id.stvComments);

        editAdmin.setText(admin_no);
        editName.setText(name);
        editClass.setText(stdClass);
        editMath.setText("Math "+sMath);
        editEnglish.setText("English "+sEnglish);
        editKiswahili.setText("Kiswahili "+sKiswahili);
        editScience.setText("Science "+sScience);
        editSocial.setText("Social Studies "+sSocial);
        editCre.setText("CRE "+sCre);
        editComments.setText(sComments);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_single_student, menu);
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
