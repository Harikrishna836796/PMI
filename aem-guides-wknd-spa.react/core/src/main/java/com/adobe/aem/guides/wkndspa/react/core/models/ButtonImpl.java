/*
 *  Copyright 2015 Adobe Systems Incorporated
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.adobe.aem.guides.wkndspa.react.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.via.ResourceSuperType;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.adobe.cq.wcm.core.components.models.Button;
import com.adobe.cq.wcm.core.components.models.datalayer.ComponentData;
import com.adobe.cq.wcm.core.components.util.AbstractComponentImpl;
import com.day.cq.wcm.api.PageManager;
import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import com.fasterxml.jackson.annotation.JsonProperty;

@Model(adaptables = SlingHttpServletRequest.class, adapters = { Button.class,
		ComponentExporter.class }, resourceType = ButtonImpl.RESOURCE_TYPE)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class ButtonImpl extends AbstractComponentImpl implements Button{

	public static final String RESOURCE_TYPE = "wknd-spa-react/components/button";

	@Self
	@Via(type = ResourceSuperType.class)
	private Button button;

	@Self
	private SlingHttpServletRequest request;
	
	@ScriptVariable
	private PageManager pageManager;
	
	@ValueMapValue
	@Via("resource")
	@Default(values="Select One")
	private String styleVariation;
	
	@ValueMapValue
	@Via("resource")
	@Default(values="Select One")
	private String linkVariation;

	public String getLinkVariation() {
		return linkVariation;
	}

	@Override
	public String getText() {
		return button.getText();
	}

	@SuppressWarnings("deprecation")
	@Override
	@Nullable
	public String getLink() {
		return button.getLink();
	}

	@Override
	@Nullable
	public String getIcon() {
		return button.getIcon();
	}

	@Override
	@Nullable
	public String getAccessibilityLabel() {
		return button.getAccessibilityLabel();
	}

	@NotNull
	@Override
	public String getExportedType() {
		return request.getResource().getResourceType();
	}
	
	@Nullable
	public String getStyleVariation() {
		return styleVariation;
	}
	
	@Override
    @JsonProperty("dataLayer")
    public ComponentData getData() {
        return button.getData();
    }

}