/******************************************************************************
 * Product: iDempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2012 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
/** Generated Model - DO NOT CHANGE */
package com.ingeint.model;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for SC_ServerSettings
 *  @author iDempiere (generated) 
 *  @version Release 1.0c - $Id$ */
public class X_SC_ServerSettings extends PO implements I_SC_ServerSettings, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20131218L;

    /** Standard Constructor */
    public X_SC_ServerSettings (Properties ctx, int SC_ServerSettings_ID, String trxName)
    {
      super (ctx, SC_ServerSettings_ID, trxName);
      /** if (SC_ServerSettings_ID == 0)
        {
			setHostAddress (null);
			setHostPort (0);
			setSC_ServerSettings_ID (0);
			setSecondsTimeout (0);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_SC_ServerSettings (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 3 - Client - Org 
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuffer sb = new StringBuffer ("X_SC_ServerSettings[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Description.
		@param Description 
		Optional short description of the record
	  */
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription () 
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	/** Set Host Address.
		@param HostAddress 
		Host Address URL or DNS
	  */
	public void setHostAddress (String HostAddress)
	{
		set_Value (COLUMNNAME_HostAddress, HostAddress);
	}

	/** Get Host Address.
		@return Host Address URL or DNS
	  */
	public String getHostAddress () 
	{
		return (String)get_Value(COLUMNNAME_HostAddress);
	}

	/** Set Host port.
		@param HostPort 
		Host Communication Port
	  */
	public void setHostPort (int HostPort)
	{
		set_Value (COLUMNNAME_HostPort, Integer.valueOf(HostPort));
	}

	/** Get Host port.
		@return Host Communication Port
	  */
	public int getHostPort () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_HostPort);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Web Service.
		@param isWebService Web Service	  */
	public void setisWebService (boolean isWebService)
	{
		set_Value (COLUMNNAME_isWebService, Boolean.valueOf(isWebService));
	}

	/** Get Web Service.
		@return Web Service	  */
	public boolean isWebService () 
	{
		Object oo = get_Value(COLUMNNAME_isWebService);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Scale Server Settings.
		@param SC_ServerSettings_ID Scale Server Settings	  */
	public void setSC_ServerSettings_ID (int SC_ServerSettings_ID)
	{
		if (SC_ServerSettings_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_SC_ServerSettings_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_SC_ServerSettings_ID, Integer.valueOf(SC_ServerSettings_ID));
	}

	/** Get Scale Server Settings.
		@return Scale Server Settings	  */
	public int getSC_ServerSettings_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_SC_ServerSettings_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set SC_ServerSettings_UU.
		@param SC_ServerSettings_UU SC_ServerSettings_UU	  */
	public void setSC_ServerSettings_UU (String SC_ServerSettings_UU)
	{
		set_Value (COLUMNNAME_SC_ServerSettings_UU, SC_ServerSettings_UU);
	}

	/** Get SC_ServerSettings_UU.
		@return SC_ServerSettings_UU	  */
	public String getSC_ServerSettings_UU () 
	{
		return (String)get_Value(COLUMNNAME_SC_ServerSettings_UU);
	}

	/** Set Seconds Timeout.
		@param SecondsTimeout Seconds Timeout	  */
	public void setSecondsTimeout (int SecondsTimeout)
	{
		set_Value (COLUMNNAME_SecondsTimeout, Integer.valueOf(SecondsTimeout));
	}

	/** Get Seconds Timeout.
		@return Seconds Timeout	  */
	public int getSecondsTimeout () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_SecondsTimeout);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Search Key.
		@param Value 
		Search key for the record in the format required - must be unique
	  */
	public void setValue (String Value)
	{
		set_Value (COLUMNNAME_Value, Value);
	}

	/** Get Search Key.
		@return Search key for the record in the format required - must be unique
	  */
	public String getValue () 
	{
		return (String)get_Value(COLUMNNAME_Value);
	}
}