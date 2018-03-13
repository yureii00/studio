/*
 * Copyright (C) 2007-2018 Crafter Software Corporation. All rights reserved.
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
package org.craftercms.studio.api.v1.asset.processing;

import org.craftercms.studio.api.v1.exception.AssetProcessingException;

/**
 * Resolves a {@link AssetProcessor} based on configuration.
 *
 * @author avasquez
 */
public interface AssetProcessorResolver {

    /**
     * Returns an {@link AssetProcessor} that's compatible with the specified configuration
     *
     * @param config the configuration
     *
     * @return the asset processor for the given configuration
     * @throws AssetProcessingException if there's an error while retrieving the processor or if the configuration is invalid
     */
    AssetProcessor getProcessor(ProcessorConfiguration config) throws AssetProcessingException;

}
