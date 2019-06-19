<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<jsp:include page="/WEB-INF/jsp/menu.jsp"/>


<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" rel="stylesheet">
<div class="container">
	<div class="row">
    	 <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="border-radius: 16px;">
                        <div class="well profile col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 text-center">
                                <figure>
                                     <img src="${itemCommand.ii_url}" alt="" class="img-circle" style="width:75px;" id="user-img">
                                </figure>
                                <h5 style="text-align:center;"><strong id="user-name">${itemCommand.i_title}</strong></h5>                               
                                <p style="text-align:center;font-size: smaller;" id="user-frid">Stock: ${itemCommand.i_stock} </p>                      
                                <p style="text-align:center;font-size: smaller;overflow-wrap: break-word;" id="user-email">Detail : ${itemCommand.i_detail} </p>
                                <p style="text-align:center;font-size: smaller;"><strong>price: </strong><span class="tags" id="user-status">${itemCommand.i_price}</span></p>
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 divider text-center"></div>
                                <p style="text-align:center;font-size: smaller;"><strong>Category: </strong></p>
                                <p style="text-align:center;font-size: smaller;" id="user-role">${itemCommand.i_category}</p>
                                <button class="btn"><a href="edit.do" >Edit</a></button>
                                <button class="btn"><a href="?sort=0" >Confirm</a></button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>    
        </div>
	</div>


<style>

<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" rel="stylesheet">
<div class="container">
	<div class="row">
    	 <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="border-radius: 16px;">
                        <div class="well profile col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 text-center">
                                <figure>
                                     <img src="http://www.localcrimenews.com/wp-content/uploads/2013/07/default-user-icon-profile.png" alt="" class="img-circle" style="width:75px;" id="user-img">
                                </figure>
                                <h5 style="text-align:center;"><strong id="user-name">Arun Kumar Perumal</strong></h5>
                                <p style="text-align:center;font-size: smaller;" id="user-frid">FBT000000213 </p>
                                <p style="text-align:center;font-size: smaller;overflow-wrap: break-word;" id="user-email">arunkumarperumal8791@gmail.com </p>
                                <p style="text-align:center;font-size: smaller;"><strong>A/C status: </strong><span class="tags" id="user-status">Active</span></p>
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 divider text-center"></div>
                                <p style="text-align:center;font-size: smaller;"><strong>Job role</strong></p>
                                <p style="text-align:center;font-size: smaller;" id="user-role">Software Engineer</p>
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 divider text-center"></div>
                                    <div class="col-lg-6 left" style="text-align:center;overflow-wrap: break-word;">
                                        <h4><p style="text-align: center;"><strong id="user-globe-rank">245 </strong></p></h4>           
                                        <p><small class="label label-success">Global Ranking</small></p>
                                        <!--<button class="btn btn-success btn-block"><span class="fa fa-plus-circle"></span> Follow </button>-->
                                    </div>
                                    <div class=" col-lg-6 left" style="text-align:center;overflow-wrap: break-word;">
                                        <h4><p style="text-align: center;"><strong id="user-college-rank">245 </strong></p></h4>                   
                                        <p> <small class="label label-warning">College Ranking</small></p>
                                        <!-- <button class="btn btn-info btn-block"><span class="fa fa-user"></span> View Profile </button>-->
                                    </div>
                              </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>    
        </div>
	</div>
</div>
</style>