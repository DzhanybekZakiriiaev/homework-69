<!DOCTYPE html>
<html lang="en">
<#import "/spring.ftl" as spring>
<head>
    <meta charset="UTF-8">
    <title><@spring.message "titleLogout"/></title>
    <link rel="stylesheet" type="text/css" href="../main.css">
</head>
<body>
<div class="container">
    <h1><@spring.message "titleLogout"/></h1>
    <form method="POST" action="/logout">
        <input type="hidden" name="_csrf" value="${csrfToken}">
        <p><@spring.message "confirmation"/></p>
        <button type="submit"><@spring.message "logout"/></button>
    </form>
</div>
</body>
</html>
