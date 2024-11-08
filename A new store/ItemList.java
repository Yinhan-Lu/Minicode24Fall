package assignment1;

import assignment1.items.*;// StoreItem is not in same package as itemlist. we should import it although it is public

public class ItemList {
    private StoreItem[] StoreItems;
    private int size;

    public ItemList(){
        this.StoreItems = new StoreItem[10];
        size = 0;
    }

    private void resize(){
        StoreItem[] bigger_items = new StoreItem[size*2];
        int i = 0;
        while(i<this.size){
            bigger_items[i] = this.StoreItems[i];
            i++;
        }
        this.StoreItems = bigger_items;
    }

    public int getSize(){
        return size;
    }
    public StoreItem[] getAllItems(){
        StoreItem[] all_items = new StoreItem[this.size];
        int i = 0;
        
        while(i<this.size){
            all_items[i] = this.StoreItems[i];
            i++;
        }
        return all_items;
    }
    public void addItem(StoreItem new_item){
        if(this.size == this.StoreItems.length){
            resize();
        }
        this.StoreItems[this.size] = new_item;
        this.size++;
    }
    public StoreItem removeItem(StoreItem the_item){
        boolean found = false;
        StoreItem found_item;
        int i = 0;
        while(i<this.size &&(! found)){
            if(the_item.equals(this.StoreItems[i])){/////
                found = true;
            }
            i++;
        }
        if(found){
            found_item = this.StoreItems[i-1];
            while(i<this.size){
                this.StoreItems[i-1] = this.StoreItems[i];
                i++;
            }
            this.StoreItems[i-1] = null;
            this.size--;
            // this.StoreItems = this.getAllItems();
            
            
            return found_item;
        }else{return null;}
    }
    public StoreItem[]  findEqualItems(StoreItem the_item){
        StoreItem[] found_list_big = new StoreItem[this.size];
        int found_size = 0;
        int i = 0;
        while(i<this.size){
            if(the_item.equals(this.StoreItems[i])){
                found_list_big[found_size] = this.StoreItems[i];
                found_size++;
            }
            i++;
        }
        StoreItem[] found_list = new StoreItem[found_size];
        if (found_size == 0){
            return found_list;
        }else{
            int k = 0;
            while(k<found_size){
                found_list[k] = found_list_big[k];
                k++;
            }
        }
        return found_list;
    }
}
