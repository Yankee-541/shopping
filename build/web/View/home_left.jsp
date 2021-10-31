<%-- 
    Document   : home_left
    Created on : Oct 18, 2021, 9:57:09 PM
    Author     : Tebellum
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-sm-3">
    <div class="card bg-light mb-3">
        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
        <ul class="list-group category_block">
            <c:forEach items="${requestScope.allCate}" var="c">
                <li class="list-group-item text-white ${requestScope.cate_id == c.cid?"active":""}"><a href="category?cid=${c.cid}">${c.cname}</a></li>
            </c:forEach>

        </ul>
    </div>
    <div class="card bg-light mb-3">
        <div class="card-header bg-success text-white text-uppercase">Last product</div>
        <div class="card-body">
            <img class="img-fluid" src="${requestScope.productLast.image}" />
            <h5 class="card-title">${requestScope.productLast.name}</h5>
            <p class="card-text">${requestScope.productLast.tittle}</p>
            <p class="bloc_left_price">${requestScope.productLast.price} $</p>
        </div>
    </div>
</div>
