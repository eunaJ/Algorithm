with ecoli_quarter as (
    select id, 
    case 
        when month(differentiation_date) < 4 then '1Q'
        when month(differentiation_date) < 7 then '2Q'
        when month(differentiation_date) < 10 then '3Q'
        else '4Q'
    end as quarter
    from ecoli_data
)
select quarter, count(d.id) ecoli_count
from ecoli_data d join ecoli_quarter q on d.id = q.id
group by quarter
order by quarter;