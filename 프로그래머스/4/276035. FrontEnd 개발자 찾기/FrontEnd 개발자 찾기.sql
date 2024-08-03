select distinct id, email, first_name, last_name
from skillcodes s join developers d on s.code & d.skill_code = s.code
where s.category like 'Front End'
order by id;