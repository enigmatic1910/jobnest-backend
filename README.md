<h1 align="center" id="title">JobNest-Backend</h1>

<p align="center"><img src="https://socialify.git.ci/enigmatic1910/jobnest-backend/image?language=1&amp;name=1&amp;owner=1&amp;pattern=Solid&amp;theme=Dark" alt="project-image"></p>

<p id="description">Jobnest Backend — lightweight Java backend for job listing / management</p>

  
  
<h2>🧐 Features</h2>

Here're some of the project's best features:

*   CRUD job postings with search and pagination
*   User registration and login with secure JWT authentication
*   Role-based access control for protected endpoints
*   Automated periodic import of external job listings

<h2>🛠️ Installation Steps:</h2>

<p>1. Clone the repository:</p>

```
git clone https://github.com/enigmatic1910/jobnest-backend.git 
```

<p>2. Set up a relational database (e.g. MySQL/PostgreSQL) and create a database for the project.</p>

<p>3. Configure database and JWT settings</p>

```
Edit src/main/resources/application.properties
```

<p>4. Add your database URL username password and a JWT secret</p>

<p>5. Build the project:</p>

```
./mvnw clean package -DskipTests
```

<p>6. Run the application:</p>

```
java -jar target/jobnest-0.0.1-SNAPSHOT.jar
```

<p>7. (Optional) Run with Docker:</p>

```
docker build -t jobnest-backend:latest .
```

```
docker run -e SPRING_PROFILES_ACTIVE=prod -p 8080:8080 jobnest-backend:latest
```

  
  
<h2>💻 Built with</h2>

Technologies used in the project:

*   Java 21
*   Spring Boot
*   Spring Security
*   JWT (JSON Web Tokens)
*   Spring Data JPA (with a relational database)
*   Maven
*   Docker
*   REST API design
