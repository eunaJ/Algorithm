with max_colony as (
    select year(differentiation_date) year, max(size_of_colony) max
    from ecoli_data
    group by year(differentiation_date)
)

select year(differentiation_date) year, (mc.max - size_of_colony) year_dev, id
from ecoli_data e join max_colony mc on year(differentiation_date) = mc.year
order by year, year_dev;