package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import helpers.Helper;
import helpers.PageWeb;

public class loginPage extends PageWeb {
  private By txtBuscar;
  private By btnLupa;
  private By btnImagen;
  private By btnImagen2;
  private By cmbSize;
  private By btnColornegro;
  private By btnColornaranja;
  private By btnAddtocart;
  private By btnContinueshopping;
  private By btnProceed;
  private By btnProceed2;
  private By txtEmail;
  private By btnCreate;
  private By chkTitle;
  private By txtFirstname;
  private By txtLastname;
  private By txtEmailcuenta;
  private By txtPassword;
  private By cmbDays;
  private By cmbMonth;
  private By cmbYears;
  private By txtCompanydireccion;
  private By txtAddress;
  private By txtAddress2;
  private By txtCity;
  private By cmbState;
  private By txtCodigopostal;
  private By cmbCountry;
  private By txtHomephone;
  private By txtMobilephone;
  private By txtAlias;
  private By btnRegistre;
  private By btnProceed3;
  private By chkTermservice;
  private By btnProceed4;
  private By btnPay;
  private By btnConfirmar;
  private By btnLogo;
  private By btnMisordenes;
  private By btnPdf;
  private By btnCerrarsesion;
  
	//Constructor
  public loginPage(WebDriver driver, ExtentTest test, Boolean TAKE_SS, int seconds) {
	//Siempre se conserva el super 
	  super(driver, test, TAKE_SS, seconds);
	  
	  this.txtBuscar=By.id("search_query_top");
	  this.btnLupa=By.name("submit_search");
	  this.btnImagen=By.cssSelector("#center_column>ul>li>div>div:nth-child(1)>div>a:nth-child(1)>img");
	  this.btnImagen2=By.cssSelector("#center_column>ul>li:nth-child(1)>div>div:nth-child(1)>div>a:nth-child(1)>img");
	  this.cmbSize=By.cssSelector("#attributes>fieldset>div:nth-child(2)>div>select");
	  this.btnColornegro=By.id("color_11");
	  this.btnColornaranja=By.id("color_13");
	  this.btnAddtocart=By.name("Submit");
	  this.btnContinueshopping=By.cssSelector("#layer_cart>div:nth-child(1)>div:nth-child(2)>div:nth-child(5)>span>span>i");
	  this.btnProceed=By.cssSelector("#layer_cart>div:nth-child(1)>div:nth-child(2)>div:nth-child(5)>a>span");
	  this.btnProceed2=By.cssSelector("#center_column>p:nth-child(7)>a:nth-child(1)>span");
	  this.txtEmail=By.id("email_create");
	  this.btnCreate=By.id("SubmitCreate");
	  this.chkTitle=By.id("id_gender1");
	  this.txtFirstname=By.id("customer_firstname");
	  this.txtLastname=By.id("customer_lastname");
	  this.txtEmailcuenta=By.id("");
	  this.txtPassword=By.id("passwd");
	  this.cmbDays=By.id("days");	  
	  this.cmbMonth=By.id("months");
	  this.cmbYears=By.id("years");
	  this.txtCompanydireccion=By.id("company");
	  this.txtAddress=By.id("address1");
	  this.txtAddress2=By.id("address2");
	  this.txtCity=By.id("city");
	  this.cmbState=By.id("id_state");
	  this.txtCodigopostal=By.id("postcode");
	  this.cmbCountry=By.id("id_country");
	  this.txtHomephone=By.id("phone");
	  this.txtMobilephone=By.id("phone_mobile");
	  this.txtAlias=By.id("alias");
	  this.btnRegistre=By.id("submitAccount");
	  this.btnProceed3=By.name("processAddress");
	  this.chkTermservice=By.id("cgv");
	  this.btnProceed4=By.name("processCarrier");
	  this.btnPay=By.cssSelector("#HOOK_PAYMENT>div:nth-child(1)>div>p>a");
	  this.btnConfirmar=By.cssSelector("#center_column>form>p>button>span>i");
	  this.btnLogo=By.cssSelector("#page>div:nth-child(2)>div>div:nth-child(1)>a>i");
	  this.btnMisordenes=By.cssSelector("#footer>div>section:nth-child(7)>div>ul>li:nth-child(1)>a");
	  this.btnPdf=By.cssSelector("#order-list>tbody>tr>td:nth-child(6)>a>i");
	  this.btnCerrarsesion=By.cssSelector("#header>div:nth-child(2)>div>div>nav>div:nth-child(2)>a");
	  
  }
  
   
//Método para agregar blusa negra:
  public void agregarblusa(String subDir, String Valorprenda, String Valorsize) throws Exception {
	  Helper.waitSeconds(3);
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(txtBuscar))).sendKeys(Valorprenda);
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(btnLupa))).click();
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(btnImagen))).click();
	  Helper.waitSeconds(3);
	  JavascriptExecutor jse = (JavascriptExecutor)driver;
	  jse.executeScript("window.scrollBy(0,250)");
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("document.getElementById('uniform-group_1').setAttribute('class', '')");
	  Helper.waitSeconds(3);
	  Select Size = new Select(wait.until(ExpectedConditions.visibilityOf(driver.findElement(cmbSize))));
	  Size.selectByValue(Valorsize);
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(btnColornegro))).click();
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(btnAddtocart))).click();
	  Helper.waitSeconds(3);
	  Helper.addEvidence(TAKE_SS, driver, test, "blusa agregada", subDir, "blusaagregada");
	  Helper.waitSeconds(3);
	  Assert.assertEquals(driver.findElement(By.cssSelector("#layer_cart>div:nth-child(1)>div:nth-child(1)>h2")).getText(), "Product successfully added to your shopping cart");
  	}
  
//Método para agregar vestido largo de verano:
  public void agregarvestido(String subDir, String Valorprenda2, String Valorsize2) throws Exception {
	  Helper.waitSeconds(3);
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(btnContinueshopping))).click();
	  driver.findElement(By.cssSelector("#header_logo>a>img")).click();
	  Helper.waitSeconds(3);
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(txtBuscar))).sendKeys(Valorprenda2);
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(btnLupa))).click();
	  Helper.waitSeconds(3);
	  JavascriptExecutor jse2 = (JavascriptExecutor)driver;
	  jse2.executeScript("window.scrollBy(0,250)");
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(btnImagen2))).click();
	  Helper.waitSeconds(3);
	  JavascriptExecutor jse3 = (JavascriptExecutor)driver;
	  jse3.executeScript("window.scrollBy(0,250)");
	  Helper.waitSeconds(3);
	  driver.findElement(By.id("quantity_wanted")).sendKeys("2");
	  WebElement selectElementSize = driver.findElement(cmbSize);
	  Select selectObjectSize = new Select(selectElementSize);
	  selectObjectSize.selectByValue("1");
	  //JavascriptExecutor js4 = (JavascriptExecutor) driver;
	  //js4.executeScript("document.getElementById('add_to_cart').setAttribute('class', '')");
	  //Helper.waitSeconds(3);
	  //WebElement selectElementSize = driver.findElement(cmbSize);
	  //Select selectObjectSize = new Select(selectElementSize);
	  //selectObjectSize.selectByValue(Valorsize2);
	  Helper.waitSeconds(3);
	  //driver.findElement(By.id("color_14")).click();
	  driver.findElement(By.id("add_to_cart")).click();
	  driver.findElement(By.name("Submit")).click();
	  Helper.waitSeconds(3);
	  Helper.addEvidence(TAKE_SS, driver, test, "summer dress agregado", subDir, "summerdressagregado");
	  Helper.waitSeconds(3);
	  Assert.assertEquals(driver.findElement(By.cssSelector("#layer_cart>div:nth-child(1)>div:nth-child(1)>h2")).getText(), "Product successfully added to your shopping cart");
	}
	  
//Método para validar los articulos en el carrito:
  public void assertcarrito(String subDir) throws Exception {
	  Helper.waitSeconds(3);
	  //Thread.sleep(2000);
	  //Assert.assertEquals(driver.findElement(By.cssSelector("#layer_cart>div:nth-child(1)>div:nth-child(2)>h2>span>span")).getText(), "2");
	}
	  
//Método para crear una cuenta:
  public void crearcuenta(String subDir, String mail, String Nombre, String Apellido, String Pass, String Dia, String Mes, String An, String Company, String Direccion, String Ciudad, String Estado, String Zip, String Pais, String Telefono1, String Telefono2, String Alias) throws Exception {
      Helper.waitSeconds(4);
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(btnProceed))).click();
	  Helper.waitSeconds(3);
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(btnProceed2))).click();
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(txtEmail))).sendKeys(mail);
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(btnCreate))).click();
	  Helper.waitSeconds(3);
	  driver.findElement(chkTitle).click();
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(txtFirstname))).sendKeys(Nombre);
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(txtLastname))).sendKeys(Apellido);
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(txtPassword))).sendKeys(Pass);
	  WebElement selectElementDia = driver.findElement(cmbDays);
	  Select selectObjectDia = new Select(selectElementDia);
	  selectObjectDia.selectByValue(Dia.substring(0, Dia.length()-2));
	  WebElement selectElementMes = driver.findElement(cmbMonth);
	  Select selectObjectMes = new Select(selectElementMes);
	  selectObjectMes.selectByValue(Mes.substring(0, Mes.length()-2));
	  WebElement selectElementAn = driver.findElement(cmbYears);
	  Select selectObjectAn = new Select(selectElementAn);
	  selectObjectAn.selectByValue(An.substring(0, An.length()-2));
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(txtCompanydireccion))).sendKeys(Company);
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(txtAddress))).sendKeys(Direccion);
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(txtCity))).sendKeys(Ciudad);
	  WebElement selectElementSt = driver.findElement(cmbState);
	  Select selectObjectSt = new Select(selectElementSt);
	  selectObjectSt.selectByVisibleText(Estado);
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(txtCodigopostal))).sendKeys(Zip);
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(txtHomephone))).sendKeys(Telefono1.substring(0, Telefono1.length()-2));
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(txtMobilephone))).sendKeys(Telefono2.substring(0, Telefono2.length()-2));
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(txtAlias))).clear();
	  driver.findElement(txtAlias).sendKeys(Alias);
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(btnRegistre))).click();
	  Helper.waitSeconds(3);
	  Helper.addEvidence(TAKE_SS, driver, test, "cuenta creada 1", subDir, "cuentacreada1");
	  JavascriptExecutor jse3 = (JavascriptExecutor)driver;
	  jse3.executeScript("window.scrollBy(0,250)");
	  Helper.waitSeconds(3);
	  Helper.addEvidence(TAKE_SS, driver, test, "cuenta creada2", subDir, "cuentacreada2");
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(btnProceed3))).click();
	  Helper.waitSeconds(3);
	  JavascriptExecutor jse4 = (JavascriptExecutor)driver;
	  jse4.executeScript("window.scrollBy(0,250)");
	  Helper.waitSeconds(3);
	  Helper.addEvidence(TAKE_SS, driver, test, "shipping", subDir, "shipping");
	  Assert.assertEquals(driver.findElement(By.cssSelector("#form>div>div:nth-child(2)>div:nth-child(2)>div>div>table>tbody>tr>td:nth-child(4)>div")).getText(), "$2.00");
	}
	  
	  //Método para orden completa:
	  public void ordencompleta(String subDir) throws Exception {  
	  Helper.waitSeconds(3);
	  JavascriptExecutor js5 = (JavascriptExecutor) driver;
	  js5.executeScript("document.getElementById('uniform-cgv').setAttribute('class', '')");
	  Helper.waitSeconds(3);
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(chkTermservice))).click();
	  Helper.waitSeconds(3);
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(btnProceed4))).click();
	  Helper.waitSeconds(3);
	  JavascriptExecutor jse6 = (JavascriptExecutor)driver;
	  jse6.executeScript("window.scrollBy(0,500)");
	  Helper.waitSeconds(3);
	  Helper.addEvidence(TAKE_SS, driver, test, "costo final del carrito", subDir, "costofinaldelcarrito");
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(btnPay))).click();
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(btnConfirmar))).click();
	  Helper.waitSeconds(3);
	  JavascriptExecutor jse7 = (JavascriptExecutor)driver;
	  jse7.executeScript("window.scrollBy(0,500)");
	  Helper.waitSeconds(3);
	  Helper.addEvidence(TAKE_SS, driver, test, "orden completada", subDir, "ordencompletada");
	}
	  
	  //Método historia de órdenes:
	  public void historiaordenes(String subDir) throws Exception {
	  Helper.waitSeconds(3);
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(btnLogo))).click();
	  Helper.waitSeconds(3);
	  JavascriptExecutor jse8 = (JavascriptExecutor)driver;
	  jse8.executeScript("window.scrollBy(0,500)");
	  Helper.waitSeconds(3);
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(btnMisordenes))).click();
	  Helper.waitSeconds(3);
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(btnPdf))).click();
	  Helper.waitSeconds(3);
	  JavascriptExecutor jse9 = (JavascriptExecutor)driver;
	  jse9.executeScript("window.scrollBy(0,250)");
	  Helper.waitSeconds(3);
	  Helper.addEvidence(TAKE_SS, driver, test, "historia de ordenes", subDir, "historiadeordenes");
	  Helper.waitSeconds(3);
	  Assert.assertEquals(driver.findElement(By.cssSelector("#order-list>tbody>tr>td:nth-child(5)>span")).getText(), "On backorder");
	}
	  
	  //Método para cerrar sesión:
	  public void cerrarsesion(String subDir) throws Exception {
	  Helper.waitSeconds(3);
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(btnCerrarsesion))).click();
	  Helper.waitSeconds(3);
	  Helper.addEvidence(TAKE_SS, driver, test, "cierre de sesion", subDir, "cierredesesion");
	  
	}
  
    
}