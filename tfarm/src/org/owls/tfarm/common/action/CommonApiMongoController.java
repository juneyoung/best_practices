package org.owls.tfarm.common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Implementation of this Interface should turn the first argument to \@ParamVariable
 * @author juneyoungoh
 *
 * @param <K>
 * @param <R>
 * @param <EX>
 */
public interface CommonApiMongoController <K, R, EX extends Exception> {
	Logger logger = Logger.getLogger(CommonApiMongoController.class);
	public R read(K col, HttpServletRequest req, HttpServletResponse resp) throws Exception;
	public R list(K col, HttpServletRequest req, HttpServletResponse resp) throws Exception;
}