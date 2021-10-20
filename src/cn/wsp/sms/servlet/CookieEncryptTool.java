package cn.wsp.sms.servlet;

import java.io.UnsupportedEncodingException;
import org.apache.tomcat.util.codec.binary.Base64;

public class CookieEncryptTool {

	
	/*
	 * Base64º”√‹
	 */
	
 	 public  static String  encodeBase64 (String cleartext){
 		 try{
 			 cleartext = new String (Base64.encodeBase64(cleartext.getBytes("UTF-8")));
 		 } catch(UnsupportedEncodingException e){
 			 e.printStackTrace();
 		 }
 		 
 		 return cleartext;
 		 
 	 }
 	 
 	 /*
 	  * Base64Ω‚√‹
 	  */
 	  public static String decodeBase64 (String ciphertext){
		
 		  try {
 			  ciphertext = new  String(Base64.decodeBase64(ciphertext.getBytes()),"UTF-8");
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
 		  return ciphertext;
 		  
 	  }
}
