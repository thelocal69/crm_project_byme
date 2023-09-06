package com.batdongsan24h.dao.impl;

import java.util.List;

import com.batdongsan24h.model.UserModel;

public interface IUserDao {
	UserModel findEmailAndPassword(String email, String pass);
	List<UserModel> findAll();
	Integer save(UserModel userModel);
	UserModel findOne(Integer id);
	void update(UserModel updateUser);
	void delete(Integer id);
}
