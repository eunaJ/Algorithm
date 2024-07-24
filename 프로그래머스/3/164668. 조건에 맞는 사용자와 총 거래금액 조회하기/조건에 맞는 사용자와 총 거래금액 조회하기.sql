select user_id, nickname, sum(price) total_sales
from used_goods_board join used_goods_user on used_goods_board.writer_id = used_goods_user.user_id
where used_goods_board.status = 'done'
group by used_goods_user.user_id, used_goods_user.nickname
having sum(price) >= 700000
order by total_sales;