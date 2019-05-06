DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS subjects CASCADE;
DROP TABLE IF EXISTS assignments CASCADE;


CREATE TABLE users
(
    userId   serial PRIMARY KEY,
    name     VARCHAR(40),
    email    VARCHAR(40),
    password VARCHAR(40),
    role     BOOLEAN
);


CREATE TABLE subjects
(
    subjectId   serial PRIMARY KEY,
    title       VARCHAR(40),
    content     TEXT,
    isPublished BOOLEAN
);

CREATE TABLE assignments
(
    assignmentId serial PRIMARY KEY,
    title       VARCHAR(40),
    content     TEXT,
    maxScore    INT,
    isPublished BOOLEAN
);


INSERT INTO users(userId, name, email, password, role)
VALUES (1, 'Pinaszaggatoh', 'lhofstadter@caltech.edu', 'Lalivagyok69', true);
INSERT INTO users(userId, name, email, password, role)
VALUES (2, 'Sheldon Cooper', 'lhofstadter@caltech.edu', 'SheldonCooper123', false);
INSERT INTO users(userId, name, email, password, role)
VALUES (3, 'Howard Wolovitz', 'lhofstadter@caltech.edu', 'HowardWoloviz123', false);
INSERT INTO users(userId, name, email, password, role)
VALUES (4, 'Raj Koothrappali', 'lhofstadter@caltech.edu', 'RajKoothrappali123', false);
INSERT INTO users(userId, name, email, password, role)
VALUES (5, 'Penny', 'lhofstadter@caltech.edu', 'Penny1234', false);
INSERT INTO users(userId, name, email, password, role)
VALUES (6, 'Bernadette Rostenkowski', 'lhofstadter@caltech.edu', 'BernadetteRostenkowski123', false);
INSERT INTO users(userId, name, email, password, role)
VALUES (7, 'Amy Farrah Fowler', 'lhofstadter@caltech.edu', 'AmyFarrahFowler123', false);


INSERT INTO subjects(subjectId, title, content, isPublished)
VALUES (1, 'Berta',
        'Helpful, Goddess of Java, bitten by a radioactive computer, coding abilities give her amazing powers she uses tu help others',
        true);
INSERT INTO subjects(subjectId, title, content, isPublished)
VALUES (2, 'Captain Marvel',
        'After an alien device mutated her DNA, Danvers transformed from a merely brilliant pilot into one of the most powerful Super Heroes in the universe. Now soaring among the stars, Carol Danvers is known as Captain Marvel!',
        true);
INSERT INTO subjects(subjectId, title, content, isPublished)
VALUES (3, 'Thanos',
        'The Mad Titan Thanos quests across the universe in search of the Infinity Stones, intending to use their limitless power for shocking purposes.',
        true);
INSERT INTO subjects(subjectId, title, content, isPublished)
VALUES (4, 'Spider-Man',
        'Bitten by a radioactive spider, Peter Parker’s arachnid abilities give him amazing powers he uses to help others, while his personal life continues to offer plenty of obstacles.',
        true);
INSERT INTO subjects(subjectId, title, content, isPublished)
VALUES (5, 'Iron Man',
        'Genius. Billionaire. Playboy. Philanthropist. Tony Starks confidence is only matched by his high-flying abilities as the hero called Iron Man.',
        true);
INSERT INTO subjects(subjectId, title, content, isPublished)
VALUES (6, 'Captain America',
        'Recipient of the Super-Soldier serum, World War II hero Steve Rogers fights for American ideals as one of the world’s mightiest heroes and the leader of the Avengers.',
        true);
INSERT INTO subjects(subjectId, title, content, isPublished)
VALUES (7, 'Hulk',
        'Dr. Bruce Banner lives a life caught between the soft-spoken scientist he’s always been and the uncontrollable green monster powered by his rage.',
        true);
INSERT INTO subjects(subjectId, title, content, isPublished)
VALUES (8, 'Black Widow',
        'Despite super spy Natasha Romanoff’s checkered past, she’s become one of S.H.I.E.L.D.’s most deadly assassins and a frequent member of the Avengers.',
        true);
INSERT INTO subjects(subjectId, title, content, isPublished)
VALUES (9, 'Thor',
        'The son of Odin uses his mighty abilities as the God of Thunder to protect his home Asgard and planet Earth alike.',
        true);
INSERT INTO subjects(subjectId, title, content, isPublished)
VALUES (10, 'Hawkeye',
        'A master marksman and longtime friend of Black Widow, Clint Barton serves as the Avengers’ amazing archer.',
        true);
INSERT INTO subjects(subjectId, title, content, isPublished)
VALUES (11, 'Yondu',
        'Adventurer and natural mystic, Yondu wields a mighty bow with Yaka arrows that move according to his whistles. ',
        true);
INSERT INTO subjects(subjectId, title, content, isPublished)
VALUES (12, 'Rocket',
        'As the weapons and tactical expert of the Guardians of the Galaxy, Rocket risks his hide to defend the cosmos.',
        true);


