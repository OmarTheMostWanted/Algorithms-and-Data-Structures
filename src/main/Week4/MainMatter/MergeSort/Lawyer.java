package main.Week4.MainMatter.MergeSort;


import java.util.Objects;

class Lawyer {

    private int badgeNumber;

    private int numberOfTrials;

    private double hourlyWage;

    private double totalIncome;

    private int numberOfObjections;

    public Lawyer(int badgeNumber, int numberOfTrials, double hourlyWage, double totalIncome, int numberOfObjections) {
        this.badgeNumber = badgeNumber;
        this.numberOfTrials = numberOfTrials;
        this.hourlyWage = hourlyWage;
        this.totalIncome = totalIncome;
        this.numberOfObjections = numberOfObjections;
    }

    public int getBadgeNumber() {
        return badgeNumber;
    }

    public int getNumberOfTrials() {
        return numberOfTrials;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public int getNumberOfObjections() {
        return numberOfObjections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Lawyer))
            return false;
        Lawyer className = (Lawyer) o;
        return badgeNumber == className.badgeNumber && numberOfTrials == className.numberOfTrials && Double.compare(className.hourlyWage, hourlyWage) == 0 && Double.compare(className.totalIncome, totalIncome) == 0 && numberOfObjections == className.numberOfObjections;
    }

    @Override
    public int hashCode() {
        return Objects.hash(badgeNumber, numberOfTrials, hourlyWage, totalIncome, numberOfObjections);
    }

    @Override
    public String toString() {
        return "Lawyer{" + "badgeNumber=" + badgeNumber + ", numberOfTrials=" + numberOfTrials + ", hourlyWage=" + hourlyWage + ", totalIncome=" + totalIncome + ", numberOfObjections=" + numberOfObjections + '}';
    }
}