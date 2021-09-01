package com.ingeint.scaleconnector.gui.cli;

import com.ingeint.scaleconnector.gui.feature.SCUIFeature;
import com.ingeint.scaleconnector.service.ScaleConnector;
import jline.ConsoleReader;
import jssc.SerialPortTimeoutException;
import lombok.extern.slf4j.Slf4j;
import picocli.CommandLine.Command;

import java.io.IOException;
import java.util.concurrent.Callable;

@Slf4j
@Command(name = "read", description = "Reads the serial port (interactive command)")
public class ReadCommand implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        try {
            ConsoleReader console = new ConsoleReader();

            String temp = console.readLine(String.format("Serial Port (%s): ", SCUIFeature.get("DEFAULT_SERIALPORT")));
            if (!temp.trim().isEmpty()) {
                SCUIFeature.set("DEFAULT_SERIALPORT", temp.trim());
            }

            boolean readNext;
            do {
                temp = console.readLine(String.format("Baud (%s): ", SCUIFeature.get("DEFAULT_BAUD")));
                if (temp.trim().isEmpty()) {
                    readNext = true;
                } else if (!temp.matches("[0-9]+")) {
                    System.out.println("Input must be numbers");
                    readNext = false;
                } else {
                    readNext = true;
                    SCUIFeature.set("DEFAULT_BAUD", temp.trim());
                }
            } while (!readNext);

            do {
                temp = console.readLine(String.format("Data Bits (%s): ", SCUIFeature.get("DEFAULT_DATABITS")));
                if (temp.trim().isEmpty()) {
                    readNext = true;
                } else if (!temp.matches("[0-9]+")) {
                    System.out.println("Input must be numbers");
                    readNext = false;
                } else {
                    readNext = true;
                    SCUIFeature.set("DEFAULT_DATABITS", temp.trim());
                }
            } while (!readNext);

            do {
                temp = console.readLine(String.format("Stop Bits (%s): ", SCUIFeature.get("DEFAULT_STOPBITS")));
                if (temp.trim().isEmpty()) {
                    readNext = true;
                } else if (!temp.matches("[0-9]+")) {
                    System.out.println("Input must be numbers");
                    readNext = false;
                } else {
                    readNext = true;
                    SCUIFeature.set("DEFAULT_STOPBITS", temp.trim());
                }
            } while (!readNext);

            do {
                temp = console.readLine(String.format("Parity (%s): ", SCUIFeature.get("DEFAULT_PARITY")));
                if (temp.trim().isEmpty()) {
                    readNext = true;
                } else if (!temp.matches("[0-9]+")) {
                    System.out.println("Input must be numbers");
                    readNext = false;
                } else {
                    readNext = true;
                    SCUIFeature.set("DEFAULT_PARITY", temp.trim());
                }
            } while (!readNext);

            do {
                temp = console.readLine(String.format("Start Character (%s): ", SCUIFeature.get("DEFAULT_STARTCHARACTER")));
                if (temp.trim().isEmpty()) {
                    readNext = true;
                } else if (!temp.matches("[0-9]+")) {
                    System.out.println("Input must be numbers");
                    readNext = false;
                } else {
                    readNext = true;
                    SCUIFeature.set("DEFAULT_STARTCHARACTER", temp.trim());
                }
            } while (!readNext);

            do {
                temp = console.readLine(String.format("End Character (%s): ", SCUIFeature.get("DEFAULT_ENDCHARACTER")));
                if (temp.trim().isEmpty()) {
                    readNext = true;
                } else if (!temp.matches("[0-9]+")) {
                    System.out.println("Input must be numbers");
                    readNext = false;
                } else {
                    readNext = true;
                    SCUIFeature.set("DEFAULT_ENDCHARACTER", temp.trim());
                }
            } while (!readNext);

            do {
                temp = console.readLine(String.format("Byte Count (%s): ", SCUIFeature.get("DEFAULT_BYTECOUNT")));
                if (temp.trim().isEmpty()) {
                    readNext = true;
                } else if (!temp.matches("[0-9]+")) {
                    System.out.println("Input must be numbers");
                    readNext = false;
                } else {
                    readNext = true;
                    SCUIFeature.set("DEFAULT_BYTECOUNT", temp.trim());
                }
            } while (!readNext);

            do {
                temp = console.readLine(String.format("Readings (%s): ", SCUIFeature.get("DEFAULT_READINGS")));
                if (temp.trim().isEmpty()) {
                    readNext = true;
                } else if (!temp.matches("[0-9]+")) {
                    System.out.println("Input must be numbers");
                    readNext = false;
                } else {
                    readNext = true;
                    SCUIFeature.set("DEFAULT_READINGS", temp.trim());
                }
            } while (!readNext);

            do {
                temp = console.readLine(String.format("Start Cut Position (%s): ", SCUIFeature.get("DEFAULT_STARTCUT")));
                if (temp.trim().isEmpty()) {
                    readNext = true;
                } else if (!temp.matches("[0-9]+")) {
                    System.out.println("Input must be numbers");
                    readNext = false;
                } else {
                    readNext = true;
                    SCUIFeature.set("DEFAULT_STARTCUT", temp.trim());
                }
            } while (!readNext);

            do {
                temp = console.readLine(String.format("End Cut Position (%s): ", SCUIFeature.get("DEFAULT_ENDCUT")));
                if (temp.trim().isEmpty()) {
                    readNext = true;
                } else if (!temp.matches("[0-9]+")) {
                    System.out.println("Input must be numbers");
                    readNext = false;
                } else {
                    readNext = true;
                    SCUIFeature.set("DEFAULT_ENDCUT", temp.trim());
                }
            } while (!readNext);

            do {
                temp = console.readLine(String.format("Stability Position (%s): ", SCUIFeature.get("DEFAULT_SINDICATORPOS")));
                if (temp.trim().isEmpty()) {
                    readNext = true;
                } else if (!temp.matches("[0-9]+")) {
                    System.out.println("Input must be numbers");
                    readNext = false;
                } else {
                    readNext = true;
                    SCUIFeature.set("DEFAULT_SINDICATORPOS", temp.trim());
                }
            } while (!readNext);

            do {
                temp = console.readLine(String.format("Stability (%s): ", SCUIFeature.get("DEFAULT_SINDICATOR")));
                if (temp.trim().isEmpty()) {
                    readNext = true;
                } else if (!temp.matches("[0-9]+")) {
                    System.out.println("Input must be numbers");
                    readNext = false;
                } else {
                    readNext = true;
                    SCUIFeature.set("DEFAULT_SINDICATOR", temp.trim());
                }
            } while (!readNext);

            do {
                temp = console.readLine(String.format("Floating Point (%s): ", SCUIFeature.get("DEFAULT_FPOINT")));
                if (temp.trim().isEmpty()) {
                    readNext = true;
                } else if (!temp.matches("[0-9]+")) {
                    System.out.println("Input must be numbers");
                    readNext = false;
                } else {
                    readNext = true;
                    SCUIFeature.set("DEFAULT_FPOINT", temp.trim());
                }
            } while (!readNext);
        } catch (IOException e) {
            log.error("Error reading data");
            e.printStackTrace();
            return 1;
        }

        int baud = Integer.parseInt(SCUIFeature.get("DEFAULT_BAUD").trim());
        int dataBits = Integer.parseInt(SCUIFeature.get("DEFAULT_DATABITS").trim());
        int stopBits = Integer.parseInt(SCUIFeature.get("DEFAULT_STOPBITS").trim());
        int parity = Integer.parseInt(SCUIFeature.get("DEFAULT_PARITY").trim());
        int byteCount = Integer.parseInt(SCUIFeature.get("DEFAULT_BYTECOUNT").trim());
        int readings = Integer.parseInt(SCUIFeature.get("DEFAULT_READINGS").trim());
        String serialPort = SCUIFeature.get("DEFAULT_SERIALPORT");
        int startCharacter = Integer.parseInt(SCUIFeature.get("DEFAULT_STARTCHARACTER").trim());
        int endCharacter = Integer.parseInt(SCUIFeature.get("DEFAULT_ENDCHARACTER").trim());
        int startCut = Integer.parseInt(SCUIFeature.get("DEFAULT_STARTCUT"));
        int endCut = Integer.parseInt(SCUIFeature.get("DEFAULT_ENDCUT"));
        int sIndicatorPos = Integer.parseInt(SCUIFeature.get("DEFAULT_SINDICATORPOS"));
        int sIndicator = Integer.parseInt(SCUIFeature.get("DEFAULT_SINDICATOR"));
        int fPoint = Integer.parseInt(SCUIFeature.get("DEFAULT_FPOINT"));

        ScaleConnector sc = new ScaleConnector(serialPort, baud, dataBits, stopBits, parity);
        sc.setByteCount(byteCount);
        sc.setStartCharacter(startCharacter);
        sc.setEndCharacter(endCharacter);
        sc.setReadings(readings);
        sc.setStartCutPosition(startCut);
        sc.setEndCutPosition(endCut);
        sc.setStabilityValuePosition(sIndicatorPos);
        sc.setStabilityValue(sIndicator);
        sc.setFloatingPoint(fPoint);

        try {
            System.out.println("Value: " + sc.readValue());
        } catch (SerialPortTimeoutException e) {
            log.error("Finish timeout");
            e.printStackTrace();
            return 1;
        } catch (Exception e) {
            log.error("Error reading serial port");
            e.printStackTrace();
            return 1;
        }

        System.out.println();
        return 0;
    }
}
