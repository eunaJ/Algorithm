select e1.id id, e1.genotype genotype, e2.genotype parent_genotype 
from ecoli_data e1 left join ecoli_data e2 on e1.parent_id = e2.id
where e1.genotype & e2.genotype = e2.genotype
order by id;