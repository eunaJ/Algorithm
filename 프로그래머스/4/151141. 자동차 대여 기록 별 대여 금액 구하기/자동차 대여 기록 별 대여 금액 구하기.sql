select h.history_id as history_id, 
       round((datediff(end_date, start_date) + 1) * 
           (daily_fee * (100 - 
               ifnull((select discount_rate 
                from car_rental_company_discount_plan p
                where p.car_type = c.car_type
                    and duration_type = (case 
                        when datediff(end_date, start_date) + 1 >= 90 then '90일 이상'
                        when datediff(end_date, start_date) + 1 >= 30 then '30일 이상'
                        when datediff(end_date, start_date) + 1 >= 7 then '7일 이상'
                        end)), 0)) / 100), 0) as fee
from car_rental_company_rental_history h 
    left join car_rental_company_car c on h.car_id = c.car_id
where c.car_type = '트럭'
order by fee desc, h.history_id desc;