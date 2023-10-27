public class IsDigitsOnly {

  public static void main(String[] args) {
    String str = "1234567890";
    boolean isDigitsOnly = true;
    for (char c : str.toCharArray()) {
      if (!Character.isDigit(c)) {
        isDigitsOnly = false;
        break;
      }
    }
    System.out.println(isDigitsOnly);
  }
}
