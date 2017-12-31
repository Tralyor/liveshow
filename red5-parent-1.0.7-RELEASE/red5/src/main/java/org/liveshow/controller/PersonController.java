package org.liveshow.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.liveshow.dto.*;
import org.liveshow.entity.User;
import org.liveshow.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by asus on 2017/12/8.
 */
@Controller
@RequestMapping("/person")
public class PersonController
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;
	@Autowired
	private CareService careService;
	@Autowired
	private LiveRecordService liveRecordService;
	@Autowired
	private RoomService roomService;
	@Autowired
	private PartService partService;
	@Autowired
	private DarkroomDanmakuService darkroomDanmakuService;
	@Autowired
	private ApplicationService applicationService;
	@Autowired
	private DarkroomRoomService darkroomRoomService;
	ObjectMapper mapper = new ObjectMapper();

	/**
	 * 进入关注的所有用户页面
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/following", method = RequestMethod.GET)
	public String getPersonalFollowing(HttpSession session, Model model)
	{
		logger.info("进入following页面");
		User user = (User) session.getAttribute("user");
		if (user != null)
		{
			int id = user.getId();
			List<PersonalFollowingDTO> personalFollowingDTOList = userService.getPersonFollowing(id);

			logger.info("将关注列表放入model");
			model.addAttribute("personalFollowingDTOList", personalFollowingDTOList);

			logger.info("进入关注页面");
			return "person/following";
		}
		else
		{
			logger.info("未登录，跳转到登录页面");
			return "redirect:/user/login";
		}
	}

	/**
	 * 取消关注
	 * @param roomId
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/unfollowing", method = RequestMethod.POST)
	@ResponseBody
	public Show unfollowing(int roomId, HttpSession session)
	{
		User user = (User) session.getAttribute("user");
		if (user != null)
		{
			int userId = user.getId();
			logger.info("用户" + userId + "取消关注：" + roomId);

			int res = careService.deleteCare(userId, roomId);
//			int res = 1;
			if (res == 1)
			{
				logger.info("取消成功");
				return new Show(null, 1, "取消成功！");
			}
			else
			{
				logger.info("取消失败");
				return new Show(null, 0, "取消失败！");
			}
		}
		else
		{
			logger.info("未登录");
			return new Show(null, 0, "请先登录！");
		}
	}

	/**
	 * 进入直播记录页面
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/liveRecord", method = RequestMethod.GET)
	public String getPersonalLiveRecord(HttpSession session, Model model)
	{
		User user = (User) session.getAttribute("user");
		if (user != null)
		{
			int userId = user.getId();
			List<PersonalLiveRecordDTO> personalLiveRecordDTOList = liveRecordService.getLiveRecordByUserId(userId);

			logger.info("将直播记录放入model");
			model.addAttribute("personalLiveRecordDTOList", personalLiveRecordDTOList);

			logger.info("用户" + userId + "进入直播记录页面");
			return "person/liveRecord";
		}
		else
		{
			logger.info("未登录，跳转到登录页面");
			return "redirect:/user/login";
		}
	}

	/**
	 * 根据时间搜索直播记录
	 * @param startTime
	 * @param endTime
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/liveRecordByTime", method = RequestMethod.POST)
	@ResponseBody
	public Show getPersonalLiveRecordByTime(String startTime, String endTime, HttpSession session)
	{
		User user = (User) session.getAttribute("user");
		if (user != null)
		{
			int userId = user.getId();
			Show show = liveRecordService.getLiveRecordByTime(userId, startTime.trim(), endTime.trim());

			logger.info("用户" + userId + "查看" + startTime + "到" + endTime + "直播记录");
			return show;
		}
		else
		{
			logger.info("未登录");
			return new Show(null, 0, "请先登录！");
		}
	}

	/**
	 * 进入直播设置页面
	 * @param session
	 * @param model
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping(value = "/liveSetting", method = RequestMethod.GET)
	public String getPersonLiveSetting(HttpSession session, Model model) throws JsonProcessingException
	{
		User user = (User) session.getAttribute("user");
		if (user != null)
		{
			int userId = user.getId();
			PersonalLiveSettingDTO personalLiveSettingDTO = roomService.getPersonalLiveSetting(userId);

			logger.info("将直播设置放入model");
			model.addAttribute("personalLiveSettingDTO", personalLiveSettingDTO);

			List<PersonalLiveSettingPartDTO> personalLiveSettingPartDTOList = partService.getAllPartWithModuleList();
			logger.info("将全部板块模块放入model");
			model.addAttribute("personalLiveSettingPartDTOListJson", mapper.writeValueAsString(personalLiveSettingPartDTOList));
			model.addAttribute("personalLiveSettingPartDTOList", personalLiveSettingPartDTOList);

			logger.info("进入直播设置页面");
			return "person/liveSetting";
		}
		else
		{
			logger.info("未登录");
			return "redirect:/user/login";
		}
	}

	/**
	 * 更新直播设置
	 * 不包括直播开启关闭
	 * @param personalLiveSettingDTO
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/updateLiveSetting", method = RequestMethod.POST)
	@ResponseBody
	public Show updateLiveSetting(
			@RequestBody PersonalLiveSettingDTO personalLiveSettingDTO,
			HttpSession session)
	{
		User user = (User) session.getAttribute("user");
		if (user != null)
		{
			int userId = user.getId();
			logger.info("用户" + userId + "修改直播设置");
			return roomService.updateLiveSetting(personalLiveSettingDTO);
		}
		else
		{
			logger.info("未登录");
			return new Show(null, 0, "请先登录！");
		}
	}

	/**
	 * 进入禁言名单页面
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/mute", method = RequestMethod.GET)
	public String getMute(HttpSession session, Model model)
	{
		User user = (User) session.getAttribute("user");
		if (user != null)
		{
			int userId = user.getId();
			List<PersonalMuteDTO> personalMuteDTOList = darkroomDanmakuService.getNotExpiredMute(userId);

			logger.info("将禁言名单放入Model");
			model.addAttribute("personalMuteDTOList", personalMuteDTOList);

			logger.info("用户" + userId + "进入禁言名单页面");
			return "person/liveSettingMute";
		}
		else
		{
			logger.info("未登录");
			return "redirect:/user/login";
		}
	}

	/**
	 * 赊销禁言
	 * @param session
	 * @param muteId
	 * @return
	 */
	@RequestMapping(value = "/cancelMute", method = RequestMethod.POST)
	@ResponseBody
	public Show cancelMute(HttpSession session, int muteId)
	{
		User user = (User) session.getAttribute("user");
		if (user != null)
		{
			int userId = user.getId();
			logger.info("用户" + userId + "撤销" + muteId + "的禁言");
			return darkroomDanmakuService.cancelMute(muteId);
		}
		else
		{
			logger.info("未登录");
			return new Show(null, 0, "请先登录！");
		}
	}

	/**
	 * 进入禁言记录页面
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/muteLog", method = RequestMethod.GET)
	public String getMuteLog(HttpSession session, Model model)
	{
		User user = (User) session.getAttribute("user");
		if (user != null)
		{
			int userId = user.getId();
			List<PersonalMuteDTO> personalMuteDTOList = darkroomDanmakuService.getExpireMute(userId);

			logger.info("将禁言记录放入model");
			model.addAttribute("personalMuteDTOList", personalMuteDTOList);

			logger.info("用户" + userId + "进入禁言名单页面");
			return "person/liveSettingMuteLog";
		}
		else
		{
			logger.info("未登录");
			return "redirect:/user/login";
		}
	}

	/**
	 * 进入个人资料页面
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getPerson(HttpSession session, Model model)
	{
		User user = (User) session.getAttribute("user");
		if (user != null)
		{
			int userId = user.getId();
			PersonalProfileDTO personalProfileDTO = userService.getPersonalProfile(userId);

			logger.info("将禁言记录放入model");
			model.addAttribute("personalProfileDTO", personalProfileDTO);

			logger.info("用户" + userId + "进入个人资料页面");
			return "person/person";
		}
		else
		{
			logger.info("未登录");
			return "redirect:/user/login";
		}
	}

	/**
	 * 进入修改密码页面
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/changePass", method = RequestMethod.GET)
	public String changePassPage(HttpSession session, Model model)
	{
		User user = (User) session.getAttribute("user");
		if (user != null)
		{
			int userId = user.getId();
			logger.info("用户" + userId + "进入修改密码页面");

			return "person/personChangePass";
		}
		else
		{
			logger.info("未登录");
			return "redirect:/user/login";
		}
	}

	/**
	 * 修改密码
	 * @param session
	 * @param personalChangePasswordDTO
	 * @return
	 */
	@RequestMapping(value = "/changePass", method = RequestMethod.POST)
	@ResponseBody
	public Show updatePass(HttpSession session,
			@RequestBody PersonalChangePasswordDTO personalChangePasswordDTO)
	{
		User user = (User) session.getAttribute("user");
		if (user != null)
		{
			int userId = user.getId();
			logger.info("用户" + userId + "进行修改密码");
			return userService.updatePassword(userId, personalChangePasswordDTO);
		}
		else
		{
			logger.info("未登录");
			return new Show(null, 0, "请先登录！");
		}
	}

	/**
	 * 进入修改昵称页面
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/changeNickname", method = RequestMethod.GET)
	public String changeNickname(HttpSession session, Model model)
	{
		User user = (User) session.getAttribute("user");
		if (user != null)
		{
			int userId = user.getId();
			logger.info("用户" + userId + "进入修改昵称页面");
			return "person/personChangeName";
		}
		else
		{
			logger.info("未登录");
			return "redirect:/user/login";
		}
	}

	/**
	 * 修改昵称
	 * @param session
	 * @param nickname
	 * @return
	 */
	@RequestMapping(value = "/changeNickname", method = RequestMethod.POST)
	@ResponseBody
	public Show updateNickname(HttpSession session, String nickname)
	{
		User user = (User) session.getAttribute("user");
		if (user != null)
		{
			int userId = user.getId();
			logger.info("用户" + userId + "要修改昵称为" + nickname);
			return userService.updateUserNickName(userId, nickname);
		}
		else
		{
			logger.info("未登录");
			return new Show(null, 0, "请先登录！");
		}
	}

	/**
	 * 进入修改头像页面
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/changePic", method = RequestMethod.GET)
	public String changePic(HttpSession session, Model model)
	{
		User user = (User) session.getAttribute("user");
		if (user != null)
		{
			int userId = user.getId();
			logger.info("用户" + userId + "进入修改头像页面");
			return "person/personChangePic";
		}
		else
		{
			logger.info("未登录");
			return "redirect:/user/login";
		}
	}

	@RequestMapping(value = "/application", method = RequestMethod.GET)
	public String application(HttpSession session, Model model)
	{
		User user = (User) session.getAttribute("user");
		if (user != null)
		{
			int userId = user.getId();
			PersonalProfileDTO personalProfileDTO = userService.getPersonalProfile(userId);
			model.addAttribute("personalProfileDTO", personalProfileDTO);
			logger.info("用户" + userId + "进入实名认证页面");
			return "person/liveApplication";
		}
		else
		{
			logger.info("未登录");
			return "redirect:/user/login";
		}
	}

	@RequestMapping(value = "/submitApplication", method = RequestMethod.POST)
	@ResponseBody
	public Show submitApplication(HttpSession session, HttpServletRequest request)
	{
		String[] nameArray = {"headheldPassport", "passportFront", "passportBack"};
		User user = (User) session.getAttribute("user");

		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd/HH");
		/**构建图片保存的目录**/
		String logoPathDir = "/application"+ dateformat.format(new Date()) + "/" + user.getId();
		System.out.println(logoPathDir);
		/**得到图片保存目录的真实路径**/
		String logoRealPathDir = multipartHttpServletRequest.getSession().getServletContext().getRealPath(logoPathDir);
		/**根据真实路径创建目录**/
		File logoSaveFile = new File(logoRealPathDir);
		if(!logoSaveFile.exists())
			logoSaveFile.mkdirs();

		PersonalApplicationDTO personalApplicationDTO = new PersonalApplicationDTO();

		String realName = multipartHttpServletRequest.getParameter("realName");
		String passportType = multipartHttpServletRequest.getParameter("passportType");
		String idcardId = multipartHttpServletRequest.getParameter("idcardId");

		personalApplicationDTO.setUserId(user.getId());
		personalApplicationDTO.setRealName(realName);
		personalApplicationDTO.setPassportType(passportType);
		personalApplicationDTO.setIdcardId(idcardId);
		/**页面控件的文件流**/
		for (int i = 0; i < 3; i++)
		{
			MultipartFile multipartFile = multipartHttpServletRequest.getFile(nameArray[i]);
			if (!multipartFile.isEmpty())
			{
				/**获取文件的后缀**/
				String suffix = multipartFile.getOriginalFilename().substring
						(multipartFile.getOriginalFilename().lastIndexOf("."));
				/**使用UUID生成文件名称**/
				String logImageName = UUID.randomUUID().toString()+ suffix;//构建文件名称
//				String logImageName = multipartFile.getOriginalFilename();
				/**拼成完整的文件保存路径加文件**/
				String fileName = logoRealPathDir + File.separator + logImageName;
				File file = new File(fileName);

				try {
					multipartFile.transferTo(file);
					String path = logoPathDir + File.separator + logImageName;
					if (i == 0)
					{
						personalApplicationDTO.setHeadheldPassport(path);
					}
					else if (i == 1)
					{
						personalApplicationDTO.setPassportFront(path);
					}
					else if (i == 2)
					{
						personalApplicationDTO.setPassportBack(path);
					}
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else
			{
				return new Show(null, 0, "有图片未选择");
			}
		}

		if (applicationService.addApplication(personalApplicationDTO))
		{
			return new Show(null, 1, "上传成功！");
		}
		else
		{
			return new Show(null, 0, "上传失败！");
		}
	}

	@RequestMapping(value = "/managerApplication", method = RequestMethod.GET)
	public String managerApplication(HttpSession session, Model model)
	{
		User user = (User) session.getAttribute("user");
		if (user != null )
		{
			int userId = user.getId();
			logger.info("用户" + userId + "进入实名认证页面");
			model.addAttribute("applications", applicationService.initApplication());
			return "";
		}
		else
		{
			logger.info("未登录");
			return "redirect:/user/login";
		}
	}

	@RequestMapping(value = "/getApplicationInfo",method = RequestMethod.POST)
	@ResponseBody
	public Show getApplicationInfo(Integer startTime, Integer endTime){
		return applicationService.getApplicationByDate(startTime, endTime);
	}

	@RequestMapping(value = "/checkApplication",method = RequestMethod.POST)
	@ResponseBody
	public Show checkApplication(int id, Boolean passState, HttpSession session){
		User user = (User) session.getAttribute("user");
		return applicationService.checkApplication(id, passState,user.getId());
	}

	@RequestMapping(value = "/getDarkRoomInfoByDate", method = RequestMethod.POST)
	@ResponseBody
	public Show getDarkRoomInfo(Integer startTime, Integer endTime){
		return darkroomRoomService.getDarkRoomInfoByDate(startTime, endTime);
	}

	@RequestMapping(value = "/getDarkRoomInfoByUserName")
	@ResponseBody
	public Show getDarkRoomInfoByUserName(String userName){
		return darkroomRoomService.getDarkRoomInfoByUserName(userName);
	}

	@RequestMapping(value = "/undoDarkRoom",method = RequestMethod.POST)
	@ResponseBody
	public Show undoDarkRoom(int id, HttpSession session){
		User user = (User) session.getAttribute("user");
		return darkroomRoomService.undoDarkRoom(id, user.getId());
	}

}
