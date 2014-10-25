package solution;

/**
 * Created by lakb2_000 on 2014/10/24.
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present.
 *                   When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 */
public class LRUCache {

    private int[] value ;
    private int[] key ;
    private int[] times ;
    private int length ;
    private int capcacity ;

    public LRUCache(int capacity) {
        this.length = 0 ;
        this.capcacity = capacity ;
        this.value = new int[capacity] ;
        this.key = new int[capacity] ;
        this.times = new int[capacity] ;
    }

    public int get(int key) {
        for(int i = 0 ; i < this.length ; i ++){
            if(this.key[i] == key){
                this.times[i] ++ ;
                return this.value[i] ;
            }
        }
        return -1 ;
    }

    public void set(int key, int value) {
        for(int i = 0 ; i < this.length ; i ++){
            if(this.key[i] == key){
                this.times[i] ++ ;
                this.value[i] = value ;
                return ;
            }
        }
        if(this.length < this.capcacity){
            this.key[this.length] = key ;
            this.value[this.length] = value ;
            this.times[this.length] = 1 ;
            this.length ++ ;
        }else{
            int min = Integer.MAX_VALUE ;
            int index = -1 ;
            for(int i = 0 ; i < this.length ; i ++){
                if(this.times[i] < min){
                    index = i ;
                    min = this.times[i] ;
                }
            }

            for(int i = index ; i < this.length - 1 ; i ++){
                this.key[i] = this.key[i + 1] ;
                this.value[i] = this.value[i + 1] ;
                this.times[i] = this.times[i + 1] ;
            }
            this.key[this.length - 1] = 0 ;
            this.value[this.length - 1] = 0 ;
            this.times[this.length - 1] = 0 ;

        }

    }

    public static void main(String[] args){
        int[] num = new int[10] ;
        System.out.print(num[8]);
    }
}
