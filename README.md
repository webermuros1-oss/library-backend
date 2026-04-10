# Library API

REST API para la gestión de una biblioteca. Permite administrar autores y libros mediante operaciones CRUD completas.

---

## Tecnologías

- Java 25
- Spring Boot 4.0.5
- Spring Data JPA
- Hibernate
- MySQL 8
- Maven

---

## Requisitos previos

- Java 25 instalado
- MySQL 8 corriendo en local
- Maven instalado (o usar el wrapper `mvnw`)

---

## Configuración de la base de datos

Crea la base de datos en MySQL:

```sql
CREATE DATABASE library;
```

Las credenciales por defecto configuradas en `application.properties`:

```
URL:      jdbc:mysql://localhost:3306/library

```

Si tus credenciales son distintas, edita `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/library
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_PASSWORD
```

Hibernate creará las tablas automáticamente al arrancar (`ddl-auto=update`).

---

## Arrancar el proyecto

```bash
mvn spring-boot:run
```

La API quedará disponible en `http://localhost:8080`.

---

## Estructura del proyecto

```
src/main/java/inditexP1/library/
├── controller/
│   ├── AuthorController.java
│   └── BookController.java
├── model/
│   ├── Author.java
│   └── Book.java
├── repository/
│   ├── AuthorRepository.java
│   └── BookRepository.java
├── services/
│   ├── AuthorService.java
│   └── BookService.java
└── LibraryApplication.java
```

---

## Modelos

### Author

| Campo       | Tipo    | Descripción              |
|-------------|---------|--------------------------|
| id          | Integer | Identificador (auto)     |
| name        | String  | Nombre del autor         |
| surname     | String  | Apellido del autor       |
| nationality | String  | Nacionalidad             |
| birthYear   | Integer | Año de nacimiento        |
| alive       | Boolean | Si está vivo o no        |
| category    | String  | Categoría literaria      |

### Book

| Campo           | Tipo    | Descripción                    |
|-----------------|---------|--------------------------------|
| id              | Integer | Identificador (auto)           |
| title           | String  | Título del libro               |
| isbn            | String  | ISBN del libro                 |
| publicationYear | Integer | Año de publicación             |
| image           | String  | URL de la imagen de portada    |
| category        | String  | Categoría literaria            |
| author          | Author  | Autor asociado (relación ManyToOne) |

---

## Endpoints

### Authors — `/api/authors`

#### GET todos los autores
```
GET /api/authors
```
Respuesta `200`:
```json
[
  {
    "id": 1,
    "name": "Gabriel",
    "surname": "García Márquez",
    "nationality": "Colombiana",
    "birthYear": 1927,
    "alive": false,
    "category": "Realismo mágico"
  }
]
```

---

#### GET autor por ID
```
GET /api/authors/{id}
```
Respuesta `200` si existe, `404` si no existe.

---

#### POST crear autor
```
POST /api/authors/new
Content-Type: application/json
```
Body:
```json
{
  "name": "Gabriel",
  "surname": "García Márquez",
  "nationality": "Colombiana",
  "birthYear": 1927,
  "alive": false,
  "category": "Realismo mágico"
}
```
Respuesta `200` con el autor creado.

---

#### PUT editar autor
```
PUT /api/authors/{id}
Content-Type: application/json
```
Body:
```json
{
  "name": "Gabriel",
  "surname": "García Márquez",
  "nationality": "Colombiana",
  "birthYear": 1927,
  "alive": false,
  "category": "Ficción"
}
```
Respuesta `true` si se actualizó correctamente, `false` si hubo error.

---

#### DELETE eliminar autor
```
DELETE /api/authors/{id}
```
Respuesta `204` si se eliminó, `404` si no existe.

---

#### GET autores por categoría
```
GET /api/authors/category/{category}
```
Respuesta `200` con lista de autores de esa categoría.

---

### Books — `/api/books`

#### GET todos los libros
```
GET /api/books
```
Respuesta `200`:
```json
[
  {
    "id": 1,
    "title": "Cien años de soledad",
    "isbn": "978-0-06-088328-7",
    "publicationYear": 1967,
    "image": "https://...",
    "category": "Realismo mágico",
    "author": { ... }
  }
]
```

---

#### GET libro por ID
```
GET /api/books/{id}
```
Respuesta `200` si existe, `404` si no existe.

---

#### POST crear libro
```
POST /api/books
Content-Type: application/json
```
Body:
```json
{
  "title": "Cien años de soledad",
  "isbn": "978-0-06-088328-7",
  "publicationYear": 1967,
  "image": "https://...",
  "category": "Realismo mágico",
  "author": { "id": 1 }
}
```
Respuesta `201` con el libro creado.

---

#### PUT editar libro
```
PUT /api/books/{id}
Content-Type: application/json
```
Body igual que el POST. Respuesta `200` con el libro actualizado, `404` si no existe.

---

#### DELETE eliminar libro
```
DELETE /api/books/{id}
```
Respuesta `204` si se eliminó, `404` si no existe.

---

#### GET libros por categoría
```
GET /api/books/category/{category}
```
Respuesta `200` con lista de libros de esa categoría.

---

## Relaciones entre entidades

- Un **Author** puede tener muchos **Books** (OneToMany)
- Un **Book** pertenece a un **Author** (ManyToOne)
- La relación se serializa evitando referencias circulares con `@JsonIgnoreProperties`


## Trabajo realizado por:

- Heber Paris Caamaño
- Sergio Fernandez Rial
- Juan luis Márquez Canedo
- Mellisa Gómez
- Alberto García Poncet


Copyright (c) 2026 

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.