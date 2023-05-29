create table users
(
    id       serial
        primary key,
    name     text not null,
    email    text not null,
    username text not null
);

create table reviews
(
    id               serial primary key,
    description      text,
    description_time timestamp,
    user_id          integer not null,
    foreign key (user_id) references users (id) on delete cascade,
    product_id       integer not null,
    foreign key (product_id) references products (id) on delete cascade
);

CREATE TABLE IF NOT EXISTS orders (
                                      id SERIAL PRIMARY KEY,
                                      delivery TEXT NOT NULL,
                                      price INTEGER NOT NULL,
                                      order_time TIMESTAMP NOT NULL,
                                      user_id INTEGER NOT NULL,
                                      product_id INTEGER NOT NULL,
                                      FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (product_id) REFERENCES products(id)
    );

