package Lessons.Lesson4TryWithResourcesMapStructures;

import java.util.Objects;

public class StupedStringString implements MapStringString {

    private Bucket head;

    class Node {
        public final String key;
        public String value;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

   class Bucket {
        public final int keyHash;
        public final Node[] nodes = new Node[100];
        public Bucket next;

       public Bucket(int keyHash) {
           this.keyHash = keyHash;
       }
   }


    @Override
    public void put(String key, String value) {
        if (Objects.isNull(key))
            throw new RuntimeException("key is null");
        Bucket current = head;
        while (Objects.nonNull(current) && current.keyHash != key.hashCode()){
            current = current.next;
        }
        if (Objects.isNull(current)){
            current = new Bucket(key.hashCode());
        }

        if (Objects.isNull(head)){
            head = current;
        } else {
            Bucket last = head;
            while (Objects.nonNull(last.next) && last.keyHash != key.hashCode()){
                last = last.next;
            }
            if (last.keyHash != key.hashCode())
                last.next = current;
        }

        Node[] nodes = current.nodes;
        int i = 0;
        for (; Objects.nonNull(nodes[i]) && !nodes[i].key.equals(key); i++) ;
        nodes[i] = new Node(key, value);

    }

    @Override
    public String get(String key) {
        if (Objects.isNull(key)){
            throw new RuntimeException("Key is null");
        }
        Bucket bucket = head;
        while (Objects.nonNull(bucket) && bucket.keyHash != key.hashCode()){
            bucket = bucket.next;
        }
        if (Objects.isNull(bucket)) return null;
        for (Node node : bucket.nodes) {
            if (node.key.equals(key)) return node.value;
        }
        return null;
    }
}
