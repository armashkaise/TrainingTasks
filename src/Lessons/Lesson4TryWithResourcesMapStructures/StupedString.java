package Lessons.Lesson4TryWithResourcesMapStructures;

import java.util.Objects;

public class StupedString<K, V> implements MapString<K, V> {

    private Bucket head;

    class Node<K, V> {
        public final K key;
        public V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

   class Bucket<K, V> {
        public final int keyHash;
        public final Node<K, V>[] nodes = new Node[100];
        public Bucket next;

       public Bucket(int keyHash) {
           this.keyHash = keyHash;
       }
   }


    @Override
    public void put(K key, V value) {
        Bucket current = findOrInsertBucket(key);

        if (Objects.isNull(head)){
            head = current;
        } else {
            insertNewBucked(key, current);
        }
        insertNewNode(key, value, current);
    }

    private void insertNewNode(K key, V value, Bucket current) {
        Node[] nodes = current.nodes;
        int i = 0;
        for (; Objects.nonNull(nodes[i]) && !nodes[i].key.equals(key); i++) ;
        nodes[i] = new Node(key, value);
    }

    private void insertNewBucked(K key, Bucket current) {
        Bucket last = head;
        while (Objects.nonNull(last.next) && last.keyHash != key.hashCode()){
            last = last.next;
        }
        if (last.keyHash != key.hashCode())
            last.next = current;
    }

    private Bucket findOrInsertBucket(K key) {
        if (Objects.isNull(key))
            throw new RuntimeException("key is null");
        Bucket current = head;
        while (Objects.nonNull(current) && current.keyHash != key.hashCode()){
            current = current.next;
        }
        if (Objects.isNull(current)){
            current = new Bucket(key.hashCode());
        }
        return current;
    }

    @Override
    public V get(K key) {
        if (Objects.isNull(key)){
            throw new RuntimeException("Key is null");
        }
        Bucket bucket = head;
        while (Objects.nonNull(bucket) && bucket.keyHash != key.hashCode()){
            bucket = bucket.next;
        }
        if (Objects.isNull(bucket)) return null;
        for (Node node : bucket.nodes) {
            if (node.key.equals(key)) return (V) node.value;
        }
        return null;
    }
}
