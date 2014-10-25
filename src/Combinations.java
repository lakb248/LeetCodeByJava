package solution;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lakb2_000 on 2014/9/10.
 */
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<List<Integer>>() ;
        Deque<List<Integer>> queue = new LinkedList<List<Integer>>() ;

        for(int i = 0 ; i < n ; i ++){
            List<Integer> l = new LinkedList<Integer>() ;
            l.add(i + 1);
            queue.add(l) ;
        }

        while(!queue.isEmpty()){
            List<Integer> ll = queue.pollFirst() ;
            if(ll.size() == k){
                list.add(ll);
            }else{
                for(int i = ll.get(ll.size() - 1) + 1 ; i <= n ; i ++){
                    List<Integer> next_list = new LinkedList<Integer>() ;
                    next_list.addAll(ll) ;
                    next_list.add(i) ;
                    queue.addLast(next_list);
                }
            }
        }

        return list ;
    }

}
