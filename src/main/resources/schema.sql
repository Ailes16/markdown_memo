create table memos (
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    memo_name VARCHAR(30) NOT NULL,
    content VARCHAR(2000),
    group_id BIGINT
);
create table groups (
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    group_name VARCHAR(20) NOT NULL
);