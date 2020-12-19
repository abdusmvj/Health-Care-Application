package com.event.management.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.event.management.model.ActivityModel;
import com.event.management.model.ActivityUserMappingModel;
import com.event.management.model.AdminDeviceSetup;
import com.event.management.model.EventModel;
import com.event.management.model.MenuModel;
import com.event.management.model.UserProfileModel;
import com.event.management.security.GenerateJWT;
import com.event.management.service.UserService;
import com.event.management.vo.BannerImageForm;
import com.event.management.vo.MenuForm;
import com.event.management.vo.ServiceResponse;


@Controller
public class WebServiceController {
	
	/*Priyanka 19-12-2017 @Start*/
	
	private static final Logger logger = Logger.getLogger(WebController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/getMenuList", method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody  ServiceResponse  getMenuList(@RequestParam("eventId") long eventId){
		
		logger.debug("  ################### CLASS WEBCONTROLLER ### URL /getMenuList ### ENTER ### ");
		ServiceResponse res = new ServiceResponse();
		
		try{
			List<MenuForm> menuList = userService.getMenuList(eventId);
			res.setResObject(menuList);
			res.setStatus("SUCCESS");
		}
		catch(Exception e){
			res.setErrorMsg(e.getMessage());
			res.setStatus("FAILURE");//Priyanka 05.01.2018
			logger.error("  ################### CLASS WEBCONTROLLER ### URL /getMenuList ### ERRROR ### "+e);
		}
		logger.debug("  ################### CLASS WEBCONTROLLER ### URL /getMenuList ### EXIT ### ");
		return res;
	}
	
	@RequestMapping(value = "/getAboutDetails", method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody  ServiceResponse  getAboutDetails(@RequestParam("eventId") long eventId){
		
		logger.debug("  ################### CLASS WEBSERVICECONTROLLER ### URL /getAboutDetails ### ENTER ### ");
		ServiceResponse res = new ServiceResponse();
		try{
			BannerImageForm bannerImgForm = userService.getAboutDetails(eventId);
			if(bannerImgForm!=null){
				res.setResObject(bannerImgForm);
			}else{
				res.setErrorMsg("No details found");
			}
			res.setStatus("SUCCESS");
		}
		catch(Exception e){
			res.setErrorMsg(e.getMessage());
			res.setStatus("FAILURE");//Priyanka 05.01.2018
			logger.error("  ################### CLASS WEBSERVICECONTROLLER ### URL /getAboutDetails ### ERRROR ### "+e);
		}
		logger.debug("  ################### CLASS WEBSERVICECONTROLLER ### URL /getAboutDetails ### EXIT ### ");
		return res;
	}
	
	@RequestMapping(value = "/getActiveEventDetails", method=RequestMethod.GET,produces = "application/json")
	public @ResponseBody  ServiceResponse  getActiveEventDetails(){
		
		logger.debug("  ################### CLASS WEBCONTROLLER ### URL /getActiveEventDetails ### ENTER ### ");
		ServiceResponse res = new ServiceResponse();
		try{
			EventModel activeEventDetails = userService.getActiveEventDetails();
			if(activeEventDetails==null){
				res.setErrorMsg("Details not available for active event");
			}else{
				res.setResObject(activeEventDetails);
			}
			res.setStatus("SUCCESS");
		}
		catch(Exception e){
			res.setErrorMsg(e.getMessage());
			res.setStatus("FAILURE");
			logger.error("  ################### CLASS WEBCONTROLLER ### URL /getActiveEventDetails ### ERRROR ### "+e);
		}
		logger.debug("  ################### CLASS WEBCONTROLLER ### URL /getActiveEventDetails ### EXIT ### ");
		return res;
	}
	/*Priyanka 20-12-2017 @End*/
	
    /*Sriparna 20-12-2017*/
	
	@RequestMapping(value = "/getScheduleDetails", method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody  ServiceResponse  getScheduleDetails(@RequestParam("eventId") long eventId){
		
		logger.debug("  ################### CLASS WEBCONTROLLER ### URL /getScheduleDetails ### ENTER ### ");
		ServiceResponse res = new ServiceResponse();
		try{
			List scheduleList = userService.getScheduleDetails(eventId);
			res.setResObject(scheduleList);
			res.setStatus("SUCCESS");
		}
		catch(Exception e){
			res.setErrorMsg(e.getMessage());
			res.setStatus("FAILURE");
			logger.error("  ################### CLASS WEBCONTROLLER ### URL /getScheduleDetails ### ERRROR ### "+e);
		}
		logger.debug("  ################### CLASS WEBCONTROLLER ### URL /getScheduleDetails ### EXIT ### ");
		return res;
	}
	
	
	  /*Tajinder 20-12-2017*/
	@RequestMapping(value = "/mobilelogin", method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody ServiceResponse login(@RequestParam("username") String username,
											   @RequestParam("password") String password,
											   @RequestParam("isAdmin") Integer isAdmin){
		
		
		logger.debug("  ################### CLASS WEBSERVICECONTROLLER ### URL /login ### ENTER ### ");
		ServiceResponse res = new ServiceResponse();
		
		try {
				if(username==""){
					res.setErrorMsg("Invalid credentials!!");
				}else if(password==""){
					res.setErrorMsg("Invalid credentials!!");
				}else if(isAdmin==null){
					res.setErrorMsg("Invalid credentials!!");
				}else{
					UserProfileModel user=userService.validateUser(username,password,isAdmin);
					if(user!=null){
						
						/*Priyanka 04.01.2018 @Start*/
						
						EventModel event =  userService.getEventDetailById(user.getEvent_id());
						GenerateJWT genJWT = new GenerateJWT();
						String JWTToken = genJWT.createJWT(user.getId(),user.getUsername(),event.getEvent_end_date(),event.getEvent_end_time());
						res.setAuthenticationToken(JWTToken);
						
						/*Priyanka 04.01.2018 @End*/
						
					    res.setResObject(user);
					    res.setStatus("SUCCESS");
				    }else{
				    	 res.setStatus("FAILURE");
				    	 res.setErrorMsg("Invalid credentials!!");
				    }
				}
		} catch (Exception e) {
			res.setErrorMsg(e.getMessage());
			logger.error("  ################### CLASS WEBSERVICECONTROLLER ### URL /login ### ERRROR ### "+e);
		}
		logger.debug("  ################### CLASS WEBSERVICECONTROLLER ### URL /login ### EXIT ### ");
		return res;
		
	}
	
	/*Priyanka 21-12-2017 @Start*/
	@RequestMapping(value = "/getICardInformation", method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody  ServiceResponse  getICardInformation(@RequestParam("userId") long userId,@RequestParam("eventId") long eventId,
			@RequestParam("authenticationToken") String authenticationToken){
		
		logger.debug("  ################### CLASS WEBCONTROLLER ### URL /getICardInformation ### ENTER ### ");
		ServiceResponse res = new ServiceResponse();
		
		try{
			/*Priyanka 05.01.2018 @Start*/
			
			GenerateJWT genJWT = new GenerateJWT();
			int validAuth = 0;
			if((authenticationToken != null &&  authenticationToken!="") && (userId>0)){
				validAuth = genJWT.parseJWT(authenticationToken,userId);	
			}
			if(validAuth==1){
				UserProfileModel userDetails = userService.getICardInformation(userId,eventId);
				if(userDetails==null){
					res.setErrorMsg("User details not found");
				}else{
					res.setResObject(userDetails);
				}
			}
			res.setAuthenticationFlag(validAuth);
			res.setStatus("SUCCESS");
			/*Priyanka 05.01.2018 @End*/
		}
		catch(Exception e){
			res.setErrorMsg(e.getMessage());
			res.setStatus("FAILURE");//Priyanka 05.01.2018
			logger.error("  ################### CLASS WEBCONTROLLER ### URL /getICardInformation ### ERRROR ### "+e);
		}
		logger.debug("  ################### CLASS WEBCONTROLLER ### URL /getICardInformation ### EXIT ### ");
		return res;
	}
	
	@RequestMapping(value = "/getMenuDetails", method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody  ServiceResponse  getMenuDetails(@RequestParam("menuId") long menuId,@RequestParam("is_restricted_access") int is_restricted_access,
			@RequestParam("userId") long userId,@RequestParam("authenticationToken") String authenticationToken){
		
		logger.debug("  ################### CLASS WEBCONTROLLER ### URL /getMenuDetails ### ENTER ### ");
		ServiceResponse res = new ServiceResponse();
		/*Priyanka 05.01.2018 @Start*/
		List<Object> menuDetails = null;
		try{
			if(is_restricted_access==1){
				GenerateJWT genJWT = new GenerateJWT();
				int validAuth = 0;
				if((authenticationToken != null &&  authenticationToken!="") && (userId>0)){
					validAuth = genJWT.parseJWT(authenticationToken,userId);	
				}
				if(validAuth==1){
					menuDetails = userService.getMenuDetails(menuId);
				}
				res.setAuthenticationFlag(validAuth);
			}else{
				menuDetails = userService.getMenuDetails(menuId);
			}
			
			if(menuDetails==null){
				res.setErrorMsg("Menu details not found");
			}else{
				res.setResObject(menuDetails);
			}
			res.setStatus("SUCCESS");
			/*Priyanka 05.01.2018 @End*/
		}catch(Exception e){
			res.setErrorMsg(e.getMessage());
			res.setStatus("FAILURE");//Priyanka 05.01.2018
			logger.error("  ################### CLASS WEBCONTROLLER ### URL /getMenuDetails ### ERRROR ### "+e);
		}
		logger.debug("  ################### CLASS WEBCONTROLLER ### URL /getMenuDetails ### EXIT ### ");
		return res;
	}
	
	/*Priyanka 21-12-2017 @End*/
	
	/*Tajinder 21-12-2017 @Start*/
	@RequestMapping(value = "/getActivityDetailsList", method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody  ServiceResponse  getActivityDetailsList(@RequestParam("eventId") long eventId,@RequestParam("userId") long userId,
			@RequestParam("authenticationToken") String authenticationToken){
		
		logger.debug("  ################### CLASS WEBSERVICECONTROLLER ### URL /getActivityDetailsList ### ENTER ### ");
		ServiceResponse res = new ServiceResponse();
		try{
			/*Priyanka 05.01.2018 @Start*/
			GenerateJWT genJWT = new GenerateJWT();
			int validAuth = 0;
			if((authenticationToken != null &&  authenticationToken!="") && (userId>0)){
				validAuth = genJWT.parseJWT(authenticationToken,userId);	
			}
			if(validAuth==1){
				List<ActivityModel> activityList = userService.getActivityDetail(eventId);
				if(activityList==null){
					res.setErrorMsg("No data found");
				}else{
					res.setResObject(activityList);
				}
			}
			res.setAuthenticationFlag(validAuth);
			res.setStatus("SUCCESS");
			/*Priyanka 05.01.2018 @End*/
		}
		catch(Exception e){
			res.setErrorMsg(e.getMessage());
			res.setStatus("FAILURE");//Priyanka 05.01.2018
			logger.error("  ################### CLASS WEBSERVICECONTROLLER ### URL /getActivityDetailsList ### ERRROR ### "+e);
		}
		logger.debug("  ################### CLASS WEBSERVICECONTROLLER ### URL /getActivityDetailsList ### EXIT ### ");
		return res;
	}
	/*Tajinder 21-12-2017 @End*/
	
	/*Priyanka 22-12-2017 @Start*/
	
	@RequestMapping(value = "/adminDeviceSetup", method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody  ServiceResponse  adminDeviceSetup(@RequestParam("userId") long userId,@RequestParam("eventId") long eventId,
															@RequestParam("activityId") long activityId,@RequestParam("deviceId") String deviceId,
															@RequestParam("isEntry") int isEntry,@RequestParam("authenticationToken") String authenticationToken){
		
		logger.debug("  ################### CLASS WEBCONTROLLER ### URL /adminDeviceSetup ### ENTER ### ");
		ServiceResponse res = new ServiceResponse();
		AdminDeviceSetup deviceDetails = new AdminDeviceSetup();
		
		try{
			/*Priyanka 05.01.2018 @Start*/
			GenerateJWT genJWT = new GenerateJWT();
			int validAuth = 0;
			if((authenticationToken != null &&  authenticationToken!="") && (userId>0)){
				validAuth = genJWT.parseJWT(authenticationToken,userId);	
			}
			if(validAuth==1){
				deviceDetails.setUser_id(userId);
				deviceDetails.setEvent_id(eventId);
				deviceDetails.setActivity_id(activityId);
				deviceDetails.setDevice_id(deviceId);
				deviceDetails.setIs_entry(isEntry);
				
				String message = userService.adminDeviceSetup(deviceDetails);
				res.setErrorMsg(message);
			}
			res.setAuthenticationFlag(validAuth);
			res.setStatus("SUCCESS");
			/*Priyanka 05.01.2018 @End*/
		}
		catch(Exception e){
			res.setErrorMsg(e.getMessage());
			res.setStatus("FAILURE");//Priyanka 05.01.2018
			logger.error("  ################### CLASS WEBCONTROLLER ### URL /adminDeviceSetup ### ERRROR ### "+e);
		}
		logger.debug("  ################### CLASS WEBCONTROLLER ### URL /adminDeviceSetup ### EXIT ### ");
		return res;
	}
	
	@RequestMapping(value = "/getParticipantPresence", method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody  ServiceResponse  getParticipantPresence(@RequestParam("userId") long userId,@RequestParam("eventId") long eventId,
				@RequestParam("activityId") long activityId,@RequestParam("entryOrExit") String entryOrExit,
				@RequestParam("authenticationToken") String authenticationToken,@RequestParam("adminId") long adminId){
		
		logger.debug("  ################### CLASS WEBCONTROLLER ### URL /getParticipantPresence ### ENTER ### ");
		ServiceResponse res = new ServiceResponse();
		ActivityUserMappingModel activityDetails = new ActivityUserMappingModel();
		ArrayList<String> messageList=new ArrayList<String>(); 
		try{
			/*Priyanka 05.01.2018 @Start*/
			GenerateJWT genJWT = new GenerateJWT();
			int validAuth = 0;
			if((authenticationToken != null &&  authenticationToken!="") && (adminId>0)){
				validAuth = genJWT.parseJWT(authenticationToken,adminId);	
			}
			if(validAuth==1){
				activityDetails.setUser_id(userId);
				activityDetails.setActivity_id(activityId);
				
				messageList = userService.getParticipantPresence(activityDetails,eventId,entryOrExit);
				if(messageList!= null){
					res.setSuccessMsg(messageList.get(0)); 
					res.setErrorMsg(messageList.get(1));
				}
			}
			res.setAuthenticationFlag(validAuth);
			res.setStatus("SUCCESS");
			/*Priyanka 05.01.2018 @End*/
		}catch(Exception e){
			res.setErrorMsg(e.getMessage());
			res.setStatus("FAILURE");
			logger.error("  ################### CLASS WEBCONTROLLER ### URL /getParticipantPresence ### ERRROR ### "+e);
		}
		logger.debug("  ################### CLASS WEBCONTROLLER ### URL /getParticipantPresence ### EXIT ### ");
		return res;
	}
	/*Priyanka 22-12-2017 @End*/
	
	
	
	
	
}
