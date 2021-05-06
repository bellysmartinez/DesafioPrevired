package tests;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.NoInjection;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import helpers.Helper;
import io.github.bonigarcia.wdm.WebDriverManager;

import pages.loginPage;


public class loginTest {
	private WebDriver driver;
	private ExtentReports extent;
	private ExtentTest test;
	private static String SUBDIR = "EvidenciaPruebaNuevo\\";// directorio de almacenamiento de evidencia
	private static Boolean TAKE_SS = true;//Captura de imagenes
	private static int WAITING = 20;
	 
	@BeforeSuite
	public void configExtentReports() {
		// ExtentReports config
		this.extent = new ExtentReports("ExtentReports/PruebaNuevo.html", true);// hace referencia al reporte html

		this.extent.addSystemInfo("Host Name", "Nuevo");
		this.extent.addSystemInfo("Enviroment", "Automation Testing");
		this.extent.addSystemInfo("User Name", "Bellys Martinez");

		File conf = new File("src/test/resources/extentReports/" + "extent-config.xml");
		this.extent.loadConfig(conf);
	}



		
	@Test 
	@Parameters({ "URL_PRINCIPAL" })
	public void agregarblusa(String URL_PRINCIPAL) throws Exception {
		// Selenium config
				DesiredCapabilities caps = new DesiredCapabilities();
				caps.setCapability("Empresa", "Nuevo");
				WebDriverManager.chromedriver().setup();
				Helper.robotMoveMouse(2000, 2000);
				driver = new ChromeDriver();
				//driver.manage().timeouts().implicitlyWait(WAITING, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				driver.navigate().to(URL_PRINCIPAL);
				
		String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();

		test = extent.startTest("Agregar blusa", "Pagina Web de Nuevo");
		test.log(LogStatus.INFO, "Agregar blusa");

		loginPage Pagina = new loginPage(driver, test, TAKE_SS, WAITING);
		
		Pagina.agregarblusa(subDir, "blouse", "3");
	}
	
	@Test 
	public void agregarvestido() throws Exception {
		
		String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();

		test = extent.startTest("Agregar vestido", "Pagina Web de Nuevo");
		test.log(LogStatus.INFO, "Agregar vestido");

		loginPage Pagina = new loginPage(driver, test, TAKE_SS, WAITING);
		
		Pagina.agregarvestido(subDir, "Summer Dress", "1");
	}
	
	@Test 
	public void assertcarrito() throws Exception {
		
		String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();

		test = extent.startTest("Validar articulos en el carrito", "Pagina Web de Nuevo");
		test.log(LogStatus.INFO, "Validar articulos en el carrito");

		loginPage Pagina = new loginPage(driver, test, TAKE_SS, WAITING);
		
		Pagina.assertcarrito(subDir);
	}
	
	@Test (dataProvider = "datos")
	public void crearcuenta(String mail, String Nombre, String Apellido, String Pass, String Dia, String Mes, String An, String Company, String Direccion, String Ciudad, String Estado, String Zip, String Pais, String Telefono1, String Telefono2, String Alias) throws Exception {
		
		String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();

		test = extent.startTest("Crear cuenta", "Pagina Web de Nuevo");
		test.log(LogStatus.INFO, "Crear cuenta");

		loginPage Pagina = new loginPage(driver, test, TAKE_SS, WAITING);
		
		Pagina.crearcuenta(subDir, mail, Nombre, Apellido, Pass, Dia, Mes, An, Company, Direccion, Ciudad, Estado, Zip, Pais, Telefono1, Telefono2, Alias);
	}
	
	@Test 
	public void ordencompleta() throws Exception {
		
		String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();

		test = extent.startTest("Orden completada", "Pagina Web de Nuevo");
		test.log(LogStatus.INFO, "Orden completada");

		loginPage Pagina = new loginPage(driver, test, TAKE_SS, WAITING);
		
		Pagina.ordencompleta(subDir);
	}
	
	@Test 
	public void historiaordenes() throws Exception {
		
		String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();

		test = extent.startTest("Historial de ordenes", "Pagina Web de Nuevo");
		test.log(LogStatus.INFO, "Historial de ordenes");

		loginPage Pagina = new loginPage(driver, test, TAKE_SS, WAITING);
		
		Pagina.historiaordenes(subDir);
	}
	
	@Test 
	public void cerrarsesion() throws Exception {
		
		String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();

		test = extent.startTest("Cerrar sesion", "Pagina Web de Nuevo");
		test.log(LogStatus.INFO, "Cerrar sesion");

		loginPage Pagina = new loginPage(driver, test, TAKE_SS, WAITING);
		
		Pagina.cerrarsesion(subDir);
	}
	
	@DataProvider
	public String[][] datos(){
		return Helper.get("src\\test\\resources\\datosPrueba\\datos.xls");
	}
	

	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, "Test failed.- <br>" + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, "Test skipped.- <br>" + result.getThrowable());
		} else {
			test.log(LogStatus.PASS, "Test passed.-");
		}
		//driver.close();
		extent.endTest(test);
	}

	@AfterSuite
	public void closeExtentReports() {
		// Introduce los datos en el reporte.
		extent.flush();
	}


}


