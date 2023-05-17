public abstract class Worker implements Employee{
    protected double totalMonthSalary;
    public double getMonthSalary() {
        totalMonthSalary = Math.round(totalMonthSalary);
        return totalMonthSalary;
    }
    @Override
    public String toString(){
        return (this.getClass().getName() + ", salary - " + totalMonthSalary);
    }
}
