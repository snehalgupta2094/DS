package Design;
class Entry<K,V>{
    K key;
    V value;
    Entry<K,V> next;
    Entry(K key, V value, Entry next){
        this.key=key;
        this.value=value;
        this.next=next;
    }
}
class MyHashMap {
    Entry map[];
    int capacity=1000000;
    public MyHashMap() {
        map=new Entry[capacity];
    }

    public void put(int key, int value) {
        int hash=hashCode(key);
        Entry current=map[hash];
        Entry newNode=new Entry(key,value,null);
        if(current==null){
            map[hash]=newNode;
        }
        else{
            Entry prev=null;
            while (current!=null){
                //value already exist overwrite it
                if(current.key.equals(key)){
                   current.value=value;
                    break;
                }
                prev=current;
                current=current.next;
            }
            if(prev!=null)
                prev.next=newNode;
        }
    }

    public int get(int key) {
        int hash=hashCode(key);
        Entry current=map[hash];
        while (current!=null){
            //value already exist
            if(current.key.equals(key)){
                return (int)current.value;
            }
            current=current.next;
        }
    return -1;
    }

    public void remove(int key) {

    }
    public int hashCode(int key){
        return hashCode(key)%capacity;
    }

}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
public class CustomHashMap {

}
