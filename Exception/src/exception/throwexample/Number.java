/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception.throwexample;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Iresh
 */
public class Number {
 public int mark;
 
    public void compare() {
        try{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Mark ");
        mark=scanner.nextInt();
        if (mark < 45) {
            throw new ArithmeticException("not valid");
        } else {
            System.out.println("Pass");
        }
        }catch(InputMismatchException e){
              e.printStackTrace();
    }
    

}


    public static void main(String args[]) {
        Number n = new Number();
        n.compare();
    }
}
