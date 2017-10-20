CREATE TABLE article (
  id INTEGER NOT NULL IDENTITY,
  title VARCHAR(256) NOT NULL,
  label VARCHAR(64) NOT NULL,
  text LONGVARCHAR NOT NULL,
  created_date TIMESTAMP NOT NULL,
  modified_date TIMESTAMP NOT NULL,
  author_id INT NOT NULL,
  PRIMARY KEY (id));
CREATE TABLE author (
  id INTEGER NOT NULL IDENTITY,
  name VARCHAR(64) NOT NULL,
  email VARCHAR(64) NOT NULL,
  created_date TIMESTAMP NOT NULL,
  PRIMARY KEY (id));

CREATE TRIGGER create_article BEFORE INSERT ON article
 REFERENCING NEW AS newrow 
 FOR EACH ROW WHEN (newrow.created_date IS NULL)
 SET newrow.created_date = NOW(), newrow.modified_date = NOW()

CREATE TRIGGER update_article BEFORE UPDATE ON article
 REFERENCING NEW AS newrow 
 FOR EACH ROW SET newrow.modified_date = NOW()

CREATE TRIGGER create_author BEFORE INSERT ON author
 REFERENCING NEW AS newrow
 FOR EACH ROW WHEN (newrow.created_date is NULL)
 SET newrow.created_date = NOW()