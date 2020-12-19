package com.event.management.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class UploadImage {

	
	Properties prop = new Properties();
	String resourceName = "common.properties"; 
	String basePath=null;

	
	public String uploadPicture(MultipartFile file_upload,Long eventId ,int imageNumber,HttpServletRequest request){
		
		
		String fileName=eventId+"_"+imageNumber;
		 String fullPath=null;
		 String savefilePath=null;

			try {
				prop=CommonUtility.loadPropertyFile(resourceName);
				basePath=prop.getProperty("file.upload.base.upload.path");
				
				

				
				
				String userPath =eventId.toString();
				
				String savePath = basePath + File.separator + userPath ;
				        
				        
				        
							if(!file_upload.isEmpty()){
								 String originalfilename=file_upload.getOriginalFilename();
						         String fileExtension=originalfilename.substring(originalfilename.indexOf("."),originalfilename.length());
								         if(fileExtension.equals(".JPG") || fileExtension.equals(".PNG") || fileExtension.equals(".JPEG") || fileExtension.equals(".GIF") || fileExtension.equals(".jpg") || fileExtension.equals(".jpeg") ||
												fileExtension.equals(".png") ||fileExtension.equals(".gif")){
										
								         
								        
										 
													 System.out.println("Extension---"+fileExtension);
													 byte[] bytes = file_upload.getBytes();
													 File dir = new File(savePath);
													 
													    if (!dir.exists())
														dir.mkdirs();
													    fileExtension=".jpg";
														String filename=null;
										           		filename=fileName+fileExtension;
										           		fullPath=dir.getAbsolutePath() + File.separator +filename;
										           		File serverFile = new File(fullPath);
										           		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
										           		stream.write(bytes);
										           		stream.close();
											        
										           		//savefilePath="upload" + File.separator + userForm.getEmail()  +File.separator +filename;
										           		savefilePath= userPath +File.separator +filename;
								        
						         }
							}
				        
	}catch(Exception e){
		System.out.println("Exception "+e);
	}
			return savefilePath;
	}

}
