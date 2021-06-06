public class FCFS{
    static int fcfs(int arr[],int head){
        int count=0,current=0;
        for(int i=0;i<arr.length;i++)
       {
            current = arr[i];
            count += Math.abs(current-head);
            head = current;
        }
        return count;
    }
    public static void main (String[] args){
        int arr[]  = {176, 79, 34, 60, 92, 11, 41, 114};
        int head = 50;
        int count = fcfs(arr,head);
        System.out.println(count);
    }
    }