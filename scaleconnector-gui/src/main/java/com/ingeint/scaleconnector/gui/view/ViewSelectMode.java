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

package com.ingeint.scaleconnector.gui.view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.ingeint.scaleconnector.gui.controller.ControllerViewSelectMode;
import com.ingeint.scaleconnector.gui.feature.SCUIFeature;
import com.ingeint.scaleconnector.gui.feature.SCUILocale;
import com.ingeint.scaleconnector.gui.feature.SCUIStandard;

import net.miginfocom.swing.MigLayout;

public class ViewSelectMode extends JFrame {

	private static final long serialVersionUID = -6046414331203762804L;

	private List<JButton> buttons;
	private JPanel pnlCentral;
	private JPanel pnlLogo;
	private JLabel lblLogo;
	private JButton btnServer;
	private JButton btnClient;
	private JLabel lblLocale;

	private JComboBox<String> cmbSelectLocale;
	private DefaultComboBoxModel<String> cmbModelSelectLocale;

	public ViewSelectMode() {
		setLayout(new BorderLayout());
		setIconImage(SCUIStandard.ICON);
		setSize(270, 270);
		setResizable(false);
		setLocationRelativeTo(this);
		buttons = new ArrayList<JButton>();

		pnlCentral = new JPanel();
		pnlCentral.setLayout(new MigLayout());
		add(pnlCentral, BorderLayout.CENTER);

		lblLocale = new JLabel();
		pnlCentral.add(lblLocale, "width 120,  height 30");

		cmbModelSelectLocale = new DefaultComboBoxModel<String>(SCUILocale.list());
		cmbSelectLocale = new JComboBox<String>(cmbModelSelectLocale);
		cmbModelSelectLocale.setSelectedItem(SCUIFeature.get("DEFAULT_LOCALE"));
		pnlCentral.add(cmbSelectLocale, "width 120,  height 30, wrap");

		btnServer = new JButton();
		pnlCentral.add(btnServer, "width 120,  height 40");
		buttons.add(btnServer);

		btnClient = new JButton();
		pnlCentral.add(btnClient, "width 120,  height 40, wrap");
		buttons.add(btnClient);

		pnlLogo = new JPanel();
		add(pnlLogo, BorderLayout.NORTH);

		lblLogo = new JLabel();
		lblLogo.setIcon(SCUIStandard.LOGO);
		pnlLogo.add(lblLogo);

		loadLocale();
	}

	public void loadLocale() {
		setTitle(SCUILocale.get("ViewSelectMode.title"));
		btnClient.setText(SCUILocale.get("ViewSelectMode.btnClient"));
		btnServer.setText(SCUILocale.get("ViewSelectMode.btnServer"));
		lblLocale.setText(SCUILocale.get("ViewSelectMode.lblLocale"));
	}

	public void addListener(ControllerViewSelectMode listener) {
		for (JButton button : buttons) {
			button.addActionListener(listener);
		}
		addWindowListener(listener);
		cmbSelectLocale.addItemListener(listener);
	}

	public JButton getBtnServer() {
		return btnServer;
	}

	public JButton getBtnClient() {
		return btnClient;
	}

	public JLabel getLblLocale() {
		return lblLocale;
	}

	public DefaultComboBoxModel<String> getCmbModelSelectLocale() {
		return cmbModelSelectLocale;
	}

}
