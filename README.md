# Desaf&iacute;o Automatizaci&oacute;n QA

Realice el siguiente flujo:

- Para la ejecución de esta prueba automatizada es necesario cargar el proyecto y luego ir al proyecto Nuevo.

- Posteriormente dirigirse a la ruta: src/test/resources.

- Abrir la carpeta testng, en donde se encontrará el xml (ejecucion.xml) que contiene la lista de los tests para ser ejecutados.

- Hacer clic derecho sobre este xml, dirigirse a Run AS y luego hacer clic en 1 TestNg suite.

- Procederá a la ejecución de los test.

- Una vez ejecutados dirigirse a la carpeta ExtentReports y hacer clic sobre el html (PruebaNuevo.html) donde se abrirá el html y se podrá visualizar las evidencias.

- También se puede acceder manualmente para visualizar las evidencias a través de la carpeta ExtentReports, acceder a la carpeta Evidencia y EvidenciaPruebaNuevo y 
luego se mostrará cada una de las carpetas donde se encuentran las evidencias por cada test realizado: agregarblusa, cerrarsesion, crearcuenta, historiairdenes y ordencompleta.

- En la carpeta src/test/resorces también se encontrará la carpeta datosPrueba que contiene el excel con todos los datos que se necesitan para crear la cuenta e ingresar en el formulario, los cuales son:
correo, nombre, apellido, contraseña, día, mes, año, company, dirección, ciudad, país, código postal, telefóno 1, telefóno 2 y dirección alias.

Nota: No se pudo realizar el test del vestido largo de verano debido a que el automatizador no reconoce los elementos del select de la talla, los botones de colores, 
ni el botón de añadir a carrito de compras. Se intentó con id, name, Xpath y cssSelector y siempre arrojaba el error Unable to locate element.  



 

 

