<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Password Reset</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-pzjw8f+uaB9LWPEO/QYzWbqQDV5yOiG6H9JwvqwTpX2u/i+FhB6ab8foHkLxg5g9"
          crossorigin="anonymous">
    <style>
        body {
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        .token-container {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <h2 class="text-center mb-4">Password Reset</h2>
            <div class="token-container">
                <h4>Your Reset Token:</h4>
                <p class="text-primary">${hashedToken}</p>
            </div>
            <form action="/password-reset" method="POST">
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <input type="hidden" name="email" value="${email}">
                <div class="form-group">
                    <label for="token">Token</label>
                    <input type="text" id="token" name="token" class="form-control" value="${hashedToken}" readonly>
                </div>
                <div class="form-group">
                    <label for="password">New Password</label>
                    <input type="password" id="password" name="password" class="form-control" required>
                </div>
                <div class="form-group">
                    <label for="confirmPassword">Confirm Password</label>
                    <input type="password" id="confirmPassword" name="confirmPassword" class="form-control" required>
                </div>
                <button type="submit" class="btn btn-primary">Reset Password</button>
            </form>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy5bsZ4YvHNuH5rqL7g4HQ6p4z3O+kX6EY4Dk1x"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"
        integrity="sha384-fJfvbiqtrGzCgj4CAwFGNWxVZ2on9GCwz/tb+F6KByCYchfnz+XbQQ3QyAfrtBXA"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>
