package org.owls.tfarm.common.action.mongo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Mongo 의 document 를 다양한 타입으로 출력할 수 있는 컨트롤러 (restful)
 * Implementation of this Interface should turn the first argument to \@ParamVariable
 * @author juneyoungoh
 *
 * @param <K>
 * @param <R>
 * @param <EX>
 */
public interface CommonMongoController <K, R, Ex extends Exception> {
	Logger logger = Logger.getLogger(CommonMongoController.class);
	public R create(@PathVariable K col, HttpServletRequest req, HttpServletRequest resp) throws Ex;
	public R read(@PathVariable K col, HttpServletRequest req, HttpServletResponse resp) throws Ex;
	public R update(@PathVariable K col, HttpServletRequest req, HttpServletResponse resp) throws Ex;
	public R delete(@PathVariable K col, HttpServletRequest req, HttpServletResponse resp) throws Ex;
	public R list(@PathVariable K col, HttpServletRequest req, HttpServletResponse resp) throws Ex;
}