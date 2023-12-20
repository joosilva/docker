USE docker;

CREATE TABLE USER (
    USER_ID BIGINT AUTO_INCREMENT PRIMARY KEY ,
    USER_NAME VARCHAR(45) NOT NULL,
    USER_EMAIL VARCHAR(65) NOT NULL,
    USER_PASSWORD VARCHAR(255) NOT NULL,
    USER_TIPO VARCHAR(10) NOT NULL,
    USER_CREATED_IN TIMESTAMP,
    USER_UPDATED_IN TIMESTAMP
);