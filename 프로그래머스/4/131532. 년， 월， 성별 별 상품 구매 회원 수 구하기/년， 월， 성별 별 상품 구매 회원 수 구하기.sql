select year(sales_date) year, month(sales_date) month, gender, count(distinct ui.user_id) users
from user_info ui join online_sale os on ui.user_id = os.user_id
where gender is not null
group by year, month, gender
order by year, month, gender