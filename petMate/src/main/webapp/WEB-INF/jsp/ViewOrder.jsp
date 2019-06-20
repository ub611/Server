
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<jsp:include page = "/WEB-INF/jsp/menu.jsp"/>
<%@page import="com.example.petMate.controller.OrderForm"%>
<%
	OrderForm orderForm = (OrderForm)session.getAttribute("orderForm");
%>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<div class="container">
        <div class="row text-center">
            <div class="col-md-12">
                <h2>Order Result</h2>
            </div>
            <div class="col-md-12" style="margin-top: 20px;">
                <div class="pricing-table">
                    <div class="panel panel-primary" style="border: none;">
                        <div class="controle-header panel-heading panel-heading-landing">
                            <h1 class="panel-title panel-title-landing">
                                <font size="20"><%=orderForm.getBuy().getB_date() %></font>
                            </h1>
                        </div>
                        <div class="panel-body panel-body-landing">
                            <table class="table">
                            <tr>
                                    <td width="100px"><i class="fa fa-check"></i></td>
                                    <td>Name: <%=orderForm.getAccount().getU_name() %></td>
                                </tr>
                                <tr>
                                    <td width="100px"><i class="fa fa-check"></i></td>
                                    <td>Phone: <%=orderForm.getAccount().getU_phone() %></td>
                                </tr>
                                <tr>
                                    <td width="100px"><i class="fa fa-check"></i></td>
                                    <td>Address: <%=orderForm.getAccount().getU_address() %></td>
                                </tr>
                            </table>
                        </div>
                        <div class="panel-footer panel-footer-landing">
                            <a href="/petList.do" class="btn btn-price btn-success btn-lg">HOME</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>