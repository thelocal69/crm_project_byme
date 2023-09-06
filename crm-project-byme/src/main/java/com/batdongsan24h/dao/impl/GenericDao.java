package com.batdongsan24h.dao.impl;

import java.util.List;

import com.batdongsan24h.mapper.impl.RowMapper;

public interface GenericDao<T> {
	@SuppressWarnings("hiding")
	<T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameter);
	Integer insert(String sql, Object... parameter);
	void update(String sql, Object... parameter);
}
