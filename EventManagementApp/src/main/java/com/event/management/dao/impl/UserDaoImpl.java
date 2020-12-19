package com.event.management.dao.impl;

import java.math.BigInteger;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.event.management.constant.CommonConstant;
import com.event.management.constant.ErrorConstant;
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
import com.event.management.model.MenuNameValueSet;
import com.event.management.model.ScheduleModel;
import com.event.management.model.UserProfileModel;
import com.event.management.util.CommonUtility;
import com.event.management.util.EncryptDecrypt;
import com.event.management.util.QRCodeUtil;
import com.event.management.vo.BannerImageForm;
import com.event.management.vo.MenuDetails;
import com.event.management.vo.MenuForm;
import com.event.management.vo.SocialMediaLink;

public class UserDaoImpl implements UserDao {

	private static final Logger logger = Logger.getLogger(UserDaoImpl.class);

	SessionFactory sessionFactory;

	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void getUserDetails(long userId) throws Exception {
		try {
			sessionFactory.getCurrentSession();
		} catch (Exception e) {
			logger.error(" ### EXCEPTION IN UserDaoImpl ###" + e);
		}
	}

	/* Priyanka 19-12-2017 @Start */

	public UserProfileModel validateUser(String username, String password)
			throws Exception {
		UserProfileModel user = null;
		try {
			EncryptDecrypt encryptDecrypt = new EncryptDecrypt();
			String encryptedpassword = encryptDecrypt.encrypt(password);
			Session session = sessionFactory.getCurrentSession();
			String hqlQuery = "Select u FROM UserProfileModel u WHERE u.username = :username and u.password = :password and u.role_id = :roleId";

			Query query = session.createQuery(hqlQuery);
			query.setParameter("username", username);
			query.setParameter("password", encryptedpassword);
			query.setParameter("roleId", (long) 1);
			user = (UserProfileModel) query.uniqueResult();
			//session.close();
		} catch (Exception e) {
			logger.error(" ### EXCEPTION IN UserDaoImpl ###" + e);
		}
		return user;

	}

	@SuppressWarnings("unchecked")
	public List<MenuForm> getMenuList(long eventId) throws Exception {
		List<MenuForm> menuList = new ArrayList<MenuForm>();
		try {
			Session session = sessionFactory.getCurrentSession();
			List<MenuModel> menu = session.createCriteria(MenuModel.class)
					.add(Restrictions.eq("event_id", eventId)).list();

			for (MenuModel m : menu) {
				MenuForm data = new MenuForm();
				data.setId(m.getId());
				data.setEvent_id(m.getEvent_id());
				data.setMenu_name(m.getMenu_name());
				data.setIs_restricted_access(m.getIs_restricted_access());

				menuList.add(data);
			}
		} catch (Exception e) {
			logger.error(" ### EXCEPTION IN UserDaoImpl ###" + e);
		}
		return menuList;
	}

	/* Priyanka 19-12-2017 @End */

	/* Sriparna 20-12-2017 */
	public List getScheduleDetails(long eventId) throws Exception {

		Session session = sessionFactory.getCurrentSession();
		List<ScheduleModel> scheduleList = session
				.createCriteria(ScheduleModel.class)
				.add(Restrictions.eq("event_id", eventId)).add(Restrictions.eq("is_deleted", 0)) //Priyanka 08.01.2018
.addOrder(Order.asc("schedule_date")).list();

		return scheduleList;
	}

	/* Priyanka 20-12-2017 @Start */

	public EventModel getActiveEventDetails() throws Exception {
		EventModel activeEventDetails = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			activeEventDetails = (EventModel) session
					.createCriteria(EventModel.class)
					.add(Restrictions.eq("is_event_active", 1)).uniqueResult();
		} catch (Exception e) {
			logger.error(" ### EXCEPTION IN UserDaoImpl ###" + e);
		}
		return activeEventDetails;
	}

	/* Priyanka 20-12-2017 @End */

	public UserProfileModel validateUser(String username, String password,
			Long roleId) {
		UserProfileModel user = null;
		try {
			EncryptDecrypt encryptDecrypt=new EncryptDecrypt();
			String encryptpassword=encryptDecrypt.encrypt(password);
			Session session = sessionFactory.getCurrentSession();
			String hqlQuery = "Select u FROM UserProfileModel u WHERE u.username = :username and u.password = :password and u.role_id = :roleId";

			Query query = session.createQuery(hqlQuery);
			query.setParameter("username", username);
			query.setParameter("password", encryptpassword);
			query.setParameter("roleId", roleId);
			user = (UserProfileModel) query.uniqueResult();

		} catch (Exception e) {
			logger.error(" ### EXCEPTION IN UserDaoImpl ###" + e);
		}
		return user;
	}

	/* Priyanka 20-12-2017 @Start */
	public UserProfileModel getICardInformation(long userId, long eventId)
			throws Exception {
		UserProfileModel userDetails = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			userDetails = (UserProfileModel) session
					.createCriteria(UserProfileModel.class)
					.add(Restrictions.and(Restrictions.eq("id", userId),
							Restrictions.eq("event_id", eventId)))
					.uniqueResult();
		} catch (Exception e) {
			logger.error(" ### EXCEPTION IN UserDaoImpl ###" + e);
		}
		return userDetails;
	}

	public List<Object> getMenuDetails(long menuId) throws Exception {
		List<MenuDetails> menuDetailsList = new ArrayList<MenuDetails>();
		Map<String, List<MenuDetails>> menuDetails1 = new HashMap<String, List<MenuDetails>>();
		List<Object> mdlist = new ArrayList<Object>();
		try {
			Session session = sessionFactory.getCurrentSession();
			String hql = " select n.menu_field_name,v.menu_fields_value,v.menu_name_value_set_id "
					+ " from MenuFieldsNameModel n , MenuFieldsValueModel v "
					+ " where n.id = v.menu_fields_name_id and n.menu_id = :menuId "
					+ " order by v.menu_name_value_set_id ASC ";

			List<Object> result = (List<Object>) session.createQuery(hql)
					.setParameter("menuId", menuId).list();
			long count = 0;
			Iterator itr = result.iterator();
			List<MenuDetails> ml = new ArrayList<MenuDetails>();

			while (itr.hasNext()) {
				Object[] obj = (Object[]) itr.next();
				System.out.println(obj[2]);

				if (count == (Long) obj[2]) {
					MenuDetails m = new MenuDetails();
					m.setMenu_field((String) obj[0]);
					m.setMenu_value((String) obj[1]);
					m.setMenu_name_value_set_id((Long) obj[2]);
					ml.add(m);
				} else {
					count = (Long) obj[2];
					ml = new ArrayList<MenuDetails>();
					MenuDetails m = new MenuDetails();
					m.setMenu_field((String) obj[0]);
					m.setMenu_value((String) obj[1]);
					m.setMenu_name_value_set_id((Long) obj[2]);
					ml.add(m);
				}
				menuDetails1.put("set" + obj[2], ml);
			}

			Iterator<Entry<String, List<MenuDetails>>> mapItr = menuDetails1
					.entrySet().iterator();
			while (mapItr.hasNext()) {
				Map.Entry<String, List<MenuDetails>> entry = mapItr.next();
				mdlist.add(entry.getValue());
			}

		} catch (Exception e) {
			logger.error(" ### EXCEPTION IN UserDaoImpl ###" + e);
		}
		return mdlist;
	}

	/* Priyanka 20-12-2017 @End */

	/* Tajinder 21-12-2017 @Start */
	public BannerImageForm getAboutDetails(long eventId) throws Exception {

		BannerImageForm bannerImage = new BannerImageForm();
		List<EventBannerImageModel> list = new ArrayList<EventBannerImageModel>();

		try {
			Session session = sessionFactory.getCurrentSession();

			String hql = "Select e FROM EventModel e WHERE e.id = :eventId ";
			Query query = session.createQuery(hql);
			query.setParameter("eventId", eventId);

			//Priyanka 23.12.2017 @Start
	        EventModel event =( EventModel)  query.uniqueResult();
	        bannerImage.setAbout_Us(event.getAbout_us());
	        bannerImage.setEvent_id(event.getId());
	        bannerImage.setContact_person(event.getContact_person());
	        bannerImage.setContact_no(event.getContact_no());
	        bannerImage.setContact_email(event.getContact_email());//Priyanka 08.01.2018
	        
	        List<SocialMediaLink> mediaLinkList = new ArrayList<SocialMediaLink>();
	        if(event.getFacebook_link()!=null){
	        	SocialMediaLink mediaLink = new SocialMediaLink();
	        	mediaLink.setSocialMedia_type("FaceBook");
	        	mediaLink.setSocialMedia_link(event.getFacebook_link());
	        	mediaLinkList.add(mediaLink);
	        }
	        if(event.getLinkedin_link()!=null){
	        	SocialMediaLink mediaLink = new SocialMediaLink();
	        	mediaLink.setSocialMedia_type("LinkedIn");
	        	mediaLink.setSocialMedia_link(event.getLinkedin_link());
	        	mediaLinkList.add(mediaLink);
	        }
	        if(event.getTwitter_link()!=null){
	        	SocialMediaLink mediaLink = new SocialMediaLink();
	        	mediaLink.setSocialMedia_type("Twitter");
	        	mediaLink.setSocialMedia_link(event.getTwitter_link());
	        	mediaLinkList.add(mediaLink);
	        }
	        if(event.getBlogger_link()!=null){
	        	SocialMediaLink mediaLink = new SocialMediaLink();
	        	mediaLink.setSocialMedia_type("Blogger");
	        	mediaLink.setSocialMedia_link(event.getBlogger_link());
	        	mediaLinkList.add(mediaLink);
	        }
	        if(event.getGoogle_plus_link()!=null){
	        	SocialMediaLink mediaLink = new SocialMediaLink();
	        	mediaLink.setSocialMedia_type("Google Plus");
	        	mediaLink.setSocialMedia_link(event.getGoogle_plus_link());
	        	mediaLinkList.add(mediaLink);
	        }
	        if(event.getTumblr_link()!=null){
	        	SocialMediaLink mediaLink = new SocialMediaLink();
	        	mediaLink.setSocialMedia_type("Tumblr");
	        	mediaLink.setSocialMedia_link(event.getTumblr_link());
	        	mediaLinkList.add(mediaLink);
	        }
	        
	        bannerImage.setSocialMediaLinkList(mediaLinkList); 
	      //Priyanka 23.12.2017 @End
	        
	      //Priyanka 08.01.2018 @Start
	        String liveUrl = event.getLive_url();
	        liveUrl = liveUrl.replace("\n", "").replace("\\s+", "");
	        List liveUrlList = Arrays.asList(liveUrl.split(","));
	        bannerImage.setLiveUrlList(liveUrlList);
	      //Priyanka 08.01.2018 @End  
	        
			List<EventBannerImageModel> eventBannerImageModel = session	.createCriteria(EventBannerImageModel.class).add(Restrictions.eq("event_id", eventId)).list();
			for (EventBannerImageModel eb : eventBannerImageModel) {
				eb.setBanner_img_path(eb.getBanner_img_path());
				list.add(eb);
			}
			bannerImage.setBannerImg(list);

		} catch (Exception e) {
			logger.error(" ### EXCEPTION IN UserDaoImpl ###" + e);
		}
		return bannerImage;
	}


	public List<ActivityModel> getActivityDetail(long eventId) throws Exception {
		List<ActivityModel> activity = new ArrayList<ActivityModel>();
		try {
			Session session = sessionFactory.getCurrentSession();
			activity = session.createCriteria(ActivityModel.class)
					.add(Restrictions.eq("event_id", eventId)).list();

		} catch (Exception e) {
			logger.error(" ### EXCEPTION IN UserDaoImpl ###" + e);
		}
		return activity;
	}

	/* Tajinder 21-12-2017 @End */

	/* Joydip Da 21-12-2017 */

	public List<EventModel> getAllEvents() {
		
		try {

			

			Session session = sessionFactory.getCurrentSession();

			
			 Query query = session.createQuery("from EventModel where is_deleted="+0);
		        
			java.util.List<EventModel> list = query.list();
			//session.close();
			return list;
		} catch (Exception e) {
			
			e.printStackTrace(System.err);
			logger.error(" ### EXCEPTION IN UserDaoImpl :: getAllEvents ###"
					+ e);

		}
		return null;
	}

	public List<EventModel> fetchEventDetailById(String eventId) {
		try {

		// creating session object
			Session session = sessionFactory.getCurrentSession();

			

			Query query = session.createQuery("from EventModel where id= "
					+ eventId);
			java.util.List<EventModel> list = query.list();
			System.out.println(list);
			
			return list;
		} catch (Exception e) {
			

			e.printStackTrace(System.err);
			logger.error(" ### EXCEPTION IN UserDaoImpl :: getAllEvents ###"
					+ e);

		}
		return null;
	}

	public int setEventActiveById(String eventId) {

		try {
			System.out.println("setEventActiveById->>" + " " + eventId + "  ");

			Session session = sessionFactory.getCurrentSession();

			Query query = session
					.createQuery("update EventModel set is_event_active=0");

			query.executeUpdate();

			//session = sessionFactory.openSession();

			query = session
					.createQuery("update EventModel set is_event_active=1 where id="
							+ Long.parseLong(eventId));
			int y = query.executeUpdate();
			session.flush();
			return y;
		} catch (Exception ex) {

			ex.printStackTrace();
			return 0;
		}
	}

	/*
	 * public void updateEditedEvent(String event_name, String about_us,
	 * List<String> event_venue, List<String> addmoreVal, String menuID,String
	 * event_id_hidden) { int count=1; try{
	 * System.out.println("updateEditedEvent->>" +
	 * " "+event_name+"  "+about_us+"  "
	 * +event_venue+"  "+addmoreVal+"  "+menuID);
	 * 
	 * MenuModel mModel =new MenuModel(); Transaction t=null;
	 * mModel.setId(Long.decode(menuID));
	 * mModel.setEvent_id(Long.decode(event_id_hidden));
	 * mModel.setMenu_name(event_name); mModel.setIs_restricted_access(0);
	 * sessionFactory.getCurrentSession().update(mModel); Session session =
	 * sessionFactory.openSession();
	 * 
	 * Query query =
	 * session.createQuery("delete MenuFieldsModel where menu_id= "+menuID);
	 * 
	 * query.executeUpdate(); } catch(Exception ex){ ex.printStackTrace(); } }
	 */

	public int updateEditedEvent(String event_name, String about_us,
			String event_venue, String event_id_hidden, Date event_sdate,
			String event_stime, Date event_edate, String event_etime) {

		try {
			System.out.println("updateEditedEvent->>" + " " + event_name + "  "
					+ about_us + "  " + event_venue + "  " + "  ");

			Session session = sessionFactory.getCurrentSession();

			Query query = session
					.createQuery("update EventModel set event_name='"
							+ event_name + "',  event_venue='" + event_venue
							+ "'," + "  about_us='" + about_us
							+ "',event_start_date='" + event_sdate
							+ "',event_start_time='" + event_stime + "',"
							+ "event_end_date='" + event_edate
							+ "',event_end_time='" + event_etime
							+ "' where id='" + event_id_hidden + "'");

			query.executeUpdate();

			session.flush();
			return 1;

		} catch (Exception ex) {

			ex.printStackTrace();
			return 0;
		}

	}

	/*
	 * public void updateEditedEvent(String event_name, String about_us,
	 * List<String> event_venue, List<String> addmoreVal, String menuID, String
	 * event_id_hidden) { // TODO Auto-generated method stub
	 * 
	 * }
	 */

	public int createEventDetail(String event_name, String about_us,
			String event_venue, String event_id_hidden, Date event_sdate,
			String event_stime, Date event_edate, String event_etime) {
		try {
			System.out.println("createEventDetail->>" + " " + event_name + "  "
					+ about_us + "  " + event_venue + "  " + "  ");

			Session session = sessionFactory.getCurrentSession();

			EventModel eM = new EventModel();
			eM.setId(Long.decode(event_id_hidden));
			eM.setEvent_name(event_name);
			eM.setEvent_venue(event_venue);
			eM.setAbout_us(about_us);
			eM.setEvent_start_date(event_sdate);
			eM.setEvent_start_time(event_stime);
			eM.setEvent_end_date(event_edate);
			eM.setEvent_end_time(event_etime);

			sessionFactory.getCurrentSession().save(eM);

			session.flush();
			return 1;

		} catch (Exception ex) {

			ex.printStackTrace();
			return 0;
		}
	}

	public void saveEventImage(EventModel evt) throws Exception {
		try {
			Session session = sessionFactory.getCurrentSession();
			String hqlQuery = "update EventModel e set e.event_screen_image_path = :event_screen_image_path  where e.id = :eventId";
			session.createQuery(hqlQuery)
					.setString("event_screen_image_path",
							evt.getEvent_screen_image_path())
					.setLong("eventId", evt.getId()).executeUpdate();
		} catch (Exception e) {
			logger.error(" ### EXCEPTION IN UserDaoImpl ###" + e);
		}
	}

	public void saveBannerImage(EventBannerImageModel bannerImg)
			throws Exception {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(bannerImg);

		} catch (Exception e) {
			logger.error(" ### EXCEPTION IN UserDaoImpl ###" + e);
		}
	}

	/* Priyanka 22-12-2017 @Start */
	public String adminDeviceSetup(AdminDeviceSetup deviceDetails) throws Exception {
		String message = "";
		try{
			Session session = sessionFactory.getCurrentSession();
			List result = session.createCriteria(AdminDeviceSetup.class).add(Restrictions.eq("device_id",deviceDetails.getDevice_id())).list();
			
			if(!result.isEmpty()){
            	AdminDeviceSetup device =new AdminDeviceSetup();
            	session.createQuery("UPDATE AdminDeviceSetup SET is_active = 0 WHERE device_id = :deviceId").setParameter("deviceId",deviceDetails.getDevice_id()).executeUpdate();
            }
            session.save(deviceDetails);
            
		}catch(Exception e){
			message = e.getMessage();
			logger.error(" ### EXCEPTION IN UserDaoImpl ###" + e);
		}
		return message;
	}

	/*public String getParticipantPresence(ActivityUserMappingModel activityDetails, long eventId,String entryOrExit) throws Exception {
		String message = "";
		try {
			Session session = sessionFactory.getCurrentSession();

			ActivityModel activity = (ActivityModel) session
					.createCriteria(ActivityModel.class)
					.add(Restrictions.and(
							Restrictions.eq("id",
									activityDetails.getActivity_id()),
							Restrictions.eq("event_id", eventId)))
					.uniqueResult();
			if (activity != null) {
				if (activity.getIs_prtcpt_auth_req() == 1) {
					ActivityUserMappingModel activityUser = (ActivityUserMappingModel) session
							.createCriteria(ActivityUserMappingModel.class)
							.add(Restrictions.and(Restrictions.eq(
									"activity_id",
									activityDetails.getActivity_id()),
									Restrictions.eq("user_id",
											activityDetails.getUser_id())))
							.uniqueResult();
					if (activityUser != null) {
						if (activity.getIs_one_time_pass() == 1) {
							if (entryOrExit.equalsIgnoreCase("Entry")) {
								if (activityUser.getIs_enter() == 1) {
									message = MessageConstant.MSG_ACTIVITY_ALREADY_ATTEND;
								} else {
									session.createQuery(
											"UPDATE ActivityUserMappingModel SET is_enter = 1 WHERE activity_id = :activityID AND user_id =:userId ")
											.setParameter(
													"activityID",
													activityDetails
															.getActivity_id())
											.setParameter(
													"userId",
													activityDetails
															.getUser_id())
											.executeUpdate();
									message = MessageConstant.MSG_SUCCESSFUL_ENTRY;
								}
							} else {
								session.createQuery(
										"UPDATE ActivityUserMappingModel SET is_exit = 1 WHERE activity_id = :activityID AND user_id =:userId ")
										.setParameter(
												"activityID",
												activityDetails
														.getActivity_id())
										.setParameter("userId",
												activityDetails.getUser_id())
										.executeUpdate();
								message = MessageConstant.MSG_USE_EXIT;
							}
						} else {
							session.createQuery(
									"UPDATE ActivityUserMappingModel SET is_enter = 1 WHERE activity_id = :activityID AND user_id =:userId ")
									.setParameter("activityID",
											activityDetails.getActivity_id())
									.setParameter("userId",
											activityDetails.getUser_id())
									.executeUpdate();
							message = MessageConstant.MSG_SUCCESSFUL_ENTRY;
						}
					}
				} else {
					message = MessageConstant.MSG_SUCCESSFUL_ENTRY;
				}
			} else {
				message = MessageConstant.MSG_ACTIVITY_NOT_IN_EVENT;
			}

		} catch (Exception e) {
			logger.error(" ### EXCEPTION IN UserDaoImpl ###" + e);
		}
		return message;
	}*/
	public ArrayList<String> getParticipantPresence(ActivityUserMappingModel activityDetails, long eventId,String entryOrExit) throws Exception {
		ArrayList<String> list=new ArrayList<String>(); 
		try {
			Session session = sessionFactory.getCurrentSession();

			ActivityModel activity = (ActivityModel) session.createCriteria(ActivityModel.class)
					.add(Restrictions.and(Restrictions.eq("id",activityDetails.getActivity_id()),
					 Restrictions.eq("event_id", eventId))).uniqueResult();
			if (activity != null) {
				if (activity.getIs_prtcpt_auth_req() == 1) {
					ActivityUserMappingModel activityUser = (ActivityUserMappingModel) session.createCriteria(ActivityUserMappingModel.class)
							.add(Restrictions.and(Restrictions.eq("activity_id",activityDetails.getActivity_id()),
							 Restrictions.eq("user_id",activityDetails.getUser_id()))).uniqueResult();
					if (activityUser != null) {
						if (activity.getIs_one_time_pass() == 1) {
							if (entryOrExit.equalsIgnoreCase("Entry")) {
								if (activityUser.getIs_enter() == 1) {
									list.add(MessageConstant.MSG_ACTIVITY_ALREADY_ATTEND_CODE);
									list.add(MessageConstant.MSG_ACTIVITY_ALREADY_ATTEND);
								} else {
									session.createQuery("UPDATE ActivityUserMappingModel SET is_enter = 1 WHERE activity_id = :activityID AND user_id =:userId ")
											.setParameter("activityID",activityDetails.getActivity_id())
											.setParameter("userId",activityDetails.getUser_id()).executeUpdate();
									list.add(MessageConstant.MSG_SUCCESSFUL_ENTRY_CODE);
									list.add(MessageConstant.MSG_SUCCESSFUL_ENTRY);
								}
							} else {
								session.createQuery("UPDATE ActivityUserMappingModel SET is_exit = 1 WHERE activity_id = :activityID AND user_id =:userId ")
										.setParameter("activityID",activityDetails.getActivity_id())
										.setParameter("userId",activityDetails.getUser_id()).executeUpdate();
								list.add(MessageConstant.MSG_USE_EXIT_CODE);
								list.add(MessageConstant.MSG_USE_EXIT);
							}
						} else {
							session.createQuery("UPDATE ActivityUserMappingModel SET is_enter = 1 WHERE activity_id = :activityID AND user_id =:userId ")
									.setParameter("activityID",activityDetails.getActivity_id())
									.setParameter("userId",activityDetails.getUser_id()).executeUpdate();
							list.add(MessageConstant.MSG_SUCCESSFUL_ENTRY_CODE);
							list.add(MessageConstant.MSG_SUCCESSFUL_ENTRY);
						}
					} else {
						list.add(MessageConstant.MSG_ACTIVITY_NOT_IN_EVENT_CODE);
						list.add(MessageConstant.MSG_ACTIVITY_NOT_IN_EVENT);
					}
				} else {
					list.add(MessageConstant.MSG_SUCCESSFUL_ENTRY_CODE);
					list.add(MessageConstant.MSG_SUCCESSFUL_ENTRY);
				}
			} else {
				list.add(MessageConstant.MSG_ACTIVITY_NOT_IN_EVENT_CODE);
				list.add(MessageConstant.MSG_ACTIVITY_NOT_IN_EVENT);
			}

		} catch (Exception e) {
			logger.error(" ### EXCEPTION IN UserDaoImpl ###" + e);
		}
		return list;
	}
	
	/* Priyanka 22-12-2017 @End */

	public int deleteEventDetailById(String eventId) {
		 
		try{
			 System.out.println("deleteEventDetailById->>" + " "+eventId+"  ");
			 
		   Session session = sessionFactory.getCurrentSession();
		   /*Sriparna issue log 27-12-2017*/
		   Query query = session.createQuery("update EventModel set is_deleted=1 where id="+Long.parseLong(eventId));
		   
		        int y= query.executeUpdate();
		   	    session.flush();		  
		 return y;		
		}
		catch(Exception ex){
			
			ex.printStackTrace();
			return 0;
		}	 
	}

	// ======================abdus added this code
	// @20-12-2017===========================

	public void saveParticipantsList(List<UserProfileModel> listUserProfileModel) {
		try {
			// sessionFactory.getCurrentSession();
			Session session = this.sessionFactory.getCurrentSession();
			if (listUserProfileModel != null && listUserProfileModel.size() > 0) {
				session.save(listUserProfileModel);
			}

			//session.close();

		} catch (Exception e) {

			logger.error(" ### EXCEPTION IN UserDaoImpl ###" + e);

		}

	}

	// ===============abdus added this code @20-12-2017==================

	/**** JOYDIP ADD/EDIT PARTICIPANT START *******************************/

	public List<UserProfileModel> fetchAllUserDetails(String eventId) {
		try {

			
			Session session = sessionFactory.getCurrentSession();

			Query query = session.createQuery("   from UserProfileModel u "
					+ "  where   u.role_id='2'  and  u.is_deleted='0' and event_id='" + eventId + "'");

			java.util.List<UserProfileModel> list = query.list();
			
			return list;
		} catch (Exception e) {
			
			e.printStackTrace(System.err);
			logger.error(" ### EXCEPTION IN UserDaoImpl :: fetchAllUserDetails ###"
					+ e);

		}
		return null;
	}

	public List<UserProfileModel> fetchUserDetailById(String userId) {
		try {

			// creating session object
			Session session = sessionFactory.getCurrentSession();

			
			Query query = session
					.createQuery("from UserProfileModel where id= " + userId);
			java.util.List<UserProfileModel> list = query.list();
			
			return list;
		} catch (Exception e) {
			

			e.printStackTrace(System.err);
			logger.error(" ### EXCEPTION IN UserDaoImpl :: fetchUserDetailById ###"
					+ e);

		}
		return null;
	}

	/*Sriparna issue=category 29-12-2017*/
	public int updateEditedUser(long eventId,String name_of_user, String user_id_hidden,
			String user_email, String user_email_hidden,String user_phone, String user_address,
			String user_company, String user_designation,String user_category) {
		List<UserProfileModel> userProfileModelList=new ArrayList<UserProfileModel>();
		Session session = sessionFactory.getCurrentSession();
		try {
		userProfileModelList= session
				.createCriteria(UserProfileModel.class)
				.add(Restrictions.and(Restrictions.eq("email_id", user_email),
						Restrictions.eq("event_id", eventId),Restrictions.ne("id", Long.parseLong(user_id_hidden)),Restrictions.eq("is_deleted", 0))).list();
		 if(userProfileModelList.size()>0){
			return 5;
		
		}
		/*else if(userProfileModelList.size()==0){
			return 5;
		
		}*/else{
			 session = sessionFactory.getCurrentSession();

			Query query = session.createQuery("update UserProfileModel set "
					+ "  name='" + name_of_user + "'," + "email_id='"
					+ user_email + "'," + "phone_number='" + user_phone + "',"
					+ "address='" + user_address + "'," + "company='"
					+ user_company + "', " + "designation='" + user_designation
				    + "', " + "category='" + user_category
					+ "' "

					+ "where id='" + user_id_hidden + "'");

			int row = query.executeUpdate();

			session.flush();
			return row;
		}

		} catch (Exception ex) {

			ex.printStackTrace();
			return 0;
		}

	}
	/*Sriparna issue=category 29-12-2017*/

	public int createUserDetail(String user_name, String name_of_user,
			String user_pass, String user_id_hidden, String user_email,
			String user_phone, String user_address, String user_company,
			String user_designation, String user_event_id,String user_category) {
		List<UserProfileModel> userProfileModelList=new ArrayList<UserProfileModel>();
		try {
			
			//check if user already exist for particular event
			Session session = sessionFactory.getCurrentSession();
			userProfileModelList= session
					.createCriteria(UserProfileModel.class)
					.add(Restrictions.and(Restrictions.eq("email_id", user_email),
							Restrictions.eq("event_id", Long.parseLong(user_event_id)),Restrictions.eq("is_deleted", 0))).list();
			 if(userProfileModelList.size()>0){
				return 5;
			
			}
			/*else if(userProfileModelList.size()==0){
				return 5;
			
			}*/else{

			
			
			String uniqueUsername = createUniqueUsernameInTable(name_of_user);

			if (uniqueUsername == "") {
				return 4;

			}

			EncryptDecrypt encryptDecrypt=new EncryptDecrypt();
			String encrypted_Password=encryptDecrypt.encrypt(user_pass);
			
			
			System.out.println("uniqueUsername->>" + uniqueUsername);
			UserProfileModel eM = new UserProfileModel();
			//eM.setId(Long.decode(user_id_hidden));
			eM.setUsername(uniqueUsername);
			eM.setPassword(encrypted_Password);
			eM.setName(name_of_user);
			eM.setEmail_id(user_email);
			eM.setPhone_number(Long.parseLong("" + user_phone));
			eM.setAddress(user_address);
			eM.setCompany(user_company);
			eM.setDesignation(user_designation);
			eM.setEvent_id(Long.parseLong("" + user_event_id));
			eM.setRole_id(Long.parseLong("2"));
			eM.setCategory(user_category);
			
			Long x = (Long) sessionFactory.getCurrentSession().save(eM);

			session = sessionFactory.getCurrentSession();
			session.load(UserProfileModel.class, x);

			String qrCode = QRCodeUtil.generateQRCode(x.toString(),
					user_event_id);
			if (qrCode == null || qrCode.isEmpty()) {

				Query q = session
						.createQuery("delete UserProfileModel where id = " + x);
				q.executeUpdate();
				System.out.println("createUserDetail->>" + " QR failed ");
				session.flush();
				return 3;

			}

			System.out.println("createUserDetail->>" + " qrCode: " + qrCode);

			eM.setQR_code_img_path(qrCode);

			session.update(eM);

			return 1;
		}

		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		}

	}

	public final boolean isUniqueInTable(String field_value, String field_name,
			String table_model_name) {

		try {
			

			return sessionFactory
					.getCurrentSession()
					.createQuery(
							"from " + table_model_name + " u where u."
									+ field_name + "=:" + field_value + "")
					.setParameter("field_value", field_value).uniqueResult() != null;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	public final String createUniqueUsernameInTable(String user_name) {

		try {

			Session session = sessionFactory.getCurrentSession();
			String usernameLeftPart = CommonUtility.keepAlphabetOnly(user_name)
					.trim();
			Query query = session
					.createQuery("select u.username from UserProfileModel u where u.username like ?");

			query.setString(0, "%" + usernameLeftPart + "%");

			java.util.List<String> list = query.list();
			for (int i = 0; i < list.size(); i++) {
				String[] arrBrokenBy_ = list.get(i).toString().split("_");
				int hasUnderscore = arrBrokenBy_.length;
				list.set(
						i,
						(hasUnderscore > 1 && (CommonUtility
								.isStringInt(arrBrokenBy_[hasUnderscore - 1]))) ? arrBrokenBy_[hasUnderscore - 1]
								: "0");
			}

			java.util.List<Integer> intList = CommonUtility
					.strListToIntList(list);

			int suffix = CommonUtility.getRandomWithExclusion(new Random(),
					100, 999, CommonUtility.intListToIntArray(intList));
			if (suffix == -1) {
				suffix = CommonUtility.getRandomWithExclusion(new Random(),
						1000, 9999, CommonUtility.intListToIntArray(intList));
			}

			return (usernameLeftPart + "_" + suffix).toUpperCase();

		} catch (Exception ex) {
			// t.rollback();
			ex.printStackTrace();
			return "";
		}

	}
	/**** JOYDIP ADD/EDIT PARTICIPANT END *******************************/
	
	/**** TAJINDER  ADD/EDIT USER ACTIVITY MAPPING START ***********************/
	public List<UserProfileModel> getParticipantListByEventId(Long eventId)
			throws Exception {
		List<UserProfileModel> participantList = new ArrayList<UserProfileModel>();
		try{
			Session session = sessionFactory.getCurrentSession();
			participantList = session.createCriteria(UserProfileModel.class)
					.add(Restrictions.eq("event_id",eventId))
					.add(Restrictions.ne("role_id",CommonConstant.ADMIN_ROLE))//Tajinder 08-01-2017
					.list();
		
		}catch(Exception e){
			logger.error(" ### EXCEPTION IN UserDaoImpl ###" + e);
		}
		return participantList;
	}

	public List<ActivityModel> getActivityListByEventId(Long eventId) throws Exception {
		List<ActivityModel> activityList = new ArrayList<ActivityModel>();
		try{
			Session session = sessionFactory.getCurrentSession();
			activityList = session.createCriteria(ActivityModel.class).add(Restrictions.eq("event_id",eventId)).list();
		
		}catch(Exception e){
			logger.error(" ### EXCEPTION IN UserDaoImpl ###" + e);
		}
		return activityList;
	}

	

	public String registerParticipantWithActivity(Long eventId,Long activityId, List<Long> participant_Id) throws Exception {
		String result=ErrorConstant.MSG_ERROR_PARTICIPANT_REGISTER;
		int count=0;
		try {
			Session session = sessionFactory.getCurrentSession();
			String participant_IdString=null;
			
			for(int i=0;i<participant_Id.size();i++){
				
				 if((sessionFactory.getCurrentSession()
		                .createQuery("from ActivityUserMappingModel m where m.user_id=:user_id and m.event_id=:event_id and m.activity_id=:activity_id") 
		                .setParameter("event_id", eventId)
		                .setParameter("user_id", participant_Id.get(i))
		                .setParameter("activity_id", activityId)
		                .uniqueResult() != null)==false){
				
				
				ActivityUserMappingModel m =new ActivityUserMappingModel();
				m.setActivity_id(activityId);
				m.setEvent_id(eventId);
				m.setUser_id(participant_Id.get(i));
				session.save(m);
				count++;
				 }else{
					 if(participant_Id.size()==1){
						return result=ErrorConstant.MSG_USER_PARTICIPANTS_ALREADY_EXIST; 
					 }
				 }
				
			}
			logger.error(" ###Count ###" + count);
			return result=MessageConstant.MSG_SUCCESS_PARTICIPANT_REGISTER;
			
		} catch (Exception e) {
			logger.error(" ### EXCEPTION IN UserDaoImpl ###" + e);
			
			if(participant_Id.size()==1){
				return result=ErrorConstant.MSG_ERROR_PARTICIPANT_REGISTER; 
			 }
		}
		
		return result;
	}
	/**** TAJINDER  ADD/EDIT USER ACTIVITY MAPPING END ***********************/
	
	/**** SRIPARNA  ADD/EDIT ACTIVITY  START ***********************/
public List<ActivityModel> fetchActivitiesByEventId(String eventId) {
		
		try{
			 System.out.println("fetchActivitiesByEventId daoImpl->>" + " "+eventId+"  ");
			 
			 // creating session object
		   /*  Session session = sessionFactory.openSession();*/
		  //   Session session = sessionFactory.getCurrentSession();
		     Session session = sessionFactory.getCurrentSession();
		     Query query = session.createQuery("from ActivityModel where event_id="+Long.parseLong(eventId)+ " and is_deleted="+0);
		     java.util.List<ActivityModel> list = query.list();
		 	 		   
		   	 session.flush();
		  // 	 session.close();
		 return list;		
		}
		catch(Exception ex){
			
			ex.printStackTrace();
			return null;
		}	 
	}
	public List<ActivityModel> fetchActivityDetailById(String activityId) {
			
			try {

				  Session session = sessionFactory.getCurrentSession();

		      

		        Query query = session.createQuery("from ActivityModel where id= "+Long.parseLong(activityId));
		        java.util.List<ActivityModel> list = query.list();
		       
		      
		        session.flush();
		       // session.close();
	            return list;
			} catch (Exception ex) {
				ex.printStackTrace();
				return null;
		        }            
		        		       
		}
	public int createActivity(String activity_id_hidden, String event_Id_hidden,
			String activity_name, String venue, String is_prtcpt_auth_req,
			String is_one_time_pass, String is_reset_on_exit) {
		try{
			 System.out.println("createActivity->>" + " "+activity_name+"  "+venue+"  ");
					  			 
			  Session session = sessionFactory.getCurrentSession();

			  ActivityModel aM = new ActivityModel();
			  
			  aM.setId(Long.decode(activity_id_hidden));
			  aM.setEvent_id(Long.decode(event_Id_hidden));
			  aM.setActivity_name(activity_name);
			  aM.setVenue(venue);
			  aM.setIs_prtcpt_auth_req(Integer.parseInt(is_prtcpt_auth_req));
			  aM.setIs_one_time_pass(Integer.parseInt(is_one_time_pass));
			  aM.setIs_reset_on_exit(Integer.parseInt(is_reset_on_exit));
			  				 
			  sessionFactory.getCurrentSession().save(aM);		      
			  session.flush();
			 // session.close();
		 	  return 1;		  
	 	}
		catch(Exception ex){			
			ex.printStackTrace();
			  return 0;
		}
	}
	
	public int updateActivityDetailById(String activity_id_hidden, String event_Id_hidden,
			String activity_name, String venue, String is_prtcpt_auth_req,
			String is_one_time_pass, String is_reset_on_exit) {
		 
			try{
				 System.out.println("updateActivityDetailById->>" + " "+activity_name+"  "+venue);
							 
				  Session session = sessionFactory.getCurrentSession();

			   	  Query query = session.createQuery("update ActivityModel set event_id='"+Long.decode(event_Id_hidden)+"',  activity_name='"+activity_name+"',"
			   	  		+ "  venue='"+venue+"',is_prtcpt_auth_req='"+Integer.parseInt(is_prtcpt_auth_req)+"',is_one_time_pass='"+Integer.parseInt(is_one_time_pass)+"',"
			   	  				+ "is_reset_on_exit='"+Integer.parseInt(is_reset_on_exit)+"' where id='"+Long.decode(activity_id_hidden)+"'");
			   
				  query.executeUpdate();
			   	  session.flush();
			   	// session.close();
			 	  return 1;			  
		 	}
			catch(Exception ex){			
				ex.printStackTrace();
				  return 0;
			}	
	}

	public int deleteActivityDetailById(String activityId) {
		try{
			 System.out.println("deleteActivityDetailById->>" + " "+activityId+"  ");
			 
		   Session session = sessionFactory.getCurrentSession();

		   Query query = session.createQuery("update ActivityModel set is_deleted=1 where id="+Long.parseLong(activityId));
		        int y= query.executeUpdate();
	
		   session.flush();	
		  // session.close();
		 return y;		
		}
		catch(Exception ex){
			
			ex.printStackTrace();
			return 0;
		}	 
	}
	/**** SRIPARNA  ADD/EDIT ACTIVITY  END ***********************/
	
	/************ 03-01-2018****/

	/*Joydip da 02-01-2018*/
	public List<MenuModel> fetchMenuDetailsByEventId(String menuId) {
		try {

			
		 	
	        Session session = sessionFactory.getCurrentSession();

	        
	        Query query = session.createQuery("from MenuModel where event_id= "+menuId+" and is_deleted=0 ");
	        List<MenuModel> list = query.list();
	      
	       
return list;
		} catch (Exception e) {
			
	        e.printStackTrace(System.err);
			logger.error(" ### EXCEPTION IN UserDaoImpl :: fetchMenuDetailsByEventId ###" + e);

		}
		return null;
	}
	public List<MenuFieldsNameModel> fetchMenuDetailsById(String menuId) {
	
		try {

			
			
		
	        Session session = sessionFactory.getCurrentSession();

	        

	        Query query = session.createQuery("from MenuFieldsNameModel where menu_id= "+menuId+" and is_deleted=0 ");
	        java.util.List<MenuFieldsNameModel> list = query.list();
	        
return list;
		} catch (Exception e) {
			
	        e.printStackTrace(System.err);
			logger.error(" ### EXCEPTION IN UserDaoImpl :: getAllEvents ###" + e);

		}
		return null;
	}
	public List<MenuModel> fetchMenuNameDetailById(String menuId) {
	
		try {

			
			
		
	        Session session = sessionFactory.getCurrentSession();

	        // creating transaction object
	       

	        Query query = session.createQuery("from MenuModel where id= "+menuId);
	        java.util.List<MenuModel> list = query.list();
	        System.out.println(list);
	       
return list;
		} catch (Exception e) {
			
	        e.printStackTrace(System.err);
			logger.error(" ### EXCEPTION IN UserDaoImpl :: fetchMenuFieldNameDetailById ###" + e);

		}
		return null;
	}
	public int createMenuByEventId(String menu_field_name_id_hidden,
			String menu_field_id,String is_restriction_acccess) {
		
		try {
			

			/*Session session = sessionFactory.openSession();
			session.beginTransaction();*/
 	MenuModel eM = new MenuModel();
			eM.setMenu_name(menu_field_name_id_hidden);
			eM.setEvent_id(Long.decode(menu_field_id));
			eM.setIs_restricted_access(Integer.parseInt(is_restriction_acccess));
			eM.setIs_deleted(0); 
			 
		 	Long x = (Long) sessionFactory.getCurrentSession().save(eM);
 	/*session.getTransaction().commit();
			session.flush();
			session.close();*/
		 	return 1;

		} catch (Exception ex) {
		 
			ex.printStackTrace();
			return 0;
		}
	}
	
	public int createMenuFieldNameByMenuId(String menu_field_name_id_hidden,
			String menu_field_name,String  menu_field_id) {
		
		try {
			
			MenuFieldsNameModel eM = new MenuFieldsNameModel();
			eM.setId(Long.decode(menu_field_name_id_hidden));
			eM.setMenu_id(Long.decode(menu_field_id));
			eM.setMenu_field_name(menu_field_name);
			eM.setIs_deleted(0);

			Long x = (Long) sessionFactory.getCurrentSession().save(eM);
			
			//setMenuFieldvalueBlankForNewMenuFieldName(x,menu_field_id);
			
			return 1;

		} catch (Exception ex) {
		 
			ex.printStackTrace();
			return 0;
		}
	}
	
	public int setMenuFieldvalueBlankForNewMenuFieldName(long menu_filed_name_id
			,String  menu_field_id){
		
		try {
			Session session = sessionFactory.getCurrentSession();
			List<MenuNameValueSet> menuNameValueSetList = session.createCriteria(MenuNameValueSet.class)
					.add(Restrictions.eq("menu_id", menu_field_id)).list();

			for (MenuNameValueSet m : menuNameValueSetList) {
				saveMenuFieldValue( Long.parseLong(menu_field_id), menu_filed_name_id,
						"",m.getId()) ;
			}
		} catch (Exception e) {
			logger.error(" ### EXCEPTION IN UserDaoImpl ###" + e);
		}
		return 0;
		
		
	}
	public int updateMenuFieldNameByMenuId(String menu_field_name_id_hidden,
			String menu_field_name, String menu_field_id) {
		
		try {
			System.out.println("updateMenuFieldNameByMenuId->>" + " " + menu_field_name_id_hidden + "  "
					+ menu_field_name + "  "  + "  " + "  ");

			Session session = sessionFactory.getCurrentSession();

			Query query = session.createQuery("update MenuFieldsNameModel set "
					+ "  menu_id='" + menu_field_id + "'," + "menu_field_name='"
					+ menu_field_name + "' "  

					+ "where id='" + menu_field_name_id_hidden + "'");

			int row = query.executeUpdate();

			
			return row;

		} catch (Exception ex) {
		 
			ex.printStackTrace();
			return 0;
		}
	}
	public List<MenuFieldsNameModel> fetchMenuFieldNameDetailById(String menuId) {
		
		try {

			
			
		
	        Session session =sessionFactory.getCurrentSession();

	        

	        Query query = session.createQuery("from MenuFieldsNameModel where id= "+menuId);
	        java.util.List<MenuFieldsNameModel> list = query.list();
	        System.out.println(list);
	      
return list;
		} catch (Exception e) {
			
	        e.printStackTrace(System.err);
			logger.error(" ### EXCEPTION IN UserDaoImpl :: fetchMenuFieldNameDetailById ###" + e);

		}
		return null;
	}
	public List<MenuModel> fetchAllMenusById(String menuId) {
		
		try {

			
		
	        Session session =sessionFactory.getCurrentSession();

	        

	        Query query = session.createQuery("from MenuModel where event_id= "+menuId+" and is_deleted=0 ");
	        List<MenuModel> list = query.list();
	       
	       
return list;
		} catch (Exception e) {
			
	        e.printStackTrace(System.err);
			logger.error(" ### EXCEPTION IN UserDaoImpl :: fetchAllMenusById ###" + e);

		}
		return null;
	}

	public int updateMenuNameByMenuId(String menu_field_name_id_hidden,
			String menu_field_name, String menu_field_id,String is_restriction_acccess) {
		
		try {
			System.out.println("updateMenuNameByMenuId->>" + " " + menu_field_name_id_hidden + "  "
					+ menu_field_name + "  "  + "  " + "  ");

			Session session = sessionFactory.getCurrentSession();

			Query query = session.createQuery("update MenuModel set "
					 + " " + "menu_name='"
					+ menu_field_name + "' "  
                    + " ,is_restricted_access= '"+is_restriction_acccess + "' "   //Tajinder Changes
					+ "where id='" + menu_field_name_id_hidden + "'");

			int row = query.executeUpdate();

			
			return row;

		} catch (Exception ex) {
		 
			ex.printStackTrace();
			return 0;
		}
	}
	
	public int deleteMenuNameById(String id) {
		 
		
		try {
			System.out.println("deleteMenuNameById->>" + " " + id + "  "
					 );

			Session session = sessionFactory.getCurrentSession();

			Query query = session.createQuery("update MenuModel set "+ " " + "is_deleted=1 "+ "where id='" + id + "'");

			int row = query.executeUpdate();
			System.out.println("deleteMenuNameById->>" + " " + row + "  "
					 );
		/*	session.flush();*/
			return row;

		} catch (Exception ex) {
		 
			ex.printStackTrace();
			return 0;
		}
}
	public int deleteMenuFieldNameById(String id) {
		 
		
		try {
			System.out.println("deleteMenuFieldNameById->>" + " " + id + "  "
					 );

			Session session = sessionFactory.getCurrentSession();

			Query query = session.createQuery("update MenuFieldsNameModel set "+ " " + "is_deleted=1 "+ "where id='" + id + "'");

			int row = query.executeUpdate();
			System.out.println("deleteMenuFieldNameById->>" + " " + row + "  "
					 );
			/*session.flush();*/
			return row;

		} catch (Exception ex) {
		 
			ex.printStackTrace();
			return 0;
		}
}
	
	
	
	
	
	
	
	//======abdus added this code @28-12-2017=========start=======
	
	public List<ScheduleModel> getScheduleList(String eventId) {
		
		try {

			
	        Session session =sessionFactory.getCurrentSession();

	       
	        Query query = session.createQuery("from ScheduleModel where event_id="+Long.parseLong(eventId)+ " and is_deleted="+0);
	        @SuppressWarnings("unchecked")
			java.util.List<ScheduleModel> list = query.list();
	       
		 return list;		
		}
		catch(Exception ex){
			logger.error(" ### EXCEPTION IN UserDaoImpl ###   //getScheduleList" + ex);
			ex.printStackTrace();
			return null;
		}	 
	}
	
	//======abdus added this code @28-12-2017===========end=====
	

	//=============abdus added this code @21-12-2017=========start===========
	
	@SuppressWarnings({ "unchecked", "null" })
	public List <EventModel> getEventNameList() throws Exception {
		List  listResult = new ArrayList();
		 logger.debug("================call dao method in dao getEventNameList()=========");
		List <EventModel> listeventname=new ArrayList<EventModel>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			//Session session = HibernateUtil.beginTransaction();
			SQLQuery query = session.createSQLQuery("select e.id,e.event_name from event e where e.is_deleted='0'  ");
            listResult = query.list();
            
            if(listResult.size()>0)
            {
            	List<Object[]> rows = listResult;
            	
            	for (Object[] row : rows) {
            		            EventModel eventModel=new EventModel();
	                    		BigInteger id = (BigInteger) row[0];
	                    		eventModel.setId(id.longValue());
	                    		eventModel.setEvent_name(((String)row[1]));
	                    		System.out.println( "Found " + eventModel.getId() + " " + eventModel.getEvent_name() );
	                    		listeventname.add(eventModel);
            	          }
            }
            
            session.flush();
       } catch (Exception e) {

			logger.error(" ### EXCEPTION IN UserDaoImpl ###   //getEventNameList" + e);

		}
		
		return listeventname;
	}
	//=============abdus added this code @21-12-2017==========end===========
	
	//=============abdus added this code @21-12-2017============start=========
	public List<ScheduleModel> fetchScheduleModelDetailById(String scheduleId) {
		      logger.debug("================call dao method in dao fetchScheduleModelDetailById()=========");
	
		try {
			
			
			
		

	        // creating session object
	        Session session = sessionFactory.getCurrentSession();

	        /*// creating transaction object
	          t = session.beginTransaction();*/

	        Query query = session.createQuery("from ScheduleModel where id= "+scheduleId);
	        java.util.List<ScheduleModel> list = query.list();
	        /*System.out.println(list);
	        t.commit();
	        session.close();*/
            return list;
		} catch (Exception e) {
			         
	        
	        e.printStackTrace(System.err);
			logger.error(" ### EXCEPTION IN UserDaoImpl :: fetchScheduleModelDetailById ###" + e);

		}
		return null;
	}
	
//=============abdus added this code @21-12-2017=============end========
	//========abdus added this code @28-12-2017==========start==
		public int saveScheduleModelData(ScheduleModel scheduleModel, String participant_hidden_id) {
			
			 logger.debug("================call dao method in dao saveScheduleModelData()=========");
			try{ 
				 
				
				   sessionFactory.getCurrentSession().save(scheduleModel);
				  return 1;
			  
		 	}
			catch(Exception ex){
				
				ex.printStackTrace();
				  return 0;
			}
		}
		//========abdus added this code @28-12-2017==========end==
		
		
		//========abdus added this code @28-12-2017==========start==
		
		public int updateScheduleModelData(ScheduleModel scheduleModel, String participant_hidden_id) {
			
			 logger.debug("================call dao method in dao updateScheduleModelData()=========");
				try{
					
					 System.out.println("createScheduleDetail->>" + " "+participant_hidden_id+"  "+scheduleModel.getSchedule_endtime()+"  "+scheduleModel.getSchedule_name()+"  "+"  ");
					
					  Session session = sessionFactory.getCurrentSession();
					  
				   	  Query query = session.createQuery("update ScheduleModel set event_id='"+scheduleModel.getEvent_id()+"',  schedule_name='"+scheduleModel.getSchedule_name()+"',"
				   	  		+ "  schedule_date='"+scheduleModel.getSchedule_date()+"',schedule_starttime='"+scheduleModel.getSchedule_starttime()+"', "
				   	  	+ " description='"+scheduleModel.getDescription()+ "',schedule_endtime='"+scheduleModel.getSchedule_endtime()+ "'where id='"+participant_hidden_id+"'");
				   
					  query.executeUpdate();
						 
					      
					  session.flush();
				 	  return 1;
				  
			 	}
				catch(Exception ex){
					logger.error(" ### EXCEPTION IN UserDaoImpl ###" + ex);
					ex.printStackTrace();
					  return 0;
				}
				 
			
		}
		
		//=====abdus added this code @28-12-2017======end===
		
		 //abdus added this code for row delete============= start==============@29-12-2017	
		public int deleteScheduleModelRowById(String scheduleId) {
			logger.debug("================call dao method in dao  deleteScheduleModelRowById()=========");
			 
			try{
				 System.out.println("deleteScheduleModelRowById->>" + " "+scheduleId+"  ");
				 
			   Session session = sessionFactory.getCurrentSession();

			   Query query = session.createQuery("update ScheduleModel set is_deleted=1 where id="+Long.parseLong(scheduleId));
			        int y= query.executeUpdate();
			   	    session.flush();
			   /*	    session.close();*/
			 return y;		
			}
			catch(Exception ex){
				
				ex.printStackTrace();
				return 0;
			}	 
		}
		
		
		//abdus added this code for row delete============= start==============	@29-12-2017
		/**** MOUSUMI START add edit menu fields value 03-01-2018 ************************/	
		public List<Object> fetchMenuValueListByMenuId(long menuId) {
			
			List<MenuDetails> menuDetailsList = new ArrayList<MenuDetails>();
			Map<String, List<MenuDetails>> menuDetails1 = new HashMap<String, List<MenuDetails>>();
			List<Object> mdlist = new ArrayList<Object>();
			try {
				Session session = sessionFactory.getCurrentSession();
				String hql = " select n.menu_field_name,v.menu_fields_value,v.menu_name_value_set_id "
						+ " from MenuFieldsNameModel n , MenuFieldsValueModel v "
						+ " where n.id = v.menu_fields_name_id and n.menu_id = :menuId and  v.is_deleted=0  "
						+ " order by v.menu_name_value_set_id ASC ";

				List<Object> result = (List<Object>) session.createQuery(hql)
						.setParameter("menuId", menuId).list();
				long count = 0;
				Iterator itr = result.iterator();
				List<MenuDetails> ml = new ArrayList<MenuDetails>();

				while (itr.hasNext()) {
					Object[] obj = (Object[]) itr.next();
					System.out.println(obj[2]);

					if (count == (Long) obj[2]) {
						MenuDetails m = new MenuDetails();
						m.setMenu_field((String) obj[0]);
						m.setMenu_value((String) obj[1]);
						m.setMenu_name_value_set_id((Long) obj[2]);
						ml.add(m);
					} else {
						count = (Long) obj[2];
						ml = new ArrayList<MenuDetails>();
						MenuDetails m = new MenuDetails();
						m.setMenu_field((String) obj[0]);
						m.setMenu_value((String) obj[1]);
						m.setMenu_name_value_set_id((Long) obj[2]);
						ml.add(m);
					}
					menuDetails1.put("set" + obj[2], ml);
				}

				Iterator<Entry<String, List<MenuDetails>>> mapItr = menuDetails1
						.entrySet().iterator();
				while (mapItr.hasNext()) {
					Map.Entry<String, List<MenuDetails>> entry = mapItr.next();
					mdlist.add(entry.getValue());
				}

			} catch (Exception e) {
				logger.error(" ### EXCEPTION IN UserDaoImpl ###" + e);
			}
			return mdlist;
		}
		public int updateMenuFieldValueByMenuId(
				String menu_fields_value, long menu_field_value_id) {
			
			try {
				

				Session session = sessionFactory.getCurrentSession();

				Query query = session.createQuery("update MenuFieldsValueModel set "
						+ "menu_fields_value='"
						+ menu_fields_value + "' "  
						+ "where id='" + menu_field_value_id + "'");

				int row = query.executeUpdate();

				
				return row;

			} catch (Exception ex) {
			 
				ex.printStackTrace();
				return 0;
			}
		}
		
		public Long getMenuFiledValueSetId(long menu_id) {
			
			try {
				
				MenuNameValueSet menuNameValueSet=new MenuNameValueSet();
				menuNameValueSet.setMenu_id(menu_id);
				Long id =(Long)sessionFactory.getCurrentSession().save(menuNameValueSet);
				sessionFactory.getCurrentSession().flush();
				return id;

			} catch (Exception ex) {
			 
				ex.printStackTrace();
				return 0L;
			}
		}
		
		public int saveMenuFieldValue(long menu_id,long menu_field_name_id,
				String menu_fields_value,long menu_fields_value_set_id) {
			
			try {
				/*MenuNameValueSet menuNameValueSet=new MenuNameValueSet();
				menuNameValueSet.setMenu_id(Long.parseLong(menu_id));
				Long id =(Long)sessionFactory.getCurrentSession().save(menuNameValueSet);
				sessionFactory.getCurrentSession().flush();*/
			
				
				MenuFieldsValueModel menuFieldsValueModel=new MenuFieldsValueModel();
				menuFieldsValueModel.setMenu_id(menu_id);
				menuFieldsValueModel.setMenu_fields_name_id(menu_field_name_id);
				menuFieldsValueModel.setMenu_name_value_set_id(menu_fields_value_set_id);
				menuFieldsValueModel.setMenu_fields_value(menu_fields_value);
				menuFieldsValueModel.setCreated_on(new java.util.Date());
				sessionFactory.getCurrentSession().save(menuFieldsValueModel);

				
				
				return 1;

			} catch (Exception ex) {
			 
				ex.printStackTrace();
				return 0;
			}
		}
		public List<MenuFieldsValueModel> fetchMenuValueDetailsBySetId(long setId){
			try {

				
				
				
		        Session session = sessionFactory.getCurrentSession();

		        // creating transaction object
		       

		        Query query = session.createQuery("from MenuFieldsValueModel where menu_name_value_set_id= "+setId);
		        List<MenuFieldsValueModel> list = query.list();
		        System.out.println(list);
		       
	return list;
			} catch (Exception e) {
				
		        e.printStackTrace(System.err);
				logger.error(" ### EXCEPTION IN UserDaoImpl :: fetchMenuFieldNameDetailById ###" + e);

			}
			return null;
		}
		public int deleteEventMenuValueBySetId(long setId) {
			 
			try{
				 System.out.println("deleteEventMenuValueBySetId->>" + " "+setId+"  ");
				 
			   Session session = sessionFactory.getCurrentSession();
			   /*Sriparna issue log 27-12-2017*/
			   Query query = session.createQuery("update MenuFieldsValueModel set is_deleted=1 where menu_name_value_set_id="+setId);
			   
			        int y= query.executeUpdate();
			   	    session.flush();		  
			 return y;		
			}
			catch(Exception ex){
				
				ex.printStackTrace();
				return 0;
			}	 
		}
		
	
		public int deleteEventMenuValueByForMenuId(long menuId) {
			 
			try{
				 System.out.println("deleteEventMenuValueByForMenuId->>" + " "+menuId+"  ");
				 
			   Session session = sessionFactory.getCurrentSession();
			   /*Sriparna issue log 27-12-2017*/
			   Query query = session.createQuery("update MenuFieldsValueModel set is_deleted=1 where menu_id="+menuId);
			   
			        int y= query.executeUpdate();
			   	    session.flush();		  
			 return y;		
			}
			catch(Exception ex){
				
				ex.printStackTrace();
				return 0;
			}	 
		}
		/**** MOUSUMI END add edit menu fields value 03-01-2018 ************************/
		
		/*Priyanka 27-12-2017 @Start*/
		
		public int updateEventAboutDetailById(EventModel event) throws Exception {
			try{
				Session session = sessionFactory.getCurrentSession();
				
				EventModel updateEvent = (EventModel)session.get(EventModel.class, event.getId()); 
				updateEvent.setAbout_us(event.getAbout_us());
				updateEvent.setContact_person(event.getContact_person());
				updateEvent.setContact_no(event.getContact_no());
				updateEvent.setContact_email(event.getContact_email());//Priyanka 08.01.2018
				updateEvent.setFacebook_link(event.getFacebook_link());
				updateEvent.setTwitter_link(event.getTwitter_link());
				updateEvent.setLinkedin_link(event.getLinkedin_link());
				updateEvent.setGoogle_plus_link(event.getGoogle_plus_link());
				updateEvent.setTumblr_link(event.getTumblr_link());
				updateEvent.setBlogger_link(event.getBlogger_link());
				updateEvent.setMsg_sender_name(event.getMsg_sender_name());
				updateEvent.setMsg_body(event.getMsg_body());
				updateEvent.setLive_url(event.getLive_url());
				
			    session.update(updateEvent); 
				return 1;
			}catch(Exception e){
				logger.error(" ### EXCEPTION IN UserDaoImpl ### updateEventAboutDetailById()" + e);
			}
			return 0;
		}
		/*Priyanka 27-12-2017 @Start*/
		
		/**** TAJINDER 04-01-2018  START ***********************/
		public int deleteUserById(String userId) throws Exception {
			try{
				 System.out.println("deleteEventDetailById->>" + " "+userId+"  ");
				 Session session = sessionFactory.getCurrentSession();
			   
				 	Query query = session.createQuery("update UserProfileModel set is_deleted = 1 where id="+Long.parseLong(userId));
			   
			        int y= query.executeUpdate();
			   	    session.flush();		  
			 return y;		
			}
			catch(Exception ex){
				
				ex.printStackTrace();
				return 0;
			}	 
		}
		/**** TAJINDER 04-01-2018  END ***********************/
		public int deleteBannerImageByEventId(long eventId) throws Exception {
			int y=0;
			try{
				 Session session = sessionFactory.getCurrentSession();
		Query q = session
				.createQuery("delete EventBannerImageModel where event_id = " + eventId);
		q.executeUpdate();
		System.out.println("createUserDetail->>" + " QR failed ");
		session.flush();
		return y;		
			}
			catch(Exception ex){
				
				ex.printStackTrace();
				return 0;
			}	 
		}
		
		public int checkIsUserValidForPrint( long userId){
			int count =0;
			try{
			 Session session = sessionFactory.getCurrentSession();
			 // String hql = "  SELECT  * FROM ActivityUserMappingModel WHERE user_id= "+userId+" is_deleted ='0' ";
			  Query query = session.createQuery("from ActivityUserMappingModel where   user_id= "+userId+"   and is_enter='1' ");
		        
				java.util.List<ActivityUserMappingModel> result = query.list();
				/*List<Object> result = (List<Object>) session.createQuery(hql).list();
			   */	    session.flush();
			   	    if(result!=null){
			   	     if(result.size()>0){
			   	    	count=1;
			   	     }
			   	    }
			 return count;		
			}
			catch(Exception ex){
				
				ex.printStackTrace();
				return count;
			}	 
		}
		
		/*Priyanka 04.01.2018 @Start*/
		public EventModel getEventDetailById(long eventId) throws Exception {
			EventModel event = new EventModel();
			try{
				Session session = sessionFactory.getCurrentSession();
				event = (EventModel) session.get(EventModel.class, eventId);
			}catch(Exception e){
				logger.error(" ### EXCEPTION IN UserServiceImpl ###"+e); 
			}
			return event;
		}
		/*Priyanka 04.01.2018 @Start*/
		
		public List<UserProfileModel> fetchParticipantDetailsByEventAndActivityId(String eventId,
				String activityId) throws Exception {
			List<UserProfileModel> finalList=new ArrayList<UserProfileModel> ();
			try {
					Session session =sessionFactory.getCurrentSession();
					String hqlQuery="SELECT u.id,u.username,u.email_id,ma.id AS mapping_id,u.event_id FROM user_profile   u " +
									" LEFT OUTER JOIN activity_user_mapping ma ON u.event_id = ma.event_id AND u.id = ma.user_id " +
									" WHERE ma.event_id= :event_id AND ma.activity_id= :activity_id  AND NOT u.role_id=:role_id";
					Query query = session.createSQLQuery(hqlQuery);
					query.setParameter("event_id", eventId);
					query.setParameter("activity_id", activityId);
					query.setParameter("role_id", CommonConstant.ADMIN_ROLE);
					 List<Object[]> rows  = query.list();
		            
					 List<UserProfileModel> tempList=new ArrayList<UserProfileModel> ();
		    		
		    		for (Object[] row: rows) {
		    			UserProfileModel userProfile=new UserProfileModel();
		    			
		    			
		    			userProfile.setId(Long.parseLong(String.valueOf((BigInteger)row[0])));
		    			
		    			// USER NAME: COLUMN POSITION 1 
		    			userProfile.setUsername((String)row[1]);
		    			
		    			// USER EMAIL ID: COLUMN POSITION 2 
		    			userProfile.setEmail_id((String)row[2]);
		    			userProfile.setUser_mapping_id(Long.parseLong(String.valueOf((BigInteger)row[3])));
		    			userProfile.setEvent_id(Long.parseLong(String.valueOf((BigInteger)row[4])));
		    			
		    			tempList.add(userProfile);
		    		}
		    		
		    		finalList.addAll(tempList);
		    		
		            return finalList;
			} catch (Exception e) {
				
		        e.printStackTrace(System.err);
				logger.error(" ### EXCEPTION IN UserDaoImpl :: fetchParticipantDetailsByEventAndActivityId ###" + e);

			}
			return null;
		}

		public int deleteuserMappingById(String userMappingId) throws Exception {
			ActivityUserMappingModel userMapping;
			try{
				 System.out.println("deleteuserMappingById->>" + " "+userMappingId+"  ");
				 
			   Session session = sessionFactory.getCurrentSession();

			   Query query = session.createQuery("delete ActivityUserMappingModel where id="+userMappingId);
			   int y= query.executeUpdate();
			   session.flush();		  
			   return y;		
			}
			catch(Exception ex){
				ex.printStackTrace();
				return 0;
			}	
		}
}
