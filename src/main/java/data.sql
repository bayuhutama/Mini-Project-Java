INSERT into m_Wallet_Default_Nominal (nominal,is_deleted,created_on,created_by,modified_by,deleted_by) values 
(50000,false,now(),0,0,0), 
(100000,false,now(),0,0,0), 
(200000,false,now(),0,0,0);


Insert into t_Customer_Wallet (customer_id,pin,balance,barcode,points,created_by,created_on,modified_by,deleted_by,is_deleted) values
(1,'123456',5000000,'qiwjec91m209381920',20,0,now(),0,0,false),
(2,'123455',2000000,'qweqwejeiqwje',20,0,now(),0,0,false);

insert into m_bank (nama,va_code) values
('BCA','0987654321'),
('BNI','8926371287'),
('BRI','9238467283'),
('MANDIRI','3029482617');

Insert into m_user (biodata_id,role_id,email,password,is_locked,created_by,created_on,modified_by,deleted_by,is_deleted,login_attempt) values
(1,1,'ronaldo@gmail.com','ronaldo',false,0,now(),0,0,false,0),
(2,1,'natasha@gmail.com','blackwidow',false,0,now(),0,0,false,0);

insert into m_biodata (fullname,mobile_phone,created_by,created_on,modified_by,deleted_by,is_deleted,image_path) values
('Cristiano Ronaldo',08080808,0,now(),0,0,false,'/gbr/ronaldo.jpg'),
('Natasha Romanoff', 02020202,0,now(),0,0,false,'/gbr/blackwidow.jpg');

insert into m_customer (biodata_id,dob,gender,blood_group_id,height,weight,is_deleted) values
(1,'1985-02-05','M',0,187,85,false),
(2,'1984-12-03','F',0,170,59,false);
