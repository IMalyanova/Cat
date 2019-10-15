
public class Cat {
    private Double originWeight;
    private Double weight;

    private Double minWeight;
    private Double maxWeight;

    private double eatenAndDrunk;
    private  static  int count;

    public Cat() {
        this(1500.0 + 3000.0 * Math.random());
    }

    public Cat(double weight){
        this(weight, 100., 9000., weight, 0.);
    }

    private Cat(double weight, double minWeight, double maxWeight, double originWeight, double eatenAndDrunk) {
        this.weight = weight;
        this.originWeight = weight;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
        this.eatenAndDrunk = eatenAndDrunk;
        if (isAlive()) {
            count++;
        }
    }

    public Cat(Cat cat1){
        this(cat1.weight, cat1.minWeight, cat1.maxWeight, cat1.originWeight, cat1.eatenAndDrunk );
    }

    public void meow() {
        if (isAlive()){
            addWeight(-1.);
            System.out.println("Meow");
        }
    }

    public void feed(Double amount) {
        if(isAlive()){
            addEatenAndDrunk(amount);
            addWeight(amount);
        }
    }

    public void drink(Double amount) {
        feed(amount);
    }

    public Double getWeight() {
        return weight;
    }

    protected void setWeight(Double weight) {
        if(isAlive()){
            this.weight = weight;
            if (!isAlive()){
                count--;
            }
        }
    }

    protected void addWeight(Double weight) {
        if (isAlive()){
            setWeight(getWeight()+ weight);
        }
    }

    private boolean isAlive() {
        return (weight >= minWeight)&&(weight <= maxWeight);
    }

    public String getStatus() {
        if(weight < minWeight){
            return "Starved";
        }else if(weight > maxWeight){
            return "Exploded";
        }else if(weight > originWeight){
            return "Sleeping";
        }else{
            return "Playing";
        }
    }

    public double getEatenAndDrunk() {
        return eatenAndDrunk;
    }

    protected void setEatenAndDrunk(double eatenAndDrunk) {
        if (isAlive()) {
        this.eatenAndDrunk = eatenAndDrunk;
        }
    }

    protected void addEatenAndDrunk(double eatenAndDrunk) {
        if (isAlive()) {
            setEatenAndDrunk(getEatenAndDrunk() + eatenAndDrunk);
        }
    }

    public void useTheToilet(){
        if (isAlive()){
            double waste =(1.+ Math.random()*10.);
            addWeight(- waste);
            System.out.println("Cat went to the toilet! Weight = " + getWeight());
        }
    }

    public static int getCount() {
        return count;
    }

    public Cat twin(){
        return new Cat(this);
    }

    public static Cat twin(Cat cat1){
        return cat1.twin();
    }
}