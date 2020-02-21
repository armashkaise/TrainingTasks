package Lessons.Lesson9WildcardAndPECS.yet.another.fuckup;

import java.util.Objects;
import java.util.UUID;

public class Park implements AreaSize{
    private final UUID id;
    private String name;
    private int lenght;
    private int width;

    public Park(String name, int lenght, int width) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.lenght = lenght;
        this.width = width;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Park park = (Park) o;
        return Objects.equals(id, park.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
