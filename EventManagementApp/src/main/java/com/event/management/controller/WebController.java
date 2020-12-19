package com.event.management.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.event.management.constant.CommonConstant;
import com.event.management.constant.ErrorConstant;
import com.event.management.constant.PageNameConstant;
import com.event.management.model.EventModel;
import com.event.management.model.UserProfileModel;
import com.event.management.service.UserService;

@Controller
public class WebController {

	
	private static final Logger logger = Logger.getLogger(WebController.class);

	
	@Autowired
	private UserService userService;

	
	@RequestMapping(value = "/")
	public ModelAndView home_main() {

		logger.debug("  ################### CLASS WEBCONTROLLER ### URL /home_main ### ENTER ### ");

		ModelAndView model = new ModelAndView();

		try {
			model.setViewName(PageNameConstant.LOGIN_PAGE);
			model.addObject("loginForm", new UserProfileModel());

		} catch (Exception e) {
			logger.error("  ################### CLASS WEBCONTROLLER ### URL /home_main ### ERRROR ### "
					+ e);
			model.setViewName(PageNameConstant.ERROR_EVENT_MANAGEMENT_COMMON_PAGE);
		}

		logger.debug("  ################### CLASS WEBCONTROLLER ### URL /home_main ### EXIT ### ");
		return model;
	}

	
	@RequestMapping(value = "/login")
	public ModelAndView login(HttpServletRequest req) {

		logger.debug("  ################### CLASS WEBCONTROLLER ### URL /login ### ENTER ### ");

		ModelAndView model = new ModelAndView();
		HttpSession session = req.getSession();
		try {
			/*
			 * model.setViewName(PageNameConstant.LOGIN_PAGE);
			 * model.addObject("loginForm", new UserProfileModel());
			 */
			if (session != null
					&& session
							.getAttribute(CommonConstant.SESSION_USER_DETAILS) != null) {
				model.setViewName(PageNameConstant.HOME_PAGE);
			} else {
				model.setViewName(PageNameConstant.LOGIN_PAGE);
				model.addObject("loginForm", new UserProfileModel());

			}

		} catch (Exception e) {
			logger.error("  ################### CLASS WEBCONTROLLER ### URL /login ### ERRROR ### "
					+ e);
			model.setViewName(PageNameConstant.ERROR_EVENT_MANAGEMENT_COMMON_PAGE);
		}

		logger.debug("  ################### CLASS WEBCONTROLLER ### URL /login ### EXIT ### ");
		return model;
	}

	
	@RequestMapping(value = "/loginProcess")
	public ModelAndView loginProcess(
			@ModelAttribute("login") UserProfileModel login,
			HttpServletRequest req) {
		logger.debug("  ################### CLASS WEBCONTROLLER ### URL /loginProcess ### ENTER ### ");
		HttpSession session = req.getSession();
		ModelAndView model = new ModelAndView();

		try {
			if (session != null
					&& session
							.getAttribute(CommonConstant.SESSION_USER_DETAILS) != null) {
				model.setViewName(PageNameConstant.HOME_PAGE);
			} else if (login.getUsername() == null
					|| login.getUsername().isEmpty()
					|| login.getPassword() == null
					|| login.getPassword().isEmpty()) {
				model.setViewName(PageNameConstant.LOGIN_PAGE);
				model.addObject("loginForm", new UserProfileModel());
				model.addObject("errorMsg",
						ErrorConstant.ENTER_ALL_DETAILS_ERROR);

			} else {
				UserProfileModel userDetail = userService.validateUserInfo(
						login.getUsername(), login.getPassword());
				if (userDetail != null) {
					session.setAttribute(CommonConstant.SESSION_USER_DETAILS,
							userDetail);
					model.setViewName(PageNameConstant.HOME_PAGE);
				} else {
					model.setViewName(PageNameConstant.LOGIN_PAGE);
					model.addObject("loginForm", new UserProfileModel());
					model.addObject("errorMsg",
							ErrorConstant.ERROR_INVALID_CREDENTIALS);
				}
			}

		} catch (Exception e) {
			logger.error("  ################### CLASS WEBCONTROLLER ### URL /loginProcess ### ERRROR ### "
					+ e);
			model.setViewName(PageNameConstant.ERROR_EVENT_MANAGEMENT_COMMON_PAGE);
		}

		logger.debug("  ################### CLASS WEBCONTROLLER ### URL /loginProcess ### EXIT ### ");
		return model;

	}

	
	@RequestMapping(value = "/addEditEvent")
	public ModelAndView addEditEvent(HttpServletRequest req) {

		logger.debug("  ################### CLASS WEBCONTROLLER ### URL /addEditEvent ### ENTER ### ");

		HttpSession session = req.getSession();
		ModelAndView model = new ModelAndView();

		try {
			if (session != null
					&& session
							.getAttribute(CommonConstant.SESSION_USER_DETAILS) != null) {
				model.setViewName(PageNameConstant.ADD_EDIT_EVENT_PAGE);
			} else {
				model.setViewName(PageNameConstant.LOGIN_PAGE);
				model.addObject("loginForm", new UserProfileModel());
			}

		} catch (Exception e) {
			logger.error("  ################### CLASS WEBCONTROLLER ### URL /addEditEvent ### ERRROR ### "
					+ e);
			model.setViewName(PageNameConstant.ERROR_EVENT_MANAGEMENT_COMMON_PAGE);
		}

		logger.debug("  ################### CLASS WEBCONTROLLER ### URL /addEditEvent ### EXIT ### ");
		return model;
	}

	
	@RequestMapping(value = "/logout")
	public String Logout(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		logger.info(" ### CLASS LOGINCONTROLLER ### METHOD  Logout ### ENTER ### ");
		try {
			UserProfileModel user = (UserProfileModel) session
					.getAttribute(CommonConstant.SESSION_USER_DETAILS);
			if (user != null) {
				session = request.getSession(false);
				if (session != null) {
					session.invalidate();
				}
			}
		} catch (Exception e) {
			logger.error(" ### CLASS LOGINCONTROLLER ### METHOD Logout ### ERROR ### "
					+ e);
		}
		logger.info(" ### CLASS LOGINCONTROLLER ### METHOD Logout ### EXIT ### ");
		return "redirect:/login";
	}

	
	@RequestMapping(value = "/splashImageUpload")
	public ModelAndView splashImageUpload(HttpServletResponse response,
			HttpSession session) {

		logger.debug("  ################### CLASS WEBCONTROLLER ### URL /splashImageUpload ### ENTER ### ");

		ModelAndView model = new ModelAndView();
		try {
			if (session != null
					&& session
							.getAttribute(CommonConstant.SESSION_USER_DETAILS) != null) {
				model.setViewName(PageNameConstant.SPLASH_UPLOAD_IMAGE_PAGE);
			} else {
				model.setViewName(PageNameConstant.LOGIN_PAGE);
				model.addObject("loginForm", new UserProfileModel());
			}

		} catch (Exception e) {
			logger.error("  ################### CLASS WEBCONTROLLER ### URL /splashImageUpload ### ERRROR ### "
					+ e);
			model.setViewName(PageNameConstant.ERROR_EVENT_MANAGEMENT_COMMON_PAGE);
		}

		logger.debug("  ################### CLASS WEBCONTROLLER ### URL /splashImageUpload ### EXIT ### ");
		return model;
	}

	
	@RequestMapping(value = "/bannerImageUpload")
	public ModelAndView bannerImageUpload(HttpServletResponse response,
			HttpSession session) {

		logger.debug("  ################### CLASS WEBCONTROLLER ### URL /bannerImageUpload ### ENTER ### ");

		ModelAndView model = new ModelAndView();
		try {
			if (session != null
					&& session
							.getAttribute(CommonConstant.SESSION_USER_DETAILS) != null) {
				model.setViewName(PageNameConstant.BANNER_UPLOAD_IMAGE_PAGE);
			} else {
				model.setViewName(PageNameConstant.LOGIN_PAGE);
				model.addObject("loginForm", new UserProfileModel());
			}

		} catch (Exception e) {
			logger.error("  ################### CLASS WEBCONTROLLER ### URL /bannerImageUpload ### ERRROR ### "
					+ e);
			model.setViewName(PageNameConstant.ERROR_EVENT_MANAGEMENT_COMMON_PAGE);
		}

		logger.debug("  ################### CLASS WEBCONTROLLER ### URL /bannerImageUpload ### EXIT ### ");
		return model;
	}

	
	
	/****** ABDUS UPLOAD PARTICIPANT LIST START ******/

	@RequestMapping(value = "/excelUploadForm")
	public ModelAndView uploafExcelForm(HttpServletRequest request,
			HttpServletResponse response) {

		logger.debug("  ################### CLASS WEBCONTROLLER ### URL /uploafExcelForm ### ENTER ### ");

		HttpSession session = request.getSession();
		ModelAndView model = new ModelAndView();

		try {
			if (session != null
					&& session
							.getAttribute(CommonConstant.SESSION_USER_DETAILS) != null) {
				model.setViewName(PageNameConstant.UPLOADFILE_PAGE);
			} else {
				model.setViewName(PageNameConstant.LOGIN_PAGE);
				model.addObject("loginForm", new UserProfileModel());
			}

		} catch (Exception e) {
			logger.error("  ################### CLASS WEBCONTROLLER ### URL /uploafExcelForm ### ERRROR ### "
					+ e);
			model.setViewName(PageNameConstant.ERROR_EVENT_MANAGEMENT_COMMON_PAGE);
		}

		logger.debug("  ################### CLASS WEBCONTROLLER ### URL /uploafExcelForm ### EXIT ### ");
		return model;
	}

	/****** ABDUS UPLOAD PARTICIPANT LIST START ******/

	
	/**** JOYDIP ADD/EDIT PARTICIPANT START *******************************/
	@RequestMapping(value = "/add-edit-user-profile")
	public ModelAndView add_edit_user_profile(HttpServletRequest request) {

		logger.debug("  ################### CLASS WEBCONTROLLER ### URL /login ### ENTER ### ");

		ModelAndView model = new ModelAndView();
		HttpSession session = request.getSession();

		try {
			if (session != null
					&& session
							.getAttribute(CommonConstant.SESSION_USER_DETAILS) != null) {
				model.setViewName(PageNameConstant.ADD_EDIT_USER_PROFILE_PAGE);
			} else {
				model.setViewName(PageNameConstant.LOGIN_PAGE);
				model.addObject("loginForm", new UserProfileModel());
			}

		} catch (Exception e) {
			logger.error("  ################### CLASS WEBCONTROLLER ### URL /login ### ERRROR ### "
					+ e);
			model.setViewName(PageNameConstant.ERROR_EVENT_MANAGEMENT_COMMON_PAGE);
		}

		logger.debug("  ################### CLASS WEBCONTROLLER ### URL /login ### EXIT ### ");
		return model;
	}

	
	/**** TAJINDER ADD/EDIT USER ACTIVITY MAPPING START ***********************/
	@RequestMapping(value = "/userActivityMapping")
	public ModelAndView userActivityMapping(HttpServletResponse response,
			HttpSession session) {

		logger.debug("  ################### CLASS WEBCONTROLLER ### URL /userActivityMapping ### ENTER ### ");

		ModelAndView model = new ModelAndView();
		try {
			if (session != null
					&& session
							.getAttribute(CommonConstant.SESSION_USER_DETAILS) != null) {
				model.setViewName(PageNameConstant.USER_ACTIVITY_MAPPING_PAGE);
			} else {
				model.setViewName(PageNameConstant.LOGIN_PAGE);
				model.addObject("loginForm", new UserProfileModel());
			}

		} catch (Exception e) {
			logger.error("  ################### CLASS WEBCONTROLLER ### URL /userActivityMapping ### ERRROR ### "
					+ e);
			model.setViewName(PageNameConstant.ERROR_EVENT_MANAGEMENT_COMMON_PAGE);
		}

		logger.debug("  ################### CLASS WEBCONTROLLER ### URL /userActivityMapping ### EXIT ### ");
		return model;
	}

	/**** SRIPARNA ADD/EDIT ACTIVITY START ***********************/

	@RequestMapping(value = "/addEditActivity")
	public ModelAndView addEditActivity(HttpServletRequest req) {

		logger.debug("  ################### CLASS WEBCONTROLLER ### URL /addEditActivity ### ENTER ### ");

		HttpSession session = req.getSession();
		ModelAndView model = new ModelAndView();

		try {
			if (session != null
					&& session
							.getAttribute(CommonConstant.SESSION_USER_DETAILS) != null) {
				model.setViewName(PageNameConstant.ADD_EDIT_ACTIVITY_PAGE);
			} else {
				model.setViewName(PageNameConstant.LOGIN_PAGE);
				model.addObject("loginForm", new UserProfileModel());
			}

		} catch (Exception e) {
			logger.error("  ################### CLASS WEBCONTROLLER ### URL /addEditActivity ### ERRROR ### "
					+ e);
			model.setViewName(PageNameConstant.ERROR_EVENT_MANAGEMENT_COMMON_PAGE);
		}

		logger.debug("  ################### CLASS WEBCONTROLLER ### URL /addEditActivity ### EXIT ### ");
		return model;
	}

	@RequestMapping(value = "/addEditMenu")
	public ModelAndView add_edit_menu(HttpServletRequest req) {

		logger.debug("  ################### CLASS WEBCONTROLLER ### URL /add-edit-menu ### ENTER ### ");

		HttpSession session = req.getSession();
		ModelAndView model = new ModelAndView();

		try {
			if (session != null
					&& session
							.getAttribute(CommonConstant.SESSION_USER_DETAILS) != null) {
				model.setViewName(PageNameConstant.ADD_EDIT_MNEU);
			} else {
				model.setViewName(PageNameConstant.LOGIN_PAGE);
				model.addObject("loginForm", new UserProfileModel());
			}

		} catch (Exception e) {
			logger.error("  ################### CLASS WEBCONTROLLER ### URL /add-edit-menu ### ERRROR ### "
					+ e);
			model.setViewName(PageNameConstant.ERROR_EVENT_MANAGEMENT_COMMON_PAGE);
		}

		logger.debug("  ################### CLASS WEBCONTROLLER ### URL /add-edit-menu ### EXIT ### ");
		return model;
	}

	@RequestMapping(value = "/addEditFieldNameMenu")
	public ModelAndView add_edit_menu_field_name(HttpServletRequest req) {

		logger.debug("  ################### CLASS WEBCONTROLLER ### URL /add_edit_menu_field ### ENTER ### ");

		HttpSession session = req.getSession();
		ModelAndView model = new ModelAndView();

		try {
			if (session != null
					&& session
							.getAttribute(CommonConstant.SESSION_USER_DETAILS) != null) {
				model.setViewName(PageNameConstant.ADD_EDIT_MNEU_FIELD);
			} else {
				model.setViewName(PageNameConstant.LOGIN_PAGE);
				model.addObject("loginForm", new UserProfileModel());
			}

		} catch (Exception e) {
			logger.error("  ################### CLASS WEBCONTROLLER ### URL /add_edit_menu_field ### ERRROR ### "
					+ e);
			model.setViewName(PageNameConstant.ERROR_EVENT_MANAGEMENT_COMMON_PAGE);
		}

		logger.debug("  ################### CLASS WEBCONTROLLER ### URL /add_edit_menu_field ### EXIT ### ");
		return model;
	}

	// ==============abdus added this code @28-12-2017=========start======

	@RequestMapping(value = "/addEditSchedule")
	public ModelAndView addEditSchedule(HttpServletRequest req) {

		logger.debug("  ################### CLASS WEBCONTROLLER ### URL /addEditSchedule ### ENTER ### ");

		HttpSession session = req.getSession();
		ModelAndView model = new ModelAndView();

		try {
			if (session != null
					&& session
							.getAttribute(CommonConstant.SESSION_USER_DETAILS) != null) {
				// abdus added this code @28-12-2018
				List<EventModel> eventNameListData = new ArrayList<EventModel>();
				eventNameListData = userService.getEventNameList();
				model.addObject("eventNameListData", eventNameListData);
				// abdus added this code
				model.setViewName(PageNameConstant.ADD_EDIT_SCHEDULE_PAGE);
			} else {
				model.setViewName(PageNameConstant.LOGIN_PAGE);
				model.addObject("loginForm", new UserProfileModel());
			}

		} catch (Exception e) {
			logger.error("  ################### CLASS WEBCONTROLLER ### URL /addEditSchedule ### ERRROR ### "
					+ e);
			model.setViewName(PageNameConstant.ERROR_EVENT_MANAGEMENT_COMMON_PAGE);
		}

		logger.debug("  ################### CLASS WEBCONTROLLER ### URL /addEditSchedule ### EXIT ### ");
		return model;
	}
	// ===============abdus added this code @28-12-2017=========end======
	/*Priyanka 26.12.2017 @Start*/

	@RequestMapping(value = "/addEditAbout")
	public ModelAndView addEditAbout(HttpServletRequest req) {

		logger.debug("  ################### CLASS WEBCONTROLLER ### URL /addEditAbout ### ENTER ### ");
		
		HttpSession session=req.getSession();
		ModelAndView model = new ModelAndView();
		
		try {
			if (session !=null  && session.getAttribute(CommonConstant.SESSION_USER_DETAILS)!=null){
			    model.setViewName(PageNameConstant.ADD_EDIT_ABOUT_PAGE);
			}else{
				model.setViewName(PageNameConstant.LOGIN_PAGE);
				model.addObject("loginForm", new UserProfileModel());
			}
		} catch (Exception e) {
			logger.error("  ################### CLASS WEBCONTROLLER ### URL /addEditAbout ### ERRROR ### " + e);
			model.setViewName(PageNameConstant.ERROR_EVENT_MANAGEMENT_COMMON_PAGE);
		}
		logger.debug("  ################### CLASS WEBCONTROLLER ### URL /addEditAbout ### EXIT ### ");
		return model;
	}



	/*Priyanka 26.12.2017 @End*/

	/**** MOUSUMI START add edit menu fields value 03-01-2018 ************************/
	@RequestMapping(value = "/addEditMenuFieldValue")
	public ModelAndView addEditMenuFieldValue(HttpServletResponse response,
			HttpSession session) {

		logger.debug("  ################### CLASS WEBCONTROLLER ### URL /addEditMenuFieldValue ### ENTER ### ");

		ModelAndView model = new ModelAndView();
		try {
			if (session != null
					&& session
							.getAttribute(CommonConstant.SESSION_USER_DETAILS) != null) {
				model.setViewName(PageNameConstant.ADD_EDIT_MENU_FIELD_VALUE);
			} else {
				model.setViewName(PageNameConstant.LOGIN_PAGE);
				model.addObject("loginForm", new UserProfileModel());
			}

		} catch (Exception e) {
			logger.error("  ################### CLASS WEBCONTROLLER ### URL /addEditMenuFieldValue ### ERRROR ### "
					+ e);
			model.setViewName(PageNameConstant.ERROR_EVENT_MANAGEMENT_COMMON_PAGE);
		}

		logger.debug("  ################### CLASS WEBCONTROLLER ### URL /addEditMenuFieldValue ### EXIT ### ");
		return model;
	}
	/**** MOUSUMI END add edit menu fields value 03-01-2018 ************************/

}
