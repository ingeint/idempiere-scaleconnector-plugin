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

/**
 * Generated Interface for SC_ServerSettings
 * 
 * @author iDempiere (generated)
 * @version Release 1.0c
 */
@SuppressWarnings("all")
public interface I_SC_ServerSettings {

	/** TableName=SC_ServerSettings */
	public static final String Table_Name = "SC_ServerSettings";

	/** AD_Table_ID=1000004 */
	public static final int Table_ID = MTable.getTable_ID(Table_Name);

	KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

	/**
	 * AccessLevel = 3 - Client - Org
	 */
	BigDecimal accessLevel = BigDecimal.valueOf(3);

	/** Load Meta Data */

	/** Column name AD_Client_ID */
	public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/**
	 * Get Client. Client/Tenant for this installation.
	 */
	public int getAD_Client_ID();

	/** Column name AD_Org_ID */
	public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/**
	 * Set Organization. Organizational entity within client
	 */
	public void setAD_Org_ID(int AD_Org_ID);

	/**
	 * Get Organization. Organizational entity within client
	 */
	public int getAD_Org_ID();

	/** Column name Created */
	public static final String COLUMNNAME_Created = "Created";

	/**
	 * Get Created. Date this record was created
	 */
	public Timestamp getCreated();

	/** Column name CreatedBy */
	public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/**
	 * Get Created By. User who created this records
	 */
	public int getCreatedBy();

	/** Column name Description */
	public static final String COLUMNNAME_Description = "Description";

	/**
	 * Set Description. Optional short description of the record
	 */
	public void setDescription(String Description);

	/**
	 * Get Description. Optional short description of the record
	 */
	public String getDescription();

	/** Column name HostAddress */
	public static final String COLUMNNAME_HostAddress = "HostAddress";

	/**
	 * Set Host Address. Host Address URL or DNS
	 */
	public void setHostAddress(String HostAddress);

	/**
	 * Get Host Address. Host Address URL or DNS
	 */
	public String getHostAddress();

	/** Column name HostPort */
	public static final String COLUMNNAME_HostPort = "HostPort";

	/**
	 * Set Host port. Host Communication Port
	 */
	public void setHostPort(int HostPort);

	/**
	 * Get Host port. Host Communication Port
	 */
	public int getHostPort();

	/** Column name IsActive */
	public static final String COLUMNNAME_IsActive = "IsActive";

	/**
	 * Set Active. The record is active in the system
	 */
	public void setIsActive(boolean IsActive);

	/**
	 * Get Active. The record is active in the system
	 */
	public boolean isActive();

	/** Column name isWebService */
	public static final String COLUMNNAME_isWebService = "isWebService";

	/** Set Web Service */
	public void setisWebService(boolean isWebService);

	/** Get Web Service */
	public boolean isWebService();

	/** Column name SC_ServerSettings_ID */
	public static final String COLUMNNAME_SC_ServerSettings_ID = "SC_ServerSettings_ID";

	/** Set Scale Server Settings */
	public void setSC_ServerSettings_ID(int SC_ServerSettings_ID);

	/** Get Scale Server Settings */
	public int getSC_ServerSettings_ID();

	/** Column name SC_ServerSettings_UU */
	public static final String COLUMNNAME_SC_ServerSettings_UU = "SC_ServerSettings_UU";

	/** Set SC_ServerSettings_UU */
	public void setSC_ServerSettings_UU(String SC_ServerSettings_UU);

	/** Get SC_ServerSettings_UU */
	public String getSC_ServerSettings_UU();

	/** Column name SecondsTimeout */
	public static final String COLUMNNAME_SecondsTimeout = "SecondsTimeout";

	/** Set Seconds Timeout */
	public void setSecondsTimeout(int SecondsTimeout);

	/** Get Seconds Timeout */
	public int getSecondsTimeout();

	/** Column name Updated */
	public static final String COLUMNNAME_Updated = "Updated";

	/**
	 * Get Updated. Date this record was updated
	 */
	public Timestamp getUpdated();

	/** Column name UpdatedBy */
	public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/**
	 * Get Updated By. User who updated this records
	 */
	public int getUpdatedBy();

	/** Column name Value */
	public static final String COLUMNNAME_Value = "Value";

	/**
	 * Set Search Key. Search key for the record in the format required - must be
	 * unique
	 */
	public void setValue(String Value);

	/**
	 * Get Search Key. Search key for the record in the format required - must be
	 * unique
	 */
	public String getValue();
}
