/* RAD NA CASU, 23. 05. 2022. i DOMACI ZADATAK 1.
 *
 * Kreirati klasu Planinar kog opisuju
 *    - jedinstveni celobrojni identifikacioni broj,
 *    - ime i
 *    - prezime.
 * Svi podaci smeju da se dohvate, ali ne i postave mimo konstruktora koji postavlja sve attribute klase.
 * Pored toga, klasa ima:
 *    - apstraktnu metodu stampaj,
 *    - apstraktnu metodu koja vraca clanarinu planinara i
 *    - apstraktnu metodu uspesanUspon koja vraća informaciju da li ce se planinar uspesno popeti na planinu.
 *      Metoda kao ulazni parametar prima objekat tipa Planina.
 */

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
  public abstract void stampaj();
  public abstract int prikaziClanarinuPlaninara();
  public abstract boolean uspesanUsponPlaninara(Planina planina);
}