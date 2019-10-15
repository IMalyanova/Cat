
public class Loader {
    public static void main(String[] args) {
        Cat cat = new Cat();
        System.out.println(Cat.getCount());
        System.out.println(cat.getStatus());
        System.out.println(Cat.getCount());
        Cat murzik = new Cat();
        System.out.println(Cat.getCount());
        Cat vaska = Cat.twin(murzik);
        System.out.println(Cat.getCount());
        murzik.drink(50.);
        System.out.println("Status Murzik: " + murzik.getStatus());
        System.out.println("Weight Murzik: " + murzik.getWeight());
        murzik.feed(5.);
        murzik.useTheToilet();
        System.out.println(Cat.getCount());
        System.out.println("Status Vaska: " + vaska.getStatus());
        System.out.println("Weight Vaska: " + vaska.getWeight());
        vaska.feed(5.);
        vaska.useTheToilet();
        System.out.println("Status Murzik: " + murzik.getStatus());
        System.out.println("Weight Murzik: " + murzik.getWeight());
        System.out.println("Status Vaska: " + vaska.getStatus());
        System.out.println("Weight Vaska: " + vaska.getWeight());
        System.out.println(Cat.getCount());
    }

    public static Cat getKitten(){
        double weight = 100 + 100 * Math.random();
        return new Cat(weight);
    }
}