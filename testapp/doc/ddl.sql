-- DDL(Data Definition Language)

drop table books;

create table books(
  book_no int primary key auto_increment,
  title varchar(255) not null,
  author varchar(255) not null,
  publisher varchar(30) not null
);

insert into books(book_no,title,author,publisher)
  values(1, '제목1','작가1','출판사1');
insert into books(book_no,title,author,publisher)
  values(2, '제목2','작가2','출판사2');
insert into books(book_no,title,author,publisher)
  values(3, '제목3','작가3','출판사3');
insert into books(book_no,title,author,publisher)
  values(4, '제목4','작가4','출판사4');
insert into books(book_no,title,author,publisher)
  values(5, '제목5','작가5','출판사5');

select *
from books;

select * 
from books
where book_no = 3;

update books set
  title='제목6',
  author='작가6',
  publisher='출판사6'
where book_no = 3;

delete from books where book_no=3;

create table members(
  member_no int primary key auto_increment,
  name text not null,
  borrow ENUM('Y', 'N'),
  bname text not null,
  deadline date not null
);

insert into members(name,borrow,bname,deadline)
  values('user1','Y','book1','2024-2-15');
insert into members(name,borrow,bname,deadline)
  values('user2','N','book2','2018-10-01');
insert into members(name,borrow,bname,deadline)
  values('user3','Y','book3','2024-2-24');
insert into members(name,borrow,bname,deadline)
  values('user4','N','book4','2015-1-2');
insert into members(name,borrow,bname,deadline)
  values('user5','N','boo54','2020-12-8');
