select animal_ins.name name, animal_ins.datetime datetime
from animal_ins left join animal_outs on animal_ins.animal_id = animal_outs.animal_id
where animal_outs.animal_id is null
order by datediff(animal_outs.datetime, animal_ins.datetime) desc, animal_ins.datetime
limit 3;