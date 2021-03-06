/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.icss.hit.struts.action;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionRedirect;

import com.icss.hit.struts.form.addressInfoForm;

/** 
 * 用于将中转传输数据给后面处理的Action。
 * Creation date: 08-05-2009
 * @author 赵颖申
 * XDoclet definition:
 * @struts.action validate="true"
 * @struts.action path="/addressinfoSend" name="searchOtherInfoForm" input="/addressInfo.do" scope="request" validate="true"
 * @struts.action-forward name="addressinfoSend.fail" path="/address/address.jsp"
 * @struts.action-forward name="addressinfoSend.successd" path="/address/address.jsp"
 */
public class AddressinfoSendAction extends Action {
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		//用于将前面传过来的表单给封装
		addressInfoForm searchAddressInfoForm = (addressInfoForm) form;
		//使用表单传过来的内容,性别和查询的东东
		String key = searchAddressInfoForm.getSuUser();
		String sex = searchAddressInfoForm.getSuSex();
		String keyUrl = null;
		String sexUrl = null;
		try {
			//给有中文字符的给加上编码
			keyUrl = URLEncoder.encode(key, "UTF-8");        
			sexUrl = URLEncoder.encode(sex, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return mapping.findForward("SearchOtherInfo.succeed");
		}
		// 带部门参数的页面跳转在不输入目标的时候
		if(key == null||key.trim()=="")
		{
			ActionRedirect redirect = new ActionRedirect(mapping.findForward("addressinfoSend.successd"));
			redirect.addParameter("sex", sexUrl);
			redirect.addParameter("dept", searchAddressInfoForm.getSuDept());
			return redirect;
		}
		// 带参数的页面跳转
		else
		{
			
			ActionRedirect redirect = new ActionRedirect(mapping.findForward("addressinfoSend.successd"));
			//带所有的参数来重定向
			redirect.addParameter("type",searchAddressInfoForm.getType());
			redirect.addParameter("key", keyUrl);
			redirect.addParameter("sex", sexUrl);
			redirect.addParameter("dept", searchAddressInfoForm.getSuDept());
			redirect.addParameter("page", 1);
			return redirect;
		}
	}
}