CREATE SEQUENCE IF NOT EXISTS buyer_sequence;

CREATE TABLE IF NOT EXISTS buyers (
    id BIGINT PRIMARY KEY DEFAULT nextval('buyer_sequence'),
    namespace_id VARCHAR(50) NOT NULL,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(255) UNIQUE,
    phone_number VARCHAR(20),
    address JSONB,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    deleted_at TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255),
    deleted_by VARCHAR(255),
    version int
);

CREATE INDEX IF NOT EXISTS idx_buyers_name ON buyers(name);
CREATE INDEX IF NOT EXISTS idx_buyers_phone ON buyers(phone_number);