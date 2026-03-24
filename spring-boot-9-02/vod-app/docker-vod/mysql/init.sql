CREATE TABLE `shop`
(
    `id`   int          NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    `logo` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `producer`
(
    `id`        int          NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `supplement`
(
    `id`          int          NOT NULL AUTO_INCREMENT,
    `name`      varchar(255) NOT NULL,
    `flavor`       varchar(255) NOT NULL,
    `producer_id` int   DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `supplement_shop`
(
    `supplement_id`  int DEFAULT NULL,
    `shop_id` int DEFAULT NULL
);

INSERT INTO `shop`(`id`, `logo`, `name`)
VALUES (1, 'https://photos05.redcart.pl/templates/images/description/6187/Image/1623418596-kfd-logo.png', 'KFD');
INSERT INTO `shop`(`id`, `logo`, `name`)
VALUES (2, 'https://galeriamlociny.pl/app/uploads/wayfinder/url_logo/3225.png', 'SFD');
INSERT INTO `shop`(`id`, `logo`, `name`)
VALUES (3, 'https://strefagladiatorow.pl/userdata/public/producers/69.jpg', 'Strefa Gladiatorow');

INSERT INTO `producer`(`id`, `name`)
VALUES (1, 'KFD');
INSERT INTO `producer`(`id`, `name`)
VALUES (2, 'SFD');
INSERT INTO `producer`(`id`, `name`)
VALUES (3, 'Olimp');

INSERT INTO `supplement`(`id`, `name`, `flavor`, `producer_id`)
VALUES (1, 'Kreatyna', 'Malina', 1);
INSERT INTO `supplement`(`id`, `name`, `flavor`, `producer_id`)
VALUES (2, 'Cytrulina', 'Truskawka', 1);
INSERT INTO `supplement`(`id`, `name`, `flavor`, `producer_id`)
VALUES (3, 'Kolagen', 'Cytrusowy', 1);
INSERT INTO `supplement`(`id`, `name`, `flavor`, `producer_id`)
VALUES (4, 'Witamina d3', 'bezsmakowe', 2);
INSERT INTO `supplement`(`id`, `name`, `flavor`, `producer_id`)
VALUES (5, 'Witamina b12', 'bezsmakowe', 2);
INSERT INTO `supplement`(`id`, `name`, `flavor`, `producer_id`)
VALUES (6, 'Omega3', 'bezsmakowe', 3);
INSERT INTO `supplement`(`id`, `name`, `flavor`, `producer_id`)
VALUES (7, 'Selen+Cynk', 'bezsmakowe', 3);

INSERT INTO `supplement_shop`(`supplement_id`, `shop_id`)
VALUES (1, 1);
INSERT INTO `supplement_shop`(`supplement_id`, `shop_id`)
VALUES (1, 3);
INSERT INTO `supplement_shop`(`supplement_id`, `shop_id`)
VALUES (2, 3);
INSERT INTO `supplement_shop`(`supplement_id`, `shop_id`)
VALUES (3, 1);
INSERT INTO `supplement_shop`(`supplement_id`, `shop_id`)
VALUES (3, 2);
INSERT INTO `supplement_shop`(`supplement_id`, `shop_id`)
VALUES (4, 1);
INSERT INTO `supplement_shop`(`supplement_id`, `shop_id`)
VALUES (4, 3);
INSERT INTO `supplement_shop`(`supplement_id`, `shop_id`)
VALUES (5, 2);
INSERT INTO `supplement_shop`(`supplement_id`, `shop_id`)
VALUES (5, 3);
INSERT INTO `supplement_shop`(`supplement_id`, `shop_id`)
VALUES (6, 1);
INSERT INTO `supplement_shop`(`supplement_id`, `shop_id`)
VALUES (7, 2);
















CREATE TABLE user
(
    id       int primary key auto_increment,
    username VARCHAR(255),
    password VARCHAR(255)
);

CREATE TABLE role
(
    id       int primary key auto_increment,
    username VARCHAR(255),
    role     VARCHAR(255)
);

INSERT INTO user(username, password)
VALUES ('dbuser1', '$2a$10$eiA5dKnoUk77EKXZhJvq7O3XBy5ECYupA0FCEm0gS58QSY6PoPcOS'),
       ('dbuser2', '$2a$10$eiA5dKnoUk77EKXZhJvq7O3XBy5ECYupA0FCEm0gS58QSY6PoPcOS'),
       ('dbuser3', '$2a$10$eiA5dKnoUk77EKXZhJvq7O3XBy5ECYupA0FCEm0gS58QSY6PoPcOS');


INSERT INTO role(username, role)
VALUES ('dbuser1', 'USER_ADMIN'),
       ('dbuser2', 'AUTHOR_ADMIN'),
       ('dbuser3', 'BOOK_ADMIN');




