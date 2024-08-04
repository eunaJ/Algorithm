with recursive gen(id, parent_id, generation) as (
    select id, parent_id, 1
    from ecoli_data
    where parent_id is null
    union all
    select e.id, e.parent_id, generation + 1
    from ecoli_data e join gen g on e.parent_id = g.id
)

select count(*) count, generation
from gen
where id not in (select parent_id from gen where parent_id is not null)
group by generation
order by generation;