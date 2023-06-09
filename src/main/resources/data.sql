INSERT INTO users (address, birth_date, email, first_name, last_name, password, phone_number, role)
    VALUES ('admincim', DATE '1999-11-11', 'admin', 'Admin', 'Aladár',
    '$2a$10$mISTa3.0QLR6PzNofrIAUeuo3hJf/p5Tc91DiLGLmy0QQPHSmj5me', '0000000', 'ADMIN');

INSERT INTO users (address, birth_date, email, first_name, last_name, password, phone_number, role)
    VALUES ('Budafoki út 12.', DATE '1989-01-01', 'vpisti@mail.com', 'István', 'Várhelyi',
    '$2a$10$mISTa3.0QLR6PzNofrIAUeuo3hJf/p5Tc91DiLGLmy0QQPHSmj5me', '01234567', 'INTERNAL');

INSERT INTO users (address, birth_date, email, first_name, last_name, password, phone_number, role)
    VALUES ('Petőfi út 12.', DATE '1999-01-01', 'vmiska@mail.com', 'Mihály', 'Tóth',
    '$2a$10$mISTa3.0QLR6PzNofrIAUeuo3hJf/p5Tc91DiLGLmy0QQPHSmj5me', '01234567', 'INTERNAL');

INSERT INTO hotels (name, address, image_url) VALUES ('Rubin Hotel', 'Dayka Gábor utca 2.', 'rubin_kep.jpg');
INSERT INTO hotels (name, address, image_url) VALUES ('Mariott Hotel', 'Apáczai Csere János u. 4', 'mariott_kep.jpg');

INSERT INTO advertisements (title, description, country, city, image_url)
    VALUES ('Barangolás az Alpok mélyén', 'Nyaraljon a világ legszebb vidékén, az Alpokban',
    'Ausztria', 'Salzburg', 'alpok.img');

INSERT INTO advertisements (title, description, country, city, image_url)
    VALUES ('Tengerpart és napsütés Krétán', 'Élvezze a napsütést az ókori görög kultúra bölcsőjében',
    'Görögország', 'Hanía', 'kreta.img');