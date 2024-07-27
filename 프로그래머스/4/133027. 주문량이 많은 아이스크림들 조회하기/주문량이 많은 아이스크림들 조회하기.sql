select flavor
from (
    select flavor, sum(a.total_order) total_order
    from (
        select *
        from first_half fh 
        union
        select *
        from july j
    ) a
    group by flavor
) f
order by f.total_order desc
limit 3;