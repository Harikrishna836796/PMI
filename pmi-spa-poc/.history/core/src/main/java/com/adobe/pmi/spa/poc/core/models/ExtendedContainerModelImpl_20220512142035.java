/*
 * ***********************************************************************
 * AEM SPA CONFIDENTIAL
 * ___________________
 *
 * Copyright 2021 AEM SPA.
 * All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains the property
 * of AEM SPA and its suppliers, if any. The intellectual and
 * technical concepts contained herein are proprietary to AEM SPA
 * and its suppliers and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from AEM SPA.
 * ***********************************************************************
 */

package com.adobe.pmi.spa.poc.core.models;

import com.adobe.cq.wcm.core.components.models.Container;
import com.adobe.cq.wcm.core.components.models.LayoutContainer;
import com.day.cq.wcm.foundation.model.export.AllowedComponentsExporter;
import com.day.cq.wcm.foundation.model.responsivegrid.ResponsiveGrid;

import java.util.Map;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.via.ResourceSuperType;

@Model(adaptables = SlingHttpServletRequest.class, adapters = {LayoutContainer.class, ComponentExporter.class }, resourceType = ExtendedContainerModelImpl.RESOURCE_TYPE)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class ExtendedContainerModelImpl implements LayoutContainer
{
    protected static final String RESOURCE_TYPE = "pmi-spa-poc/components/container";
    
    @Self @Via(type = ResourceSuperType.class)
    private LayoutContainer layoutContainer;

    @Self @Via(type = ResourceSuperType.class)
    ResponsiveGrid responsiveGrid;

     @Self
    private SlingHttpServletRequest request;

    @Override
    public String getBackgroundStyle() {
        return layoutContainer.getBackgroundStyle();
    }

    @Override
    public String getAppliedCssClasses() {
        return layoutContainer.getAppliedCssClasses();
    }

    @Override
    public Map<String, ? extends ComponentExporter> getExportedItems() {
        return layoutContainer.getExportedItems();
    }

    @Override
    public String[] getExportedItemsOrder() {
        return layoutContainer.getExportedItemsOrder();
    }

    @Override
    public LayoutType getLayout() {
        return layoutContainer.getLayout();
    }

    public int getColumnCount() {
        return responsiveGrid.getColumnCount();
    }

    public AllowedComponentsExporter getAllowedComponents() {
        return responsiveGrid.getExportedAllowedComponents();
    }

    public String getGridClassNames() {
        return responsiveGrid.getGridClassNames();
    }

    public Map<String, String> getColumnClassNames() {
        return responsiveGrid.getColumnClassNames();
    }

    @Override
    public String getAccessibilityLabel() {
        return layoutContainer.getAccessibilityLabel();
    }

    @Override
    public String getRoleAttribute() {
        return layoutContainer.getRoleAttribute();
    }

    @Override
    public String getExportedType() {
        return RESOURCE_TYPE;
    }

    public String getRandom() {
        return "THISISRANDOM";
    }

}
