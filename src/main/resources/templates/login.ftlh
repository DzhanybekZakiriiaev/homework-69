<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${titleLogin}</title>
    <link rel="stylesheet" type="text/css" href="../main.css">
</head>
<body>
<div class="container">
    <h1>${titleLogin}</h1>
    <form method="POST" action="/login">
        <input type="hidden" name="_csrf" value="${csrfToken}">
        <label for="username">${username}</label>
        <input type="text" id="username" name="username">
        <br>
        <label for="password">${password}</label>
        <input type="password" id="password" name="password">
        <br>
        <button type="submit">${login}</button>
    </form>
</div>
</body>
</html>
