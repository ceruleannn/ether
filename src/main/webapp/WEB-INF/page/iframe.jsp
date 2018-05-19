<%@ page language="java" pageEncoding="UTF-8"
         contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <link type="text/css" rel="stylesheet" href="../../ui/css/area.css"/>
    <link type="text/css" rel="stylesheet" href="../../ui/css/serach.css"/>
    <script src="/admin/js/vue.js"></script>
    <script src="/ui/js/jquery.min.js"></script>

    <style>
        .brand-c {
            color: #ff0000 !important;
        }

        .type-c {
            color: #ff0000 !important;
        }

        .order-c {
            border-color: #e4393c !important;
            background: #e4393c !important;
            color: #FFF !important;
        }
        .arrow-c{
            background-position: 0 -120px !important;
        }
        .arrow-top-c{
            background-position: -10px -120px !important;
        }

        .arrow-bottom-c{
            background-position: -10px -130px !important;
        }


    </style>

</head>
<body>
<div class="jdjd">
    <div id="J_selector" class="selector">
        <div class="J_selectorLine s-brand">
            <div class="sl-wrap">
                <div class="sl-key"><strong>类型：</strong></div>
                <div class="sl-value">

                    <div class="clr"></div>
                    <div class="sl-v-list">
                        <ul class="J_valueList">
                            <li style="display: block">
                                <a id="tall" class="type-c" title="所有分类" href="javascript:void(0)" onclick="load(this)"><i></i>所有分类</a>
                            </li>
                            <c:forEach var="type" items="${requestScope.types}">
                                <li style="display: block">
                                    <a id="t${type.tid}" title="${type.name}" href="javascript:void(0)"
                                       onclick="load(this)"><i></i>${type.name}</a>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>


                </div>

            </div>
        </div>
        <div class="J_selectorLine s-category">
            <div class="sl-wrap">
                <div class="sl-key"><strong>品牌：</strong></div>
                <div class="sl-value">
                    <div class="sl-v-list">
                        <ul class="J_valueList">
                            <li>
                                <a id="ball" class="brand-c" title="所以品牌" href="javascript:void(0)"
                                   onclick="load(this)"><i></i>所有品牌</a>
                            </li>
                            <c:forEach var="brand" items="${requestScope.brands}">
                                <li>
                                    <a id="b${brand.bid}" title="${brand.name}" href="javascript:void(0)"
                                       onclick="load(this)"><i></i>${brand.name}</a>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>

                </div>

            </div>
        </div>

    </div>

    <div class="filter" id="J_filter">
        <div class="f-line top">
            <div class="f-sort">
                <a href="javascript:;" class="order-c" onclick="order(this,1)">
                    <span class="fs-tit">综合</span><em
                        class="fs-down"><i class="arrow arrow-c"></i></em>

                </a><a href="javascript:;" class=""
                       onclick="order(this,2)"><span
                    class="fs-tit">销量</span><em class="fs-down"><i class="arrow"></i></em></a><a href="javascript:;"
                                                                                                 class=""
                                                                                                 onclick="order(this,3)"><span
                    class="fs-tit">新品</span><em class="fs-down"><i class="arrow"></i></em></a><a href="javascript:;"
                                                                                                 class=""
                                                                                                 onclick="order(this,4)"><span
                    class="fs-tit">价格</span><em class="fs-up"><i class="arrow-top"></i><i class="arrow-bottom"></i></em></a>
            </div>

            <div id="J_selectorPrice" class="f-price">
                <div class="f-price-set">
                    <div class="fl"><input id="price1" type="text" class="input-txt" autocomplete="off"
                                           style="color:#ccc" value="">
                    </div>
                    <em>-</em>
                    <div class="fl"><input id="price2" type="text" class="input-txt" autocomplete="off"
                                           style="color:#ccc" value="">
                    </div>
                </div>

            </div>
            <div class="f-sort">
                <a href="javascript:;" class="" onclick="search()">
                    <span class="fs-tit">确定</span>
                </a>
            </div>
            <div id="J_topPage" class="f-pager"><span class="fp-text"><b>1</b><em>/</em><i>100</i></span><a
                    class="fp-prev disabled" href="javascript:;">&lt;</a><a class="fp-next" onclick="search()"
                                                                            href="javascript:;"
                                                                            title="使用方向键右键也可翻到下一页哦！">&gt;</a>
            </div>
            <div class="f-result-sum">共<span id="J_resCount" class="num">4.3万+</span>件商品</div>

            <span class="clr"></span>
        </div>
    </div>

    <div id="J_goodsList" class="goods-list-v2 gl-type-1 J-goods-list">

        <ul class="gl-warp clearfix" data-tpl="1">

            <li  class="gl-item">
                <div class="gl-i-wrap">
                    <div class="p-img">
                        <a target="_blank" title="请根据自己需求选择套装版本；内存外观颜色随机发货" href="//item.jd.com/27742385280.html"
                           onclick="">
                            <img width="220" height="220" class="err-product" data-img="1"
                                 src="//img10.360buyimg.com/n7/jfs/t18652/355/2150048593/313361/9adb461/5ae6e88bNe6b96e75.jpg">
                        </a>
                    </div>
                    <div class="p-price">
                        <strong class="J_27742385280" data-done="1"><em>￥</em><i>2214.00</i></strong></div>
                    <div class="p-name p-name-type-2">
                        <a target="_blank" href="//item.jd.com/27742385280.html">
                            INTEL 酷睿i3 8100盒装处理器
                        </a>
                    </div>
                    <div class="p-commit">
                        <strong>销量：<a>2200</a></strong>
                    </div>

                    <div class="p-operate">
                        <a class="p-o-btn addcart"
                           href=""
                           target="_blank"><i></i>加入购物车</a>
                    </div>
                </div>
            </li>

        </ul>
        <span class="clr"></span>
    </div>
</div>
</body>
</html>

<script type="text/javascript">
    var vue = new Vue({
        el: '#J_goodsList',
        data: {products: []},
        methods: {
            add: function (data) {
                this.products = data;
            }
        }
    });

    var tid = 'all';
    var bid = 'all';
    var orderby = '';
    
    var order = function (obj,index) {
        $('.order-c').removeClass("order-c");
        $('.arrow-c').removeClass("arrow-c");
        $(obj).addClass('order-c');

        if (index!==4){
            $(obj).find('i').addClass('arrow-c');
            $('.arrow-bottom').removeClass('arrow-bottom-c');
            $('.arrow-top').removeClass('arrow-top-c');
        }

        if (index===1){
            orderby = 'sales';
        }else if (index===2){
            orderby = 'sales';
        }else if (index===3){
            orderby = 'time';
        }else if (index===4){
            var $em = $(obj).find('em');

            if ($em.hasClass('fs-down')){
                $em.removeClass('fs-down');
                $em.addClass('fs-up');

                $em.find('.arrow-bottom').removeClass('arrow-bottom-c');
                $em.find('.arrow-top').addClass('arrow-top-c');

                orderby = 'priceAsc';
            }else {
                $em.removeClass('fs-up');
                $em.addClass('fs-down');

                $em.find('.arrow-top').removeClass('arrow-top-c');
                $em.find('.arrow-bottom').addClass('arrow-bottom-c');

                orderby = 'priceDesc';
            }
        }
        search();
    };

    var load = function (obj) {

        var id = obj.id;
        if (id.charAt(0) === 't') {

            $(".type-c").removeClass("type-c");

            tid = id.substring(1, id.length);
            $(obj).addClass('type-c');


        } else if (id.charAt(0) === 'b') {
            $(".brand-c").removeClass("brand-c");

            bid = id.substring(1, id.length);
            $(obj).addClass('brand-c');
        }

        search();
    };

    function search() {
        var type = tid;
        var brand = bid;
        var price1 = $("#price1").val();
        var price2 = $("#price2").val();
        var order = orderby;
        var limit = 0;

        var data = {type: type, brand: brand, price1: price1, price2: price2, order: order, limit: limit};
        $.get('/p//list.do', data, function (data) {
            vue.add(data);
        }, 'json');

    }


</script>