package com.module.pyyh.communication.init.service;

public interface ICommunicationService<R, P> {

	public R init(P p);
	public R regist(P p);
}
