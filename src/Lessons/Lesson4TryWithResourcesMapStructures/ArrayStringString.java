package Lessons.Lesson4TryWithResourcesMapStructures;

import com.sun.source.tree.IfTree;

import java.util.Objects;

public class ArrayStringString implements MapStringString {

    private int countBucket;
    private int arrayLength = 10_000;
    private Bucket[] array = new Bucket[arrayLength];

    class Node {
        public final String key;
        public String value;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

   class Bucket {
        public final Node[] nodes = new Node[100];
   }


    @Override
    public void put(String key, String value) {
        if (Objects.isNull(key))
            throw new RuntimeException("key is null");
        Bucket currentBucket;
        int index = arrayLength & key.hashCode();
        if (Objects.isNull(array[index])) {
            currentBucket = new Bucket();
            array[index] = currentBucket;
        } else {
            currentBucket = array[index];
        }
        Node[] nodes = currentBucket.nodes;
        int i = 0;
        for (; Objects.nonNull(nodes[i]) && !nodes[i].key.equals(key); i++) ;
        nodes[i] = new Node(key, value);
    }

    @Override
    public String get(String key) {
        if (Objects.isNull(key)){
            throw new RuntimeException("Key is null");
        }
        int index = arrayLength & key.hashCode();
        Bucket bucket = array[index];
        if (Objects.isNull(bucket)) return null;

        for (Node node : bucket.nodes) {
            if (node.key.equals(key)) return node.value;
        }
        return null;
    }
}
