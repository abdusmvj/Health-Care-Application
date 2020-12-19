package com.event.management.util;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class CommonUtility {

	public static Properties loadPropertyFile(String fileName){
		Properties prop = new Properties();
		InputStream inputProperties = null;
		try {
							
							ClassLoader loader = Thread.currentThread().getContextClassLoader();
							inputProperties= loader.getResourceAsStream(fileName);
							prop.load(inputProperties);
						
		}
		catch(Exception e){
			
			System.out.println("Exception "+e);
		}
		return prop;
	}
	
	
	public static String getBaseFilePath(){
		String filePath="";
		try {
							
			filePath=System.getProperty("jboss.home.dir");
			filePath=File.separator+"welcome-content";
		}catch(Exception e){
			System.out.println(" GETBASEFILEPATH EXCEPTION => "+e);
		}
	
		return filePath;
	}	
	
	public static String getBaseFilePathUptoUpload(){
		String filePath="";
		try {
							
			filePath=System.getProperty("jboss.home.dir");
			filePath=File.separator+"welcome-content"+File.separator+"upload";
		}catch(Exception e){
			System.out.println(" GETBASEFILEPATHUPTOUPLOAD EXCEPTION => "+e);
		}
	
		return filePath;
	}
	public static String getURL(HttpServletRequest req) {

	    String scheme = req.getScheme();             // http
	    String serverName = req.getServerName();     // hostname.com
	    int serverPort = req.getServerPort();        // 80
	
	    StringBuilder url = new StringBuilder();
	    url.append(scheme).append("://").append(serverName);

	    if (serverPort != 80 && serverPort != 443) {
	        url.append(":").append(serverPort);
	    }

	    
	    return url.toString();
	}
	
	/****JOYDIP ADD/EDIT PARTICIPANT START *******************************/
	public static String createUsernameFromName(String name_of_user){
		 return		CommonUtility.keepAlphabetOnly(""+name_of_user).toUpperCase()+"_"+ ((new RandomString(8).toString()).split("@")[1]);
		 	}
			
			public static String createUserPassword(){
				return (new RandomString(8).toString()).split("@")[1];
				
			}
			
				 
				
			public static int getRandomWithExclusion(Random rnd, int start, int end, int... exclude) {
			  
				/*int numberLeftToChoose=end - start + 1 - exclude.length;
				
				if(numberLeftToChoose<=0){
					return -1;
					
					
			 	}
				
				int random = start + rnd.nextInt();
			    for (int ex : exclude) {
			        if (random < ex) {
			            break;
			        }
			        random++;
			    }
			    return random;*/

int rangeLength = end - start - exclude.length;
    	if(rangeLength<=0){
					return -1;
					
					
			 	}
    int randomInt = (rnd.nextInt(rangeLength) + start) & Integer.MAX_VALUE;

    for(int i = 0; i < exclude.length; i++) {
        if(exclude[i] > randomInt) {
            return randomInt;
        }

        randomInt++;
    }

    return randomInt;
			}
	
	
			public static String keepAlphabetOnly(String s){
				
				 return s.replaceAll("[^A-Za-z]+", "");//.toUpperCase();
				
				
			}
			
			public static boolean isStringInt(String s)
			{
			    try
			    {
			        Integer.parseInt(s);
			        return true;
			    } catch (NumberFormatException ex)
			    {
			        return false;
			    }
			}

			
			public static List<Integer> strListToIntList(List<String> strList){
				List<Integer> intList=new ArrayList<Integer>();
				for(String s : strList) intList.add(Integer.valueOf(s));
				
				return intList;
				
			}
			
			public static int[] intListToIntArray(List<Integer> list){
				
				 
				    int[] ret = new int[list.size()];
				    int i = 0;
				    for (Integer e : list)  
				        ret[i++] = e.intValue();
				    return ret;
				 
			}
			
			/****JOYDIP ADD/EDIT PARTICIPANT END*******************************/
}
