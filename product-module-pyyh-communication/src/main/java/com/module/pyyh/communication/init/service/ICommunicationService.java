package com.module.pyyh.communication.init.service;

public interface ICommunicationService<R, P> {

	public void operate();
	public R initSource(P p);
	public R registSource(P p);
}
