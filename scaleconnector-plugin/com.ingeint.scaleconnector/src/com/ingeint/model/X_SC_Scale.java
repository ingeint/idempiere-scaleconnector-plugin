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

/** Generated Model for SC_Scale
 *  @author iDempiere (generated) 
 *  @version Release 1.0c - $Id$ */
public class X_SC_Scale extends PO implements I_SC_Scale, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20131218L;

    /** Standard Constructor */
    public X_SC_Scale (Properties ctx, int SC_Scale_ID, String trxName)
    {
      super (ctx, SC_Scale_ID, trxName);
      /** if (SC_Scale_ID == 0)
        {
			setBaud (0);
			setByteCount (0);
			setDataBits (0);
			setEndCharacter (0);
			setName (null);
			setParity (0);
			setReadings (0);
// 1
			setSC_Scale_ID (0);
			setSC_ServerSettings_ID (0);
			setSerialPort (null);
			setStartCharacter (0);
			setStopBits (0);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_SC_Scale (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_SC_Scale[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Baud.
		@param Baud Baud	  */
	public void setBaud (int Baud)
	{
		set_Value (COLUMNNAME_Baud, Integer.valueOf(Baud));
	}

	/** Get Baud.
		@return Baud	  */
	public int getBaud () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Baud);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Brand.
		@param Brand Brand	  */
	public void setBrand (String Brand)
	{
		set_Value (COLUMNNAME_Brand, Brand);
	}

	/** Get Brand.
		@return Brand	  */
	public String getBrand () 
	{
		return (String)get_Value(COLUMNNAME_Brand);
	}

	/** Set Byte Count.
		@param ByteCount Byte Count	  */
	public void setByteCount (int ByteCount)
	{
		set_Value (COLUMNNAME_ByteCount, Integer.valueOf(ByteCount));
	}

	/** Get Byte Count.
		@return Byte Count	  */
	public int getByteCount () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_ByteCount);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Data Bits.
		@param DataBits Data Bits	  */
	public void setDataBits (int DataBits)
	{
		set_Value (COLUMNNAME_DataBits, Integer.valueOf(DataBits));
	}

	/** Get Data Bits.
		@return Data Bits	  */
	public int getDataBits () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_DataBits);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	/** Set End Character.
		@param EndCharacter End Character	  */
	public void setEndCharacter (int EndCharacter)
	{
		set_Value (COLUMNNAME_EndCharacter, Integer.valueOf(EndCharacter));
	}

	/** Get End Character.
		@return End Character	  */
	public int getEndCharacter () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_EndCharacter);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set End Cut Position.
		@param EndCutPosition End Cut Position	  */
	public void setEndCutPosition (int EndCutPosition)
	{
		set_Value (COLUMNNAME_EndCutPosition, Integer.valueOf(EndCutPosition));
	}

	/** Get End Cut Position.
		@return End Cut Position	  */
	public int getEndCutPosition () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_EndCutPosition);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Floating Point.
		@param FloatingPoint Floating Point	  */
	public void setFloatingPoint (int FloatingPoint)
	{
		set_Value (COLUMNNAME_FloatingPoint, Integer.valueOf(FloatingPoint));
	}

	/** Get Floating Point.
		@return Floating Point	  */
	public int getFloatingPoint () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_FloatingPoint);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Model.
		@param Model Model	  */
	public void setModel (String Model)
	{
		set_Value (COLUMNNAME_Model, Model);
	}

	/** Get Model.
		@return Model	  */
	public String getModel () 
	{
		return (String)get_Value(COLUMNNAME_Model);
	}

	/** Set Name.
		@param Name 
		Alphanumeric identifier of the entity
	  */
	public void setName (String Name)
	{
		set_Value (COLUMNNAME_Name, Name);
	}

	/** Get Name.
		@return Alphanumeric identifier of the entity
	  */
	public String getName () 
	{
		return (String)get_Value(COLUMNNAME_Name);
	}

	/** Set Parity.
		@param Parity Parity	  */
	public void setParity (int Parity)
	{
		set_Value (COLUMNNAME_Parity, Integer.valueOf(Parity));
	}

	/** Get Parity.
		@return Parity	  */
	public int getParity () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Parity);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Readings.
		@param Readings Readings	  */
	public void setReadings (int Readings)
	{
		set_Value (COLUMNNAME_Readings, Integer.valueOf(Readings));
	}

	/** Get Readings.
		@return Readings	  */
	public int getReadings () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Readings);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Scale.
		@param SC_Scale_ID Scale	  */
	public void setSC_Scale_ID (int SC_Scale_ID)
	{
		if (SC_Scale_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_SC_Scale_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_SC_Scale_ID, Integer.valueOf(SC_Scale_ID));
	}

	/** Get Scale.
		@return Scale	  */
	public int getSC_Scale_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_SC_Scale_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set SC_Scale_UU.
		@param SC_Scale_UU SC_Scale_UU	  */
	public void setSC_Scale_UU (String SC_Scale_UU)
	{
		set_Value (COLUMNNAME_SC_Scale_UU, SC_Scale_UU);
	}

	/** Get SC_Scale_UU.
		@return SC_Scale_UU	  */
	public String getSC_Scale_UU () 
	{
		return (String)get_Value(COLUMNNAME_SC_Scale_UU);
	}

	public com.ingeint.model.I_SC_ServerSettings getSC_ServerSettings() throws RuntimeException
    {
		return (com.ingeint.model.I_SC_ServerSettings)MTable.get(getCtx(), com.ingeint.model.I_SC_ServerSettings.Table_Name)
			.getPO(getSC_ServerSettings_ID(), get_TrxName());	}

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

	/** Set Serial Port.
		@param SerialPort Serial Port	  */
	public void setSerialPort (String SerialPort)
	{
		set_Value (COLUMNNAME_SerialPort, SerialPort);
	}

	/** Get Serial Port.
		@return Serial Port	  */
	public String getSerialPort () 
	{
		return (String)get_Value(COLUMNNAME_SerialPort);
	}

	/** Set Stability.
		@param Stability Stability	  */
	public void setStability (int Stability)
	{
		set_Value (COLUMNNAME_Stability, Integer.valueOf(Stability));
	}

	/** Get Stability.
		@return Stability	  */
	public int getStability () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Stability);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Stability Position.
		@param StabilityPosition Stability Position	  */
	public void setStabilityPosition (int StabilityPosition)
	{
		set_Value (COLUMNNAME_StabilityPosition, Integer.valueOf(StabilityPosition));
	}

	/** Get Stability Position.
		@return Stability Position	  */
	public int getStabilityPosition () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_StabilityPosition);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Start Character.
		@param StartCharacter Start Character	  */
	public void setStartCharacter (int StartCharacter)
	{
		set_Value (COLUMNNAME_StartCharacter, Integer.valueOf(StartCharacter));
	}

	/** Get Start Character.
		@return Start Character	  */
	public int getStartCharacter () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_StartCharacter);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Start Cut Position.
		@param StartCutPosition Start Cut Position	  */
	public void setStartCutPosition (int StartCutPosition)
	{
		set_Value (COLUMNNAME_StartCutPosition, Integer.valueOf(StartCutPosition));
	}

	/** Get Start Cut Position.
		@return Start Cut Position	  */
	public int getStartCutPosition () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_StartCutPosition);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Stop Bits.
		@param StopBits Stop Bits	  */
	public void setStopBits (int StopBits)
	{
		set_Value (COLUMNNAME_StopBits, Integer.valueOf(StopBits));
	}

	/** Get Stop Bits.
		@return Stop Bits	  */
	public int getStopBits () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_StopBits);
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