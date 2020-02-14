package Lessons.Lesson4TryWithResourcesMapStructures;

public interface MapString<K, V> {
    void put(K key, V value);
    V get(K key);
}
