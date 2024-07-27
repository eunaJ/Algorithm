select ii.item_id as item_id, item_name, rarity
from item_info as ii join item_tree as it on ii.item_id = it.item_id
where ii.item_id not in (
    select parent_item_id
    from item_tree
    where parent_item_id is not null)
order by item_id desc;