/**
 *  Spring Boot runs schema-@@platform@@.sql automatically during startup. -all is the default for all platforms.
 * 
 */
DROP TABLE IF EXISTS users;


CREATE TABLE users
(
  id integer NOT NULL,
  user_login character(100),
  user_pass character(100),
  age integer,
  CONSTRAINT "PK_USER" PRIMARY KEY (id)
)