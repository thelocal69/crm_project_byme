package com.batdongsan24h.dao;

import java.util.List;

import com.batdongsan24h.dao.impl.AbstractDao;
import com.batdongsan24h.dao.impl.IUserDao;
import com.batdongsan24h.mapper.UserMapper;
import com.batdongsan24h.model.UserModel;

public class UserDao extends AbstractDao<UserModel> implements IUserDao {

	@Override
	public UserModel findEmailAndPassword(String email, String pass) {
		StringBuilder sql = new StringBuilder("SELECT * FROM user AS u");
		sql.append(" JOIN role r ON u.role_id = r.id");
		sql.append(" WHERE email = ? AND pass = ?");
		List<UserModel> listUser = query(sql.toString(), new UserMapper(), email, pass);
		return !(listUser.isEmpty()) ? listUser.get(0) : null;
	}

	@Override
	public List<UserModel> findAll() {
		StringBuilder sql = new StringBuilder("SELECT * FROM user AS u");
		sql.append(" JOIN role r ON u.role_id = r.id ");
		return query(sql.toString(), new UserMapper());
	}

	@Override
	public Integer save(UserModel userModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO user");
		sql.append(" (email, pass, role_id, avatar, firstname, lastname,");
		sql.append(" username, fullname, phone, createdby, createddate)");
		sql.append(" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		return insert(sql.toString(), userModel.getEmail(), userModel.getPass(), userModel.getRoleId(),
				userModel.getAvatar(), userModel.getFirstName(), userModel.getLastName(), userModel.getUserName(),
				userModel.getFullName(), userModel.getPhone(), userModel.getCreatedBy(), userModel.getCreatedDate());
	}

	@Override
	public UserModel findOne(Integer id) {
		String sql = "SELECT * FROM user WHERE id = ?";
		List<UserModel> listUser = query(sql, new UserMapper(), id);
		return (listUser.isEmpty()) ? null : listUser.get(0);
	}

	@Override
	public void update(UserModel updateUser) {
		StringBuilder sql = new StringBuilder("UPDATE user SET avatar=?, firstname=?,");
		sql.append(" lastname=?, fullname=?, email=?, pass=?, username=?, phone=?,");
		sql.append(" role_id=?, createdby=?, createddate=?, modifiedby=?, modifieddate=? WHERE id=?");
		this.update(sql.toString(), updateUser.getAvatar(), updateUser.getFirstName(), updateUser.getLastName(),
				updateUser.getFullName(), updateUser.getEmail(), updateUser.getPass(), updateUser.getUserName(),
				updateUser.getPhone(), updateUser.getRoleId(), updateUser.getCreatedBy(), updateUser.getCreatedDate(),
				updateUser.getModifiedBy(), updateUser.getModifiedDate(), updateUser.getId());
	}

	@Override
	public void delete(Integer id) {
		String sql = "DELETE FROM user WHERE id = ?";
		this.update(sql, id);
	}

}
