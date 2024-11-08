package assignment1.items;

public class SnoozeJuice extends Drink{
    private double tem;
    public static int HOT_COLD_BOOST;
    public static int COLD_HOT_BOOST;
    public SnoozeJuice(double Price, int Hp_idx,int Btl_num, double Tem){
        super(Price, Hp_idx, Btl_num,false);
        this.tem = Tem;
    }
    public boolean equals(Object obj){
        if(obj instanceof SnoozeJuice && super.equals(obj)){
            return Math.abs(((SnoozeJuice) obj).tem - this.tem)<0.001;
        }
        return false;
    }

    @Override
    public int getHappinessIndex() {
        if (this.tem < 4 || this.tem > 65) {
            return 0;
        } else if ((this.tem >= 4 && this.tem <= 10)) {
            boolean is_summer = false;
            int current_month = MyDate.today().getMonth();
            int i = 0;
            while (i < MyDate.SUMMER_MONTHS.length && (!is_summer)) {
                if (current_month == MyDate.SUMMER_MONTHS[i]) {
                    is_summer = true;
                }
                i++;
            }
            if (is_summer) {
                return super.getHappinessIndex() + HOT_COLD_BOOST;
            }else{
                return super.getHappinessIndex();
            }
        } else if ((this.tem >= 55 && this.tem <= 65)) {
            boolean is_winter = false;
            int current_month = MyDate.today().getMonth();
            int i = 0;
            while (i < MyDate.WINTER_MONTHS.length && (!is_winter)) {
                if (current_month == MyDate.WINTER_MONTHS[i]) {
                    is_winter = true;
                }
                i++;
            }
            if (is_winter) {
                return super.getHappinessIndex() + COLD_HOT_BOOST;
            }else{
                return super.getHappinessIndex();
            }
        } else {
            return super.getHappinessIndex();
        }
    }

    public Drink getPortion(int por_int) {
        if(por_int <= this.getNumOfBottles()){
            SnoozeJuice new_Snooze = new SnoozeJuice(super.getPrice(),
                    super.getHappinessIndex(), por_int, this.tem);
            this.btl_num = super.getNumOfBottles()-por_int;
            return (Drink)new_Snooze;
        }else{
            return null;
        }



    }
}
