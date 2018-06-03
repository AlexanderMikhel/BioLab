create table if not exists visibility(
  id serial primary key,
  name character varying
);

create table if not exists directories(
  id serial primary key,
  name character varying,
  parent_directory_id INTEGER,
  created_at timestamp without time zone DEFAULT now(),
  updated_at timestamp without time zone,
  deleted_at timestamp without time zone,
  visibility_id INTEGER,
  user_id INTEGER,
  CONSTRAINT fk_directories_to_users FOREIGN KEY (user_id)
  REFERENCES users (id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_directories_to_visibility FOREIGN KEY (visibility_id)
  REFERENCES visibility (id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE if NOT EXISTS attachments(
  id                 SERIAL NOT NULL
    CONSTRAINT attachments_pkey
    PRIMARY KEY,
  file_file_name     VARCHAR(255),
  file_content_type  VARCHAR(255),
  file_file_size     INTEGER,
  created_at         TIMESTAMP,
  updated_at         TIMESTAMP,
  deleted_at         TIMESTAMP,
  directory_id       INTEGER,
  CONSTRAINT fk_directories_to_directories FOREIGN KEY (directory_id)
  REFERENCES directories (id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION
);

ALTER TABLE spectra_data DROP COLUMN profile_id CASCADE;
ALTER TABLE spectra_data add COLUMN directory_id INTEGER;
ALTER TABLE spectra_data add CONSTRAINT fk_spectra_to_directories FOREIGN KEY (directory_id)
  REFERENCES directories (id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION;

INSERT INTO visibility(name) VALUES ('private'),('public');

