-- DDL(Data Definition Language)

drop table book;

create table book(
  book_no int primary key auto_increment,
  title varchar(255) not null,
  author varchar(255) not null,
  publisher varchar(30) not null,
  genre varchar(255)
);

insert into book(book_no,title,author,publisher,genre)
  values(1, '백범일지','김구','돌베게','역사-인물');
insert into book(book_no,title,author,publisher,genre)
  values(2, '노인과 바다','헤밍웨이','민음사','외국소설');
insert into book(book_no,title,author,publisher,genre)
  values(3, '이방인','알베르 카뮈','민음사','외국소설');
insert into book(book_no,title,author,publisher,genre)
  values(4, '태평천하','채만식','문학과지성사','한국소설');
insert into book(book_no,title,author,publisher,genre)
  values(5, '습관의 힘','찰스 두히그','갤리온','자기계발');

select *
from book;

select * 
from book
where book_no = 3;

update book set
  title='하루 10분 SQL',
  author='한상일',
  publisher='위키북스',
  genre='IT/컴퓨터',
where book_no = 3;

delete from book where book_no=3;

create table member(
  member_no int primary key auto_increment,
  name varchar(255) not null,
  borrow ENUM('대출', '반납'),
  bname varchar(255) not null,
  deadline date not null
);

insert into member(name,borrow,bname,deadline)
  values('회원1','대출','백범일지','2024-2-15');
insert into member(name,borrow,bname,deadline)
  values('회원2','반납','노인과 바다','2018-10-01');
insert into member(name,borrow,bname,deadline)
  values('회원3','대출','이방인','2024-2-24');
insert into member(name,borrow,bname,deadline)
  values('회원4','반납','하루 10분 SQL','2019-1-2');
insert into member(name,borrow,bname,deadline)
  values('회원5','반납','습관의 힘','2020-12-8');
