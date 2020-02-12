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
            while (Objects.nonNull(currentNode.next) && !currentNode.key.equals(key)){
                currentNode = currentNode.next;
            }
            if (!currentNode.key.equals(key)){
                currentNode.next = new Node(key, value);
            } else {
                currentNode.value = value;
            }
        }

    }

    @Override
    public String get(String key) {
        int index = arrayLength & key.hashCode();
        if (Objects.isNull(array[index])) {
            return "Значение не найдено";
        } else {
            Node currentNode = array[index];
            Node someNode;
            someNode = currentNode;
            while (Objects.nonNull(someNode) && !someNode.key.equals(key)){
                someNode = someNode.next;
            }
            if (Objects.nonNull(someNode))
                return someNode.value;
        }
        return null;
    }
}
