select *
from student
         INNER join faculty on student.id = faculty.id;
select *
from student
right join avatar on student.id= avatar.student_id;