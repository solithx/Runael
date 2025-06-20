CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    sex VARCHAR(20),
    phone VARCHAR(20),
    email VARCHAR(100),
    city VARCHAR(100),
    birth_date DATE,
    avatar_url TEXT,
    bio TEXT,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);