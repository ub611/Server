<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<% request.setCharacterEncoding("utf-8");%>
<%@ page import="com.example.petMate.command.ItemCommand" %>
<!------ Include the above in your HEAD tag ---------->

<%@include file="/WEB-INF/jsp/menu.jsp" %>
<h2 class="mb-5">New Item</h2>
<%
	ItemCommand itemCommand = (ItemCommand)session.getAttribute("itemCommand");
%>

<div class="container">
 <form class="form-horizontal" action="itemsStep1.do" method="post"  >
 <fieldset>

<!-- Form Name -->

<legend>Fill out the item contents</legend>
	
<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Title</label>  
  <div class="col-md-4">
  <input name="i_title" class="form-control input-md"  type="text" placeholder="이름을 입력해주세요." value="${itemCommand.i_title}">
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Stock</label>  
  <div class="col-md-4">
  <input name="i_stock" class="form-control input-md" type="text" placeholder="2" value="${itemCommand.i_stock}">
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Price</label>  
  <div class="col-md-4">
  <input name="i_price" class="form-control input-md"  type="text" placeholder="10000" value="${itemCommand.i_price}">
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Detail</label>  
  <div class="col-md-4">
  <input name="i_detail" class="form-control input-md" type="text" placeholder="상품 상세 정보를 입력해주세요." value="${itemCommand.i_detail}">
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="selectbasic">Category</label>
  <div class="col-md-4">
    <select name="i_category" class="form-control" id="selecteded">
      <option value="1">Food & Snack</option>
      <option value="2">Houseware</option>
      <option value="3">Toy</option>
      <option value="4">Goods for Walk</option>
    </select>
  </div>
</div>

<!-- Button (Double) -->
<div class="form-group">
  <div class="col-md-8">
<!--     <button name="button1id" class="btn btn-success" id="button1id">Create</button>
 -->    <input name="button2id" class="btn btn-success" id="button2id" type="submit" value="Next"/>
  </div>
</div>

</fieldset>
<%-- </form:form> --%>
</form>

</div>

<script>
$("#selecteded").val(${itemCommand.i_category}).prop("selected", true);
</script> 