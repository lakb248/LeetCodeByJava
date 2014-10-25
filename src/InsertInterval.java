package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lakb2_000 on 2014/8/24.
 */
public class InsertInterval {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        ArrayList<Interval> list = new ArrayList<Interval>() ;
        int length = intervals.size() ;

        if(length == 0){
            list.add(newInterval) ;
            return list ;
        }


        if(newInterval.start > intervals.get(length - 1).end){
            intervals.add(newInterval) ;
            return intervals ;
        }
        if(newInterval.end < intervals.get(0).start){
            list.add(newInterval) ;
            list.addAll(intervals) ;
            return list ;
        }

        Interval cur , next ;
        ArrayList<Interval> overlapList = new ArrayList<Interval>() ;
        boolean isOverlap = false ;
        boolean hasStart = false ;
        int startArea = -1 , endArea = -1 ;
        for(int i = 0 ; i < length ; i ++){
            cur = intervals.get(i) ;

            if(cur.start <= newInterval.start){
                isOverlap = isOverlap(cur,newInterval) ;
            }else{
                isOverlap = isOverlap(newInterval,cur) ;
            }

            if(isOverlap){
                if(!hasStart){
                    startArea = i ;
                    hasStart = true ;
                }
                overlapList.add(cur) ;
                endArea = i ;
            }

        }

        if(overlapList.size() == 0){
            for(int i = 0 ; i < length ; i ++){
                if(intervals.get(i).start > newInterval.end){
                    intervals.add(i,newInterval);
                    return intervals ;
                }
            }
        }else{
            int l = overlapList.size() ;
            int overlapStart = 0 , overlapEnd = 0 ;
            if(overlapList.get(0).start <= newInterval.start){
                overlapStart = overlapList.get(0).start ;
            }else{
                overlapStart = newInterval.start ;
            }

            if(overlapList.get(l-1).end <= newInterval.end){
                overlapEnd = newInterval.end ;
            }else{
                overlapEnd = overlapList.get(l - 1).end ;
            }

            Interval interval = new Interval(overlapStart , overlapEnd) ;
            intervals.add(startArea , interval);
            for(int i = startArea + 1 ; i <= endArea + 1; i ++){
                intervals.remove(startArea + 1) ;
            }

            return intervals ;
        }


        return list ;

    }

    public boolean isOverlap(Interval one , Interval two){
        if(one.end < two.start)
            return false ;
        if(one.end >= two.start)
            return true ;
        if(one.end >= two.end)
            return true ;

        return false ;
    }

}
