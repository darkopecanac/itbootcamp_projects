/* RAD NA CASU, 23. 05. 2022. i DOMACI ZADATAK 1.
 *
 * Kreirati klasu Alpinista koji dodatno pamti
 *    - koliko poena je alpinista ostvario, celobrojna vrednost, a oni se mogu menjati kroz adekvatnu metodu.
 *    - Alpinista moze da savlada sve uspone do 4000 metara.
 * Placa clanarinu u iznosu od 1500, pri tom za svaki poen ima popust od 50,
 * a informacije o alpinisti se ispisuju u formatu:
 *    Alpinista, id: id
 *    Ime: ime prezime
 *    Broj poena: poeni
 */

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

  public Alpinista(int id_planinara,
                   String imePlaninara,
                   String prezimePlaninara,
                   int brojPoenaApliniste,
                   int maxUsponAlpiniste,
                   int visinaClanarineAlpiniste) {
    super(id_planinara, imePlaninara, prezimePlaninara);
    this.brojPoenaApliniste = brojPoenaApliniste;
    setMaxUsponAlpiniste(maxUsponAlpiniste);
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
    if ( maxUsponAlpiniste > 0 )
      this.maxUsponAlpiniste = maxUsponAlpiniste;
    else
      System.out.println("Uneli ste pogresnu vrednost za maksimalan uspon alpiniste!");
  }

  public int getVisinaClanarineAlpiniste() {
    return visinaClanarineAlpiniste;
  }

  // dp: Methods
  @Override
  public void stampaj() {
    System.out.println(
            "\nAlpinista, id : " + super.getIdPlaninara() +
            "\nIme: " + super.getImePlaninara() + " " + super.getPrezimePlaninara() +
            " Broj poena: " + this.getBrojPoenaApliniste()
    );
  }

// Placa clanarinu u iznosu od 1500, pri tom za svaki poen ima popust od 50.
  @Override
  public int prikaziClanarinuPlaninara() {
    int visinaClanarineZaPlacanje = getVisinaClanarineAlpiniste() - getBrojPoenaApliniste() * 50;

    if ( visinaClanarineZaPlacanje > 0 )
      return visinaClanarineZaPlacanje;
    return 0;
  }

  @Override
  public boolean uspesanUsponPlaninara(Planina planina) {
    if ( planina.getVisinaPlanine() <= this.getMaxUsponAlpiniste() )
      return true;
    return false;
  }
}