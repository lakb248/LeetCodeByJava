package solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by lakb2_000 on 2014/8/24.
 */
public class MergeIntervals {
    public static void  main(String[] args){}

    public List<Interval> merge(List<Interval> intervals){
        if(intervals.size() == 1 || intervals.size() == 0)
            return intervals ;
        List<Interval> list = new ArrayList<Interval>() ;
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval int1, Interval int2) {
                return int1.start - int2.start;
            }
        });
        int length = intervals.size() ;
        Interval i1 = null , i2 = null ;
        int i = 0 ;
        while(i < length - 1){
            i1 = intervals.get(i) ;
            i2 = intervals.get(i + 1) ;

            if(i1.end >= i2.start){
                if(i1.end >= i2.end){
                    i2.start = i1.start ;
                    i2.end = i1.end ;
                }else{
                    i2.start = i1.start ;
                }
            }else{
                list.add(i1) ;
            }
            i ++ ;
        }
        list.add(i2) ;
        return list ;
    }

    public void sort(List<Interval> list){
        int length = list.size() ;
        boolean flag = true ;
        for(int i = 0 ; i < length ; i ++){
            flag = true ;
            for(int j = 0 ; j < length - i - 1 ; j ++){
                Interval i1 = list.get(j) , i2 = list.get(j + 1) ;
                if(i1.start > i2.start){
                    Interval temp = i1 ;
                    i1 = i2 ;
                    i2 = temp ;
                    flag = false ;
                }
            }
            if(flag)
                return ;
        }
    }
}


class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}