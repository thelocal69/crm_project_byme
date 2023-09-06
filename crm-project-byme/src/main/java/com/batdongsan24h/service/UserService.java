package com.batdongsan24h.service;

import java.util.List;

import javax.inject.Inject;

import com.batdongsan24h.dao.impl.IRoleDao;
import com.batdongsan24h.dao.impl.IUserDao;
import com.batdongsan24h.model.RoleModel;
import com.batdongsan24h.model.UserModel;
import com.batdongsan24h.service.impl.IUserService;

public class UserService implements IUserService{
	
	@Inject
	private IUserDao userDao;
	
	@Inject
	private IRoleDao roleDao;

	@Override
	public UserModel findEmailAndPassword(String email, String pass) {
		
		return userDao.findEmailAndPassword(email, pass);
	}

	@Override
	public List<UserModel> findAll() {
		return userDao.findAll();
	}
	
	@Override
	public UserModel save(UserModel userModel) {
		userModel.setCreatedDate(new java.sql.Timestamp(System.currentTimeMillis()));
		RoleModel roleModel = roleDao.findOne(userModel.getRoleId());
		userModel.setRoleId(roleModel.getId());
		userDao.save(userModel);
		return userModel;
	}

	@Override
	public UserModel findOne(Integer id) {
		return userDao.findOne(id);
	}

	@Override
	public UserModel update(UserModel updateUser) {
		UserModel oldUser = userDao.findOne(updateUser.getId());
		updateUser.setCreatedDate(oldUser.getCreatedDate());
		updateUser.setCreatedBy(oldUser.getCreatedBy());
		updateUser.setModifiedDate(new java.sql.Timestamp(System.currentTimeMillis()));
		RoleModel roleModel = roleDao.findOne(updateUser.getRoleId());
		updateUser.setRoleId(roleModel.getId());
		userDao.update(updateUser);
		return updateUser;
	}

	@Override
	public void deleteAll(Integer[] ids) {
		for (Integer id : ids) {
			this.userDao.delete(id);
		}
	}

	@Override
	public void deleteById(Integer id) {
		this.userDao.delete(id);
	}

}
