CREATE TABLE IF NOT EXISTS `cart` (
                                         id SERIAL PRIMARY KEY,
                                         user_id INTEGER NOT NULL,
                                         product_id INTEGER NOT NULL,
                                         FOREIGN KEY (user_id) REFERENCES `users`(id),
    FOREIGN KEY (product_id) REFERENCES `product`(product_id)
    );
