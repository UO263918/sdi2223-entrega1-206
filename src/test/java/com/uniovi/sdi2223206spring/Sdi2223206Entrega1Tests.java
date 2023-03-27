package com.uniovi.sdi2223206spring;

import com.uniovi.sdi2223206spring.pageobjects.*;
import com.uniovi.sdi2223206spring.util.SeleniumUtils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Sdi2223206Entrega1Tests {

    static String PathFirefox = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
    //static String Geckodriver = "C:\\Path\\geckodriver-v0.30.0-win64.exe";
    static String Geckodriver = "C:\\Users\\Rulo\\Documents\\Raul\\Universidad\\Segundo Cuatri\\SDI\\Practicas\\Parte 1\\sesion06\\PL-SDI-Sesión5-material\\geckodriver-v0.30.0-win64.exe";
    //static String PathFirefox = "/Applications/Firefox.app/Contents/MacOS/firefox-bin";
    //static String Geckodriver = "/Users/USUARIO/selenium/geckodriver-v0.30.0-macos";
    //Común a Windows y a MACOSX
    static WebDriver driver = getDriver(PathFirefox, Geckodriver);
    static String URL = "http://localhost:8090";
    public static WebDriver getDriver(String PathFirefox, String Geckodriver) {
        System.setProperty("webdriver.firefox.bin", PathFirefox);
        System.setProperty("webdriver.gecko.driver", Geckodriver);
        driver = new FirefoxDriver();
        return driver;
    }

    @Test
    void contextLoads() {
    }

    @BeforeEach
    public void setUp(){
        driver.navigate().to(URL);
    }

    //Después de cada prueba se borran las cookies del navegador
    @AfterEach
    public void tearDown(){
        driver.manage().deleteAllCookies();
    }

    //Antes de la primera prueba
    @BeforeAll
    static public void begin() {}

    //Al finalizar la última prueba
    @AfterAll
    static public void end() {
        //Cerramos el navegador al finalizar las pruebas
        driver.quit();
    }

    /*@Test
    @Order(1)
    void PR01A(){
        PO_HomeView.checkWelcomeToPage(driver, PO_Properties.getSPANISH());

    }

    @Test
    @Order(2)
    void PR01B(){
        List<WebElement> welcomeMessageElement = PO_HomeView.getWelcomeMessageText(driver,
                PO_Properties.getSPANISH());
        Assertions.assertEquals(welcomeMessageElement.get(0).getText(),
                PO_HomeView.getP().getString("welcome.message", PO_Properties.getSPANISH()));
    }

    //PR02. Opción de navegación. Pinchar en el enlace Registro en la página home
    @Test
    @Order(3)
    void PR02(){
        PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");
    }

    //PR03. Opción de navegación. Pinchar en el enlace Identifícate en la página home
    @Test
    @Order(4)
    public void PR03() {
        PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
    }

    //PR04. Opción de navegación. Cambio de idioma de Español a Inglés y vuelta a Español
    @Test
    @Order(5)
    public void PR04() {
        PO_HomeView.checkChangeLanguage(driver, "btnSpanish", "btnEnglish",
                PO_Properties.getSPANISH(), PO_Properties.getENGLISH());
    }*/

    //[Prueba1] Registro de Usuario con datos válidos.
    @Test
    @Order(1)
    public void Prueba01() {
        //Vamos al formulario de registro
        PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");
        //Rellenamos el formulario.
        PO_SignUpView.fillForm(driver, "prueba01@prueba01.com", "PRUEBA01", "PRUEBA01", "PRUEBA01", "PRUEBA01");
        //Comprobamos que entramos en la sección privada y nos nuestra el texto a buscar
        String checkText = "Esta es una zona privada la web";
        List<WebElement> result = PO_View.checkElementBy(driver, "text", checkText);
        Assertions.assertEquals(checkText, result.get(0).getText());
    }

    //[Prueba2] Registro de Usuario con datos inválidos (email vacío, nombre vacío, apellidos vacíos).
    //Propiedad: Error.signup.passwordConfirm.coincidence
    @Test
    @Order(2)
    public void Prueba02() {
        // email vacío
        PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");
        PO_SignUpView.fillForm(driver, "", "PRUEBA02", "PRUEBA02", "PRUEBA02", "PRUEBA02");

        PO_SignUpView.checkElementByKey(driver, "Error.empty", PO_Properties.getSPANISH());

        // nombre vacío
        PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");
        PO_SignUpView.fillForm(driver, "prueba02@prueba02.com", "", "PRUEBA02", "PRUEBA02", "PRUEBA02");

        PO_SignUpView.checkElementByKey(driver, "Error.empty", PO_Properties.getSPANISH());

        // apellido vacío
        PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");
        PO_SignUpView.fillForm(driver, "prueba02@prueba02.com", "PRUEBA02", "", "PRUEBA02", "PRUEBA02");

        PO_SignUpView.checkElementByKey(driver, "Error.empty", PO_Properties.getSPANISH());
    }

    //[Prueba3] Registro de Usuario con datos inválidos (repetición de contraseña inválida).
    //Propiedad: Error.signup.passwordConfirm.coincidence
    @Test
    @Order(3)
    public void Prueba03() {
        PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");
        PO_SignUpView.fillForm(driver, "prueba03@prueba03.com", "PRUEBA03", "PRUEBA03", "PRUEBA03", "PRUEBA03B");
        List<WebElement> result = PO_SignUpView.checkElementByKey(driver, "Error.signup.passwordConfirm.coincidence",
                PO_Properties.getSPANISH() );
        //Comprobamos el error de las contraseñas no coinciden.
        String checkText = PO_HomeView.getP().getString("Error.signup.passwordConfirm.coincidence",
                PO_Properties.getSPANISH());
        Assertions.assertEquals(checkText , result.get(0).getText());
    }

    //[Prueba4] Registro de Usuario con datos inválidos (email existente).
    //Propiedad: Error.signup.email.duplicate
    @Test
    @Order(4)
    public void Prueba04() {
        PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");
        PO_SignUpView.fillForm(driver, "prueba01@prueba01.com", "PRUEBA04", "PRUEBA04", "PRUEBA04", "PRUEBA04");
        List<WebElement> result = PO_SignUpView.checkElementByKey(driver, "Error.signup.email.duplicate",
                PO_Properties.getSPANISH() );
        //Comprobamos el error de email repetido.
        String checkText = PO_HomeView.getP().getString("Error.signup.email.duplicate",
                PO_Properties.getSPANISH());
        Assertions.assertEquals(checkText , result.get(0).getText());
    }

    //PR05: Inicio de sesión con datos válidos (administrador).
    @Test
    @Order(5)
    void Prueba05(){
        //Vamos al formulario de logueo.
        PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
        //Rellenamos el formulario
        PO_LoginView.fillLoginForm(driver, "admin@email.com", "admin");
        //Comprobamos que entramos en la página privada de ADMINISTRADOR
        String checkText = "Esta es una zona de administrador de la web";
        List<WebElement> result = PO_View.checkElementBy(driver, "text", checkText);
        Assertions.assertEquals(checkText, result.get(0).getText());
    }

    //PR06: Inicio de sesión con datos válidos (usuario estándar).
    @Test
    @Order(6)
    void Prueba06(){
        //Vamos al formulario de logueo.
        PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
        //Rellenamos el formulario
        PO_LoginView.fillLoginForm(driver, "user01@email.com", "user01");
        //Comprobamos que entramos en la pagina privada de CLIENTE
        String checkText = "Esta es una zona privada la web";
        List<WebElement> result = PO_View.checkElementBy(driver, "text", checkText);
        Assertions.assertEquals(checkText, result.get(0).getText());
    }

    //PR07: Inicio de sesión con datos inválidos (usuario estándar, campo email y contraseña vacíos).
    @Test
    @Order(7)
    void Prueba07(){
        //Vamos al formulario de logueo.
        PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
        //Rellenamos el formulario
        PO_LoginView.fillLoginForm(driver, "", "");
        //Comprobamos que nos devuelve a la vista de logueo
        String checkText = "Identifícate";
        List<WebElement> result = PO_View.checkElementBy(driver, "text", checkText);
        Assertions.assertEquals(checkText, result.get(0).getText());
    }

    //PR08: Inicio de sesión con datos válidos (usuario estándar, email existente, pero contraseña incorrecta).
    @Test
    @Order(8)
    void Prueba08(){
        //Vamos al formulario de logueo.
        PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
        //Rellenamos el formulario
        PO_LoginView.fillLoginForm(driver, "user01@email.com", "");
        //Comprobamos que nos devuelve a la vista de logueo
        String checkText = "Identifícate";
        List<WebElement> result = PO_View.checkElementBy(driver, "text", checkText);
        Assertions.assertEquals(checkText, result.get(0).getText());
    }

    //PR09: Hacer clic en la opción de salir de sesión y comprobar que se redirige a la página de inicio de sesión (Login).
    @Test
    @Order(9)
    void Prueba09(){
        //Vamos al formulario de logueo.
        PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
        //Rellenamos el formulario
        PO_LoginView.fillLoginForm(driver, "user01@email.com", "user01");
        //Comprobamos que entramos en la pagina privada de CLIENTE
        String checkText = "Esta es una zona privada la web";
        List<WebElement> result = PO_View.checkElementBy(driver, "text", checkText);
        Assertions.assertEquals(checkText, result.get(0).getText());
        //Vamos al boton de logout
        PO_HomeView.clickOption(driver, "logout", "class", "btn btn-primary");
        //Comprobamos que nos devuelve a la vista de logueo
        String checkText1 = "Identifícate";
        List<WebElement> result1 = PO_View.checkElementBy(driver, "text", checkText1);
        Assertions.assertEquals(checkText1, result1.get(0).getText());
    }

    //PR10: Comprobar que el botón cerrar sesión no está visible si el usuario no está autenticado.
    @Test
    @Order(10)
    void Prueba10(){
        //Comprobamos que el boton no está disponible de primeras
        driver.findElements(By.id("logout")).isEmpty();
        //Entramos a la página de Login para comprobar si el botón está o no visible al introducir un usuario no valido
        PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
        driver.findElements(By.id("logout")).isEmpty();
        PO_LoginView.fillLoginForm(driver, "user01@email.com", "user01");
        //Comprobamos que entramos en la pagina privada de CLIENTE
        String checkText = "Esta es una zona privada la web";
        List<WebElement> result = PO_View.checkElementBy(driver, "text", checkText);
        Assertions.assertEquals(checkText, result.get(0).getText());
        //Ahora nos deslogueamos ya que si debería de mostrarse el botón
        PO_HomeView.clickOption(driver, "logout", "class", "btn btn-primary");
        //Comprobamos que no se nos muestra el botón
        driver.findElements(By.id("logout")).isEmpty();
    }

    //PR11: Ir a la lista de usuarios, borrar el primer usuario de la lista, comprobar que la lista se actualiza y dicho usuario desaparece.
    @Test
    @Order(11)
    public void Prueba11() {
        PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
        PO_LoginView.fillLoginForm(driver, "admin@admin.es", "admin");
        PO_View.checkElementBy(driver, "id", "vistaAdminListUsers");
        List<WebElement> elementos=SeleniumUtils.waitLoadElementsBy(driver, "free", "//tbody/tr", PO_View.getTimeout());
        assertTrue(elementos.size()==15);
        PO_PrivateView.clickOption(driver, "logout", "text", "Password");
    }

    //PR12: Ir a la lista de usuarios, borrar el primer usuario de la lista, comprobar que la lista se actualiza y dicho usuario desaparece.
    @Test
    @Order(12)
    public void Prueba12() {
        PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
        PO_LoginView.fillLoginForm(driver, "admin@admin.es", "admin");
        PO_View.checkElementBy(driver, "id", "vistaAdminListUsers");
        int usuariosTotales = SeleniumUtils.getSize(driver,
                "checkbox[]");

        SeleniumUtils.textIsPresentOnPage(driver, "user01");
        List<Integer> usuariosEliminar = new ArrayList<>();
        usuariosEliminar.add(0);
        PO_AdminView.fillAdminForm(driver, usuariosEliminar);

        assertTrue(SeleniumUtils.getSize(driver,
                "checkbox[]") == usuariosTotales - 1);
        SeleniumUtils.textIsNotPresentOnPage(driver, "user01");
        PO_PrivateView.clickOption(driver, "logout", "text", "Password");

    }

    //PR13: Ir a la lista de usuarios, borrar el último usuario de la lista, comprobar que la lista se actualiza y dicho usuario desaparece.
    @Test
    @Order(13)
    public void Prueba13() {
        PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
        PO_LoginView.fillLoginForm(driver, "admin@admin.es", "admin");
        PO_View.checkElementBy(driver, "id", "vistaAdminListUsers");
        int usuariosTotales = SeleniumUtils.getSize(driver,
                "checkbox[]");

        SeleniumUtils.textIsPresentOnPage(driver, "user15");

        List<Integer> usuariosEliminar = new ArrayList<Integer>();
        usuariosEliminar.add(usuariosTotales - 1);
        PO_AdminView.fillAdminForm(driver, usuariosEliminar);
        PO_View.getP();

        assertTrue(SeleniumUtils.getSize(driver,
                "checkbox[]") == usuariosTotales - 1);
        SeleniumUtils.textIsNotPresentOnPage(driver, "user15");
        PO_PrivateView.clickOption(driver, "logout", "text", "Password");
    }

    //PR14: Ir a la lista de usuarios, borrar 3 usuarios, comprobar que la lista se actualiza y dichos usuarios desaparecen.
    @Test
    @Order(14)
    public void Prueba14() {
        PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
        PO_LoginView.fillLoginForm(driver, "admin@admin.es", "admin");
        PO_View.checkElementBy(driver, "id", "vistaAdminListUsers");
        int previousSize = SeleniumUtils.getSize(driver,
                "checkbox[]");

        SeleniumUtils.textIsPresentOnPage(driver, "user03");
        SeleniumUtils.textIsPresentOnPage(driver, "user04");
        SeleniumUtils.textIsPresentOnPage(driver, "user07");

        List<Integer> positionsToClick = new ArrayList<Integer>();
        positionsToClick.add(0);
        positionsToClick.add(1);
        positionsToClick.add(previousSize - 1);
        PO_AdminView.fillAdminForm(driver, positionsToClick);

        assertTrue(SeleniumUtils.getSize(driver,
                "checkbox[]") == previousSize - 3);
        SeleniumUtils.textIsNotPresentOnPage(driver, "user03");
        SeleniumUtils.textIsNotPresentOnPage(driver, "user04");
        SeleniumUtils.textIsNotPresentOnPage(driver, "user07");

        PO_PrivateView.clickOption(driver, "logout", "text", "Password");
    }

    /*//PR12. Loguearse, comprobar que se visualizan 4 filas de notas y desconectarse usando el rol de estudiante
    @Test
    @Order(18)
    public void PR12() {
        //Vamos al formulario de logueo.
        PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
        //Rellenamos el formulario
        PO_LoginView.fillLoginForm(driver, "99999990A", "123456");
        //COmprobamos que entramos en la pagina privada de Alumno
        String checkText = "Notas del usuario";
        List<WebElement> result = PO_View.checkElementBy(driver, "text", checkText);
        //Contamos el número de filas de notas
        List<WebElement> offerList = SeleniumUtils.waitLoadElementsBy(driver, "free", "//tbody/tr",
                PO_View.getTimeout());
        Assertions.assertEquals(4, offerList.size());
        //Ahora nos desconectamos y comprobamos que aparece el menú de registro
        String loginText = PO_HomeView.getP().getString("signup.message", PO_Properties.getSPANISH());
        PO_PrivateView.clickOption(driver, "logout", "text", loginText);
    }

    //PR13. Loguearse como estudiante y ver los detalles de la nota con Descripcion = Nota A2.
    @Test
    @Order(19)
    public void PR13() {
        //Comprobamos que entramos en la pagina privada de Alumno
        PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
        PO_LoginView.fillLoginForm(driver, "99999990A", "123456");
        String checkText = "Notas del usuario";
        List<WebElement> result = PO_View.checkElementBy(driver, "text", checkText);
        //SeleniumUtils.esperarSegundos(driver, 1);
        //Contamos las notas
        By enlace = By.xpath("//td[contains(text(), 'Nota A2')]/following-sibling::*[2]");
        driver.findElement(enlace).click();
        //Esperamos por la ventana de detalle
        checkText = "Detalles de la nota";
        result = PO_View.checkElementBy(driver, "text", checkText);
        Assertions.assertEquals(checkText, result.get(0).getText());
        //Ahora nos desconectamos comprobamas que aparece el menu de registrarse
        String loginText = PO_HomeView.getP().getString("signup.message", PO_Properties.getSPANISH());
        PO_PrivateView.clickOption(driver, "logout", "text", loginText);
    }

    //P14. Loguearse como profesor y Agregar Nota A2.
    //P14. Esta prueba podría encapsularse mejor ...
    @Test
    @Order(20)
    public void PR14() {
        //Vamos al formulario de login.
        PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
        PO_LoginView.fillLoginForm(driver, "99999993D", "123456");
        //Cmmprobamos que entramos en la pagina privada del Profesor
        PO_View.checkElementBy(driver, "text", "99999993D");
        //Pinchamos en la opción de menú de Notas: //li[contains(@id, 'offers-menu')]/a
        List<WebElement> elements = PO_View.checkElementBy(driver, "free", "//li[contains(@id, 'offers-menu')]/ a");
                elements.get(0).click();
        //Esperamos a que aparezca la opción de añadir nota: //a[contains(@href, 'offer/add')]
        elements = PO_View.checkElementBy(driver, "free", "//a[contains(@href, 'offer/add')]");
        //Pinchamos en agregar Nota.
        elements.get(0).click();
        //Ahora vamos a rellenar la nota. //option[contains(@value, '4')]
        String checkText = "Nota Nueva 1";
        PO_PrivateView.fillFormAddoffer(driver, 3, checkText, "8");
        //Esperamos a que se muestren los enlaces de paginación de la lista de notas
        elements = PO_View.checkElementBy(driver, "free", "//a[contains(@class, 'page-link')]");
        //Nos vamos a la última página
        elements.get(3).click();
        //Comprobamos que aparece la nota en la página
        elements = PO_View.checkElementBy(driver, "text", checkText);
        Assertions.assertEquals(checkText, elements.get(0).getText());
        //Ahora nos desconectamos y comprobamos que aparece el menú de registrarse
        String loginText = PO_HomeView.getP().getString("signup.message", PO_Properties.getSPANISH());
        PO_PrivateView.clickOption(driver, "logout", "text", loginText);
    }

    //PR15: Eliminar una nota
    @Test
    @Order(21)
    public void PR15() {
        //Vamos al formulario de login.
        PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
        PO_LoginView.fillLoginForm(driver, "99999993D", "123456");
        //Comprobamos que entramos en la página privada del Profesor
        PO_View.checkElementBy(driver, "text", "99999993D");
        //Pinchamos en la opción de menú de Notas: //li[contains(@id, 'offers-menu')]/a
        List<WebElement> elements = PO_View.checkElementBy(driver, "free", "//li[contains(@id, 'offers-menu')]/ a");
                elements.get(0).click();
        //Pinchamos en la opción de lista de notas.
        elements = PO_View.checkElementBy(driver, "free", "//a[contains(@href, 'offer/list')]");
        elements.get(0).click();
        //Esperamos a que se muestren los enlaces de paginación la lista de notas
        elements = PO_View.checkElementBy(driver, "free", "//a[contains(@class, 'page-link')]");
        //Nos vamos a la última página
        elements.get(3).click();
        //Esperamos a que aparezca la Nueva nota en la última página
        //Y Pinchamos en el enlace de borrado de la Nota "Nota Nueva 1"
        elements = PO_View.checkElementBy(driver, "free", "//td[contains(text(), 'Nota Nueva 1')]/following-sibling::*/

    //DEscdomentar y subirlo pa arriba cuando eso
   /* a[contains(@href, 'offer/delete')]");

        elements.get(0).click();
        //Volvemos a la última página
        elements = PO_View.checkElementBy(driver, "free", "//a[contains(@class, 'page-link')]");
        elements.get(3).click();
        //Y esperamos a que NO aparezca la última "Nueva Nota 1"
        SeleniumUtils.waitTextIsNotPresentOnPage(driver, "Nota Nueva 1",PO_View.getTimeout());
        //Ahora nos desconectamos comprobamos que aparece el menú de registrarse
        String loginText = PO_HomeView.getP().getString("signup.message", PO_Properties.getSPANISH());
        PO_PrivateView.clickOption(driver, "logout", "text", loginText);
    }
    */
}
