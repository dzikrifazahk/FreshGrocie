# FreshGrocie REST API

## Features

- [x] User CRUD
  - [x] Get Users
  - [x] Get User by Id
  - [x] Create User
  - [x] Update User
  - [x] Delete User
- [x] User/Chart
  - [x] Create Chart Based on User Id
  - [x] Get Chart Based on User Id 
- [x] User/Transaction
  - [x] Create Transaction Based on User Id
  - [x] Get Transaction Based on User Id  
- [x] Product CRUD
  - [x] Get Products
  - [x] Get Product by Id
  - [x] Create Product
  - [x] Update Product
  - [x] Delete Product
- [x] Store CRUD
  - [x] Get Stores
  - [x] Get Store by Id
  - [x] Create Store
  - [x] Update Store
  - [x] Delete Store
- [x] Transaction CRUD
  - [x] Get Transactions
  - [x] Get Transaction by Id
  - [x] Create Transaction
  - [x] Update Transaction
  - [x] Delete Transaction
- [x] Accessing Fatsecret (on development)
  - [x] Get Product by Id
  - [x] Get Products by name (search product by name)

## Installation

## Prerequisites

- [Node.js](https://nodejs.org/en/)
- [Firebase](https://www.mysql.com/)
- [Google Cloud Firestore](https://cloud.google.com/firestore)
- [Google Cloud Function](https://cloud.google.com/functions)
- [Google Cloud Storage](https://cloud.google.com/storage)

## Setup
- clone this project **`git clone https://github.com/Fashionism-Bangkit-Capstone/Fashionism-Cloud-Computing.git`**
- checkout to backend-rest-api branch **`git checkout cc_dev`**
- open the project with an IDE
- install all dependencies **`npm install`**

## Configure the Service Accounts
- Add service accounts for firebase SDK and google cloud storage creator and place inside this repository folder

## Run the Server
- Change directory to functions (cd ./functions)
- Run the server with **`npm run dev`**

## Libraries
- Express
- Firebase Admin
- Axios
- Cors
- Firebase Function
- Moment
- Multer

## Deployment
Deployed using firebase cloud function with : "firebase deploy --only functions"
