public class Toys {
    private int id; // айди игрушки
    private String name; // имя
    private int weight; // приоритет

    public Toys(int id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    // переопределение toString() чтоб удобно вывести инфу по игрушке
    @Override
    public String toString() {
        return "Toy{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}