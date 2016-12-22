/*
 * Crafter Studio Web-content authoring solution
 * Copyright (C) 2007-2016 Crafter Software Corporation.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.craftercms.studio.impl.v1.util.spring.context;

import org.craftercms.studio.api.v1.ebus.RepositoryEventContext;
import org.craftercms.studio.api.v1.service.security.SecurityProvider;
import org.craftercms.studio.api.v1.service.site.SiteService;
import org.craftercms.studio.api.v1.util.StudioConfiguration;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import static org.craftercms.studio.api.v1.util.StudioConfiguration.JOB_PASSWORD;
import static org.craftercms.studio.api.v1.util.StudioConfiguration.JOB_USERNAME;

/**
 * Created by dejanbrkic on 8/18/15.
 */
public class SiteConfigurationLoader implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        String ticket = securityProvider.authenticate(getAdminUser(), getAdminPassword());
        RepositoryEventContext repositoryEventContext = new RepositoryEventContext(ticket);
        RepositoryEventContext.setCurrent(repositoryEventContext);
        siteService.reloadSiteConfigurations();
    }

    public SiteService getSiteService() { return siteService; }
    public void setSiteService(SiteService siteService) { this.siteService = siteService; }

    public SecurityProvider getSecurityProvider() { return securityProvider; }
    public void setSecurityProvider(SecurityProvider securityProvider) { this.securityProvider = securityProvider; }

    public StudioConfiguration getStudioConfiguration() { return studioConfiguration; }
    public void setStudioConfiguration(StudioConfiguration studioConfiguration) { this.studioConfiguration = studioConfiguration; }

    public String getAdminUser() {
        return studioConfiguration.getProperty(JOB_USERNAME);
    }

    public String getAdminPassword() {
        return studioConfiguration.getProperty(JOB_PASSWORD);
    }

    protected SiteService siteService;
    protected SecurityProvider securityProvider;
    protected StudioConfiguration studioConfiguration;
}
