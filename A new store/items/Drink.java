package assignment1.items;

public abstract class Drink extends StoreItem{
    //fields
    public static int MAX_PACK_SIZE;
    public static int BUZZY_HAPPINESS_BOOST;
    protected int btl_num;
    private boolean if_buzzy;
    // methods
    public Drink(double Price,int Hp_idx,int Btl_num, boolean buzziness){
        super(Price,Hp_idx);
        this.btl_num = Btl_num;
        this.if_buzzy = buzziness;

    }
    public int getNumOfBottles(){
        return this.btl_num;
    }

    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        } else if (!(obj instanceof Drink)) {
            return false;
        }else return this.if_buzzy == ((Drink) obj).if_buzzy;
    }

    public int getHappinessIndex(){
        if(this.if_buzzy){
            return BUZZY_HAPPINESS_BOOST + super.getHappinessIndex();
        }else{
            return super.getHappinessIndex();
        }
    }

    public boolean combine(Drink drk){
        if(this.equals(drk)){
            int remain_amount = MAX_PACK_SIZE - this.btl_num;
            if(remain_amount<=0){
                return false;
            }
            if(remain_amount>=drk.getNumOfBottles()){
                this.btl_num += drk.getNumOfBottles();
                drk.btl_num = 0;
            }else{
                this.btl_num = MAX_PACK_SIZE;
                drk.btl_num -= remain_amount;
            }
            return true;
        }else{return false;}
    }
    public abstract Drink getPortion(int i);



}

