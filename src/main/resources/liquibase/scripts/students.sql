--liquibase formatted sql
--changeset student : 1
CREATE INDEX users_index ON users (user);

--liquibase formatted sql
--changeset student : 2
CREATE INDEX name_and_color_index ON users (name, color);