package org.owls.tfarm.member.controller;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.owls.tfarm.common.session.SessionManager;
import org.owls.tfarm.member.service.MongoMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value={"member"})
public class MemberController {
	
	@Autowired
	MongoMemberService service;
	
	@Autowired
	SessionManager sessionManager;

	@RequestMapping(value={"/login"})
	public String login(HttpServletRequest request, HttpServletResponse resp) throws Exception {
		System.out.println("Login request");
		String viewName = "";
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		Map<String, Object> user = service.read(id);
		if(user == null || !user.get("password").equals(password)){
			System.out.println("user exist, password incorrect");
			viewName = "redirect:/";
		} else {
			System.out.println("user exist, password correct");
			viewName = "redirect:/admin/dashboard";
			sessionManager.putSession(sessionManager.generateSessionID(), user);
			request.getSession().setAttribute("login", true);
		}
		return viewName;
	}
	
	@RequestMapping(value={"logout"})
	public String logout(HttpServletRequest request, HttpServletResponse resp) throws Exception {
		System.out.println("Logout request");
		request.getSession().removeAttribute("login");
		return "/";
	}
	
	@RequestMapping(value={"register"})
	public String register(HttpServletRequest request, HttpServletResponse resp) throws Exception {
		return "/member/register";
	}
	
//	@RequestMapping(value={"secede"})
//	public String secede(HttpServletRequest request, HttpServletResponse resp) throws Exception {
//		String user_id = String.valueOf(request.getParameter("id"));
//		if(!"system".equals(user_id)) return "redirect:/";
//		else return request.getRemoteHost();
//	}
};