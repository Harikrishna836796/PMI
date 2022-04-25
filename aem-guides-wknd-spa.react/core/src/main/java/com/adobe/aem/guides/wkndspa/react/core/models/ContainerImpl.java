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

import java.util.Map;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.via.ResourceSuperType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.adobe.cq.wcm.core.components.models.LayoutContainer;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.api.designer.Style;
import com.day.cq.wcm.foundation.model.export.AllowedComponentsExporter;
import com.day.cq.wcm.foundation.model.responsivegrid.ResponsiveGrid;
import com.drew.lang.annotations.Nullable;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.experimental.Delegate;

/**
 * Layout container model implementation.
 */
@Model(adaptables = SlingHttpServletRequest.class, adapters = { LayoutContainer.class,
      ComponentExporter.class }, resourceType = ContainerImpl.RESOURCE_TYPE)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class ContainerImpl implements LayoutContainer   {
   
    private static final Logger logger = LoggerFactory.getLogger(ContainerImpl.class);

   /**
    * The resource type.
    */
   protected static final String RESOURCE_TYPE = "wknd-spa-react/components/container";

   @Self
   @Via(type = ResourceSuperType.class)
   @Delegate(excludes = DelegationExclusionLayoutContainer.class)
   private LayoutContainer layoutContainer;

   @Self
   @Via(type = ResourceSuperType.class)
   private ResponsiveGrid responsiveGrid;
   

   public String getGridClassNames() {
      return responsiveGrid.getGridClassNames();
   }

   public Map<String, String> getColumnClassNames() {
      return responsiveGrid.getColumnClassNames();
   }

   public int getColumnCount() {
      return responsiveGrid.getColumnCount();
   }

   public AllowedComponentsExporter getAllowedComponents() {
      return responsiveGrid.getExportedAllowedComponents();
   }


    @Override
    public String getExportedType() {
       return RESOURCE_TYPE;
    }

   interface DelegationExclusionLayoutContainer {
      String getExportedType();
   }

}