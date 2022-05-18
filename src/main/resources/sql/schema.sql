CREATE TABLE IF NOT EXISTS WEEKDAYS (
    id              VARCHAR(60)     DEFAULT RANDOM_UUID()   PRIMARY KEY,
    name            VARCHAR(16)     NOT NULL
);

CREATE TABLE IF NOT EXISTS MEALS (
    id              VARCHAR(60)     DEFAULT RANDOM_UUID()   PRIMARY KEY,
    weekday_id      VARCHAR(60),
    name            VARCHAR(20),
    kcal            INT(6),
    protein         INT(8),
    sat_fat         INT(8),
    five_a_day      INT(2),
    cost            INT(6),
    CONSTRAINT FK_meal_weekday FOREIGN KEY (weekday_id) REFERENCES WEEKDAYS(id)
);