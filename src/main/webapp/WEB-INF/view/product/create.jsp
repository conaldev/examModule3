<%--
  Created by IntelliJ IDEA.
  User: conal
  Date: 08/09/2020
  Time: 23:47
  To change this template use File | Settings | File Templates.
--%>
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
<center>
    <h1>Add New Product</h1>
    <h2>
        <button type="button" class="btn btn-primary"><a href="/products">Back</a></button>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <tr>
                <th>Product Name:</th>
                <td>
                    <input type="text" name="productName" id="productName" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Price:</th>
                <td>
                    <input type="text" name="price" id="price" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Quantity:</th>
                <td>
                    <input type="number" name="quantity" id="quantity" size="45"/>
                </td>
            </tr> <tr>
                <th>Color:</th>
                <td>
                    <input type="text" name="color" id="color" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Product Description:</th>
                <td>
                    <input type="text" name="productDescription" id="productDescription" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Category:</th>
                <td><select id="category" name ="category" style="width: 300px">

<%--                    <c:forEach var="category" items="${categories}">--%>
<%--                    <option value="<c:out value="${category}"/>"><c:out value="${category}"/></option>--%>
<%--                        </c:forEach>--%>
                    <option value="Phone">Phone</option>
                    <option value="Ipad">Ipad</option>
                    <option value="Laptop" selected>Laptop</option>
                    <option value="Television">Television</option>
                </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
