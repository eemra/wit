<%@page import="com.whereistango.common.web.route.WitPage"%>
<%@page import="com.whereistango.web.temp.validator.TestSubscribeForm"%>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<jsp:include page="common/head.jsp" />

<body>
	<jsp:include page="common/header.jsp" />

	<div class="container">
		<c:if test="${not empty msg}">
			<div class="alert alert-${css} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<strong>${msg}</strong>
			</div>
		</c:if>

	</div>

	<spring:url value="<%=WitPage.ROOT.direct()%>" var="root" />
	<section id="subscribe">
		<div class="container">
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1">
					<div class="row">
						<div class="col-sm-6">
							<h2>
								<i class="fa fa-envelope-o"></i> COMING SOON <br /> SUBSCRIBE
								TO OUR NEWSLETTER
							</h2>
							<p>We don't use the mail for spam mails. Keep in touch</p>
						</div>
						<div class="col-sm-6 newsletter">
							<form:form class="newsletter" method="post"
								modelAttribute="<%=TestSubscribeForm.FORM_NAME %>"
								action="${root}">
								<spring:bind path="mail">
									<div class="form-group">
										<div class="col-sm-8 ">
											<form:input path="mail" class="form-control" id="email"
												placeholder="E-Mail" />
										</div>
									</div>
									<div class="form-group">
										<div class="col-sm-4">
											<%-- <form:errors path="mail" class="control-label" /> --%>
											<button type="submit" class="btn btn-md btn-join-mail">
												<i class="fa fa-envelope fa-2x pull-left"></i> Subscribe
											</button>
										</div>
									</div>
								</spring:bind>

							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<section id="portfolio">
		<div class="container">
			<div class="row">

				<ul class="portfolio-filter text-center">
					<li><a class="btn btn-default active" href="#" data-filter="*">All</a></li>
					<li><a class="btn btn-default" href="#"
						data-filter=".festivals">Festivals</a></li>
					<li><a class="btn btn-default" href="#"
						data-filter=".marathons">Marathons</a></li>
					<li><a class="btn btn-default" href="#"
						data-filter=".milongas">Milongas</a></li>
					<li><a class="btn btn-default" href="#" data-filter=".schools">Schools</a></li>
					<li><a class="btn btn-default" href="#"
						data-filter=".workshops">Workshops</a></li>
					<li><a class="btn btn-default" href="#"
						data-filter=".practicas">Practicas</a></li>
					<li><a class="btn btn-default" href="#" data-filter=".stores">Stores</a></li>
					<li><a class="btn btn-default" href="#" data-filter=".djs">DJs</a></li>
					<li><a class="btn btn-default" href="#"
						data-filter=".showPerformers">Show Performers</a></li>
				</ul>
				<!--/#portfolio-item-->


				<div class="portfolio-items">

					<!-- portfolio-item-->

					<div class="col-md-3 col-sm-4 portfolio-item branded milongas">
						<div class="single-blog two-column">
							<div class="post-thumb">
								<a href="https://www.facebook.com/chanteclermilonga"
									target="_blank"><img
									src="<c:url value="/src/images/event/milonga/chantecler.jpg" />"
									class="wit-img-responsive" alt=""></a>
								<div class="post-overlay">
									<span><a> <small>Fridays</small></a></span>
								</div>
							</div>
							<div class="post-content overflow">
								<ul class="nav nav-justified post-nav">
									<li><a><i class="fa fa-tag"></i>Milonga -
											Ankara/TURKEY</a></li>
								</ul>
								<h2 class="post-title bold">
									<a target="_blank">Chantecler Milonga</a>
								</h2>
								<h3 class="post-author">
									<a href="#">Posted by whereistango admin</a>
								</h3>
								<div>
									<p>
										The name &lsquo;Chantecler&rsquo; is inspired by the most
										famous cabaret in Buenos Aires in the first half of 1900s. Our
										main aim is to cherish the memory of this precious cabaret in
										Tango history. <br>You are more than welcomed to come to
										Milonga Chantecler and dance with us! <br>Every Friday
										10:00 pm - 02:00 am <br>Cheers, <br>Chantecler Team
									</p>
								</div>
								<a href="https://www.facebook.com/chanteclermilonga"
									target="_blank" class="read-more">View More</a>
							</div>
						</div>
					</div>
					<!--/#portfolio-item-->


					<!-- portfolio-item-->

					<div
						class="col-md-3 col-sm-4 portfolio-item branded showPerformers">
						<div class="single-blog two-column">
							<div class="post-thumb">
								<a
									href="https://www.facebook.com/Tango-%C4%B0nfinity-352882761468824/"
									target="_blank"><img
									src="<c:url value="/src/images/show_performer/tangoinfinity.jpg" />"
									class="wit-img-responsive" alt=""></a>
							</div>
							<div class="post-content overflow">
								<ul class="nav nav-justified post-nav">
									<li><a><i class="fa fa-tag"></i>Show Performers -
											Samsun/TURKEY</a></li>
								</ul>
								<h2 class="post-title bold">
									<a target="_blank">Tango Infinity</a>
								</h2>
								<h3 class="post-author">
									<a href="#">Posted by whereistango admin</a>
								</h3>
								<div>
									<p></p>
								</div>
								<a
									href="https://www.facebook.com/Tango-%C4%B0nfinity-352882761468824/"
									target="_blank" class="read-more">View More</a>
							</div>
						</div>
					</div>
					<!--/#portfolio-item-->


					<!-- portfolio-item-->

					<div class="col-md-3 col-sm-4 portfolio-item branded festivals">
						<div class="single-blog two-column">
							<div class="post-thumb">
								<a href="http://www.19mayistangofestivali.com/" target="_blank"><img
									src="<c:url value="/src/images/event/festival/19mayistangofestivali.jpg" />"
									class="wit-img-responsive" alt=""></a>
								<div class="post-overlay">
									<span><a><small>19-22</small> <br> <small>May</small></a></span>
								</div>
							</div>
							<div class="post-content overflow">
								<ul class="nav nav-justified post-nav">
									<li><a><i class="fa fa-tag"></i>Festival -
											Samsun/TURKEY</a></li>
								</ul>
								<h2 class="post-title bold">
									<a target="_blank">19 May&#305;s Tango Festivali</a>
								</h2>
								<h3 class="post-author">
									<a href="#">Posted by whereistango admin</a>
								</h3>
								<div>
									<p></p>
								</div>
								<a href="http://www.19mayistangofestivali.com/" target="_blank"
									class="read-more">View More</a>
							</div>
						</div>
					</div>
					<!--/#portfolio-item-->

					<!-- portfolio-item-->

					<div class="col-md-3 col-sm-4 portfolio-item branded festivals">
						<div class="single-blog two-column">
							<div class="post-thumb">
								<a href="http://summertangofest.com/" target="_blank"><img
									src="<c:url value="/src/images/event/festival/summertangofest.png" />"
									class="wit-img-responsive" alt=""></a>
								<div class="post-overlay">
									<span><a><small>22-26</small><br> <small>June</small></a></span>
								</div>
							</div>
							<div class="post-content overflow">
								<ul class="nav nav-justified post-nav">
									<li><a><i class="fa fa-tag"></i>Festival -
											Bodrum/Mu&#287;la/TURKEY</a></li>
								</ul>
								<h2 class="post-title bold">
									<a target="_blank">SUMMERTANGOFEST</a>
								</h2>
								<h3 class="post-author">
									<a href="#">Posted by whereistango admin</a>
								</h3>
								<div>
									<p>You are more than welcomed to join us if you like.
										Milongas lasts till morning with great Dj&rsquo;s around the
										world&hellip; Meastros that will create an enlighment in your
										Tango with their performances &amp; workshops Party&rsquo;s
										and pool milongas throughout the festival&hellip; yes, even in
										the boat trip! Want More? Time is your friend! Everything is
										in the same place! Workshops, Parties, Milongas and
										accomodation!</p>
								</div>
								<a href="http://summertangofest.com/" target="_blank"
									class="read-more">View More</a>
							</div>
						</div>
					</div>
					<!--/#portfolio-item-->



					<!-- portfolio-item-->
					<div class="col-md-3 col-sm-4 portfolio-item branded stores">
						<div class="single-blog two-column">
							<div class="post-thumb">
								<a
									href="https://www.facebook.com/Tangoinstyle-by-Serpil-Topuz-342021632638903"
									target="_blank"><img
									src="<c:url value="/src/images/store/tangoinstye.jpg" />"
									class="wit-img-responsive" alt=""></a>
								<!-- <div class="post-overlay">
									<span class="uppercase"><a href="#">14 <br> <small>Feb</small></a></span>
								</div> -->
							</div>
							<div class="post-content overflow">
								<ul class="nav nav-justified post-nav">
									<li><a><i class="fa fa-tag"></i>Store -
											Istanbul/TURKEY</a></li>
								</ul>
								<h2 class="post-title bold">
									<a>Tangoinsytle by Serpil Topuz</a>
								</h2>
								<h3 class="post-author">
									<a>Posted by whereistango admin</a>
								</h3>
								<!-- <p>Duis autem vel eum iriure dolor in hendrerit in blandit
									praesent luptatum zzril delenit augue duis dolore te feugait
									nulla facilisi. Nam liber [...]</p>
								 -->
								<a
									href="https://www.facebook.com/Tangoinstyle-by-Serpil-Topuz-342021632638903"
									target="_blank" class="read-more">View More</a>
								<!--
								<div class="post-bottom overflow">
									<ul class="nav nav-justified post-nav">
										<li><a href="#"><i class="fa fa-heart"></i>32 Love</a></li>
										<li><a href="#"><i class="fa fa-comments"></i>3
												Comments</a></li>
									</ul>
								</div> -->
							</div>
						</div>
					</div>
					<!--/#portfolio-item-->

					<!-- portfolio-item-->
					<div class="col-md-3 col-sm-4 portfolio-item branded workshops">
						<div class="single-blog two-column">
							<div class="post-thumb">
								<a href="https://www.facebook.com/bata.program/" target="_blank"><img
									src="<c:url value="/src/images/workshop/bata.jpg" />"
									class="wit-img-responsive" alt=""></a>
							</div>
							<div class="post-content overflow">
								<ul class="nav nav-justified post-nav">
									<li><a><i class="fa fa-tag"></i>Workshop -
											Istanbul/TURKEY</a></li>
								</ul>
								<h2 class="post-title bold">
									<a>BATA</a>
								</h2>
								<h3 class="post-author">
									<a>Posted by whereistango admin</a>
								</h3>
								<a href="https://www.facebook.com/bata.program/" target="_blank"
									class="read-more">View More</a>
							</div>
						</div>
					</div>
					<!--/#portfolio-item-->

					<!-- portfolio-item-->
					<div class="col-md-3 col-sm-4 portfolio-item branded stores">
						<div class="single-blog two-column">
							<div class="post-thumb">
								<a
									href="https://www.facebook.com/Chique-Dancewear-1436061326638960"
									target="_blank"><img
									src="<c:url value="/src/images/store/chiqueDanceWear.jpg" />"
									class="wit-img-responsive" alt=""></a>
								<!-- <div class="post-overlay">
									<span class="uppercase"><a href="#">14 <br> <small>Feb</small></a></span>
								</div> -->
							</div>
							<div class="post-content overflow">
								<ul class="nav nav-justified post-nav">
									<li><a><i class="fa fa-tag"></i>Store -
											Istanbul/TURKEY</a></li>
								</ul>
								<h2 class="post-title bold">
									<a>Chique Dancewear</a>
								</h2>
								<h3 class="post-author">
									<a>Posted by whereistango admin</a>
								</h3>
								<!-- <p>Duis autem vel eum iriure dolor in hendrerit in blandit
									praesent luptatum zzril delenit augue duis dolore te feugait
									nulla facilisi. Nam liber [...]</p>
								 -->
								<a
									href="https://www.facebook.com/Chique-Dancewear-1436061326638960"
									target="_blank" class="read-more">View More</a>
								<!--
								<div class="post-bottom overflow">
									<ul class="nav nav-justified post-nav">
										<li><a href="#"><i class="fa fa-heart"></i>32 Love</a></li>
										<li><a href="#"><i class="fa fa-comments"></i>3
												Comments</a></li>
									</ul>
								</div> -->
							</div>
						</div>
					</div>
					<!--/#portfolio-item-->

					<!-- portfolio-item-->
					<div class="col-md-3 col-sm-4 portfolio-item branded schools">
						<div class="single-blog two-column">
							<div class="post-thumb">
								<a href="http://www.shinedans.com/" target="_blank"><img
									src="<c:url value="/src/images/school/shinedans.png" />"
									class="wit-img-responsive" alt=""></a>
								<!-- <div class="post-overlay">
									<span class="uppercase"><a href="#">14 <br> <small>Feb</small></a></span>
								</div> -->
							</div>
							<div class="post-content overflow">
								<ul class="nav nav-justified post-nav">
									<li><a><i class="fa fa-tag"></i>School - Ankara/TURKEY</a></li>
								</ul>
								<h2 class="post-title bold">
									<a>Shine Dans</a>
								</h2>
								<h3 class="post-author">
									<a>Posted by whereistango admin</a>
								</h3>
								<!-- <p>Duis autem vel eum iriure dolor in hendrerit in blandit
									praesent luptatum zzril delenit augue duis dolore te feugait
									nulla facilisi. Nam liber [...]</p>
								 -->
								<a href="http://www.shinedans.com/" target="_blank"
									class="read-more">View More</a>
								<!--
								<div class="post-bottom overflow">
									<ul class="nav nav-justified post-nav">
										<li><a href="#"><i class="fa fa-heart"></i>32 Love</a></li>
										<li><a href="#"><i class="fa fa-comments"></i>3
												Comments</a></li>
									</ul>
								</div> -->
							</div>
						</div>
					</div>
					<!--/#portfolio-item-->

					<!-- portfolio-item-->
					<div class="col-md-3 col-sm-4 portfolio-item branded milongas">
						<div class="single-blog two-column">
							<div class="post-thumb">
								<a href="https://www.facebook.com/groups/671798279529978/"
									target="_blank"><img
									src="<c:url value="/src/images/milongas/lamilongashine.jpg" />"
									class="wit-img-responsive" alt=""></a>
								<div class="post-overlay">
									<span><a><br> <small>Weds</small></a></span>
								</div>
							</div>
							<div class="post-content overflow">
								<ul class="nav nav-justified post-nav">
									<li><a><i class="fa fa-tag"></i>Milonga -
											Ankara/TURKEY</a></li>
								</ul>
								<h2 class="post-title bold">
									<a>La Milonga Shine</a>
								</h2>
								<h3 class="post-author">
									<a>Posted by whereistango admin</a>
								</h3>
								<p>Every Wednesday</p>
								<a href="https://www.facebook.com/groups/671798279529978/"
									target="_blank" class="read-more">View More</a>
								<!--
								<div class="post-bottom overflow">
									<ul class="nav nav-justified post-nav">
										<li><a href="#"><i class="fa fa-heart"></i>32 Love</a></li>
										<li><a href="#"><i class="fa fa-comments"></i>3
												Comments</a></li>
									</ul>
								</div> -->
							</div>
						</div>
					</div>
					<!--/#portfolio-item-->


					<!-- portfolio-item-->
					<div class="col-md-3 col-sm-4 portfolio-item branded practicas">
						<div class="single-blog two-column">
							<div class="post-thumb">
								<a href="https://www.facebook.com/studyo333/" target="_blank"><img
									src="<c:url value="/src/images/practica/bosphorusPractica.jpg" />"
									class="wit-img-responsive" alt=""></a>
								<div class="post-overlay">
									<span><a><small>ALL</small> <br> <small>Sundays</small></a></span>
								</div>
							</div>
							<div class="post-content overflow">
								<ul class="nav nav-justified post-nav">
									<li><a href="#"><i class="fa fa-tag"></i>Practica -
											Istanbul/TURKEY</a></li>
								</ul>
								<h2 class="post-title bold">
									<a>Bosphorus Practica</a>
								</h2>
								<h3 class="post-author">
									<a>Posted by whereistango admin</a>
								</h3>
								<p>Every Sunday</p>

								<a href="https://www.facebook.com/studyo333/" target="_blank"
									class="read-more">View More</a>
								<!--
								<div class="post-bottom overflow">
									<ul class="nav nav-justified post-nav">
										<li><a href="#"><i class="fa fa-heart"></i>32 Love</a></li>
										<li><a href="#"><i class="fa fa-comments"></i>3
												Comments</a></li>
									</ul>
								</div> -->
							</div>
						</div>
					</div>
					<!--/#portfolio-item-->

					<!-- portfolio-item-->
					<div class="col-md-3 col-sm-4 portfolio-item branded marathons">
						<div class="single-blog two-column">
							<div class="post-thumb">
								<a href="http://istanbultangoweekend.com/" target="_blank"><img
									src="<c:url value="/src/images/event/marathon/istanbultangoweekend.jpg" />"
									class="wit-img-responsive" alt=""></a>
								<div class="post-overlay">
									<span><a><small>08-10</small> <br> <small>April</small></a></span>
								</div>
							</div>
							<div class="post-content overflow">
								<ul class="nav nav-justified post-nav">
									<li><a><i class="fa fa-tag"></i>Marathon -
											Istanbul/TURKEY</a></li>
								</ul>
								<h2 class="post-title bold">
									<a>istanbultangoweekend</a>
								</h2>
								<h3 class="post-author">
									<a>Posted by whereistango admin</a>
								</h3>
								<div>
									<p>
										Adile Sultan Pavillion which is built for Sultan Abdulaziz's
										little sister Adile Sultan in 1853, located in Validebag
										Grove, Uskudar today. You can reach this rectangle structure's
										enterance with double-armed majestic staircases. There are big
										halls on the first and second floors of the pavillion. <br />Also
										the first movies of phenomenon film series "Hababam Sinifi"
										are shooted in this place and one of the rooms of this
										pavillion is arranged as the Museum of "Hababam Sinifi". <br />We
										are waiting all the Tango lovers for sharing this magic and
										breathing the traces of history in this 163 years old
										ambiance.
									</p>
								</div>
								<a href="http://istanbultangoweekend.com/" target="_blank"
									class="read-more">View More</a>
								<!-- <div class="post-bottom overflow">
									<ul class="nav nav-justified post-nav">
										<li><a href="#"><i class="fa fa-heart"></i>32 Love</a></li>
										<li><a href="#"><i class="fa fa-comments"></i>3
												Comments</a></li>
									</ul>
								</div> -->
							</div>
						</div>
					</div>
					<!--/#portfolio-item-->


					<!-- portfolio-item-->
					<div class="col-md-3 col-sm-4 portfolio-item branded festivals">
						<div class="single-blog two-column">
							<div class="post-thumb">
								<a href="http://www.tangotoistanbul.com/en/" target="_blank"><img
									src="<c:url value="/src/images/event/festival/tangotoistanbul.png" />"
									class="wit-img-responsive" alt=""></a>
								<div class="post-overlay">
									<span><a><small>01-06</small><br> <small>March</small></a></span>
								</div>
							</div>
							<div class="post-content overflow">
								<ul class="nav nav-justified post-nav">
									<li><a><i class="fa fa-tag"></i>Festival -
											Istanbul/TURKEY</a></li>
								</ul>
								<h2 class="post-title bold">
									<a target="_blank">TANGOTOISTANBUL</a>
								</h2>
								<h3 class="post-author">
									<a href="#">Posted by whereistango admin</a>
								</h3>
								<div>
									<p>Every year thousands of tango lovers from more than 58
										countries come to Istanbul to enjoy magical unforgettable
										nights and days. As years pass on, we are getting more
										passionate and energetic with your support. Tango surrounds
										our lives, we live it with the most amazing maestros,
										orchestras and DJs of the Universe where we bring on together
										in Istanbul which is one of the most beloved and historical
										Cities in the World. Join and share the magical moments with
										us, we promise your Tango journey will be an unforgettable
										one.</p>
								</div>
								<a href="http://www.tangotoistanbul.com/en/" target="_blank"
									class="read-more">View More</a>
							</div>
						</div>
					</div>
					<!--/#portfolio-item-->


					<!-- portfolio-item-->
					<div class="col-md-3 col-sm-4 portfolio-item branded djs">
						<div class="single-blog two-column">
							<div class="post-thumb">
								<a href="https://www.facebook.com/TangoDj.Mengi/"
									target="_blank"><img
									src="<c:url value="/src/images/artist/dj/dj_mengi.jpg" />"
									class="wit-img-responsive" alt=""></a>
								<!-- <div class="post-overlay">
									<span class="uppercase"><a>14 <br> <small>Feb</small></a></span>
								</div> -->
							</div>
							<div class="post-content overflow">
								<ul class="nav nav-justified post-nav">
									<li><a><i class="fa fa-tag"></i>DJ - Ankara/TURKEY</a></li>
								</ul>
								<h2 class="post-title bold">
									<a>DJ Murat Mengi</a>
								</h2>
								<h3 class="post-author">
									<a>Posted by whereistango admin</a>
								</h3>
								<div>
									<p>
										DJ Murat Mengi (Turkey, Ankara):<br />&quot;Tango Djing is an
										art of touching hearts with a music. I'm trying to make people
										feel the rhythm in their hearts and bodies, drive their
										feelings into a new dimension and watch their journey to the
										new world. When you are dancing, you are not yourself anymore
										(or you shouldn't be). You are the music. You are the warmth
										of the embrace. You are your partner. And the floor under your
										feet is not the earth anymore...So my biggest and primary
										intention as a DJ is to make people dance. Not to restrict
										them with the pista, but to show the door to this new
										existence&quot;<br />DJ Mengi is one of the most popular
										tango DJs in Turkey. He plays music at Istanbul, Ankara,
										Izmir, Bursa milongas, and he also has an international DJ
										experience at tango events in Washington D.C., Brussels,
										Cyprus, Stockholm, Moscow.
									</p>
								</div>
							</div>
							<a href="https://www.facebook.com/TangoDj.Mengi/" target="_blank"
								class="read-more">View More</a>
							<!--<div class="post-bottom overflow">
									<ul class="nav nav-justified post-nav">
										<li><a href="#"><i class="fa fa-heart"></i>32 Love</a></li>
										<li><a href="#"><i class="fa fa-comments"></i>3
												Comments</a></li>
									</ul>
								</div> -->
						</div>
					</div>
				</div>
				<!--/#portfolio-item-->




			</div>
			<!--/#row -->
		</div>
		<!--/#container -->
	</section>

	<jsp:include page="common/footer.jsp" />

</body>
<script type="text/javascript">
	$('#info').readmore({
		moreLink : '<a href="#">Usage, examples, and options</a>',
		collapsedHeight : 384,
		afterToggle : function(trigger, element, expanded) {
			if (!expanded) { // The "Close" link was clicked
				$('html, body').animate({
					scrollTop : element.offset().top
				}, {
					duration : 100
				});
			}
		}
	});

	$('article').readmore({
		speed : 500
	});
</script>
