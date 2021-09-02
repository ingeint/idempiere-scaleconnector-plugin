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

package com.ingeint.scaleconnector.client;

import com.ingeint.scaleconnector.core.Request;
import com.ingeint.scaleconnector.core.Response;
import com.ingeint.scaleconnector.core.ResponseStatus;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.logging.Logger;

/**
 * Send a request to the Scale Server.
 *
 * <pre>
 * Client client = new Client(&quot;localhost&quot;, 5000);
 * client.setTimeout(1000);
 * Request request = new Request();
 * request.setType(RequestType.TEST);
 * request.setDate(Calendar.getInstance().getTime());
 * Response response = client.sendRequest(request);
 * </pre>
 */
public class Client {

    private static Logger logger = Logger.getLogger(Client.class.getName());

    private int port;
    private String host;
    private int timeout;
    private boolean isWebService;
    private String protocol;
    private String uri;

    /**
     * @param host The Host name
     * @param port The Port number
     */
    public Client(String host, int port) {
        this.port = port;
        this.host = host;
        timeout = 10000;
        protocol = "http";
        uri = "/read";
    }

    /**
     * @return Web Service Protocol
     */
    public String getProtocol() {
        return protocol;
    }

    /**
     * Set protocol
     *
     * @param protocol Web Service Protocol
     */
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    /**
     * @return Web Service URI
     */
    public String getUri() {
        return uri;
    }

    /**
     * Set Web Service URI
     *
     * @param uri Web Service URI
     */
    public void setUri(String uri) {
        this.uri = uri;
    }

    /**
     * @return Port
     */
    public int getPort() {
        return port;
    }

    /**
     * @param port Port to set
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * @return Host
     */
    public String getHost() {
        return host;
    }

    /**
     * @param host Host to set
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * @return Timeout, default 10000
     */
    public int getTimeout() {
        return timeout;
    }

    /**
     * Set timeout, default 10000
     *
     * @param timeout Timeout to set
     */
    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    /**
     * @return True: If the remote host is web service
     */
    public boolean isWebService() {
        return isWebService;
    }

    /**
     * Set type server
     *
     * @param isWebService
     */
    public void setWebService(boolean isWebService) {
        this.isWebService = isWebService;
    }

    /**
     * Sends a request to the server, the request must contain all information
     * necessary to obtain the desired response
     *
     * @param request The request to send
     * @return The response obtained
     * @throws SocketTimeoutException If timeout expires before connecting
     * @throws IOException            If an error occurred when reading from the input stream
     * @throws ClassNotFoundException If the returned object is of a class unknown
     * @see <a href="http://code.google.com/p/json-simple/">
     * http://code.google.com/p/json-simple/</a>
     */
    public Response sendRequest(Request request) throws SocketTimeoutException, IOException, ClassNotFoundException {
        logger.info("Connecting to server");
        Response response = null;
        if (isWebService) {
            String url = String.format("%s://%s:%s%s", protocol, host, port, uri);

            RestClient restClient = new RestClient();

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("type", request.getType().toString());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
            System.out.println(sdf.format(request.getDate()));
            jsonObject.put("date", sdf.format(request.getDate()));
            jsonObject.put("parameters", request.getParameters());

            String jsonResponse = restClient.sendRequest(url, jsonObject.toJSONString());

            try {
                JSONParser jsonParser = new JSONParser();
                JSONObject obj = (JSONObject) jsonParser.parse(jsonResponse);
                JSONObject objData = (JSONObject) jsonParser.parse(obj.get("data").toString());

                response = new Response();
                response.setServerMessage(obj.get("serverMessage").toString());
                response.setDate(Calendar.getInstance().getTime());
                response.setStatus(ResponseStatus.valueOf(obj.get("status").toString().toUpperCase()));

                @SuppressWarnings("unchecked")
                Iterator<String> i2 = objData.keySet().iterator();

                while (i2.hasNext()) {
                    String string = i2.next();
                    response.addValue(string, objData.get(string).toString());
                }

            } catch (ParseException e) {
                logger.severe("Error create JSON");
                e.printStackTrace();
            }

        } else {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(host, port), timeout);
            socket.setSoTimeout(timeout);

            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(request);
            out.flush();
            logger.info("Data sent");

            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            Object readObject = in.readObject();
            response = readObject.getClass().equals(Response.class) ? (Response) readObject : null;
            logger.info("Data received");

            out.close();
            in.close();
            socket.close();
        }
        return response;
    }

}
