<%@page import="org.owls.tfarm.utils.data.JSONHandler"%>
<%@page import="com.fasterxml.jackson.databind.util.JSONPObject"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	out.print(JSONHandler.jsonString(request.getAttribute("result")));
	out.flush();
%>