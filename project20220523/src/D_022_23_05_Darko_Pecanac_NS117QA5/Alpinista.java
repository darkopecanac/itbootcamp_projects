package D_022_23_05_Darko_Pecanac_NS117QA5;

public class Alpinista extends Planinar {

  // dp: Attributes
  private int brojPoenaApliniste;
  private int maxUsponAlpiniste = 4000;
  private int visinaClanarineAlpiniste = 1500;

  // dp: Constructors
  public Alpinista(){
    super();
  }

  public Alpinista(int id_planinara, String imePlaninara, String prezimePlaninara, int brojPoenaApliniste, int maxUsponAlpiniste, int visinaClanarineAlpiniste) {
    super(id_planinara, imePlaninara, prezimePlaninara);
    this.brojPoenaApliniste = brojPoenaApliniste;
    this.maxUsponAlpiniste = maxUsponAlpiniste;
    this.visinaClanarineAlpiniste = visinaClanarineAlpiniste;
  }

  // dp: Getters and Setters

  public int getBrojPoenaApliniste() {
    return brojPoenaApliniste;
  }
  public void setBrojPoenaApliniste(int brojPoenaApliniste) {
    this.brojPoenaApliniste = brojPoenaApliniste;
  }

  public int getMaxUsponAlpiniste() {
    return maxUsponAlpiniste;
  }
  public void setMaxUsponAlpiniste(int maxUsponAlpiniste) {
    this.maxUsponAlpiniste = maxUsponAlpiniste;
  }

  public int getVisinaClanarineAlpiniste() {
    return visinaClanarineAlpiniste;
  }
  public void setVisinaClanarineAlpiniste(int visinaClanarineAlpiniste) {
    this.visinaClanarineAlpiniste = visinaClanarineAlpiniste;
  }

  // dp: Methods
  @Override
  public String toString() {
    return
            "\nAlpinista, id : " + super.getId_planinara() +
            "\nIme: " + super.getImePlaninara() + " " + super.getPrezimePlaninara() +
            " Broj poena: " + this.getBrojPoenaApliniste();
  }

  // Placa clanarinu u iznosu od 1500, pri tom za svaki poen ima popust od 50,
  @Override
  public int prikaziClanarinuPlaninara() {
    return getVisinaClanarineAlpiniste() - getBrojPoenaApliniste() * 50;
  }

  @Override
  public boolean uspesanUsponPlaninara(Planina planina) {
    if ( planina.getVisinaPlanine() <= this.getMaxUsponAlpiniste() )
      return true;
    return false;
  }
}