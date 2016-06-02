<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- <footer id="footer">
	<div class="row">
		<div class="col-sm-12 text-center bottom-separator">
			<img src="images/home/under.png" class="img-responsive inline" alt="">
		</div>
		<div class="col-sm-12">
			<div class="text-center">
				<p>&copy; whereistango.com 2016. All Rights Reserved.</p>
			</div>
		</div>
	</div>
</footer> -->


<footer id="footer">
	<div class="container">
		<div class="row">
			<%-- <div class="col-sm-12 text-center bottom-separator">
				<img src="<c:url value="/src/images/home/under.png" />"
					class="img-responsive inline" alt="">
			</div> --%>
			<div class="col-sm-12">
				<div class="col-sm-12 text-center bottom-separator">
					<p>&copy; whereistango.com 2016. All Rights Reserved.</p>
				</div>
			</div>
		</div>
	</div>
</footer>



<script type="text/javascript" src="<c:url value="/src/js/jquery.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/src/js/bootstrap.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/src/js/main.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/src/js/wow.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/src/js/jquery.isotope.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/src/js/sdk.js" />"></script>

<script src=<c:url value="/src/js/readmore.js" />></script>
<script>
	(function(i, s, o, g, r, a, m) {
		i['GoogleAnalyticsObject'] = r;
		i[r] = i[r] || function() {
			(i[r].q = i[r].q || []).push(arguments)
		}, i[r].l = 1 * new Date();
		a = s.createElement(o), m = s.getElementsByTagName(o)[0];
		a.async = 1;
		a.src = g;
		m.parentNode.insertBefore(a, m)
	})(window, document, 'script', '//www.google-analytics.com/analytics.js',
			'ga');

	ga('create', 'UA-74295415-1', 'auto');
	ga('send', 'pageview');
</script>