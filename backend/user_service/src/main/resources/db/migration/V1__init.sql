CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    gender VARCHAR(20),
    phone VARCHAR(20) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    city VARCHAR(100),
    birth_date DATE,
    avatar_url TEXT,
    bio TEXT,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);