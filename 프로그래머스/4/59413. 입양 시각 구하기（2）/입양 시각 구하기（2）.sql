with recursive hours as (
    select 0 as hour
    union all
    select hour + 1
    from hours
    where hour < 23
)
select hours.hour hour, count(animal_id) count
from hours left join animal_outs on hour(datetime) = hours.hour
group by hours.hour
order by hours.hour;