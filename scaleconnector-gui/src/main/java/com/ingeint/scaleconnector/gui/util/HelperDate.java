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

package com.ingeint.scaleconnector.gui.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class HelperDate {
    private static SimpleDateFormat sdf;

    public static String format(Date date, String format) {
        sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static Date now() {
        return Calendar.getInstance().getTime();
    }

    public static String nowFormat(String format) {
        sdf = new SimpleDateFormat(format);
        return sdf.format(Calendar.getInstance().getTime());
    }

    public static Date future(int field, int quantity) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(field, quantity);
        return calendar.getTime();
    }

    public static Date future(Calendar calendar, int field, int quantity) {
        Calendar calendarClone = (Calendar) calendar.clone();
        calendarClone.add(field, quantity);
        return calendarClone.getTime();
    }

}
