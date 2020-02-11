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

//        while (Objects.nonNull(current) && current.keyHash != key.hashCode()){
//            current = current.next;
//        }
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
//                        current.right = someBucket;
                    }
                    else  {
                        someBucket.right = current;
//                        current.left = someBucket;
                    }
//                    countBucket++;
                    break;
                }
            }

//            Bucket last = head;
//            while (Objects.nonNull(last.next) && last.keyHash != key.hashCode()){
//                last = last.next;
//            }
//            if (last.keyHash != key.hashCode())
//                last.next = current;
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
//            bucket = bucket.next;
        }
        if (Objects.isNull(bucket)) return null;
        for (Node node : bucket.nodes) {
            if (node.key.equals(key)) return node.value;
        }
        return null;
    }
}
