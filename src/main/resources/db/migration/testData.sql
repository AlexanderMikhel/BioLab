----------------------------------------------------------
INSERT INTO users (first_name, middle_name, last_name) VALUES
  ('Владислав', 'Андреевич', 'Чунихин'),
  ('Александр', 'Сергеевич', 'Пушкин'),
  ('Станислав', 'Владимирович', 'Бушков');
----------------------------------------------------------
INSERT INTO profiles (name, login, password, user_id) VALUES
  ('Vlad','qwerty123','112233',1),
  ('Alex','qwerty134','112233',2),
  ('Morgan','qwerty156','112233',3);
----------------------------------------------------------
INSERT INTO projects (name) VALUES
  ('prostitutes of Samara'),
  ('prostitutes of TLT'),
  ('prostitutes of Moscow');
----------------------------------------------------------
INSERT INTO science_group (name, project_id) VALUES
  ('Smart People',1),
  ('Almost Smart People',2),
  ('Not Smart People',3);
----------------------------------------------------------
INSERT INTO agencies (name, address, phone, country, city, science_group_id) VALUES
  ('Samara University', 'Moscow highway 34', '353535', 'Russia', 'Samara', 1),
  ('Moscow University', 'Moscow highway 32', '353535', 'Russia', 'Moscow', 2),
  ('TLT University', 'Moscow highway 36', '353535', 'Russia', 'TLT', 1),
  ('SPB University', 'Moscow highway 30', '353535', 'Russia', 'SPB', 3);
----------------------------------------------------------
UPDATE profiles SET agency_id = 2 WHERE id = 1;
UPDATE profiles SET agency_id = 3 WHERE id = 2;
UPDATE profiles SET agency_id = 4 WHERE id = 3;
----------------------------------------------------------
INSERT INTO profile_science_group(profile_id, science_group_id) VALUES
  (1,2),(2,1),(3,3);
----------------------------------------------------------
INSERT INTO project_profile(project_id, profile_id) VALUES
  (1,1),(3,2),(2,3);
----------------------------------------------------------
