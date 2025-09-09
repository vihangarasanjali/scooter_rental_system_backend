-- Normalize invalid values before altering column
UPDATE users SET role = 'GUEST'
WHERE role IS NULL OR role = '' OR role NOT IN ('USER', 'ADMIN');

-- Change column definition
ALTER TABLE users
    MODIFY role VARCHAR(50) DEFAULT 'GUEST' NOT NULL;
