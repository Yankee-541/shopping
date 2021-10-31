<%-- 
    Document   : upload_product
    Created on : Oct 29, 2021, 10:45:21 PM
    Author     : Tebellum
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
       <head>
              <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
              <title>JSP Page</title>
              <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
              <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
              <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
              <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
              <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
              <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
              <link href="css/manager.css" rel="stylesheet" type="text/css"/>
       </head>
       <body>
              <form action="uploadProduct" method="POST"> 
                     <div class="modal-dialog">
                            <div class="modal-content">
                                   <div class="modal-header">						
                                          <h4 class="modal-title">Edit Employee</h4>
                                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                   </div>
                                   <div class="modal-body">					
                                          <div class="form-group">
                                                 <label>ID</label><br>
                                                 <input name="id" type="text" readonly required class="form-control" value="${requestScope.pid}">
                                          </div>
                                          <div class="form-group">
                                                 <label>Name</label>
                                                 <input name="name" type="text" class="form-control" value="${requestScope.detailproduct.name}">
                                          </div>
                                          <div class="form-group">
                                                 <label>Price</label>
                                                 <input name="price" type="Price" class="form-control" required value="${requestScope.detailproduct.price}">
                                          </div>
                                          <div class="form-group">
                                                 <label>Imagin</label>
                                                 <textarea name="imagin" class="form-control" required>${requestScope.detailproduct.image}</textarea>
                                          </div>
                                          <div class="form-group">
                                                 <label>Tittle</label>
                                                 <input name="tittle" type="text" class="form-control" required value="${requestScope.detailproduct.tittle}">
                                          </div>
                                          <div class="form-group">
                                                 <label>Description</label>
                                                 <input name="Description" type="text" class="form-control" required value="${requestScope.detailproduct.description}">
                                          </div>
                                          <b>Category</b><br>
                                          <select name="category" class="form-select">
                                                 <c:forEach items="${requestScope.allCate}" var="c">
                                                        <option  value="${c.cid}" >${c.cname}</option>
                                                 </c:forEach>
                                          </select>
                                   </div>
                                   <div class="modal-footer">
                                          <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                                          <input type="submit" class="btn btn-info" value="Save">
                                   </div>
                            </div>
                     </div>
              </form>
              <script src="js/manager.js" type="text/javascript"></script>

       </body>
</html>
