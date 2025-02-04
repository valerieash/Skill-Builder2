/**
 * This class provides various static methods that calculate various quantities
 * related to dates, including the day of week a date fall on.
 * @author
 * @version
 */
public class Date {
    /**
     * Returns true if the year is a leap year; otherwise false
     *
     * @param year the year
     * @return true if the year is a leap year; otherwise false.
     */
    public static boolean isLeapYear(int year) {
        //Leap Year
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return true;
        }
        return false;
    }

    /**
     * Returns the name of the day given by dayValue
     *
     * @param dayValue Numerical value of the day in the range 0 to 6, inclusively
     * @return the name of the day given by dayValue
     */
    public static String getNameOfDay(int dayValue) {
//?? help
        String[] daysOfTheWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int day = dayValue % 7;
        String dayOfTheWeek = daysOfTheWeek[day];
        return dayOfTheWeek;
    }

    /**
     * \
     * Returns the numeric value of the month.
     * 1 - January
     * 2 - February
     * ...
     * 12 - December
     *
     * @param name name of the month
     * @return the numeric value of the month.
     */
    public static int getMonthNumber(String name) {
        //switch case /n rplacing break with return
        switch (name) {
            case "January":
                return 1;
            case "February":
                return 2;
            case "March":
                return 3;
            case "April":
                return 4;
            case "May":
                return 5;
            case "June":
                return 6;
            case "July":
                return 7;
            case "August":
                return 8;
            case "September":
                return 9;
            case "October":
                return 10;
            case "November":
                return 11;
            case "December":
                return 12;
            default:
                return -1;


        }

    }

    /**
     * Returns the name of the month given the numeric value provided by month
     * 1 - January
     * 2 - February
     * ...
     * 12 - December
     *
     * @param month Numeric value of the month.  Should be 1 to 12, inclusively
     * @return the name of the month given the numeric value provided by month
     */
    public static String getMonthName(int month) {
        switch (month) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                return "";

        }
    }

    /**
     * Returns the number of days in the month given by the parameter month
     *
     * @param month the numeric value of the month
     * @param year  year
     * @return the number of days in the month given by the parameter month
     */
    public static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 1:
                return 31;
            case 2:
                if (isLeapYear(year)) {
                    return 29;
                }
            case 3:
                return 31;
            case 4:
                return 30;
            case 5:
                return 31;
            case 6:
                return 30;
            case 7:
                return 31;
            case 8:
                return 31;
            case 9:
                return 30;
            case 10:
                return 31;
            case 11:
                return 30;
            case 12:
                return 31;
        }
        return -1;
    }

    /**
     * Returns the number of days in the month given by the parameter month
     *
     * @param month the name of the month
     * @param year  year
     * @return the number of days in the month
     */
    public static int getDaysInMonth(String month, int year) {
        switch (month) {
            case "January":
                return 31;
            case "February":
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    return 28;
                }

            case "March":
                return 31;
            case "April":
                return 30;
            case "May":
                return 31;
            case "June":
                return 30;
            case "July":
                return 31;
            case "August":
                return 31;
            case "September":
                return 30;
            case "October":
                return 31;
            case "November":
                return 30;
            case "December":
                return 31;
            default:
                return -1;
        }
    }

    /**
     * Returns the offset in days for the month relative to January
     *
     * @param month numeric value of the month
     * @param year  year
     * @return the offset in days for the month relative to January
     */
    public static int getMonthOffset(int month, int year) {
        if (month < 1 || month > 12) {
            return -1;
        }

        int[] mof = {0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};
        int[] tof = {0, 3, 4, 0, 2, 5, 0, 3, 6, 1, 4, 6};

        if (isLeapYear(year)) {
            return mof[month - 1];
        } else {
            return tof[month - 1];
        }
    }

    /**
     * Returns the day of the week that the date falls on
     *
     * @param month      numeric value of the month
     * @param dayOfMonth day of the month
     * @param year       year
     * @return the day of the week that the date falls on
     */
    public static int dayOfWeek(int month, int dayOfMonth, int year) {
        if (dayOfMonth > getDaysInMonth(month, year) || dayOfMonth < 1) {
            return -1;
        }

        int y = (year + ((year - 1) / 4) - ((year - 1) / 100) + ((year - 1) / 400) % 7);
        return (y + getMonthOffset(month, year) + (dayOfMonth - 1)) % 7;
    }

    /**
     * Returns the day of the week that the date falls on
     *
     * @param month      name of the month
     * @param dayOfMonth day of the month
     * @param year       year
     * @return the day of the week that the date falls on
     */
    public static int dayOfWeek(String month, int dayOfMonth, int year){
        return dayOfWeek(getMonthNumber(month), dayOfMonth, year);
    }
}

