package assignment1;
import assignment1.items.*;
public class  Store {
    private ItemList store_list;
    private double total_revenue;

    public Store(ItemList list){
        this.store_list = list;
        total_revenue = 0;
    }

    public double getRevenue(){
        return this.total_revenue;
    }

    public ItemList getItems(){
        return this.store_list;
    }

    public void cleanUp(){
        int i = 0;
        StoreItem[] current_items = this.store_list.getAllItems();
        while(i<current_items.length){
            if(current_items[i] instanceof Snack && ((Snack) current_items[i]).isExpired()){
                this.store_list.removeItem(current_items[i]);
            }
            i++;
        }
    }

    public int completeSale(ItemList my_list){
        StoreItem[] current_list = my_list.getAllItems();
        int current_list_size = my_list.getSize();
        int i = 0;
        int hp_sum = 0;
        while(i<current_list_size){
            if (current_list[i] instanceof Snack){
                Snack removed_Snack = (Snack)this.store_list.removeItem(current_list[i]);
                if(removed_Snack!=null){
                    hp_sum += removed_Snack.getHappinessIndex();
                    this.total_revenue+=removed_Snack.getPrice();
                }

            } else if (current_list[i] instanceof SnoozeJuice) {
                SnoozeJuice removed_SnoozeJuice = (SnoozeJuice)this.store_list.removeItem(current_list[i]);
                SnoozeJuice portioned_snooze = null;
                if(removed_SnoozeJuice!=null) {
                    if (((SnoozeJuice) current_list[i]).getNumOfBottles() > removed_SnoozeJuice.getNumOfBottles()) {
                        portioned_snooze = (SnoozeJuice) removed_SnoozeJuice.
                                getPortion(removed_SnoozeJuice.getNumOfBottles());

                    } else {
                        portioned_snooze = (SnoozeJuice) removed_SnoozeJuice.
                                getPortion(((SnoozeJuice) current_list[i]).getNumOfBottles());
                    }
                }
                if(portioned_snooze!=null){
                    hp_sum += portioned_snooze.getHappinessIndex()*portioned_snooze.getNumOfBottles();
                    this.total_revenue+=portioned_snooze.getPrice()*portioned_snooze.getNumOfBottles();
                    if (removed_SnoozeJuice.getNumOfBottles()!=0){
                        store_list.addItem(removed_SnoozeJuice);
                    }
                }



            } else if (current_list[i] instanceof FizzWiz ) {
                FizzWiz removed_FizzWiz = (FizzWiz)store_list.removeItem(current_list[i]);
                FizzWiz portioned_FizzWiz = null;
                if(removed_FizzWiz!=null) {
                    if (((FizzWiz) current_list[i]).getNumOfBottles() > removed_FizzWiz.getNumOfBottles()) {
                        portioned_FizzWiz = (FizzWiz) removed_FizzWiz.
                                getPortion(removed_FizzWiz.getNumOfBottles());

                    } else {
                        portioned_FizzWiz = (FizzWiz) removed_FizzWiz.
                                getPortion(((FizzWiz) current_list[i]).getNumOfBottles());
                    }
                }
                if(portioned_FizzWiz!=null){
                    hp_sum += portioned_FizzWiz.getHappinessIndex()*portioned_FizzWiz.getNumOfBottles();
                    this.total_revenue+=portioned_FizzWiz.getPrice()*portioned_FizzWiz.getNumOfBottles();

                    if (removed_FizzWiz.getNumOfBottles()!=0){
                        store_list.addItem(removed_FizzWiz);
                    }
                }
            }
            i++;
        }
        return hp_sum;
    }

    public void refillDrinkInventory(Drink[] new_drinks){
        int i = 0;
        Drink current_drink;
        while(i< new_drinks.length && new_drinks[i]!=null){
            current_drink = new_drinks[i];

            for(StoreItem each_item: store_list.findEqualItems(current_drink)){
//                each_item = (Drink)each_item;
                if(each_item!=null){((Drink) each_item).combine(current_drink);}

            }
            if (current_drink.getNumOfBottles() != 0){
                this.store_list.addItem(current_drink);
            }
            i++;
        }
    }
}
