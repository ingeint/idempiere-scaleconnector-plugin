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

package com.ingeint.scaleconnector.service;

import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortTimeoutException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Reads the serial port of the scale.
 * <p>
 * To read the serial ports used JSSC,
 * http://code.google.com/p/java-simple-serial-connector/
 *
 * <pre>
 * ScaleConnector sc = new ScaleConnector(&quot;COM1&quot;, 9600, 8, 1, 0);
 * sc.setByteCount(15);
 * System.out.println(sc.readString());
 * </pre>
 *
 * @see <a href="http://code.google.com/p/java-simple-serial-connector/">
 * http://code.google.com/p/java-simple-serial-connector/</a>
 * @see <a
 * href="http://en.wikibooks.org/wiki/Serial_Programming/RS-232_Connections"
 * > http://en.wikibooks.org/wiki/Serial_Programming/RS-232_Connections</a>
 */
public class ScaleConnector {

    private final static Logger log = Logger.getLogger(ScaleConnector.class.getName());

    private int timeout;
    private int baud;
    private int dataBits;
    private int stopBits;
    private int parity;
    private int byteCount;
    private int endCharacter;
    private int startCharacter;
    private String serialPort;
    private int readings;
    private int floatingPoint;
    private boolean isStableValue;
    private int stabilityValue;
    private int stabilityValuePosition;
    private int startCutPosition;
    private int endCutPosition;

    /**
     * Initial settings connection
     *
     * @param serialPort Serial port
     * @param baud       Baud rate
     * @param dataBits   Data bits
     * @param stopBits   Stop bits
     * @param parity     Parity
     */
    public ScaleConnector(String serialPort, int baud, int dataBits, int stopBits, int parity) {
        timeout = 5000;
        byteCount = 20;
        startCharacter = 2;
        endCharacter = 3;
        readings = 1;
        isStableValue = false;
        floatingPoint = 0;
        stabilityValue = '0';
        stabilityValuePosition = 1;
        startCutPosition = 1;
        endCutPosition = 18;
        this.baud = baud;
        this.dataBits = dataBits;
        this.stopBits = stopBits;
        this.parity = parity;
        this.serialPort = serialPort;
    }

    public int getStabilityValue() {
        return stabilityValue;
    }

    public void setStabilityValue(int stabilityValue) {
        this.stabilityValue = stabilityValue;
    }

    public int getFloatingPoint() {
        return floatingPoint;
    }

    public void setFloatingPoint(int floatingPoint) {
        this.floatingPoint = floatingPoint;
    }

    public boolean isStableValue() {
        return isStableValue;
    }

    public void setIsStableValue(boolean isStableValue) {
        this.isStableValue = isStableValue;
    }

    public int getStabilityValuePosition() {
        return stabilityValuePosition;
    }

    public void setStabilityValuePosition(int stabilityValuePosition) {
        this.stabilityValuePosition = stabilityValuePosition;
    }

    public int getStartCutPosition() {
        return startCutPosition;
    }

    public void setStartCutPosition(int startCutPosition) {
        this.startCutPosition = startCutPosition;
    }

    public int getEndCutPosition() {
        return endCutPosition;
    }

    public void setEndCutPosition(int endCutPosition) {
        this.endCutPosition = endCutPosition;
    }

    /**
     * @return Number of readings
     */
    public int getReadings() {
        return readings;
    }

    /**
     * @param Number of readings
     */
    public void setReadings(int readings) {
        this.readings = readings;
    }

    /**
     * @return End Character, default 3
     */
    public int getEndCharacter() {
        return endCharacter;
    }

    /**
     * Set the end character to read the value, default 3
     *
     * @param endCharacter
     */
    public void setEndCharacter(int endCharacter) {
        this.endCharacter = endCharacter;
    }

    /**
     * @return Start Character, default 2
     */
    public int getStartCharacter() {
        return startCharacter;
    }

    /**
     * Set the start character to read the value, default 2
     *
     * @param startCharacter
     */
    public void setStartCharacter(int startCharacter) {
        this.startCharacter = startCharacter;
    }

    /**
     * @return Byte count, default 20
     */
    public int getByteCount() {
        return byteCount;
    }

    /**
     * Set byte count, number of bytes to read and stored in a buffer, default
     * 20
     *
     * @param byteCount Byte count
     */
    public void setByteCount(int byteCount) {
        this.byteCount = byteCount;
    }

    /**
     * @return Timeout, default 10000
     */
    public int getTimeout() {
        return timeout;
    }

    /**
     * Set timeout for get port value, default 10000
     *
     * @param timeout Timeout
     */
    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    /**
     * @return Baud
     */
    public int getBaud() {
        return baud;
    }

    /**
     * Set communication speed
     *
     * @param baud Baud
     */
    public void setBaud(int baud) {
        this.baud = baud;
    }

    /**
     * @return Data bits
     */
    public int getDataBits() {
        return dataBits;
    }

    /**
     * Set data bits
     *
     * @param dataBits Data bits
     */
    public void setDataBits(int dataBits) {
        this.dataBits = dataBits;
    }

    /**
     * @return Stop bits
     */
    public int getStopBits() {
        return stopBits;
    }

    /**
     * Set stop bits
     *
     * @param stopBits
     */
    public void setStopBits(int stopBits) {
        this.stopBits = stopBits;
    }

    /**
     * @return Parity
     */
    public int getParity() {
        return parity;
    }

    /**
     * Set parity
     *
     * @param parity Parity
     */
    public void setParity(int parity) {
        this.parity = parity;
    }

    /**
     * @return Serial port
     */
    public String getSerialPort() {
        return serialPort;
    }

    /**
     * Set serial port to connect
     *
     * @param serialPort
     */
    public void setSerialPort(String serialPort) {
        this.serialPort = serialPort;
    }

    /**
     * Extracts the desired value using the start and end character
     *
     * @param string String to format
     * @return Value
     */
    public Result getValue(String string) {
        String sc = String.valueOf((char) startCharacter);
        if (sc.matches("[^a-zA-Z]")){
            sc = "\\"+sc;
        }

        String ec = String.valueOf((char) endCharacter);
        if (ec.matches("[^a-zA-Z]")){
            ec = "\\"+ec;
        }

        String patternString = String.format("%s([^%s%s]+)%s", sc, sc, ec, ec);
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(string);
        HashMap<Result, Integer> list = new HashMap<>();

        String raw = "";
        String value = "";
        String stability = "";

        while (matcher.find()) {
            raw = matcher.group(0);
            stability = raw.substring(stabilityValuePosition, stabilityValuePosition + 1);
            value = raw.substring(startCutPosition, endCutPosition + 1).replaceAll("[^0-9]", "");
            value = String.valueOf(Integer.parseInt(value));

            if (floatingPoint > 0)
                value = String.valueOf(Integer.parseInt(value) / Math.pow(10, floatingPoint));

            Result result = new Result(raw, value, stability);

            if (list.containsKey(result)) {
                list.put(result, list.get(result) + 1);
            } else {
                list.put(result, 1);
            }
        }

        Iterator<Result> iterator = list.keySet().iterator();

        int max = 0;
        Result keyMax = null;

        while (iterator.hasNext()) {
            Result stringTemp = iterator.next();
            if (list.get(stringTemp) > max) {
                max = list.get(stringTemp);
                keyMax = stringTemp;
            }
        }

        return keyMax;
    }

    /**
     * Read bytes from the serial port and return the value. This method uses
     * the readings for select the value
     *
     * @return Value
     * @throws SerialPortException        If an error occurred when reading from the input stream
     * @throws SerialPortTimeoutException If timeout expires before connecting
     */
    public synchronized String readValue() throws SerialPortException, SerialPortTimeoutException {
        HashMap<Result, Integer> list = new HashMap<>();

        for (int i = 0; i < readings; i++) {
            Result result = getValue(readString());
            if (list.containsKey(result)) {
                list.put(result, list.get(result) + 1);
            } else {
                list.put(result, 1);
            }
        }
        Iterator<Result> iterator = list.keySet().iterator();

        int max = 0;
        Result keyMax = null;

        while (iterator.hasNext()) {
            Result stringTemp = iterator.next();
            if (list.get(stringTemp) > max) {
                max = list.get(stringTemp);
                keyMax = stringTemp;
            }
        }

        if(keyMax == null)
            return "";

        if (keyMax.getStability().equals(stabilityValue)) {
            isStableValue = true;
        } else {
            isStableValue = false;
        }

        return keyMax.getValue();
    }

    /**
     * Read string from the serial port
     *
     * @return String
     * @throws SerialPortException        If an error occurred when reading from the input stream
     * @throws SerialPortTimeoutException If timeout expires before connecting
     */
    public synchronized String readString() throws SerialPortException, SerialPortTimeoutException {
        return new String(readBytes());
    }

    /**
     * Read bytes from the serial port
     *
     * @return Bytes
     * @throws SerialPortTimeoutException If an error occurred when reading from the input stream
     * @throws SerialPortException        If timeout expires before connecting
     */
    public synchronized byte[] readBytes() throws SerialPortTimeoutException, SerialPortException {
        SerialPort sp = new SerialPort(serialPort);
        byte[] buffer = null;
        try {
            sp.openPort();
            sp.setParams(baud, dataBits, stopBits, parity);
            sp.purgePort(SerialPort.PURGE_RXCLEAR);
            sp.purgePort(SerialPort.PURGE_TXCLEAR);
            buffer = sp.readBytes(byteCount, timeout);
            log.info("Byte Count: " + byteCount);
            log.info("Value: " + new String(buffer));
        } catch (SerialPortTimeoutException e) {
            throw e;
        } catch (SerialPortException e) {
            throw e;
        } finally {
            if (sp.isOpened())
                sp.closePort();
        }

        return buffer;
    }

}
