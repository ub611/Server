<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<jsp:include page="/WEB-INF/jsp/menu.jsp"/>

<c:if test="${!empty message}">
  <b><font color="red"><c:url value="${message}" /></font></b>
  <br>
  <c:out value="Id or Password is wrong."/>
</c:if>

<div align="center">
  <form action='<c:url value="/signin.do"/>' method="POST">
    <%-- <c:if test="${!empty signinForwardAction}">
      <input type="hidden" name="forwardAction"
        value='<c:url value="${signinForwar dAction}"/>' />
    </c:if> --%>
    <p></p> <p></p> <p></p>  <p></p> <p></p> <p></p>  <p></p> <p></p> <p></p>  <p></p> <p></p> <p></p>
    <table>
      <tr>
        <td colspan="2">Please enter your username and password. <br />&nbsp;
        </td>
      </tr>
      <tr>
        <td>ID:</td>
        <td><input type="text" name="username" size="20" /></td>
      </tr>
      <tr>  
        <td>Password:</td>
        <td><input type="password" name="password" size="20" /></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        </tr>
    </table>
   	 <input type="submit" value="LOGIN" class="btn btn-outline-primary slideup"> 
    
    <a href='<c:url value="/signupForm.do"/>'> 
     <button type="button" class="btn btn-outline-primary slideup">JOIN</button>
  </a> 
  </form>
  
</div>

<%-- <%@ include file="IncludeBottom.jsp"%> --%>