<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Book</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <div class="container" style="max-width: 600px;">
        <header>
            <h1>Edit Book</h1>
        </header>

        <form action="/books/edit/${book.id}" method="post">
            <div class="form-group">
                <label for="title">Title</label>
                <input type="text" id="title" name="title" value="${book.title}" required>
            </div>

            <div class="form-group">
                <label for="genre">Genre</label>
                <input type="text" id="genre" name="genre" value="${book.genre}" required>
            </div>

            <div class="form-group">
                <label for="price">Price ($)</label>
                <input type="number" step="0.01" id="price" name="price" value="${book.price}" required>
            </div>

            <div class="form-group">
                <label for="authorId">Author</label>
                <select id="authorId" name="authorId" required>
                    <c:forEach var="author" items="${authors}">
                        <option value="${author.id}" ${author.id == book.author.id ? 'selected' : ''}>
                            ${author.name}
                        </option>
                    </c:forEach>
                </select>
            </div>

            <div style="margin-top: 2rem; display: flex; gap: 1rem;">
                <button type="submit" class="btn btn-primary">Update Book</button>
                <a href="/books" class="btn btn-outline">Cancel</a>
            </div>
        </form>
    </div>
</body>
</html>
