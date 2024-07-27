select year(sales_date) year, month(sales_date) month, count(distinct os.user_id) purchased_users, round(count(distinct os.user_id)/(select count(distinct user_id) from user_info where year(joined) = 2021), 1) puchased_ratio
from online_sale as os
where os.user_id in (
    select user_id
    from user_info
    where year(joined) = 2021) and year(sales_date) = 2022
group by year(sales_date), month(sales_date)
order by year, month;