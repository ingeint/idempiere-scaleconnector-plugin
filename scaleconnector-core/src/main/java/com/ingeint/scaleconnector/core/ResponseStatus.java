/**
 * This file is part of Scale Connector.
 * <p>
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 * <p>
 * Copyright (C) 2015 INGEINT <http://www.ingeint.com>.
 * Copyright (C) Contributors.
 * <p>
 * Contributors:
 * - 2015 Saúl Piña <spina@ingeint.com>.
 */

package com.ingeint.scaleconnector.core;

/**
 * Response status
 */
public enum ResponseStatus {
    /**
     * The request can not be processed
     */
    NOT_UNDERSTOOD("The request can not be processed"),
    /**
     * Server error
     */
    ERROR("Server error"),
    /**
     * Successful connection
     */
    SUCCESS("Successful connection"),
    /**
     * Access forbidden
     */
    FORBIDDEN("Access forbidden");

    public final String notice;

    private ResponseStatus(String notice) {
        this.notice = notice;
    }
}
