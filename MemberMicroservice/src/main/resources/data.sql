/* Policy Table*/
DROP TABLE IF EXISTS policy;
create table policy(policy_id int,policy_number int,benefit_id int,premium double,tenure int);

insert into policy (policy_id,policy_number,benefit_id,premium,tenure) values(1,101,201,5000.0,25);
insert into policy (policy_id,policy_number,benefit_id,premium,tenure) values(2,102,203,8000.0,21);
insert into policy (policy_id,policy_number,benefit_id,premium,tenure) values(3,103,203,15000.0,14);

DROP TABLE IF EXISTS benefits;
create table benefits(benefit_id int, benefit_name varchar(50));

insert into benefits (benefit_id,benefit_name) values(201,'Free Monthly Health Checkup');
insert into benefits (benefit_id,benefit_name) values(202,'Cashless Medical Treatment');
insert into benefits (benefit_id,benefit_name) values(203,'Coverage For Covid-19 Treatment');
insert into benefits (benefit_id,benefit_name) values(204,'Daily Hospital Cash Benefit');
insert into benefits (benefit_id,benefit_name) values(205,'Tax Benefits On The Health Insurance Premium');

DROP TABLE IF EXISTS member_policy;
create table member_policy(member_id int,policy_id int,policy_number int,benefit_id int,subscription_date date,tenure int,cap_amount_benefits double);

insert into member_policy (member_id,policy_id,policy_number,benefit_id,subscription_date,tenure,cap_amount_benefits) values(1,1,101,202,'2021-06-24',21,100000.00);
insert into member_policy (member_id,policy_id,policy_number,benefit_id,subscription_date,tenure,cap_amount_benefits) values(2,1,101,201,'2020-03-07',21,120000.00);
insert into member_policy (member_id,policy_id,policy_number,benefit_id,subscription_date,tenure,cap_amount_benefits) values(3,2,102,203,'2019-01-09',14,80000.00);

DROP TABLE IF EXISTS provider_policy;
create table provider_policy(provider_id int,provider_name varchar(20),provider_address varchar(50),policy_id int,location varchar(20));

/*Inserting data in provider_policy table*/
insert into provider_policy (provider_id,provider_address,provider_name,policy_id,location) values(1,'MG Road','City Hospital',1,'Chennai');
insert into provider_policy (provider_id,provider_address,provider_name,policy_id,location) values(2,'Chitnis Nagar','LIC',1,'Nagpur');
insert into provider_policy (provider_id,provider_address,provider_name,policy_id,location) values(3,'Chandni Chowk','Bajaj',2,'Delhi');
insert into provider_policy (provider_id,provider_address,provider_name,policy_id,location) values(4,'Dhayari','Apollo Hospital',3,'Pune');
insert into provider_policy (provider_id,provider_address,provider_name,policy_id,location) values(5,'Boriwali','HDFC',2,'Mumbai');

DROP TABLE IF EXISTS member_premium;
create table member_premium(member_id int,policy_id int,paid_date date,due_date date,premium double,late_payment boolean,late_payment_charges double);

/* inserting in member_premium*/
insert into member_premium (member_id,policy_id,paid_date,due_date,premium,late_payment,late_payment_charges) values(1,1,'2021-06-25','2021-07-05',5000.0,false,0.0);
insert into member_premium (member_id,policy_id,paid_date,due_date,premium,late_payment,late_payment_charges) values(2,2,'2021-04-09','2021-05-13',8000.0,false,0.0);
insert into member_premium (member_id,policy_id,paid_date,due_date,premium,late_payment,late_payment_charges) values(3,2,'2021-04-20','2021-03-02',15000.0,true,100);

DROP TABLE IF EXISTS member_claim;
create table member_claim(claim_id int,amount_claimed double,amount_settled double,benefit_id int,claim_status varchar(20),member_id int,policy_id int,provider_id int,description varchar(255));
/* inserting in claim*/
insert into member_claim (claim_id,amount_claimed,amount_settled,benefit_id,claim_status,member_id,policy_id,provider_id,description) values(1,50000.0,50000.0,202,'claimed',1,3,3,'Acccident claim on City Hospital');
insert into member_claim (claim_id,amount_claimed,amount_settled,benefit_id,claim_status,member_id,policy_id,provider_id,description) values(2,42000.0,42000.0,205,'claimed',2,1,4,'claim on LIC');
insert into member_claim (claim_id,amount_claimed,amount_settled,benefit_id,claim_status,member_id,policy_id,provider_id,description) values(3,90000.0,50000.0,201,'not claimed',2,2,1,'Hdfc Claim');
