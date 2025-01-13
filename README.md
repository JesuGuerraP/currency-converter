# Currency Converter

![Currency Converter](https://img.shields.io/badge/Status-In%20Progress-blue)
![License](https://img.shields.io/badge/License-MIT-green)

**Currency Converter** es una aplicación web que permite realizar conversiones entre diferentes monedas utilizando tasas de cambio en tiempo real. Está desarrollada con tecnologías modernas para garantizar rendimiento y escalabilidad.

## 🚀 Características

- Conversión en tiempo real entre múltiples monedas.
- Interfaz dinámica y responsiva utilizando Thymeleaf.
- Actualización automática de tasas de cambio mediante consumo de APIs externas.
- Manejo eficiente del backend utilizando Spring Boot.
- Validación de datos en el cliente y el servidor.

## 🛠️ Tecnologías y herramientas utilizadas

### Backend
- **Java 17**: Lenguaje principal para el desarrollo del backend.
- **Spring Boot**: Framework para la creación de aplicaciones web robustas.
  - **Spring Web**: Para gestionar rutas y solicitudes HTTP.
  - **Spring Boot DevTools**: Para facilitar el desarrollo con recarga en caliente.
- **RestTemplate**: Para consumir la API externa de tasas de cambio.
- **API externa**: Servicio para obtener tasas de cambio actualizadas (ejemplo: [ExchangeratesAPI.io](https://exchangeratesapi.io/)).

### Frontend
- **Thymeleaf**: Motor de plantillas para renderizar vistas dinámicas.
- **HTML5**: Creación de la estructura de las vistas.
- **CSS3**: Estilización de la interfaz.
- **Bootstrap**: Framework para diseño responsivo y estilos predeterminados.
- **JavaScript (opcional)**: Para funcionalidades interactivas adicionales.

### Dependencias adicionales
- **Lombok**: Para reducir el boilerplate en las clases Java.
- **Maven**: Gestión de dependencias y construcción del proyecto.

### Herramientas
- **IntelliJ IDEA**: Entorno de desarrollo integrado (IDE).
- **Postman**: Para probar las APIs externas durante el desarrollo.
- **Git y GitHub**: Control de versiones y colaboración.
- **H2 Database (opcional)**: Base de datos en memoria para pruebas.


## 🚧 Instalación y configuración

1. Clona este repositorio:
   ```bash
   git clone https://github.com/JesuGuerraP/currency-converter.git
   
2. Navega al directorio del proyecto:
bash
Copiar código
cd currency-converter

3.Configura el archivo application.properties con los siguientes valores:
properties
Copiar código
api.key=TU_API_KEY
api.url=https://api.exchangeratesapi.io/latest

4.Compila e inicia el proyecto con Maven:
bash
Copiar código
mvn spring-boot:run

5. Abre tu navegador en http://localhost:8080

   API utilizada
El proyecto utiliza una API de tasas de cambio. Algunos ejemplos de servicios que podrías haber usado son:

ExchangeratesAPI.io
OpenExchangeRates
CurrencyLayer
🛠️ Próximas mejoras
 Añadir historial de conversiones realizadas por el usuario.
 Soporte para gráficos interactivos con datos históricos de tasas.
 Implementar internacionalización (i18n) para soportar varios idiomas.
📝 Licencia
Este proyecto está bajo la Licencia MIT. Consulta el archivo LICENSE para más detalles.

👤 Autor
Creado por Jesús Guerra.

📧 Correo: jesuguerra@gmail.com
🌐 GitHub: JesuGuerraP

