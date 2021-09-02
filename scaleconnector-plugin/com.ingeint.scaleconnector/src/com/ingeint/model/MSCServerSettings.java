/**
 * This file is part of Scale Connector.
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 * 
 * Copyright (C) 2015 INGEINT <http://www.ingeint.com>.
 * Copyright (C) Contributors.
 * 
 * Contributors:
 *    - 2015 Saúl Piña <spina@ingeint.com>.
 */

package com.ingeint.model;

import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import org.compiere.model.Query;

/**
 * Custom Model X_SC_ServerSettings
 */
public class MSCServerSettings extends X_SC_ServerSettings {

	private static final long serialVersionUID = -713397209151149360L;

	public MSCServerSettings(Properties ctx, int SC_ServerSettings_ID, String trxName) {
		super(ctx, SC_ServerSettings_ID, trxName);
	}

	public MSCServerSettings(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	protected boolean beforeDelete() {
		for (MSCScale line : getLines()) {
			line.deleteEx(true);
		}
		return true;
	}

	public List<MSCScale> getLines() {
		return new Query(getCtx(), I_SC_Scale.Table_Name, "SC_ServerSettings_ID=?", get_TrxName())
				.setParameters(get_ID()).list();
	}

}
