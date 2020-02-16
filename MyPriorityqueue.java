public class MyPriorityQueue {
    private int[] queue;
    private int size;
    public MyPriorityQueue(){
        this(10);
    }
    public MyPriorityQueue(int capacity){
        if(capacity<0){
            throw new IllegalArgumentException("Illegal:"+capacity);
        }
        this.queue=new int[capacity];
        this.size=0;
    }
    private void shlftdown(int index){
        int left=index*2+1;
        while(left<size){
            int max=left;
            int right=index*2+2;
            if(right<size){
                if(queue[right]>queue[left]){
                    max=queue[right];
                }
            }
            if(queue[index]>queue[max]){
                break;
            }
            int tmp=queue[index];
            queue[index]=queue[max];
            queue[max]=tmp;

            index=max;
            left=2*index+1;

        }
    }
    private void shlftup(int index){
        while(index>0){
            int parent=(index-1)/2;
            if(queue[parent]>queue[index]){
                break;
            }
            int tmp=queue[parent];
            queue[parent]=queue[index];
            queue[index]=tmp;

            index=parent;
        }
    }
    public boolean offer(int element){
        queue[size++]=element;
        shlftup(size-1);
        return true;
    }

    public int poll(){
        if(size<=0){
            throw new IndexOutOfBoundsException();
        }
        int element=queue[0];
        queue[0]=queue[--size];
        shlftdown(0);
        return element;
    }

    public int peek(){
        return queue[0];
    }

    public boolean isEmpty(){
        return 0==size;
    }

    public int size(){
        return size;
    }

}


