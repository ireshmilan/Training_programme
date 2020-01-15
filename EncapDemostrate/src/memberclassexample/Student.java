/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memberclassexample;

/**
 *
 * @author Iresh
 */
public class Student {

    public void display() {
        
    class LocalStudent{
    private int sNo;
    private String name;
    
    public void setsNo(int sno){
    this.sNo=sno;
    }
    public void setname(String name){
    this.name=name;
    }
    public int getsNo(){
    return sNo;
    }
    public String getname(){
    return name;
    }
    }
    
    LocalStudent ls= new LocalStudent();
    ls.setsNo(1);
    ls.setname("iresh");
        System.out.println(ls.getsNo()+" "+ls.getname());
    }
    
}
