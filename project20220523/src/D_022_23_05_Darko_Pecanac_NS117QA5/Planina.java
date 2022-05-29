/* RAD NA CASU, 23. 05. 2022. i DOMACI ZADATAK 1.
 *
 * Kreirati klasu Planina koju opisuju
 *    - ime planine,
 *    - naziv drzave u kojoj se nalazi i
 *    - visina planine.
 * Klasa mora imati konstruktore, getere i setere.
 */

package D_022_23_05_Darko_Pecanac_NS117QA5;

public class Planina {

  // dp: Attributes
  private String imePlanine;
  private String drzavaPlanine;
  private int visinaPlanine;

  // dp: Constructors
  public Planina() {
  }

  public Planina(String imePlanine, String drzavaPlanine, int visinaPlanine) {
    this.imePlanine = imePlanine;
    this.drzavaPlanine = drzavaPlanine;
    setVisinaPlanine(visinaPlanine);
  }

  // dp: Getters and Setters
  public String getImePlanine() {
    return imePlanine;
  }
  public void setImePlanine(String imePlanine) {
    this.imePlanine = imePlanine;
  }

  public String getDrzavaPlanine() {
    return drzavaPlanine;
  }
  public void setDrzavaPlanine(String drzavaPlanine) {
    this.drzavaPlanine = drzavaPlanine;
  }

  public int getVisinaPlanine() {
    return visinaPlanine;
  }
  public void setVisinaPlanine(int visinaPlanine) {
    if ( visinaPlanine > 0 )
      this.visinaPlanine = visinaPlanine;
    else
      System.out.println("Uneli ste pogresnu vrednost za visinu planine!");
  }
}