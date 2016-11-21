package org.owls.tfarm.api.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.owls.tfarm.api.service.mongo.ApiService;
import org.owls.tfarm.common.action.mongo.CommonMongoController;
import org.owls.tfarm.utils.http.HttpRequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value={"api"}, produces={"application/json", "text/html"})
public class JSONController implements CommonMongoController<String, ModelAndView, Exception> {
	
	private final String VIEW = "api/json";
	
	@Autowired
	ApiService service;

	@Override
	@RequestMapping(value={ "read/{col}" })
	public ModelAndView read(@PathVariable String col, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		System.out.println("READ API CALLED");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(VIEW);
		mav.addObject("result", service.findOne(col, req.getParameter("id")));
		return mav;
	}

	@Override
	@RequestMapping(value={ "list/{col}" })
	public ModelAndView list(@PathVariable String col, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(VIEW);
		mav.addObject("result", service.findAll(col, null));
		return mav;
	}
	
	@Override
	@RequestMapping(value={ "create/{col}" })
	public ModelAndView create(@PathVariable String col, HttpServletRequest req, HttpServletRequest resp) throws Exception {
		// TODO Auto-generated method stub
		ModelAndView mav = new ModelAndView();
		Map<String, String> param = HttpRequestUtils.flatRequest(req);
		service.insert(col, param);
		mav.setViewName(VIEW);
		return mav;
	}

	@Override
	@RequestMapping(value={"update/{col}"})
	public ModelAndView update(@PathVariable String col, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(VIEW);
		return mav;
	}

	@Override
	@RequestMapping(value={"delete/{col}"})
	public ModelAndView delete(@PathVariable String col, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(VIEW);
		return mav;
	}
};