CREATE TABLE users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(100) NOT NULL,
                       email VARCHAR(100) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       role ENUM('ADMIN', 'GUEST') DEFAULT 'GUEST'
);

CREATE TABLE rooms (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(100) NOT NULL,
                       description TEXT,
                       price_per_night DOUBLE NOT NULL,
                       capacity INT NOT NULL,
                       available BOOLEAN DEFAULT TRUE
);

CREATE TABLE scooters (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          model VARCHAR(100) NOT NULL,
                          description TEXT,
                          price_per_hour DOUBLE NOT NULL,
                          available BOOLEAN DEFAULT TRUE,
                          image_url VARCHAR(255)
);

CREATE TABLE bookings (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          user_id BIGINT NOT NULL,
                          room_id BIGINT,
                          scooter_id BIGINT,
                          start_datetime DATETIME NOT NULL,
                          end_datetime DATETIME NOT NULL,
                          total_price DOUBLE NOT NULL,
                          FOREIGN KEY (user_id) REFERENCES users(id),
                          FOREIGN KEY (room_id) REFERENCES rooms(id),
                          FOREIGN KEY (scooter_id) REFERENCES scooters(id)
);
