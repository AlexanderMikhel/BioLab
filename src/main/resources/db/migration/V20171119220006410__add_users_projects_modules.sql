create table if not exists users(
  id serial primary key,
  name character varying ,
  created_at timestamp without time zone DEFAULT now(),
  updated_at timestamp without time zone,
  deleted_at timestamp without time zone
);

create table if not exists profiles(
id serial primary key,
name character varying,
login character varying,
password character varying,
created_at timestamp without time zone DEFAULT now(),
updated_at timestamp without time zone,
deleted_at timestamp without time zone,
user_id INTEGER,
CONSTRAINT fk_profiles_to_users FOREIGN KEY (user_id)
REFERENCES users (id) MATCH SIMPLE
ON UPDATE NO ACTION ON DELETE NO ACTION
);

create table if not exists projects(
  id serial primary key,
  name character varying ,
  created_at timestamp without time zone DEFAULT now(),
  updated_at timestamp without time zone,
  deleted_at timestamp without time zone,
  user_id INTEGER,
  CONSTRAINT fk_projects_to_users FOREIGN KEY (user_id)
  REFERENCES users (id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION
);

create table if not exists modules(
  id serial primary key,
  name character varying ,
  created_at timestamp without time zone DEFAULT now(),
  updated_at timestamp without time zone,
  deleted_at timestamp without time zone,
  project_id INTEGER,
  CONSTRAINT fk_modules_to_projects FOREIGN KEY (project_id)
  REFERENCES projects (id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION
);

DROP INDEX IF EXISTS projects__user_id;
CREATE INDEX projects__user_id
  ON projects
  USING btree
  (user_id);


DROP INDEX IF EXISTS modules__project_id;
CREATE INDEX modules__project_id
  ON modules
  USING btree
  (project_id);
