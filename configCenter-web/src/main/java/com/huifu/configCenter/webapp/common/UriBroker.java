package com.huifu.configCenter.webapp.common;

import java.util.List;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;

public class UriBroker implements TemplateMethodModel {
	
	private String domainName;

	@Override
	public Object exec(List list) throws TemplateModelException {
		return  domainName;
		
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getDomainName() {
		return domainName;
	}

}
