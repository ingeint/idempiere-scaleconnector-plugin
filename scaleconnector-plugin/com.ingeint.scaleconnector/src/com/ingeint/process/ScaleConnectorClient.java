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
import java.util.Date;
import java.util.HashMap;

import com.ingeint.model.MSCScale;
import com.ingeint.scaleconnector.client.Client;
import com.ingeint.scaleconnector.core.*;

/**
 * This class allows you to connect to the scale
 */
public class ScaleConnectorClient {

	private MSCScale recordScale;
	private Response response;

	/**
	 * Set Scale Settings
	 * 
	 * @param recordScale MSCScale
	 */
	public ScaleConnectorClient(MSCScale recordScale) {
		this.recordScale = recordScale;
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
	 */
	public Response sendRequest() throws SocketTimeoutException, ClassNotFoundException, IOException {
		HashMap<String, String> parameters = new HashMap<String, String>();

		parameters.put("baud", String.valueOf(recordScale.getBaud()));
		parameters.put("serialport", recordScale.getSerialPort());
		parameters.put("stopbits", String.valueOf(recordScale.getStopBits()));
		parameters.put("parity", String.valueOf(recordScale.getParity()));
		parameters.put("databits", String.valueOf(recordScale.getDataBits()));
		parameters.put("bytecount", String.valueOf(recordScale.getByteCount()));
		parameters.put("startcharacter", String.valueOf(recordScale.getStartCharacter()));
		parameters.put("endcharacter", String.valueOf(recordScale.getEndCharacter()));
		parameters.put("readings", String.valueOf(recordScale.getReadings()));
		parameters.put("startcut", String.valueOf(recordScale.getStartCutPosition()));
		parameters.put("endcut", String.valueOf(recordScale.getEndCutPosition()));
		parameters.put("stabilitypos", String.valueOf(recordScale.getStabilityPosition()));
		parameters.put("stability", String.valueOf(recordScale.getStability()));
		parameters.put("floatingpoint", String.valueOf(recordScale.getFloatingPoint()));

		Client client = new Client(recordScale.getSC_ServerSettings().getHostAddress(),
				recordScale.getSC_ServerSettings().getHostPort());
		client.setTimeout(recordScale.getSC_ServerSettings().getSecondsTimeout() * 1000);
		client.setWebService(recordScale.getSC_ServerSettings().isWebService());
		Request request = new Request();
		request.setType(RequestType.READ_PORT);
		request.setDate(new Date());
		request.setParameters(parameters);
		response = client.sendRequest(request);
		return response;
	}

	public ResponseStatus getResposeStatus() {
		return response.getStatus();
	}

	public double getValue() {

		if (response.getValue("value") == null) {
			return 0;
		}
		if (!response.getValue("value").matches("[0-9\\.]+")) {
			return 0;
		}
		try {
			return Double.parseDouble(response.getValue("value"));
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public Response getResponse() {
		return response;
	}

	public boolean getStability() {
		return Boolean.parseBoolean(response.getValue("isstable"));
	}

	public String getStringValue() {
		return response.getValue("value");
	}
}
