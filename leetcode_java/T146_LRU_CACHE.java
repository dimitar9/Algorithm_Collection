public class LRUCache {
    private HashMap <Integer,Node>map;
    private int cap;
    private int number;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        cap=capacity;
        number=0;
        head=new Node(-1,-1);
        head.pre=null;
        head.next=null;
        tail=head;
        map=new HashMap<Integer,Node>(capacity);
    }

    public int get(int key) {
        Node ret=map.get(new Integer(key));
        if(ret==null) return -1;
        refresh(ret);
        return ret.value;

    }
    public void refresh(Node node){
        if(node==head.next) return ;
        Node temp=head.next ; //head node in the map;
        Node nodePre=node.pre;
        Node nodeNext=node.next; //save
        head.next=node;
        node.pre=head;
        temp.pre=node;
        node.next=temp;
        nodePre.next=nodeNext;
        if(nodeNext!=null)   nodeNext.pre=nodePre;
            else tail=nodePre;

    }

    public void set(int key, int value) {
        Node ret=map.get(new Integer(key));
        if(ret!=null) {
            refresh(ret);
            ret.value=value;
        }
        else {
            //check and delete 
            if(number==cap){
                Node temp=tail;
                tail=tail.pre;
                tail.next=null;
                map.remove(new Integer(temp.key));
                number--;
            }
            number++;
            //add in the last and refresh
            Node node=new Node(key,value);
            node.pre=tail;
            node.next=null;
            tail.next=node;
            tail=node;
            map.put(key,node);
            refresh(node);
        }

    }
    class Node{
        int key;
        int value;
        Node pre;
        Node next;
        public Node(int k,int v){
            value=v;
            key=k;
        }

    }
}


/*
cheating solution
public class LRUCache {
    private int capacity;
    private Map<Integer, Integer> map;

    public LRUCache(int c) {
      this.capacity = c;
      this.map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
      };
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        return map.get(key);
    }

    public void set(int key, int value) {
        map.put(key, value);
    }
}


*/
