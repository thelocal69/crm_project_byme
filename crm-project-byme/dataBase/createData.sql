CREATE DATABASE account;

USE account;

CREATE TABLE role(
	id int PRIMARY KEY AUTO_INCREMENT,
	rolename varchar(255) NOT NULL,
	description text NOT NULL,
	createdby varchar(255),
	createddate timestamp,
	modifiedby varchar(255),
	modifieddate timestamp
);

CREATE TABLE user(
	id int PRIMARY KEY AUTO_INCREMENT,
	email varchar(255) NOT NULL,
	pass varchar(255) NOT NULL,
	role_id int NOT NULL,
	avatar varchar(255),
	firstname varchar(255),
	lastname varchar(255),
	username varchar(255),
	fullname varchar(255),
	phone varchar(10),
	createdby varchar(255),
	createddate timestamp,
	modifiedby varchar(255),
	modifieddate timestamp
);


ALTER TABLE user ADD CONSTRAINT fk_roleid_user FOREIGN KEY (role_id) REFERENCES role(id);

CREATE TABLE status (
	id int PRIMARY KEY AUTO_INCREMENT,
	statusname varchar(255) NOT NULL
);

CREATE TABLE project(
	id int PRIMARY KEY AUTO_INCREMENT,
	projectname varchar(255) NOT NULL,
	starteddate varchar(155),
	endeddate varchar(155),
	createdby varchar(255),
	createddate timestamp,
	modifiedby varchar(255),
	modifieddate timestamp
);

CREATE TABLE job (
	id int PRIMARY KEY AUTO_INCREMENT,
	name varchar(255) NOT NULL,
	content text NOT NULL,
	starteddate varchar(155),
	endeddate varchar(155),
	project_id int NOT NULL,
	user_id int NOT NULL,
	status_id int NOT NULL,
	createdby varchar(255),
	createddate timestamp,
	modifiedby varchar(255),
	modifieddate timestamp
);

ALTER TABLE job ADD CONSTRAINT fk_projectid_job FOREIGN KEY (project_id) REFERENCES project(id);
ALTER TABLE job ADD CONSTRAINT fk_userid_job FOREIGN KEY (user_id) REFERENCES user(id);
ALTER TABLE job ADD CONSTRAINT fk_statusid_job FOREIGN KEY (status_id) REFERENCES status(id);

CREATE TABLE project_user (
	user_id int NOT NULL,
	project_id int NOT NULL,
	createdby varchar(255),
	createddate timestamp,
	modifiedby varchar(255),
	modifieddate timestamp,
	
	PRIMARY KEY(user_id, project_id)
);

ALTER TABLE project_user ADD CONSTRAINT fk_userid_projectuser FOREIGN KEY (user_id) REFERENCES user(id);
ALTER TABLE project_user ADD CONSTRAINT fk_projectid_projectuser FOREIGN KEY (project_id) REFERENCES project(id);
