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

package com.ingeint.scaleconnector.gui.feature;

import com.ingeint.scaleconnector.gui.app.Main;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.Properties;
import java.util.logging.Logger;

public class SCUIFeature {

    public static final String FEATURES_PROPERTIES_PATH = "scaleconnector.properties";
    private static Logger logger = Logger.getLogger(Main.class.getName());

    private static Properties properties = new Properties();

    public static void load() throws IOException {
        if (Files.exists(Paths.get(FEATURES_PROPERTIES_PATH))) {
            properties.load(new FileReader(FEATURES_PROPERTIES_PATH, StandardCharsets.UTF_8));
        } else {
            properties.load(SCUIFeature.class.getClassLoader().getResourceAsStream(FEATURES_PROPERTIES_PATH));
        }
        set("OS", System.getProperty("os.name"));
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

    public static Enumeration<Object> getKeys() {
        return properties.keys();
    }

    public static void set(String key, String value) {
        properties.put(key, value);
        save();
    }

    public static synchronized void save() {
        try {
            properties.store(new FileOutputStream(FEATURES_PROPERTIES_PATH), FEATURES_PROPERTIES_PATH);
        } catch (IOException e) {
            logger.severe("Error on saving properties");
            e.printStackTrace();
        }
    }
}
