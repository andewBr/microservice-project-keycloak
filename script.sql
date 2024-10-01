CREATE TABLE countries (
                           id SERIAL PRIMARY KEY,
                           country_name VARCHAR(255) NOT NULL
);

CREATE TABLE cvs (
                     id SERIAL PRIMARY KEY,
                     uuid UUID NOT NULL UNIQUE,
                     name VARCHAR(255) NOT NULL,
                     surname VARCHAR(255) NOT NULL,
                     country_id BIGINT NOT NULL,
                     city VARCHAR(255),
                     is_ready_to_relocate BOOLEAN,
                     is_ready_for_remote_work BOOLEAN,
                     status VARCHAR(50),
                     CONSTRAINT fk_country
                         FOREIGN KEY (country_id) REFERENCES countries(id)  -- Внешний ключ для country_id
);

drop table cvs;
drop table countries;

INSERT INTO countries (country_name)
VALUES ('United States'),
       ('Canada'),
       ('Germany'),
       ('France'),
       ('Japan');

INSERT INTO cvs (uuid, name, surname, country_id, city, is_ready_to_relocate, is_ready_for_remote_work, status)
VALUES
    ('e6c234fa-9a2f-4ae3-b2b1-26f3e5a5e080', 'John', 'Doe', 1, 'New York', true, false, 'Active'),
    ('7b982cd3-25f0-4384-9f13-33cf3b176ee7', 'Jane', 'Smith', 2, 'Toronto', false, true, 'Inactive'),
    ('27f6ecae-c9b4-495f-a5b5-0a0d649ea902', 'Hans', 'Müller', 3, 'Berlin', true, true, 'Active'),
    ('3dbb278f-7c5d-450e-b0c3-c5a3f49c73a2', 'Marie', 'Curie', 4, 'Paris', false, true, 'Active'),
    ('5e098b63-0973-4456-a2fe-9d1c0b0f8c77', 'Taro', 'Yamada', 5, 'Tokyo', true, false, 'Active');

