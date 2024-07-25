select animal_ins.animal_id animal_id, animal_ins.animal_type animal_type, animal_ins.name name
from animal_ins join animal_outs on animal_ins.animal_id = animal_outs.animal_id
where animal_ins.sex_upon_intake like 'Intact%' and (animal_outs.sex_upon_outcome like 'Neutered%' or animal_outs.sex_upon_outcome like 'Spayed%')
order by animal_id;