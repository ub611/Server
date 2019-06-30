<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/jsp/menu.jsp"/>


<div style="margin:40px">
	<h2>Pets to Adopt</h2>
</div>
<div style="margin:40px"><a href="/petRegister.do">펫 등록하러 가깅!</a></div>

<div class="container" style="margin:20px">
  <div class="row">
  <c:forEach var="pet" items="${petList}">
    <div class="col-xl-3 col-md-6 mb-4">
      <div class="card border-0 shadow">
      <a href="/adoptDetail.do?p_idx=${pet.p_idx}">   
        <img src="${pet.p_url}" class="card-img-top" alt="..."> </a> 
        <div class="card-body text-center">
          <h5 class="card-title mb-0">${pet.p_name} :: ${pet.p_cate_detail}</h5>
          <div class="card-text text-black-50">Age :: ${pet.p_age}</div>
          <div class="card-text text-black-50">Gender :: <c:choose><c:when test="${pet.getP_gender() eq 0}">boy</c:when><c:otherwise>girl</c:otherwise></c:choose></div>
          <div class="card-text text-black-50">Injection :: <c:choose><c:when test="${pet.p_isInjection eq '0'}">did</c:when><c:otherwise>didn't</c:otherwise></c:choose></div>
        </div>
        
	    <div style="margin:10px" class=" text-center">
	    
	    <c:choose>
	     <c:when test="${u_idx ne pet.user_u_idx}">  
	     	    <a href="/chat.do">Chating to Owner</a>  
		 </c:when>
		 
		 <c:otherwise>
		 	    
	    		<div style="margin:10px">
      				 <c:if test="${u_idx eq pet.user_u_idx}">
      	 				<a href="/petEdit.do?p_idx=${pet.p_idx}"> edit   </a> 
		 				<a href="/petDeleteConfirm.do?p_idx=${pet.p_idx}">delete</a>         
		 			</c:if>
	    </div>
		 </c:otherwise>
		 </c:choose>
		 </div>

	    
	    
      </div>
    </div>
  </c:forEach> 
  </div>
</div>


