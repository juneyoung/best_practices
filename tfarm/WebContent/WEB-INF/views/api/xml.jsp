<%@page import="org.owls.tfarm.utils.data.XmlHandler"%>
<%@ page language="java" contentType="application/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	out.print(XmlHandler.xmlString(request.getAttribute("result")));
	out.flush();
%>