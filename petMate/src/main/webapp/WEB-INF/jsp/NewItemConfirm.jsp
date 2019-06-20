<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language ="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8");%>

<!------ Include the above in your HEAD tag ---------->


<jsp:include page="/WEB-INF/jsp/menu.jsp"/>

<h2 class="mb-5">New Item</h2>


<div class="container">
<%-- 	<form:form commandName="itemCommand" class="form-horizontal" action="new.do" method="post" enctype="multipart/form-data" >
 --%>
 <form class="form-horizontal" action="itemsStep1.do" method="post"  >
 <fieldset>

<!-- Form Name -->

<legend>Fill out the item contents</legend>
	
<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Title</label>  
  <div class="col-md-4">
  <input name="i_title" class="form-control input-md"  type="text" placeholder="이름을 입력해주세요." value="${itemCommand.i_title}" readonly >
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Stock</label>  
  <div class="col-md-4">
  <input name="i_stock" class="form-control input-md" type="text" placeholder="2" value="${itemCommand.i_stock}" readonly >
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Price</label>  
  <div class="col-md-4">
  <input name="i_price" class="form-control input-md"  type="text" placeholder="10000" value="${itemCommand.i_price}" readonly >
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Detail</label>  
  <div class="col-md-4">
  <input name="i_detail" class="form-control input-md" type="text" placeholder="상품 상세 정보를 입력해주세요." value="${itemCommand.i_detail}" readonly >
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="selectbasic">Category</label>
  <div class="col-md-4">
    <select name="i_category" class="form-control" id="selecteded">
      <option disabled="disabled" value="1">Food & Snack</option>
      <option disabled="disabled" value="2">Houseware</option>
      <option disabled="disabled" value="3">Toy</option>
      <option disabled="disabled" value="4">Goods for Walk</option>
    </select>
  </div>
</div>
<div>
<button class="btn"><a href='<c:url value="itemsEdit.do"/>'>Edit</a></button>
<button class="btn"><a href='<c:url value="/itemsDetail?i_idx=${itemCommand.i_idx}"/>' >Go Item Detail</a></button>
</div>
</fieldset>
</form>

</div>

<script>
$("#selecteded").val(${itemCommand.i_category}).prop("selected", true);
</script> 