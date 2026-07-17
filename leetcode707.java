class MyLinkedList {

    class Node {
        int val;
        Node next;

        Node(int val){
            this.val = val;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {

        head = null;
        tail = null;
        size = 0;
        
    }
    
    public int get(int index) {

        if(index<0 || index>=size){
            return -1;
        }

        Node temp = head;

        for(int i =0 ;i<index ;i++){
            temp = temp.next;
        }

        return temp.val;
        
    }
    
    public void addAtHead(int val) {

        Node node = new Node(val);

        node.next = head;

        head = node;

        if(size == 0){
            tail = head;
        }

        size++;
        
    }
    
    public void addAtTail(int val) {

        Node node = new Node(val);

        if(size == 0){
            head = node;
            tail = node;
        }else{

           tail.next = node;
           tail  = node;

        }
        size++;
        
    }
    
    public void addAtIndex(int index, int val) {

        if(index<0 || index>size){
            return ;
        }
        if(index == 0){
    addAtHead(val);
    return;
}
        if(index == size){
            addAtTail(val);
            return;
        }

        Node prev = head ;

        for(int i = 0 ;i<index-1;i++){

         prev =   prev.next; 
        }

        Node node = new Node(val);

        node.next = prev.next;
         prev.next = node;

          size++; 
    }
 
    
    public void deleteAtIndex(int index) {
        if(index <0 || index >=size){
            return ;
        }

        if(index == 0){
            head = head.next;
            size--;

            if(size == 0){
                tail = null;
            }
            return ;
        }

        Node prev = head;

        for(int i = 0;i<index -1;i++){
            
            prev = prev.next;

        }

        prev.next = prev.next.next;


        if(index == size-1){
            tail = prev;
        }

        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
