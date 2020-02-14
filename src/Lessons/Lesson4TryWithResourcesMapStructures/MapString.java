package Lessons.Lesson4TryWithResourcesMapStructures;

public interface MapStringString<K, V> {
    void put(K key, V value);
    V get(K key);
}
