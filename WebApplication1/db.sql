CREATE DATABASE trucks_database;

USE trucks_database;
CREATE TABLE customers
    (
       customerID INT NOT NULL,
       CustomerTitle VARCHAR(50) NOT NULL,
      BusinessName VARCHAR(30) NOT NULL,
      billingAddress VARCHAR(50) NOT NULL,
      city VARCHAR(30) NOT NULL,
       State VARCHAR(30) NOT NULL,
       PostalCode INT NOT NULL,
       Country VARCHAR(30) NOT NULL,
       PhoneNumber INT NOT NULL,
       OtherNumber INT NOT NULL,
       FaxNumber INT NOT NULL,
       EmailAddress VARCHAR(50) NOT NULL,
       CustomerDetails VARCHAR(30) NOT NULL,
       Type VARCHAR(30) NOT NULL,
       CompanyName VARCHAR(30) NOT NULL,
       ContactName VARCHAR(30) NOT NULL,
       AlternateContactName VARCHAR(30) NOT NULL,
       DateEntered DATE NOT NULL,
       PRIMARY KEY (customerID)
     );
     
     INSERT INTO Customer VALUES (1, 1,Jon, 2, we, wewe, ewe,23232, ffsds223323, 23232, 442323, 232344,3433434, 32323.23, 232323232, edfff, dfddfdf, 32323);
-------------------------------------


CREATE TABLE locations
(
  locationID INT NOT NULL,
  locationName VARCHAR(255) NOT NULL,
  locationCode INT NOT NULL,
  addressStreet1 VARCHAR(255) NOT NULL,
  addressStreet2 VARCHAR(255) NOT NULL,
  city VARCHAR(30) NOT NULL,
  state VARCHAR(30) NOT NULL,
  postalCode INT NOT NULL,
  region VARCHAR(30) NOT NULL,
  localContactName VARCHAR(30) NOT NULL,
  locationPhone INT NOT NULL,
  locationFaxNumber INT NOT NULL,
  locationEmailAddress VARCHAR(50) NOT NULL,
  customerID INT NOT NULL,
  PRIMARY KEY (locationID),
  FOREIGN KEY (customerID) REFERENCES customers(customerID)
);
INSERT INTO Location VALUES (1,1,Joe,60616,Yes,400E 33RD ST, APT 1608, CHICAGO,Illinois,60616,abc,jeevith, 312-868-9088,009876,imgotra@hawk.iit.edu);
-------------------------------------

CREATE TABLE prices
(
  priceID INT NOT NULL,
  locationIDFrom INT NOT NULL,
  locationIDTo INT NOT NULL,
  price FLOAT NOT NULL,
  locationCodeFrom INT NOT NULL,
  locationCodeTo INT NOT NULL,
  locationID INT NOT NULL,
  customerID INT NOT NULL,
  PRIMARY KEY (priceID),
  FOREIGN KEY (locationID) REFERENCES locations(locationID),
  FOREIGN KEY (customerID) REFERENCES customers(customerID)
);

CREATE TABLE employees
(
  employeeID INT NOT NULL,
  firstName VARCHAR(30) NOT NULL,
  lastName VARCHAR(30) NOT NULL,
  email VARCHAR(30) NOT NULL,
  extension INT NOT NULL,
  homePhone INT NOT NULL,
  cellPhone INT NOT NULL,
  jobTitle VARCHAR(30) NOT NULL,
  SSN INT NOT NULL,
  dirverLicenseNo INT NOT NULL,
  address VARCHAR(30) NOT NULL,
  city VARCHAR(30) NOT NULL,
  state VARCHAR(30) NOT NULL,
  postalCode INT NOT NULL,
  birthDate DATE NOT NULL,
  dateHired DATE NOT NULL,
  salary FLOAT NOT NULL,
  notes VARCHAR(300) NOT NULL,
  PRIMARY KEY (employeeID)
);
INSERT INTO Employee(32,jeevit,GUPTA,imagotra@hawk.iit.edu,+1,312-868-9088,312-868-9087,Consultant,2345,7890,400 E, CHICAGO,60616,6-6-93,7-23-16,$400,HELLO);
-----------------------------
CREATE TABLE expenses
(
  expenseID INT NOT NULL,
  expenseType VARCHAR(30) NOT NULL,
  expenseCategory VARCHAR(30) NOT NULL,
  purposOfExpense VARCHAR(30) NOT NULL,
  amount FLOAT NOT NULL,
  description VARCHAR(255) NOT NULL,
  datePurchased DATE NOT NULL,
  dateSubmitted DATE NOT NULL,
  advanceAmount INT NOT NULL,
  paymentMethod VARCHAR(255) NOT NULL,
  employeeID INT NOT NULL,
  PRIMARY KEY (expenseID),
  FOREIGN KEY (employeeID) REFERENCES employees(employeeID)
);
INSERT INTO Expense (56,ABC,LOW,PAINT,$567,HELLO,8-7-17,8-7-17,$450,Card);
-----------------------------
CREATE TABLE trucks
(
  truckID INT NOT NULL,
  VIN INT NOT NULL,
  truckNumber INT NOT NULL,
  makeYear DATE NOT NULL,
  model VARCHAR(30) NOT NULL,
  licensePlateNumber INT NOT NULL,
  color VARCHAR(30) NOT NULL,
  cost FLOAT NOT NULL,
  employeeID INT NOT NULL,
  PRIMARY KEY (truckID),
  FOREIGN KEY (employeeID) REFERENCES employees(employeeID)
);

CREATE TABLE orders
(
  orderID INT NOT NULL,
  orderDate DATE NOT NULL,
  isSpecial CHAR NOT NULL,
  PONumber INT NOT NULL,
  orderTotalAmount INT NOT NULL,
  truckID INT NOT NULL,
  employeeID INT NOT NULL,
  customerID INT NOT NULL,
  PRIMARY KEY (orderID),
  FOREIGN KEY (truckID) REFERENCES trucks(truckID),
  FOREIGN KEY (employeeID) REFERENCES employees(employeeID),
  FOREIGN KEY (customerID) REFERENCES customers(customerID)
);

CREATE TABLE invoices
(
  invoiceID INT NOT NULL,
  orderID INT NOT NULL,
  PRIMARY KEY (invoiceID),
  FOREIGN KEY (orderID) REFERENCES orders(orderID)
);

CREATE TABLE transactions
(
  transactionID INT NOT NULL,
  transactionDate DATE NOT NULL,
  transactionDescription VARCHAR(255) NOT NULL,
  transactionAmount FLOAT NOT NULL,
  discount FLOAT NOT NULL,
  unitPrice FLOAT NOT NULL,
  quantity INT NOT NULL,
  driverPrice FLOAT NOT NULL,
  orderID INT NOT NULL,
  priceID INT NOT NULL,
  truckID INT NOT NULL,
  employeeID INT NOT NULL,
  PRIMARY KEY (transactionID),
  FOREIGN KEY (orderID) REFERENCES orders(orderID),
  FOREIGN KEY (priceID) REFERENCES prices(priceID),
  FOREIGN KEY (truckID) REFERENCES trucks(truckID),
  FOREIGN KEY (employeeID) REFERENCES employees(employeeID)
);
INSERT INTO Comment VALUES (128,234,$200,1,4,2-23-2017,Done);
----------------------------------
CREATE TABLE payments
(
  paymentID INT NOT NULL,
  paymentMethodID INT NOT NULL,
  paymentAmount FLOAT NOT NULL,
  paymentDate DATE NOT NULL,
  checknumber INT NOT NULL,
  creditcardID INT NOT NULL,
  creditcardNumber INT NOT NULL,
  cardHolderName VARCHAR(255) NOT NULL,
  creditcardExpDate DATE NOT NULL,
  creditCardAuthNumber INT NOT NULL,
  orderID INT NOT NULL,
  PRIMARY KEY (paymentID),
  FOREIGN KEY (orderID) REFERENCES orders(orderID)
);

CREATE TABLE comments
(
  commentID INT NOT NULL,
  commentDateTime DATE NOT NULL,
  comment VARCHAR(300) NOT NULL,
  locationID INT NOT NULL,
  customerID INT NOT NULL,
  transactionID INT NOT NULL,
  truckID INT NOT NULL,
  PRIMARY KEY (commentID),
  FOREIGN KEY (locationID) REFERENCES locations(locationID),
  FOREIGN KEY (customerID) REFERENCES customers(customerID),
  FOREIGN KEY (transactionID) REFERENCES transactions(transactionID),
  FOREIGN KEY (truckID) REFERENCES trucks(truckID)
);
