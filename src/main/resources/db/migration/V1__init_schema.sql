CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE concerts (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    date DATE NOT NULL,
    hour TIME NOT NULL,
    number_of_places INT NOT NULL CHECK (number_of_places > 0)
);

CREATE TABLE seats (
    id BIGSERIAL PRIMARY KEY,
    concert_id BIGINT NOT NULL REFERENCES concerts(id),
    seat_number INT NOT NULL,
    CONSTRAINT unique_seat_per_concert UNIQUE (concert_id, seat_number)
);

CREATE TABLE reservations (
    id BIGSERIAL PRIMARY KEY,
    seat_id BIGINT NOT NULL REFERENCES seats(id),
    user_id BIGINT NOT NULL REFERENCES users(id),
    status VARCHAR(25) NOT NULL,
    expires_at TIMESTAMP NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT status_values CHECK (
        status IN ('PENDING', 'CONFIRMED', 'EXPIRED', 'CANCELLED')
    )
);

CREATE UNIQUE INDEX unique_reservation_per_seat
    ON reservations (seat_id)
    WHERE status IN ('PENDING', 'CONFIRMED');