package com.event.management.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.event.management.util.CommonUtility;

@Controller
public class FileAccessController  {

	@Autowired
	ServletContext servletContext;
	
	private String fileBasePath;
	
	private static final Logger logger = Logger.getLogger(FileAccessController.class);
	 
	FileAccessController(){
		
			 logger.debug("  ################### CLASS FILEACCESSCONTROLLER ### DEFAULT CONSTRUCTOR CALLED ### ENTER ### ");
		
		try {
			Properties prop = new Properties();
			String resourceName = "common.properties"; 
			
			prop=CommonUtility.loadPropertyFile(resourceName);
			fileBasePath=prop.getProperty("file.upload.base.upload.path");
		}catch(Exception e){
			  logger.error("  ################### CLASS FILEACCESSCONTROLLER ### DEFAULT CONSTRUCTOR CALLED ### ERROR ### "+e);
		}
			 logger.debug("  ################### CLASS FILEACCESSCONTROLLER ### DEFAULT CONSTRUCTOR CALLED ### EXIT ### ");
	}
	
	
	@RequestMapping(value="/accessFile" , method=RequestMethod.GET)
	public void accessFile(@RequestParam(value="filePath")String filePath,ModelMap model,HttpSession session,HttpServletResponse response,HttpServletRequest request) throws Exception {
		
				logger.debug("  ################### CLASS FILEACCESSCONTROLLER ### URL /user/accessFile ### ENTER ### ");
		try{
		
			 
				// Get requested image by path info.
				String requestedFile = filePath;
		        if (requestedFile == null) {
		            // Do your thing if the image is not supplied to the request URI.
		            // Throw an exception, or send 404, or show default/warning image, or just ignore it.
		            response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
		            return ;
		        }
		
		        // Decode the file name (might contain spaces and on) and prepare file object.
		        File file = new File(fileBasePath, URLDecoder.decode(requestedFile, "UTF-8"));
		
		        // Check if file actually exists in filesystem.
		        if (!file.exists()) {
		            // Do your thing if the file appears to be non-existing.
		            // Throw an exception, or send 404, or show default/warning image, or just ignore it.
		            response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
		            return ;
		        }
		
		        // Get content type by filename.
		        String contentType = servletContext.getMimeType(file.getName());
		
		        // Check if file is actually an image (avoid download of other files by hackers!).
		        // For all content types, see: http://www.w3schools.com/media/media_mimeref.asp
		        /*if (contentType == null || !contentType.startsWith("image")) {
		            // Do your thing if the file appears not being a real image.
		            // Throw an exception, or send 404, or show default/warning image, or just ignore it.
		            response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
		            return ;
		        }*/
		        
		        // Init servlet response.
		        response.reset();
		        response.setContentType(contentType);
		        response.setHeader("Content-Length", String.valueOf(file.length()));
		
		        // Write image content to response.
		        Files.copy(file.toPath(), response.getOutputStream());
		        //((OutputStream) response).flush();
				
		}catch(Exception e){
				logger.error("  ################### CLASS FILEACCESSCONTROLLER ### URL /user/accessFile ### ERROR ### "+e);
		}
				logger.debug("  ################### CLASS FILEACCESSCONTROLLER ### URL /user/accessFile ### EXIT ### ");
		}
}
