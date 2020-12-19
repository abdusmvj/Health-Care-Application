package com.event.management.util;


import java.nio.charset.Charset;
import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.xml.bind.DatatypeConverter;
       

public class EncryptDecrypt {
     
       
       
         /** 
          * Generate key pair and encrypt/decrypt message. 
          * @param args 
         * @throws NoSuchAlgorithmException 
         * @throws NoSuchPaddingException 
         * @throws InvalidKeyException 
         * @throws BadPaddingException 
         * @throws IllegalBlockSizeException 
          * @throws Throwable 
          */  
	
	 

		    private static final String FORMAT = "ISO-8859-1";
		    public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";

		    private KeySpec ks;
		    private SecretKeyFactory skf;
		    private Cipher cipher;
		    SecretKey key;

		    public EncryptDecrypt() throws Exception {

		        String myEncryptionKey = "EVENTMANAGEMENT_7DCF26491AE79C54C768C514CF154";

		        ks = new DESedeKeySpec(myEncryptionKey.getBytes(FORMAT));
		        skf = SecretKeyFactory.getInstance(DESEDE_ENCRYPTION_SCHEME);
		        cipher = Cipher.getInstance(DESEDE_ENCRYPTION_SCHEME);
		        key = skf.generateSecret(ks);
		    }

		    public String encrypt(String unencryptedString) throws Exception {

		        String encryptedString = null;
		        cipher.init(Cipher.ENCRYPT_MODE, key);
		        byte[] plainText = unencryptedString.getBytes(FORMAT);
		        byte[] encryptedText = cipher.doFinal(plainText);
		        encryptedString = DatatypeConverter.printBase64Binary(encryptedText);

		        return encryptedString;
		    }

		    public String decrypt(String encryptedString)  throws Exception {

		        String decryptedText = null;
		        cipher.init(Cipher.DECRYPT_MODE, key);
		        byte[] encryptedText = DatatypeConverter.parseBase64Binary(encryptedString);
		        byte[] plainText = cipher.doFinal(encryptedText);
		        decryptedText = new String(plainText);

		        return decryptedText;
		    }

		   
		    public static String getSpecialCharacter(int code) {

		        Charset charSet = Charset.forName(FORMAT);
		        String specialCharacter = new String(new byte[] { (byte) code }, charSet);
		        specialCharacter = String.format("%s", specialCharacter);

		        return specialCharacter;
		    }
		    
		    public static void main(String[] args) {
		    	try{
		    	EncryptDecrypt e=new EncryptDecrypt();
		    	String a=e.encrypt("123456");
		    	   System.out.println(a);
		    String b=	e.decrypt("EIL3pAYy6es=");
		    System.out.println(b);
		    	}catch(Exception e){
		    		System.out.println("Exception e"+e);
		    	}
			}

		}
	
	

