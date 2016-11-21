package org.owls.tfarm.api.service.mongo;

import java.util.List;

// API 서비스의 명세를 정의한다.
// C(insert/save) R U D 를 정의하며 그 외의 기능 (Ex> Paging) 은 구현체에서 처리할 것 
public interface CommonApiService <C, K, P, R, Ex extends Exception> {
	public void insert (C col, P param) throws Ex;
	public void save (C col, P param) throws Ex;
	public R findOne (C col, K pkey) throws Ex;
	public void update (C col, P param) throws Ex;
	public void remove (C col, K key) throws Ex;
	public List<R> findAll (C col, P param) throws Ex;
};