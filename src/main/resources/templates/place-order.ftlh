<!DOCTYPE html>
<html>
<head>
    <title>${title}</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
    <style>
        body {
            padding: 20px;
        }
        .form-control {
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<h1 class="text-center">${title}</h1>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <form action="/cart/place-order" method="POST">
                <div class="mb-3">
                    <label for="delivery">${delivery}</label>
                    <input type="text" id="delivery" name="delivery" class="form-control" required>
                </div>
                <button type="submit" class="btn btn-primary">${place_order}</button>
            </form>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
