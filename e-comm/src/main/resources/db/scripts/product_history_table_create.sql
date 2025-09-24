CREATE TABLE product_history (
    history_id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT,
    title VARCHAR(255),
    price VARCHAR(255),
    description VARCHAR(255),
    category VARCHAR(255),
    image VARCHAR(255),
    created_by VARCHAR(255),
    created_date DATETIME(6),
    action_type VARCHAR(50) NOT NULL,
    action_timestamp DATETIME(6) DEFAULT CURRENT_TIMESTAMP(6),
    modified_by VARCHAR(255)
);