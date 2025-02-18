student-api-service
├── src
│   └── main ( fro there you need to change this main folder with the folder attatched above)
│       ├── java
│       │   └── com
│       │       └── example
│       │           └── warehouseservices
│       │               ├── model       <-- Holds data classes (e.g., Student.java)
│       │               ├── controller  <-- REST API controllers (e.g., StudentController.java)
│       │               ├── service     <-- Service classes for business logic (e.g., StudentService.java)
│       │               └── WarehouseserviceApplication.java  <-- Main entry point
│       └── resources
│           ├── application.properties  <-- Configuration properties
│           └── students.csv            <-- Sample data
└── pom.xml


Create the Warehouse Service Microservice

Spring Initializr Configuration:

    Group: com.aryaag
    Artifact: warehouse-service
    Name: Warehouse Service
    Packaging: Jar
    Java Version: 21
    Add dependencies:
        Spring Web
        Spring Data JPA
        Lombok
        PostgreSQL Driver
        Spring Security

Click Generate and open the project in IntelliJ IDEA.



After generating the spring boot, a zip file is generated in your home>Downloads, extract it to a folder, Now go src, main and relace the main with main file i attatched. 
Now you are good to go with project, run it test the API in URL as well as Postman or any testing software.

URL for results - http://localhost:8080/ + these down
Warehouse Service

GET /api/v1/warehouses – Get all warehouses
POST /api/v1/warehouses – Add a new warehouse
PUT /api/v1/warehouses/{warehouseId} – Update a warehouse
DELETE /api/v1/warehouses/{warehouseId} – Delete a warehouse

Customer Service

GET /api/v1/customers – Get all customers
POST /api/v1/customers – Add a new customer
PUT /api/v1/customers/{customerId} – Update a customer
DELETE /api/v1/customers/{customerId} – Delete a customer

Commodity Service

GET /api/v1/commodities – Get all commodities
POST /api/v1/commodities – Add a new commodity
PUT /api/v1/commodities/{commodityId} – Update a commodity
DELETE /api/v1/commodities/{commodityId} – Delete a commodity

Inventory Service

GET /api/v1/inventory – Get all inventory records
GET /api/v1/inventory/warehouse/{warehouseId} – Get inventory by warehouse
GET /api/v1/inventory/customer/{customerId} – Get inventory by customer
POST /api/v1/inventory – Add inventory (INWARD)
PUT /api/v1/inventory/{inventoryId} – Update inventory
DELETE /api/v1/inventory/{inventoryId} – Delete inventory

Inventory Movement Service

GET /api/v1/inventory/movements – Get all inventory movements
POST /api/v1/inventory/movements – Add inventory movement (INWARD/OUTWARD)
GET /api/v1/inventory/movements/warehouse/{warehouseId} – Get movements by warehouse
GET /api/v1/inventory/movements/commodity/{commodityId} – Get movements by commodity
GET /api/v1/inventory/movements/customer/{customerId} – Get movements by customer
