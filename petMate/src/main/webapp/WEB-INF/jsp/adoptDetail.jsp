<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/jsp/menu.jsp"/>

<div class="container" style="margin:20px">
<h2>${adoptDetail.a_title}</h2>
    <div class="row">

    <div class="col-xs-12 col-md-4 col-md-offset-1">
      <p>
        <strong>gender::</strong> <c:choose><c:when test="${petDetail.p_gender eq '0'}">boy</c:when><c:otherwise>girl</c:otherwise></c:choose>
      </p>
      <p>
        <strong>age::</strong> ${petDetail.p_age }
      </p>
      <p>
        <strong>injection::</strong> <c:choose><c:when test="${petDetail.p_isInjection eq '0'}">did</c:when><c:otherwise>didn't</c:otherwise></c:choose>
      </p>
      <p>
        <em><strong>Wanna Adopt?<br />
        <a href="#">contact to owner</a></strong></em>
      </p>
    </div>
    
    <div class="col-xs-12 col-md-6">
      <figure class="text-center">
        <img src="http://placehold.it/400x300" alt="The Amazing Product" class="img-thumbnail" />
      </figure>
    </div>

  	</div>
  	
  	<hr />
  	
  	<p>
      ${adoptDetail.a_content }
    </p>

	<hr />
	
   <div style="algin:right">
	<a href="/adoptUpdate.do?a_idx=${adoptDetail.a_idx}">edit</a>
	<a href="/adoptDeleteConfirm.do?a_idx=${adoptDetail.a_idx}">delete</a>
   </div>
</div>




