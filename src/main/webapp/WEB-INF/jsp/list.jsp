<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Library Catalog</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <div class="container">
        <header class="action-bar">
            <h1>Library Catalog</h1>
            <a href="/books/add" class="btn btn-primary">+ Add New Book</a>
        </header>

        <table>
            <thead>
                <tr>
                    <th>Title</th>
                    <th>Genre</th>
                    <th>Price</th>
                    <th>Author</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="book" items="${books}">
                    <tr>
                        <td>
                            <div style="font-weight: 600;">${book.title}</div>
                        </td>
                        <td><span class="badge">${book.genre}</span></td>
                        <td>$${book.price}</td>
                        <td>
                            <div style="font-weight: 500;">${book.author.name}</div>
                            <div class="author-info">${book.author.biography}</div>
                        </td>
                        <td>
                            <a href="/books/edit/${book.id}" class="btn btn-outline" style="padding: 0.4rem 0.8rem; font-size: 0.85rem;">Edit</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
