package service;

import entites.Contract;
import entites.Installment;

import java.util.Calendar;
import java.util.Date;

public class ContractService {
    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processoContract (Contract c , int months) {
        double basicQuota = c.getTotalValue() / months;
        for (int i = 0 ; i<months ; i++) {
            Date date = addMonths(c.getDate(), i);
            double updatedQuota = basicQuota + onlinePaymentService.installment(basicQuota, i);
            double fullQuota =  updatedQuota + onlinePaymentService.payamentFell(updatedQuota);
            c.addInstallment(new Installment(date, fullQuota));
        }



    }
    private Date addMonths(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, n);
        return cal.getTime();
    }
}
