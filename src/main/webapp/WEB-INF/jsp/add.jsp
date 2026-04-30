<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add New Book</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <div class="container" style="max-width: 600px;">
        <header>
            <h1>Add New Book</h1>
        </header>

        <form action="/books/add" method="post">
            <div class="form-group">
                <label for="title">Title</label>
                <input type="text" id="title" name="title" required placeholder="Enter book title">
            </div>

            <div class="form-group">
                <label for="genre">Genre</label>
                <input type="text" id="genre" name="genre" required placeholder="e.g. Fantasy, Mystery">
            </div>

            <div class="form-group">
                <label for="price">Price ($)</label>
                <input type="number" step="0.01" id="price" name="price" required placeholder="0.00">
            </div>

            <div class="form-group">
                <label for="authorId">Author</label>
                <select id="authorId" name="authorId" required>
                    <option value="" disabled selected>Select an author</option>
                    <c:forEach var="author" items="${authors}">
                        <option value="${author.id}">${author.name}</option>
                    </c:forEach>
                </select>
            </div>

            <div style="margin-top: 2rem; display: flex; gap: 1rem;">
                <button type="submit" class="btn btn-primary">Save Book</button>
                <a href="/books" class="btn btn-outline">Cancel</a>
            </div>
        </form>
    </div>
</body>
</html>
