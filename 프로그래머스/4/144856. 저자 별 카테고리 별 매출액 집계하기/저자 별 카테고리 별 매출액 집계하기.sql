select b.author_id author_id, author_name, category, sum(price*sales) total_sales
from book_sales bs left outer join book b on bs.book_id = b.book_id left outer join author a on b.author_id = a.author_id
where sales_date like '2022-01%'
group by author_id, category
order by author_id, category desc;