/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package normalexample;

/**
 *
 * @author Iresh
 */
class NormalExample {
    private int sNo;
    private String name;
    private int age;
    private String school="ABC";

    public void setsNo(int sNo) {
        this.sNo = sNo;
    }
    public void setname(String name){
        this.name=name;
    }
    public void setage(int age){
        this.age=age;
    }
    
    public int getsNo() {
        return sNo;
    }
    public String getname(){
        return name;
    }
    public int getage(){
        return age;
    } 
    public String getschool(){
        return school;
    }
}
