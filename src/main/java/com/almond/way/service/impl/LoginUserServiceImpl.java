package com.almond.way.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.almond.way.dao.ILoginUserDao;
import com.almond.way.model.LoginUser;
import com.almond.way.service.ILoginUserService;

@Service()
public class LoginUserServiceImpl implements ILoginUserService {

	@Resource
	private ILoginUserDao loginUserDao;
	
	@Override
	public LoginUser getLoginUserById(String id, String pwd) {
		LoginUser user = new LoginUser();
		user.setId(id);
		user.setPwd(pwd);
		return loginUserDao.getLoginUser(user);
	}

}
