<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/jsp/menu.jsp"/>

<h1>really wanna delete?</h1>
<form><input type="hidden" name="p_idx" value=${p_idx } /></form>
<a href="/petDetail.do?p_idx=${p_idx}">no</a>
<a href="/petDelete.do?p_idx=${p_idx}">yes</a>