package Lessons.Lesson9WildcardAndPECS.yet.another.fuckup;

import java.util.Objects;
import java.util.UUID;

public class Street implements AreaSize{
    private final UUID id;
    private String name;
    private int lenght;
    private int width;

    public Street(String name, int lenght, int width) {
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
    public String toString() {
        return "Street{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lenght=" + lenght +
                ", width=" + width +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Street street = (Street) o;
        return Objects.equals(id, street.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
