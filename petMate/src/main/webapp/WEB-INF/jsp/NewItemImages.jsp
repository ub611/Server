<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("utf-8");%>

<!------ Include the above in your HEAD tag ---------->


<jsp:include page="/WEB-INF/jsp/menu.jsp"/>

<h2 class="mb-5">New Item</h2>


<div class="container">
<%-- 	<form:form commandName="itemCommand" class="form-horizontal" action="new.do" method="post" enctype="multipart/form-data" >
 --%>
 <form class="form-horizontal" action="itemsNew.do" method="post"  enctype="multipart/form-data">
 <fieldset>

<!-- Form Name -->
<legend>Regist Item Images (max:5)</legend>

<div class="form-group">
  <label class="col-md-4 control-label" >Item Image</label>
  <div class="col-md-4">
  	<input name="ii_url" class="form-control input-md"  type="file" >
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label" >Item Image</label>
  <div class="col-md-4">
  	<input name="ii_url1" class="form-control input-md"  type="file">
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label" >Item Image</label>
  <div class="col-md-4">
  	<input name="ii_url2" class="form-control input-md"  type="file">
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label" >Item Image</label>
  <div class="col-md-4">
  	<input name="ii_url3" class="form-control input-md"  type="file">
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label" >Item Image</label>
  <div class="col-md-4">
  	<input name="ii_url4" class="form-control input-md"  type="file">
  </div>
</div>


<!-- Button (Double) -->
<div class="form-group">
  <div class="col-md-8">
<!--   		<button name="button2id" class="btn btn-success" onclick="location.href='/step1.do'" value="Back"></button>
 -->  <button class="btn"><a href="itemsStep1.do">Back</a></button>
	   <input name="button2id" class="btn btn-success" id="button2id" type="submit" value="Create"/>
  </div>
</div>

</fieldset>
<%-- </form:form> --%>
</form>

</div>