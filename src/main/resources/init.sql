DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS subjects CASCADE;


CREATE TABLE users
(
    userId   VARCHAR(30) PRIMARY KEY,
    name     VARCHAR(40),
    email    VARCHAR(40),
    password VARCHAR(40),
    role     VARCHAR(10)
);


CREATE TABLE subjects
(
    subjectId   VARCHAR(30) PRIMARY KEY,
    title       VARCHAR(40),
    content     TEXT,
    isPublished BOOLEAN
);

CREATE TABLE assignment
(
    assignmentId   VARCHAR(30) PRIMARY KEY,
    title       VARCHAR(40),
    content     TEXT,
    maxScore    INT(3),
    isPublished BOOLEAN
);


INSERT INTO users(userId, name, email, password, role)
VALUES ('lali', 'Pinaszaggatoh', 'lhofstadter@caltech.edu', 'lalivagyok69', 'mentor');
INSERT INTO users(userId, name, email, password, role)
VALUES ('sheldon', 'Sheldon Cooper', 'lhofstadter@caltech.edu', 'SheldonCooper123', 'student');
INSERT INTO users(userId, name, email, password, role)
VALUES ('howard', 'Howard Wolovitz', 'lhofstadter@caltech.edu', 'HowardWoloviz123', 'student');
INSERT INTO users(userId, name, email, password, role)
VALUES ('raj', 'Raj Koothrappali', 'lhofstadter@caltech.edu', 'RajKoothrappali123', 'student');
INSERT INTO users(userId, name, email, password, role)
VALUES ('penny', 'Penny', 'lhofstadter@caltech.edu', 'Penny1234', 'student');
INSERT INTO users(userId, name, email, password, role)
VALUES ('bernadette', 'Bernadette Rostenkowski', 'lhofstadter@caltech.edu', 'BernadetteRostenkowski123', 'student');
INSERT INTO users(userId, name, email, password, role)
VALUES ('amy', 'Amy Farrah Fowler', 'lhofstadter@caltech.edu', 'AmyFarrahFowler123', 'student');


INSERT INTO subjects(subjectId, title, content, isPublished)
VALUES ('berta', 'Berta',
        'Helpful, Goddess of Java, bitten by a radioactive computer, coding abilities give her amazing powers she uses tu help others',
        true);
INSERT INTO subjects(subjectId, title, content, isPublished)
VALUES ('marvel', 'Captain Marvel',
        'After an alien device mutated her DNA, Danvers transformed from a merely brilliant pilot into one of the most powerful Super Heroes in the universe. Now soaring among the stars, Carol Danvers is known as Captain Marvel!',
        true);
INSERT INTO subjects(subjectId, title, content, isPublished)
VALUES ('thanos', 'Thanos',
        'The Mad Titan Thanos quests across the universe in search of the Infinity Stones, intending to use their limitless power for shocking purposes.',
        true);
INSERT INTO subjects(subjectId, title, content, isPublished)
VALUES ('spider', 'Spider-Man',
        'Bitten by a radioactive spider, Peter Parker’s arachnid abilities give him amazing powers he uses to help others, while his personal life continues to offer plenty of obstacles.',
        true);
INSERT INTO subjects(subjectId, title, content, isPublished)
VALUES ('iron', 'Iron Man',
        'Genius. Billionaire. Playboy. Philanthropist. Tony Starks confidence is only matched by his high-flying abilities as the hero called Iron Man.',
        true);
INSERT INTO subjects(subjectId, title, content, isPublished)
VALUES ('america', 'Captain America',
        'Recipient of the Super-Soldier serum, World War II hero Steve Rogers fights for American ideals as one of the world’s mightiest heroes and the leader of the Avengers.',
        true);
INSERT INTO subjects(subjectId, title, content, isPublished)
VALUES ('hulk', 'Hulk',
        'Dr. Bruce Banner lives a life caught between the soft-spoken scientist he’s always been and the uncontrollable green monster powered by his rage.',
        true);
INSERT INTO subjects(subjectId, title, content, isPublished)
VALUES ('widow', 'Black Widow',
        'Despite super spy Natasha Romanoff’s checkered past, she’s become one of S.H.I.E.L.D.’s most deadly assassins and a frequent member of the Avengers.',
        true);
INSERT INTO subjects(subjectId, title, content, isPublished)
VALUES ('thor', 'Thor',
        'The son of Odin uses his mighty abilities as the God of Thunder to protect his home Asgard and planet Earth alike.',
        true);
INSERT INTO subjects(subjectId, title, content, isPublished)
VALUES ('hawk', 'Hawkeye',
        'A master marksman and longtime friend of Black Widow, Clint Barton serves as the Avengers’ amazing archer.',
        true);
INSERT INTO subjects(subjectId, title, content, isPublished)
VALUES ('yondu', 'Yondu',
        'Adventurer and natural mystic, Yondu wields a mighty bow with Yaka arrows that move according to his whistles. ',
        true);
INSERT INTO subjects(subjectId, title, content, isPublished)
VALUES ('rocket', 'Rocket',
        'As the weapons and tactical expert of the Guardians of the Galaxy, Rocket risks his hide to defend the cosmos.',
        true);


