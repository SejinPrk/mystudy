-- DDL(Data Definition Language)

-- 플랫폼
drop table platforms;

create table platforms(
  platform_no int primary key auto_increment,
  category_no int,
    FOREIGN KEY (category_no) REFERENCES Category(id),
  name varchar(255) not null,
  price INTEGER not null,
  term text not null
);

SELECT * FROM PlatformHandler WHERE category_id = <카테고리 no>;

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


-- 회원

drop table members;

create table members(
  member_no int primary key auto_increment,
  email varchar(255) not null,
  name varchar(255) not null,
  password varchar(100) not null,
  created_date datetime null default now(),
  tel varchar(100) not null,
  credit_no INTEGER not null,
  credit_date varchar(100) not null,
  notification tinyint(1) not null
  );

insert into members(email,name,password,created_date,tel,credit_no,credit_date,notification)
values('user1@test.com', 'user1',sha2('1111',256),'2024-1-1','010-0000-0000','12341234','01/30','0');
insert into members(email,name,password,created_date,tel,credit_no,credit_date,notification)
values('user2@test.com', 'user2',sha2('1111',256),'2024-2-2','010-0000-0000','12341234','02/28','1');
insert into members(email,name,password,created_date,tel,credit_no,credit_date,notification)
values('user3@test.com', 'user3',sha2('1111',256),'2024-3-3','010-0000-0000','12341234','03/26','1');
insert into members(email,name,password,created_date,tel,credit_no,credit_date,notification)
values('user4@test.com', 'user4',sha2('1111',256),'2024-4-4','010-0000-0000','12341234','10/30','0');
insert into members(email,name,password,created_date,tel,credit_no,credit_date,notification)
values('user5@test.com', 'user5',sha2('1111',256),'2024-5-5','010-0000-0000','12341234','12/27','1');

select * from members;


-- 분류

drop table category;

create table category(
  category_no int primary key auto_increment,
  name varchar(255) not null
  );

insert into category(name)
values('Shopping');
insert into category(name)
values('OTT Contents');
insert into category(name)
values('Music');
insert into category(name)
values('Lifestyle');
insert into category(name)
values('Newsletter');
insert into category(name)
values('기타');

select * from category;


-- 알림

drop table notifications;

create table notifications(
  notification_no int primary key auto_increment,
  content text not null,
  date datetime not null,
  checked TINYINT(1) NOT NULL,
  member_no INT,
  FOREIGN KEY (member_no) REFERENCES members(member_no)
  );

INSERT INTO notifications(content, date, checked, member_no)
VALUES('결제일이 곧 다가옵니다.', NOW(), 1, 1);
INSERT INTO notifications(content, date, checked, member_no)
VALUES('새로운 할인 행사가 시작되었습니다!',  NOW(), 1, 2);
INSERT INTO notifications(content, date, checked, member_no)
VALUES('구독 기간이 만료되었습니다. 갱신이 필요합니다.',  NOW(), 0, 3);
INSERT INTO notifications(content, date, checked, member_no)
VALUES('무료 체험 기간이 만료되었습니다. 연장하시겠습니까?',  NOW(), 0, 4);

select * from notifications;

-- 결제내역
create table payments(
  payment_no int primary key auto_increment,
  start Date not null,
  end Date,
  amount int
  );

insert into payments(payment_no,start,end,amount)
values(1, '과제1','내용1','2024-1-1');
insert into assignments(assignment_no,title,content,deadline)
values(2, '과제2','내용2','2024-2-2');
insert into assignments(assignment_no,title,content,deadline)
values(3, '과제3','내용3','2024-3-3');
insert into assignments(assignment_no,title,content,deadline)
values(4, '과제4','내용4','2024-4-4');
insert into payments(assignment_no,title,content,deadline)
values(5, '과제5','내용5','2024-5-5');

select * from payments;


-- 구독내역

