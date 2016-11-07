package org.owls.tfarm.member.dao;

import java.util.Map;

import org.springframework.data.repository.CrudRepository;

public class MongoCrudRepoImpl implements CrudRepository<Map<String, Object>, Long> {

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Iterable<? extends Map<String, Object>> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(Long arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Map<String, Object>> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Map<String, Object>> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> findOne(Long arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Map<String, Object>> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Map<String, Object>> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}
