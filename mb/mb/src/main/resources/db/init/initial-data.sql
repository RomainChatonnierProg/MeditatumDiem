CREATE SEQUENCE roles_id_seq START 1;

INSERT INTO role(id, name) VALUES(nextval('roles_id_seq'), 'ROLE_USER');
INSERT INTO role(id, name) VALUES(nextval('roles_id_seq'), 'ROLE_MODERATOR');
INSERT INTO role(id, name) VALUES(nextval('roles_id_seq'), 'ROLE_ADMIN');
