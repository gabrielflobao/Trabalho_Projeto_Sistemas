package service;

public interface OnlinePaymentService  {

    public double payamentFell(Double amount);
    public double installment (Double amount, int months);

}
