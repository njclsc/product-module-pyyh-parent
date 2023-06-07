package com.module.pyyh.communication.pojo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class LizerConfigPojo {
	private String type;
	private String impClass;
	private List<String> handlers;
	private List<String> businessOrder;
}
