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
  <c:forEach var="adopt" items="${adoptList}">
    <!-- Team Member 1 -->
    <div class="col-xl-3 col-md-6 mb-4">
      <div class="card border-0 shadow">
      
      	
        <img src="${pet.pic_url}" class="card-img-top" alt="...">
        <div class="card-body text-center">
          <h5 class="card-title mb-0"><a href="/adoptDetail.do?a_idx=${adopt.a_idx}">${adopt.a_title}</a></h5>
          <div class="card-text text-black-50">${adopt.a_content}</div>
        </div>
      	
      </div>
    </div>
    <!-- Team Member 2 -->
    <!-- <div class="col-xl-3 col-md-6 mb-4">
      <div class="card border-0 shadow">
        <img src="https://source.unsplash.com/9UVmlIb0wJU/500x350" class="card-img-top" alt="...">
        <div class="card-body text-center">
          <h5 class="card-title mb-0">Team Member</h5>
          <div class="card-text text-black-50">Web Developer</div>
        </div>
      </div>
    </div> -->
    <!-- Team Member 3 -->
    <!-- <div class="col-xl-3 col-md-6 mb-4">
      <div class="card border-0 shadow">
        <img src="https://source.unsplash.com/sNut2MqSmds/500x350" class="card-img-top" alt="...">
        <div class="card-body text-center">
          <h5 class="card-title mb-0">Team Member</h5>
          <div class="card-text text-black-50">Web Developer</div>
        </div>
      </div>
    </div> -->
    <!-- Team Member 4 -->
    <!-- <div class="col-xl-3 col-md-6 mb-4">
      <div class="card border-0 shadow">
        <img src="https://source.unsplash.com/ZI6p3i9SbVU/500x350" class="card-img-top" alt="...">
        <div class="card-body text-center">
          <h5 class="card-title mb-0">Team Member</h5>
          <div class="card-text text-black-50">Web Developer</div>
        </div>
      </div>
    </div> -->
  </c:forEach> 
  </div>
  <!-- /.row -->

</div>
