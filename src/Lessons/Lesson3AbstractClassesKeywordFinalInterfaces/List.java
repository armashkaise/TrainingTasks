package Lessons.Lesson3AbstractClassesKeywordFinalInterfaces;

public interface IntList {
    void add(int i) ;
    int get(int i) throws OutOfBoundException;
    int size();
}
