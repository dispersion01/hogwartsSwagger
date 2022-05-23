create table person (id numeric, name varchar, age numeric,  drive_licence BOOLEAN );
create table vehicle (id numeric, brand varchar, moder varchar, price numeric);
alter table person
    add primary key (name);
alter table vehicle
    add primary key (brand, moder);
select person.id, person.name, person.drive_licence, vehicle.id, vehicle.brand, vehicle.moder
from vehicle
         left join person on person.id = vehicle.id;