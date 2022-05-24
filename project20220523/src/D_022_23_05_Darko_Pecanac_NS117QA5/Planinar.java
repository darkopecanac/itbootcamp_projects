package D_022_23_05_Darko_Pecanac_NS117QA5;

public abstract class Planinar {

  // dp: Attributes
  private int id_planinara;
  private String imePlaninara;
  private String prezimePlaninara;

  // dp: Constructors
  public Planinar() {
  }

  public Planinar(int id_planinara, String imePlaninara, String prezimePlaninara) {
    this.id_planinara = id_planinara;
    this.imePlaninara = imePlaninara;
    this.prezimePlaninara = prezimePlaninara;
  }

  // dp: Getters
  public int getId_planinara() {
    return id_planinara;
  }

  public String getImePlaninara() {
    return imePlaninara;
  }

  public String getPrezimePlaninara() {
    return prezimePlaninara;
  }

  // dp: Methods
  public abstract String toString();
  public abstract int prikaziClanarinuPlaninara();
  public abstract boolean uspesanUsponPlaninara(Planina planina);
}