package com.wc.genericUtility;

import java.util.Base64;

public class EncryptedDecryptedUtility{
	/**
	 * this class contains methods for encryption and decryption
	 * @param s
	 * @return
	 */
	
	
	
	
	
	
	/**
	 * this method is used for encoding purpose
	 * @param s
	 * @return
	 */
	
	public String encoding(String s) {
		             byte[] byteA = s.getBytes();
		             byte[] byteB = Base64.getEncoder().encode(byteA);
		             
		              String k=new String(byteB);
		
		              return k;
	}
	
	
	
	/**
	 * this method is used for decoding purpose
	 * @param s
	 * @return
	 */
	public String decoding(String s) {
        byte[] byteC= s.getBytes();
        byte[] byteD = Base64.getDecoder().decode(byteC);
        
         String q=new String(byteD);

         return q;
	}

	
	
}
