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
package com.ingeint.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Interface for SC_Scale
 *  @author iDempiere (generated) 
 *  @version Release 1.0c
 */
@SuppressWarnings("all")
public interface I_SC_Scale 
{

    /** TableName=SC_Scale */
    public static final String Table_Name = "SC_Scale";

    /** AD_Table_ID=1000005 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 3 - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(3);

    /** Load Meta Data */

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Client.
	  * Client/Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within client
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within client
	  */
	public int getAD_Org_ID();

    /** Column name Baud */
    public static final String COLUMNNAME_Baud = "Baud";

	/** Set Baud	  */
	public void setBaud (int Baud);

	/** Get Baud	  */
	public int getBaud();

    /** Column name Brand */
    public static final String COLUMNNAME_Brand = "Brand";

	/** Set Brand	  */
	public void setBrand (String Brand);

	/** Get Brand	  */
	public String getBrand();

    /** Column name ByteCount */
    public static final String COLUMNNAME_ByteCount = "ByteCount";

	/** Set Byte Count	  */
	public void setByteCount (int ByteCount);

	/** Get Byte Count	  */
	public int getByteCount();

    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/** Get Created.
	  * Date this record was created
	  */
	public Timestamp getCreated();

    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/** Get Created By.
	  * User who created this records
	  */
	public int getCreatedBy();

    /** Column name DataBits */
    public static final String COLUMNNAME_DataBits = "DataBits";

	/** Set Data Bits	  */
	public void setDataBits (int DataBits);

	/** Get Data Bits	  */
	public int getDataBits();

    /** Column name Description */
    public static final String COLUMNNAME_Description = "Description";

	/** Set Description.
	  * Optional short description of the record
	  */
	public void setDescription (String Description);

	/** Get Description.
	  * Optional short description of the record
	  */
	public String getDescription();

    /** Column name EndCharacter */
    public static final String COLUMNNAME_EndCharacter = "EndCharacter";

	/** Set End Character	  */
	public void setEndCharacter (int EndCharacter);

	/** Get End Character	  */
	public int getEndCharacter();

    /** Column name EndCutPosition */
    public static final String COLUMNNAME_EndCutPosition = "EndCutPosition";

	/** Set End Cut Position	  */
	public void setEndCutPosition (int EndCutPosition);

	/** Get End Cut Position	  */
	public int getEndCutPosition();

    /** Column name FloatingPoint */
    public static final String COLUMNNAME_FloatingPoint = "FloatingPoint";

	/** Set Floating Point	  */
	public void setFloatingPoint (int FloatingPoint);

	/** Get Floating Point	  */
	public int getFloatingPoint();

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set Active.
	  * The record is active in the system
	  */
	public void setIsActive (boolean IsActive);

	/** Get Active.
	  * The record is active in the system
	  */
	public boolean isActive();

    /** Column name Model */
    public static final String COLUMNNAME_Model = "Model";

	/** Set Model	  */
	public void setModel (String Model);

	/** Get Model	  */
	public String getModel();

    /** Column name Name */
    public static final String COLUMNNAME_Name = "Name";

	/** Set Name.
	  * Alphanumeric identifier of the entity
	  */
	public void setName (String Name);

	/** Get Name.
	  * Alphanumeric identifier of the entity
	  */
	public String getName();

    /** Column name Parity */
    public static final String COLUMNNAME_Parity = "Parity";

	/** Set Parity	  */
	public void setParity (int Parity);

	/** Get Parity	  */
	public int getParity();

    /** Column name Readings */
    public static final String COLUMNNAME_Readings = "Readings";

	/** Set Readings	  */
	public void setReadings (int Readings);

	/** Get Readings	  */
	public int getReadings();

    /** Column name SC_Scale_ID */
    public static final String COLUMNNAME_SC_Scale_ID = "SC_Scale_ID";

	/** Set Scale	  */
	public void setSC_Scale_ID (int SC_Scale_ID);

	/** Get Scale	  */
	public int getSC_Scale_ID();

    /** Column name SC_Scale_UU */
    public static final String COLUMNNAME_SC_Scale_UU = "SC_Scale_UU";

	/** Set SC_Scale_UU	  */
	public void setSC_Scale_UU (String SC_Scale_UU);

	/** Get SC_Scale_UU	  */
	public String getSC_Scale_UU();

    /** Column name SC_ServerSettings_ID */
    public static final String COLUMNNAME_SC_ServerSettings_ID = "SC_ServerSettings_ID";

	/** Set Scale Server Settings	  */
	public void setSC_ServerSettings_ID (int SC_ServerSettings_ID);

	/** Get Scale Server Settings	  */
	public int getSC_ServerSettings_ID();

	public com.ingeint.model.I_SC_ServerSettings getSC_ServerSettings() throws RuntimeException;

    /** Column name SerialPort */
    public static final String COLUMNNAME_SerialPort = "SerialPort";

	/** Set Serial Port	  */
	public void setSerialPort (String SerialPort);

	/** Get Serial Port	  */
	public String getSerialPort();

    /** Column name Stability */
    public static final String COLUMNNAME_Stability = "Stability";

	/** Set Stability	  */
	public void setStability (int Stability);

	/** Get Stability	  */
	public int getStability();

    /** Column name StabilityPosition */
    public static final String COLUMNNAME_StabilityPosition = "StabilityPosition";

	/** Set Stability Position	  */
	public void setStabilityPosition (int StabilityPosition);

	/** Get Stability Position	  */
	public int getStabilityPosition();

    /** Column name StartCharacter */
    public static final String COLUMNNAME_StartCharacter = "StartCharacter";

	/** Set Start Character	  */
	public void setStartCharacter (int StartCharacter);

	/** Get Start Character	  */
	public int getStartCharacter();

    /** Column name StartCutPosition */
    public static final String COLUMNNAME_StartCutPosition = "StartCutPosition";

	/** Set Start Cut Position	  */
	public void setStartCutPosition (int StartCutPosition);

	/** Get Start Cut Position	  */
	public int getStartCutPosition();

    /** Column name StopBits */
    public static final String COLUMNNAME_StopBits = "StopBits";

	/** Set Stop Bits	  */
	public void setStopBits (int StopBits);

	/** Get Stop Bits	  */
	public int getStopBits();

    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/** Get Updated.
	  * Date this record was updated
	  */
	public Timestamp getUpdated();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/** Get Updated By.
	  * User who updated this records
	  */
	public int getUpdatedBy();

    /** Column name Value */
    public static final String COLUMNNAME_Value = "Value";

	/** Set Search Key.
	  * Search key for the record in the format required - must be unique
	  */
	public void setValue (String Value);

	/** Get Search Key.
	  * Search key for the record in the format required - must be unique
	  */
	public String getValue();
}
