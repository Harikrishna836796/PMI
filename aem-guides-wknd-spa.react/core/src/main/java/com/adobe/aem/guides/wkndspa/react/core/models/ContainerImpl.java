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

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.via.ResourceSuperType;
import org.apache.sling.models.factory.ModelFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.adobe.cq.wcm.core.components.internal.models.v1.AbstractContainerImpl;
import com.adobe.cq.wcm.core.components.internal.models.v1.ResourceListItemImpl;
import com.adobe.cq.wcm.core.components.models.LayoutContainer;
import com.adobe.cq.wcm.core.components.models.ListItem;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.api.designer.Style;
import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Layout container model implementation.
 */
@Model(adaptables = SlingHttpServletRequest.class, adapters = { LayoutContainer.class,
		ComponentExporter.class }, resourceType = ContainerImpl.RESOURCE_TYPE)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class ContainerImpl extends AbstractContainerImpl  implements LayoutContainer   {
	
    private static final Logger logger = LoggerFactory.getLogger(ContainerImpl.class);

	/**
	 * The resource type.
	 */
	protected static final String RESOURCE_TYPE = "wknd-spa-react/components/container";

	/*
	 * @Self
	 * 
	 * @Via(type = ResourceSuperType.class) private ResponsiveGrid responsiveGrid;
	 */
	
	@Self
	@Via(type = ResourceSuperType.class)
	private LayoutContainer layoutContainer;
	
	  /**
     * The layout type.
     */
    private LayoutType layout;
    
    @ScriptVariable(injectionStrategy = InjectionStrategy.OPTIONAL)
    @JsonIgnore
    @Nullable
    protected Style currentStyle;
	/**
	 * The current resource.
	 */
	@ScriptVariable
	private Resource resource;

	@Self
	private SlingHttpServletRequest request;

	@ScriptVariable
	private PageManager pageManager;

	 
	 public static final String ATTR_HIERARCHY_ENTRY_POINT_PAGE = "com.adobe.aem.spa.project.core.models.Page.entryPointPage";

	    /**
	     * Request attribute key of the component context
	     */
	    public static final String ATTR_COMPONENT_CONTEXT = "com.day.cq.wcm.componentcontext";

	    /**
	     * Request attribute key of the current page
	     */
	    public static final String ATTR_CURRENT_PAGE = "currentPage";

	    @Inject
	    private ModelFactory modelFactory;
	 /**
     * Initialize the model.
     */
		/*
		 * @PostConstruct protected void postInit() { try { Resource resource =
		 * request.getResource(); Page currentPage = resource.adaptTo(Page.class);
		 * 
		 * // If the 'LayoutContainer' instance is either 'null' or it has no items
		 * available then we can // attempt to get a new instance using a wrapped
		 * request and adapting it to 'LayoutContainer'. if (layoutContainer == null ||
		 * layoutContainer.getItems().size() == 0) { layoutContainer =
		 * modelFactory.getModelFromWrappedRequest(
		 * createHierarchyServletRequest(request, currentPage, currentPage), resource,
		 * LayoutContainer.class); } } catch (Exception e) { System.out.println("e ::" +
		 * e.getMessage());
		 * logger.info("Unable to bind the current page request to 'LayoutContainer'",
		 * e); } }
		 */

	
	
	  @NotNull protected List<ResourceListItemImpl> readItems() { return
	  getChildren().stream() .map(res -> new ResourceListItemImpl(linkHandler, res,
	  getId(), component)) .collect(Collectors.toList()); }
	 

   
    @Override
	public String getBackgroundStyle() {
		return layoutContainer.getBackgroundStyle();
	}


	public String[] getDataLayerShownItems() {
		return null;
	}

	@Override
	public @NotNull LayoutType getLayout() {
		return layoutContainer.getLayout();
	}

	@Override
	@Nullable
	public String getAccessibilityLabel() {
		return layoutContainer.getAccessibilityLabel();
	}

	@Override
	public @NotNull List<ListItem> getItems() {
		return layoutContainer.getItems();
	}
	
	@Override
	public @NotNull String[] getExportedItemsOrder() {
		return layoutContainer.getExportedItemsOrder();
	}
	
	
	  @Override public String getAppliedCssClasses() { return
	  layoutContainer.getAppliedCssClasses(); }
	 

	@Override
	@Nullable
	public String getRoleAttribute() {
		return layoutContainer.getRoleAttribute();
	}

	/*
	 * private SlingHttpServletRequest createHierarchyServletRequest(
	 * 
	 * @NotNull SlingHttpServletRequest request,
	 * 
	 * @NotNull com.day.cq.wcm.api.Page page, @Nullable com.day.cq.wcm.api.Page
	 * entryPage) { SlingHttpServletRequest wrapperRequest = new
	 * SlingHttpServletRequestWrapper(request);
	 * 
	 * ComponentContext componentContext = (ComponentContext)
	 * request.getAttribute(ATTR_COMPONENT_CONTEXT);
	 * 
	 * // When traversing child pages, the currentPage must be updated
	 * HierarchyComponentContextWrapper componentContextWrapper = new
	 * HierarchyComponentContextWrapper(componentContext, page);
	 * wrapperRequest.setAttribute(ATTR_COMPONENT_CONTEXT, componentContextWrapper);
	 * wrapperRequest.setAttribute(ATTR_CURRENT_PAGE, page);
	 * wrapperRequest.setAttribute(ATTR_HIERARCHY_ENTRY_POINT_PAGE, entryPage);
	 * 
	 * return wrapperRequest; }
	 */
	

}