package com.adobe.aem.guides.wkndspa.react.core.models;

import org.osgi.annotation.versioning.ConsumerType;

import com.adobe.cq.export.json.ComponentExporter;

@ConsumerType
public interface ButtonP extends ComponentExporter{
	
	String getSortOrder();

}
