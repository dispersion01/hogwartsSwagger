

select * from student;

select *
from student
where age > 10
  AND age < 20;

select name
from student;

select *
from student
where name like '%o%';

select *
from student
where student.id < student.age;

select *
from student
order by name ;

select *
from student
order by age ;