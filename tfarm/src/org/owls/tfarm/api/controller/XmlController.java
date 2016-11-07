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

@Controller
@RequestMapping(value={"api"}, produces={"application/xml"})
public class XmlController implements CommonApiMongoController<String, ModelAndView, Exception> {

	private final String VIEW = "api/xml";
	
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
		mav.setViewName(VIEW);
		mav.addObject("result", service.list(col));
		return mav;
	}
}
