package Practice;

class IPTV {

  private int ip;

  public IPTV(int ip) {
    this.ip = ip;
  }

  protected int getIp() {
    return ip;
  }
}

class TV extends IPTV {

  private int size;
  private int color;

  public TV(int ip, int size, int color) {
    super(ip);
    this.size = size;
    this.color = color;
  }

  public void printProperty() {
    System.err.println(
      getIp() + " IP 주소이고 " + size + "이고 " + color + "이다."
    );
  }
}

public class Practice02 {
    public static void main(String[] args) {
    }
}
