package com.event.management.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.MultiFormatOneDReader;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class QRCodeUtil {
	
	static Properties prop = new Properties();
	static String resourceName = "common.properties"; 
	static String basePath_qr_code=null;
	
	 public static final String generateQRCode(String userId,	String eventId ) {
         String QRCPath = "";
		 try{ 
			 
			 prop=CommonUtility.loadPropertyFile(resourceName);
				basePath_qr_code=prop.getProperty("file.upload.base.upload.path.qrcode");
				
			 String qrCodeData = userId+"||"+ eventId;
				String filePath = basePath_qr_code+File.separator+userId+"_QRC.png";
				String charset = "UTF-8"; // or "ISO-8859-1"
				Map hintMap = new HashMap();
				hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
				BitMatrix matrix = new MultiFormatWriter().encode(new String(qrCodeData.getBytes(charset), charset),
						BarcodeFormat.QR_CODE, 200, 200, hintMap);
				MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath
						.lastIndexOf('.') + 1), new File(filePath));
				QRCPath ="QRCode"+File.separator+ userId+"_QRC.png";
				System.out.println("QR Code image created successfully!");

		 }catch(Exception e){
			 e.printStackTrace();
			 return null;
		 }
		    
	    return QRCPath;
	}
}
