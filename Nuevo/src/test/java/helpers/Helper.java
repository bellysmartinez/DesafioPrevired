package helpers;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * <P>
 * Clase utilitaria con herramientas comunes a todas las paginas web.
 * <p>
 * Se presentan los siguientes utilitarios:
 * <ul>
 * <li>{@link #addEvidence(Boolean, WebDriver, ExtentTest, String, String, String)}</li>
 * <li>{@link #waitSeconds(int)}</li>
 * <li>{@link #obtenerPaginaExcel(String, String)}</li>
 * <li>{@link #obtenerCelda(XSSFSheet, int, String)}</li>
 * <li>{@link #robotMoveMouse(int, int)}</li>
 * </ul>
 */
public class Helper {

	private static String PATH_EVIDENCE = "ExtentReports\\Evidencia";
	private static String DIR_EVIDENCE = ".\\Evidencia\\";

	/**
	 * <p>
	 * Agrega la evidencia de prueba al reporte a generar.
	 * 
	 * @param TAKE_SS    boolean que indica si se debe adjuntar la evidencia.
	 * @param driver     WebDriver del navegador utilizado.
	 * @param test       referencia al reporte de ExtentReports.
	 * @param imageTitle titulo/descripci�n de la imagen.
	 * @param subDir     Subdirectorio en el cual se guardara la imagen.
	 * @param imageName  nombre de la imagen sin extension.
	 */
	public static void addEvidence(Boolean TAKE_SS, WebDriver driver, ExtentTest test, String imageTitle, String subDir,
			String imageName) {
		if (TAKE_SS) {
			Helper.takeScreenShot(driver, subDir, imageName);
			Helper.takeEvidence(test, imageTitle, subDir, imageName);
		}
	}

	/**
	 * <p>
	 * Detiene la ejecucion la cantidad de segundos indicados por parametro.
	 * <p>
	 * Utilitario para usarse en conjunto con los implicitWait.
	 *
	 * @param seconds cantidad de segundos a detener la ejecucion.
	 */
	public static void waitSeconds(int seconds) {// para esperar antes de algo
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * <p>
	 * Toma una impresion de pantalla y la guarda en un directorio donde quedan
	 * todas las evidencias de prueba
	 *
	 * @param driver    driver navegador.
	 * @param subDir    directorio de las imagenes.
	 * @param imageName nombre de la imagen sin extension.
	 */
	private static void takeScreenShot(WebDriver driver, String subDir, String imageName) {
		// Directorio donde quedaran las imagenes guardadas
		File directory = new File(PATH_EVIDENCE);

		try {
			if (directory.isDirectory()) {
				// Toma la captura de imagen
				File imagen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				// Mueve el archivo a la carga especificada con el respectivo nombre
				FileUtils.copyFile(imagen,
						new File(directory.getAbsolutePath() + "\\" + subDir + "\\" + imageName + ".png"));
			} else {
				// Se lanza la excepcion cuando no encuentre el directorio
				throw new IOException("ERROR : La ruta especificada no es un directorio!");
			}
		} catch (IOException e) {
			// Impresion de Excepciones
			e.printStackTrace();
		}
	}

	/**
	 * <p>
	 * Adjunta una imagen como evidencia de prueba, la imagen ya ha sido capturada
	 * por:
	 * <ul>
	 * <li>{@link #takeScreenShot(WebDriver, String, String)}</li>
	 * </ul>
	 *
	 * @param test       referencia a la instancia de ExtentReports.
	 * @param imageTitle titulo de la imagen.
	 * @param subDir     subdirectorio de la imagen.
	 * @param imageName  nombre de la imagen sin extension.
	 */
	private static void takeEvidence(ExtentTest test, String imageTitle, String subDir, String imageName) {
		File directory = new File(PATH_EVIDENCE);

		try {
			if (directory.isDirectory()) {
				test.log(LogStatus.INFO,
						imageTitle + test.addScreenCapture(DIR_EVIDENCE + subDir + "\\" + imageName + ".png"));

			} else {
				throw new IOException("ERROR : La ruta especificada no es un directorio!");
			}
		} catch (IOException e) {
			// Impresion de Excepciones
			e.printStackTrace();
		}
	}

	/**
	 * <p>
	 * Lee un excel y obtiene una referencia a la hoja especificada por parametro.
	 * <ul>
	 * <li>{@link #obtenerPaginaExcel(String rutaExcel, String hoja)}</li>
	 * </ul>
	 *
	 * @param rutaExcel ruta en la cual se encuentra el excel a abrir.
	 * @param sheet     hoja del excel a manipular.
	 */
	@SuppressWarnings("unused")
	public static XSSFSheet obtenerPaginaExcel(String rutaExcel, String sheet) {
		FileInputStream fis;
		XSSFWorkbook wb;
		XSSFSheet st = null;

		try {
			fis = new FileInputStream(rutaExcel);
			wb = new XSSFWorkbook(fis);
			st = wb.getSheet(sheet);
			fis.close();
		} catch (IOException e) {
			System.out.println("ERROR LEYENDO EL EXCEL!!");
			e.printStackTrace();
		}

		return st;
	}

	/**
	 * <p>
	 * Extrae el dato de una hoja excel segun su fila - columna.
	 * <ul>
	 * <li>{@link #obtenerCelda(String rutaExcel, String hoja)}</li>
	 * </ul>
	 *
	 * @param sheet  hoja del excel de la cual se extraeran los datos.
	 * @param row    fila de hoja excel.
	 * @param column columna de la hoja excel.
	 */
	public static XSSFCell obtenerCelda(XSSFSheet sheet, int row, String column) {
		XSSFRow rw = sheet.getRow(row - 1);
		XSSFCell cell = rw.getCell(columLetter(column));

		return cell;
	}

	/**
	 * <p>
	 * Convierte la columna indicada en letras a numero. Se consideran las columnas
	 * de la A - Z.
	 * <ul>
	 * <li>{@link #columLetter(String column)}</li>
	 * </ul>
	 *
	 * @param column columna de la hoja excel (A - Z).
	 */
	private static int columLetter(String column) {
		String[] columnas = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
				"S", "T", "U", "V", "W", "X", "Y", "Z" };
		int encontrado = -1;

		for (int i = 0; i <= columnas.length; i++) {
			if (columnas[i].equalsIgnoreCase(column)) {
				encontrado = i;
				break;
			}
		}

		try {
			if (encontrado == -1) {
				throw new Exception("ERROR : Columna invalida!!");
			}

		} catch (Exception e) {
			// Impresion de exception
			e.printStackTrace();
		}

		return encontrado;

	}

	/**
	 * <p>
	 * Utilizamos un robot para mover el mouse a la posicion x,y de la pantalla.
	 *
	 * @param x posicion x de la pantalla.
	 * @param y posicion y de la pantalla.
	 */
	@SuppressWarnings("unused")
	public static void robotMoveMouse(int x, int y) {
		// Implementamos un robot para mover el mouse a la posicion x,y.
		// Obtenemos un objeto Robot.
		Robot robotObj;
		try {
			robotObj = new Robot();
			robotObj.mouseMove(x, y);
		} catch (AWTException e) {
			// Error al seleccionar el archivo.
			e.printStackTrace();
		}
	}
	
	// Dependencies: POI | HSSF Workbook/Sheet/Row/Cell
			// This method will read and return Excel data into a double array
			public static String[][] get(String filename) {
				String[][] dataTable = null;
				File file = new File(filename);
				try {
					// Create a file input stream to read Excel workbook and worksheet
					FileInputStream xlfile = new FileInputStream(file);
					HSSFWorkbook xlwb = new HSSFWorkbook(xlfile);
					HSSFSheet xlSheet = xlwb.getSheetAt(0);

					// Get the number of rows and columns
					int numRows = xlSheet.getLastRowNum() + 1;
					int numCols = xlSheet.getRow(0).getLastCellNum();

					// Create double array data table - rows x cols
					// We will return this data table
					dataTable = new String[numRows][numCols];

					// For each row, create a HSSFRow, then iterate through the "columns"
					// For each "column" create an HSSFCell to grab the value at the specified cell (i,j)
					for (int i = 0; i < numRows; i++) {
						HSSFRow xlRow = xlSheet.getRow(i);
						for (int j = 0; j < numCols; j++) {
							HSSFCell xlCell = xlRow.getCell(j);
							dataTable[i][j] = xlCell.toString();
						}
					}
				} catch (IOException e) {
					System.out.println("ERROR FILE HANDLING " + e.toString());
				}
				return dataTable;
			}

}
