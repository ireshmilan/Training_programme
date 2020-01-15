/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package innerclassexample;

/**
 *
 * @author Iresh
 */
 class Student {
     
    protected class LocalStudent{//Inner class can declared private, public,protected but private inner class not access other classes 
        
    private int sId;
    private String name;
    
    public void setsId(int sid){
    this.sId=sid;
    }
    public void setname(String name){
    this.name=name;
    }
    
    public int getsId(){
    return sId;
    }
    public String getname(){ 
    return name;
    }
  
    }
    public void display(){
    LocalStudent ls = new LocalStudent();
    ls.setsId(1);
    ls.setname("Iresh");
        System.out.println(ls.getsId()+" "+ls.getname());
    }
}
