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
public class EncapDemostrate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        NormalExample student = new NormalExample();
        NormalExample student1 = new NormalExample();
        student.setsNo(1);
        student.setname("Iresh");
        student.setage(24);
        student1.setsNo(2);
        student1.setage(27);
        student1.setname("Kamal");
        System.out.println(student1.getsNo()+" "+student1.getschool());
        System.out.println(student.getsNo()+" "+student.getname()+" "+student.getage()+" "+student.getschool());
    }
    
}
