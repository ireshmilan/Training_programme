/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberformatexception;

/**
 *
 * @author Iresh
 */
public class NumberFormatExceptionExample {
    public static void main(String[] args) {
        try {
            String number="123.11";
        int no=Integer.parseInt(number);
            System.out.println(no);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        
        
        
    }
}
