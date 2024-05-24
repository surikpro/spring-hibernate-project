INSERT INTO account (first_name, last_name) VALUES ('Adam', 'Smit');
INSERT INTO account (first_name, last_name) VALUES ('James', 'Sullivan');
INSERT INTO account (first_name, last_name) VALUES ('Haydar', 'Henderson');

INSERT INTO position (position_title, account_id) VALUES ('Spring Developer', 1);
INSERT INTO position (position_title, account_id) VALUES ('Java Developer', 1);

INSERT INTO project (project_name) VALUES ('Project 1');
INSERT INTO project (project_name) VALUES ('Project 2');

INSERT INTO accounts_projects (account_id, project_id) VALUES (1, 1);
INSERT INTO accounts_projects (account_id, project_id) VALUES (1, 2);

INSERT INTO task (task_name, task_description, project_id) VALUES ('create get TaskController', 'create all layers', 1);
INSERT INTO task (task_name, task_description, project_id) VALUES ('create post TaskController', 'create all layers', 1);
INSERT INTO task (task_name, task_description, project_id) VALUES ('create delete TaskController', 'create all layers, review for bugs', 1);