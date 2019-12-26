CREATE SEQUENCE hibernate_sequence START 1 INCREMENT 1;

CREATE TABLE checklist (
  id       INT8 NOT NULL,
  filename VARCHAR(255),
  name     VARCHAR(255),
  user_id  INT8,
  PRIMARY KEY (id)
);

CREATE TABLE list_element (
  id           INT8 NOT NULL,
  comment      VARCHAR(255),
  element      VARCHAR(255),
  checklist_id INT8,
  PRIMARY KEY (id)
);

CREATE TABLE user_role (
  user_id INT8 NOT NULL,
  roles   VARCHAR(255)
);

CREATE TABLE usr (
  id              INT8    NOT NULL,
  activation_code VARCHAR(255),
  active          BOOLEAN NOT NULL,
  email           VARCHAR(255),
  password        VARCHAR(255) NOT NULL ,
  username        VARCHAR(255) NOT NULL ,
  PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS checklist
  ADD CONSTRAINT checklist_user_fk FOREIGN KEY (user_id) REFERENCES usr;

ALTER TABLE IF EXISTS list_element
  ADD CONSTRAINT list_element_checklist_fk FOREIGN KEY (checklist_id) REFERENCES checklist;

ALTER TABLE IF EXISTS user_role
  ADD CONSTRAINT user_role_user_fk FOREIGN KEY (user_id) REFERENCES usr;