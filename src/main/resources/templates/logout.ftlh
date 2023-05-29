<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${titleLogout}</title>
    <link rel="stylesheet" type="text/css" href="../main.css">
</head>
<body>
<div class="container">
    <h1>${titleLogout}</h1>
    <form method="POST" action="/logout">
        <input type="hidden" name="_csrf" value="${csrfToken}">
        <p>${confirmation}</p>
        <button type="submit">${logout}</button>
    </form>
</div>
</body>
</html>
