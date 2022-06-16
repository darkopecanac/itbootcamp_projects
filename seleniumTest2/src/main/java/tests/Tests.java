/*
 * Kreirati projekat SeleniumTest i u njemu 2 paketa:
 * ·    pages
 * ·    tests
 *
 * Testirati rad sistema https://computer-database.gatling.io/computers.
 *
 * U paketu tests dodati klase BaseTests i Tests.
 *
 * Klasa BaseTests treba da odvoji svu zajedničku logiku testova.
 *
 * Napraviti sledeće testove:
 * -  Testiranje pretrage računara koji u imenu sadrže reč asci. Proveriti da li u poruci iznad piše da ih je 6 i da li ima 6 redova u tabeli.
 * -  Kreirati novi računar (uneti samo ime) i proveriti da li je validaciona poruka o uspešnom kreiranju tu ukljucujući i ime koje ste uneli.
 *
 * U paketu pages dodati sve potrebne stranice.Kad zavrsite projekat prevucite u vaš folder na drive-u.
 * */

package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests extends BaseTests {

  @Test (priority = 1)
  public void verifyComputerSearch() {
    getHomePage().openHomePage();
    getHomePage().searchByString("asci");
    Assert.assertTrue(getHomePage().searchResult());
    Assert.assertTrue(getHomePage().sixRowsPresent());
  }

  @Test (priority = 2)
  public void verifyAddingNewComputer() {
    getHomePage().openHomePage();
    getHomePage().addNewComputer();
    getNewComputerPage().addNewComputer("Dare");
    Assert.assertTrue(getNewComputerPage().validateCreationMessage("Dare"));
  }
}