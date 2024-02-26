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



-- 분류

drop table category;

create table category(
  category_no int primary key auto_increment,
  name varchar(255) not null
  );


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


-- 결제내역

drop table payments;

create table payments(
  payment_no int primary key auto_increment,
  start Date not null,
  end Date null,
  amount int
  );



-- 구독내역

drop table subscriptions;

create table subscriptions(
  subscription_no int primary key auto_increment,
  start Date null,
  end Date null
);

