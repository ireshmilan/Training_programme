/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiply;

/**
 *
 * @author Iresh
 */
public class Multiply {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i;
        int y;
        int mul;
        
        for (i = 1; i < 10; i++) {
            System.out.print("" + i + " |");

            for (y = 1; y < 10; y++) {
                // System.out.println("");
                mul = y * i;
                System.out.print("  " + mul + "");
            }
            System.out.println("");
        }
    }

}
