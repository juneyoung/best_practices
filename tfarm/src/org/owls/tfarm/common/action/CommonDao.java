package org.owls.tfarm.common.action;

import java.util.List;

import org.apache.log4j.Logger;
/**
 * 일반적 상황의 CRUD List 의 명세를 정의
 * @author juneyoungoh
 *
 * @param <K>
 * @param <V>
 * @param <EX>
 */
public interface CommonDao <K, V, EX extends Exception> {
	Logger logger = Logger.getLogger(CommonDao.class);	
	public V read (K key) throws EX;
	public List<V> list (K key) throws EX;
	public void create(V value) throws EX;
	public void update(V value) throws EX;
	public void delete(K key) throws EX;
}
