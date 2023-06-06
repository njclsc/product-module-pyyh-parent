package com.module.pyyh.communication.init.service;

public abstract class ACommunicationOperate<R, P> implements ICommunicationService<R, P>{
	private P p;
	public ACommunicationOperate(P p){
		this.p = p;
	}
	public void operate(){
		initSource(p);
		registSource(p);
	}
}
