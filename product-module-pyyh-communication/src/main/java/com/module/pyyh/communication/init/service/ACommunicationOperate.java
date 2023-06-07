package com.module.pyyh.communication.init.service;

public abstract class ACommunicationOperate<R, P> implements ICommunicationService<R, P>{
	private P p;
	public ACommunicationOperate(P p){
		this.p = p;
	}
	public void operate() throws Exception{
		initSource(p);
		registSource(p);
	}
}
