package stepsPO;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pages.Base;
import pages.HomePage;
import pages.ReservePage;

public class ComprarPassagemPO {

    final WebDriver driver;
    private HomePage homePage;
    private ReservePage reservePage;

    public String origem;
    public String destino;

    public ComprarPassagemPO(Base base){
        this.driver = base.driver;
    }

    // As anotações Before e After ficam no Hooks.java
    @Dado("que acesso o site {string} PO")
    public void que_acesso_o_site_po(String url) {
        homePage = new HomePage(driver);
        homePage.acessarHomePage(url);

        assertEquals("BlazeDemo", homePage.lerNomeDaGuia());
    }

    @Quando("seleciono a {string} e {string} PO")
    public void seleciono_a_e_po(String origem, String destino) {
        this.origem = origem;
        homePage.selecionarOrigemDestino(origem, destino);
    }

    @E("clico no botao Find Flights PO")
    public void clico_no_botao_find_flights_po() {
        homePage.clicarBotaoFindFlights();
        reservePage = new ReservePage(driver);
    }

    @Entao("visualiza a lista de voos PO")
    public void visualiza_a_lista_de_voos_po() {
        assertEquals("BlazeDemo - reserve", reservePage.lerNomeDaGuia());
        assertEquals("Flights from " + this.origem + " to " + this.destino + ":", 
            reservePage.lerCabecalhoVoos());
    }

    @Quando("clico no {int} PO")
    public void clico_no_po(Integer int1) {
    }

}
