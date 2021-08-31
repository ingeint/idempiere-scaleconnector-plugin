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

package com.ingeint.scaleconnector.gui.controller;

import com.ingeint.scaleconnector.gui.feature.SCUIFeature;
import com.ingeint.scaleconnector.gui.feature.SCUILocale;
import com.ingeint.scaleconnector.gui.view.ViewAbout;
import com.ingeint.scaleconnector.gui.view.ViewServerMode;
import com.ingeint.scaleconnector.gui.view.ViewWait;
import com.ingeint.scaleconnector.service.ScaleConnector;
import com.ingeint.scaleconnector.service.Server;
import jssc.SerialPortTimeoutException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.URI;
import java.util.logging.Logger;

public class ControllerViewServerMode implements ActionListener, WindowListener {

    private static Logger logger = Logger.getLogger(ControllerViewServerMode.class.getName());
    private ViewServerMode viewServerMode;
    private Server server;
    private ViewWait viewWait;

    public ControllerViewServerMode() {
        viewServerMode = new ViewServerMode();
        viewServerMode.addListener(this);
        initView();
        viewServerMode.setVisible(true);
        viewServerMode.setResizable(false);
    }

    public void initView() {
        viewServerMode.getTxtSerialPort().setText(SCUIFeature.get("DEFAULT_SERIALPORT"));
        viewServerMode.getTxtBaud().setText(SCUIFeature.get("DEFAULT_BAUD"));
        viewServerMode.getTxtDataBits().setText(SCUIFeature.get("DEFAULT_DATABITS"));
        viewServerMode.getTxtParity().setText(SCUIFeature.get("DEFAULT_PARITY"));
        viewServerMode.getTxtStopBits().setText(SCUIFeature.get("DEFAULT_STOPBITS"));
        viewServerMode.getTxtPort().setText(SCUIFeature.get("DEFAULT_PORT"));
        viewServerMode.getTxtByteCount().setText(SCUIFeature.get("DEFAULT_BYTECOUNT"));
        viewServerMode.getTxtStartCharacter().setText(SCUIFeature.get("DEFAULT_STARTCHARACTER"));
        viewServerMode.getTxtEndCharacter().setText(SCUIFeature.get("DEFAULT_ENDCHARACTER"));
        viewServerMode.getTxtReadings().setText(SCUIFeature.get("DEFAULT_READINGS"));
        viewServerMode.getTxtStartCutPosition().setText(SCUIFeature.get("DEFAULT_STARTCUT"));
        viewServerMode.getTxtEndCutPosition().setText(SCUIFeature.get("DEFAULT_ENDCUT"));
        viewServerMode.getTxtStabilityIndicatorPosition().setText(SCUIFeature.get("DEFAULT_SINDICATORPOS"));
        viewServerMode.getTxtStabilityIndicator().setText(SCUIFeature.get("DEFAULT_SINDICATOR"));
        viewServerMode.getTxtFloatingPoint().setText(SCUIFeature.get("DEFAULT_FPOINT"));
        viewServerMode.getBtnStop().setEnabled(false);

        viewServerMode.getTblModelBytesRead().setColumnIdentifiers(new Object[]{"POS", "CHAR", "INT", "HEX"});

    }

    public void close() {
        if (server != null && server.isAlive()) {
            int option = JOptionPane.showConfirmDialog(viewServerMode, SCUILocale.get("ViewServerMode.changeMode"), SCUILocale.get("ViewClientMode.menuItemChangeMode"), JOptionPane.OK_CANCEL_OPTION);
            if (option != JOptionPane.OK_OPTION) {
                return;
            }
        }
        viewServerMode.dispose();
        System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(viewServerMode.getMenuItemClose())) {
            close();
        } else if (e.getSource().equals(viewServerMode.getMenuItemAbout())) {
            new ViewAbout().setVisible(true);
        } else if (e.getSource().equals(viewServerMode.getMenuItemChangeMode())) {
            changeMode();
        } else if (e.getSource().equals(viewServerMode.getMenuItemDocumentation())) {
            goDocumentation();
        } else if (e.getSource().equals(viewServerMode.getBtnStart())) {
            startServer();
        } else if (e.getSource().equals(viewServerMode.getBtnStop())) {
            stopServer();
        } else if (e.getSource().equals(viewServerMode.getBtnReadPort())) {
            readPort();
        }
    }

    public void goDocumentation() {
        try {
            Desktop.getDesktop().browse(new URI(SCUIFeature.get("DOCUMENTATION")));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(viewServerMode, SCUILocale.get("ViewClientMode.errorGoDocumentation"), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void changeMode() {
        if (server != null && server.isAlive()) {
            int option = JOptionPane.showConfirmDialog(viewServerMode, SCUILocale.get("ViewServerMode.changeMode"), SCUILocale.get("ViewClientMode.menuItemChangeMode"), JOptionPane.OK_CANCEL_OPTION);
            if (option != JOptionPane.OK_OPTION) {
                return;
            }
            stopServer();
        }
        viewServerMode.dispose();
        new ControllerViewSelectMode();
    }

    public synchronized void readPort() {
        viewWait = new ViewWait();

        new Thread(() -> {
            try {
                viewServerMode.getTblModelBytesRead().getDataVector().removeAllElements();

                int baud = viewServerMode.getTxtBaud().getInteger();
                int dataBits = viewServerMode.getTxtDataBits().getInteger();
                int stopBits = viewServerMode.getTxtStopBits().getInteger();
                int parity = viewServerMode.getTxtParity().getInteger();
                int byteCount = viewServerMode.getTxtByteCount().getInteger();
                int readings = viewServerMode.getTxtReadings().getInteger();
                String port = viewServerMode.getTxtSerialPort().getText();
                int sIndicatorPos = viewServerMode.getTxtStabilityIndicatorPosition().getInteger();
                int fPoint = viewServerMode.getTxtFloatingPoint().getInteger();
                int sIndicator = viewServerMode.getTxtStabilityIndicator().getInteger();
                int startCut = viewServerMode.getTxtStartCutPosition().getInteger();
                int endCut = viewServerMode.getTxtEndCutPosition().getInteger();
                int startChar = viewServerMode.getTxtStartCharacter().getInteger();
                int endChar = viewServerMode.getTxtEndCharacter().getInteger();

                SCUIFeature.set("DEFAULT_PARITY", viewServerMode.getTxtParity().getText().trim());
                SCUIFeature.set("DEFAULT_STOPBITS", viewServerMode.getTxtStopBits().getText().trim());
                SCUIFeature.set("DEFAULT_DATABITS", viewServerMode.getTxtDataBits().getText().trim());
                SCUIFeature.set("DEFAULT_BAUD", viewServerMode.getTxtBaud().getText().trim());
                SCUIFeature.set("DEFAULT_BYTECOUNT", viewServerMode.getTxtByteCount().getText().trim());
                SCUIFeature.set("DEFAULT_STARTCHARACTER", viewServerMode.getTxtStartCharacter().getText().trim());
                SCUIFeature.set("DEFAULT_ENDCHARACTER", viewServerMode.getTxtEndCharacter().getText().trim());
                SCUIFeature.set("DEFAULT_READINGS", viewServerMode.getTxtReadings().getText().trim());
                SCUIFeature.set("DEFAULT_STARTCUT", viewServerMode.getTxtStartCutPosition().getText().trim());
                SCUIFeature.set("DEFAULT_ENDCUT", viewServerMode.getTxtEndCutPosition().getText().trim());
                SCUIFeature.set("DEFAULT_SINDICATORPOS", viewServerMode.getTxtStabilityIndicatorPosition().getText().trim());
                SCUIFeature.set("DEFAULT_SINDICATOR", viewServerMode.getTxtStabilityIndicator().getText().trim());
                SCUIFeature.set("DEFAULT_FPOINT", viewServerMode.getTxtFloatingPoint().getText().trim());
                SCUIFeature.set("DEFAULT_SERIALPORT", port);

                ScaleConnector sc = new ScaleConnector(port, baud, dataBits, stopBits, parity);
                sc.setByteCount(byteCount);
                sc.setReadings(readings);
                sc.setStartCharacter(startChar);
                sc.setEndCharacter(endChar);
                sc.setStartCutPosition(startCut);
                sc.setEndCutPosition(endCut);
                sc.setStabilityValuePosition(sIndicatorPos);
                sc.setStabilityValue(sIndicator);
                sc.setFloatingPoint(fPoint);

                byte[] bytesPortValue = null;
                String portValue = "";

                bytesPortValue = sc.readBytes();
                portValue = sc.readValue();

                viewServerMode.getLblPortValue().setText(portValue);

                if (sc.isStableValue()) {
                    viewServerMode.getLblStatusValue().setText(SCUILocale.get("ViewServerMode.STATUS_STABLE"));
                    viewServerMode.getLblStatusValue().setForeground(Color.GREEN);
                } else {
                    viewServerMode.getLblStatusValue().setText(SCUILocale.get("ViewServerMode.STATUS_UNSTABLE"));
                    viewServerMode.getLblStatusValue().setForeground(Color.RED);
                }

                for (int i = 0; i < bytesPortValue.length; i++) {
                    viewServerMode.getTblModelBytesRead().addRow(new Object[]{i, (char) bytesPortValue[i], bytesPortValue[i], String.format("%02x", bytesPortValue[i]).toUpperCase()});
                }

            } catch (SerialPortTimeoutException e) {
                logger.severe("Finish timeout");
                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(viewServerMode, SCUILocale.get("ViewServerMode.timeoutScaleConnector"), "Error", JOptionPane.ERROR_MESSAGE);
                });
                e.printStackTrace();
            } catch (Exception e) {
                logger.severe("Error reading serial port");
                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(viewServerMode, SCUILocale.get("ViewServerMode.errorReadingSerialPort"), "Error", JOptionPane.ERROR_MESSAGE);
                });
                e.printStackTrace();
            } finally {
                viewWait.close();
            }

        }).start();
        viewWait.display();

    }

    private synchronized void stopServer() {
        try {
            server.stop();
            viewServerMode.getBtnStop().setEnabled(false);
            viewServerMode.getBtnStart().setEnabled(true);
            viewServerMode.getLblStatus().setText(SCUILocale.get("ViewServerMode.lblStatusStop"));
        } catch (Exception e1) {
            logger.warning("Error stoping server");
            JOptionPane.showMessageDialog(viewServerMode, SCUILocale.get("ViewServerMode.errorStopingServer"), "Error", JOptionPane.ERROR_MESSAGE);
            e1.printStackTrace();
        }
    }

    private synchronized void startServer() {
        server = new Server(viewServerMode.getTxtPort().getInteger());
        SCUIFeature.set("DEFAULT_PORT", viewServerMode.getTxtPort().getText().trim());
        try {
            server.start();
            viewServerMode.getBtnStop().setEnabled(true);
            viewServerMode.getBtnStart().setEnabled(false);
            viewServerMode.getLblStatus().setText(SCUILocale.get("ViewServerMode.lblStatusStart"));
        } catch (Exception e1) {
            logger.warning("Error starting server");
            JOptionPane.showMessageDialog(viewServerMode, SCUILocale.get("ViewServerMode.errorStartingServer"), "Error", JOptionPane.ERROR_MESSAGE);
            e1.printStackTrace();
        }
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        close();
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

}
