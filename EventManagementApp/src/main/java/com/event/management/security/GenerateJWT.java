package com.event.management.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.annotation.ComponentScan;


@ComponentScan
public class GenerateJWT {

	//Method to construct a JWT
	public String createJWT(long userId,String userName,Date eventEndDate,String eventEndTime) throws ParseException {
		
	    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String strDate = dateFormat.format(eventEndDate);
        System.out.println("strDate:"+strDate);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = sdf.parse(strDate);
        System.out.println("date:"+date);
        long nowMillis = date.getTime();
	    Date exp = new Date(nowMillis + ((24*60*60 + 1) * 1000));
        System.out.println("exp:"+exp);
        
	    String apiKey = null;
		try {
			apiKey = Jwts.builder()
					  .setSubject(String.valueOf(userId))
					  .setExpiration(exp)
					  .claim("name", userName)
					  .signWith(
					    SignatureAlgorithm.HS256, //The JWT signature algorithm we will be using to sign the token
					    "secret".getBytes("UTF-8")
					  )
					  .compact();
			System.out.println("apiKey:"+ apiKey);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	    return apiKey;
	}
	
	//Method to validate a JWT
	public int parseJWT(String jwt,long userId) {
		try{ 
			Jws<Claims> claims = Jwts.parser()
				        .requireSubject(String.valueOf(userId))
				        .setSigningKey("secret".getBytes("UTF-8"))
				        .parseClaimsJws(jwt);
			
			 System.out.println("ID: " + claims.getBody());
			 System.out.println("Subject: " + claims.getSignature());
			 System.out.println("Issuer: " + claims.getHeader());
			 return 1;
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
	
	
}
