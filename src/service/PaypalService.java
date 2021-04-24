package service;

public class PaypalService implements OnlinePaymentService{
    private static final Double valorFell = 0.02;
    private static final Double valorMonths = 0.02;


    @Override
    public double payamentFell(Double amount) {
        return amount * valorFell;
    }

    @Override
    public double installment(Double amount, int months) {
        return amount * months * valorMonths;

    }

}
