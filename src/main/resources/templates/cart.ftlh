<!DOCTYPE html>
<html>
<#import "/spring.ftl" as spring>
<head>
    <title><@spring.message "titleCart"/></title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
    <style>
        body {
            padding: 20px;
        }
        .product-card {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<form action="" method="get">
    <label for="lang_select">
        <@spring.message "language"/>:
    </label>
    <select name="lang" id="lang_select">
        <option value="en">English</option>
        <option value="ru">Russian</option>
    </select>
    <button type="submit">
        <@spring.message "choose" />
    </button>
</form>

<h1 class="text-center"><@spring.message "titleCart"/></h1>
<div class="row">
    <#list cart.products as product>
        <div class="col-md-4">
            <div class="card product-card">
                <img src="../images/${product.image}" class="card-img-top" alt="Product Image">
                <div class="card-body">
                    <h5 class="card-title">${product.name}</h5>
                    <p class="card-text">${product.description}</p>
                    <p class="card-text"><@spring.message "price"/>: $${product.price}</p>
                    <form action="/cart/remove" method="POST">
                        <input type="hidden" name="_csrf" value="${csrfToken}">
                        <input type="hidden" name="productId" value="${product.id}">
                        <button type="submit" class="btn btn-danger"><@spring.message "removeFromCart"/></button>
                    </form>
                </div>
            </div>
        </div>
    </#list>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>