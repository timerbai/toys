

import java.util.PriorityQueue;
import java.util.Comparator;
import java.io.FileWriter;
import java.io.IOException;

public class Store {
    private PriorityQueue<Toys> toys;

    public Store() {
         // инициализация кдасса PriorityQueue чтобы сортирвать по весу
         this.toys = new PriorityQueue<>(Comparator.comparingInt(Toys::getWeight).reversed());
        }
    
        public void addToy(Toys toy) {
            toys.add(toy);
        }
        // метод чтобы извекать игрушки по очереди
    public Toys getToy() {
        return toys.poll(); // возвращаем и удаляем элемент с высшим приоритетом
    }

    public static void main(String[] args) {
        Store store = new Store();

        // добавляем игрушки в магаз
        // делаем 3 массива
        Toys[] arr1 = new Toys[]{
                new Toys(1, "Anna", 5),
                new Toys(2, "Oleg", 3),
                new Toys(3, "Igor", 10),
                new Toys(4, "John", 6)
        };
        Toys[] arr2 = new Toys[]{
                new Toys(5, "Frang", 4),
                new Toys(6, "Putin", 8),
                new Toys(7, "Abram", 12),
                new Toys(8, "tatrin", 11)
        };
        Toys[] arr3 = new Toys[]{
                new Toys(9, "Bear", 2),
                new Toys(10, "Baby", 1)
        };
        for (int i = 0; i < arr1.length; i++) {
            store.addToy(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            store.addToy(arr2[i]);
        }
        for (int i = 0; i < arr3.length; i++) {
            store.addToy(arr3[i]);
        }
         // фиксируем результаты
         try (FileWriter writer = new FileWriter("toys_output.txt")) {
            for (int i = 0; i < 10; i++) {
                Toys toy = store.getToy();
                if (toy != null) {
                    writer.write(toy.toString() + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}