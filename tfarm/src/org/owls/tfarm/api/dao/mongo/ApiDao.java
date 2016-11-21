package org.owls.tfarm.api.dao.mongo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

// insert save findOne findAll update remove 
@Repository
@SuppressWarnings("rawtypes")
public class ApiDao {
	
	@Autowired
	MongoTemplate template;
	
	public void insert(String col, Map param) throws Exception {
		template.insert(param, col);
	}
	
	public void save(String col, Map param) throws Exception {
		template.save(param, col);
	}
	
	public Map findOne(String col, Object key) throws Exception {
		return template.findOne(Query.query(Criteria.where("id").is(key)), Map.class, col);
	}
	
	public List<Map> findAll(String col, Map param) throws Exception {
		return template.findAll(Map.class, col);
	}
	
	public void update(String col, Map param) throws Exception {
		//??
	}
	
	public void remove(String col, Object key) throws Exception {
		template.remove(Query.query(Criteria.where("id").is(key)), Map.class, col);
	}

//	@SuppressWarnings("unchecked")
//	public Map<String, Object> findOne(String col, String key) throws Exception {
//		
//		//콜렉션에서 key 필드를 찾는다.
//		//DBCollection collection = template.getCollection(col);
//		Query findOneQuery = new Query();
//		findOneQuery.addCriteria(Criteria.where("id").is(key));
//		return template.findOne(findOneQuery, Map.class, col);
//	}
};
