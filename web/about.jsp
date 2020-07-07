<%-- 
    Document   : about
    Created on : Jul 7, 2020, 7:59:48 PM
    Author     : duong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <section class="about_story_area p_120">
            <div class="container">
                <div class="row story_inner">
                    <div class="col-lg-6">
                        <div class="story_text">
                            <h2>About <br />Our Story</h2>
                            <p>Who are in extremely love with eco friendly system. Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                            <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi aliquip consequat.</p>
                            <a class="main_btn" href="#">View Full Menu</a>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="story_img">
                            <img class="img-fluid" src="img/story/story-1.jpg" alt="">
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!--================End Story Area =================-->

        <!--================Member Area =================-->
        <section class="testimonials_area pad_btm">
            <div class="container">
                <div class="testi_slider owl-carousel">
                    <div class="item">
                        <div class="row">
                            <div class="col-lg-4">
                                <img src="img/My_IMG.jpg" alt="">
                            </div>
                            <div class="col-lg-8">
                                <div class="testi_text">
                                    <h4>Lâm Lệ Dương</h4>
                                    <h5>Full-Stack Developer, Google</h5>
                                    <p>“Who are in extremely love with eco friendly system. Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.”</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <div class="row">
                            <div class="col-lg-4">
                                <img src="img/My_IMG.jpg" alt="">
                            </div>
                            <div class="col-lg-8">
                                <div class="testi_text">
                                    <h4>Lâm Lệ Dương</h4>
                                    <h5>Full-Stack Developer, Google</h5>
                                    <p>“Who are in extremely love with eco friendly system. Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.”</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <div class="row">
                            <div class="col-lg-4">
                                <img src="img/My_IMG.jpg" alt="">
                            </div>
                            <div class="col-lg-8">
                                <div class="testi_text">
                                    <h4>Lâm Lệ Dương</h4>
                                    <h5>Full-Stack Developer, Google</h5>
                                    <p>“Who are in extremely love with eco friendly system. Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.”</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <%@include file="footer.jsp" %>
    </body>
</html>
