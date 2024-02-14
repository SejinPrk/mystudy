-- DDL(Data Definition Language)

drop table boards;

create table boards(
  board_no int not null,
  title varchar(255) not null,
  content text not null,
  writer varchar(30) not null,
  category int not null,
  created_date datetime null default now()
);

alter table boards
  add constraint primary key (board_no),
  modify column board_no int not null auto_increment;

create table board_files(
  file_no int not null,
  file_path varchar(255) not null,
  board_no int not null
)

alter table board_files
  add constraint primary key (file_no),
  modify column file_no int not null auto_increment,
  add constraint board_files_fk foreign key (board_no) references boards(board_no);

drop table assignments;

create table assignments(
  assignment_no int primary key auto_increment,
  title varchar(255) not null,
  content text not null,
  deadline date not null
);

drop table members;

create table members(
  member_no int primary key auto_increment,
  email varchar(255) not null,
  name varchar(255) not null,
  password varchar(100) not null,
   created_date datetime null default now()
);



alter table boards
  add column category int not null;

update boards set category=1;

