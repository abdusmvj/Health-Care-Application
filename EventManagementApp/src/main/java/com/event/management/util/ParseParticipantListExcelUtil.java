package com.event.management.util;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.event.management.model.UserProfileModel;

public class ParseParticipantListExcelUtil {
	
	 final String UPLOADED_FOLDER = "D:/ExcelFileUpload/";
	 
	 private static final Logger logger = Logger.getLogger(ParseParticipantListExcelUtil.class);
	 
	 public List <UserProfileModel> getParticipantList(MultipartFile multipartFiles,BigInteger event_name_id){
		 List <UserProfileModel> listData=new ArrayList<UserProfileModel>();
		 try {
				
				
				
				// Get the file and save it somewhere
	            byte[] bytes = multipartFiles.getBytes();
	            Path path = Paths.get(UPLOADED_FOLDER + multipartFiles.getOriginalFilename());
	            Files.write(path, bytes);
	            
			    
			     
			       int maxDataCount=0;
			       String id=null;
		    	    FileInputStream file = new FileInputStream(new File(path.toString()));
		            //Create Workbook instance holding reference to .xlsx file
		            XSSFWorkbook workbook = new XSSFWorkbook(file);
		            //Get first/desired sheet from the workbook
		            XSSFSheet sheet = workbook.getSheetAt(0);
		            
		           
		           
		            for (Iterator<Row> rit = sheet.rowIterator(); rit.hasNext();) {
		            	 UserProfileModel userProfileModel=new UserProfileModel();
		              Row row = rit.next();
		              
		            
		             
		              if(row.equals("") || row.equals(null) )
		              {
		            	  System.out.println("row is black ");
		            	  break;
		              }
		              //Skip the first row beacause it will be header
		                 if (row.getRowNum() == 0) {
		                     maxDataCount = row.getLastCellNum();
		                   
		                     continue;
		                   }
		                 
		                 if(row.getRowNum() == 1)
		                 {
		                	 maxDataCount = row.getLastCellNum();
		                	 continue;
		                 }
		                 
		                 
		                
		                 
		                
		                Iterator<Cell> cit = row.cellIterator();
		                Cell cell;
		                
		                for(int i=0; i<row.getLastCellNum(); i++) {
						    cell = row.getCell(i, Row.CREATE_NULL_AS_BLANK);
						       System.out.print(cell.toString()+"\t"+"\t");
						}
		                
		                
	                    if ( cit.hasNext()) {
		                    cell = cit.next();
		                    cell.setCellType(Cell.CELL_TYPE_STRING);
		                    id = cell.getStringCellValue();
		                    userProfileModel.setEvent_id(event_name_id.longValue());
		                    
		                }
		               
		                if ( cit.hasNext()) {
		                    cell = cit.next();
		                    cell.setCellType(Cell.CELL_TYPE_STRING);
		                    userProfileModel.setName(cell.getStringCellValue());
		                    
		                }
		                
		                if ( cit.hasNext()==true) {
		                    cell = cit.next();
		                    cell.setCellType(Cell.CELL_TYPE_STRING);
		                   
		                    	userProfileModel.setCompany(cell.getStringCellValue());
	                        
		                    
		                }
		                
		                if ( cit.hasNext()) {
		                    cell = cit.next();
		                    cell.setCellType(Cell.CELL_TYPE_STRING);
		                    userProfileModel.setDesignation(cell.getStringCellValue());
	                   }
		                
		                if ( cit.hasNext()) {
		                    cell = cit.next();
		                    cell.setCellType(Cell.CELL_TYPE_STRING);
		                    userProfileModel.setPhone_number(Long.parseLong(cell.getStringCellValue()));
	                    }
		                
		                if ( cit.hasNext()) {
		                    cell = cit.next();
		                    cell.setCellType(Cell.CELL_TYPE_STRING);
		                    userProfileModel.setEmail_id(cell.getStringCellValue());
	                  }
		                
		                if ( cit.hasNext()==true) {
		                    cell = cit.next();
		                    cell.setCellType(Cell.CELL_TYPE_STRING);
		                   
		                    	userProfileModel.setAddress(cell.getStringCellValue());
	                        
		                    
		                }
		                
		                if ( cit.hasNext()) {
		                    cell = cit.next();
		                    cell.setCellType(Cell.CELL_TYPE_STRING);
		                    userProfileModel.setCategory(cell.getStringCellValue());
	                        
		                    
		                }
		                file.close();
		                System.out.println("data get from excel "+userProfileModel.getName()+"\t"+userProfileModel.getAddress());
		                listData.add(userProfileModel);
		                System.out.println("List size is "+ listData.size());
		            }
		 }
		                catch (Exception e) {
		   			     logger.error("  ################### CLASS WEBCONTROLLER ### URL /uploadExcelFile ### ERRROR ### "+ e);
		   					
		   					}
		 return listData;
	 }

}
