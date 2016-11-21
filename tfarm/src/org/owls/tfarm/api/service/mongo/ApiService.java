package org.owls.tfarm.api.service.mongo;

import java.util.List;
import java.util.Map;

import org.owls.tfarm.api.dao.mongo.ApiDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("rawtypes")
public class ApiService implements CommonApiService<String, String, Map, Map, Exception> {
	
	@Autowired
	ApiDao dao;

	@Override
	public void insert(String col, Map param) throws Exception {
		dao.insert(col, param);
	}

	@Override
	public void save(String col, Map param) throws Exception {
		dao.save(col, param);
	}

	@Override
	public List<Map> findAll(String col, Map param) throws Exception {
		return dao.findAll(col, param);
	}

	@Override
	public Map findOne(String col, String key) throws Exception {
		return dao.findOne(col, key);
	}

	@Override
	public void update(String col, Map param) throws Exception {
		dao.update(col, param);
	}

	@Override
	public void remove(String col, String key) throws Exception {
		dao.remove(col, key);
	}
};