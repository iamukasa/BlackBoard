package com.blackboard.makeshift.blackboard;

/**
 * Created by irving on 5/3/15.
 */
public class StudentsDetailsObject {
    private String adminno;
    private String name;
    private String sclass;

    private String math;
    private String english;
    private String kiswahili;
    private String science;
    private String social;
    private String cre;
    private String tchcomments;



    public StudentsDetailsObject(String Adminno,String Name,String Sclass,String Math,String English,
    String Kiswahili,String Science,String Social,String Cre,String Tchcomments){
        this.adminno=Adminno;
        this.name=Name;
        this.sclass=Sclass;
        this.math=Math;
        this.english=English;
        this.kiswahili=Kiswahili;
        this.science=Science;
        this.social=Social;
        this.cre=Cre;
        this.tchcomments=Tchcomments;

    }

    public String getAdminno() {
        return adminno;
    }

    public void setAdminno(String adminno) {
        this.adminno = adminno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass;
    }

    public String getMath() {
        return math;
    }

    public void setMath(String math) {
        this.math = math;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english ) {
        this.english= english;
    }

    public String getKiswahili() {
        return kiswahili;
    }

    public void setKiswahili(String kiswahili) {
        this.kiswahili = kiswahili;
    }

    public String getScience() {
        return science;
    }

    public void setScience(String science ) {
        this.science= science;
    }

    public String getSocial() {
        return social;
    }

    public void setSocial(String social) {
        this.social= social;
    } public String getCre() {
        return cre;
    }

    public void setCre(String cre ) {
        this.cre= cre;
    }

    public String getTchcomments() {
        return tchcomments;
    }

    public void setTchcomments(String tchcomments) {
        this.tchcomments= tchcomments;
    }





}
