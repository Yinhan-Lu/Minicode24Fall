package assignment1.items;

public class FizzWiz extends Drink{
    public FizzWiz(double Price,int Hp_idx, int Btl_num){
        super(Price,Hp_idx,Btl_num,true);
    }
    public boolean equals(Object obj){
        if( obj instanceof FizzWiz && super.equals(obj)){
            return true;
        }
        return false;
    }


    public Drink getPortion(int por_int) {
        if(por_int <= this.getNumOfBottles()){

            FizzWiz new_fizz = new FizzWiz(this.getPrice(),
                    super.getHappinessIndex()-BUZZY_HAPPINESS_BOOST, por_int); // fizzWiz must trigger buzzy boost
            this.btl_num = this.getNumOfBottles()-por_int;
            return new_fizz;
        }else{
            return null;
        }



    }
}
