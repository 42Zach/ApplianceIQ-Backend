-- CREATE TABLE IF NOT EXISTS appliances (
-- id SERIAL PRIMARY KEY,
-- name VARCHAR(255) NOT NULL,
-- image VARCHAR(255),
-- type VARCHAR(255)
-- );

CREATE TABLE IF NOT EXISTS appliances (
id SERIAL PRIMARY KEY,
name VARCHAR(255) NOT NULL,
image VARCHAR(255),
type VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS appliance_types (
id SERIAL PRIMARY KEY,
appliance_id BIGINT,
type VARCHAR(255) NOT NULL,
FOREIGN KEY (appliance_id) REFERENCES appliances(id)
);