package stackjava.com.reflection;
class Person {
  protected String address;

  public Person(){
    this.address = null;
  }
  public Person(String address) {
    this.address = address;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return "Person [address=" + address + "]";
  }
  
  
}
