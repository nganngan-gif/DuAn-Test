USE master
go

create database NghienTube
go

use NghienTube
go

create table Users(
	UsersID varchar(10) primary key,
	Pass varchar(30),
	Email varchar(50),
	FullName Nvarchar(50),
	Admin bit
);

create table Video(
	VideoID varchar(10) primary key,
	Title Nvarchar(100),
	Poster varchar(200),
	Views Integer,
	Description Nvarchar(500),
	Active bit
);

create table Favorite(
	FavoriteID varchar(10) primary key,
	UserID varchar(10) references Users(UsersID),
	VideoID varchar(10) references Video(VideoID),
	LikeDate Date
);

create table Share(
	ShareID varchar(10) primary key,
	UserID varchar(10) references Users(UsersID),
	VideoID varchar(10) references Video(VideoID),
	Email varchar(50),
	ShareDate Date
);

insert into Users
values ('admin','123456','admin@gmail.com','admin1',1),
		 ('user','123456','user@gmail.com','user1',0),
		  ('ducduy','123456','ducduy@gmail.com','Duc Duy',0),
		   ('hoangduy','123456','hoangduy@gmail.com','Hoang Duy',0),
		    ('loi','123456','loi@gmail.com','Danh Loi',0)