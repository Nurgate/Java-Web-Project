USE mywebproject;

INSERT INTO roles (id, name)
VALUES (1, 'ADMIN');
INSERT INTO roles (id, name)
VALUES (2, 'USER');

INSERT INTO users(`id`, `email`, `first_name`, `gender`, `last_name`, `password`, `username`)
VALUES ('1', 'admin@admin.com', 'Nuridin', 'Male', 'Kisyov', '123456', 'ndkisyov');