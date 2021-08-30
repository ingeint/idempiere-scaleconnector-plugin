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

package com.ingeint.scaleconnector.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import com.ingeint.scaleconnector.gui.feature.SCUIFeature;
import com.ingeint.scaleconnector.gui.feature.SCUILocale;
import com.ingeint.scaleconnector.gui.view.ViewSelectMode;

public class ControllerViewSelectMode implements ActionListener, WindowListener, ItemListener {

	private static Logger logger = Logger.getLogger(ControllerViewSelectMode.class.getName());
	private ViewSelectMode viewSelectMode;

	public ControllerViewSelectMode() {
		viewSelectMode = new ViewSelectMode();
		viewSelectMode.addListener(this);
		viewSelectMode.setVisible(true);
	}

	public void close() {
		viewSelectMode.dispose();
		System.exit(0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(viewSelectMode.getBtnClient())) {
			new ControllerViewClientMode();
			viewSelectMode.dispose();
		} else if (e.getSource().equals(viewSelectMode.getBtnServer())) {
			new ControllerViewServerMode();
			viewSelectMode.dispose();
		}
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// NOTHING
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// NOTHING
	}

	@Override
	public void windowClosing(WindowEvent e) {
		close();
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// NOTHING
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// NOTHING
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// NOTHING
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// NOTHING
	}

	@Override
	public void itemStateChanged(ItemEvent ie) {
		try {
			String locale = viewSelectMode.getCmbModelSelectLocale().getSelectedItem().toString();
			SCUILocale.load(locale);
			SCUIFeature.set("DEFAULT_LOCALE", locale);
			viewSelectMode.loadLocale();
		} catch (Exception e) {
			logger.severe("Error loading locale");
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, SCUILocale.get("ViewSelectMode.errorLocale"), "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}

}
