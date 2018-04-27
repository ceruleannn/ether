<%@ page language="java" pageEncoding="UTF-8"
         contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <base href="${pageContext.request.contextPath}" />

    <title>以太商城</title>
    <link href="/ui/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
    <link href="/ui/css/style.css" rel="stylesheet" type="text/css" media="all" />
    <link href="/ui/css/style4.css" rel="stylesheet" type="text/css" media="all" />
    <script src="/ui/js/jquery.min.js"></script>

</head>
<body>

<!--header-->
<div class="header">
    <div class="container">
        <div class="head">
            <div class=" logo">
                <a href="/index"><img src="/ui/images/logo.png" alt=""></a>
            </div>
        </div>
    </div>
    <div class="header-top">
        <div class="container">
            <div class="col-sm-5 col-md-offset-2  header-login">
                <ul >

                    <c:choose>

                        <c:when test="${sessionScope.user==null}">
                            <li><a href="/u/login">登陆</a></li>
                            <li><a href="/u/sign">注册</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="#">欢迎你 ${sessionScope.user.username}</a></li>
                            <li><a href="/u/logout">注销</a></li>
                            <li><a href="/u/edit">修改密码</a></li>
                            <li><a href="/o/order">订单</a></li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>

            <div class="clearfix"> </div>
        </div>
    </div>

    <div class="container">

        <div class="head-top">

            <div class="col-sm-8 col-md-offset-2 h_menu4">
                <nav class="navbar nav_bottom" role="navigation">

                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header nav_2">
                        <button type="button" class="navbar-toggle collapsed navbar-toggle1" data-toggle="collapse" data-target="#bs-megadropdown-tabs">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>

                    </div>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
                        <ul class="nav navbar-nav nav_1">
                            <li><a class="color" href="/index">主页</a></li>

                            <li><a class="color3" href="/p/list?type=1">新闻</a></li>
                            <li><a class="color4" href="/p/list?type=1">CPU</a></li>
                            <li><a class="color3" href="/p/list?type=3">内存</a></li>
                            <li><a class="color4" href="/p/list?type=2">显卡</a></li>
                            <li><a class="color5" href="/p/list?type=4">硬盘</a></li>
                            <li><a class="color6" href="/p/list?type=5">呵呵</a></li>
                        </ul>
                    </div><!-- /.navbar-collapse -->

                </nav>
            </div>
            <div class="col-sm-2 search-right">

                <div class="cart box_1">
                    <a href="checkout.html">
                        <h3> <div class="total">
                            <span class="simpleCart_total"></span></div>
                            <img src="/ui/images/cart.png" alt=""/></h3>
                    </a>
                    <p><a href="javascript:;" class="simpleCart_empty">Empty Cart</a></p>

                </div>
                <div class="clearfix"> </div>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<!--banner-->
<div class="banner">
    <div class="container">
        <section class="rw-wrapper">
            <h1 class="rw-sentence">
                <span>Fashion &amp; Beauty</span>
                <div class="rw-words rw-words-1">
                    <span>Beautiful Designs</span>
                    <span>Sed ut perspiciatis</span>
                    <span> Totam rem aperiam</span>
                    <span>Nemo enim ipsam</span>
                    <span>Temporibus autem</span>
                    <span>intelligent systems</span>
                </div>
                <div class="rw-words rw-words-2">
                    <span>We denounce with right</span>
                    <span>But in certain circum</span>
                    <span>Sed ut perspiciatis unde</span>
                    <span>There are many variation</span>
                    <span>The generated Lorem Ipsum</span>
                    <span>Excepteur sint occaecat</span>
                </div>
            </h1>
        </section>
    </div>
</div>
<!--content-->
<div class="content">
    <div class="container">
        <div class="content-top">
            <div class="col-md-6 col-md">
                <div class="col-1">
                    <a href="single.html" class="b-link-stroke b-animate-go  thickbox">
                        <img src="/ui/images/pi.jpg" class="img-responsive" alt=""/><div class="b-wrapper1 long-img"><p class="b-animate b-from-right    b-delay03 ">Lorem ipsum</p><label class="b-animate b-from-right    b-delay03 "></label><h3 class="b-animate b-from-left    b-delay03 ">Trendy</h3></div></a>

                    <!---<a href="single.html"><img src="images/pi.jpg" class="img-responsive" alt=""></a>-->
                </div>
                <div class="col-2">
                    <span>Hot Deal</span>
                    <h2><a href="single.html">Luxurious &amp; Trendy</a></h2>
                    <p>Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years</p>
                    <a href="single.html" class="buy-now">Buy Now</a>
                </div>
            </div>
            <div class="col-md-6 col-md1">
                <div class="col-3">
                    <a href="single.html"><img src="/ui/images/pi1.jpg" class="img-responsive" alt="">
                        <div class="col-pic">
                            <p>Lorem Ipsum</p>
                            <label></label>
                            <h5>For Men</h5>
                        </div></a>
                </div>
                <div class="col-3">
                    <a href="single.html"><img src="/ui/images/pi2.jpg" class="img-responsive" alt="">
                        <div class="col-pic">
                            <p>Lorem Ipsum</p>
                            <label></label>
                            <h5>For Kids</h5>
                        </div></a>
                </div>
                <div class="col-3">
                    <a href="single.html"><img src="/ui/images/pi3.jpg" class="img-responsive" alt="">
                        <div class="col-pic">
                            <p>Lorem Ipsum</p>
                            <label></label>
                            <h5>For Women</h5>
                        </div></a>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>
        <!--products-->
        <div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >网页模板</a></div>
        <div class="content-mid">
            <h3>Trending Items</h3>
            <label class="line"></label>
            <div class="mid-popular">
                <div class="col-md-3 item-grid simpleCart_shelfItem">
                    <div class=" mid-pop">
                        <div class="pro-img">
                            <img src="/ui/images/pc.jpg" class="img-responsive" alt="">
                            <div class="zoom-icon ">
                                <a class="picture" href="/ui/images/pc.jpg" rel="title" class="b-link-stripe b-animate-go  thickbox"><i class="glyphicon glyphicon-search icon "></i></a>
                                <a href="single.html"><i class="glyphicon glyphicon-menu-right icon"></i></a>
                            </div>
                        </div>
                        <div class="mid-1">
                            <div class="women">
                                <div class="women-top">
                                    <span>Women</span>
                                    <h6><a href="single.html">Sed ut perspiciati</a></h6>
                                </div>
                                <div class="img item_add">
                                    <a href="#"><img src="/ui/images/ca.png" alt=""></a>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                            <div class="mid-2">
                                <p ><label>$100.00</label><em class="item_price">$70.00</em></p>
                                <div class="block">
                                    <div class="starbox small ghosting"> </div>
                                </div>

                                <div class="clearfix"></div>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="col-md-3 item-grid simpleCart_shelfItem">
                    <div class=" mid-pop">
                        <div class="pro-img">
                            <img src="/ui/images/pc1.jpg" class="img-responsive" alt="">
                            <div class="zoom-icon ">
                                <a class="picture" href="/ui/images/pc1.jpg" rel="title" class="b-link-stripe b-animate-go  thickbox"><i class="glyphicon glyphicon-search icon "></i></a>
                                <a href="single.html"><i class="glyphicon glyphicon-menu-right icon"></i></a>
                            </div>
                        </div>
                        <div class="mid-1">
                            <div class="women">
                                <div class="women-top">
                                    <span>Women</span>
                                    <h6><a href="single.html">At vero eos</a></h6>
                                </div>
                                <div class="img item_add">
                                    <a href="#"><img src="/ui/images/ca.png" alt=""></a>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                            <div class="mid-2">
                                <p ><label>$100.00</label><em class="item_price">$70.00</em></p>
                                <div class="block">
                                    <div class="starbox small ghosting"> </div>
                                </div>

                                <div class="clearfix"></div>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="col-md-3 item-grid simpleCart_shelfItem">
                    <div class=" mid-pop">
                        <div class="pro-img">
                            <img src="/ui/images/pc2.jpg" class="img-responsive" alt="">
                            <div class="zoom-icon ">
                                <a class="picture" href="/ui/images/pc2.jpg" rel="title" class="b-link-stripe b-animate-go  thickbox"><i class="glyphicon glyphicon-search icon "></i></a>
                                <a href="single.html"><i class="glyphicon glyphicon-menu-right icon"></i></a>
                            </div>
                        </div>
                        <div class="mid-1">
                            <div class="women">
                                <div class="women-top">
                                    <span>Men</span>
                                    <h6><a href="single.html">Sed ut perspiciati</a></h6>
                                </div>
                                <div class="img item_add">
                                    <a href="#"><img src="/ui/images/ca.png" alt=""></a>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                            <div class="mid-2">
                                <p ><label>$100.00</label><em class="item_price">$70.00</em></p>
                                <div class="block">
                                    <div class="starbox small ghosting"> </div>
                                </div>

                                <div class="clearfix"></div>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="col-md-3 item-grid simpleCart_shelfItem">
                    <div class=" mid-pop">
                        <div class="pro-img">
                            <img src="/ui/images/pc3.jpg" class="img-responsive" alt="">
                            <div class="zoom-icon ">
                                <a class="picture" href="/ui/images/pc3.jpg" rel="title" class="b-link-stripe b-animate-go  thickbox"><i class="glyphicon glyphicon-search icon "></i></a>
                                <a href="single.html"><i class="glyphicon glyphicon-menu-right icon"></i></a>
                            </div>
                        </div>
                        <div class="mid-1">
                            <div class="women">
                                <div class="women-top">
                                    <span>Women</span>
                                    <h6><a href="single.html">On the other</a></h6>
                                </div>
                                <div class="img item_add">
                                    <a href="#"><img src="/ui/images/ca.png" alt=""></a>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                            <div class="mid-2">
                                <p ><label>$100.00</label><em class="item_price">$70.00</em></p>
                                <div class="block">
                                    <div class="starbox small ghosting"> </div>
                                </div>

                                <div class="clearfix"></div>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
            <div class="mid-popular">
                <div class="col-md-3 item-grid simpleCart_shelfItem">
                    <div class=" mid-pop">
                        <div class="pro-img">
                            <img src="/ui/images/pc4.jpg" class="img-responsive" alt="">
                            <div class="zoom-icon ">
                                <a class="picture" href="images/pc4.jpg" rel="title" class="b-link-stripe b-animate-go  thickbox"><i class="glyphicon glyphicon-search icon "></i></a>
                                <a href="single.html"><i class="glyphicon glyphicon-menu-right icon"></i></a>
                            </div>
                        </div>
                        <div class="mid-1">
                            <div class="women">
                                <div class="women-top">
                                    <span>Men</span>
                                    <h6><a href="single.html">On the other</a></h6>
                                </div>
                                <div class="img item_add">
                                    <a href="#"><img src="/ui/images/ca.png" alt=""></a>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                            <div class="mid-2">
                                <p ><label>$100.00</label><em class="item_price">$70.00</em></p>
                                <div class="block">
                                    <div class="starbox small ghosting"> </div>
                                </div>

                                <div class="clearfix"></div>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="col-md-3 item-grid simpleCart_shelfItem">
                    <div class=" mid-pop">
                        <div class="pro-img">
                            <img src="/ui/images/pc5.jpg" class="img-responsive" alt="">
                            <div class="zoom-icon ">
                                <a class="picture" href="/ui/images/pc5.jpg" rel="title" class="b-link-stripe b-animate-go  thickbox"><i class="glyphicon glyphicon-search icon "></i></a>
                                <a href="single.html"><i class="glyphicon glyphicon-menu-right icon"></i></a>
                            </div>
                        </div>
                        <div class="mid-1">
                            <div class="women">
                                <div class="women-top">
                                    <span>Men</span>
                                    <h6><a href="single.html">Sed ut perspiciati</a></h6>
                                </div>
                                <div class="img item_add">
                                    <a href="#"><img src="/ui/images/ca.png" alt=""></a>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                            <div class="mid-2">
                                <p ><label>$100.00</label><em class="item_price">$70.00</em></p>
                                <div class="block">
                                    <div class="starbox small ghosting"> </div>
                                </div>

                                <div class="clearfix"></div>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="col-md-3 item-grid simpleCart_shelfItem">
                    <div class=" mid-pop">
                        <div class="pro-img">
                            <img src="/ui/images/pc6.jpg" class="img-responsive" alt="">
                            <div class="zoom-icon ">
                                <a class="picture" href="/ui/images/pc6.jpg" rel="title" class="b-link-stripe b-animate-go  thickbox"><i class="glyphicon glyphicon-search icon "></i></a>
                                <a href="single.html"><i class="glyphicon glyphicon-menu-right icon"></i></a>
                            </div>
                        </div>
                        <div class="mid-1">
                            <div class="women">
                                <div class="women-top">
                                    <span>Women</span>
                                    <h6><a href="single.html">At vero eos</a></h6>
                                </div>
                                <div class="img item_add">
                                    <a href="#"><img src="/ui/images/ca.png" alt=""></a>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                            <div class="mid-2">
                                <p ><label>$100.00</label><em class="item_price">$70.00</em></p>
                                <div class="block">
                                    <div class="starbox small ghosting"> </div>
                                </div>

                                <div class="clearfix"></div>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="col-md-3 item-grid simpleCart_shelfItem">
                    <div class=" mid-pop">
                        <div class="pro-img">
                            <img src="/ui/images/pc7.jpg" class="img-responsive" alt="">
                            <div class="zoom-icon ">
                                <a class="picture" href="/ui/images/pc7.jpg" rel="title" class="b-link-stripe b-animate-go  thickbox"><i class="glyphicon glyphicon-search icon "></i></a>
                                <a href="single.html"><i class="glyphicon glyphicon-menu-right icon"></i></a>
                            </div>
                        </div>
                        <div class="mid-1">
                            <div class="women">
                                <div class="women-top">
                                    <span>Men</span>
                                    <h6><a href="single.html">Sed ut perspiciati</a></h6>
                                </div>
                                <div class="img item_add">
                                    <a href="#"><img src="/ui/images/ca.png" alt=""></a>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                            <div class="mid-2">
                                <p ><label>$100.00</label><em class="item_price">$70.00</em></p>
                                <div class="block">
                                    <div class="starbox small ghosting"> </div>
                                </div>

                                <div class="clearfix"></div>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <!--//products-->
        <!--brand-->
        <div class="brand">
            <div class="col-md-3 brand-grid">
                <img src="/ui/images/ic.png" class="img-responsive" alt="">
            </div>
            <div class="col-md-3 brand-grid">
                <img src="/ui/images/ic1.png" class="img-responsive" alt="">
            </div>
            <div class="col-md-3 brand-grid">
                <img src="/ui/images/ic2.png" class="img-responsive" alt="">
            </div>
            <div class="col-md-3 brand-grid">
                <img src="/ui/images/ic3.png" class="img-responsive" alt="">
            </div>
            <div class="clearfix"></div>
        </div>
        <!--//brand-->
    </div>

</div>
<!--//content-->
<!--//footer-->
<div class="footer">
    <div class="footer-middle">
        <div class="container">
            <div class="col-md-3 footer-middle-in">
                <a href="index.html"><img src="/ui/images/log.png" alt=""></a>
                <p>Suspendisse sed accumsan risus. Curabitur rhoncus, elit vel tincidunt elementum, nunc urna tristique nisi, in interdum libero magna tristique ante. adipiscing varius. Vestibulum dolor lorem.</p>
            </div>

            <div class="col-md-3 footer-middle-in">
                <h6>Information</h6>
                <ul class=" in">
                    <li><a href="404.html">About</a></li>
                    <li><a href="contact.html">Contact Us</a></li>
                    <li><a href="#">Returns</a></li>
                    <li><a href="contact.html">Site Map</a></li>
                </ul>
                <ul class="in in1">
                    <li><a href="#">Order History</a></li>
                    <li><a href="wishlist.html">Wish List</a></li>
                    <li><a href="login.html">Login</a></li>
                </ul>
                <div class="clearfix"></div>
            </div>
            <div class="col-md-3 footer-middle-in">
                <h6>Tags</h6>
                <ul class="tag-in">
                    <li><a href="#">Lorem</a></li>
                    <li><a href="#">Sed</a></li>
                    <li><a href="#">Ipsum</a></li>
                    <li><a href="#">Contrary</a></li>
                    <li><a href="#">Chunk</a></li>
                    <li><a href="#">Amet</a></li>
                    <li><a href="#">Omnis</a></li>
                </ul>
            </div>
            <div class="col-md-3 footer-middle-in">
                <h6>Newsletter</h6>
                <span>Sign up for News Letter</span>
                <form>
                    <input type="text" value="Enter your E-mail" onfocus="this.value='';" onblur="if (this.value == '') {this.value ='Enter your E-mail';}">
                    <input type="submit" value="Subscribe">
                </form>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>

</div>
<!--//footer-->
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="/ui/js/simpleCart.min.js"> </script>
<!-- slide -->
<script src="/ui/js/bootstrap.min.js"></script>
<!--light-box-files -->
<script src="/ui/js/jquery.chocolat.js"></script>
<link rel="stylesheet" href="/ui/css/chocolat.css" type="text/css" media="screen" charset="utf-8">
<!--light-box-files -->
<script type="text/javascript" charset="utf-8">
    $(function() {
        $('a.picture').Chocolat();
    });
</script>


</body>
</html>