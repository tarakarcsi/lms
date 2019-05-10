DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS subjects CASCADE;
DROP TABLE IF EXISTS assignments CASCADE;
DROP TABLE IF EXISTS attendance CASCADE;


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
    title       TEXT,
    content     TEXT,
    maxScore    INT,
    isPublished BOOLEAN
);

CREATE TABLE attendance
(
    currentDate TEXT,
    present VARCHAR(20),
    userId INT references users(userId)

);

INSERT INTO users(name, email, password, role)
VALUES ('Pinaszaggatoh', '1lhofstadter@caltech.edu', 'Lalivagyok69', true);
INSERT INTO users(name, email, password, role)
VALUES ('Sheldon Cooper', '2lhofstadter@caltech.edu', 'SheldonCooper123', false);
INSERT INTO users(name, email, password, role)
VALUES ('Howard Wolovitz', '3lhofstadter@caltech.edu', 'HowardWoloviz123', false);
INSERT INTO users(name, email, password, role)
VALUES ('Raj Koothrappali', '4lhofstadter@caltech.edu', 'RajKoothrappali123', false);
INSERT INTO users(name, email, password, role)
VALUES ('Penny', '5lhofstadter@caltech.edu', 'Penny1234', false);
INSERT INTO users(name, email, password, role)
VALUES ('Bernadette Rostenkowski', '6lhofstadter@caltech.edu', 'BernadetteRostenkowski123', false);
INSERT INTO users(name, email, password, role)
VALUES ('Amy Farrah Fowler', '7lhofstadter@caltech.edu', 'AmyFarrahFowler123', false);




INSERT INTO subjects(title, content, isPublished)
VALUES ('Berta',
        'Helpful, Goddess of Java, bitten by a radioactive computer, coding abilities give her amazing powers she uses tu help others',
        true);
INSERT INTO subjects(title, content, isPublished)
VALUES ('Captain Marvel',
        'After an alien device mutated her DNA, Danvers transformed from a merely brilliant pilot into one of the most powerful Super Heroes in the universe. Now soaring among the stars, Carol Danvers is known as Captain Marvel!',
        true);
INSERT INTO subjects(title, content, isPublished)
VALUES ('Thanos',
        'The Mad Titan Thanos quests across the universe in search of the Infinity Stones, intending to use their limitless power for shocking purposes.',
        true);
INSERT INTO subjects(title, content, isPublished)
VALUES ('Spider-Man',
        'Bitten by a radioactive spider, Peter Parker’s arachnid abilities give him amazing powers he uses to help others, while his personal life continues to offer plenty of obstacles.',
        true);
INSERT INTO subjects(title, content, isPublished)
VALUES ('Iron Man',
        'Genius. Billionaire. Playboy. Philanthropist. Tony Starks confidence is only matched by his high-flying abilities as the hero called Iron Man.',
        true);
INSERT INTO subjects(title, content, isPublished)
VALUES ('Captain America',
        'Recipient of the Super-Soldier serum, World War II hero Steve Rogers fights for American ideals as one of the world’s mightiest heroes and the leader of the Avengers.',
        true);
INSERT INTO subjects(title, content, isPublished)
VALUES ('Hulk',
        'Dr. Bruce Banner lives a life caught between the soft-spoken scientist he’s always been and the uncontrollable green monster powered by his rage.',
        true);
INSERT INTO subjects(title, content, isPublished)
VALUES ('Black Widow',
        'Despite super spy Natasha Romanoff’s checkered past, she’s become one of S.H.I.E.L.D.’s most deadly assassins and a frequent member of the Avengers.',
        true);
INSERT INTO subjects(title, content, isPublished)
VALUES ('Thor',
        'The son of Odin uses his mighty abilities as the God of Thunder to protect his home Asgard and planet Earth alike.',
        true);
INSERT INTO subjects(title, content, isPublished)
VALUES ('Hawkeye',
        'A master marksman and longtime friend of Black Widow, Clint Barton serves as the Avengers’ amazing archer.',
        true);
INSERT INTO subjects(title, content, isPublished)
VALUES ('Yondu',
        'Adventurer and natural mystic, Yondu wields a mighty bow with Yaka arrows that move according to his whistles. ',
        true);
INSERT INTO subjects(title, content, isPublished)
VALUES ('Rocket',
        'As the weapons and tactical expert of the Guardians of the Galaxy, Rocket risks his hide to defend the cosmos.',
        true);



INSERT INTO assignments (title, content, maxScore, isPublished)
VALUES ('Marvel era beginning?',
        'The Marvel era began in 1961', 80,
        true);
INSERT INTO assignments (title, content, maxScore, isPublished)
VALUES ('How many stand-alone Iron Man films are there?',
        '3', 10,
        true);
INSERT INTO assignments (title, content, maxScore, isPublished)
VALUES ('Can You Name The Actor Who Plays Thanos?',
        'Josh Brolin', 70,
        true);
INSERT INTO assignments (title, content, maxScore, isPublished)
VALUES ('Which Character Is Not An Avenger In The First Film?',
        'Falcon', 15,
        true);
INSERT INTO assignments (title, content, maxScore, isPublished)
VALUES ('Can You Name The Actor Who Plays Thanos?',
        'Josh Brolin', 60,
        true);
INSERT INTO assignments (title, content, maxScore, isPublished)
VALUES ('Who Is The Villain Of The First Avengers Film?',
        'Loki', 25,
        true);
INSERT INTO assignments (title, content, maxScore, isPublished)
VALUES ('Which Avenger Created Ultron?',
        'Iron Man', 35,
        true);
INSERT INTO assignments (title, content, maxScore, isPublished)
VALUES ('Who is Tony Stark based on?',
        'Howard Hughes', 95,
        true);
INSERT INTO assignments (title, content, maxScore, isPublished)
VALUES ('Which Avenger Does Loki Control In The First Avengers Film?',
        'Calcutta', 52,
        true);
INSERT INTO assignments (title, content, maxScore, isPublished)
VALUES ('How is Captain Marvel, who only gained a portion of the power of the Tesseract, stronger than Vision, who had all the powers of an Infinity Stone?',
        'Cuz Im Batmaaan', 100,
        true);
INSERT INTO assignments (title, content, maxScore, isPublished)
VALUES ('Which Character Left The Team In Age Of Ultron?',
        'Hulk', 97,
        true);
INSERT INTO assignments (title, content, maxScore, isPublished)
VALUES ('What does J.A.R.V.I.S. stand for?',
        'Just A Rather Very Intelligent System', 81,
        true);




