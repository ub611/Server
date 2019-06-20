<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<jsp:include page="/WEB-INF/jsp/menu.jsp"/>

<h2 class="mb-5">Item</h2>

<div class="container">
  <div class="w-100">
	<div class="container">
	<div><button><a href="items/step1.do">new Item</a></button></div>
	<div class="row">
		<ul class="list-group">
          <li class="list-group-item"><a href="/items.do?sort=0">All</a></li>
          <li class="list-group-item"><a href="/items.do?sort=1" >Food & Snack</a></li>
          <li class="list-group-item"><a href="/items.do?sort=2" >House</a></li>
          <li class="list-group-item"><a href="/items.do?sort=3">Toy</a></li>
          <li class="list-group-item"><a href="/items.do?sort=4" >Walk</a></li>
        </ul>
	</div>
	</div>
</div>
    <div class="row">
        <div class="col-lg-12 my-3">
            <div class="pull-right">
                <div class="btn-group">
                    <button class="btn btn-info" id="list">
                        List View
                    </button>
                    <button class="btn btn-danger" id="grid">
                        Grid View
                    </button>
                </div>
            </div>
        </div>
    </div> 
    <div id="products" class="row view-group">
                <div class="item col-xs-4 col-lg-4">
                      <c:forEach var="item" items="${items}">
                    <div class="thumbnail card">
                        <div class="img-event">
                            <img class="group list-group-image img-fluid" src="${item.ii_url[0]}" alt="" />
                        </div>
                        <div class="caption card-body">
                            <h4 class="group card-title inner list-group-item-heading">
                                <a href="/items/${item.i_idx}">${item.i_title}</a></h4>
                            <p class="group inner list-group-item-text">
                                ${item.i_detail}</p>
                            <div class="row">
                                <div class="col-xs-12 col-md-6">
                                    <p class="lead">
                                        ￦ ${item.i_price}</p>
                                </div>
                                <div><p>${item.i_date}</p></div>
                                <div class="col-xs-12 col-md-6">
                                    <a class="btn btn-success" href="http://www.jquery2dotnet.com">Add to cart</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    </c:forEach>
                    
                </div>
                </div>
                </div>

<style>
.view-group {
    display: -ms-flexbox;
    display: flex;
    -ms-flex-direction: row;
    flex-direction: row;
    padding-left: 0;
    margin-bottom: 0;
}
.thumbnail
{
    margin-bottom: 30px;
    padding: 0px;
    -webkit-border-radius: 0px;
    -moz-border-radius: 0px;
    border-radius: 0px;
}

.item.list-group-item
{
    float: none;
    width: 100%;
    background-color: #fff;
    margin-bottom: 30px;
    -ms-flex: 0 0 100%;
    flex: 0 0 100%;
    max-width: 100%;
    padding: 0 1rem;
    border: 0;
}
.item.list-group-item .img-event {
    float: left;
    width: 30%;
}

.item.list-group-item .list-group-image
{
    margin-right: 10px;
}
.item.list-group-item .thumbnail
{
    margin-bottom: 0px;
    display: inline-block;
}
.item.list-group-item .caption
{
    float: left;
    width: 70%;
    margin: 0;
}

.item.list-group-item:before, .item.list-group-item:after
{
    display: table;
    content: " ";
}

.item.list-group-item:after
{
    clear: both;
}
</style>
<script>
$(document).ready(function() {
    $('#list').click(function(event){event.preventDefault();$('#products .item').addClass('list-group-item');});
    $('#grid').click(function(event){event.preventDefault();$('#products .item').removeClass('list-group-item');$('#products .item').addClass('grid-group-item');});
});
</script> --%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<% request.setCharacterEncoding("utf-8");%>

<!------ Include the above in your HEAD tag ---------->

<jsp:include page="/WEB-INF/jsp/menu.jsp"/>

<!-- <section class="resume-section p-3 p-lg-5 d-flex align-items-center" id="item">
 -->  
 <div class="w-100">
<!--  	<div class="container">
    <h2 class="mb-5">Item</h2>
    <div class="container">	<div><button><a href="items/step1.do">new Item</a></button></div>
		</div> -->


<div style="margin:40px"><h2>Items </h2></div>
<div style="margin:40px"><a href="itemsStep1.do">Item 등록하러 가깅!</a></div>


	<div class="col">
		<ul class="list-group">
          <li class="list-group-item"><a href="/items.do?sort=0">All</a></li>
          <li class="list-group-item"><a href="/items.do?sort=1" >Food & Snack</a></li>
          <li class="list-group-item"><a href="/items.do?sort=2" >House</a></li>
          <li class="list-group-item"><a href="/items.do?sort=3">Toy</a></li>
          <li class="list-group-item"><a href="/items.do?sort=4" >Walk</a></li>
        </ul>
	</div>
	</div>

<!-- </section>
 -->
<%-- <br><br>
<div class="container" >
  <div class="row">
    <section id="pinBoot">
      <c:forEach var="item" items="${items}">
         <article class="white-panel"><img src="${item.ii_url[0]}" alt="">
         	<h4><a href="/items/detail?i_idx=${item.i_idx}">${item.i_title}</a></h4>
         		<p>${item.i_date}</p>
         		<p>${item.i_detail}</p>
         		<p>￦ ${item.i_price}</p>
      	 </article>
      </c:forEach>
    </section>
    <hr>
  </div>
</div> --%>

<div class="container" style="margin:20px">
  <div class="row">
   <c:forEach var="item" items="${items}">
    <div class="col-xl-3 col-md-6 mb-4">
      <div class="card border-0 shadow">
        <img src="${item.ii_url[0]}" alt="">
        <div class="card-body text-center">
          <h4><a href="/itemsDetail?i_idx=${item.i_idx}">${item.i_title}</a></h4>
          <h5 class="card-title mb-0"><fmt:formatNumber value="${item.i_price}"  pattern="₩ #,##0"  /></h5>
          <div class="card-text text-black-50">${item.i_detail}</div>
          <div class="card-text text-black-50"><fmt:formatNumber value="${order.i_date}"
pattern="yyyy/MM/dd hh:mm:ss"/></div>
        </div>
      </div>
    </div>
  </c:forEach> 
  </div>
</div> 




<style>
body {
 background-color:#eee;   
}    

#pinBoot {
  position: relative;
  max-width: 100%;
  width: 100%;
}
img {
  width: 100%;
  max-width: 100%;
  height: auto;
}
.white-panel {
  position: absolute;
  background: white;
  box-shadow: 0px 1px 2px rgba(0, 0, 0, 0.3);
  padding: 10px;
}
/*
stylize any heading tags withing white-panel below
*/

.white-panel h1 {
  font-size: 1em;
}
.white-panel h1 a {
  color: #A92733;
}
.white-panel:hover {
  box-shadow: 1px 1px 10px rgba(0, 0, 0, 0.5);
  margin-top: -5px;
  -webkit-transition: all 0.3s ease-in-out;
  -moz-transition: all 0.3s ease-in-out;
  -o-transition: all 0.3s ease-in-out;
  transition: all 0.3s ease-in-out;
}
</style>
  
<script>
$(document).ready(function() {
	$('#pinBoot').pinterest_grid({
	no_columns: 4,
	padding_x: 10,
	padding_y: 10,
	margin_bottom: 50,
	single_column_breakpoint: 700
	});
	});

	/*
	Ref:
	Thanks to:
	http://www.jqueryscript.net/layout/Simple-jQuery-Plugin-To-Create-Pinterest-Style-Grid-Layout-Pinterest-Grid.html
	*/


	/*
	    Pinterest Grid Plugin
	    Copyright 2014 Mediademons
	    @author smm 16/04/2014

	    usage:

	     $(document).ready(function() {

	        $('#blog-landing').pinterest_grid({
	            no_columns: 4
	        });

	    });


	*/
	;(function ($, window, document, undefined) {
	    var pluginName = 'pinterest_grid',
	        defaults = {
	            padding_x: 10,
	            padding_y: 10,
	            no_columns: 3,
	            margin_bottom: 50,
	            single_column_breakpoint: 700
	        },
	        columns,
	        $article,
	        article_width;

	    function Plugin(element, options) {
	        this.element = element;
	        this.options = $.extend({}, defaults, options) ;
	        this._defaults = defaults;
	        this._name = pluginName;
	        this.init();
	    }

	    Plugin.prototype.init = function () {
	        var self = this,
	            resize_finish;

	        $(window).resize(function() {
	            clearTimeout(resize_finish);
	            resize_finish = setTimeout( function () {
	                self.make_layout_change(self);
	            }, 11);
	        });

	        self.make_layout_change(self);

	        setTimeout(function() {
	            $(window).resize();
	        }, 500);
	    };

	    Plugin.prototype.calculate = function (single_column_mode) {
	        var self = this,
	            tallest = 0,
	            row = 0,
	            $container = $(this.element),
	            container_width = $container.width();
	            $article = $(this.element).children();

	        if(single_column_mode === true) {
	            article_width = $container.width() - self.options.padding_x;
	        } else {
	            article_width = ($container.width() - self.options.padding_x * self.options.no_columns) / self.options.no_columns;
	        }

	        $article.each(function() {
	            $(this).css('width', article_width);
	        });

	        columns = self.options.no_columns;

	        $article.each(function(index) {
	            var current_column,
	                left_out = 0,
	                top = 0,
	                $this = $(this),
	                prevAll = $this.prevAll(),
	                tallest = 0;

	            if(single_column_mode === false) {
	                current_column = (index % columns);
	            } else {
	                current_column = 0;
	            }

	            for(var t = 0; t < columns; t++) {
	                $this.removeClass('c'+t);
	            }

	            if(index % columns === 0) {
	                row++;
	            }

	            $this.addClass('c' + current_column);
	            $this.addClass('r' + row);

	            prevAll.each(function(index) {
	                if($(this).hasClass('c' + current_column)) {
	                    top += $(this).outerHeight() + self.options.padding_y;
	                }
	            });

	            if(single_column_mode === true) {
	                left_out = 0;
	            } else {
	                left_out = (index % columns) * (article_width + self.options.padding_x);
	            }

	            $this.css({
	                'left': left_out,
	                'top' : top
	            });
	        });

	        this.tallest($container);
	        $(window).resize();
	    };

	    Plugin.prototype.tallest = function (_container) {
	        var column_heights = [],
	            largest = 0;

	        for(var z = 0; z < columns; z++) {
	            var temp_height = 0;
	            _container.find('.c'+z).each(function() {
	                temp_height += $(this).outerHeight();
	            });
	            column_heights[z] = temp_height;
	        }

	        largest = Math.max.apply(Math, column_heights);
	        _container.css('height', largest + (this.options.padding_y + this.options.margin_bottom));
	    };

	    Plugin.prototype.make_layout_change = function (_self) {
	        if($(window).width() < _self.options.single_column_breakpoint) {
	            _self.calculate(true);
	        } else {
	            _self.calculate(false);
	        }
	    };

	    $.fn[pluginName] = function (options) {
	        return this.each(function () {
	            if (!$.data(this, 'plugin_' + pluginName)) {
	                $.data(this, 'plugin_' + pluginName,
	                new Plugin(this, options));
	            }
	        });
	    }

	})(jQuery, window, document);
</script> 