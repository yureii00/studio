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
package org.craftercms.studio.api.v1.util.filter;

import org.craftercms.studio.api.v1.to.ContentItemTO;

import static org.craftercms.studio.api.v1.util.StudioConfiguration.CONTENT_TYPES_FILTER_DOCUMENTS_INCLUDE_PATTERN;

public class DocumentFilter extends AbstractFilter {

    /**
     * filtering for documents. compared with contentType and
     * contentType for pages is /cstudio-com/document
     *
     * @param item
     * @return true/false
     */

    public boolean filter(ContentItemTO item) {
        boolean isMatched = match(item.contentType);
        boolean isDocument = (isMatched && !item.component);
        item.document = isDocument;      //it may have been set already, but still resetting.
        return isDocument;
    }

    @Override
    public String getIncludePattern() {
        return studioConfiguration.getProperty(CONTENT_TYPES_FILTER_DOCUMENTS_INCLUDE_PATTERN);
    }
}
