select id, email, first_name, last_name
from developers d
where skill_code & (select code from skillcodes where name like 'Python') 
    or skill_code & (select code from skillcodes where name like 'C#')
order by id;