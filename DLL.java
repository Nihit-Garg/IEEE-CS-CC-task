public public class DLL{

    private Node head;
    private int size;

    public DLL(){
        this.size=0;
    }

    public void insertFirst(int value){
        Node node=new Node(value);
        node.next =head;
        node.prev=null;
        if(head!=null){
            head.prev=node;
        }
        head=node;
        size++;

    }

    public void insertLast(int value){
        Node node=new Node(value);
        Node last =head;
        node.next=null;
        if(head==null){
            node.prev=null;
            head=node;
            size++;
            return ;
        }
        while(last.next!=null){
            last=last.next;
        }
        last.next=node;
        node.prev=last;
    }

    public void insert(int val,int index){
        if(index==0){
            insertFirst(val);
            return;
        }
        if(index==size){
            insertLast(val);
            return;
        }
        DLL.Node temp=head;
        for(int i=1;i<index;i++){
            temp=temp.next;
        }
        DLL.Node node=new DLL.Node(val,temp.next);
        temp.next=node;
        size++;
    }


    public void Display(){
        Node node=head;
        Node last=null;
        while(node!=null){
            System.out.print(node.val +"->");
            last=node;
            node=node.next;
        }
        System.out.println("END");

        System.out.println("Print in reverse order");
        while(last!=null){
            System.out.print(last.val +"->");
            last=last.prev;
        }
        System.out.println("START");
    }



    private class Node{
        int val;
        private Node next;
        private Node prev;

        public Node(int val){
            this.val=val;
        }

        public Node(int val,Node next,Node prev){
            this.val=val;
            this.next=next;
            this.prev=prev;
        }
    }
} 
