package com.poka.app.pb.ws.impl;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.poka.app.anno.bussiness.AppointmentBussiness;
import com.poka.app.anno.bussiness.PaymentBussiness;
import com.poka.app.anno.bussiness.PerInfoAndBranchBussiness;
import com.poka.app.anno.bussiness.QryApplyBussiness;
import com.poka.app.anno.enity.QryApply;
import com.poka.app.pb.ws.IPBPospSW;
import com.poka.app.vo.AppointmentVo;
import com.poka.app.vo.PaymentVo;

@WebService(endpointInterface = "com.poka.app.pb.ws.IPBPospSW") 
public class PBPospSW implements IPBPospSW {

	private AppointmentBussiness appointmentBussiness;
    private PaymentBussiness paymentBussiness;
    private QryApplyBussiness qryApplyBussiness;
    private PerInfoAndBranchBussiness perInfoAndBranchBussiness;
    
    
    @Autowired
    public void setPerInfoAndBranchBussiness(PerInfoAndBranchBussiness perInfoAndBranchBussiness) {
		this.perInfoAndBranchBussiness = perInfoAndBranchBussiness;
	}

	@Autowired
	public void setPaymentBussiness(PaymentBussiness paymentBussiness) {
		this.paymentBussiness = paymentBussiness;
	}
    
    @Autowired
    public void setQryApplyBussiness(QryApplyBussiness qryApplyBussiness) {
    	this.qryApplyBussiness = qryApplyBussiness;
    }

	@Autowired
	public void setAppointmentBussiness(AppointmentBussiness appointmentBussiness) {
		this.appointmentBussiness = appointmentBussiness;
	}

	/*
	 * 预约请求处理
	 * @see com.poka.app.pb.ws.IPBPospSW#makeAppointmen(com.poka.app.vo.AppointmentVo)
	 */
	@Override
	public boolean makeAppointmen(AppointmentVo appointment) {
		
		return appointmentBussiness.makeAppointment(appointment);
	}

	/*
	 * 交款处理
	 * @see com.poka.app.pb.ws.IPBPospSW#makePayment(com.poka.app.vo.PaymentVo)
	 */
	@Override
	public boolean makePayment(PaymentVo payment) {
		return paymentBussiness.makePayment(payment);
	}

	@Override
	public boolean makeQryApply(QryApply qryApply) {
		return qryApplyBussiness.makeQryApply(qryApply);
	}

	@Override
	public boolean getPerInfoData(String listData) {
		return perInfoAndBranchBussiness.updatePerInfo(listData);
	}

	@Override
	public boolean getBanchInfoData(String listData) {
		return perInfoAndBranchBussiness.updateBranchInfo(listData);
	}

}
