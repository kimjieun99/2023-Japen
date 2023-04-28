package Practice;

class Location {

  private String name;
  private double longitude;
  private double latitude;

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getLongitude() {
    return this.longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  public double getLatitude() {
    return this.latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }
}

class LocationManager {}

public class Practice06 {

  public static void main(String[] args) {
    System.out.println("도시, 경도, 위도를 입력하세요.");
    LocationManager lm = new LocationManager();
    lm.insertLocation();
    lm.showAll();
    lm.showInfo();
  }
}
