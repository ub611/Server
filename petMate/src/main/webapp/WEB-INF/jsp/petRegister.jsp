<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/WEB-INF/jsp/menu.jsp"/>

<div class="container" style="margin:100px">
  <div class="row">
      <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 text-left">                        
        <c:if test="${pet==null}">                   
        <h3>New Pet Information</h3>
        </c:if>
        <c:if test="${pet!=null}">
        <h3>Update Pet Information</h3>
        </c:if> 
      </div>
  </div>
  <div class="row">
      <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6 col-xs-offset-3">
      	<c:if test="${pet==null}">
      		<form action="/petRegister.do" method="POST">
        </c:if>
      	<c:if test="${pet!=null}">
        	<form action="/petEdit.do" method="POST">
        	  <input type="hidden" name="p_idx" value=${pet.p_idx } />
        	  <input type="hidden" name="u_idx" value=${adopt.owner_idx } />
        </c:if>
        	  <c:if test="${adopt!=null}">         
        	  	<label class="form-label" for="a_state">Adoption State</label>          
	            <select name="a_state" required >
                	<option value="">adoption state</option>
	            	<c:choose>
		            	<c:when test="${adopt.a_state eq '0'}"><option value="0" selected>ongoing</option></c:when>
		            	<c:otherwise><option value="0">ongoing</option></c:otherwise>
	            	</c:choose>
	            	<c:choose>
		            	<c:when test="${adopt.a_state eq '1'}"><option value="1" selected>completed</option></c:when>
		            	<c:otherwise><option value="1">completed</option></c:otherwise>
	            	</c:choose>                </select>
	          </c:if>
              <div class="form-group">
                  <label class="form-label" for="p_name">Pet's name</label>
                  <input type="text" class="form-control" id="p_name" name="p_name" tabindex="1" required 
                  value="${pet.p_name}"/>
              </div>                            
              <div>
              	<label class="form-label" for="p_age">Pet's age</label>
                <input type="text" class="form-control" id="p_age" name="p_age" tabindex="2" required 
                value="${pet.p_age}"/>
              </div>
              <hr/>
              <div>
                <label class="form-label" for="p_cate">Pet's category</label>
                <select name="p_cate" required >
                	<option value="">choose cate</option>
                	<c:choose>
		            	<c:when test="${pet.p_cate eq '0'}"><option value="0" selected>dog</option></c:when>
		            	<c:otherwise><option value="0">dog</option></c:otherwise>
	            	</c:choose>
	            	<c:choose>
		            	<c:when test="${pet.p_cate eq '1'}"><option value="1" selected>cat</option></c:when>
		            	<c:otherwise><option value="1">cat</option></c:otherwise>
	            	</c:choose>
	            	<c:choose>
		            	<c:when test="${pet.p_cate eq '2'}"><option value="2" selected>etc</option></c:when>
		            	<c:otherwise><option value="2">etc</option></c:otherwise>
	            	</c:choose>
                </select>
              </div>
              <div>
                <label class="form-label" for="p_cate_detail">Pet's detail category</label>
                <input type="text" class="form-control" id="p_cate_detail" name="p_cate_detail" placeholder="Maltese, Ragdoll..." tabindex="3" required 
                value="${pet.p_cate_detail}"/>
              </div>
              <hr/>
              <div> 
                <label class="form-label" for="p_gender">Pet's gender</label>
                <select name="p_gender" required >
                	<option value="">choose gender</option>
                	<c:choose>
		            	<c:when test="${pet.p_gender eq '1'}"><option value="1" selected>girl</option></c:when>
		            	<c:otherwise><option value="1">girl</option></c:otherwise>
	            	</c:choose>
	            	<c:choose>
		            	<c:when test="${pet.p_gender eq '0'}"><option value="0" selected>boy</option></c:when>
		            	<c:otherwise><option value="0">boy</option></c:otherwise>
	            	</c:choose>
                </select>
              </div>
              <hr/>
              <div>
                <label class="form-label" for="p_isInjection">Pet's injection info</label>
                <select name="p_isInjection" required>
                	<option value="">Neutralization</option>
                	<c:choose>
		            	<c:when test="${pet.p_isInjection eq '0'}"><option value="0" selected>yes</option></c:when>
		            	<c:otherwise><option value="0">yes</option></c:otherwise>
	            	</c:choose>
	            	<c:choose>
		            	<c:when test="${pet.p_isInjection eq '1'}"><option value="1" selected>no</option></c:when>
		            	<c:otherwise><option value="1">no</option></c:otherwise>
	            	</c:choose>
                </select>
              </div>  
              <hr/>
              <label class="form-label" for="a_content">Content</label>
              <textarea class="form-control" rows="5" cols="50" id="a_content" name="a_content" placeholder="..." tabindex="4" required 
              >${adopt.a_content}</textarea>
              <hr>
              <input type="file" name="report" />
              <div class="text-right">
                  <button type="submit" class="btn btn-start-order">
                  	<c:if test="${pet==null}">
					register
					</c:if>
					<c:if test="${pet!=null}">
					edit
					</c:if>
				  </button>
              </div>
          </form>
      </div>
  </div>
</div>
