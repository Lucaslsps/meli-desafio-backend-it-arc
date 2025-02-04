CREATE TABLE IF NOT EXISTS notifications (
    id SERIAL PRIMARY KEY,
    status VARCHAR(50) NOT NULL,
    city_name VARCHAR(100) NOT NULL,
    notification_date TIMESTAMP,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    error_message TEXT
);

-- Create an index on the notification_date column
CREATE INDEX idx_notification_date ON notifications (notification_date);

CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    city_name VARCHAR(100) NOT NULL,
    allow_notifications BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);