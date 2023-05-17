public class Manager extends Worker {
    double moneyEarnedForCompany = (Math.random() * 25_000) + 115_000;
    public Manager(double fixedSalaryPart) {
        totalMonthSalary = Math.round(fixedSalaryPart + (moneyEarnedForCompany * 0.05));
    }

}
