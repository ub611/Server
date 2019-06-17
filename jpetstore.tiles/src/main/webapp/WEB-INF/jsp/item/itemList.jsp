<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<table class="n23">
    <tr bgcolor="#CCCCCC">
      <td><b>Order ID</b></td> <td><b>Date</b></td> <td><b>Total Price</b></td>
    </tr>
    <c:forEach var="item" items="${items}">
      <tr bgcolor="#FFFF88">
        <td>
              ${item.i_idx}</td>
            <td>
             ${item.i_title}
          </td>
        <td>${item.i_date}</td>
        <td>${item.i_detail}</td>
      </tr>
    </c:forEach>
  </table>