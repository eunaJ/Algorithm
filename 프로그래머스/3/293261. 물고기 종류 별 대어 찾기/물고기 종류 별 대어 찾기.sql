select id, fish_name, length
from fish_info i left join fish_name_info ni on i.fish_type = ni.fish_type
where (i.fish_type, length) in (
    select fish_type, max(length)
    from fish_info
    group by fish_type)
order by id;