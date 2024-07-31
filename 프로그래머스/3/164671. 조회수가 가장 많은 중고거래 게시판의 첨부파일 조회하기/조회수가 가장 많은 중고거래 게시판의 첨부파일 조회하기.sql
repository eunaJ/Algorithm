select concat('/home/grep/src/', b.board_id, '/', file_id, file_name, file_ext) file_path
from used_goods_board b join used_goods_file f on b.board_id = f.board_id
where f.board_id = (
    select board_id
    from used_goods_board b
    order by views desc
    limit 1)
order by file_id desc;