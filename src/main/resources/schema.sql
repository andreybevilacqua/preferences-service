CREATE TABLE Preference (
    id UUID NOT NULL PRIMARY KEY,
    name varchar2(200)
);

CREATE TABLE Solution (
    id UUID NOT NULL PRIMARY KEY,
    name varchar2(200)
);

CREATE TABLE Universal_Preference (
    id UUID NOT NULL PRIMARY KEY,
    name varchar2(200)
);

CREATE TABLE UserApp (
    id UUID NOT NULL PRIMARY KEY,
    name varchar2(400)
);