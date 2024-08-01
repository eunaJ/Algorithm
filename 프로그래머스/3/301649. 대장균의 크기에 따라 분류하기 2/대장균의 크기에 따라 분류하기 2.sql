select 
    id,
    case 
        when rank_size <= ((select count(*) from ecoli_data) * 0.25) then 'CRITICAL'
        when rank_size <= ((select count(*) from ecoli_data) * 0.5) then 'HIGH'
        when rank_size <= ((select count(*) from ecoli_data) * 0.75) then 'MEDIUM'
        else 'LOW'
        end as colony_name
from (
    select id, rank() over (order by size_of_colony desc) as rank_size
    from ecoli_data e
) as size_order
order by id;