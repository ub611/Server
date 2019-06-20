<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/jsp/menu.jsp"/>

<div class="container" style="margin:20px">
<h2>${adoptDetail.a_title}</h2>
    <div class="row">

    <div class="col-xs-12 col-md-4 col-md-offset-1">
      <p>
        Proceed then with the classic triplet: the pain, the dream, the solution.
      </p>
      <p>
        <strong>The pain</strong> ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.<br /><strong>The dream</strong> enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodoconsequat. Duis aute irure dolor in reprehenderit in voluptate velit essecillum dolore eu fugiat nulla pariatur.
      </p>
      <p>
        <strong>The solution</strong> selfies semiotics keffiyeh master cleanse Vice before they sold out. Vegan 90's tofu pork belly skateboard, Truffaut tote bag.
      </p>
      <p>
        <em><strong>Interested?<br />
        <a href="#packages">Go straight to the packages.</a></strong></em>
      </p>
    </div>
    
    <div class="col-xs-12 col-md-6">
      <figure class="text-center">
        <img src="http://placehold.it/400x300" alt="The Amazing Product" class="img-thumbnail" />
      </figure>
    </div>

  	</div>
  	
  	<hr />

  <div class="row">
  <figure class="col-md-2 col-md-offset-1">
      <img src="http://placehold.it/100x100" alt="Jonathan F. Doe" class="img-responsive img-circle pull-right" />
  </figure>
  <blockquote class="col-md-7">
      <p>
          Testimonials are important. Be sure to include some in your sales page.
      </p>
      <p>
          With Product, my sales page was <strong>online in minutes</strong>. And it rocks!.
      </p>
      <small>Jonathan F. Doe, CIO at Lorem Ipsum</small>
  </blockquote>
  </div>

  <div style="algin:right">
	<a href="/adoptUpdate.do?a_idx=${adoptDetail.a_idx}">edit</a>
	<a href="/adoptDeleteConfirm.do?a_idx=${adoptDetail.a_idx}">delete</a>
  </div>
</div>




