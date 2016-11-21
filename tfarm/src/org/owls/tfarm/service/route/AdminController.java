package org.owls.tfarm.service.route;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value={"admin"})
public class AdminController {
	@RequestMapping(value={"dashboard"})
	public ModelAndView dashboard (HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/dashboard");
		return mav;
	}
};