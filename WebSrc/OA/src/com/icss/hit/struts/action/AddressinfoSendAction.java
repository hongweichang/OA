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
 * ���ڽ���ת�������ݸ����洦����Action��
 * Creation date: 08-05-2009
 * @author ��ӱ��
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
		//���ڽ�ǰ�洫�����ı�������װ
		addressInfoForm searchAddressInfoForm = (addressInfoForm) form;
		//ʹ�ñ���������������,�Ա�Ͳ�ѯ�Ķ���
		String key = searchAddressInfoForm.getSuUser();
		String sex = searchAddressInfoForm.getSuSex();
		String keyUrl = null;
		String sexUrl = null;
		try {
			//���������ַ��ĸ����ϱ���
			keyUrl = URLEncoder.encode(key, "UTF-8");        
			sexUrl = URLEncoder.encode(sex, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return mapping.findForward("SearchOtherInfo.succeed");
		}
		// �����Ų�����ҳ����ת�ڲ�����Ŀ���ʱ��
		if(key == null||key.trim()=="")
		{
			ActionRedirect redirect = new ActionRedirect(mapping.findForward("addressinfoSend.successd"));
			redirect.addParameter("sex", sexUrl);
			redirect.addParameter("dept", searchAddressInfoForm.getSuDept());
			return redirect;
		}
		// ��������ҳ����ת
		else
		{
			
			ActionRedirect redirect = new ActionRedirect(mapping.findForward("addressinfoSend.successd"));
			//�����еĲ������ض���
			redirect.addParameter("type",searchAddressInfoForm.getType());
			redirect.addParameter("key", keyUrl);
			redirect.addParameter("sex", sexUrl);
			redirect.addParameter("dept", searchAddressInfoForm.getSuDept());
			redirect.addParameter("page", 1);
			return redirect;
		}
	}
}