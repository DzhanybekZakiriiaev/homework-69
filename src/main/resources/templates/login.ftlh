<!DOCTYPE html>
<html lang=".lang">
<#import "/spring.ftl" as spring>
<head>
    <meta charset="UTF-8">
    <title><@spring.message "titleLogin"/></title>
    <link rel="stylesheet" type="text/css" href="../main.css">
</head>
<body>
<div class="container">
    <h1><@spring.message "titleLogin"/></h1>
    <form method="POST" action="/login">
        <input type="hidden" name="_csrf" value="${csrfToken}">
        <label for="username"><@spring.message "username"/></label>
        <input type="text" id="username" name="username">
        <br>
        <label for="password"><@spring.message "password"/></label>
        <input type="password" id="password" name="password">
        <br>
        <button type="submit"><@spring.message "login"/></button>
    </form>
</div>
</body>
</html>
