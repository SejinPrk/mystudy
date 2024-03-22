-- 예약 내역
insert into reservations(reservation_no,member_no,accommodation_no,start_date,end_date,payment_day,status,chat)
values(1234,1,1,'2024-03-21','2024-04-21','2024-02-10','예약됨');
insert into reservations(reservation_no,member_no,accommodation_no,start_date,end_date,payment_day,status,chat)
values(1235,2,2,'2023-02-20','2023-03-20','2023-01-9','완료됨');
insert into reservations(reservation_no,member_no,accommodation_no,start_date,end_date,payment_day,status,chat)
values(1236,3,3,'2022-01-19','2022-02-19','2022-12-8','취소됨');
insert into reservations(reservation_no,member_no,accommodation_no,start_date,end_date,payment_day,status,chat)
values(1237,4,4,'2021-12-18','2021-12-18','2021-11-7','완료됨');

select * from reservations;



-- 선호사항
insert into preferences(member_no,theme_no) values(1,1);
insert into preferences(member_no,theme_no) values(2,2);
insert into preferences(member_no,theme_no) values(3,3);
insert into preferences(member_no,theme_no) values(4,4);

select * from preferences;


-- 즐겨찾기
insert into favorites(accommodation_no,member_no) values(1,1);
insert into favorites(accommodation_no,member_no) values(2,2);
insert into favorites(accommodation_no,member_no) values(3,3);
insert into favorites(accommodation_no,member_no) values(4,4);

select * from favorites;




-- 문의
insert into inquiries(inquiry_no,member_no,title,content,status,received_date)
values(1,1,'문의합니다','문의내용...','답변 완료','2024-03-06');
insert into inquiries(inquiry_no,member_no,title,content,status,received_date)
values(2,2,'문의합니다','문의내용...','진행중','2023-02-09');
insert into inquiries(inquiry_no,member_no,title,content,status,received_date)
values(3,3,'문의합니다','문의내용...','답변 완료','2018-01-01');
insert into inquiries(inquiry_no,member_no,title,content,status,received_date)
values(4,4,'문의합니다','문의내용...','진행중','2016-08-24');

select * from inquiries;

-- 문의 파일
insert into inquiry_files(inquiry_file_no,inquiry_no,file_ori,file_uuid)
values(1,1,'file1','b1deb4d-3b7d-4bad-9bdd');
insert into inquiry_files(inquiry_file_no,inquiry_no,file_ori,file_uuid)
values(2,2,'file2','dgkj-72jh-verl-0fja');
insert into inquiry_files(inquiry_file_no,inquiry_no,file_ori,file_uuid)
values(3,3,'file3','9lhj-knlv-jbtn-bp5t');
insert into inquiry_files(inquiry_file_no,inquiry_no,file_ori,file_uuid)
values(4,4,'file4','thbx-krjh-tbke-ahb5');

select * from inquiry_files;

-- 문의 답변
insert into inquiry_replies(inquiry_no,content,reply_date)
values(1,'답변드립니다.','2024-05-14');
insert into inquiry_replies(inquiry_no,content,reply_date)
values(2,'답변드립니다.','2023-04-10');
insert into inquiry_replies(inquiry_no,content,reply_date)
values(3,'답변드립니다.','2022-03-06');
insert into inquiry_replies(inquiry_no,content,reply_date)
values(4,'답변드립니다.','2021-02-02');

select * from inquiry_replies;



-- 알림
insert into notifications(notification_no,member_no,content,notification_date,is_read)
values(1,1,'작성하신 게시글에 새 댓글이 달렸습니다.','2024-10-20',1);
insert into notifications(notification_no,member_no,content,notification_date,is_read)
values(2,2,'작성하신 댓글에 새 답글이 달렸습니다.','2023-12-25',0);
insert into notifications(notification_no,member_no,content,notification_date,is_read)
values(3,3,'호스트로부터 채팅이 왔습니다.','2022-3-8',0);
insert into notifications(notification_no,member_no,content,notification_date,is_read)
values(4,4,'리뷰 작성으로 500 포인트가 발급되었습니다.','2024-10-20',1);

select * from notifications;