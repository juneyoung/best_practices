package org.owls.tfarm.api.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.owls.tfarm.api.service.mongo.ApiService;
import org.owls.tfarm.common.action.CommonApiMongoController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//무조건 json.jsp 로 보내며 Object 이름은 result 로 보낸다.
@Controller
@RequestMapping(value={"api"}, produces={"application/json", "text/html"})
public class JSONController implements CommonApiMongoController<String, ModelAndView, Exception> {
	
	private final String VIEW = "api/json";
	
	@Autowired
	ApiService service;

	@Override
	@RequestMapping(value={ "read/{col}" })
	public ModelAndView read(@PathVariable String col, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		System.out.println("READ API CALLED");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(VIEW);
		mav.addObject("result", service.read(col, req.getParameter("id")));
		return mav;
	}

	@Override
	@RequestMapping(value={ "list/{col}" })
	public ModelAndView list(@PathVariable String col, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ModelAndView mav = new ModelAndView();
		// HttpServletRequest 의 queryString 을 받아서 Criteria를 생성한다.
		// 단, 페이징 관련한 파라미터는 예약어로 잡혀있으며 내부에서 치환한다. 
		mav.setViewName(VIEW);
		mav.addObject("result", service.list(col));
		return mav;
	}
}
