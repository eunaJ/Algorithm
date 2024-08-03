select month(start_date) month, car_id, count(*) records
from car_rental_company_rental_history h
where car_id in (
    select car_id
    from car_rental_company_rental_history h
    where start_date >= '2022-08-01' and start_date <= '2022-10-31'
    group by car_id
    having count(*) >= 5
) and start_date >= '2022-08-01' and start_date <= '2022-10-31'
group by month, car_id
order by month, car_id desc;