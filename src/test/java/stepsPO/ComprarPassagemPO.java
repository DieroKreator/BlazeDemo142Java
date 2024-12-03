package stepsPO;

import org.junit.Assert;
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

    public ComprarPassagemPO(Base base) {
        this.driver = base.driver;
    }

    // As anotações Before e After ficam no Hooks.java
    @Dado("que acesso o site {string} PO")
    public void que_acesso_o_site_po(String url) {
        homePage = new HomePage(driver);
        homePage.acessarHomePage(url);

        Assert.assertEquals("BlazeDemo", homePage.lerNomeDaGuia());
    }

    @Quando("seleciono a {string} e {string} PO")
    public void seleciono_a_e_po(String origem, String destino) {
        this.origem = origem;
        this.destino = destino;
        homePage.selecionarOrigemDestino(origem, destino);

        // Ativar a sincronização para o robô executar devagar
        // E podermos visualizar o funcionamento
        // Importante: É só como curiosidade ou em caso de problemas
        // O indicado é deixar o robô executar o mais rápido possível

        synchronized (driver) {
            try {
                driver.wait(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @E("clico no botao Find Flights PO")
    public void clico_no_botao_find_flights_po() {
        homePage.clicarBotaoFindFlights();
        reservePage = new ReservePage(driver);
    }

    @Entao("visualiza a lista de voos PO")
    public void visualiza_a_lista_de_voos_po() {
        Assert.assertEquals("BlazeDemo - reserve", reservePage.lerNomeDaGuia());
        Assert.assertEquals("Flights from " + this.origem + " to " + this.destino + ":",
                reservePage.lerCabecalhoVoos());

        synchronized (driver) {
            try {
                driver.wait(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Quando("clico no {int} PO")
    public void clico_no_po(Integer ordem_do_voo) {
        reservePage.clicarNoVoo(ordem_do_voo);

        synchronized (driver) {
            try {
                driver.wait(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
