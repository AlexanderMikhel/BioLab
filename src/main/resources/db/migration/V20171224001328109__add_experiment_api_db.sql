create table if not exists directories(
  id BIGSERIAL primary key,
  name character varying,
  parent_directory_id BIGINT,
  created_at timestamp without time zone DEFAULT now(),
  updated_at timestamp without time zone,
  deleted_at timestamp without time zone,
  user_id INTEGER,
  CONSTRAINT fk_directories_to_users FOREIGN KEY (user_id)
  REFERENCES users (id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE if NOT EXISTS files(
  id                 bigSERIAL  PRIMARY KEY,
  file_file_name     VARCHAR(255),
  file_content_type  VARCHAR(255),
  file_file_size     INTEGER,
  created_at         TIMESTAMP,
  updated_at         TIMESTAMP,
  deleted_at         TIMESTAMP,
  directory_id       BIGINT,
  CONSTRAINT fk_files_to_directories FOREIGN KEY (directory_id)
  REFERENCES directories (id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE if NOT EXISTS user_file_storage(
  id                 BIGSERIAL   PRIMARY KEY,
  parent_directory_id       BIGINT,
  user_id INTEGER,
  CONSTRAINT fk_directories_to_users FOREIGN KEY (user_id)
  REFERENCES users (id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION
);

create TABLE IF NOT EXISTS functions(
  id serial primary key,
  name VARCHAR
);

create TABLE IF NOT EXISTS experiments
(
  id bigserial primary key,
  name VARCHAR,
  created_by_profile INTEGER,
  project_id BIGINT,
  created_at timestamp default now(),
  updated_at timestamp,
  deleted_at timestamp,
  CONSTRAINT fk_experiments_to_profiles FOREIGN KEY (created_by_profile)
  REFERENCES profiles (id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_experiments_to_projects FOREIGN KEY (project_id)
  REFERENCES projects (id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION
);


create table IF NOT EXISTS algorithms
(
  id bigserial  primary key,
  experiment_id bigint,
  algorithm_item_id bigint,
  order integer,
  created_at timestamp default now(),
  deleted_at timestamp,
  CONSTRAINT fk_algorithms_to_experiments FOREIGN KEY (experiment_id)
  REFERENCES experiments (id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION
);


create TABLE IF NOT EXISTS algorithm_items(
  id bigserial primary key,
  function_id integer,
  result_ids bigint[],
  order INTEGER,
  CONSTRAINT fk_algorithm_items_to_functions FOREIGN KEY (function_id)
  REFERENCES functions (id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION
);




