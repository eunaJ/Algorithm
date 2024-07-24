select category, sum(sales) total_sales
from book join book_sales on book.book_id = book_sales.book_id
where date_format(sales_date, '%Y-%m') = '2022-01'
group by category
order by category;