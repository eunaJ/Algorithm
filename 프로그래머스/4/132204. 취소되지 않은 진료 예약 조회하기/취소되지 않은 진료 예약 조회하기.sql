select apnt_no, pt_name, a.pt_no pt_no, a.mcdp_cd mcdp_cd, dr_name, apnt_ymd
from appointment a left outer join patient p on a.pt_no = p.pt_no left outer join doctor d on a.mddr_id = d.dr_id
where a.mcdp_cd = 'CS' and apnt_ymd like '2022-04-13%' and apnt_cncl_yn = 'N'
order by apnt_ymd