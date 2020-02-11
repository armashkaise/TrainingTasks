package Lessons.Lesson4TryWithResourcesMapStructures;

import java.util.Objects;

public class TreeStringString implements MapStringString {

    private Bucket head;
    private int countBucket;

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
        public Bucket left;
        public Bucket right;
        public Bucket(int keyHash) {
           this.keyHash = keyHash;
       }
   }


    @Override
    public void put(String key, String value) {
        if (Objects.isNull(key))
            throw new RuntimeException("key is null");
        Bucket current = head;
        if (Objects.isNull(current)){
            current = new Bucket(key.hashCode());
            countBucket++;
        }
        if (Objects.isNull(head)){
            head = current;
        } else {
            for (int i = 0; i < countBucket; i++) {
                Bucket someBucket= current;
                if (current.keyHash == key.hashCode()) {
                    break;
                }
                else if (current.keyHash < key.hashCode()){//меньше
                    current = current.right;
                } else{//больше
                    current = current.left;
                }
                if (Objects.isNull(current)) {
                    current = new Bucket(key.hashCode());
                    countBucket++;
                    if (current.keyHash < someBucket.keyHash) {
                        someBucket.left = current;
                    }
                    else  {
                        someBucket.right = current;
                    }
                    break;
                }
            }
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
        for (int i = 0; i < countBucket; i++) {
            if (bucket.keyHash == key.hashCode()) {
                for (Node node : bucket.nodes) {
                    if (node.key.equals(key)) return node.value;
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
