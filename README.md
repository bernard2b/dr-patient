# DR App

DR App is a Java Spring Boot Maven project that aims to provide a backend API for managing doctors, patients, and appointments. The application is still in development and uses PostgreSQL as database. The frontend user interface for the application is built with React and can be found in the [dr-patient-ui](https://github.com/bernard2b/dr-patient-ui) repository.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Future Plans](#future-plans)
- [Contributing](#contributing)

## Installation

To set up the DR App locally, follow these steps:

1. Clone the repository: `git clone https://github.com/your-username/dr-app.git`
2. Navigate to the project directory: `cd dr-app`
3. Install the project dependencies: `mvn install`
4. Configure the PostgreSQL database connection in the application properties file.
5. Run the application: `mvn spring-boot:run`

The application will start running on `http://localhost:8080`.

## Usage

The DR App provides various API endpoints for managing doctors, patients, and appointments. You can use tools like Postman to interact with the API and perform operations such as creating, retrieving, updating, and deleting data.

## API Endpoints

The application currently exposes the following API endpoints:

### DoctorController

- `POST /save-doctors`: Save a list of doctors to the database.
- `GET /doctors`: Retrieve a list of all doctors.
- `GET /doctor/{id}`: Retrieve a specific doctor by ID.

### PatientController

- `POST /save-patients`: Save a list of patients to the database.
- `GET /patients`: Retrieve a list of all patients.
- `GET /patient/{id}`: Retrieve a specific patient by ID.
- `GET /patient-gender`: Retrieve patients by gender.
- `PUT /update-patient/{id}`: Update a patient's information.
- `DELETE /delete-patient/{id}`: Delete a patient from the database.

### ReservationController

- `POST /create-reservation`: Create a reservation by providing doctor ID and patient ID.
- `GET /reservations`: Retrieve a list of all reservations.

## Future Plans

1. Develop more endpoints and functionalities to enhance the capabilities of the DR App.
2. Implement authentication and authorization mechanisms to secure the API endpoints, ensuring that only authorized users can access and modify data.
3. Enhance the database schema by adding additional tables and relationships to create many-to-many connections between entities.
4. Integrate automated testing to ensure the stability and reliability of the application.

## Contributing

Feel free to contribute your ideas or suggestions to further enhance the DR App! If you would like to contribute, please fork the repository, create a new branch, make your changes, and submit a pull request. Make sure to follow the existing code style.

