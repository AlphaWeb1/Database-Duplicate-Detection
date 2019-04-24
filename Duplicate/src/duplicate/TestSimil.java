/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package duplicate;

import java.util.Scanner;

/**
 *
 * @author hp
 */
public class TestSimil {
    public static void main(String[] a){
        Scanner get=new Scanner(System.in);
        System.out.print("Enter The First Word:");
    Simil sm=new Simil(get.next());
//        System.out.println(sm);"Pencilvaneya""Pennsylvania"
        System.out.println("\nEnter The Second Word:");
        System.out.println((double)sm.getSimilarityInPercentFor(get.next())/100);
    
    }
}
