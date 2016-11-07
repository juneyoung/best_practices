package org.owls.tfarm.api.service.mongo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.owls.tfarm.api.dao.mongo.ApiDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings({"rawtypes", "unchecked"})
public class ApiService {
	
	@Autowired
	ApiDao dao;
	
	public Map read(String col, String key) throws Exception {
		return dao.read(col, key);
	}
	
	public Map list(String col) throws Exception {
		Map rtn = new HashMap();
		List<Map> list = dao.list(col);
		rtn.put("items", list);
		rtn.put("total", list.size());
		return rtn;
	}
}
