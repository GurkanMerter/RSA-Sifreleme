package rsa_proje;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;
import sun.nio.cs.ext.Big5;



public class RSA_Fonksiyon {
   
   
	static String alınan_text;
	static BigInteger n2;
	static BigInteger ascii;
	static BigInteger e2;
	static BigInteger d2;
	static char[] charlist;
	static char[] şifreliste;
        static char[] deşifreliste;

	
        
	
	public RSA_Fonksiyon(String txt) {

		this.alınan_text = txt;

		charlist = txt.toCharArray();
                
		int p = 47;
		int q = 43;
		int n = p * q;
		int aradasal = (p - 1) * (q - 1);
		int e;                                      
                
		Random random = new Random();
 
                 do{
                     
                      e=random.nextInt(aradasal);           //genel anahtar
                     
                 }while(ebobal(e,aradasal)!=1);

                int d = çarpmatersi(aradasal, e);           //özel anahtar
                System.out.println(e);
                System.out.println(d);

		n2 = BigInteger.valueOf(n);
		e2 = BigInteger.valueOf(e);
		d2 = BigInteger.valueOf(d);
	}
        
                public int ebobal(int x,int y){
    
                if(y==0){
                 return x;
                 }else{
            
                    return ebobal(y, x%y);
                 }
                
                 }
 
                
        private static BigInteger şifrelenmişAscii(BigInteger nBig, BigInteger ascii, BigInteger e) {

		BigInteger çarpılmışascii = BigInteger.valueOf(1);

		for (int i = 1; i <= e.intValue(); i++) {

			çarpılmışascii = ascii.multiply(çarpılmışascii);
                        
		}
                
		BigInteger c = BigInteger.valueOf(1);

		c = çarpılmışascii.mod(nBig);

		return c;
	}
        
        
        
        public char[] stringSifreleme() {

		şifreliste = new char[charlist.length];

		int index = 0;

		for (char harf : charlist) {

			int ascii = (int) harf;

			RSA_Fonksiyon.ascii = BigInteger.valueOf(ascii);

			BigInteger c = şifrelenmişAscii(n2, RSA_Fonksiyon.ascii, e2);

			şifreliste[index++] = (char) c.intValue();
		}

		return şifreliste;

	}

	public char[] StringDeşifreleme() {

                deşifreliste = new char[charlist.length];

		int index = 0;

		for (char harf : şifreliste) {

			BigInteger c = BigInteger.valueOf((int) harf);

			BigInteger de = şifrelenmişAscii(n2, c, d2);

			deşifreliste[index++] = (char) de.intValue();

		}

		return deşifreliste;

	}

	
	

	private static int çarpmatersi(int asalsınır, int e) {

		for (int k = 1; k < asalsınır; k++) {

			if (((asalsınır * k + 1) % e) == 0) {

				return (((asalsınır * k) + 1) / e);
			}
		}

		return 0;
	}
        
    
	
}