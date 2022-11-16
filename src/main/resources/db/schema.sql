CREATE TABLE IF NOT EXISTS Account (
    username VARCHAR(64) PRIMARY KEY,
    password VARCHAR(64) NOT NULL,
    birthDate DATE NOT NULL,
    residenceCountry VARCHAR(24) NOT NULL,
    gender VARCHAR(1),
    phoneNumber VARCHAR(10),
);
