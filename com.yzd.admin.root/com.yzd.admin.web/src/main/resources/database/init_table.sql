create table if not exists users (id int not null primary key auto_increment,username varchar(100),password varchar(100),status int);
create table if not exists shortcuts (id int not null primary key auto_increment,name varchar(100),filePath varchar(1000),color int);