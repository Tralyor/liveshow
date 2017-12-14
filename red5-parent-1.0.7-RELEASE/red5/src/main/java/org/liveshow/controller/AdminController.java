package org.liveshow.controller;

import com.sun.org.apache.regexp.internal.RE;
import org.liveshow.dto.Show;
import org.liveshow.entity.Module;
import org.liveshow.entity.Part;
import org.liveshow.entity.User;
import org.liveshow.service.ModuleService;
import org.liveshow.service.PartService;
import org.liveshow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

	@Autowired
	private PartService partService;

	@Autowired
	private ModuleService moduleService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/blockadeHost", method = RequestMethod.GET)
	public String enterBlockadeHost()
	{

		return "manager/blockadeHost";
	}

	@RequestMapping(value = "/blockadeOverview", method = RequestMethod.GET)
	public String enterBlockadeOverview()
	{
		return "manager/blockadeOverview";
	}

	@RequestMapping(value = "/blockadeVisitor", method = RequestMethod.GET)
	public String enterBlockadeVisitor()
	{
		return "manager/blockadeVisitor";
	}

	@RequestMapping(value = "/superAdmin", method = RequestMethod.GET)
	public String enterSuperAdmin()
	{
		return "manager/superAdmin";
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
