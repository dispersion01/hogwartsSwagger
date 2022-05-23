alter table student
    add constraint age check ( age > 16 );
alter table faculty
    add constraint text unique (color, name);
alter table student
    add constraint unique_name unique (name) ;
alter table student
    alter column name set not null;
alter table student
    alter column age set default 20;