public class Driver {
  public static void main(String[] args) {
    NDArray<Integer> a = new NDArray<Integer>(2, 1, 1, 1, 1);
    System.out.println("dims: " + a.dims());
    a.set(1, 1, 0, 0, 0, 0);
    a.set(9, 0, 0, 0, 0, 0);
    System.out.println(a.get(0, 0, 0, 0, 0));
    System.out.println(a.size());
    System.out.println(a);
  }
}
