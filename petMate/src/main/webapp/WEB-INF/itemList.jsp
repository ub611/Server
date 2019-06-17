<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/menu.jsp" flush="true"/>
<table class="n23">
    <tr bgcolor="#CCCCCC">
      <td><b>Order ID</b></td> <td><b>Date</b></td> <td><b>Total Price</b></td>
    </tr>
    <c:forEach var="item" items="${items}">
      <tr bgcolor="#FFFF88">
        <td> <c:out value="${item.i_idx}"/></td>
        <td><c:out value="${item.i_title}"/></td>
        <td><c:out value="${item.i_date}"/></td>
        <td><c:out value="${item.i_detail}"/></td>
      </tr>
    </c:forEach>
  </table>