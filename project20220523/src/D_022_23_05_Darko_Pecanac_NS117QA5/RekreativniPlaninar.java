/* RAD NA CASU, 23. 05. 2022. i DOMACI ZADATAK 1.
 *
 * Kreirati klasu RekreativniPlaninar, koja pored svega sto ima Planinar ima i:
 *    - masu opreme (kg) koju nosi (celobrojna je vrednost, npr. 20 kg),
 *    - naziv okruga odakle je rekreativni planinar i
 *    - maksimalni uspon koji planinar moze da savlada bez opreme (npr. 2000 m).
 * Da li će se rekreativni planinar uspešno popeti na planinu zavisi
 *    - da li je njegov najveći uspon manji od visine planine, s tim da oprema dodatno otežava penjanje i
 *      za svaki kilogram opreme koji nosi može da pređe 50 metara manje.
 * Rekeativci placaju clanarinu u iznosu od 1000 rsd.
 * Metoda koja ispisuje podatke o planinaru ispisuje ih u sledecem formatu:
 *    Rekreativac, id: id
 *    Ime: ime prezime Okrug: okrug
 */

package D_022_23_05_Darko_Pecanac_NS117QA5;

public class RekreativniPlaninar extends Planinar {

  // dp: Attributes
  private int tezinaOpremeRekreativnogPlaninara;
  private String okrugRekreativnogPlaninara;
  private int maxUsponRekreativnogPlaninaraBezOpreme = 2000;
  private int visinaClanarineRekreativnogPlaninara = 1000;

  // dp: Constructors
  public RekreativniPlaninar() {
    super();
  }

  public RekreativniPlaninar(
          int id_planinara,
          String imePlaninara,
          String prezimePlaninara,
          int tezinaOpreme,
          String okrugPlaninara,
          int maxUsponPlaninara) {
    super(id_planinara, imePlaninara, prezimePlaninara);
    this.tezinaOpremeRekreativnogPlaninara = tezinaOpreme;
    this.okrugRekreativnogPlaninara = okrugPlaninara;
    this.maxUsponRekreativnogPlaninaraBezOpreme = maxUsponPlaninara;
  }

  // dp: Getters and Setters
  public int getTezinaOpremeRekreativnogPlaninara() {
    return tezinaOpremeRekreativnogPlaninara;
  }
  public void setTezinaOpremeRekreativnogPlaninara(int tezinaOpremeRekreativnogPlaninara) {
    this.tezinaOpremeRekreativnogPlaninara = tezinaOpremeRekreativnogPlaninara;
  }

  public String getOkrugRekreativnogPlaninara() {
    return okrugRekreativnogPlaninara;
  }
  public void setOkrugRekreativnogPlaninara(String okrugRekreativnogPlaninara) {
    this.okrugRekreativnogPlaninara = okrugRekreativnogPlaninara;
  }

  public int getMaxUsponRekreativnogPlaninaraBezOpreme() {
    return maxUsponRekreativnogPlaninaraBezOpreme;
  }

  public void setMaxUsponRekreativnogPlaninaraBezOpreme(int maxUsponRekreativnogPlaninaraBezOpreme) {
    this.maxUsponRekreativnogPlaninaraBezOpreme = maxUsponRekreativnogPlaninaraBezOpreme;
  }
  public int getVisinaClanarineRekreativnogPlaninara() {
    return visinaClanarineRekreativnogPlaninara;
  }

  // dp: Methods
  @Override
  public void stampaj() {
    System.out.println(
            "\nRerekativac, id : " + super.getId_planinara() +
            "\nIme: " + super.getImePlaninara() + " " + super.getPrezimePlaninara() +
            " Okrug: " + this.getOkrugRekreativnogPlaninara()
    );
  }

  @Override
  public int prikaziClanarinuPlaninara() {
    return this.getVisinaClanarineRekreativnogPlaninara();
  }

  @Override
  public boolean uspesanUsponPlaninara(Planina planina) {
    int umanjenaVisinaMaxUsponaRekreatinvogPlaninara =
            this.getMaxUsponRekreativnogPlaninaraBezOpreme() -
            this.getTezinaOpremeRekreativnogPlaninara() * 50;

    if ( planina.getVisinaPlanine() <= umanjenaVisinaMaxUsponaRekreatinvogPlaninara )
      return true;
    return false;
  }
}