package Homework.modelelements;

public class Texture {
    static int counter = 0;
    private int id;
    private String name;

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    {
        id = ++counter;
    }

    public Texture(String name)
    {
        this.name = name;
    }
}
