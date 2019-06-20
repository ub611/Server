<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!------ Include the above in your HEAD tag ---------->

<jsp:include page="/WEB-INF/jsp/menu.jsp" />

<h2 class="mb-5">&nbsp;&nbsp;&nbsp;Join Us</h2>


<div class="container">
	<form:form commandName="AccountForm" class="form-horizontal"
		action="signup.do" method="post">
		<form:errors cssClass="error" />
		<fieldset>

			<!-- Form Name -->

			<legend>Fill out You Information</legend>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">ID</label>
				<div class="col-md-4">
					<input id="u_idx" name="account.u_idx"
						class="form-control input-md" type="text"
						placeholder="Input your ID" value="${AccountForm.account.u_idx}">
					<form:errors path="account.u_idx" cssClass="error" />
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
					<input name="button2id" class="btn btn-success" id="button2id"
						type="submit" value="Create" />
				</div>
			</div>

		</fieldset>
	</form:form>

</div>