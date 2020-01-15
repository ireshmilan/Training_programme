/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arithmaticexception;

/**
 *
 * @author Iresh
 */
public class ArithmaticExceptionExample {

    public static void main(String[] args) {

        try {
            int a = 20;
            int b = 0;

            int c = a / b;
            System.out.println("Answer is " + c);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }

    }

}
