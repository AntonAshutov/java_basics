public class TopManager extends Worker{

    public TopManager(double fixedSalaryPart, boolean bonus) {
        totalMonthSalary = (bonus? fixedSalaryPart * 2.5 : fixedSalaryPart);
    }

}
