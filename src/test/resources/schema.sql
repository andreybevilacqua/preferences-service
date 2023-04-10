CREATE TABLE IF NOT EXISTS Preference (
    id UUID NOT NULL PRIMARY KEY,
    name varchar2(200)
);

CREATE TABLE IF NOT EXISTS Solution (
    id UUID NOT NULL PRIMARY KEY,
    name varchar2(200)
);

CREATE TABLE IF NOT EXISTS Universal_Preference (
    id UUID NOT NULL PRIMARY KEY,
    name varchar2(200)
);

CREATE TABLE IF NOT EXISTS UserApp (
    id UUID NOT NULL PRIMARY KEY,
    name varchar2(400)
);