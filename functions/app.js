// This server can be used in local and are ready to deployed in firebase function

// Defining all the required modules
const functions = require("firebase-functions");
const express = require("express");
const cors = require("cors");
const routes = require("./routes");

// Defining port number for local testing
const port = 3000;

// Store express application instance
const app = express();

// Configuring middleware and routing
app.use(express.json());
app.use(cors({origin: true}));
app.use(routes);

// Testing on localhost purpose
app.listen(port, () => {
  console.log(`Example app listening on port ${port}`);
});

// Default route
app.get("/", async (req, res) => {
  res.send("API working!");
});

// Exporting cloud function named freshGrocie that triggered bt HTTP request
exports.freshGrocie = functions.region("asia-southeast2").https.onRequest(app);
