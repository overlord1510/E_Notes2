# eNotes - Spring MVC Project

eNotes is a web application built using Spring MVC that allows users to create, edit, delete, and manage notes online. This project demonstrates the use of Spring MVC for building a simple but functional web application.

## Features
- User authentication and authorization
- Create, read, update, and delete (CRUD) operations for notes
- Responsive design

## Prerequisites
- Java 8 or higher
- Maven
- MySQL
## Installation

1. **Clone the repository:**
    ```sh
    git clone https://github.com/yourusername/enotes.git
    cd enotes
    ```

2. **Setup the database:**
    - Create a new database named `e_notes`.
    - Update the `application.properties` file with your database credentials.

3. **Build the project using Maven:**
    ```sh
    mvn clean install
    ```

4. **Run the application:**
    ```sh
    mvn spring-boot:run
    ```

5. **Access the application:**
    Open your browser and go to `http://localhost:8080`.

## Usage

1. **Register a new account or log in with an existing account.**

2. **Create a new note by clicking the 'New Note' button.**

3. **Edit or delete notes by clicking the respective buttons.**

4. **Search for notes using the search bar.**

## Screenshots

### Home Page
![HomePage](https://github.com/overlord1510/E_Notes2/assets/58284179/0d769241-1fca-439d-9cd5-e77b89912388)

### Login Page
![LoginPage](https://github.com/overlord1510/E_Notes2/assets/58284179/b3402695-2f01-4acb-be10-fb8bd7654a1d)

### Register Page
![RegisterPage](https://github.com/overlord1510/E_Notes2/assets/58284179/825e5fca-c987-4924-81f7-1dd925ba88e6)

### Add Notes
![Add notes](https://github.com/overlord1510/E_Notes2/assets/58284179/c6bf0229-ccca-423e-b1a4-5df977c3df91)

### Empty Note List
![Empty Note List](https://github.com/overlord1510/E_Notes2/assets/58284179/c0867b4e-f97f-49e2-8166-71a3014f6ad7)

### Note List
![Note List](https://github.com/overlord1510/E_Notes2/assets/58284179/1b4bf1b7-8fc2-437b-ad58-0f1922aa59f1)

## Technologies Used
- Spring MVC
- Spring Boot
- Hibernate
- Thymeleaf
- MySQL

## Contributing

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes.
4. Commit your changes (`git commit -am 'Add new feature'`).
5. Push to the branch (`git push origin feature-branch`).
6. Create a new Pull Request.
