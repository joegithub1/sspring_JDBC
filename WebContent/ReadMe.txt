create table user_info(
 user_id number(11) primary key not null,
 user_name nvarchar2(50),--账号
 pass_word nvarchar2(50),--密码
 user_state number(1) --是否可用
)
insert into user_info values(1,'1001','000000',1);
insert into user_info values(2,'1002','000000',1);
insert into user_info values(3,'1003','000000',0);
insert into user_info values(4,'1004','000000',0);
insert into user_info values(5,'1005','000000',0);
insert into user_info values(7,'','','');
select * from user_info
insert into user_info(user_id,user_name,pass_word,user_state) 
values(6,'1006','000000',1)
drop table user_info
delete from user_info where 1=1
select * from user_info where user_name='1006' and user_state='1'
