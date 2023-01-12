INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Alex', 'Brown', 'alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Maria', 'Green', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_CLIENT');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);

INSERT INTO tb_category (name) VALUES ('Horror');
INSERT INTO tb_category (name) VALUES ('Adventure');

INSERT INTO tb_book (author, name, price, edition, img_Url) VALUES ('Stephen King', 'IT', 80.0, 1, 'https://d3525k1ryd2155.cloudfront.net/f/025/813/9780670813025.OL.0.m.jpg');
INSERT INTO tb_book (author, name, price, edition, img_Url) VALUES ('J.R.R Tolkien', 'The Hobbit', 50.0, 1, 'https://m.media-amazon.com/images/I/51x4uqq3M4L._SY344_BO1,204,203,200_QL70_ML2_.jpg');

INSERT INTO tb_book_category VALUES (1,1);
INSERT INTO tb_book_category VALUES (2,1);
INSERT INTO tb_book_category VALUES (2,2);