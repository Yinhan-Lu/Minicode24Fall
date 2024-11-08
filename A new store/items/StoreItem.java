package assignment1.items;

public abstract class StoreItem{
    private double price;
    private int hp_idx;
    public StoreItem(double Price,int Hp_idx){
        //constructor
        if (!(Price >= 0 && Hp_idx>=0)){
            throw new IllegalArgumentException("One of the price and happiness index is negative");
        }
        this.price = Price;
        this.hp_idx = Hp_idx;
    }

    public final double getPrice(){
        return this.price;
    }

    public int getHappinessIndex() {
        return this.hp_idx;
    }
    public boolean equals(Object obj){
        if (obj instanceof StoreItem){
            StoreItem obj_down = (StoreItem) obj;
            return Math.abs(this.price - obj_down.price) < 0.001 && (this.getHappinessIndex() == obj_down.getHappinessIndex());

        }
        return false;
    }


}
