create table Question (
	id int not null auto_increment,
    question varchar(500) not null,
    oneoption varchar(500) not null,
    twooption varchar(500) not null,
    oneimage varchar(500) default 'void',
    twoimage varchar(500)  default 'void',
    category varchar(500) default 'void',
    isnsfw varchar(1) default 'n',
    primary key (id)
);


create table User
(
 uid bigint auto_increment,
 uemail varchar(100) not null,
 upassword varchar(100) not null,
 primary key (uid)
);

alter table User add voidind varchar(1) not null default 'n';

create table Vote
(
	vid bigint auto_increment,
    uid bigint not null,
    qid int not null,
    votevalue varchar(1) not null,
    primary key (vid),
    foreign key (uid) references User(uid),
    foreign key (qid) references Question(id)
);

alter table Vote add voidind varchar(1) not null default 'n';

alter table Question add uid bigint not null default 1;
alter table Question add constraint fk_uid foreign key (uid) references User(uid);
alter table Question add voidind varchar(1) not null default 'n';
alter table User modify column upassword varchar(500);
alter table User add unique (uemail);