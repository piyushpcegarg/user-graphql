-- Create a keyspace
CREATE KEYSPACE IF NOT EXISTS userstore WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : '1' };

-- Create a table
CREATE TABLE IF NOT EXISTS userstore.user (
    id uuid PRIMARY KEY,
    firstname text,
    lastname text,
    email text,
    password text,
    avatar text,
    role text
);