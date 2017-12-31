package org.liveshow.controller;

import org.liveshow.dto.Show;
import org.liveshow.dto.manager.*;
import org.liveshow.entity.Part;
import org.liveshow.entity.User;
import org.liveshow.entity.Module;
import org.liveshow.service.DarkroomDanmakuService;
import org.liveshow.service.DarkroomRoomService;
import org.liveshow.service.ModuleService;
import org.liveshow.service.PartService;
import org.liveshow.service.UserService;
import org.liveshow.service.SupermanagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;

/**
 * Created by asus on 2017/12/10.
 */
@Controller
@RequestMapping("/admin")
public class AdminController
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SupermanagerService supermanagerService;
	@Autowired
	private ModuleService moduleService;
	@Autowired
	private DarkroomDanmakuService darkroomDanmakuService;
	@Autowired
	private DarkroomRoomService darkroomRoomService;
	@Autowired
	private PartService partService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/blockadeHost", method = RequestMethod.GET)
	public String enterBlockadeHost(Model model)
	{
		logger.info("获取板块列表");
		List<Module> moduleList = moduleService.getAllModule();
		model.addAttribute("moduleList", moduleList);
		return "manager/blockadeHost";
	}

	@RequestMapping(value = "/searchRoomMute", method = RequestMethod.POST)
	@ResponseBody
	public Show searchRoomMute(int moduleId, boolean state,
			String startTime, String endTime)
	{
		RoomMuteDTO roomMuteDTO = new RoomMuteDTO(moduleId, startTime,
				endTime, state);
		logger.info("查询moduleId为" + roomMuteDTO.getModuleId() +
			"时间在" + roomMuteDTO.getStartTime() + "到" +
			roomMuteDTO.getEndTime() + "过期状态为" + roomMuteDTO.isState());
		return darkroomRoomService.getRoomMuteDTO(roomMuteDTO);
	}

	@RequestMapping(value = "/blockadeOverview", method = RequestMethod.GET)
	public String enterBlockadeOverview()
	{
		logger.info("进入封禁概览页面");
		return "manager/blockadeOverview";
	}

	@RequestMapping(value = "/getRoomMuteByModule", method = RequestMethod.GET )
	@ResponseBody
	public Show getRoomMuteByModule()
	{
		logger.info("ajax请求每个板块被封禁的主播人数");
		List<DarkroomByModuleDTO> darkroomByModuleDTOList =
				darkroomRoomService.getNumByModule();
		return new Show(darkroomByModuleDTOList, 1, "获取成功！");
	}

	@RequestMapping(value = "/getDanmaMuteByModule", method = RequestMethod.GET)
	@ResponseBody
	public Show getDanmaMuteByModule()
	{
		logger.info("ajax请求每个板块被封禁的游客人数");
		List<DarkroomByModuleDTO> darkroomByModuleDTOList =
				darkroomDanmakuService.getNumByModule();
		return new Show(darkroomByModuleDTOList, 1, "获取成功！");
	}

	@RequestMapping(value = "/getMuteByDate", method = RequestMethod.GET)
	@ResponseBody
	public Show getMuteByDate()
	{
		logger.info("ajax请求近7天被封禁的游客人数和主播人数");
		List<DarkroomByDateDTO> roomByDateDTOList = darkroomRoomService.getNumByDate();
		List<DarkroomByDateDTO> danmaByDateDTOList = darkroomDanmakuService.getNumByDate();
		MuteByDateDTO muteByDateDTO = new MuteByDateDTO(roomByDateDTOList, danmaByDateDTOList);
		return new Show(muteByDateDTO, 1, "获取成功！");
	}

	@RequestMapping(value = "/blockadeVisitor", method = RequestMethod.GET)
	public String enterBlockadeVisitor(Model model)
	{
		logger.info("进入游客管理页面");

		logger.info("获取板块列表");
		List<Module> moduleList = moduleService.getAllModule();
		model.addAttribute("moduleList", moduleList);
		return "manager/blockadeVisitor";
	}

	@RequestMapping(value = "/searchMute", method = RequestMethod.POST)
	@ResponseBody
	public Show searchMute(int moduleId, boolean state)
	{
		logger.info("搜索moduleId为" + moduleId + "， state为" + state + "封禁用户");
		return darkroomDanmakuService.searchMute(moduleId, state);
	}

	@RequestMapping(value = "/cancelMute", method = RequestMethod.POST)
	@ResponseBody
	public Show cancelMute(int muteId)
	{
		System.out.println(muteId);
		logger.info("撤销muteId为" + muteId + "禁言");
		return darkroomDanmakuService.cancelMute(muteId);
	}

	/**
	 * 进入超管管理页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/superAdmin", method = RequestMethod.GET)
	public String enterSuperAdmin(Model model)
	{
		logger.info("进入游客管理页面");

		logger.info("获取超管的列表");
		List<SuperManagerDTO> superManagerDTOList = supermanagerService.getAllSuperManager();
		model.addAttribute("superManagerDTOList", superManagerDTOList);

		logger.info("获取板块列表");
		List<Module> moduleList = moduleService.getAllModule();
		model.addAttribute("moduleList", moduleList);
		return "manager/superAdmin";
	}

	@RequestMapping(value = "/addSuperManager", method = RequestMethod.POST)
	@ResponseBody
	public Show addSuperManager(String loginName, int moduleId)
	{
		logger.info("添加超管的用户loginName为 " + loginName + " ， 管理的模块id为 " + moduleId);
		return supermanagerService.addSuperManager(loginName, moduleId);
	}

	@RequestMapping(value = "/searchSuperManager", method = RequestMethod.POST)
	@ResponseBody
	public Show getSuperManagerByModule(int moduleId)
	{
		logger.info("获取moduleId为 " + moduleId + " 超管");
		return supermanagerService.getSuperManagerByModuleId(moduleId);
	}

	@RequestMapping(value = "/changeManager", method = RequestMethod.POST)
	@ResponseBody
	public Show changeSuperManagerModuleId(String loginName, int moduleId)
	{
		logger.info("修改loginName为" + loginName + "的用户管理板块Id为" + moduleId);
		return supermanagerService.changeSuperManager(loginName.trim(), moduleId);
	}

	@RequestMapping(value = "/cancelManager", method = RequestMethod.POST)
	@ResponseBody
	public Show cancelSuperManager(String loginName)
	{
		logger.info("取消loginName为" + loginName + "的超管");
		return supermanagerService.canelSuperManager(loginName);
	}

	@RequestMapping("/overview")
	public String enterOverView(){
		return "manager/overview";
	}

	@RequestMapping("/homepart")
	public String enterHomePart(){
		return "manager/homepart";
	}

	@RequestMapping("/manager")
	public String enterPartManager(HttpServletRequest req, Model model){
		List<Part> partList = partService.getAllPart();
		List<Module> moduleList = moduleService.getAllModule();
		model.addAttribute("partList", partList);
		model.addAttribute("moduleList", moduleList);
		return "manager/partmanager";
	}

	@RequestMapping("/performance/part")
	public String enterPartPerformance(){
		return "manager/performance";
	}

	@RequestMapping("/performance/anchor")
	public String enterAnchorPerformance(){
		return "manager/personalperformance";
	}

	@RequestMapping("/login")
	public String login(){
		return "/manager/login";
	}

	@RequestMapping("/doLogin")
	@ResponseBody
	public Show doLogin(@RequestParam("loginName") String loginName, @RequestParam("password") String password, HttpSession session){
		Show show = new Show();
		User user = userService.adminLogin(loginName, password);
		if(user != null){
			session.setAttribute("admin", user);
			show.setState(1);
			show.setMessage("登录成功");
		}else {
			show.setState(0);
			show.setMessage("用户名或密码错误");
		}
		return show;
	}
}
