package com.event.management.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.event.management.constant.CommonConstant;
import com.event.management.constant.MessageConstant;
import com.event.management.dao.UserDao;
import com.event.management.model.ActivityModel;
import com.event.management.model.ActivityUserMappingModel;
import com.event.management.model.AdminDeviceSetup;
import com.event.management.model.EventBannerImageModel;
import com.event.management.model.EventModel;
import com.event.management.model.MenuFieldsNameModel;
import com.event.management.model.MenuFieldsValueModel;
import com.event.management.model.MenuModel;
import com.event.management.model.ScheduleModel;
import com.event.management.model.UserProfileModel;
import com.event.management.service.UserService;
import com.event.management.util.CommonUtility;
import com.event.management.util.ParseParticipantListExcelUtil;
import com.event.management.util.UploadImage;
import com.event.management.vo.BannerImageForm;
import com.event.management.vo.MenuForm;


@Service("userService")
/*@Transactional(propagation=Propagation.REQUIRED)*/
public class UserServiceImpl implements UserService{
	
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Autowired
	@Qualifier("userProDao")
	UserDao userDao;
	 
	
	@Transactional
	public void getUserDetails(long userId) throws Exception{
		try{
			userDao.getUserDetails(userId);
		}catch(Exception e){
			logger.error(" ### EXCEPTION IN UserServiceImpl ###"+e); 
		}
	}

	/*Priyanka 19-12-2017 @Start*/
	
	
	@Transactional
	public List<MenuForm> getMenuList(long eventId) throws Exception {
		List<MenuForm> menuList = null ;
		try{
			 menuList = userDao.getMenuList(eventId);
		}catch(Exception e){
			logger.error(" ### EXCEPTION IN UserServiceImpl ###"+e); 
		}
		return menuList;
	}
	
	/*Priyanka 19-12-2017 @End*/
	
	/*Sriparna 20-12-2017*/
	@Transactional
	public List getScheduleDetails(long eventId) throws Exception {
		List scheduleList = null ;
		try{
			scheduleList = userDao.getScheduleDetails(eventId);
		}catch(Exception e){
			logger.error(" ### EXCEPTION IN UserServiceImpl ###"+e); 
		}
		return scheduleList;
	}

	
	/*Priyanka 20-12-2017 @Start*/
	@Transactional
	public EventModel getActiveEventDetails() throws Exception{
		EventModel activeEventDetails = null;
		
		try{
			activeEventDetails = userDao.getActiveEventDetails();
		}catch(Exception e){
			logger.error(" ### EXCEPTION IN UserServiceImpl ###"+e); 
		}
		return activeEventDetails;
	}
	/*Priyanka 20-12-2017 @End*/
	
	@Transactional
	public UserProfileModel validateUser(String username, String password,Integer isAdmin) {
		UserProfileModel user=null;
		long roleId=0;
		try{
			if(isAdmin==CommonConstant.IS_ADMIN_TRUE){
				roleId=CommonConstant.ADMIN_ROLE;
			}else{
				roleId=CommonConstant.PARTICIPANT_ROLE;
		}
			user=userDao.validateUser(username,password,roleId);
		}catch(Exception e){
			logger.error(" ### EXCEPTION IN UserServiceImpl ###"+e); 
		}
		return user;
	}

	/*Priyanka 20-12-2017 @Start*/
	@Transactional
	public UserProfileModel getICardInformation(long userId, long eventId)throws Exception {
		UserProfileModel userDetails=null;
		try{
			userDetails = userDao.getICardInformation(userId,eventId);
		}catch(Exception e){
			logger.error(" ### EXCEPTION IN UserServiceImpl ###"+e);
		}
		return userDetails;
	}
	
	@Transactional
	public List<Object> getMenuDetails(long menuId) throws Exception {
		List<Object> menuDetails = null;
		try{
			menuDetails = userDao.getMenuDetails(menuId);
		}catch(Exception e){
			logger.error(" ### EXCEPTION IN UserServiceImpl ###"+e);
		}
		return menuDetails;
	}
	
	/*Priyanka 20-12-2017 @End*/
	
	/*Tajinder 21-12-2017 @Start*/
	@Transactional
	public BannerImageForm getAboutDetails(long eventId) throws Exception {
		BannerImageForm bannerForm = null;
		try{
			 bannerForm = userDao.getAboutDetails(eventId);
		}catch(Exception e){
			logger.error(" ### EXCEPTION IN UserServiceImpl ###"+e); 
		}
		return bannerForm;
	}
	
	@Transactional
	public List<ActivityModel> getActivityDetail(long eventId) throws Exception {
		List<ActivityModel> activityList = null ;
		try{
			activityList = userDao.getActivityDetail(eventId);
		}catch(Exception e){
			logger.error(" ### EXCEPTION IN UserServiceImpl ###"+e); 
		}
		return activityList;
	}
	/*Tajinder 21-12-2017 @End*/
	
	/*************Tajinder  21.12.2017 Start *********************/
	@Transactional
	public UserProfileModel validateUserInfo(String username, String password) throws Exception {
		UserProfileModel user=null;
		try{
			
			user=userDao.validateUser(username,password);
		}catch(Exception e){
			logger.error(" ### EXCEPTION IN UserServiceImpl ###"+e); 
		}
		return user;
	}
	/*************Tajinder  21.12.2017 End *********************/
	
	/*Joydip Da 21-12-2017*/
	@Transactional
	public List<EventModel> getAllEvents() throws Exception {
		try{
		return	userDao.getAllEvents();
		}catch(Exception e){
			logger.error(" ### EXCEPTION IN UserServiceImpl :: getAllEvents ###"+e); 
		}
		return null;
		
	}
	
	@Transactional
	public List<EventModel> fetchEventDetailById(String eventId) {
		try{
			return	userDao.fetchEventDetailById( eventId);
			}catch(Exception e){
				logger.error(" ### EXCEPTION IN UserServiceImpl :: getAllEvents ###"+e); 
			}
		
		return null;
	}


	@Transactional
	public int setEventActiveById(String eventId) {
	
		try{
			return	userDao.setEventActiveById( eventId);
			}catch(Exception e){
				logger.error(" ### EXCEPTION IN UserServiceImpl :: getAllEvents ###"+e); 
			}
		 	return 0;		
	}



	/*public void updateEditedEvent(String event_name, String about_us,
			List<String> event_venue, List<String> addmoreVal, String menuID,String event_id_hidden) {
		try{
			userDao.updateEditedEvent(  event_name,   about_us,
					  event_venue,   addmoreVal,   menuID,event_id_hidden);
		}catch(Exception e){
			logger.error(" ### EXCEPTION IN UserServiceImpl ###"+e); 
		}
		
	}*/
	@Transactional
	public int updateEditedEvent(String event_name, String about_us,
			String event_venue, String event_id_hidden, Date event_sdate,
			String event_stime, Date event_edate, String event_etime) {
		try{
			return	userDao.updateEditedEvent(   event_name,   about_us,
					  event_venue,   event_id_hidden,
					  event_sdate,   event_stime,
					  event_edate,   event_etime);
		}catch(Exception e){
			logger.error(" ### EXCEPTION IN UserServiceImpl ###"+e); 
		}
		return 0;
	}
	
	
	@Transactional
	public int createEventDetail(String event_name, String about_us,
			String event_venue, String event_id_hidden, Date event_sdate,
			String event_stime, Date event_edate, String event_etime) {
		 
		try{
			return	userDao.createEventDetail(   event_name,   about_us,
					  event_venue,   event_id_hidden,
					  event_sdate,   event_stime,
					  event_edate,   event_etime);
		}catch(Exception e){
			logger.error(" ### EXCEPTION IN UserServiceImpl ###"+e); 
		}
		return 0;
		
		
		
	}

	@Transactional
	public String uploadFile(MultipartFile file_upload, Long eventId,HttpServletRequest request)
			throws Exception {
		
		String result=MessageConstant.ERROR_FAILURE_UPLOAD_FILE;
		Random rand = new Random();
		int  randomNumber = rand.nextInt(10000) + 1;
		
		UploadImage uploadImage = new UploadImage();
		String uploadEventFilepath=uploadImage.uploadPicture(file_upload,eventId,randomNumber,request);
		
		if(uploadEventFilepath!=null){
			EventModel evt=new EventModel();
			evt.setId(eventId);
			evt.setEvent_screen_image_path(uploadEventFilepath);
			userDao.saveEventImage(evt);
			result=MessageConstant.MSG_SUCCESS_UPLOAD_FILE;
		}
		return result;
	}
	
	@Transactional
	public String uploadMultipleFiles(List<MultipartFile> file_upload_multiple,
			Long eventId, HttpServletRequest request) throws Exception {
			String result=MessageConstant.ERROR_FAILURE_UPLOAD_FILE;
			int count=0;
			int index=0;
			if(file_upload_multiple!=null){
			userDao.deleteBannerImageByEventId(eventId);
			for (MultipartFile multipartFile : file_upload_multiple) {
				Random rand = new Random();
				int  randomNumber = rand.nextInt(10000) + 1;
				count++;
						
				index=count-1;
				 UploadImage uploadImage = new UploadImage();
				 String uploadBannerFilepath=uploadImage.uploadPicture(file_upload_multiple.get(index),eventId ,randomNumber,request);
				 if(uploadBannerFilepath!=null){
					 	EventBannerImageModel banImg=new EventBannerImageModel();
					 	banImg.setEvent_id(eventId);
					 	banImg.setBanner_img_path(uploadBannerFilepath);
					 	//banImg.setCreated_on((java.sql.Date) new Date());
						userDao.saveBannerImage(banImg);
						result=MessageConstant.MSG_SUCCESS_UPLOAD_FILE;
					}
			
	}
	}
		return result;
	}

	/*Priyanka 22-12-2017 @Start*/
	@Transactional
	public String adminDeviceSetup(AdminDeviceSetup deviceDetails) throws Exception {
		String message = "";
		try{
			message = userDao.adminDeviceSetup(deviceDetails);
		}catch(Exception e){
			message = e.getMessage();
			logger.error(" ### EXCEPTION IN UserServiceImpl ###"+e); 
		}
		return message;
	}
	
	
	@Transactional
	public ArrayList<String> getParticipantPresence(ActivityUserMappingModel activityDetails, long eventId,String entryOrExit) throws Exception {
		ArrayList<String> messageList=new ArrayList<String>(); 
		try{
			messageList = userDao.getParticipantPresence(activityDetails,eventId,entryOrExit);
		}catch(Exception e){
			logger.error(" ### EXCEPTION IN UserServiceImpl ###"+e); 
		}
		return messageList;
	}
	

	/*Priyanka 22-12-2017 @End*/
	
	@Transactional
public int deleteEventDetailById(String eventId) {
		
		try{
			return	userDao.deleteEventDetailById( eventId);
			}catch(Exception e){
				logger.error(" ### EXCEPTION IN UserServiceImpl :: deleteEventDetailById ###"+e); 
			}
		 	return 0;		
	}

/****** ABDUS UPLOAD PARTICIPANT LIST START  ******/
	@Transactional
	public  HashMap<String,Object> saveParticipantsList(MultipartFile multipartFiles,java.math.BigInteger event_name_id) {
		 //String msg=MessageConstant.PARTICIAPNT_FILE_ADD_FAILED;
		 List<String> errorId=new ArrayList<String> ();
		 
		 HashMap<String,Object> map=new HashMap<String,Object>();
		 List<String> userIdListSuccess=new ArrayList<String>();
		 List<String> userIdListFailure=new ArrayList<String>();
			
		try{
			 List <UserProfileModel> listUserProfileModel=new ArrayList<UserProfileModel>();
			ParseParticipantListExcelUtil parseParticipantListExcelUtil=new ParseParticipantListExcelUtil();
			listUserProfileModel=parseParticipantListExcelUtil.getParticipantList(multipartFiles, event_name_id);
			
			if(listUserProfileModel!=null){
				if(listUserProfileModel.size()==0){
					 map.put(CommonConstant.UPLOAD_EXCEL_FAILURE_MSG_KEY, MessageConstant.PARTICIAPNT_FILE_ADD_FAILED);
				
				}else{
					for(int i=0;i<listUserProfileModel.size();i++){
						
						UserProfileModel userProfileModel=listUserProfileModel.get(i);
						try{
							String user_pass=CommonUtility.createUserPassword();
							int value=userDao.createUserDetail(userProfileModel.getUsername(),
							userProfileModel.getName(), user_pass, 
							null, userProfileModel.getEmail_id(), 
							userProfileModel.getPhone_number().toString(), userProfileModel.getAddress(), userProfileModel.getCompany(), userProfileModel.getDesignation(), 
							event_name_id.toString(),userProfileModel.getCategory());
							
							if(value==1){
								userIdListSuccess.add(userProfileModel.getEmail_id());
								
							}else{
								userIdListFailure.add(userProfileModel.getEmail_id());//user already added to database
							}
							
						}catch(Exception e){
							userIdListFailure.add(userProfileModel.getEmail_id());
							errorId.add(userProfileModel.getEmail_id());
						}
					}
					map.put(CommonConstant.USER_ID_LIST_UPLOAD_EXCEL_SUCCESSFULLY_KEY, userIdListSuccess);
					  map.put(CommonConstant.USER_ID_LIST_UPLOAD_EXCEL_FAILURE_KEY, userIdListFailure);
					//userDao.saveParticipantsList(listUserProfileModel);
					
					  map.put(CommonConstant.UPLOAD_EXCEL_SUCCESSFULL_MSG_KEY, MessageConstant.PARTICIAPNT_FILE_ADD_SUUCCESSFULLY);
				 // msg=MessageConstant.PARTICIAPNT_FILE_ADD_SUUCCESSFULLY;
				}
			}
		}catch(Exception e){
			  map.put(CommonConstant.UPLOAD_EXCEL_FAILURE_MSG_KEY, MessageConstant.PARTICIAPNT_FILE_ADD_FAILED);
			logger.error(" ### EXCEPTION IN UploadExcelFileServiceImpl ###"+e); 
		}
		return map;
	}
	/****** ABDUS UPLOAD PARTICIPANT LIST START  ******/
	
	/****JOYDIP ADD/EDIT PARTICIPANT START*******************************/
	@Transactional
	public List<UserProfileModel> fetchAllUserDetails(String eventId) {
		try{
			return	userDao.fetchAllUserDetails(eventId);
			}catch(Exception e){
				logger.error(" ### EXCEPTION IN UserServiceImpl :: getAllEvents ###"+e); 
			}
			return null;
	}


	@Transactional
	public List<UserProfileModel> fetchUserDetailById(String userId) {
		try{
			return	userDao.fetchUserDetailById( userId);
			}catch(Exception e){
				logger.error(" ### EXCEPTION IN UserServiceImpl :: getAllEvents ###"+e); 
			}
		
		return null;
	}


	@Transactional
	public int updateEditedUser(/*String user_name,*/long eventId, String name_of_user,
			/*String user_pass,*/ String user_id_hidden, String user_email,String user_email_hidden,
			String user_phone, String user_address, String user_company, String user_designation,String user_category) {
	 
		
		try{
			return	userDao.updateEditedUser(   eventId,   name_of_user,
					  /*user_pass,*/   user_id_hidden,   user_email,user_email_hidden,
					  user_phone,   user_address,   user_company,user_designation,user_category);
			}catch(Exception e){e.printStackTrace();
				logger.error(" ### EXCEPTION IN UserServiceImpl :: updateEditedUser ###"+e); 
				
			}
		
		return 0;
		
		
	}


	@Transactional
	public int createUserDetail(String user_name, String name_of_user,
			String user_pass, String user_id_hidden, String user_email,
			String user_phone, String user_address, String user_company,
			String user_designation, String user_event_id,String user_category) {

		try{
			return	userDao.createUserDetail(   user_name,   name_of_user,
					  user_pass,   user_id_hidden,   user_email,
					  user_phone,   user_address,   user_company,user_designation,user_event_id, user_category);
			}catch(Exception e){e.printStackTrace();
				logger.error(" ### EXCEPTION IN UserServiceImpl :: createUserDetail ###"+e); 
			}
		
		return 0;
	}

	/****JOYDIP ADD/EDIT PARTICIPANT END*******************************/
	
	/**** TAJINDER  ADD/EDIT USER ACTIVITY MAPPING START ***********************/
	@Transactional
	public List<UserProfileModel> getParticipantListByEventId(Long eventId) {
		List<UserProfileModel> participantList=null;
		try {
			participantList=userDao.getParticipantListByEventId(eventId);
		} catch (Exception e) {
			logger.error(" ### EXCEPTION IN UserServiceImpl :: getParticipantListByEventId ###"+e); 
		}
		return participantList;
	}

	
	@Transactional
	public List<ActivityModel> getActivityListByEventId(Long eventId) {
		List<ActivityModel> activityList=null;
		try {
			activityList=userDao.getActivityListByEventId(eventId);
		} catch (Exception e) {
			logger.error(" ### EXCEPTION IN UserServiceImpl :: getActivityListByEventId ###"+e); 
		}
		return activityList;
	}

	@Transactional
	public String registerParticipantWithActivity(Long eventId, Long activityId,List<Long> participant_Id) throws Exception {
		String message = "";
		try{
			message = userDao.registerParticipantWithActivity(eventId,activityId,participant_Id);
		}catch(Exception e){
			logger.error(" ### EXCEPTION IN UserServiceImpl ###"+e); 
		}
		return message;
	}
	/**** TAJINDER  ADD/EDIT USER ACTIVITY MAPPING END ***********************/
	
	/**** SRIPARNA  ADD/EDIT ACTIVITY  START ***********************/
	@Transactional
	public List<ActivityModel> fetchActivitiesByEventId(String eventId) {
		try{
			return	userDao.fetchActivitiesByEventId(eventId);
			}catch(Exception e){
				logger.error(" ### EXCEPTION IN UserServiceImpl :: fetchActivitiesByEventId ###"+e); 
			}
		
		return null;
	}

	
	@Transactional
	public List<ActivityModel> fetchActivityDetailById(String activityId) {

			try{
				return	userDao.fetchActivityDetailById(activityId);
				}catch(Exception e){
					logger.error(" ### EXCEPTION IN UserServiceImpl :: fetchActivityDetailById ###"+e); 
				}
			
			return null;
	}
	
	@Transactional
	public int createActivity(String activity_id_hidden, String event_Id_hidden,
			String activity_name, String venue, String is_prtcpt_auth_req,
			String is_one_time_pass, String is_reset_on_exit) {
		 
		try{
			return	userDao.createActivity(activity_id_hidden,event_Id_hidden,activity_name,venue,is_prtcpt_auth_req,is_one_time_pass,is_reset_on_exit);
		}catch(Exception e){
			logger.error(" ### EXCEPTION IN UserServiceImpl= createActivity ###"+e); 
		}
		return 0;	
	}
	
	@Transactional
	public int updateActivityDetailById(String activity_id_hidden, String event_Id_hidden,
			String activity_name, String venue, String is_prtcpt_auth_req,
			String is_one_time_pass, String is_reset_on_exit) {
		 
		try{
			return	userDao.updateActivityDetailById(activity_id_hidden,event_Id_hidden,activity_name,venue,is_prtcpt_auth_req,is_one_time_pass,is_reset_on_exit);
		}catch(Exception e){
			logger.error(" ### EXCEPTION IN UserServiceImpl= createActivity ###"+e); 
		}
		return 0;	
	}

	
	@Transactional
	public int deleteActivityDetailById(String activityId) {
		try{
			return	userDao.deleteActivityDetailById(activityId);
			}catch(Exception e){
				logger.error(" ### EXCEPTION IN UserServiceImpl :: deleteActivityDetailById ###"+e); 
			}
		 	return 0;	
	}
	/**** SRIPARNA  ADD/EDIT ACTIVITY  END ***********************/
	
	/*Joydip da 02-01-2018*/
	@Transactional
	public int createMenuByEventId(String menu_field_name_id_hidden,
			String menu_field_id,String is_restriction_acccess) {
		try{
			return	userDao.createMenuByEventId(   menu_field_name_id_hidden,menu_field_id,is_restriction_acccess); //Tajinder Changes
			}catch(Exception e){e.printStackTrace();
				logger.error(" ### EXCEPTION IN UserServiceImpl :: createMenuFieldNameByMenuId ###"+e); 
			}
		
		return 0;
	}
	@Transactional
	public List<MenuModel> fetchMenuNameDetailById(String menuId) {
		try{
			return	userDao.fetchMenuNameDetailById( menuId);
			}catch(Exception e){
				logger.error(" ### EXCEPTION IN UserServiceImpl :: getAllEvents ###"+e); 
			}
		
		return null;
	}
	
	@Transactional
	public List<MenuFieldsNameModel> fetchMenuDetailsById(String menuId) {
		try{
			return	userDao.fetchMenuDetailsById( menuId);
			}catch(Exception e){
				logger.error(" ### EXCEPTION IN UserServiceImpl :: getAllEvents ###"+e); 
			}
		
		return null;
	}
	
	@Transactional
	public List<MenuModel> fetchMenuDetailsByEventId(String menuId) {
		try{
			return	userDao.fetchMenuDetailsByEventId( menuId);
			}catch(Exception e){
				logger.error(" ### EXCEPTION IN UserServiceImpl :: getAllEvents ###"+e); 
			}
		
		return null;
	}
	
	
	@Transactional
	public List<MenuModel> fetchAllMenusById(String menuId) {
		try{
			return	userDao.fetchAllMenusById( menuId);
			}catch(Exception e){
				logger.error(" ### EXCEPTION IN UserServiceImpl :: getAllEvents ###"+e); 
			}
		
		return null;
	}
	
	@Transactional
	public List<MenuFieldsNameModel> fetchMenuFieldNameDetailById(String menuId) {
		try{
			return	userDao.fetchMenuFieldNameDetailById( menuId);
			}catch(Exception e){
				logger.error(" ### EXCEPTION IN UserServiceImpl :: getAllEvents ###"+e); 
			}
		
		return null;
	}
	
	@Transactional
	public int updateMenuFieldNameByMenuId(String menu_field_name_id_hidden,
			String menu_field_name, String menu_field_id) {
		try{
			return	userDao.updateMenuFieldNameByMenuId(   menu_field_name_id_hidden,menu_field_name,menu_field_id);
			}catch(Exception e){e.printStackTrace();
				logger.error(" ### EXCEPTION IN UserServiceImpl :: createMenuFieldNameByMenuId ###"+e); 
			}
		
		return 0;
	}
	
	@Transactional
	public int createMenuFieldNameByMenuId(String menu_field_name_id_hidden,
			String menu_field_name,String  menu_field_id) {
		try{
			return	userDao.createMenuFieldNameByMenuId(   menu_field_name_id_hidden,menu_field_name,menu_field_id);
			}catch(Exception e){e.printStackTrace();
				logger.error(" ### EXCEPTION IN UserServiceImpl :: createMenuFieldNameByMenuId ###"+e); 
			}
		
		return 0;
	}
	
	@Transactional
	public int updateMenuNameByMenuId(String menu_field_name_id_hidden,
			String menu_field_name, String menu_field_id,String is_restriction_acccess) {
		try{
			return	userDao.updateMenuNameByMenuId(menu_field_name_id_hidden,menu_field_name,menu_field_id,is_restriction_acccess);
			}catch(Exception e){e.printStackTrace();
				logger.error(" ### EXCEPTION IN UserServiceImpl :: createMenuFieldNameByMenuId ###"+e); 
			}
		
		return 0;
	}
	
	@Transactional
	public int deleteMenuNameById(String id) {
		 
		try{
			return	userDao.deleteMenuNameById(   id);
			}catch(Exception e){e.printStackTrace();
				logger.error(" ### EXCEPTION IN UserServiceImpl :: deleteMenuNameById ###"+e); 
			}
		
		return 0;
}
	
	@Transactional
	public int deleteMenuFieldNameById(String id) {
		 
		try{
			return	userDao.deleteMenuFieldNameById(   id);
			}catch(Exception e){e.printStackTrace();
				logger.error(" ### EXCEPTION IN UserServiceImpl :: deleteMenuFieldNameById ###"+e); 
			}
		
		return 0;
}
	
	
	
	
	
	
	//==============abdus added this  @28-12-2017    start===============
	
	@Transactional
		public List<ScheduleModel> getScheduleList(String eventId) throws Exception {
			try{
			return	userDao.getScheduleList(eventId);
			}catch(Exception e){
				logger.error(" ### EXCEPTION IN UserServiceImpl :: getAllEvents ###"+e); 
			}
			return null;
			
		}
		//==============abdus added this  @28-12-2017    end===============
		
		//==============abdus added this  @28-12-2017    start===============
		
	@Transactional
	   public List<EventModel> getEventNameList() {
			
			List<EventModel> eventNameList=null;
			try{
				
				
				eventNameList=userDao.getEventNameList();
			}catch(Exception e){
				logger.error(" ### EXCEPTION IN UploadExcelFileServiceImpl ###"+e); 
			}
			return eventNameList;
			
		}
	 //==============abdus added this  @28-12-2017    end===============
	   
	 //================abdus added this  @28-12-2017    Start====================
	@Transactional
	   public List<ScheduleModel> fetchScheduleModelDetailById(String eventId) {
			try{
				return	userDao.fetchScheduleModelDetailById( eventId);
				}catch(Exception e){
					logger.error(" ### EXCEPTION IN UserServiceImpl :: fetchScheduleModelDetailById ###"+e); 
				}
			
			return null;
		}
		
		//================abdus added this  @28-12-2017    end====================
	   
	 //========abdus added this code ==========start============@29-12-2017
	@Transactional
	   public int saveScheduleModelData(ScheduleModel scheduleModel, String participant_id_hidden) {
	  	 
	  	try{
	  		return	userDao.saveScheduleModelData(scheduleModel, participant_id_hidden);
	  	}catch(Exception e){
	  		logger.error(" ### EXCEPTION IN UserServiceImpl ###"+e); 
	  	}
	  	return 0;
	  	
	  	
	  	
	      }
	   
	  //========abdus added this code ==========end============@29-12-2017
	  //========abdus added this code ==========start============@29-12-2017
	@Transactional
	   public int updateScheduleModelData(ScheduleModel scheduleModel, String participant_id_hidden) {
	  	 
	  		try{
	  			return	userDao.updateScheduleModelData(scheduleModel, participant_id_hidden);
	  		}catch(Exception e){
	  			logger.error(" ### EXCEPTION IN UserServiceImpl ###"+e); 
	  		}
	  		return 0;
	  		
	  		
	  		
	  	    }
	  //========abdus added this code ==========end============@29-12-2017
	   
	  //========abdus added this code ==========start============@29-12-2017
	@Transactional
	   public int deleteScheduleModelRowById(String scheduleId) {
	  		
	  		try{
	  			return	userDao.deleteScheduleModelRowById( scheduleId);
	  			}catch(Exception e){
	  				logger.error(" ### EXCEPTION IN UserServiceImpl :: deleteEventDetailById ###"+e); 
	  			}
	  		 	return 0;		
	  	}

	  //========abdus added this code ==========end============@29-12-2017
	/**** MOUSUMI START add edit menu fields value 03-01-2018 ************************/
	@Transactional
	public List<Object> fetchMenuValueListByMenuId(long menuId) {
		try{
  			return	userDao.fetchMenuValueListByMenuId( menuId);
  			}catch(Exception e){
  				logger.error(" ### EXCEPTION IN UserServiceImpl :: fetchMenuValueListByMenuId ###"+e); 
  			}
  		 	return null;
	}
	
	@Transactional
	public List<MenuFieldsValueModel> fetchMenuValueDetailsBySetId(long setId) {
		try{
  			return	userDao.fetchMenuValueDetailsBySetId( setId);
  			}catch(Exception e){
  				logger.error(" ### EXCEPTION IN UserServiceImpl :: fetchMenuValueDetailsBySetId ###"+e); 
  			}
  		 	return null;
	}
	
	
	@Transactional
	public String saveUpdateMenuFieldValue(List<MenuFieldsValueModel> menuFieldsValueModelList ,
			Long eventId , Long menuId ) {
		try{
			if(menuFieldsValueModelList!=null){
				if(menuFieldsValueModelList.size()>0){
				if(menuFieldsValueModelList.get(0).getId()!=null){
						for(int i=0;i<menuFieldsValueModelList.size();i++){
							
								userDao.updateMenuFieldValueByMenuId(
				  						menuFieldsValueModelList.get(i).getMenu_fields_value(),menuFieldsValueModelList.get(i).getId());
			  			}
				}else{
						long menuFieldValueId=userDao.getMenuFiledValueSetId(menuId);
						for(int i=0;i<menuFieldsValueModelList.size();i++){
							userDao.saveMenuFieldValue(menuId,menuFieldsValueModelList.get(i).getMenu_fields_name_id(),
				  						menuFieldsValueModelList.get(i).getMenu_fields_value(), menuFieldValueId);
						}
				}
				}
			}
  			}catch(Exception e){
  				logger.error(" ### EXCEPTION IN UserServiceImpl :: fetchMenuValueListByMenuId ###"+e); 
  			}
  		 	return null;
	}
	
	
	@Transactional
	public int deleteEventMenuValueBySetId(long setId) {
		try{
			
				return	userDao.deleteEventMenuValueBySetId(setId);
  				
			
  			}catch(Exception e){
  				logger.error(" ### EXCEPTION IN UserServiceImpl :: fetchMenuValueListByMenuId ###"+e); 
  			}
  		 	return 0;
	}
	
	@Transactional
	public int checkIsUserValidForPrint( long userId){
		try{
			
			return	userDao.checkIsUserValidForPrint(userId);
				
		
			}catch(Exception e){
				logger.error(" ### EXCEPTION IN UserServiceImpl :: checkIsUserValidForPrint ###"+e); 
			}
		 	return 0;
	}
	
	@Transactional
	public int deleteEventMenuValueByForMenuId(long menuId) {
		try{
			
			return	userDao.deleteEventMenuValueByForMenuId(menuId);
				
		
			}catch(Exception e){
				logger.error(" ### EXCEPTION IN UserServiceImpl :: fetchMenuValueListByMenuId ###"+e); 
			}
		 	return 0;
	}
	/**** MOUSUMI END add edit menu fields value 03-01-2018 ************************/
	/*Priyanka 26.12.2017 @Start*/
	@Transactional
	public int updateEventAboutDetailById(EventModel event) throws Exception {
		try{
			return userDao.updateEventAboutDetailById(event);
		}catch(Exception e){
			logger.error(" ### EXCEPTION IN UserServiceImpl -->> updateEventAboutDetailById ###"+e); 
		}
		return 0;
	}
	/*Priyanka 26.12.2017 @End*/
	
	/**** TAJINDER 04-01-2018  START ***********************/
	@Transactional
	public int deleteUserById(String userId) throws Exception {
		try{
			return	userDao.deleteUserById(userId);
			}catch(Exception e){
				logger.error(" ### EXCEPTION IN UserServiceImpl :: deleteEventDetailById ###"+e); 
			}
		 	return 0;
	}
	/**** TAJINDER 04-01-2018  END ***********************/
	/*Priyanka 04.01.2018 @Start*/
	@Transactional
	public EventModel getEventDetailById(long eventId) throws Exception {
		EventModel event = new EventModel();
		try{
			event = userDao.getEventDetailById(eventId);
		}catch(Exception e){
			logger.error(" ### EXCEPTION IN UserServiceImpl ###"+e); 
		}
		return event;
	}
	/*Priyanka 04.01.2018 @End*/
	
	/*Tajinder 5-1-2018 @Start*/
	@Transactional
	public List<UserProfileModel> fetchParticipantDetailsByEventAndActivityId(
			String eventId, String activityId) {
		try{
			return	userDao.fetchParticipantDetailsByEventAndActivityId(eventId,activityId);
			}catch(Exception e){
				logger.error(" ### EXCEPTION IN UserServiceImpl :: getAllEvents ###"+e); 
			}
		
		return null;
	}
	/*Tajinder 5-1-2018 @End*/
	@Transactional
	public int deleteuserMappingById(String userMappingId) throws Exception {
		try{
				return	userDao.deleteuserMappingById(userMappingId);
						
		}catch(Exception e){
						logger.error(" ### EXCEPTION IN UserServiceImpl :: fetchMenuValueListByMenuId ###"+e); 
		}
		return 0;
	}
}
