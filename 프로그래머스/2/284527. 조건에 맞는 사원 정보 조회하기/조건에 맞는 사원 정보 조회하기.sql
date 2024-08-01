select sum(score) score, hr_grade.emp_no emp_no, emp_name, position, email 
from hr_employees join hr_grade on hr_employees.emp_no = hr_grade.emp_no 
group by emp_no 
order by score desc
limit 1;