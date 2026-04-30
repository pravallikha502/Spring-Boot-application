<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Error</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <div class="container" style="max-width: 600px; text-align: center;">
        <header>
            <h1 style="border-left-color: var(--accent);">Something went wrong</h1>
        </header>

        <div class="alert">
            ${errorMessage}
        </div>

        <div style="margin-top: 2rem;">
            <a href="/books" class="btn btn-primary">Back to Catalog</a>
        </div>
    </div>
</body>
</html>
