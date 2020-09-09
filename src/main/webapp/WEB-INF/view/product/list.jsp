<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <style>
        a {
            color: white;
            text-decoration: none;
        }
    </style>
    <title>Product Management Application</title>
</head>
<body>
<h1 align="center">Product Management</h1>
<table>
    <tr>
        <td><h3 align="left">
            <button type="button" class="btn btn-primary"><a href="/products?action=create">+Add New Product</a></button>
        </h3></td>
        <td ><form method="post" action="/products?action=search">
            <div align="right">
                <input type="text" id="nameSearch" name="nameSearch" placeholder="search by name">
                <button type="submit" class="btn btn-primary">Search</button>
            </div>
        </form></td>
    </tr>
</table>

<div align="center">
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Product Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Color</th>
            <th>Description</th>
            <th>Category</th>
            <th>Action</th>
        </tr>
        <c:forEach var="product" items="${listProduct}">
            <tr>
                <td><c:out value="${product.id}"/></td>
                <td><c:out value="${product.productName}"/></td>
                <td><c:out value="${product.price}"/></td>
                <td><c:out value="${product.quantity}"/></td>
                <td><c:out value="${product.color}"/></td>
                <td><c:out value="${product.productDescription}"/></td>
                <td><c:out value="${product.category}"/></td>

                <td>
                    <button type="button" class="btn btn-primary"><a href="?action=edit&id=${product.id}">Edit</a>
                    </button>
                    <button type="button" class="btn btn-primary" onclick="myConfirm()"><a href="?action=delete&id=${product.id}">Delete</a>
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
    <script>
        function myConfirm(){
            confirm("Are you sure want to delete?")
        }
    </script>
</div>
</body>
</html>