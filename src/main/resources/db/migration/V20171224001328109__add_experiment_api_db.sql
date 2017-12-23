create table IF NOT EXISTS spectra_data
(
  id serial not null
    constraint spectra_pkey
    primary key,
  spectra json,
  name VARCHAR,
  created_at timestamp default now(),
  updated_at timestamp,
  deleted_at timestamp
);

create TABLE IF NOT EXISTS experiments
(
  id serial not null
    constraint experiment_pkey
    primary key,
  name VARCHAR,
  created_by_profile INTEGER,
  CONSTRAINT fk_experiments_to_profiles FOREIGN KEY (created_by_profile)
  REFERENCES profiles (id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION,
  project_id INTEGER,
  CONSTRAINT fk_experiments_to_projects FOREIGN KEY (project_id)
  REFERENCES projects (id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION,
  created_at timestamp default now(),
  updated_at timestamp,
  deleted_at timestamp
);

create TABLE IF NOT EXISTS experiment_spectra(
  id serial not null
    constraint experiment_spectra_pkey
    primary key,
  spectra_id INTEGER,
  CONSTRAINT fk_experiment_spectra_to_spectra FOREIGN KEY (spectra_id)
  REFERENCES spectra_data (id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION,
  experiment_id INTEGER,
  CONSTRAINT fk_experiment_spectra_to_experiments FOREIGN KEY (experiment_id)
  REFERENCES experiments (id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION
);


create TABLE IF NOT EXISTS algorithms(
  id serial not null
    constraint algorithm_pkey
    primary key,
  name VARCHAR,
  order_lines INTEGER,
  created_by_profile INTEGER,
  CONSTRAINT fk_algorithms_to_profiles FOREIGN KEY (created_by_profile)
  REFERENCES profiles (id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION
);


create TABLE IF NOT EXISTS experiment_algorithm(
  id serial not null
    constraint experiment_algorithm_pkey
    primary key,
  experiment_id INTEGER,
  algoritm_id INTEGER,
  order_lines INTEGER,
  CONSTRAINT fk_experiment_algorithm_to_experiments FOREIGN KEY (experiment_id)
  REFERENCES experiments (id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_experiment_algorithm_to_algorithms FOREIGN KEY (algoritm_id)
  REFERENCES algorithms (id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION
);

DROP INDEX IF EXISTS experiments_profiles_id;
CREATE INDEX experiments_profiles_id
  ON experiments
  USING BTREE
  (created_by_profile);

DROP INDEX IF EXISTS experiments_projects_id;
CREATE INDEX experiments_projects_id
  ON experiments
  USING BTREE
  (project_id);

DROP INDEX IF EXISTS algorithms_profiles_id;
CREATE INDEX algorithms_profiles_id
  ON algorithms
  USING BTREE
  (created_by_profile);