package org.owls.tfarm.service.route;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value={"page/member"})
public class MemberController {
	
	@RequestMapping(value={"login"})
	public String login(){
		return "member/login";
	}
	
	@RequestMapping(value={"register"})
	public String register(){
		System.out.println("REGISTER");
		return "member/register";
	}
};