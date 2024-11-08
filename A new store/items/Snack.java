package assignment1.items;

public class Snack extends StoreItem {
    private String snk_type;
    private MyDate date;

    public Snack(double Price, int Hp_idx, String Type, MyDate Date) {
        super(Price, Hp_idx);
        this.snk_type = Type;
        this.date = Date;

    }
    public boolean equals(Object obj){
        if(super.equals(obj)){
            if(obj instanceof Snack){
                if (((Snack)obj).snk_type.equals(this.snk_type) && this.date.equals( ( (Snack)  obj).date) ){
                    return true;
                }
            }
        }
        return false;
    }

    //true means expired
    public boolean isExpired(){
        MyDate today = MyDate.today();
        if(today.getYear()>this.date.getYear()){
            return true;
        }else if(today.getYear()<this.date.getYear()){
            return false;
        }else{
            if(today.getMonth()>this.date.getMonth()){
                return true;
            }else if(today.getMonth()<this.date.getMonth()){
                return false;
            }else{
                if(today.getDay()>this.date.getDay()){
                    return true;
                }else if(today.getMonth()<=this.date.getMonth()){ // i am not sure whether it is counted to expired in the expired day.
                    return false;
                }
            }
        }
        return false;
    }

    
    

    @Override
    public int getHappinessIndex() {
        if(isExpired()){return super.getHappinessIndex()/2;}else{return super.getHappinessIndex();}

    }

}
