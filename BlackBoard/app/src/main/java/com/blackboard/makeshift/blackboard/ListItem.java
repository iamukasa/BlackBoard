package com.blackboard.makeshift.blackboard;

/**
 * Created by irving on 5/3/15.
 */
public class ListItem {
    private String AdminNo;
    private String studentName;


    public ListItem(String adminnoo, String studentname) {
        this.AdminNo = adminnoo;
        this.studentName=studentname;
        this.setStudentName(studentname);

    }

    public String getAdminNo() {
        return AdminNo;
    }

    public void setAdminNo(String adminnoo) {
        this.AdminNo= adminnoo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentname) {
        this.studentName= studentname;
    }



}