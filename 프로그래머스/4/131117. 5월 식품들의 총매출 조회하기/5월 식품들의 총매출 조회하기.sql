select fp.product_id product_id, product_name, sum(price*amount) total_sales
from food_product fp join food_order fo on fp.product_id = fo.product_id
where date_format(produce_date, '%Y-%m') = '2022-05'
group by fp.product_id
order by total_sales desc, product_id;