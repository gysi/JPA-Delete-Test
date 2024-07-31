-- Create the Parent table
CREATE TABLE parent
(
    id   INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Create the Child table
CREATE TABLE child
(
    id   INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Create the junction table to establish a many-to-many relationship
CREATE TABLE parent_child
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    parent_id INT,
    child_id  INT,
    attribute varchar(255) NOT NULL,
    FOREIGN KEY (parent_id) REFERENCES parent (id) ON DELETE CASCADE,
    FOREIGN KEY (child_id) REFERENCES child (id) ON DELETE CASCADE
);
