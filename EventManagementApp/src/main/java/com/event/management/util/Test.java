/*package com.event.management.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class Test {
	public void generateQRCode() {
		  try{
	    	String qrCodeData = "Hello Worldwwwwwwwwwwww!";
			String filePath = "D:\\image\\QRC2.png";
			String charset = "UTF-8"; // or "ISO-8859-1"
			Map hintMap = new HashMap();
			hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
			BitMatrix matrix = new MultiFormatWriter().encode(new String(qrCodeData.getBytes(charset), charset),
					BarcodeFormat.QR_CODE, 200, 200, hintMap);
			MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath
					.lastIndexOf('.') + 1), new File(filePath));
			
		
			
			System.out.println("QR Code image created successfully!");

	    }catch(Exception e){
	    }
	    
	   
	    
	}
	
	public static void main(String[] args) {
		try{
			Test t=new Test();
			t.generateQRCode();
		}catch(Exception e){
			
		}
	}
}*/
