/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsa_projee;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author MONSTER
 */
public class Rsa_projee {

    
    public static void main(String[] args) {
        
            
        
        
		  Scanner input = new Scanner(System.in);
		  
		  System.out.print("Şifrelenecek metni giriniz : ");
		  
		  String metin = input.nextLine();
		 
		  input.close();
		  
		  RSA_Fonksiyon rsa = new RSA_Fonksiyon(metin); 
		  
		  System.out.println(rsa.stringSifreleme());

		  System.out.println(rsa.StringDeşifreleme());
        
    }
    
}
