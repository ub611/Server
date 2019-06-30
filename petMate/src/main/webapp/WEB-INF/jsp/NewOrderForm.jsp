<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<jsp:include page = "/WEB-INF/jsp/menu.jsp"/>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h2>&nbsp;&nbsp;&nbsp;Payment Details</h2>

<div>
<form:form commandName="orderForm" action="/newOrderSubmitted.do" method="post"><br>
  
  <table>
    <tr>
      <td>&nbsp;&nbsp;&nbsp;Bank name</td>
      <td>&nbsp;&nbsp;&nbsp;<form:select path="bankName" items="${bankName}" />
    </tr>
    <tr>
      <td>&nbsp;&nbsp;&nbsp;Account Number:</td>
      <td>&nbsp;&nbsp;&nbsp;<form:input path="accountNumber" size="20"/> 
        <font color="red" size="2">* Use a fake number!</font>
    </tr>
    
  </table>
  <p>
  <p>
  <p>
  	&nbsp;&nbsp;&nbsp;<input type="submit" value="SUBMIT" class="btn btn-outline-secondary slidedown"/>
  </p>
</form:form>
</div>
