package com.event.management.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
import com.event.management.vo.BannerImageForm;
import com.event.management.vo.MenuForm;
public interface UserDao {

	public void getUserDetails(long userId) throws Exception;
	public List<MenuForm> getMenuList(long eventId) throws Exception;//Priyanka 19.12.2017
	public BannerImageForm getAboutDetails(long eventId)throws Exception; //Tajinder 21.12.2017
	public List getScheduleDetails(long eventId) throws Exception; //Sriparna 20-12-2017
	public EventModel getActiveEventDetails() throws Exception;//Priyanka 20.12.2017
	public UserProfileModel validateUser(String username, String password,Long roleId);//Tajinder 20.12.2017
	public UserProfileModel getICardInformation(long userId, long eventId)throws Exception;//Priyanka 21.12.2017;
	public List<ActivityModel> getActivityDetail(long eventId)throws Exception; //Tajinder 21.12.2017
	public List<Object> getMenuDetails(long menuId)throws Exception; //Priyanka 21.12.2017
	
	/*Joydip Da 21-12-2017*/
	public List<EventModel> getAllEvents();
	public List<EventModel> fetchEventDetailById(String eventId);

	public int setEventActiveById(String eventId);

	/*public void updateEditedEvent(String event_name, String about_us,
			List<String> event_venue, List<String> addmoreVal, String menuID, String event_id_hidden);
	*/
	public int updateEditedEvent(String event_name, String about_us,
			String event_venue, String event_id_hidden2, Date event_sdate, String event_stime, Date event_edate, String event_etime);
	
	public int createEventDetail(String event_name, String about_us,
			String event_venue, String event_id_hidden, Date event_sdate,
			String event_stime, Date event_edate, String event_etime);
	
	public UserProfileModel validateUser(String username, String password)throws Exception;//Tajinder 21.12.2017
	
	public void saveEventImage(EventModel evt) throws Exception;//Tajinder 22.12.2017
	
	public void saveBannerImage(EventBannerImageModel bannerImg) throws Exception;//Tajinder 22.12.2017

	public int deleteEventDetailById(String eventId);
	
	public void saveParticipantsList(List<UserProfileModel> listUserProfileModel) throws Exception;
	
	/****JOYDIP ADD/EDIT PARTICIPANT START*******************************/
	public List<UserProfileModel> fetchAllUserDetails(String eventId);

	public List<UserProfileModel> fetchUserDetailById(String userId);

	public int updateEditedUser(long eventId,String user_name, String name_of_user,
			String user_pass, String user_id_hidden, String user_email,String user_email_hidden,
			String user_phone, String user_address,String user_category);

	public int createUserDetail(String user_name, String name_of_user,
			String user_pass, String user_id_hidden, String user_email,
			String user_phone, String user_address, String user_company,
			String user_designation, String user_event_id,String user_category);

	/****JOYDIP ADD/EDIT PARTICIPANT END*******************************/
	
	/**** TAJINDER  ADD/EDIT USER ACTIVITY MAPPING START ***********************/
	public List<UserProfileModel> getParticipantListByEventId(Long eventId) throws Exception; //Tajinder 26.12.2017
	public List<ActivityModel> getActivityListByEventId(Long eventId) throws Exception; //Tajinder 26.12.2017
	public String registerParticipantWithActivity(Long eventId,Long activityId, List<Long> participant_Id) throws Exception; //Tajinder 26.12.2017
	/**** TAJINDER  ADD/EDIT USER ACTIVITY MAPPING END ***********************/
	
	/**** SRIPARNA  ADD/EDIT ACTIVITY  START ***********************/
	
	public List<ActivityModel> fetchActivitiesByEventId(String eventId); /*Sriparna 26-12-2017*/
	public List<ActivityModel> fetchActivityDetailById(String activityId); /*Sriparna 26-12-2017*/
	public int createActivity(String activity_id_hidden, String event_Id_hidden,
			String activity_name, String venue, String is_prtcpt_auth_req,
			String is_one_time_pass, String is_reset_on_exit);   /*Sriparna 26-12-2017*/
	public int updateActivityDetailById(String activity_id_hidden, String event_Id_hidden,
			String activity_name, String venue, String is_prtcpt_auth_req,
			String is_one_time_pass, String is_reset_on_exit);   /*Sriparna 26-12-2017*/
	public int deleteActivityDetailById(String activityId);  /*Sriparna 26-12-2017*/
	
	
	/*WEB SERVICE*/
	public String adminDeviceSetup(AdminDeviceSetup deviceDetails) throws Exception; //Priyanka 22.12.2017
	/*public String getParticipantPresence(ActivityUserMappingModel activityDetails, long eventId,String entryOrExit) throws Exception; //Priyanka 22.12.2017
*/
	public ArrayList<String> getParticipantPresence(ActivityUserMappingModel activityDetails, long eventId,String entryOrExit) throws Exception; //Priyanka 22.12.2017

	/**** SRIPARNA  ADD/EDIT ACTIVITY  END ***********************/
	
	public int createMenuByEventId(String menu_field_name_id_hidden,
			String menu_field_id,String is_restriction_acccess);//Tajinder Changes
	public List<MenuModel> fetchMenuNameDetailById(String menuId);
	public List<MenuFieldsNameModel> fetchMenuDetailsById(String menuId);
	public List<MenuModel> fetchMenuDetailsByEventId(String menuId);
	public List<MenuModel> fetchAllMenusById(String menuId);
	public List<MenuFieldsNameModel> fetchMenuFieldNameDetailById(String menuId);
	public int updateMenuFieldNameByMenuId(String menu_field_name_id_hidden,
			String menu_field_name, String menu_field_id);
	public int createMenuFieldNameByMenuId(String menu_field_name_id_hidden,
			String menu_field_name, String menu_field_id);
	public int updateMenuNameByMenuId(String menu_field_name_id_hidden,
			String menu_field_name, String menu_field_id,String is_restriction_acccess);//Tajinder Changes
	public int deleteMenuNameById(String id);
	public int deleteMenuFieldNameById(String id);
	
	
public List<ScheduleModel> getScheduleList(String eventId);   //abdus added this code @28-12-2017
	
	public List<EventModel> getEventNameList() throws Exception;    //abdus added this code @28-12-2017
	public int saveScheduleModelData(ScheduleModel scheduleModel, String participant_id_hidden) throws Exception;  //abdus added this code @28-12-2017
	public int updateScheduleModelData(ScheduleModel scheduleModel, String participant_id_hidden) throws Exception;  //abdus added this code @28-12-2017
	
	public List<ScheduleModel> fetchScheduleModelDetailById(String scheduleId);  //abdus added this code @29-12-2017
	public int deleteScheduleModelRowById(String scheduleId);   //abdus added this code @29-12-2017
	
	public List<Object> fetchMenuValueListByMenuId(long menuId) ;
	public int updateEventAboutDetailById(EventModel event) throws Exception; //Priyanka 27.12.2017
	
	public Long getMenuFiledValueSetId(long menu_id) ;
	public int updateMenuFieldValueByMenuId(
			String menu_fields_value, long menu_field_value_id);
	
	public int saveMenuFieldValue(long menu_id,long menu_field_name_id,
			String menu_fields_value,long menu_fields_value_set_id);
	public List<MenuFieldsValueModel> fetchMenuValueDetailsBySetId(long setId);
	
	public int deleteEventMenuValueBySetId(long setId) ;
	
	public int deleteEventMenuValueByForMenuId(long menuId) ;
	
	
	public int checkIsUserValidForPrint( long userId);
	/**** TAJINDER 04-01-2018  START ***********************/
	public int deleteUserById(String userId) throws Exception;
	/**** TAJINDER 04-01-2018  END ***********************/
	
	public int deleteBannerImageByEventId(long eventId) throws Exception ;
	
	public EventModel getEventDetailById(long eventId) throws Exception; //Priyanka 04.01.2018;
	
	public List<UserProfileModel> fetchParticipantDetailsByEventAndActivityId(String eventId,String activityId) throws Exception;/*Tajinder 5-1-2018 @Start*/
	public int deleteuserMappingById(String userMappingId) throws Exception;/*Tajinder 5-1-2018 @Start*/
}
