package com.module.pyyh.communication.init.service;

public interface ICommunicationService<R, P> {

	public void operate() throws Exception;
	public R initSource(P p) throws Exception;
	public R registSource(P p) throws Exception;
}
