/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.icss.hit.struts.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/** 
 * MyEclipse Struts
 * Creation date: 08-10-2009
 * 
 * XDoclet definition:
 * @struts.form name="alterRoomForm"
 */
public class AlterRoomForm extends ActionForm {
	/*
	 * Generated fields
	 */

	/** rname property */
	private String rname;

	/** rInfo property */
	private String rinfo;

	/** rid property */
	private String rid;

	/** rcontain property */
	private String rcontain;

	/*
	 * Generated Methods
	 */

	/** 
	 * Method validate
	 * @param mapping
	 * @param request
	 * @return ActionErrors
	 */
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		ActionErrors errors = new ActionErrors();
		if(rname==null || rname.trim().equals(""))errors.add("nameError", new ActionMessage("nameError.Error"));
		if(rcontain==null || (!rcontain.matches("[1-9]\\d*"))||rcontain.trim().equals("") )errors.add("containError", new ActionMessage("containError.Error"));
		request.setAttribute("rid", rid);
		request.setAttribute("rname", rname);
		request.setAttribute("rcontain", rcontain);
		request.setAttribute("rInfo", rinfo);
		System.out.println(rinfo);
		return errors;
	}

	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
	}

	/** 
	 * Returns the rname.
	 * @return String
	 */
	public String getRname() {
		return rname;
	}

	/** 
	 * Set the rname.
	 * @param rname The rname to set
	 */
	public void setRname(String rname) {
		this.rname = rname;
	}

	/** 
	 * Returns the rInfo.
	 * @return String
	 */
	/*public String getRInfo() {
		return rInfo;
	}

	/** 
	 * Set the rInfo.
	 * @param rInfo The rInfo to set
	 */
	/*public void setRInfo(String rInfo) {
		this.rInfo = rInfo;
	}*/

	/** 
	 * Returns the rid.
	 * @return String
	 */
	public String getRid() {
		return rid;
	}

	/** 
	 * Set the rid.
	 * @param rid The rid to set
	 */
	public void setRid(String rid) {
		this.rid = rid;
	}

	/** 
	 * Returns the rcontain.
	 * @return String
	 */
	public String getRcontain() {
		return rcontain;
	}

	/** 
	 * Set the rcontain.
	 * @param rcontain The rcontain to set
	 */
	public void setRcontain(String rcontain) {
		this.rcontain = rcontain;
	}

	public String getRinfo() {
		return rinfo;
	}

	public void setRinfo(String rinfo) {
		this.rinfo = rinfo;
	}
}