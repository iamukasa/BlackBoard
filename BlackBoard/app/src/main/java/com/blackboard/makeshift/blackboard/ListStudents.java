package com.blackboard.makeshift.blackboard;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;


public class ListStudents extends Constants{
    SharedPreferences mBlackBoardSettings;
    ArrayList <StudentsDetailsObject> studentsdetails;
    ArrayList <ListItem> listToShow;
    ListView show;
    Button addmore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_students);
        mBlackBoardSettings =
                getSharedPreferences(BLACKBOARD_PREFERENCES, Context.MODE_PRIVATE);
        studentsdetails=new ArrayList<StudentsDetailsObject>();
        listToShow=new ArrayList<ListItem>();
        show=(ListView)findViewById(R.id.listStudents);
        addmore=(Button)findViewById(R.id.addMore);

  String jsonAllMembers=mBlackBoardSettings.getString(BLACKBOARD_STUDENT_DETAILS,null);
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<StudentsDetailsObject>>() {}.getType();
        studentsdetails= gson.fromJson(jsonAllMembers, listType);

        for(int i=0;i<studentsdetails.size();i++){
            listToShow.add(new ListItem(studentsdetails.get(i).getAdminno(),studentsdetails.get(i).getName()));
        }



        ListItemAdapter adapters = new ListItemAdapter(getApplicationContext(),
                R.layout.list_item, listToShow);
        show.setAdapter(adapters);

         show.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 Intent i=new Intent(getApplicationContext(),ViewSingleStudent.class);
                 i.putExtra("id", position);
                 startActivity(i);

             }
         });

addmore.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Gson gson = new Gson();
        String jsonMembers= gson.toJson(studentsdetails);
        SharedPreferences.Editor editor = mBlackBoardSettings.edit();
        editor.putString(BLACKBOARD_STUDENT_DETAILS,jsonMembers );
        editor.commit();
        Intent i=new Intent(getApplicationContext(),EnterStudentsData.class);
        startActivity(i);
    }
});




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_students, menu);
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
