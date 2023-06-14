// This server can be used in local and are ready to deployed in firebase function
const functions = require("firebase-functions");
const express = require("express");
const cors = require("cors");
// eslint-disable-next-line no-unused-vars
const routes = require("./routes");
const port = 3000;

// provide firebase service account credential
process.env.GOOGLE_APPLICATION_CREDENTIALS = "../freshgrocie-capstone-firebase-adminsdk-jf6qi-d9860d926f.json";

const app = express();
app.use(express.json());
app.use(cors({origin: true}));
app.use(routes);

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`);
});

app.get("/", async (req, res) => {
  res.send("Hello World!");
});

exports.freshGrocie = functions.region("asia-southeast2").https.onRequest(app);
