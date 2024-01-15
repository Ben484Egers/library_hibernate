DROP SCHEMA library_db;
CREATE SCHEMA library_db;
USE library_db;

CREATE TABLE `authors` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `image_path` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `series` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `books` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`isbn` varchar(255) NOT NULL,
	`title` varchar(255) NOT NULL,
	`serie_id` bigint DEFAULT NULL,
	`description` varchar(255) NOT NULL,
	`image_path` varchar(255) NOT NULL,
	`release_date` date  NOT NULL,
	`genre` varchar(20) NOT NULL,
	`copies` int NOT NULL,
	`available_copies` int NOT NULL,
	`language` varchar(20) NOT NULL,
	PRIMARY KEY (`id`),
	UNIQUE KEY `UK_bookISBN` (`isbn`),
    KEY `FK_serieId` (`serie_id`),
	CONSTRAINT `FK_serieId` FOREIGN KEY (`serie_id`) REFERENCES `series` (`id`),
	CHECK (`genre` IN ('Horror', 'Drama', 'Scifi', 'Romance', 'Thriller', 'Comedy')),
	CHECK (`language` IN ('Nederlands', 'English', 'Español'))
);


CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `dob` date NOT NULL,
  `address` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `role` varchar(20) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone_number` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_email` (`email`),
  CHECK (`role` IN ('User', 'Admin', 'Super_Admin'))
);

CREATE TABLE `loan_receipt` (
	`id` bigint NOT NULL AUTO_INCREMENT,
    `book_id` bigint NOT NULL,
	`user_id` bigint NOT NULL,
	`borrow_date` date NOT NULL,
    `return_date` date NULL,
	`actual_return_date` date,
	`ticket_number` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_bookId` (`book_id`),
  KEY `FK_userId` (`user_id`),
  CONSTRAINT `FK_bookId` FOREIGN KEY (`book_id`) REFERENCES `books` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FK_userId` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
);

CREATE TABLE `book_author` (
  `book_id` bigint NOT NULL,
  `author_id` bigint,
  KEY `FK_bookId` (`book_id`),
  KEY `FK_authorId` (`author_id`),
  CONSTRAINT `FK_bookAuthorId` FOREIGN KEY (`book_id`) REFERENCES `books` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FK_authorId` FOREIGN KEY (`author_id`) REFERENCES `authors` (`id`)
);



INSERT IGNORE INTO authors(first_name, last_name, image_path, email)
VALUES
  ('Alice', 'Oseman', 'library-back-end\\src\\main\\resources\\images\\Alice-Oseman.jpg', 'aoseman@mail.com'),
  ('Colleen', 'Hoover', 'library-back-end\\src\\main\\resources\\images\\Colleen-Hoover.jpg', 'choover@mail.com'),
  ('Sally', 'Rooney', 'library-back-end\\src\\main\\resources\\images\\Sally-Rooney.jpg', 'srooney@mail.com'),
  ('J.R.R', 'Tolkien', 'src\\main\\resources\\images\\J._R._R._Tolkien.png', 'tolkien@mail.com'),
  ('J.K', 'Rowling', 'library-back-end\\src\\main\\resources\\images\\jk-rowling.jpg', 'jrowling@mail.com'),
  ('E.L', 'James', 'library-back-end\\src\\main\\resources\\images\\el-james.jpg', 'ejames@mail.com'),
  ('Rick', 'Riordan', 'library-back-end\\src\\main\\resources\\images\\rick-riordan.jpg', 'rriordan@mail.com');

INSERT IGNORE INTO books(title, ISBN, description, image_path, release_date, copies, available_copies, genre, language)
VALUES
  ("Loveless", "9780008244125", "It was all sinking in. I’d never had a crush on anyone. No boys, no girls, not a single person I had ever met. What did that mean?", "src/main/resources/images/loveless.png", "2020-07-09", 1, 0, "Comedy", "English"),
  ("Normal People", "9781984822178", "At school Connell and Marianne pretend not to know each other. He’s popular and well-adjusted, star of the school soccer team while she is lonely, proud, and intensely private.", "src/main/resources/images/normal-people.png", "2018-08-28", 2, 1, "Drama", "English"),
  ("It Ends With Us", "1501110365", "Lily hasn’t always had it easy, but that’s never stopped her from working hard for the life she wants. She’s come a long way from the small town in Maine where she grew up — she graduated from college, moved to Boston, and started her own business.", "src/main/resources/images/It-ends-with us.png", "2016-02-29", 1, 0, "Drama", "English");


INSERT IGNORE INTO book_author(book_id, author_id)
VALUES
	(1, 1),
	(2, 3),
	(3, 2);

INSERT IGNORE INTO users(first_name, last_name, email, password, address, phone_number, dob, role)
VALUES
  ("Benjamin", "Eagers", "benji@mail.com", "7890", "driestraat", "597-33", "1998-08-10", "User"),
  ("Test", "Test acc", "test@testlo.com", "12345", "Teststraat #404", "597-79089", "1904-5-10", "Admin"),
  ("Test", "Test acc 2", "test2@test.com", "12345", "Teststraat #405", "597-79089", "1904-5-10", "Admin");


INSERT IGNORE INTO loan_receipt(book_id, user_id, borrow_date, return_date, ticket_number)
VALUES
  (1, 1, "2023-12-05", "2023-12-19", "AB11"),
  (3, 2, "2023-12-03", "2023-12-17", "AB12"),
  (2, 3, "2023-12-08", "2023-12-22", "AB13");


INSERT IGNORE INTO series(id, title)
VALUES
	(1, 'Harry Potter'),
	(2, 'Lord of the Rings'),
	(3, 'Percy Jackson'),
	(4, 'Fifty Shades');

INSERT IGNORE INTO books(title, ISBN, description, image_path, release_date, genre, copies, available_copies, language, serie_id)
VALUES
  ("Fifty Shades of Grey", "2221", "something", "src\\main\\resources\\images\\grey.png", "2011-06-20", "Romance", 3, 2, "Español", 4),
  ("Fifty Shades Darker", "2222", "something", "src\\main\\resources\\images\\darker.png", "2011-09-16", "Romance", 1, 0, "Español", 4),
  ("Fifty Shades Freed", "2224", "something", "src\\main\\resources\\images\\freed.png", "2012-04-17", "Romance", 1, 1, "Español", 4),
  ("Harry Potter and The Sorcerer's Stone", "2233", "you're a wizard, Harry", "src\\main\\resources\\images\\sorcers-stone.png", "1997-06-27", "Horror", 2, 1, "English", 1),
  ("Harry Potter and The Chamber of Secrets", "3344", "you're a wizard, Harry", "src\\main\\resources\\images\\chamber-secrets.png", "1998-07-02", "Horror", 1, 1, "English", 1),
  ("Harry Potter and The Prisoner of Azkaban", "4455", "you're a wizard, Harry", "src/main/resources/images/prisoner.png", "1999-07-08", "Horror", 1, 1, "English", 1),
  ("Harry Potter and The Goblet of Fire", "5566", "you're a wizard, Harry", "src\\main\\resources\\images\\goblet-fire.png", "2000-07-08", "Horror", 1, 1, "English", 1),
  ("Harry Potter and The Order of the Phoenix", "6677", "you're a wizard, Harry", "src\\main\\resources\\images\\phoenix.png", "2003-06-21", "Horror", 1, 1, "English", 1),
  ("Harry Potter and The Half-Blood Prince", "7788", "your're a wizard, Harry", "src\\main\\resources\\images\\prince.png", "2005-07-16", "Horror", 1, 1, "English", 1),
  ("Harry Potter and The Deathly Hallows", "8899", "you're a wizard, Harry", "src\\main\\resources\\images\\hallows.png", "2007-07-21", "Horror", 1, 1, "English", 1),
  ("The Sea of Monsters", "9900", "something", "src\\main\\resources\\images\\monsters.png", "2006-04-01", "Thriller", 2, 2, "English", 3),
  ("The Titan's Curse", "0011", "something", "src\\main\\resources\\images\\titan.png", "2007-05-01", "Thriller", 1, 1, "English", 3),
  ("The Battle of The Labyrinth", "1122", "something", "src\\main\\resources\\images\\battle.png", "2008-05-06", "Thriller", 2, 2, "English", 3),
  ("The Last Olympian", "2223", "something", "src\\main\\resources\\images\\olympian.png", "2009-05-05", "Thriller", 1, 1, "English", 3),
  ("The Hobbit", "2225", "something", "src\\main\\resources\\images\\hobbit.png", "1937-09-21", "Drama", 1, 1, "Nederlands", 2),
  ("The Fellowship of The Ring", "2226", "something", "src\\main\\resources\\images\\fellowship.png", "1954-07-29", "Drama", 1, 1, "Nederlands", 2),
  ("The Two Towers", "2227", "something", "src\\main\\resources\\images\\towers.png", "1954-11-11", "Drama", 1, 1, "Nederlands", 2),
  ("The Return of The King", "2228", "something", "src\\main\\resources\\images\\king.png", "1955-10-20", "Drama", 1, 1, "Nederlands", 2),
  ("The Silmarillion", "2229", "something", "src\\main\\resources\\images\\silmarillion.png", "1977-09-15", "Drama", 1, 1, "Nederlands", 2),
  ("Unfinished Tales of Numenor & Middle-Earth", "2220", "something", "src\\main\\resources\\images\\tales.png", "1980-07-10", "Drama", 1, 1, "Nederlands", 2);

INSERT IGNORE INTO book_author(book_id, author_id)
VALUES
  (4, 6),
  (5, 6),
  (6, 6);



INSERT IGNORE INTO book_author(book_id, author_id)
VALUES
  (7, 5),
  (8, 5),
  (9, 5),
  (10, 5),
  (11, 5),
  (12, 5),
  (13, 5);

INSERT IGNORE INTO book_author(book_id, author_id)
VALUES
  (18, 4),
  (19, 4),
  (20, 4),
  (21, 4),
  (22, 4),
  (23, 4);

INSERT IGNORE INTO book_author(book_id, author_id)
VALUES
  (14, 7),
  (15, 7),
  (16, 7),
  (17, 7);

INSERT IGNORE INTO loan_receipt(book_id, user_id, borrow_date, return_date, ticket_number)
VALUES
  (7, 3, "2024-01-01", "2024-01-15", "AB14"),
  (7, 1, "2024-01-02", "2024-01-16", "AB15"),
  (7, 2, "2024-01-03", "2024-01-17", "AB16"),
  (4, 1, "2024-01-04", "2024-01-18", "AB17"),
  (4, 3, "2024-01-04", "2024-01-18", "AB18"),
  (5, 2, "2024-01-04", "2024-01-18", "AB18");



