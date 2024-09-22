import java.text.NumberFormat;
import java.util.Locale;

public class Mortgage
{
    private double mortgage_amount_principal_P;
    private double yearly_interest_rate;
    private int mortgage_term_in_Years;
    private double mortgage_rate_in_months_r;
    private int total_payments_n;

    public Mortgage(double mortgage_amount_principal_P, double yearly_interest_rate, int mortgage_term_in_Years)
    {
        this.mortgage_amount_principal_P = mortgage_amount_principal_P;
        this.yearly_interest_rate = yearly_interest_rate;
        this.mortgage_term_in_Years = mortgage_term_in_Years;
        this.mortgage_rate_in_months_r = (yearly_interest_rate / 100) / 12;
        this.total_payments_n = mortgage_term_in_Years * 12;
    }

    public double monthly_mortgage_calculation_M()
    {
        if (mortgage_rate_in_months_r == 0) {
            return mortgage_amount_principal_P / total_payments_n;
        }
        double monthly_payment_M = mortgage_amount_principal_P *
            (mortgage_rate_in_months_r * Math.pow(1 + mortgage_rate_in_months_r, total_payments_n)) /
            (Math.pow(1 + mortgage_rate_in_months_r, total_payments_n) - 1);
        return monthly_payment_M;
    }

    public double principal_balance_after_one_installment()
    {
        double monthly_payment = monthly_mortgage_calculation_M();
        double interest_paid = mortgage_amount_principal_P * mortgage_rate_in_months_r;
        double principal_payment = monthly_payment - interest_paid;
        mortgage_amount_principal_P = mortgage_amount_principal_P - principal_payment;
        return mortgage_amount_principal_P;
    }

    public double extra_principal_payment(double extra_payment)
    {
        mortgage_amount_principal_P = mortgage_amount_principal_P - extra_payment;
        return mortgage_amount_principal_P;
    }

    public void set_interest_rate(double yearly_interest_rate_new)
    {
        this.yearly_interest_rate = yearly_interest_rate_new;
        this.mortgage_rate_in_months_r = (yearly_interest_rate / 100) / 12;
    }

    public double get_principal_balance()
    {
        return mortgage_amount_principal_P;
    }
}

class MortgageCalculation
{
    public static void main(String[] args)
    {
        NumberFormat fmt1 = NumberFormat.getCurrencyInstance(Locale.US);

        Mortgage mortgage1 = new Mortgage(400000, 6, 30);
        Mortgage mortgage2 = new Mortgage(350000, 5.75, 15);

        System.out.println("\nMortgage1 monthly payment: " + fmt1.format(mortgage1.monthly_mortgage_calculation_M()));
        System.out.println("Mortgage2 monthly payment: " + fmt1.format(mortgage2.monthly_mortgage_calculation_M()) + "\n");

        System.out.println("Mortgage1 principal balance after one installment: " + fmt1.format(mortgage1.principal_balance_after_one_installment()));
        System.out.println("Mortgage2 principal balance after one installment: " + fmt1.format(mortgage2.principal_balance_after_one_installment()) + "\n");

        mortgage1.set_interest_rate(6 - 0.25);
        mortgage2.set_interest_rate(5.75 - 0.25);

        System.out.println("Mortgage1 new monthly payment after interest rate reduction: " + fmt1.format(mortgage1.monthly_mortgage_calculation_M()));
        System.out.println("Mortgage2 new monthly payment after interest rate reduction: " + fmt1.format(mortgage2.monthly_mortgage_calculation_M()) + "\n");

        mortgage1.extra_principal_payment(5000);
        mortgage2.extra_principal_payment(5000);

        System.out.println("Mortgage1 monthly payment after adding extra principal payment: " + fmt1.format(mortgage1.monthly_mortgage_calculation_M()));
        System.out.println("Mortgage2 monthly payment after adding extra principal payment: " + fmt1.format(mortgage2.monthly_mortgage_calculation_M()) + "\n");

        System.out.println("Mortgage1 current principal balance: " + fmt1.format(mortgage1.get_principal_balance()));
        System.out.println("Mortgage2 current principal balance: " + fmt1.format(mortgage2.get_principal_balance()) + "\n");
    }
}
