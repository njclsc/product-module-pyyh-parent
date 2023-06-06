package com.module.pyyh.communication.pojo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CommunicationConfigPojo {
	private String type;
	private boolean used;
	private List<String> addresses;
	private String impClass;
	private int miniBuf;
	private int maxBuf;
	private int initBuf;
	private int queueSize;
}
