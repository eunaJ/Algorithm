select animal_outs.animal_id animal_id, animal_outs.name name
from animal_ins right join animal_outs on animal_ins.animal_id = animal_outs.animal_id
where animal_ins.animal_id is null
order by animal_id;