<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<jsp:include page="/WEB-INF/jsp/menu.jsp"/>

<% request.setCharacterEncoding("utf-8");%>

<h2 class="mb-5">&nbsp;&nbsp;&nbsp;MyPage</h2>

&nbsp;&nbsp;&nbsp;&nbsp;
<button type="button" onclick="location.href='/myPageItem?u_idx=${AccountForm.account.u_idx}'" class="btn btn-outline-warning slidetopright">&nbsp;&nbsp;Item&nbsp;&nbsp; </button>
&nbsp;<button type="button" onclick="location.href='/myPagePet?u_idx=${AccountForm.account.u_idx}'" class="btn btn-outline-warning slidetopright"> &nbsp;&nbsp;Pet&nbsp;&nbsp; </button>
&nbsp;<button type="button" onclick="location.href='/chat.do'" class="btn btn-outline-warning slidetopright"> Chatting </button>
&nbsp;&nbsp;
<button type="button" onclick="location.href='/signoff.do'" class="btn btn-outline-danger slideleft"> Logout </button>

<br><br><br>

<div class="container">
	<form:form commandName="AccountForm" class="form-horizontal"
		action="updateAccount.do" method="post">
		<form:errors cssClass="error" />
		<fieldset>

			<!-- Form Name -->

			<legend>Fill out You Information</legend>

<p></p>
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">ID</label>
				<div class="col-md-4">
					<input name="account.u_idx" class="form-control input-md"
						id="u_idx" type="text" placeholder="id"
						value="${AccountForm.account.u_idx}">
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">name</label>
				<div class="col-md-4">
					<input name="account.u_name" class="form-control input-md"
						id="u_name" type="text" placeholder="Kim, Yubin"
						value="${AccountForm.account.u_name}">
					<form:errors path="account.u_name" cssClass="error" />
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">address</label>
				<div class="col-md-4">
					<input name="account.u_address" class="form-control input-md"
						id="u_address" type="text" placeholder="YongIn"
						value="${AccountForm.account.u_address}">
				</div>
				<form:errors path="account.u_address" cssClass="error" />

			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">phone
					Number</label>
				<div class="col-md-4">
					<input name="account.u_phone" class="form-control input-md"
						id="u_phone" type="text" placeholder="010-1234-4567"
						value="${AccountForm.account.u_phone}">
					<form:errors path="account.u_phone" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">password</label>
				<div class="col-md-4">
					<input name="account.u_pw" class="form-control input-md" id="u_pw"
						type="password">
					<form:errors path="account.u_pw" cssClass="error" />

				</div>
			</div>


			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">One
					more password</label>
				<div class="col-md-4">
					<input name="repeatedPassword" class="form-control input-md"
						id="u_pw_repeat" type="password">
					<form:errors path="repeatedPassword" cssClass="error" />

				</div>
			</div>

			<div class="form-group">
				<label class="col-md-4 control-label">Profile Image</label>
				<div class="col-md-4">
					<input name="account.u_profile" class="form-control input-md"
						id="u_profile" type="file">
				</div>
			</div>


			<!-- Button (Double) -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="button1id">Double
					Button</label>
				<div class="col-md-8">
					<!--     <button name="button1id" class="btn btn-success" id="button1id">Create</button>
 --> 
					<input name="button2id" class="btn btn-outline-success slideright" id="button2id"
						type="submit" value="Update" /> 
				</div>
			</div>

		</fieldset>
	</form:form>

</div>