CREATE TABLE IF NOT EXISTS users (
  id          SERIAL PRIMARY KEY,
  first_name  CHARACTER VARYING,
  middle_name CHARACTER VARYING,
  last_name  CHARACTER VARYING,
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
);bioLab@localhost

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
  profile_id      INTEGER,
  science_group_id INTEGER,
  created_at      TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW(),
  updated_at      TIMESTAMP WITHOUT TIME ZONE,
  deleted_at      TIMESTAMP WITHOUT TIME ZONE,
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

DROP INDEX IF EXISTS profiles__user_id;
CREATE INDEX profiles__user_id
  ON profiles
  USING BTREE
  (user_id);

DROP INDEX IF EXISTS profiles__agency_id;
CREATE INDEX profiles__agency_id
  ON profiles
  USING BTREE
  (agency_id);

DROP INDEX IF EXISTS science_group__project_id;
CREATE INDEX science_group__project_id
  ON science_group
  USING BTREE
  (project_id);

DROP INDEX IF EXISTS agencies_science_group_id;
CREATE INDEX agencies_science_group_id
  ON agencies
  USING BTREE
  (science_group_id);


DROP INDEX IF EXISTS profile_role_profile_id;
CREATE INDEX profile_role_profile_id
  ON profile_role
  USING BTREE
  (profile_id);


DROP INDEX IF EXISTS profile_role_role_id;
CREATE INDEX profile_role_role_id
  ON profile_role
  USING BTREE
  (role_id);

DROP INDEX IF EXISTS profile_science_group_profile_id;
CREATE INDEX profile_science_group_profile_id
  ON profile_science_group
  USING BTREE
  (profile_id);

DROP INDEX IF EXISTS profile_science_group_science_group_id;
CREATE INDEX profile_science_group_science_group_id
  ON profile_science_group
  USING BTREE
  (science_group_id);

DROP INDEX IF EXISTS project_profile_project_id;
CREATE INDEX project_profile_project_id
  ON project_profile
  USING BTREE
  (project_id);

DROP INDEX IF EXISTS project_profile_profile_id;
CREATE INDEX project_profile_profile_id
  ON project_profile
  USING BTREE
  (profile_id);