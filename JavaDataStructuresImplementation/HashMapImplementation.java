import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapImplementation<K, V> {

    static class Node<K, V> {
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size; // total number of nodes
    private int capacity; // total buckets
    private LinkedList<Node<K, V>>[] buckets;

    @SuppressWarnings("unchecked")
    public HashMapImplementation() {
        this.capacity = 4;
        this.buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            this.buckets[i] = new LinkedList<>();
        }
    }

    private int hashFunc(K key) {
        int bucketIdx = key.hashCode() % capacity;
        return Math.abs(bucketIdx);
    }

    private int searchInLL(LinkedList<Node<K, V>> list, K key) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).key.equals(key)) {
                return i;
            }
        }
        return -1;
    }

    private void reHash() {
        LinkedList<Node<K, V>>[] oldBuckets = buckets;
        capacity *= 2;
        buckets = new LinkedList[capacity];

        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }

        for (LinkedList<Node<K, V>> list : oldBuckets) {
            for (Node<K, V> node : list) {
                put(node.key, node.value);
            }
        }
    }

    public void put(K key, V value) {
        int bucketIdx = hashFunc(key);
        LinkedList<Node<K, V>> list = buckets[bucketIdx];
        int dataIdx = searchInLL(list, key);

        if (dataIdx == -1) {
            list.add(new Node<>(key, value));
            size++;
        } else {
            Node<K, V> node = list.get(dataIdx);
            node.value = value;
        }

        double lambda = (double) size / capacity;
        if (lambda > 2.0) {
            reHash();
        }
    }

    public boolean containsKey(K key) {
        int bucketIdx = hashFunc(key);
        LinkedList<Node<K, V>> list = buckets[bucketIdx];
        return searchInLL(list, key) != -1;
    }

    public V get(K key) {
        int bucketIdx = hashFunc(key);
        LinkedList<Node<K, V>> list = buckets[bucketIdx];
        int dataIdx = searchInLL(list, key);
        return (dataIdx != -1) ? list.get(dataIdx).value : null;
    }

    public V remove(K key) {
        int bucketIdx = hashFunc(key);
        LinkedList<Node<K, V>> list = buckets[bucketIdx];
        int dataIdx = searchInLL(list, key);

        if (dataIdx != -1) {
            Node<K, V> node = list.remove(dataIdx);
            size--;
            return node.value;
        }
        return null;
    }

    public ArrayList<K> keySet() {
        ArrayList<K> keys = new ArrayList<>();
        for (LinkedList<Node<K, V>> list : buckets) {
            for (Node<K, V> node : list) {
                keys.add(node.key);
            }
        }
        return keys;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        HashMapImplementation<String, Integer> mp = new HashMapImplementation<>();
        mp.put("Bangladesh", 20);
        mp.put("India", 120);

        ArrayList<String> keys = mp.keySet();

        for (String key : keys) {
            System.out.println(key + " " + mp.get(key));
        }
    }
}
