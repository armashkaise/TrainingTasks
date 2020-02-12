package Lessons.Lesson4TryWithResourcesMapStructures;

import java.util.Objects;

public class AssocArrayStringString implements MapStringString {

    private int countNode;
    private int arrayLength = 10_000;
    private Node[] array = new Node[arrayLength];

    class Node {
        public final int hashCode;
        public final String key;
        public String value;
        private Node next;

        public Node(String key, String value) {
            this.hashCode = key.hashCode();
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return hashCode == node.hashCode &&
                    Objects.equals(key, node.key) &&
                    Objects.equals(value, node.value) &&
                    Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(hashCode, key, value, next);
        }
    }

//   class Bucket {
//        public final Node[] nodes = new Node[100];
//   }


    @Override
    public void put(String key, String value) {
        if (Objects.isNull(key))
            throw new RuntimeException("key is null");
        Node currentNode;
        int index = arrayLength & key.hashCode();
        if (Objects.isNull(array[index])) {
            currentNode = new Node(key, value);
            array[index] = currentNode;
            countNode++;
        } else {
            currentNode = array[index];
            Node someNode;
            someNode = currentNode.next;
            while (Objects.nonNull(someNode) && !someNode.key.equals(key)){
                someNode = someNode.next;
            }
            someNode = new Node(key, value);
            System.out.println(someNode);
        }


//        Node[] nodes = currentBucket.nodes;
//        int i = 0;
//        for (; Objects.nonNull(nodes[i]) && !nodes[i].key.equals(key); i++) ;
//        nodes[i] = new Node(key, value);
    }

    @Override
    public String get(String key) {
//        if (Objects.isNull(key)){
//            throw new RuntimeException("Key is null");
//        }
//        int index = arrayLength & key.hashCode();
//        Bucket bucket = array[index];
//        if (Objects.isNull(bucket)) return null;
//
//        for (Node node : bucket.nodes) {
//            if (node.key.equals(key)) return node.value;
//        }
        return null;
    }
}
