package com.module.pyyh.communication.init.serviceimp;

import com.module.pyyh.communication.init.service.ACommunicationOperate;

public class TcpClientImp<R, P> extends ACommunicationOperate<R, P> {

	public TcpClientImp(P p) {
		super(p);
		// TODO Auto-generated constructor stub
		System.out.println("tc");
	}

	@Override
	public R initSource(P p) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public R registSource(P p) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
