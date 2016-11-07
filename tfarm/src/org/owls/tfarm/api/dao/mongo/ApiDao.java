package org.owls.tfarm.api.dao.mongo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ApiDao {
	
	@Autowired
	MongoTemplate template;

	@SuppressWarnings("unchecked")
	public Map<String, Object> read(String col, String key) throws Exception {
		
		//콜렉션에서 key 필드를 찾는다.
		//DBCollection collection = template.getCollection(col);
		Query findOneQuery = new Query();
		findOneQuery.addCriteria(Criteria.where("id").is(key));
		return template.findOne(findOneQuery, Map.class, col);
	}

	@SuppressWarnings("rawtypes")
	public List<Map> list(String col) throws Exception {
		return template.findAll(Map.class, col);
	}

	public void create(Map<String, Object> value) throws Exception {
	}

	public void update(Map<String, Object> value) throws Exception {
	}

	public void delete(String key) throws Exception {
	}
};
