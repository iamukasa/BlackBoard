package com.blackboard.makeshift.blackboard;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class SplashActivity extends Constants{
    static final int CHOOSE_REG=0;
    SharedPreferences mBlackBoardSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mBlackBoardSettings =
                getSharedPreferences(BLACKBOARD_PREFERENCES, Context.MODE_PRIVATE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(mBlackBoardSettings.contains(BLACKBOARD_TEACHER_NAME) &
                        mBlackBoardSettings.contains(BLACKBOARD_STUDENT_DETAILS)){
                    Intent i=new Intent(getApplicationContext(),ListStudents.class);
                    startActivity(i);
                }else if(mBlackBoardSettings.contains(BLACKBOARD_STUDENT_CLASS)){
                    Intent i=new Intent(getApplicationContext(),RegisterParent.class);
                    startActivity(i);


                }else if (mBlackBoardSettings.contains(BLACKBOARD_TEACHER_NAME)){

                    Intent i=new Intent(getApplicationContext(),EnterStudentsData.class);
                    startActivity(i);

                }else if(mBlackBoardSettings.contains(BLACKBOARD_STUDENT_CLASS) &
                        mBlackBoardSettings.contains(BLACKBOARD_STUDENT_ADMIN)&
                        mBlackBoardSettings.contains(BLACKBOARD_STUDENT_SCHOOL)) {
                    Intent i = new Intent(getApplicationContext(), MyChildDetails.class);
                    startActivity(i);
                }
                else{
                    SplashActivity.this.showDialog(CHOOSE_REG);

                }



            }
        },3* 1000); // wait for 3 seconds
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash, menu);
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
    @Override
    protected Dialog onCreateDialog(final int id){
        switch(id){
            case CHOOSE_REG:
                final LayoutInflater inflater3 =
                        (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View layoutswrong =
                        inflater3.inflate(R.layout.register_dialogue,
                                (ViewGroup) findViewById(R.id.reg_dig));
                final Button wrn=(Button)layoutswrong.findViewById(R.id.rAsparent);
                wrn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i=new Intent(getApplicationContext(),RegisterParent.class);
                        startActivity(i);

                    }
                });
                final Button wrne=(Button)layoutswrong.findViewById(R.id.rAsTeacher);
                wrne.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i=new Intent(getApplicationContext(),RegisterTeacher.class);
                        startActivity(i);

                    }
                });

                final AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
                builder3.setView(layoutswrong);
                final AlertDialog lDialog11 = builder3.create();
                return lDialog11;
        }
        return null;
    }
}
