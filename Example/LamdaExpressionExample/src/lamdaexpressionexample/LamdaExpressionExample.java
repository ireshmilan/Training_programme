/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lamdaexpressionexample;

/**
 *
 * @author Iresh
 */
public class LamdaExpressionExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Calculate c= x -> x+x; //Using lamda Expression
        int sum=c.power(3);
        System.out.println("Sum is "+sum);
    }
    
}
