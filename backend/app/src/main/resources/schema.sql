-- DROP TABLE IF EXISTS good;
-- DROP TABLE IF EXISTS comment;
-- DROP TABLE IF EXISTS post;
-- DROP TABLE IF EXISTS follow;
-- DROP TABLE IF EXISTS profile;
-- DROP TABLE IF EXISTS account;

CREATE TABLE IF NOT EXISTS account(
    userId SERIAL NOT NULL,
    mailAddress VARCHAR(31),
    password VARCHAR(31),
    PRIMARY KEY (userId)
);

CREATE TABLE IF NOT EXISTS profile(
    userId INT NOT NULL,
    userName VARCHAR(15),
    prof_img BYTEA,
    followingNumber INT,
    followerNumber INT,
    postNumber INT,
    PRIMARY KEY (userId),
    FOREIGN KEY (userId) REFERENCES account
);

CREATE TABLE IF NOT EXISTS follow(
    followId SERIAL NOT NULL,
    userId INT NOT NULL,
    followedUserId INT NOT NULL,
    PRIMARY KEY (followId),
    FOREIGN KEY (userId) REFERENCES account
);

CREATE TABLE IF NOT EXISTS post(
    postId SERIAL NOT NULL,
    content VARCHAR(511),
    post_img BYTEA,
    datetime TIMESTAMP(0),
    latitude NUMERIC(5,2),
    longtitude NUMERIC(5,2),
    userId INT NOT NULL,
    PRIMARY KEY (postId),
    FOREIGN KEY (userId) REFERENCES account
);

CREATE TABLE IF NOT EXISTS comment(
    commentId SERIAL NOT NULL,
    postId INT NOT NULL,
    userId INT NOT NULL,
    content VARCHAR(511),
    datetime TIMESTAMP(0),
    PRIMARY KEY (commentId),
    FOREIGN KEY (postId) REFERENCES post,
    FOREIGN KEY (userId) REFERENCES account
);

CREATE TABLE IF NOT EXISTS good(
    goodId SERIAL NOT NULL,
    userId INT NOT NULL,
    postId INT NOT NULL,
    PRIMARY KEY (goodId),
    FOREIGN KEY (userId) REFERENCES account,
    FOREIGN KEY (postId) REFERENCES post
);
