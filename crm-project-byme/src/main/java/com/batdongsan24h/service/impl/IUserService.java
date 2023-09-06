package com.batdongsan24h.service.impl;

import java.util.List;

import com.batdongsan24h.model.UserModel;

public interface IUserService {
	UserModel findEmailAndPassword(String email, String pass);
	List<UserModel> findAll();
	UserModel save(UserModel userModel);
	UserModel findOne(Integer id);
	UserModel update (UserModel updateUser);
	void deleteAll(Integer[] ids);
	void deleteById(Integer id);
}
