/* RAD NA CASU, 23. 05. 2022. i DOMACI ZADATAK 1.
 *
 * Kreirati klasu Planina koju opisuju
 *    - ime planine,
 *    - naziv države u kojoj se nalazi i
 *    - visina planine.
 * Klasa mora imati konstruktore i getere i setere.
 *
 * Kreirati klasu Planinar kog opisuju
 *    - jedinstveni celobrojni identifikacioni broj,
 *    - ime i
 *    - prezime.
 * Svi podaci smeju da se dohvate, ali ne i postave mimo konstruktora koji postavlja sve attribute klase.
 * Pored toga, klasa ima:
 *    - apstraktnu metodu štampaj
 *    - apstraktnu metodu koja vraca clanarinu planinara
 *    - apstraktnu metodu uspesanUspon koja vraća informaciju da li će se planinar upešno popeti na planinu.
 *        Metoda kao ulazni parametar prima objekat tipa Planina.
 *
 * Kreirati klasu RekreativniPlaninar koja pored svega što ima Planinar ima i:
 *    - težinu opreme (kg) koju nosi (celobrojna je vrednost npr: 20kg),
 *    - naziv okruga odakle je rekreativni planinar
 *    - maksimalni uspon koji planinar može da savlada bez opreme (npr: 2000m)
 * Da li će se rekreativni planinar uspešno popeti na planinu zavisi
 *    - da li je njegov najveći uspon manji od visine planine, s tim da oprema dodatno otežava penjanje i
 *        za svaki kilogram opreme koji nosi može da pređe 50 metara manje.
 * Rekeativci placaju clanarinu u iznosu od 1000 rsd
 * Metoda koja ispisuje podatke o planinaru ispisuje ih u sledećem formatu:
 *    Rekreativac, id: id
 *    Ime: ime prezime Okrug: okrug
 *
 * Kreirati klasu Alpinista koji dodatno pamti
 *    - koliko poena je alpinista ostvario (celobrojna vrednost) i poeni se mogu menjati kroz adekvatnu metodu.
 *    - Alpinista može da savlada sve uspone do 4000 metara,
 * Placa clanarinu u iznosu od 1500, pri tom za svaki poen ima popust od 50,
 * a informacije o alpinisti se ispisuju u formatu:
 *    Alpinista, id: id
 *    Ime: ime i prezime
 *    Broj poena: poeni
 *
 * Kreirati glavnu klasu I u njoj:
 *    - instancirati jednu planinu
 *    - napraviti niz ili listu koji ce sadrzati najmanje tri rekrativna planinara i tri alpiniste
 *    - ispisati podatke o svim planinarima i za svakog od planinara ispisati da li ce se popeti na instanciranu planinu
 *    - ispisati koliki je zbir svih clanarina planinara iz niza/liste
*/
// dp: Attributes
// dp: Constructors
// dp: Getters and Setters
// dp: Methods

package D_022_23_05_Darko_Pecanac_NS117QA5;

import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {

    Planina triglav = new Planina("Triglav", "Slovenija", 2864);

    ArrayList<Planinar> planinari = new ArrayList<>();

    RekreativniPlaninar misoKnezevic = new RekreativniPlaninar(
            1234,
            "Miso",
            "Knezivic",
            25,
            "Vojvodina",
            3000);
    RekreativniPlaninar sasaKnezevic = new RekreativniPlaninar(
            4321,
            "Sasa",
            "Knezivic",
            20,
            "Vojvodina",
            3200);
    RekreativniPlaninar milosKondic = new RekreativniPlaninar(
            4444,
            "Milos",
            "Kondic",
            20,
            "Vojvodina",
            2600);

    Alpinista darkoPecanac = new Alpinista(
            8888,
            "Darko",
            "Pecanac",
            88,
            3000, 1500);

    planinari.add(misoKnezevic);
    planinari.add(sasaKnezevic);
    planinari.add(milosKondic);
    planinari.add(darkoPecanac);
  }
}
