select count(id) fish_count from fish_info join fish_name_info on fish_info.fish_type=fish_name_info.fish_type where fish_name_info.fish_name = 'bass' or fish_name_info.fish_name = 'snapper';