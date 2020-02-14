package Lessons.Lesson3AbstractClassesKeywordFinalInterfaces;

public interface List<T> {
    void add(T i) ;
    T get(int i) throws OutOfBoundException;
    int size();
}
