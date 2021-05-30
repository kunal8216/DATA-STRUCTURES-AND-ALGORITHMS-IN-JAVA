import java.util.*;
public class sstf {
    private static ArrayList<Integer> list = new ArrayList<Integer>();
    void init(int arr[]){
        for(Integer i: arr)
            list.add(i);
    }
    public ArrayList<Integer> get(){
        return list;
    }
    public void set(int i){
        list.remove(i);
    }
	   static Integer min_finder(ArrayList<Integer> list,Integer head){
       Integer min = Integer.MAX_VALUE;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for(int i=0;i<list.size();i++){
            if(list.get(i)== head)
                continue;
            temp.add(Math.abs(head-list.get(i)));
        }
        for(Integer i:temp)
            if(min>i) 
                min=i;
        for(int i=0;i<temp.size();i++)     
            if(temp.get(i)==min){
                min = list.get(i);
                break;
        }
        int e=0;
        for(int i=0;i<list.size();i++)
            if(list.get(i)==min)
                e = i;
        sstf obj = new sstf();
        obj.set(e);
        return min;
    }
    static int fcfs(ArrayList<Integer> list,Integer head,int n){
        Integer count=0,current=0;
        for(int i=0;i<n;i++)
       {
            int min_distance = min_finder(list,head);
            current = min_distance;
            count += Math.abs(current-head);
            head = current;
        }
        return count;
    }
    public static void main(String[] args) {
        int arr[] = {176, 79, 34, 60, 92, 11, 41, 114};
        Integer head = 50;
        sstf o = new sstf(); 
        o.init(arr);
        System.out.println(fcfs(o.get(),head,arr.length));
    }  
}