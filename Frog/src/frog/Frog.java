/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frog;

import java.awt.BorderLayout;
import java.util.Scanner;

/**
 *
 * @author Iresh
 */
public class Frog {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int seconds;
        int distance;
        String type;
        int remaining;
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select Distance or Time");
        type=scanner.next();
        if(type.equals("Distance")){
            System.out.println("Enter Distance");
            distance=scanner.nextInt();
            remaining=distance%9;
            if(remaining==0){
                System.out.println("Waiting Time is"+(distance/9)*8);
            }
            else if(remaining<=5){
                System.out.println("Waiting Time is"+((distance/9)*8+1));
            }
            else if(remaining<=8){
                System.out.println("Waiting Time is"+((distance/9)*8+3));
            }
           
        }
        else if(type.equals("Time")){
        
        }
        else{
            System.out.println("Invalid options...");
    }
        
    }
    
}
