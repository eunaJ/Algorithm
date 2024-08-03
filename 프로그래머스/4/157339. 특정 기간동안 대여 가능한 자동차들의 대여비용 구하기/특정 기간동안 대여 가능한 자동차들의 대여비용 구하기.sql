with discount as (
    select 
        car_type, 
        (1 - (discount_rate * 0.01)) as rate
    from 
        car_rental_company_discount_plan
    where
        duration_type = '30일 이상'
)
select
    car_id, 
    d.car_type, 
    round(daily_fee * 30 * rate) as fee
from 
    car_rental_company_car c 
    join discount d using(car_type)
where 
    car_id not in (
        select distinct car_id
        from car_rental_company_rental_history h
        where end_date >= '2022-11-01' 
    )
    and car_type in ('세단', 'SUV')
    and (daily_fee * 30 * rate) >= 500000 
    and (daily_fee * 30 * rate) < 2000000
order by fee desc, car_type, car_id desc;