CREATE TABLE IF NOT EXISTS users (
  id          SERIAL PRIMARY KEY,
  first_name  CHARACTER VARYING,
  middle_name CHARACTER VARYING,
  last_name   CHARACTER VARYING,
  created_at  TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW(),
  updated_at  TIMESTAMP WITHOUT TIME ZONE,
  deleted_at  TIMESTAMP WITHOUT TIME ZONE
);

CREATE TABLE IF NOT EXISTS roles (
  id         SERIAL PRIMARY KEY,
  name       CHARACTER VARYING,
  title      CHARACTER VARYING,
  created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW(),
  updated_at TIMESTAMP WITHOUT TIME ZONE,
  deleted_at TIMESTAMP WITHOUT TIME ZONE
);

CREATE TABLE IF NOT EXISTS projects (
  id         SERIAL PRIMARY KEY,
  name       CHARACTER VARYING,
  created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW(),
  updated_at TIMESTAMP WITHOUT TIME ZONE,
  deleted_at TIMESTAMP WITHOUT TIME ZONE
);

CREATE TABLE IF NOT EXISTS science_group (
  id         SERIAL PRIMARY KEY,
  name       CHARACTER VARYING,
  project_id INTEGER,
  created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW(),
  updated_at TIMESTAMP WITHOUT TIME ZONE,
  deleted_at TIMESTAMP WITHOUT TIME ZONE,
  CONSTRAINT fk_science_group_to_projects FOREIGN KEY (project_id)
  REFERENCES projects (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION

);

CREATE TABLE IF NOT EXISTS agencies (
  id               SERIAL PRIMARY KEY,
  name             CHARACTER VARYING,
  address          CHARACTER VARYING,
  phone            CHARACTER VARYING,
  country          CHARACTER VARYING,
  city             CHARACTER VARYING,
  science_group_id INTEGER,
  created_at       TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW(),
  updated_at       TIMESTAMP WITHOUT TIME ZONE,
  deleted_at       TIMESTAMP WITHOUT TIME ZONE,
  CONSTRAINT fk_agencies_to_science_group FOREIGN KEY (science_group_id)
  REFERENCES science_group (id)
  MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION
);


CREATE TABLE IF NOT EXISTS profiles (
  id         SERIAL PRIMARY KEY,
  name       CHARACTER VARYING,
  login      CHARACTER VARYING,
  password   CHARACTER VARYING,
  user_id    INTEGER,
  agency_id  INTEGER,
  created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW(),
  updated_at TIMESTAMP WITHOUT TIME ZONE,
  deleted_at TIMESTAMP WITHOUT TIME ZONE,
  CONSTRAINT fk_profiles_to_users FOREIGN KEY (user_id)
  REFERENCES users (id)
  MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_profiles_to_agencies FOREIGN KEY (agency_id)
  REFERENCES agencies (id)
  MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS profile_science_group (
  profile_id       INTEGER,
  science_group_id INTEGER,
  created_at       TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW(),
  updated_at       TIMESTAMP WITHOUT TIME ZONE,
  deleted_at       TIMESTAMP WITHOUT TIME ZONE,
  CONSTRAINT fk_profile_science_group_to_profiles FOREIGN KEY (profile_id)
  REFERENCES profiles (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_profile_science_group_to_scienceGroup FOREIGN KEY (science_group_id)
  REFERENCES science_group (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS profile_role (
  profile_id INTEGER,
  role_id    INTEGER,
  created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW(),
  updated_at TIMESTAMP WITHOUT TIME ZONE,
  deleted_at TIMESTAMP WITHOUT TIME ZONE,
  CONSTRAINT fk_profile_role_to_profiles FOREIGN KEY (profile_id)
  REFERENCES profiles (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_profile_role_to_roles FOREIGN KEY (role_id)
  REFERENCES roles (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS project_profile (
  project_id INTEGER,
  profile_id INTEGER,
  created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW(),
  updated_at TIMESTAMP WITHOUT TIME ZONE,
  deleted_at TIMESTAMP WITHOUT TIME ZONE,
  CONSTRAINT fk_project_profile_to_projects FOREIGN KEY (project_id)
  REFERENCES projects (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_project_profile_to_profiles FOREIGN KEY (profile_id)
  REFERENCES profiles (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION
);
