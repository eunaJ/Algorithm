select ri.rest_id rest_id, rest_name, food_type, favorites, address, round(avg(review_score), 2) score
from rest_info as ri join rest_review as rr on ri.rest_id = rr.rest_id
where address like '서울%'
group by ri.rest_id, rest_name, food_type, favorites, address
order by score desc, favorites desc;