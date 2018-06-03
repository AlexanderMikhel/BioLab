CREATE FUNCTION get_directory_path_as_string(directory_id BIGINT)
  RETURNS VARCHAR
LANGUAGE plpgsql
AS $$
DECLARE
  directory_path VARCHAR;
  path  VARCHAR := '';

BEGIN
  LOOP
    directory_path := (SELECT name
                     FROM directories
                     WHERE id = directory_id);
    path := concat(concat(directory_path,'/'),path);
    directory_id := (SELECT parent_directory_id
                     FROM directories
                     WHERE id = directory_id);
    IF directory_id IS NULL
    THEN  EXIT;
    END IF;
  END LOOP;
  RETURN path;
END;
$$;