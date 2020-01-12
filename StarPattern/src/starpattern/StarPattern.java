/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starpattern;

import java.util.Scanner;

/**
 *
 * @author Iresh
 */
public class StarPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i;
        int j;
        int k;
        int rows;
        Scanner scanner = new Scanner(System.in);
        System.out.println("How may Rows Do you need?");
        rows = scanner.nextInt();

        for (i = 1; i <= rows; i++) {
            for (j = rows - 1; j >= i; j--) {
                System.out.print(" ");

            }
            for (k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println("");

        }
        //System.out.println("");
        for (i = rows - 1; i >= 1; i--) {
            for (j = rows - 1; j >= i; j--) {
                System.out.print(" ");
            }
            for (k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

}
