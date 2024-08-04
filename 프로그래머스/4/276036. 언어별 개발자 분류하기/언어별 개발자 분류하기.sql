with A as (
    select id
    from developers d 
        join skillcodes s1 on s1.code & d.skill_code = s1.code and s1.category = 'Front End'
        join skillcodes s2 on s2.code & d.skill_code = s2.code and s2.name = 'Python'
),
B as (
    select id
    from developers d 
        join skillcodes s1 on s1.code & d.skill_code = s1.code and s1.name = 'C#'
),
C as (
    select id
    from developers d 
        join skillcodes s1 on s1.code & d.skill_code = s1.code and s1.category = 'Front End'
)

select case 
    when id in (select id from A) then 'A'
    when id in (select id from B) then 'B'
    when id in (select id from C) then 'C' 
    end as grade, id, email
from developers
having grade is not null
order by grade, id;