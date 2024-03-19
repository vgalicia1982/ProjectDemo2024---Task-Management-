-- Create the 'tasks' table
CREATE TABLE IF NOT EXISTS tasks (
    taskid INT AUTO_INCREMENT PRIMARY KEY,
    task_name VARCHAR(255) NOT NULL,
    task_description TEXT
    -- Add other columns as needed
);

-- Create the 'users' table with a foreign key reference to 'tasks' table
CREATE TABLE IF NOT EXISTS users (
    userid INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    contact_number VARCHAR(15) NOT NULL,
    taskid INT,
    FOREIGN KEY (taskid) REFERENCES tasks(taskid)
);