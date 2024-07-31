select member_name, review_text, date_format(review_date, '%Y-%m-%d') review_date
from member_profile mp join rest_review rr on mp.member_id = rr.member_id
where rr.member_id = (
    select member_id
    from rest_review rr
    group by member_id
    order by count(*) desc
    limit 1
)
order by review_date, review_text;