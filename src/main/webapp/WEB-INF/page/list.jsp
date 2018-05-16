<%@ page language="java" pageEncoding="UTF-8"
         contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
<head>

    <base href="${pageContext.request.contextPath}" />

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

    <script src="https://cdn.bootcss.com/vue/2.3.3/vue.min.js"></script>


    <!--<link href="css/form.css" rel="stylesheet" type="text/css" media="all" />-->
    <link href="http://cdn.bootcss.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet">
    <link href="../../ui/css/build.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>

<!--header-->
<div class="header">
    <div class="container">
        <div class="head">
            <div class=" logo">
                <a href="/index"><img src="../../ui/images/logo.png" alt=""></a>
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

                            <li><a class="color4" href="/p/list?type=1">CPU</a></li>
                            <li><a class="color3" href="/p/list?type=3">内存</a></li>
                            <li><a class="color4" href="/p/list?type=2">显卡</a></li>
                            <li><a class="color5" href="/p/list?type=4">硬盘</a></li>
                            <li><a class="color6" href="/p/list?type=5"></a></li>
                            <li><a class="color3" href="/p/list?type=1">新闻</a></li>

                        </ul>
                    </div><!-- /.navbar-collapse -->

                </nav>
            </div>
            <div class="col-sm-2 search-right">

                <div class="cart box_1">
                    <a href="/c/checkout">
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
                <div id="list">
                    <div v-for="product in products">

                    <div class="col-md-4 item-grid1 simpleCart_shelfItem">
                        <div class=" mid-pop">
                            <div class="pro-img">
                                <img :src="product.pic1" class="img-responsive" alt="">
                                <div class="zoom-icon ">
                                    <a class="picture" :href="product.pic1" rel="title" class="b-link-stripe b-animate-go  thickbox"><i class="glyphicon glyphicon-search icon "></i></a>
                                    <a v-bind:href="'/p/detail/' + product.pid"><i class="glyphicon glyphicon-menu-right icon"></i></a>
                                </div>
                            </div>
                            <div class="mid-1">
                                <div class="women">
                                    <div class="women-top">
                                        <span>{{product.brand.name}}</span>
                                        <h6><a v-bind:href="'/p/detail/' + product.pid" >{{product.name}}</a></h6>
                                    </div>
                                    <div class="img item_add">
                                        <a href="#"><img src="../../ui/images/ca.png" alt=""></a>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="mid-2">
                                    <p ><em class="item_price">¥{{product.price}}</em></p>
                                    <div class="block">
                                        <div class="starbox small ghosting"> </div>
                                    </div>

                                    <div class="clearfix"></div>
                                </div>

                            </div>
                        </div>
                    </div>

                    </div>
                </div>



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
                            <input type="radio" name="order" id="radio9" value="sales">
                            <label for="radio9">
                                按销量升序
                            </label>
                        </div>

                        <div class="checkbox checkbox-success">
                            <input type="radio" name="order" id="radio10" value="sales2">
                            <label for="radio10">
                                按销量降序
                            </label>
                        </div>

                        <div class="checkbox checkbox-success">
                            <input type="radio" name="order" id="radio11" value="price">
                            <label for="radio11">
                                按价格升序
                            </label>
                        </div>
                        <div class="checkbox checkbox-success">
                            <input type="radio" name="order" id="radio12" value="price2">
                            <label for="radio12">
                                按价格降序
                            </label>
                        </div>

                        <div class="checkbox checkbox-success">
                            <input type="radio" name="order" id="radio13" value="time" checked>
                            <label for="radio13">
                                按时间升序
                            </label>
                        </div>
                        <div class="checkbox checkbox-success">
                            <input type="radio" name="order" id="radio14" value="time2" checked>
                            <label for="radio14">
                                按时间降序
                            </label>
                        </div>



                    </div>
                </div>
            </section>
            <section  class="sky-form">
                <h4 class="cate">类型</h4>
                <div class="row row1 scroll-pane">

                    <div class="col col-4">

                        <div class="checkbox checkbox-info">
                            <input type="radio" name="tid" id="type1" value="1" <c:if test="${requestScope.type==1}" >checked</c:if> >
                            <label for="type1">
                                CPU
                            </label>
                        </div>

                        <div class="checkbox checkbox-info">
                            <input type="radio" name="tid" id="type2" value="2" <c:if test="${requestScope.type==2}" >checked</c:if> >
                            <label for="type2">
                                显卡
                            </label>
                        </div>

                        <div class="checkbox checkbox-info">
                            <input type="radio" name="tid" id="type3" value="3" <c:if test="${requestScope.type==3}" >checked</c:if>  >
                            <label for="type3">
                                内存
                            </label>
                        </div>

                        <div class="checkbox checkbox-info">
                            <input type="radio" name="tid" id="type4" value="4" <c:if test="${requestScope.type==4}" >checked</c:if>  >
                            <label for="type4">
                                硬盘
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
                            <input type="radio" name="bid" id="brand1" value="all" checked>
                            <label for="brand1">
                                全部
                            </label>
                        </div>

                        <div class="checkbox checkbox-warning">
                            <input type="radio" name="bid" id="brand2" value="5">
                            <label for="brand2">
                                英特尔
                            </label>
                        </div>

                        <div class="checkbox checkbox-warning">
                            <input type="radio" name="bid" id="brand3" value="2" >
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

<script type="text/javascript">

    var vue = new Vue({
        el: '#list',
        data: {products: []},
        methods: {
            add: function (data) {
                this.products = data;
            }
        }
    });

    $(document).ready(function () {
        function ajaxJson(url,method,data,possessMethod){
            $.ajax({
                url: url,
                type: method,
                data: data,
                dataType: 'json',
                success: function(data){
                    possessMethod(data);
                },
                error: function(data){
                    alert("err"+data);
                }
            });
        }

        var $_radio = $("input[type='radio']");
        $_radio.change(function(){

            var order = $("input[name='order']:checked").val();
            var tid = $("input[name='tid']:checked").val();
            var bid = $("input[name='bid']:checked").val();

            var data = 'tid='+tid+'&bid='+bid+'&order='+order;
            ajaxJson('/p/list.do','GET',data,processProduct);

        });

        function processProduct(data) {
            vue.add(data);
        }

        $("#type1").change();
    })

</script>