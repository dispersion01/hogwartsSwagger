create table person (id numeric, name varchar primary key, age numeric,  drive_licence BOOLEAN );
create table vehicle (id numeric, brand varchar primary key, moder varchar primary key, price numeric);
select person.id, person.name, person.drive_licence, vehicle.id, vehicle.brand, vehicle.moder
from vehicle
         left join person on person.id = vehicle.id;