create table memos (
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    memo_name VARCHAR(30) NOT NULL,
    content VARCHAR(10000),
    group_id BIGINT
);
create table users (
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(20) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(500) NOT NULL
);
create table groups (
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    group_name VARCHAR(20) NOT NULL
);
create table membership (
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT NOT NULL,
    group_id BIGINT NOT NULL
);