-- Creare tabela users
DROP TABLE USERS;
CREATE TABLE USERS(user_id NUMBER(10, 0) PRIMARY KEY,
                     first_name VARCHAR2(32) NOT NULL,
                     last_name VARCHAR2(32) NOT NULL,
                     birthDate DATE NOT NULL);
/
-- Creare tabela credentials
DROP TABLE CREDENTIALS;
CREATE TABLE CREDENTIALS(credential_id NUMBER(10, 0) PRIMARY KEY,
						email VARCHAR2(64) UNIQUE,
						password VARCHAR2(64) NOT NULL);
/
-- Creare tabela login
DROP TABLE LOGIN;
CREATE TABLE LOGIN(id NUMBER(10, 0) PRIMARY KEY,
					user_id NUMBER(10, 0) UNIQUE,
					credential_id NUMBER(10, 0) UNIQUE,
					CONSTRAINT fk_login_user_id FOREIGN KEY (user_id) REFERENCES USERS(user_id),
					CONSTRAINT fk_login_credential_id FOREIGN KEY (credential_id) REFERENCES CREDENTIALS(credential_id));
/
-- Creare tabela artists
DROP TABLE ARTISTS;
CREATE TABLE ARTISTS(artist_id NUMBER(10, 0) PRIMARY KEY,
					name VARCHAR2(256),
					totalSongs NUMBER(10, 0),
					totalAlbums NUMBER(10, 0),
					nationality VARCHAR2(32));
/
-- Creare tabela songs
DROP TABLE SONGS;
CREATE TABLE SONGS(song_id NUMBER(10, 0) PRIMARY KEY,
					title VARCHAR2(256));
/
-- Creare tabela sangBy
DROP TABLE SANGBY;
CREATE TABLE SANGBY(id NUMBER(10, 0) PRIMARY KEY,
					song_id NUMBER(10, 0) UNIQUE,
					artist_id NUMBER(10, 0),
					CONSTRAINT fk_sangby_song_id FOREIGN KEY (song_id) REFERENCES SONGS(song_id),
					CONSTRAINT fk_sangby_artist_id FOREIGN KEY (artist_id) REFERENCES ARTISTS(artist_id));
/
-- Creare tabela genres
DROP TABLE GENRES;
CREATE TABLE GENRES(genre_id NUMBER(10, 0) PRIMARY KEY,
					genre_name VARCHAR2(256));
/
-- Creare tabela categorized
DROP TABLE CATEGORIZED;
CREATE TABLE CATEGORIZED(id NUMBER(10, 0) PRIMARY KEY,
					song_id NUMBER(10, 0) UNIQUE,
					genre_id NUMBER(10, 0),
					CONSTRAINT fk_categorized_song_id FOREIGN KEY (song_id) REFERENCES SONGS(song_id),
					CONSTRAINT fk_categorized_genre_id FOREIGN KEY (genre_id) REFERENCES GENRES(genre_id));
/
-- Creare tabela listened
DROP TABLE LISTENED;
CREATE TABLE LISTENED(id NUMBER(10, 0) PRIMARY KEY,
					user_id NUMBER(10, 0),
					song_id NUMBER(10, 0),
					noListenes NUMBER(10, 0),
					CONSTRAINT fk_listened_song_id FOREIGN KEY (song_id) REFERENCES SONGS(song_id),
					CONSTRAINT fk_listened_user_id FOREIGN KEY (user_id) REFERENCES USERS(user_id),
          CONSTRAINT no_listened_duplicates UNIQUE (user_id, song_id));
/
-- Creare tabela albums
DROP TABLE ALBUMS;
CREATE TABLE ALBUMS(album_id NUMBER(10, 0) PRIMARY KEY,
					title VARCHAR2(256),
					releaseYear NUMBER(4, 0),
					label VARCHAR2(32));
/
-- Creare tabela partof
DROP TABLE CONTAIN;
CREATE TABLE CONTAIN(id NUMBER(10, 0) PRIMARY KEY,
					song_id NUMBER(10, 0) UNIQUE,
					album_id NUMBER(10, 0),
					CONSTRAINT fk_contain_song_id FOREIGN KEY (song_id) REFERENCES SONGS(song_id),
					CONSTRAINT fk_contain_album_id FOREIGN KEY (album_id) REFERENCES ALBUMS(album_id));
/
-- Creare tabela friends
DROP TABLE FRIENDS;
CREATE TABLE FRIENDS(id NUMBER(10, 0) PRIMARY KEY,
					user_id1 NUMBER(10, 0),
					user_id2 NUMBER(10, 0),
					CONSTRAINT fk_user_id1 FOREIGN KEY (user_id1) REFERENCES USERS(user_id),
					CONSTRAINT fk_user_id2 FOREIGN KEY (user_id2) REFERENCES USERS(user_id),
          CONSTRAINT no_friends_dup UNIQUE (user_id1, user_id2));
/
					
					

					
