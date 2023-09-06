USE account;

-- insert role
INSERT INTO role (name, description) VALUES ('ADMIN', 'adminitrator');
INSERT INTO role (name, description) VALUES ('USER', 'end user');
-- insert role

-- insert user
INSERT INTO user (email, pass , role_id) VALUES ('khikhu@mail.com', '123456', 1);
INSERT INTO user (email, pass, role_id) VALUES ('baoanphan@mail.com', '123456', 1);
INSERT INTO user (email, pass, role_id) VALUES ('lamtranphi@mail.com', '111111', 2);
INSERT INTO user (email, pass, role_id) VALUES ('calmdownman@mail.com', '111111', 2);
-- insert user

-- insert status
INSERT INTO status (name) VALUES ('PENDING');
INSERT INTO status (name) VALUES ('PROCESSING');
INSERT INTO status (name) VALUES ('COMPLETE');
-- insert status

-- insert project
INSERT INTO project (projectname, starteddate, endeddate) VALUES ('AI', '2023-11-02', '2024-11-02');
-- insert project

-- insert job
INSERT INTO job (name, content, starteddate, endeddate, project_id)
VALUES ('AI Machine', 'practice AI', '2023/11/02', '2023/11/02', 1);
-- insert job