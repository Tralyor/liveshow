package org.liveshow.controller;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by asus on 2017/12/10.
 */
@Controller
@RequestMapping("/admin")
public class AdminController
{

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
}
