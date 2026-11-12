# 🐾 Catálogo de Productos Veterinarios - VECOL (Colombia)

Aplicación web desarrollada para la hackathon utilizando **Java** y **Spring Boot**, que procesa y expone datos abiertos oficiales de Colombia (`datos.gov.co`) sobre productos veterinarios y biológicos de VECOL.

---

## 🚀 Características Principales
* **Carga de Datos Automatizada:** Procesa un archivo CSV oficial con más de 180 registros de productos veterinarios al iniciar la aplicación (`@PostConstruct`).
* **Búsqueda Multicriterio Inteligente:** Permite filtrar en tiempo real los productos simultáneamente por **Nombre**, **Especie animal** (ej. *Bovinos, Porcinos, Equinos*) y **Clase/Categoría**.
* **Contador Dinámico:** Muestra estadísticas en tiempo real del número de registros encontrados según el filtro aplicado.
* **Interfaz Moderna:** Diseño responsivo y limpio implementado con **Bootstrap 5** y **Thymeleaf**.

---

## 🛠️ Tecnologías Utilizadas
* **Backend:** Java 23, Spring Boot, Spring MVC
* **Motor de Plantillas:** Thymeleaf
* **Frontend:** Bootstrap 5, HTML5
* **Gestión de Dependencias:** Maven / Maven Wrapper (`mvnw`)
* **Control de Versiones:** Git & GitHub

---

## ⚙️ Instrucciones de Ejecución Local

Sigue estos pasos para clonar y poner en marcha el proyecto en tu equipo:

1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/saradanijime07-prog/Veterinaria.git
   cd Veterinaria
