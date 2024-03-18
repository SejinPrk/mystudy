package bitcamp.app1;

public class Car {
  String model;
  String maker;
  int capacity;
  boolean auto;

  @Override
  public String toString() {
    return "Car{" +
        "model='" + model + '\'' +
        ", maker='" + maker + '\'' +
        ", capacity=" + capacity +
        ", auto=" + auto +
        '}';
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getMaker() {
    return maker;
  }

  public void setMaker(String maker) {
    this.maker = maker;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public boolean isAuto() {
    return auto;
  }

  public void setAuto(boolean auto) {
    this.auto = auto;
  }
}
