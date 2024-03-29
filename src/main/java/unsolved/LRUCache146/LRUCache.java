package unsolved.LRUCache146;

public class LRUCache {
    class Node{
        int key;
        int value;

        Node prev;
        Node next;

        Node(int key, int value){
            this.key= key;
            this.value= value;
        }
    }

    public Node[] map;
    public int count, capacity;
    public Node head, tail;

    public LRUCache(int capacity) {

        this.capacity= capacity;
        count= 0;

        map= new Node[10_000+1];

        head= new Node(0,0);
        tail= new Node(0,0);

        head.next= tail;
        tail.prev= head;

        head.prev= null;
        tail.next= null;
    }

    public void deleteNode(Node node){
        node.prev.next= node.next;
        node.next.prev= node.prev;

        return;
    }

    public void addToHead(Node node){
        node.next= head.next;
        node.next.prev= node;
        node.prev= head;

        head.next= node;

        return;
    }

    public int get(int key) {

        if( map[key] != null ){

            Node node= map[key];

            int nodeVal= node.value;

            deleteNode(node);

            addToHead(node);

            return nodeVal;
        }
        else
            return -1;
    }

    public void put(int key, int value) {

        if(map[key] != null){

            Node node= map[key];

            node.value= value;

            deleteNode(node);

            addToHead(node);

        } else {

            Node node= new Node(key,value);

            map[key]= node;

            if(count < capacity){
                count++;
                addToHead(node);
            }
            else {

                map[tail.prev.key]= null;
                deleteNode(tail.prev);

                addToHead(node);
            }
        }

        return;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.get(1);
        lruCache.put(3,3);
        lruCache.get(2);
        lruCache.put(4,4);
        lruCache.get(1);
        lruCache.get(3);
        lruCache.get(4);
    }
}
