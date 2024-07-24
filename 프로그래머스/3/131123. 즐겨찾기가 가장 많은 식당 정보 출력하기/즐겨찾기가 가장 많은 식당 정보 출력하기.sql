select food_type, rest_id, rest_name, favorites
from rest_info ri
where favorites = (
        select max(favorites)
        from rest_info
        where food_type = ri.food_type
    )
order by food_type desc;