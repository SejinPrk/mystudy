-- DDL(Data Definition Language)

drop table platforms;

create table platforms(
  platform_no int primary key auto_increment,
  name varchar(255) not null,
  price INTEGER not null,
  term text not null
);

insert into platforms(platform_no,name,price,term)
values(1, '광고형 넷플릭스','5500','month');
insert into platforms(platform_no,name,price,term)
values(2, '넷플릭스 프리미엄','17000','month');
insert into platforms(platform_no,name,price,term)
values(3, '넷플릭스 스탠다드','13500','month');
insert into platforms(platform_no,name,price,term)
values(4, 'Spotify 개인','10900','month');
insert into platforms(platform_no,name,price,term)
values(5, 'Spotify 듀오','16350','month');
insert into platforms(platform_no,name,price,term)
values(6, 'Spotify 베이직','7900','month');
insert into platforms(platform_no,name,price,term)
values(7, '요기패스X','4900','month');
insert into platforms(platform_no,name,price,term)
values(8, '밀리의서재 월 정기구독','9900','month');
insert into platforms(platform_no,name,price,term)
values(9, '밀리의서재 연 정기구독','99000','year');
insert into platforms(platform_no,name,price,term)
values(10, '쿠팡 로켓와우','4990','month');

select * from platforms;


drop table assignments;

create table assignments(
  assignment_no int primary key auto_increment,
  title varchar(255) not null,
  content text not null,
  deadline date not null
  );

insert into assignments(assignment_no,title,content,deadline) 
values(1, '과제1','내용1','2024-1-1');
insert into assignments(assignment_no,title,content,deadline) 
values(2, '과제2','내용2','2024-2-2');
insert into assignments(assignment_no,title,content,deadline) 
values(3, '과제3','내용3','2024-3-3');
insert into assignments(assignment_no,title,content,deadline) 
values(4, '과제4','내용4','2024-4-4');
insert into assignments(assignment_no,title,content,deadline) 
values(5, '과제5','내용5','2024-5-5');

select * from assignments;

select * from assignments where assignment_no = 3;


create table members(
  member_no int primary key auto_increment,
  email varchar(255) not null,
  name varchar(255) not null,
  password varchar(100) not null,
  created_date datetime null default now()
  );

insert into members(email,name,password, created_date) 
values('user1@test.com', 'user1',sha2('1111',256),'2024-1-1');
insert into members(email,name,password,created_date) 
values('user2@test.com', 'user2',sha2('1111',256),'2024-2-2');
insert into members(email,name,password,created_date) 
values('user3@test.com', 'user3',sha2('1111',256),'2024-3-3');
insert into members(email,name,password,created_date) 
values('user4@test.com', 'user4',sha2('1111',256),'2024-4-4');
insert into members(email,name,password,created_date) 
values('user5@test.com', 'user5',sha2('1111',256),'2024-5-5');


select * from members;

alter table boards
  add column category int not null;

update boards set category=1;
