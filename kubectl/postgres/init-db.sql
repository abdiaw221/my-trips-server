-- Create the dblink extension
CREATE EXTENSION IF NOT EXISTS dblink;

-- Ensure the admin role exists
DO $$
BEGIN
    IF NOT EXISTS (SELECT FROM pg_catalog.pg_roles WHERE rolname = 'admin') THEN
CREATE ROLE admin WITH LOGIN PASSWORD 'admin';
END IF;
END
$$;

-- Create databases if they do not exist and grant privileges
DO $$
BEGIN
    -- Check for and create trip_db if it does not exist
    IF NOT EXISTS (SELECT FROM pg_database WHERE datname = 'trip_db') THEN
        EXECUTE 'CREATE DATABASE trip_db';
EXECUTE 'GRANT ALL PRIVILEGES ON DATABASE trip_db TO admin';
END IF;

    -- Check for and create int_trip_db if it does not exist
    IF NOT EXISTS (SELECT FROM pg_database WHERE datname = 'int_trip_db') THEN
        EXECUTE 'CREATE DATABASE int_trip_db';
EXECUTE 'GRANT ALL PRIVILEGES ON DATABASE int_trip_db TO admin';
END IF;
END
$$;
