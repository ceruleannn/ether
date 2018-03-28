<%@ page language="java" pageEncoding="UTF-8"
         contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Products</title>
    <link href="../../ui/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
    <!-- Custom Theme files -->
    <!--theme-style-->
    <link href="../../ui/css/style.css" rel="stylesheet" type="text/css" media="all" />
    <!--//theme-style-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <!--theme-style-->
    <link href="../../ui/css/style4.css" rel="stylesheet" type="text/css" media="all" />
    <!--//theme-style-->
    <script src="../../ui/js/jquery.min.js"></script>

    <!--<link href="css/form.css" rel="stylesheet" type="text/css" media="all" />-->
    <link href="../../ui/css/style5.css" rel="stylesheet">
    <link href="../../ui/css/build.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>

<!--header-->
<div class="header">
    <div class="container">
        <div class="head">
            <div class=" logo">
                <a href="index.html"><img src="../../ui/images/logo.png" alt=""></a>
            </div>
        </div>
    </div>
    <div class="header-top">
        <div class="container">
            <div class="col-sm-5 col-md-offset-2  header-login">
                <ul >
                    <li><a href="login.html">Login</a></li>
                    <li><a href="register.html">Register</a></li>
                    <li><a href="checkout.html">Checkout</a></li>
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
                            <li><a class="color" href="index.html">主页</a></li>

                            <li><a class="color3" href="product.html">新闻</a></li>
                            <li><a class="color4" href="404.html">CPU</a></li>
                            <li><a class="color3" href="product.html">内存</a></li>
                            <li><a class="color4" href="404.html">显卡</a></li>
                            <li><a class="color5" href="typo.html">硬盘</a></li>
                            <li ><a class="color6" href="contact.html">呵呵</a></li>
                        </ul>
                    </div><!-- /.navbar-collapse -->

                </nav>
            </div>
            <div class="col-sm-2 search-right">

                <div class="cart box_1">
                    <a href="checkout.html">
                        <h3> <div class="total">
                            <span class="simpleCart_total"></span></div>
                            <img src="../../ui/images/cart.png" alt=""/></h3>
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
<div class="banner-top">
    <div class="container">
        <h1>Products</h1>
        <em></em>
        <h2><a href="index.html">Home</a><label>/</label>Products</h2>
    </div>
</div>
<!--content-->
<div class="product">
    <div class="container">
        <div class="col-md-9">
            <div class="mid-popular">

                <!--  for each element for single product -->
                <c:forEach var="product" items="${requestScope.products}" >

                <div class="col-md-4 item-grid1 simpleCart_shelfItem">
                    <div class=" mid-pop">
                        <div class="pro-img">
                            <img src="../../ui/images/pc.jpg" class="img-responsive" alt="">
                            <div class="zoom-icon ">
                                <a class="picture" href="../../ui/images/pc.jpg" rel="title" class="b-link-stripe b-animate-go  thickbox"><i class="glyphicon glyphicon-search icon "></i></a>
                                <a href="single.html"><i class="glyphicon glyphicon-menu-right icon"></i></a>
                            </div>
                        </div>
                        <div class="mid-1">
                            <div class="women">
                                <div class="women-top">
                                    <span>${product.brand}</span>
                                    <h6><a href="single.html">${product.name}</a></h6>
                                </div>
                                <div class="img item_add">
                                    <a href="#"><img src="../../ui/images/ca.png" alt=""></a>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                            <div class="mid-2">
                                <p ><em class="item_price">¥${product.price}</em></p>
                                <div class="block">
                                    <div class="starbox small ghosting"> </div>
                                </div>

                                <div class="clearfix"></div>
                            </div>

                        </div>
                    </div>
                </div>

                </c:forEach>



                <div class="clearfix"></div>
            </div>
        </div>
        <div class="col-md-3 product-bottom">

            <!--//menu-->
            <section  class="sky-form">
                <h4 class="cate">排序</h4>
                <div class="row row1 scroll-pane">


                    <div class="col col-4">

                        <div class="checkbox checkbox-success">
                            <input type="radio" name="radio4" id="radio9" value="option3">
                            <label for="radio9">
                                按销量排序
                            </label>
                        </div>

                        <div class="checkbox checkbox-success">
                            <input type="radio" name="radio4" id="radio10" value="option3">
                            <label for="radio10">
                                按价格排序
                            </label>
                        </div>

                        <div class="checkbox checkbox-success">
                            <input type="radio" name="radio4" id="radio8" value="option2" checked>
                            <label for="radio8">
                                按时间排序
                            </label>
                        </div>


                    </div>
                </div>
            </section>


            <!---->
            <section  class="sky-form">
                <h4 class="cate">类型</h4>
                <div class="row row1 scroll-pane">

                    <div class="col col-4">

                        <div class="checkbox checkbox-info">
                            <input type="radio" name="type" id="type1" value="option3">
                            <label for="type1">
                                CPU
                            </label>
                        </div>

                        <div class="checkbox checkbox-info">
                            <input type="radio" name="type" id="type2" value="option3">
                            <label for="type2">
                                显卡
                            </label>
                        </div>

                        <div class="checkbox checkbox-info">
                            <input type="radio" name="type" id="type3" value="option2" checked>
                            <label for="type3">
                                内存
                            </label>
                        </div>


                    </div>
                </div>
            </section>
            <section  class="sky-form">
                <h4 class="cate">品牌</h4>
                <div class="row row1 scroll-pane">

                    <div class="col col-4">
                        <div class="checkbox checkbox-warning">
                            <input type="radio" name="brand" id="brand1" value="option3">
                            <label for="brand1">
                                全部
                            </label>
                        </div>

                        <div class="checkbox checkbox-warning">
                            <input type="radio" name="brand" id="brand2" value="option3">
                            <label for="brand2">
                                英特尔
                            </label>
                        </div>

                        <div class="checkbox checkbox-warning">
                            <input type="radio" name="brand" id="brand3" value="option2" checked>
                            <label for="brand3">
                                华硕
                            </label>
                        </div>

                    </div>
                </div>
            </section>
        </div>
        <div class="clearfix"></div>
        <!--products-->

        <!--//products-->
        <!--brand-->
        <div class="container">
            <div class="brand">
                <div class="col-md-3 brand-grid">
                    <img src="../../ui/images/ic.png" class="img-responsive" alt="">
                </div>
                <div class="col-md-3 brand-grid">
                    <img src="../../ui/images/ic1.png" class="img-responsive" alt="">
                </div>
                <div class="col-md-3 brand-grid">
                    <img src="../../ui/images/ic2.png" class="img-responsive" alt="">
                </div>
                <div class="col-md-3 brand-grid">
                    <img src="../../ui/images/ic3.png" class="img-responsive" alt="">
                </div>
                <div class="clearfix"></div>
            </div>
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
                <a href="index.html"><img src="../../ui/images/log.png" alt=""></a>
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

<script src="../../ui/js/simpleCart.min.js"> </script>
<!-- slide -->
<script src="../../ui/js/bootstrap.min.js"></script>
<!--light-box-files -->
<script src="../../ui/js/jquery.chocolat.js"></script>
<link rel="stylesheet" href="../../ui/css/chocolat.css" type="text/css" media="screen" charset="utf-8">
<!--light-box-files -->
<script type="text/javascript" charset="utf-8">
    $(function() {
        $('a.picture').Chocolat();
    });
</script>
</body>
</html>