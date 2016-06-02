<%@page import="com.whereistango.common.web.route.WitPage"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header id="header">
	<div class="container">
		<div class="row">
			<div class="col-sm-12 overflow">
				<div class="social-icons pull-right">
					<ul class="nav nav-pills">
						<li><a href="https://www.facebook.com/wwhereistango/"><i class="fa fa-facebook"></i></a></li>
						<li><a href="https://twitter.com/whereistango"><i class="fa fa-twitter"></i></a></li>
						<!-- <li><a href=""><i class="fa fa-google-plus"></i></a></li> -->
					</ul>
				</div>
			</div>
		</div>
	</div>

	<div class="navbar navbar-inverse" role="banner">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>

				<a class="navbar-brand"
					href="<c:url value="<%=WitPage.ROOT.direct()%>" />"> <img
					src="<c:url value="/src/images/logo2.png" />" alt="logo">
				</a>

			</div>
			 <div class="collapse navbar-collapse">
				<ul class="nav navbar-nav navbar-right">
					<li class="active"><a
						href="<c:url value="<%=WitPage.ROOT.direct()%>" />">Home</a></li>
				</ul>
			</div> 
			<%-- <div class="search">
				<form role="form">
					<i class="fa fa-search"></i>
					<div class="field-toggle">
						<input type="text" class="search-form" autocomplete="on"
							placeholder="Search">
					</div>
				</form>
			</div> --%>
		</div>
	</div>

</header>