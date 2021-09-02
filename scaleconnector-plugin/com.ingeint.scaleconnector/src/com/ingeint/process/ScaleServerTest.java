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
import java.util.Date;

import org.compiere.process.ProcessInfoParameter;
import org.compiere.util.AdempiereUserError;

import com.ingeint.base.CustomProcess;
import com.ingeint.model.MSCServerSettings;
import com.ingeint.scaleconnector.client.Client;
import com.ingeint.scaleconnector.core.Request;
import com.ingeint.scaleconnector.core.RequestType;
import com.ingeint.scaleconnector.core.Response;

/**
 * Process to test the connection to the server
 */
public class ScaleServerTest extends CustomProcess {

	private MSCServerSettings record;

	public ScaleServerTest() {
	}

	@Override
	protected void prepare() {
		ProcessInfoParameter[] para = getParameter();

		for (ProcessInfoParameter p : para) {
			String name = p.getParameterName();
			if (name.equals("SC_ServerSettings_ID"))
				record = new MSCServerSettings(getCtx(), p.getParameterAsInt(), get_TrxName());
			else
				log.severe("Unknown Parameter: " + name);
		}
	}

	@Override
	protected String doIt() throws Exception {
		try {
			return connectServerSC();
		} catch (SocketTimeoutException e) {
			throw new AdempiereUserError("Finish timeout", e);
		} catch (Exception e) {
			throw new AdempiereUserError("Error connecting to server", e);
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
	public String connectServerSC() throws SocketTimeoutException, ClassNotFoundException, IOException,
			URISyntaxException, InterruptedException {
		Client client = new Client(record.getHostAddress(), record.getHostPort());
		client.setTimeout(record.getSecondsTimeout() * 1000);
		client.setWebService(record.isWebService());
		Request request = new Request();
		request.setType(RequestType.TEST);
		request.setDate(new Date());
		Response response = client.sendRequest(request);
		return response.getStatusNotice() + ", Server time: " + response.getDate();
	}

}
