package assignment1.items;

public class MyDate {
    private int day;
    private int month;
    private int year;
    public static int[] SUMMER_MONTHS;
    public static int[] WINTER_MONTHS;

    public MyDate(int Day, int Month, int Year){
        if(Month==1 || Month==3 ||Month==5 ||Month==7 ||Month==8 ||Month==10 ||Month==12){
            if(Day<1 || Day >31){
                throw new IllegalArgumentException("The date is illegal");
            }
        }else if(Month==4 || Month==6 ||Month==9 ||Month==11){
            if(Day<1 || Day >30){
                throw new IllegalArgumentException("The date is illegal");
            }
        }else if (Month == 2){
            if(Day<1 || Day>28){
                throw new IllegalArgumentException("The date is illegal");
            }
        }else{ throw new IllegalArgumentException("The date is illegal");}
        if(Year<1 || Year>9999){
            throw new IllegalArgumentException("The date is illegal");
        }
        this.day = Day;
        this.month = Month;
        this.year = Year;
    }

    public int getDay(){
        return this.day;
    }
    public int getMonth(){
        return this.month;
    }
    public int getYear(){
        return this.year;
    }
    public boolean equals(Object obj){
        if(obj instanceof MyDate){
            if(((MyDate) obj).day == this.day && ((MyDate)obj).month == this.month && ((MyDate)obj).year == this.year){
                return true;
            }
        }
        return false;
    }
    public static MyDate today(){
        int year = java.time.LocalDate.now().getYear();
        int month = java.time.LocalDate.now().getMonthValue();
        int day = java.time.LocalDate.now().getDayOfMonth();
        return new MyDate(day,month,year);
    }
}
