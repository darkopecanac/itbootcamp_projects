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
  private int masaOpremeRekreativnogPlaninara;
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
          int masaOpreme,
          String okrugPlaninara,
          int maxUsponPlaninara) {
    super(id_planinara, imePlaninara, prezimePlaninara);
    setMasaOpremeRekreativnogPlaninara(masaOpreme);
    this.okrugRekreativnogPlaninara = okrugPlaninara;
    setMaxUsponRekreativnogPlaninaraBezOpreme(maxUsponPlaninara);
  }

  // dp: Getters and Setters
  public int getMasaOpremeRekreativnogPlaninara() {
    return masaOpremeRekreativnogPlaninara;
  }
  public void setMasaOpremeRekreativnogPlaninara(int masaOpreme) {
    if ( masaOpreme >= 0 )
      this.masaOpremeRekreativnogPlaninara = masaOpreme;
    else
      System.out.println("Uneli ste pogresnu vrednost za masu opreme rekreativnog planinara!");
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
    if ( maxUsponRekreativnogPlaninaraBezOpreme > 0 )
      this.maxUsponRekreativnogPlaninaraBezOpreme = maxUsponRekreativnogPlaninaraBezOpreme;
    else
      System.out.println("Uneli ste pogresnu vrednost za maksimalan uspon rekreativnog planinara!");
  }
  public int getVisinaClanarineRekreativnogPlaninara() {
    return visinaClanarineRekreativnogPlaninara;
  }

  // dp: Methods
  @Override
  public void stampaj() {
    System.out.println(
            "\nRerekativac, id : " + super.getIdPlaninara() +
            "\nIme: " + super.getImePlaninara() + " " + super.getPrezimePlaninara() +
            " Okrug: " + this.getOkrugRekreativnogPlaninara()
    );
  }

  @Override
  public int prikaziClanarinuPlaninara() {
    return this.getVisinaClanarineRekreativnogPlaninara();
  }

/* Da li će se rekreativni planinar uspešno popeti na planinu zavisi
 *    - da li je njegov najveći uspon manji od visine planine, s tim da oprema dodatno otežava penjanje i
 *      za svaki kilogram opreme koji nosi može da pređe 50 metara manje.
 */
  @Override
  public boolean uspesanUsponPlaninara(Planina planina) {
    int umanjenaVisinaMaxUsponaRekreatinvogPlaninara =
            this.getMaxUsponRekreativnogPlaninaraBezOpreme() -
            this.getMasaOpremeRekreativnogPlaninara() * 50;

    if ( planina.getVisinaPlanine() <= umanjenaVisinaMaxUsponaRekreatinvogPlaninara )
      return true;
    return false;
  }
}