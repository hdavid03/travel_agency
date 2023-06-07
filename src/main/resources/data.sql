INSERT INTO roles (role) VALUES ('USER');
INSERT INTO roles (role) VALUES ('ADMIN');
INSERT INTO roles (role) VALUES ('INTERNAL');

INSERT INTO users (address, birth_date, email, first_name, last_name, password, phone_number)
    VALUES ('admincim', DATE '1999-11-11', 'admin', 'Admin', 'Aladár',
    '$2a$10$mISTa3.0QLR6PzNofrIAUeuo3hJf/p5Tc91DiLGLmy0QQPHSmj5me', '0000000');

INSERT INTO users (address, birth_date, email, first_name, last_name, password, phone_number)
    VALUES ('Budafoki út 12.', DATE '1989-01-01', 'vpisti@mail.com', 'István', 'Várhelyi',
    '$2a$10$mISTa3.0QLR6PzNofrIAUeuo3hJf/p5Tc91DiLGLmy0QQPHSmj5me', '01234567');