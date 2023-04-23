CREATE TABLE Solution (
    name VARCHAR(200) PRIMARY KEY,
    type VARCHAR(200),
    is_active boolean NOT NULL,
    created_date DATETIME NOT NULL,
    updated_date DATETIME NOT NULL
);

CREATE TABLE Universal_Preference (
    name VARCHAR(200) PRIMARY KEY,
    value VARCHAR(2000),
    is_active boolean NOT NULL,
    created_date DATETIME NOT NULL,
    updated_date DATETIME NOT NULL
);

CREATE TABLE Solution_Preference (
    universal_preference_name VARCHAR(200) PRIMARY KEY,
    solution_name VARCHAR(200) PRIMARY KEY,
    value VARCHAR(200),
    is_active boolean NOT NULL
);

CREATE TABLE UserApp (
    id UUID NOT NULL PRIMARY KEY,
    name VARCHAR(400) NOT NULL,
    date_of_birth DATE NOT NULL,
    created_date DATETIME NOT NULL
);

CREATE TABLE User_Preference (
    id UUID NOT NULL PRIMARY KEY,
    name VARCHAR(400),
    created_date DATETIME NOT NULL
);
