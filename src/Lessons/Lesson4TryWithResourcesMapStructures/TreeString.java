package Lessons.Lesson4TryWithResourcesMapStructures;

import java.util.Objects;

public class TreeString<K, V> implements MapString<K, V> {

    private Bucket head;
    private int countBucket;

    class Node<K, V> {
        public final K key;
        public V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

   class Bucket<K,V> {
        public final int keyHash;
        public final Node<K, V>[] nodes = new Node[100];
        public Bucket left;
        public Bucket right;
        public Bucket(int keyHash) {
           this.keyHash = keyHash;
       }
   }


    @Override
    public void put(K key, V value) {
        if (Objects.isNull(key))
            throw new RuntimeException("key is null");
//        Bucket current = head;
//        if (Objects.isNull(current)){
//            current = new Bucket(key.hashCode());
//            countBucket++;
//        }
        Bucket current = null;
        if (Objects.isNull(head)){
            current = insertNewBucked(key);
            head = current;
        } else {
            current = findAndInsertBucket(key);
//            for (int i = 0; i < countBucket; i++) {
//                current = head;
//                Bucket someBucket= current;
//                if (current.keyHash == key.hashCode()) {
//                    break;
//                }
//                else if (current.keyHash < key.hashCode()){//меньше
//                    current = current.right;
//                } else{//больше
//                    current = current.left;
//                }
//                if (Objects.isNull(current)) {
//                    current = new Bucket(key.hashCode());
//                    countBucket++;
//                    if (current.keyHash < someBucket.keyHash) {
//                        someBucket.left = current;
//                    }
//                    else  {
//                        someBucket.right = current;
//                    }
//                    break;
//                }
//            }
        }
        insertNewNode(key, value, current);
//        Node[] nodes = current.nodes;
//        int i = 0;
//        for (; Objects.nonNull(nodes[i]) && !nodes[i].key.equals(key); i++) ;
//        nodes[i] = new Node(key, value);
    }

    private void insertNewNode(K key, V value, Bucket current) {
        Node[] nodes = current.nodes;
        int i = 0;
        for (; Objects.nonNull(nodes[i]) && !nodes[i].key.equals(key); i++) ;
        nodes[i] = new Node(key, value);
    }

    private Bucket findAndInsertBucket(K key) {
        Bucket current = head;

        for (int i = 0; i < countBucket; i++) {
            Bucket someBucket = current;
            if (current.keyHash == key.hashCode()) {
                break;
            }
            else if (current.keyHash < key.hashCode()){//меньше
                current = current.right;
            } else{//больше
                current = current.left;
            }
            if (Objects.isNull(current)) {
                current = insertNewBucked(key);
                if (current.keyHash < someBucket.keyHash) {
                    someBucket.left = current;
                }
                else  {
                    someBucket.right = current;
                }
                break;
            }
        }
        return current;
    }

    private Bucket insertNewBucked(K key) {
        countBucket++;
        return new Bucket(key.hashCode());
    }

    @Override
    public V get(K key) {
        if (Objects.isNull(key)){
            throw new RuntimeException("Key is null");
        }
        Bucket bucket = head;
        for (int i = 0; i < countBucket; i++) {
            if (bucket.keyHash == key.hashCode()) {
                for (Node node : bucket.nodes) {
                    if (node.key.equals(key)) return (V) node.value;
                }
            }
            else if (bucket.keyHash < key.hashCode()){
                bucket = bucket.right;
            } else {//больше
                bucket = bucket.left;
            }
        }
        return null;
    }
}
