package org.owls.tfarm.api.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.owls.tfarm.common.session.SessionManager;
import org.owls.tfarm.member.service.MongoMemberService;
import org.owls.tfarm.mongo.documents.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Login 처리용 restful controller
 * 무조건 JSON 타입으로 반환함.
 * @author juneyoungoh
 *
 */
//, consumes={"application/json"}
@Controller
@RequestMapping(value={"member"}, produces={"application/json"})
@ResponseStatus(value = HttpStatus.OK)
public class MemberApiController {
	
	@Autowired
	MongoMemberService service;
	
	private static ObjectMapper mapper;
	
	/**
	 * 로그인 - 비교하고 성공하면 session_id 를 발급한다
	 * @param request
	 * @param resp
	 * @return
	 * @throws JsonProcessingException 
	 * @throws Exception
	 */
	@RequestMapping(value={"/login"})
	public @ResponseBody String login(@RequestBody Map<?, ?> jsonBody, HttpServletRequest request) throws JsonProcessingException {
		System.out.println("Login request" + jsonBody.toString());
		Map<String, String> result = new HashMap<String, String>();
		String rs = "E";
		String message = "ERROR";
		
		try{
			String id = String.valueOf(jsonBody.get("id"));
			String password = String.valueOf(jsonBody.get("password"));
			
			User user = service.read(id);
			System.out.println("READ USER DOCUMENT :: " + String.valueOf(user));
			if(user == null || !user.getPassword().equals(password)){
				System.out.println("user does not exist or password incorrect");
				message = "user does not exist or password incorrect";
			} else {
				System.out.println("user exist, password correct");
				SessionManager.putSessionUser(request, SessionManager.generateSessionID(), user);
				rs = "S";
				message = "SUCCESS";
			}
		} catch(Exception ex) {
			message = ex.getMessage();
		}
		result.put("result", rs);
		result.put("result_msg", message);
		mapper = new ObjectMapper();
		return mapper.writeValueAsString(result);
	}
	
	/**
	 * 로그아웃 - 세션 아이디를 제거한다 
	 * @param request
	 * @param resp
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value={"logout"})
	public @ResponseBody String logout(@RequestBody Map<?,?> jsonBody, HttpServletRequest request) throws JsonProcessingException {
		Map<String, String> result = new HashMap<String, String>();
		mapper = new ObjectMapper();
		String rs = "E";
		String message = "ERROR";
		try{
			String session_id = String.valueOf(request.getSession().getAttribute("session_id"));
			SessionManager.removeSessionUser(session_id);
//			request.getSession().invalidate();
			rs = "S";
			message = "SUCCESS";
		}catch(Exception ex) {
			ex.printStackTrace();
			rs = "E";
			message = ex.getMessage();
		}
		result.put("result", rs);
		result.put("message", message);
		return mapper.writeValueAsString(result);
	}

	/**
	 * 가입에 대한 처리 
	 * @param request
	 * @param resp
	 * @return
	 * @throws JsonProcessingException 
	 * @throws Exception
	 */
	@RequestMapping(value={"register"})
	public @ResponseBody String register(@RequestBody Map<?, ?> jsonBody, HttpServletRequest request) throws JsonProcessingException {
		Map<String, String> result = new HashMap<String, String>();
		mapper = new ObjectMapper();
		String rs = "E";
		String message = "resister failed";
		try{
			service.create(jsonBody);
			rs = "S";
			message = "register success";
		} catch( Exception ex) {
			message = ex.getMessage();
		}
		result.put("result", rs);
		result.put("result_msg", message);
		return mapper.writeValueAsString(result);
	}
	
	/**
	 * 탈퇴에 대한 처리 
	 * @param request
	 * @param resp
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value={"secede"})
	public @ResponseBody String secede(@RequestBody Map<?, ?> jsonBody, HttpServletRequest request) throws Exception {
		return "";
	}
};