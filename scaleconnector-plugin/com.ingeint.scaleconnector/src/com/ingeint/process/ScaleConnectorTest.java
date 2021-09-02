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

package com.ingeint.process;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.URISyntaxException;

import org.compiere.process.ProcessInfoParameter;
import org.compiere.util.AdempiereUserError;

import com.ingeint.base.CustomProcess;
import com.ingeint.model.MSCScale;
import com.ingeint.model.MSCServerSettings;
import com.ingeint.scaleconnector.core.Response;
import com.ingeint.scaleconnector.core.ResponseStatus;

/**
 * Process to test the connection to scale
 * 
 */
public class ScaleConnectorTest extends CustomProcess {

	private MSCScale recordScale;
	@SuppressWarnings("unused")
	private MSCServerSettings recordServer;

	public ScaleConnectorTest() {
	}

	@Override
	protected void prepare() {
		ProcessInfoParameter[] para = getParameter();
		for (ProcessInfoParameter p : para) {
			String name = p.getParameterName();
			if (name.equals("SC_ServerSettings_ID"))
				recordServer = new MSCServerSettings(getCtx(), p.getParameterAsInt(), get_TrxName());
			else if (name.equals("SC_Scale_ID"))
				recordScale = new MSCScale(getCtx(), p.getParameterAsInt(), get_TrxName());
			else
				log.severe("Unknown Parameter: " + name);
		}

	}

	@Override
	protected String doIt() throws Exception {
		try {
			return connectServer();
		} catch (SocketTimeoutException e) {
			throw new AdempiereUserError("Finish timeout", e);
		} catch (Exception e) {
			throw new AdempiereUserError("Error getting value", e);
		}
	}

	/**
	 * Sends a request to the server, the request must contain all information
	 * necessary to obtain the desired response
	 * 
	 * @return The response obtained
	 * @throws SocketTimeoutException If timeout expires before connecting
	 * @throws IOException            If an error occurred when reading from the
	 *                                input stream
	 * @throws ClassNotFoundException If the returned object is of a class unknown
	 * @throws InterruptedException
	 * @throws URISyntaxException
	 */
	public String connectServer() throws SocketTimeoutException, ClassNotFoundException, IOException,
			URISyntaxException, InterruptedException {

		ScaleConnectorClient scc = new ScaleConnectorClient(recordScale);
		Response response = scc.sendRequest();

		if (response.getStatus().equals(ResponseStatus.SUCCESS))
			return response.getStatusNotice() + ", Server time: " + response.getDate() + ", Serial port: "
					+ response.getValue("serialport") + ", Value: " + response.getValue("value") + ", Is Stable: "
					+ response.getValue("isstable");
		else
			throw new AdempiereUserError(response.getStatusNotice() + ", Server time: " + response.getDate());
	}
}
