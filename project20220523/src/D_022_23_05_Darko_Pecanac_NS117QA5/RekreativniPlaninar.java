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
  public String toString() {
    return
            "\nRerekativac, id : " + super.getId_planinara() +
            "\nIme: " + super.getImePlaninara() + " " + super.getPrezimePlaninara() +
            " Okrug: " + this.getOkrugRekreativnogPlaninara();
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