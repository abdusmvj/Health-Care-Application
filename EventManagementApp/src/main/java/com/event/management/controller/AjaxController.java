package com.event.management.controller;

import java.io.File;
import java.math.BigInteger;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.event.management.constant.CommonConstant;
import com.event.management.constant.ErrorConstant;
import com.event.management.constant.MessageConstant;
import com.event.management.model.ActivityModel;
import com.event.management.model.EventModel;
import com.event.management.model.MenuFieldsNameModel;
import com.event.management.model.MenuFieldsValueModel;
import com.event.management.model.MenuModel;
import com.event.management.model.ScheduleModel;
import com.event.management.model.UserProfileModel;
import com.event.management.service.UserService;
import com.event.management.util.CommonUtility;
import com.event.management.util.EncryptDecrypt;
import com.event.management.util.SendMailUtil;
import com.event.management.vo.MenuFieldValueVO;

@Controller
public class AjaxController {

	
	private static final Logger logger = Logger.getLogger(AjaxController.class);

	@Autowired
	private UserService userService;
	
	Properties prop = new Properties();
	String resourceName = "common.properties"; 
	String playStorePath=null;
	
	
	
	@ResponseBody
	@RequestMapping(value = "/fetchallevents")
	public List<EventModel> allEvents() {

		logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /fetchallevents ### ENTER ### ");

		
		try {
		return	userService.getAllEvents();

		} catch (Exception e) {
			logger.error("  ################### CLASS AJAXCONTROLLER ### URL /fetchallevents ### ERRROR ### "+ e);
			
		}

		logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /fetchallevents ### EXIT ### ");
		return null;
	}
	
	@ResponseBody
 	@RequestMapping(value = "/fetcheventdetailbyid")
 	public List<EventModel> fetchEventDetailById(@RequestParam("id") String eventId) {
 		
 		logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /fetchallevents ### ENTER ### ");
 
 		 
 		try {
 		return	userService.fetchEventDetailById(eventId);
 
 		} catch (Exception e) {
 			logger.error("  ################### CLASS AJAXCONTROLLER ### URL /fetchallevents ### ERRROR ### "+ e);
 			
 		}
 
 	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /fetchallevents ### EXIT ### ");
 		return null;
 	}
	
	@ResponseBody
	@RequestMapping(value = "/seteventactivebyid")
	public int setEventActiveById(@RequestParam("id") String eventId) {
		
		logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /fetchallevents eventId ### ENTER ### ");

		 
		try {
		return	userService.setEventActiveById(eventId);

		} catch (Exception e) {
			logger.error("  ################### CLASS AJAXCONTROLLER ### URL /fetchallevents ### ERRROR ### "+ e);
			
		}

		logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /fetchallevents ### EXIT ### ");
		return 0;
	}
	


	@ResponseBody
	@RequestMapping(value = "/updateeventdetailbyid")
	public int updateEditedEvent(@RequestParam("event_name") String event_name,
											@RequestParam("about_us") String about_us,
											@RequestParam("event_venue") String event_venue,
											
											@RequestParam("event_id_hidden") String event_id_hidden,
											@RequestParam("event_sdate") String event_sdate,
											@RequestParam("event_stime") String event_stime,  
											@RequestParam("event_edate") String event_edate,
											@RequestParam("event_etime") String event_etime
		
			) {

		logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /updateeditedevent ### ENTER ### ");

		try {
			
			about_us="";
			System.out.println(event_name+" "+about_us+" "+event_venue+" "+event_id_hidden+" "+stringToSQLdate(event_sdate)+" "+stringToSQLtime(event_stime)+" "+event_edate+" "+event_etime);
		return	userService.updateEditedEvent(event_name,about_us,event_venue,event_id_hidden,stringToSQLdate(event_sdate),event_stime,stringToSQLdate(event_edate),event_etime);
			

		} catch (Exception e) {
			logger.error("  ################### CLASS AJAXCONTROLLER ### URL /login ### ERRROR ### "
					+ e);
			return 0;
		} 
	}
	
	@ResponseBody
	@RequestMapping(value = "/createeventdetail")
	public int createEventDetail(@RequestParam("event_name") String event_name,
			@RequestParam("about_us") String about_us,
			@RequestParam("event_venue") String event_venue,
			
			@RequestParam("event_id_hidden") String event_id_hidden,
			@RequestParam("event_sdate") String event_sdate,
			@RequestParam("event_stime") String event_stime,  
			@RequestParam("event_edate") String event_edate,
			@RequestParam("event_etime") String event_etime) {
			
		logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /fetchallevents ### ENTER ### ");

		 
		try {
			System.out.println(event_name+" "+about_us+" "+event_venue+" "+event_id_hidden+" "+stringToSQLdate(event_sdate)+" "+stringToSQLtime(event_stime)+" "+event_edate+" "+event_etime);
			return	userService.createEventDetail(event_name,about_us,event_venue,event_id_hidden,stringToSQLdate(event_sdate),event_stime,stringToSQLdate(event_edate),event_etime);
			

		} catch (Exception e) {
			logger.error("  ################### CLASS AJAXCONTROLLER ### URL /fetchallevents ### ERRROR ### "+ e);
			
		}

		logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /fetchallevents ### EXIT ### ");
		return 0;
	}
	
	@RequestMapping(value = "/uploadFile",method=RequestMethod.POST)
	public @ResponseBody String uploadFile(@RequestParam("file_upload") MultipartFile file_upload ,@RequestParam("event_Id") Long eventId ,
																					HttpServletResponse  response, HttpServletRequest request) {
		logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /uploadFile ### ENTER ### ");
		String result=MessageConstant.ERROR_FAILURE_UPLOAD_FILE;
		try {
				if(!file_upload.isEmpty()){
					result=userService.uploadFile(file_upload,eventId,request);
				}
			
		} catch (Exception e) {
			logger.error("  ################### CLASS AJAXCONTROLLER ### URL /uploadFile ### ERRROR ### " + e);
		}
		logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /uploadFile ### EXIT ### ");
		return result;
	}
	
	@RequestMapping(value = "/uploadBannerImages",method=RequestMethod.POST)
	public @ResponseBody String uploadBannerFile(@RequestParam("file_upload_multiple") List<MultipartFile> file_upload_multiple ,@RequestParam("eventId") Long eventId ,
																					HttpServletResponse  response, HttpServletRequest request) {
		logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /uploadFile ### ENTER ### ");
		String result=MessageConstant.ERROR_FAILURE_UPLOAD_FILE;
		try {
				if(file_upload_multiple.size()>0){
					result=userService.uploadMultipleFiles(file_upload_multiple,eventId,request);
					
				}
			
		} catch (Exception e) {
			logger.error("  ################### CLASS AJAXCONTROLLER ### URL /uploadFile ### ERRROR ### " + e);
		}
		logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /uploadFile ### EXIT ### ");
		return result;
	}
	   
	
	@ResponseBody
	@RequestMapping(value = "/deleteeventdetailbyid")
	public int deleteEventDetailById(@RequestParam("id") String eventId) {
		
		logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /deleteeventdetailbyid eventId ### ENTER ### ");

		 
		try {
		return	userService.deleteEventDetailById(eventId);

		} catch (Exception e) {
			logger.error("  ################### CLASS AJAXCONTROLLER ### URL /deleteeventdetailbyid ### ERRROR ### "+ e);
			
		}

		logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /deleteeventdetailbyid ### EXIT ### ");
		return 0;
	}
	@ResponseBody
	@RequestMapping(value = "/createuserdetail")
	public int createUserDetail(/*@RequestParam("user_name") String user_name,*/
			@RequestParam("name_of_user") String name_of_user,
		/*	@RequestParam("user_pass") String user_pass,*/
			@RequestParam("user_id_hidden") String user_id_hidden,
			@RequestParam("user_email") String user_email,
			@RequestParam("user_phone") String user_phone,
			@RequestParam("user_address") String user_address,  
			@RequestParam("user_designation") String user_designation,
			@RequestParam("user_company") String user_company,
			@RequestParam("user_event_id") String user_event_id,
			@RequestParam("user_category") String user_category
			) {
		
		
	 	
		logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /fetchallevents ### ENTER ### ");

		 
		try {
			
			if(/*(user_name != null && !user_name.isEmpty())
					|| */(name_of_user != null && !name_of_user.isEmpty())
					/*|| (user_pass != null && !user_pass.isEmpty())	*/
						|| (user_id_hidden != null && !user_id_hidden.isEmpty())
						|| (user_email != null && !user_email.isEmpty())
						|| (user_phone != null && !user_phone.isEmpty())
						|| (user_address != null && !user_address.isEmpty())
						|| (user_designation != null && !user_designation.isEmpty())
						|| (user_company != null && !user_company.isEmpty())
						|| (user_category != null && !user_category.isEmpty())
					){
			 	}
			else{
				
				return 0;
			}
			
			String user_name="";
				
			String user_pass=CommonUtility.createUserPassword();
		 	 	return	userService.createUserDetail(user_name,
						name_of_user,
						user_pass,
						user_id_hidden,
						user_email,
						user_phone,
						user_address,
		user_company,
		user_designation,
		user_event_id,user_category);
			

		} catch (Exception e) {
			logger.error("  ################### CLASS AJAXCONTROLLER ### URL /fetchallevents ### ERRROR ### "+ e);
			
		}

		logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /fetchallevents ### EXIT ### ");
		return 0;
	}
	
	@RequestMapping(value = "/uploadExcelFile" , method = RequestMethod.POST)
	public @ResponseBody   HashMap<String,Object> uploadExcelFile(Model model,HttpServletRequest request,RedirectAttributes redirectAttributes, 
	                               HttpServletResponse response, @RequestParam("file") MultipartFile multipartFiles,
	                               @RequestParam("eventid") BigInteger event_name_id) {
		
		
		logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /uploadExcelFile ### ENTER ### ");
		//Save the uploaded file to this folder
	  //  String msg=MessageConstant.PARTICIAPNT_FILE_ADD_FAILED;
	    
	    HashMap<String,Object> map=new HashMap<String,Object>();
	    
		try{
			if (multipartFiles.isEmpty()) {
				  map.put(CommonConstant.UPLOAD_EXCEL_FAILURE_MSG_KEY, "Please select a file to upload");
				//msg= "Please select a file to upload";
	           
	        }else{
	                
	                
	        	map= userService.saveParticipantsList(multipartFiles,event_name_id);
	                
	            
	              
	        }
	       
		  } catch (Exception e) {
			     logger.error("  ################### CLASS AJAXCONTROLLER ### URL /uploadExcelFile ### ERRROR ### "+ e);
					
					}
       return map;
		
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/fetchalluserdetails")
	public List<UserProfileModel> fetchAllUserDetails(@RequestParam("id") String eventId) {
		
		logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /fetchallevents ### ENTER ### ");

		 
		try {
		return	userService.fetchAllUserDetails(eventId);

		} catch (Exception e) {
			logger.error("  ################### CLASS AJAXCONTROLLER ### URL /fetchallevents ### ERRROR ### "+ e);
			
		}

		logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /fetchallevents ### EXIT ### ");
		return null;
	}
	@ResponseBody
 	@RequestMapping(value = "/fetchuserdetailbyid")
 	public List<UserProfileModel> fetchUserDetailById(@RequestParam("id") String userId) {
 		
 		logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /fetchuserdetailbyid ### ENTER ### ");
 
 		 
 		try {
 		return	userService.fetchUserDetailById(userId);
 
 		} catch (Exception e) {
 			logger.error("  ################### CLASS AJAXCONTROLLER ### URL /fetchuserdetailbyid ### ERRROR ### "+ e);
 			
 		}
 
 	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /fetchuserdetailbyid ### EXIT ### ");
 		return null;
 	}
	
	 
	@ResponseBody
	@RequestMapping(value = "/updateuserdetailbyid")
	public int updateEditedUser(			@RequestParam("eventId") long eventId,
											@RequestParam("name_of_user") String name_of_user,
											@RequestParam("user_id_hidden") String user_id_hidden,
											@RequestParam("user_email") String user_email,
											@RequestParam("user_email_hidden") String user_email_hidden,
											@RequestParam("user_phone") String user_phone,
											@RequestParam("user_address") String user_address,  
											@RequestParam("user_designation") String user_designation,
											@RequestParam("user_company") String user_company,
											@RequestParam("user_category") String user_category
 			) {

		logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /updateeditedevent ### ENTER ### ");

		 

		try {
		
 			if( (name_of_user != null && !name_of_user.isEmpty())
					|| (user_id_hidden != null && !user_id_hidden.isEmpty())
						|| (user_email != null && !user_email.isEmpty())
						|| (user_phone != null && !user_phone.isEmpty())
						|| (user_email_hidden != null && !user_email_hidden.isEmpty())
						|| (user_address != null && !user_address.isEmpty())
						|| (user_designation != null && !user_designation.isEmpty())
						|| (user_company != null && !user_company.isEmpty())
						|| (user_category != null && !user_category.isEmpty())
					){
 			}
else{
				
				return 0;
			}
			
			
		return	userService.updateEditedUser(eventId,
				name_of_user,
				user_id_hidden,
				user_email,
				user_email_hidden,
				user_phone,
				user_address,
user_company,
user_designation,user_category);
 
		} catch (Exception e) {
			logger.error("  ################### CLASS AJAXCONTROLLER ### URL /login ### ERRROR ### "
					+ e);
			return 0;
		}
 	}
	
	
	/****JOYDIP ADD/EDIT PARTICIPANT END*******************************/
	
	@ResponseBody
 	@RequestMapping(value = "/fetchactivitiesbyeventId")
 	public List<ActivityModel> fetchActivitiesByEventId(@RequestParam("id") String eventId) {
		
 		
 		logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /fetchActivitiesByEventId ### ENTER ### ");
 
 		 
 		try {
 		return	userService.fetchActivitiesByEventId(eventId);
 
 		} catch (Exception e) {
 			logger.error("  ################### CLASS AJAXCONTROLLER ### URL /fetchActivitiesByEventId ### ERRROR ### "+ e);
 			
 		}
 
 	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /fetchActivitiesByEventId ### EXIT ### ");
 		return null;
 	}
	@ResponseBody
 	@RequestMapping(value = "/fetchactivitydetailbyid")
 	public List<ActivityModel> fetchActivityDetailById(@RequestParam("id") String activityId) {
 		
 		logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /fetchactivitydetailbyid ### ENTER ### ");
 
 		 
 		try {
 		return	userService.fetchActivityDetailById(activityId);
 
 		} catch (Exception e) {
 			logger.error("  ################### CLASS AJAXCONTROLLER ### URL /fetchactivitydetailbyid ### ERRROR ### "+ e);
 			
 		}
 
 	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /fetchactivitydetailbyid ### EXIT ### ");
 		return null;
 	}
	@ResponseBody
	@RequestMapping(value = "/createactivity")
	public int createActivity(@RequestParam("activity_id_hidden") String activity_id_hidden,
			@RequestParam("event_Id_hidden") String event_Id_hidden,
			@RequestParam("activity_name") String activity_name,			
			@RequestParam("venue") String venue,
			@RequestParam("is_prtcpt_auth_req") String is_prtcpt_auth_req,
			@RequestParam("is_one_time_pass") String is_one_time_pass,  
			@RequestParam("is_reset_on_exit") String is_reset_on_exit)
			 {
			
		logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /createActivity ### ENTER ### ");

		 
		try {
			System.out.println(activity_id_hidden+" "+event_Id_hidden+" "+activity_name+" "+venue+" "+is_prtcpt_auth_req+" "+is_one_time_pass+" "+is_reset_on_exit);
			return	userService.createActivity(activity_id_hidden,event_Id_hidden,activity_name,venue,is_prtcpt_auth_req,is_one_time_pass,is_reset_on_exit);
			

		} catch (Exception e) {
			logger.error("  ################### CLASS AJAXCONTROLLER ### URL /createActivity ### ERRROR ### "+ e);
			
		}

		logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /createActivity ### EXIT ### ");
		return 0;
	}
	@ResponseBody
	@RequestMapping(value = "/updateactivitydetailbyid")
	public int updateActivityDetailById(@RequestParam("activity_id_hidden") String activity_id_hidden,
			@RequestParam("event_Id_hidden") String event_Id_hidden,
			@RequestParam("activity_name") String activity_name,			
			@RequestParam("venue") String venue,
			@RequestParam("is_prtcpt_auth_req") String is_prtcpt_auth_req,
			@RequestParam("is_one_time_pass") String is_one_time_pass,  
			@RequestParam("is_reset_on_exit") String is_reset_on_exit) {

		logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /updateActivityDetailById ### ENTER ### ");

		try {
						
			System.out.println(activity_id_hidden+" "+event_Id_hidden+" "+activity_name+" "+venue+" "+is_prtcpt_auth_req+" "+is_one_time_pass+" "+is_reset_on_exit);
			return	userService.updateActivityDetailById(activity_id_hidden,event_Id_hidden,activity_name,venue,is_prtcpt_auth_req,is_one_time_pass,is_reset_on_exit);
			

		} catch (Exception e) {
			logger.error("  ################### CLASS AJAXCONTROLLER ### URL /updateActivityDetailById ### ERRROR ### "
					+ e);
			return 0;
		} 
	}
	@ResponseBody
	@RequestMapping(value = "/deleteactivitydetailbyid")
	public int deleteActivityDetailById(@RequestParam("id") String activityId) {
		
		logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /deleteActivityDetailById eventId ### ENTER ### ");

		 
		try {
		return	userService.deleteActivityDetailById(activityId);

		} catch (Exception e) {
			logger.error("  ################### CLASS AJAXCONTROLLER ### URL /deleteActivityDetailById ### ERRROR ### "+ e);
			
		}

		logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /deleteActivityDetailById ### EXIT ### ");
		return 0;
	}
	
	/**** SRIPARNA  ADD/EDIT ACTIVITY  END ***********************/
	
/*@RequestMapping(value = "/sendInvitationMail",method=RequestMethod.POST)
	public @ResponseBody String sendInvitationMail(@RequestParam("userId") String userId ,@RequestParam("eventId") String eventId ,
																					HttpServletResponse  response, HttpServletRequest req) {
		logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /sendInvitationMail ### ENTER ### ");
		String result=MessageConstant.MAIL_EVENT_NOT_SENT_SUCCESSFULLY;
		try {
			EncryptDecrypt encryptDecrypt=new EncryptDecrypt();
			
			 List<EventModel> eventList=userService.fetchEventDetailById(eventId);
			 EventModel eventModel= eventList.get(0);
			  
			  
			  if(eventModel!=null){
					  List<UserProfileModel> userProfileList=userService.fetchUserDetailById(userId);
					  UserProfileModel userProfileModel= userProfileList.get(0);
					  if(userProfileModel!=null){
					  String decryptedPassword= encryptDecrypt.decrypt(userProfileModel.getPassword());
					  SendMailUtil send=new SendMailUtil();
					  String ip=CommonUtility.getURL( req);
					  String msgSubject="Test Mail @ Event Management App";
					  
					  String even_msg_body="";
					  if(eventModel.getMsg_body()!=null){
					  even_msg_body=eventModel.getMsg_body();
					  }
					  
					  String msg_sender_name="";
					  if(eventModel.getMsg_sender_name()!=null){
						  msg_sender_name=eventModel.getMsg_sender_name();
					  }
					  
					  String msgBody = "<HTML><body style='padding-bottom: 12px; padding-top: 12px; margin:0; background:wheat'><div style='margin-bottom:10px;width:100%;padding:0; margin:0; background:wheat; text-align:left'><p style='text-align:left;'>"
					  + "Dear "+userProfileModel.getName()+", <br>" +userProfileModel.getAddress()+" <br><br><br>"
					  + "&nbsp;&nbsp;&nbsp;&nbsp;    "+msg_sender_name+"</br>"
					  		+even_msg_body+". <br><br><b>Participant login credential :</b> <br> Username : "+userProfileModel.getUsername()+" <br> Password : "+decryptedPassword+"<br><br><br><b>Warm Regards, <br>  "+msg_sender_name+" </b></div>"
								+" '</div></body></HTML>";
					  
					 send.mail(userProfileModel.getEmail_id(),msgBody,msgSubject,req);
					
					 result=MessageConstant.MAIL_EVENT_SENT_SUCCESSFULLY;
					}
			  }
				
			
		} catch (Exception e) {
			logger.error("  ################### CLASS AJAXCONTROLLER ### URL /sendInvitationMail ### ERRROR ### " + e);
		}
		logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /sendInvitationMail ### EXIT ### ");
		return result;
	}
*/

@RequestMapping(value = "/sendInvitationMailInGroup",method=RequestMethod.POST)
public @ResponseBody HashMap<String,Object> sendInvitationMailInGroup(@RequestParam("userIdList") List<String> userIdList ,@RequestParam("eventId") long eventId ,
																				HttpServletResponse  response, HttpServletRequest req) {
	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /sendInvitationMailInGroup ### ENTER ### ");
	//String result=MessageConstant.MAIL_EVENT_NOT_SENT_SUCCESSFULLY;
	HashMap<String,Object> map=new HashMap<String,Object>();
	List<String> mailIdListSuccess=new ArrayList<String>();
	
	List<String> mailIdListFailure=new ArrayList<String>();
	
	
	try {
		EncryptDecrypt encryptDecrypt=new EncryptDecrypt();
		
		 EventModel eventModel=userService.getEventDetailById(eventId);
	//	 EventModel eventModel= eventList.get(0);
		  
		  
		  if(eventModel!=null){
			  
			  if(userIdList!=null){
				  
				  prop=CommonUtility.loadPropertyFile(resourceName);
					playStorePath=prop.getProperty("playstore.app.url");
					System.out.println(playStorePath);
					
					
				  for(int i=0;i<userIdList.size();i++){
					  long userId=Long.parseLong(userIdList.get(i));
					  UserProfileModel userProfileModel=userService.getICardInformation(userId,eventId);
					//  UserProfileModel userProfileModel= userProfileList.get(0);
					  try{
										 
						 
										  if(userProfileModel!=null){
										  String decryptedPassword= encryptDecrypt.decrypt(userProfileModel.getPassword());
										  SendMailUtil send=new SendMailUtil();
										  String ip=CommonUtility.getURL( req);
										  String msgSubject="Test Mail @ Event Management App";
										  
										  String even_msg_body="";
										  if(eventModel.getMsg_body()!=null){
										  even_msg_body=eventModel.getMsg_body();
										  }
										  
										  String msg_sender_name="";
										  if(eventModel.getMsg_sender_name()!=null){
											  msg_sender_name=eventModel.getMsg_sender_name();
										  }
										  
										  String msgBody = "<HTML><body style='padding-bottom: 12px; padding-top: 12px; margin:0; background:wheat'><div style='margin-bottom:10px;width:100%;padding:0; margin:0; background:wheat; text-align:left'><p style='text-align:left;'>"
										  + "Dear "+userProfileModel.getName()+", <br>" +userProfileModel.getAddress()+" <br><br><br>"
										  		+even_msg_body+". <br><br>"+
										  
										  		"Please download the Event Management App from : <br>"+
										  		"<b>Playstore url :</b> "+playStorePath+"<br> "+
										  		"<b>Username :</b> "+userProfileModel.getUsername()+"<br> "+
										  		"<b>Password :</b> "+decryptedPassword+
										  		
										  		"<br><br><br><b>Warm Regards, <br>  "+msg_sender_name+" </b></div>"
													+" '</div></body></HTML>";
										  
										// send.mail(userProfileModel.getEmail_id(),msgBody,msgSubject,req);
										
									
										 mailIdListSuccess.add(userProfileModel.getEmail_id());
										}
				  }
					  catch (Exception e) {
						  mailIdListFailure.add(userProfileModel.getEmail_id());
							logger.error("  ################### CLASS AJAXCONTROLLER ### URL /sendInvitationMailInGroup ### MailSending ERRROR ### " + e);
						}
				  }
				  map.put(CommonConstant.MAIL_ID_LIST_SENT_SUCCESSFULLY_KEY, mailIdListSuccess);
				  map.put(CommonConstant.MAIL_ID_LIST_SENT_FAILURE_KEY, mailIdListFailure);
				
			  }
				  
				  
				  
		  }
			
		  map.put(CommonConstant.MAIL_SENT_SUCCESSFULL_MSG_KEY, CommonConstant.MAIL_SENT_SUCCESSFULL_MSG);
	} catch (Exception e) {
		  map.put(CommonConstant.MAIL_ID_LIST_SENT_FAILURE_KEY, CommonConstant.MAIL_SENT_FAILURE_MSG);
		logger.error("  ################### CLASS AJAXCONTROLLER ### URL /sendInvitationMailInGroup ### ERRROR ### " + e);
	}
	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /sendInvitationMailInGroup ### EXIT ### ");
	return map;
}
@ResponseBody
@RequestMapping(value = "/getParticipantListByEventId")
public List<UserProfileModel> getParticipantListByEventId(@RequestParam("eventId") Long eventId) {

	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /getParticipantListByEventId ### ENTER ### ");

	
	try {
	return	userService.getParticipantListByEventId(eventId);

	} catch (Exception e) {
		logger.error("  ################### CLASS AJAXCONTROLLER ### URL /getParticipantListByEventId ### ERRROR ### "+ e);
		
	}

	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /getParticipantListByEventId ### EXIT ### ");
	return null;
}



@ResponseBody
@RequestMapping(value = "/getActivityListByEventId")
public List<ActivityModel> getActivityListByEventId(@RequestParam("eventId") Long eventId) {

	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /getActivityListByEventId ### ENTER ### ");

	
	try {
	return	userService.getActivityListByEventId(eventId);

	} catch (Exception e) {
		logger.error("  ################### CLASS AJAXCONTROLLER ### URL /getActivityListByEventId ### ERRROR ### "+ e);
		
	}

	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /getActivityListByEventId ### EXIT ### ");
	return null;
}



@ResponseBody
@RequestMapping(value = "/registerparticipantwithactivity", method = RequestMethod.POST)
public   String registerParticipantWithActivity(@RequestParam("participant_Id") String participant_Id,@RequestParam("eventId") String eventId ,@RequestParam("activity_Id") String activity_Id,
																   HttpServletResponse  response, HttpServletRequest request,HttpSession session) {
	
	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /registerParticipantWithActivity ### ENTER ### ");
	String result="";
	try {
		List<String> items = Arrays.asList(participant_Id.split("\\s*,\\s*"));
		List<Long> itemsLong=new ArrayList<Long>();
		for(String s : items) itemsLong.add(Long.valueOf(s));
		
		result=userService.registerParticipantWithActivity(Long.parseLong(eventId),Long.parseLong(activity_Id),itemsLong);

	} catch (Exception e) {
		logger.error("  ################### CLASS AJAXCONTROLLER ### URL /registerParticipantWithActivity ### ERRROR ### " + e);
		result=ErrorConstant.MSG_ERROR_PARTICIPANT_REGISTER;
	}
	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /registerParticipantWithActivity ### EXIT ### ");
	return result;

}
/**** TAJINDER  ADD/EDIT USER ACTIVITY MAPPING END ***********************/

/*Joydip da 02-01-2018*/
@ResponseBody
@RequestMapping(value = "/fetchmenudetailbyeventid")
public List<MenuModel> fetchMenuDetailsByEventId(@RequestParam("id") String menuId) {
	
	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /fetchmenudetailbyeventid ### ENTER ### ");
	try {
	return	userService.fetchMenuDetailsByEventId(menuId);

	} catch (Exception e) {
		logger.error("  ################### CLASS AJAXCONTROLLER ### URL /fetchmenudetailbyeventid ### ERRROR ### "+ e);
		
	}

	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /fetchmenudetailbyeventid ### EXIT ### ");
	return null;
}

@ResponseBody
@RequestMapping(value = "/fetchmenudetailsbyid")
public List<MenuFieldsNameModel> fetchMenuDetailsById(@RequestParam("id") String menuId) {
	
	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /fetchallevents ### ENTER ### ");

	 
	try {
	return	userService.fetchMenuDetailsById(menuId);

	} catch (Exception e) {
		logger.error("  ################### CLASS AJAXCONTROLLER ### URL /fetchallevents ### ERRROR ### "+ e);
		
	}

	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /fetchallevents ### EXIT ### ");
	return null;
}

@ResponseBody
@RequestMapping(value = "/fetchmenunamedetailbyid")
public List<MenuModel> fetchMenuNameDetailById(@RequestParam("id") String menuId) {
	
	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /fetchmenunamedetailbyid ### ENTER ### ");

	 
	try {
	return	userService.fetchMenuNameDetailById(menuId);

	} catch (Exception e) {
		logger.error("  ################### CLASS AJAXCONTROLLER ### URL /fetchmenunamedetailbyid ### ERRROR ### "+ e);
		
	}

	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /fetchmenunamedetailbyid ### EXIT ### ");
	return null;
}

@ResponseBody
@RequestMapping(value = "/createmenubyeventid")
public int createMenuByEventId( 
		@RequestParam("menu_field_name_id_hidden") String menu_field_name_id_hidden,
	  	@RequestParam("menu_field_id") String menu_field_id,
		@RequestParam("is_restriction_acccess") String is_restriction_acccess
		) {
 	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /fetchallevents ### ENTER ### ");
	try {
		
		if( 	(menu_field_name_id_hidden != null && !menu_field_name_id_hidden.isEmpty())
			
					|| (menu_field_id != null && !menu_field_id.isEmpty())
					)
		 		 {
		 	}
		else{
	 		return 0;
		}
	 	  	return	userService.createMenuByEventId(menu_field_name_id_hidden,
	 	 			menu_field_id,is_restriction_acccess);//Tajinder Changes
 	} catch (Exception e) {
		logger.error("  ################### CLASS AJAXCONTROLLER ### URL /fetchallevents ### ERRROR ### "+ e);
 	}
	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /fetchallevents ### EXIT ### ");
	return 0;
}


@ResponseBody
@RequestMapping(value = "/fetchallmenusbyid")
public List<MenuModel> fetchAllMenusById(@RequestParam("id") String menuId) {
	
	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /fetchallevents ### ENTER ### ");

	 
	try {
	return	userService.fetchAllMenusById(menuId);

	} catch (Exception e) {
		logger.error("  ################### CLASS AJAXCONTROLLER ### URL /fetchallevents ### ERRROR ### "+ e);
		
	}

	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /fetchallevents ### EXIT ### ");
	return null;
}
@ResponseBody
@RequestMapping(value = "/fetchmenufieldnamedetailbyid")
public List<MenuFieldsNameModel> fetchMenuFieldNameDetailById(@RequestParam("id") String menuId) {
	
	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /fetchmenufieldnamedetailbyid ### ENTER ### ");

	 
	try {
	return	userService.fetchMenuFieldNameDetailById(menuId);

	} catch (Exception e) {
		logger.error("  ################### CLASS AJAXCONTROLLER ### URL /fetchmenufieldnamedetailbyid ### ERRROR ### "+ e);
		
	}

	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /fetchmenufieldnamedetailbyid ### EXIT ### ");
	return null;
}
@ResponseBody
@RequestMapping(value = "/updatemenufieldnamebymenuid")
public int updateMenuFieldNameByMenuId(@RequestParam("menu_field_name_id_hidden") String menu_field_name_id_hidden,
	 	@RequestParam("menu_field_name") String menu_field_name,
	 	
	 	@RequestParam("menu_field_id") String menu_field_id
		
			) {

	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /updateeditedevent ### ENTER ### ");

	 

	try {
		
			if(
				(menu_field_name_id_hidden != null && !menu_field_name_id_hidden.isEmpty())
				
				|| (menu_field_name != null && !menu_field_name.isEmpty())
					
				){
			}
else{
			
			return 0;
		}
  	return	userService.updateMenuFieldNameByMenuId(
			menu_field_name_id_hidden,
	 	 			menu_field_name,menu_field_id);

	} catch (Exception e) {
		logger.error("  ################### CLASS AJAXCONTROLLER ### URL /login ### ERRROR ### "
				+ e);
		return 0;
	}
	}
@ResponseBody
@RequestMapping(value = "/createmenufieldnamebymenuid")
public int createMenuFieldNameByMenuId( 
		@RequestParam("menu_field_name_id_hidden") String menu_field_name_id_hidden,
	 	@RequestParam("menu_field_name") String menu_field_name,
	 	
	 	@RequestParam("menu_field_id") String menu_field_id
		) {
 	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /fetchallevents ### ENTER ### ");
	try {
		
		if(
				(menu_field_name_id_hidden != null && !menu_field_name_id_hidden.isEmpty())
			
					|| (menu_field_name != null && !menu_field_name.isEmpty())
					)
					
				 {
		 	}
		else{
			
			return 0;
		}
 	 	 	return	userService.createMenuFieldNameByMenuId(menu_field_name_id_hidden,
	 	 			menu_field_name,menu_field_id);
 	} catch (Exception e) {
		logger.error("  ################### CLASS AJAXCONTROLLER ### URL /fetchallevents ### ERRROR ### "+ e);
 	}
	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /fetchallevents ### EXIT ### ");
	return 0;
}


@ResponseBody
@RequestMapping(value = "/updatemenunamebymenuid")
public int updateMenuNameByMenuId( 
		@RequestParam("menu_field_name_id_hidden") String menu_field_name_id_hidden,
	 	@RequestParam("menu_field_name") String menu_field_name,
	 	@RequestParam("is_restriction_acccess") String is_restriction_acccess,
	 	@RequestParam("menu_field_id") String menu_field_id
		) {
	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /updateeditedevent ### ENTER ### ");
try {
		
			if(
				(menu_field_name_id_hidden != null && !menu_field_name_id_hidden.isEmpty())
				
				|| (menu_field_name != null && !menu_field_name.isEmpty())
					
				){
			}
else{
			
			return 0;
		}
		
		
 	return	userService.updateMenuNameByMenuId(menu_field_name_id_hidden,menu_field_name,menu_field_id,is_restriction_acccess);//Tajinder changes

	} catch (Exception e) {
		logger.error("  ################### CLASS AJAXCONTROLLER ### URL /login ### ERRROR ### "
				+ e);
		return 0;
	}
}


@ResponseBody
@RequestMapping(value = "/deletemenubyid")
public int deleteMenuNameById( 
		@RequestParam("id") String id 
		) {
	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /deletemenunamebyid ### ENTER ### ");
try {
		
			if(
				 id != null && !id.isEmpty() 
					
				){
			}
else{
			
			return 0;
		}
		
		
 	return	userService.deleteMenuNameById(
 			id);

	} catch (Exception e) {
		logger.error("  ################### CLASS AJAXCONTROLLER ### URL /login ### ERRROR ### "
				+ e);
		return 0;
	}
}

@ResponseBody
@RequestMapping(value = "/deletemenufieldnamebyid")
public int deleteMenuFieldNameById( 
		@RequestParam("id") String id 
		) {
	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /deleteMenuFieldNameById ### ENTER ### ");
try {
		
			if(
				 id != null && !id.isEmpty() 
					
				){
			}
else{
			
			return 0;
		}
		
		
 	return	userService.deleteMenuFieldNameById(
 			id);

	} catch (Exception e) {
		logger.error("  ################### CLASS AJAXCONTROLLER ### URL /login ### ERRROR ### "
				+ e);
		return 0;
	}
}


@ResponseBody
@RequestMapping(value = "/updateScheduleModelDataById")
public int updateScheduleModelData(@RequestParam("event_Id_hidden") Long event_Id_hidden,
		@RequestParam("schedule_name") String schedule_name,
		@RequestParam("participant_id_hidden") String participant_id_hidden,
		@RequestParam("schedule_date") String schedule_date,
		@RequestParam("schedule_starttime") String schedule_starttime,  
		@RequestParam("description") String description,
		@RequestParam("schedule_endtime") String schedule_endtime
	
		) {

	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /updateScheduleModelDataById ### ENTER ### ");

	try {
		ScheduleModel scheduleModel=new ScheduleModel();
		scheduleModel.setEvent_id(event_Id_hidden);
		scheduleModel.setSchedule_name(schedule_name);
		scheduleModel.setDescription(description);
		scheduleModel.setSchedule_date(stringToSQLdate(schedule_date));
		scheduleModel.setSchedule_starttime(schedule_starttime);
		scheduleModel.setSchedule_endtime(schedule_endtime);
		
		
		return	userService.updateScheduleModelData(scheduleModel,participant_id_hidden);
		

	} catch (Exception e) {
		logger.error("  ################### CLASS AJAXCONTROLLER ### URL /updateScheduleModelDataById ### ERRROR ### "
				+ e);
		return 0;
	} 
}

//===============abdus added this code @28-12-2017==========end=======

//========abdus added this code @29-12-2017======start=============
@ResponseBody
@RequestMapping(value = "/fetchScheduleModelDetailById")
public List<ScheduleModel> fetchScheduleModelDetailById(@RequestParam("id") String scheduleId) {
	
	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /fetchScheduleModelDetailById ### ENTER ### ");

	 
	try {
	return	userService.fetchScheduleModelDetailById(scheduleId);

	} catch (Exception e) {
		logger.error("  ################### CLASS AJAXCONTROLLER ### URL /fetchScheduleModelDetailById ### ERRROR ### "+ e);
		
	}

        logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /fetchScheduleModelDetailById ### EXIT ### ");
	return null;
}

//========abdus added this code @29-12-2017======end========

//========abdus added this code @29-12-2017======start===
@ResponseBody
@RequestMapping(value = "/deleteScheduleModelDetailById")
public int deleteScheduleModelDetailById(@RequestParam("id") String scheduleId) {
	
	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /deleteScheduleModelDetailById scheduleId ### ENTER ### ");

	 
	try {
	return	userService.deleteScheduleModelRowById(scheduleId);

	} catch (Exception e) {
		logger.error("  ################### CLASS AJAXCONTROLLER ### URL /deleteScheduleModelDetailById ### ERRROR ### "+ e);
		
	}

	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /deleteScheduleModelDetailById ### EXIT ### ");
	return 0;
}

//========abdus added this code @29-12-2017======end===

//==============abdus added this code @28-12-2017=========start======
@ResponseBody
@RequestMapping(value = "/fetchallScheduleList")
public List<ScheduleModel> getScheduleList(@RequestParam("id") String eventId) {

	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /fetchallScheduleList ### ENTER ### ");

	
	try {
	return	userService.getScheduleList(eventId);

	} catch (Exception e) {
		logger.error("  ################### CLASS AJAXCONTROLLER ### URL /fetchallScheduleList ### ERRROR ### "+ e);
		
	}

	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /fetchallScheduleList ### EXIT ### ");
	return null;
}


//==============abdus added this code @28-12-2017=========end======

//===============abdus added this code @28-12-2017==========start=======

@ResponseBody
@RequestMapping(value = "/saveParticipantData")
public int saveScheduleModelData( @RequestParam("event_Id_hidden") Long event_Id_hidden,
		@RequestParam("schedule_name") String schedule_name,
		
		
		@RequestParam("participant_id_hidden") String participant_id_hidden,
		@RequestParam("schedule_date") String schedule_date,
		@RequestParam("schedule_starttime") String schedule_starttime,  
		@RequestParam("description") String description,
		@RequestParam("schedule_endtime") String schedule_endtime)  {
		
	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /saveParticipantData ### ENTER ### ");

	System.out.println("The sedule name is"+schedule_name);
	try {
		ScheduleModel scheduleModel=new ScheduleModel();
		scheduleModel.setEvent_id(event_Id_hidden);
		scheduleModel.setSchedule_name(schedule_name);
		scheduleModel.setDescription(description);
		scheduleModel.setSchedule_date(stringToSQLdate(schedule_date));
		scheduleModel.setSchedule_starttime(schedule_starttime);
		scheduleModel.setSchedule_endtime(schedule_endtime);
		
		
		System.out.println("The sedule name is"+event_Id_hidden);
		return	userService.saveScheduleModelData(scheduleModel,participant_id_hidden);
	} catch (Exception e) {
		logger.error("  ################### CLASS AJAXCONTROLLER ### URL /saveParticipantData ### ERRROR ### "+ e);
		
	}

	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /saveParticipantData ### EXIT ### ");
	return 0;
}
//================abdus added this code @28-12-2017==========end=======


//==============abdus added this code @28-12-2017==========start=======


private java.sql.Date stringToSQLdate(String startDate){
	 try{
		 
		// startDate.replace("-","/");
		 SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
	java.util.Date date = sdf1.parse(startDate);
	java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
	return sqlStartDate;
		 
	 }
	
	
	catch(Exception e){
		
		e.printStackTrace();
		return null;
	}
	
}

private java.sql.Time stringToSQLtime(String timeString){
	 try{
			 
		 
		 String[] tm=timeString.split(":");
		 String h=tm[0];
		 String m=tm[1];
		 String s="00";
		 @SuppressWarnings("deprecation")
		Time t=new java.sql.Time(Integer.parseInt(h),Integer.parseInt(m),Integer.parseInt(s));
	return t;
		 
	 }
	
	
	catch(Exception e){
		
		e.printStackTrace();
		return null;
	}
	 
}
/*Priyanka 26.12.2017 @START*/
@ResponseBody
@RequestMapping(value = "/updateEventAboutDetailById",method=RequestMethod.POST,headers = "Accept=application/json")
public int updateEventAboutDetailById(@RequestBody EventModel event) {
	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /updateEventAboutDetailById ### ENTER ### ");
	try {
		
	    return userService.updateEventAboutDetailById(event);
	}catch (Exception e) {
		logger.error("  ################### CLASS AJAXCONTROLLER ### URL /updateEventAboutDetailById ### ERRROR ### "+ e);
		return 0;
	} 
}
/*Priyanka 26.12.2017 @End*/
/**** MOUSUMI START add edit menu fields value 03-01-2018 ************************/
@ResponseBody
@RequestMapping(value = "/fetchMenuValueListByMenuId")
public List<Object> fetchMenuValueListByMenuId(@RequestParam("menuId") long menuId) {
	
	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /fetchMenuValueListByMenuId ### ENTER ### ");

	 
	try {
	return	userService.fetchMenuValueListByMenuId( menuId);

	} catch (Exception e) {
		logger.error("  ################### CLASS AJAXCONTROLLER ### URL /fetchMenuValueListByMenuId ### ERRROR ### "+ e);
		
	}

	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /fetchMenuValueListByMenuId ### EXIT ### ");
	return null;
}

@RequestMapping(value = "/saveUpdateMenuFieldValue",method=RequestMethod.POST)
public @ResponseBody String saveUpdateMenuFieldValue(@ModelAttribute("menuFieldValueVO") MenuFieldValueVO menuFieldValueVO ,
		@RequestParam("eventId") Long eventId ,@RequestParam("menuId") Long menuId ,
																				HttpServletResponse  response, HttpServletRequest request) {
	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /saveUpdateMenuFieldValue ### ENTER ### ");
	String result=MessageConstant.ERROR_FAILURE_UPLOAD_FILE;
	try {
			if(menuFieldValueVO!=null){
				result=userService.saveUpdateMenuFieldValue(menuFieldValueVO.getMenuFieldsValueModelList(),eventId,menuId);
			}
		
	} catch (Exception e) {
		logger.error("  ################### CLASS AJAXCONTROLLER ### URL /saveUpdateMenuFieldValue ### ERRROR ### " + e);
	}
	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /saveUpdateMenuFieldValue ### EXIT ### ");
	return result;
}

@ResponseBody
@RequestMapping(value = "/fetchMenuValueDetailsBySetId")
public List<MenuFieldsValueModel> fetchMenuValueDetailsBySetId(@RequestParam("setId") long setId) {
	
	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /fetchMenuValueDetailsBySetId ### ENTER ### ");

	 
	try {
	return	userService.fetchMenuValueDetailsBySetId( setId);

	} catch (Exception e) {
		logger.error("  ################### CLASS AJAXCONTROLLER ### URL /fetchMenuValueDetailsBySetId ### ERRROR ### "+ e);
		
	}

	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /fetchMenuValueDetailsBySetId ### EXIT ### ");
	return null;
}

@ResponseBody
@RequestMapping(value = "/deleteEventMenuValueBySetId")
public int deleteEventMenuValueBySetId(@RequestParam("setId") long setId) {
	
	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /deleteEventMenuValueBySetId eventId ### ENTER ### ");

	 
	try {
	return	userService.deleteEventMenuValueBySetId(setId);

	} catch (Exception e) {
		logger.error("  ################### CLASS AJAXCONTROLLER ### URL /deleteEventMenuValueBySetId ### ERRROR ### "+ e);
		
	}

	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /deleteEventMenuValueBySetId ### EXIT ### ");
	return 0;
}

@ResponseBody
@RequestMapping(value = "/checkIsUserValidForPrint")
public int checkIsUserValidForPrint(@RequestParam("userId") long userId) {
	
	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /checkIsUserValidForPrint eventId ### ENTER ### ");

	 
	try {
	return	userService.checkIsUserValidForPrint(userId);

	} catch (Exception e) {
		logger.error("  ################### CLASS AJAXCONTROLLER ### URL /checkIsUserValidForPrint ### ERRROR ### "+ e);
		
	}

	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /checkIsUserValidForPrint ### EXIT ### ");
	return 0;
}
/**** MOUSUMI END add edit menu fields value 03-01-2018 ************************/
/*TAJINDER KAUR 04-01-2018 START*/
@ResponseBody
@RequestMapping(value = "/deleteUserProfileDetailById")
public int deleteUserProfileDetailById(@RequestParam("id") String userId) {
	
	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /deleteUserProfileDetailById eventId ### ENTER ### ");

	 
	try {
	return	userService.deleteUserById(userId);

	} catch (Exception e) {
		logger.error("  ################### CLASS AJAXCONTROLLER ### URL /deleteUserProfileDetailById ### ERRROR ### "+ e);
		
	}

	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /deleteUserProfileDetailById ### EXIT ### ");
	return 0;
}
/*TAJINDER KAUR 04-01-2018 END*/

/*TAJINDER 05-01-2018 START*/
@ResponseBody
@RequestMapping(value = "/fetchParticipantDetailsByEventAndActivityId")
public List<UserProfileModel> fetchParticipantDetailsByEventAndActivityId(@RequestParam("eventId") String eventId,
																		  @RequestParam("activityId") String activityId) {
	
	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /fetchParticipantDetailsByEventAndActivityId ### ENTER ### ");

	 
	try {
	return	userService.fetchParticipantDetailsByEventAndActivityId(eventId,activityId);

	} catch (Exception e) {
		logger.error("  ################### CLASS AJAXCONTROLLER ### URL /fetchParticipantDetailsByEventAndActivityId ### ERRROR ### "+ e);
		
	}

	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /fetchParticipantDetailsByEventAndActivityId ### EXIT ### ");
	return null;
}



@ResponseBody
@RequestMapping(value = "/deleteuserMappingById")
public int deleteuserMappingById(@RequestParam("userMappingId") String userMappingId) {
	
	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /deleteuserMappingById eventId ### ENTER ### ");

	 
	try {
	return	userService.deleteuserMappingById(userMappingId);

	} catch (Exception e) {
		logger.error("  ################### CLASS AJAXCONTROLLER ### URL /deleteuserMappingById ### ERRROR ### "+ e);
		
	}

	logger.debug("  ################### CLASS AJAXCONTROLLER ### URL /deleteuserMappingById ### EXIT ### ");
	return 0;
}
/*TAJINDER 05-01-2018 END*/
}
