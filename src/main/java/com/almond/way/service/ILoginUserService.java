package com.almond.way.service;

import com.almond.way.model.LoginUser;

public interface ILoginUserService {
	
	LoginUser getLoginUserById(String id, String pwd);

}
