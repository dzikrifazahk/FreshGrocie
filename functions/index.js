const functions = require("firebase-functions");
const admin = require("firebase-admin");
const express = require("express");
const axios = require("axios");
const cors = require("cors");

admin.initializeApp();

const db = admin.firestore();
const app = express();
const apiKey = "eyJhbGciOiJSUzI1NiIsImtpZCI6IjVGQUQ4RTE5MjMwOURFRUJCNzBCMzU5M0E2MDU3OUFEMUM5NjgzNDkiLCJ0eXAiOiJhdCtqd3QiLCJ4NXQiOiJYNjJPR1NNSjN1dTNDeldUcGdWNXJSeVdnMGsifQ.eyJuYmYiOjE2ODU5NTMyNzIsImV4cCI6MTY4NjAzOTY3MiwiaXNzIjoiaHR0cHM6Ly9vYXV0aC5mYXRzZWNyZXQuY29tIiwiYXVkIjoicHJlbWllciIsImNsaWVudF9pZCI6IjQ3NTM2ZTZkZGRhZDQwMjlhNTM4MDNlNjQ3ZjYxN2ExIiwic2NvcGUiOlsicHJlbWllciJdfQ.B2GXPihvzK_-WBIVgp9V44hTQiYfpkmCoLqjQCFEYzALLVQSN5BLNxEACX4vtCdFt1AadhZD7xAZY2KRVg4ZNDXCDC7RzhqY5BM8D4Yuvv4kYDp7FxZf9y_0CKh0CrkfBUUetNYx0MSnw7pRLmwMray7UdfQCgHcqj4cx2UN70iaAZsy5kgdVYs8niGMGbP-tC9V3GefvOBvCsHUepmF6sOa1S4el_sDtzd7WiTWtS2TlKBkb3BO8_9dNxjiO9MPHr-Lug83qpmLq1UMjUE_obdqUNNmYqYxRdJpsaw3B04jOETfiF2dan-4LbSo8rFXm-fwIU_bdOAlBG3RgfA13A";

app.use(cors({origin: true}));

// Signup route
app.post("/signup", async (req, res) => {
  const {user_email, user_password} = req.body;

  try {
    const userRecord = await admin.auth().createUser({
      email: user_email,
      password: user_password,
    });

    const user = {
      uid: userRecord.uid,
      user_email: userRecord.email,

    };

    await db.collection("users").doc(user.uid).set(user);

    res.json({message: "Signup successful!", user});
  } catch (error) {
    res.status(400).json({message: "Signup failed!", error});
  }
});

// Signin route
app.post("/signin", async (req, res) => {
  const {user_email, user_password} = req.body;

  try {
    const {user} = await admin.auth().signInWithEmailAndPassword(user_email, user_password);

    const userDoc = await db.collection("users").doc(user.uid).get();
    const userData = userDoc.data();

    res.json({message: "Signin successful!", user: userData});
  } catch (error) {
    res.status(400).json({message: "Signin failed!", error});
  }
});

app.get("/users", async (req, res) => {
  const snapshot = await db.collection("users").get();

  const users = [];
  snapshot.forEach((doc) => {
    const id = doc.id;
    const data = doc.data();

    users.push({id, ...data});
  });
  res.status(200).send(JSON.stringify(users));
});

app.get("/stores", async (req, res) => {
  const snapshot = await db.collection("stores").get();

  const stores = [];
  snapshot.forEach((doc) => {
    const id = doc.id;
    const data = doc.data();

    stores.push({id, ...data});
  });
  res.status(200).send(JSON.stringify(stores));
});

app.get("/products", async (req, res) => {
  const snapshot = await db.collection("products").get();

  const products = [];
  snapshot.forEach((doc) => {
    const id = doc.id;
    const data = doc.data();

    products.push({id, ...data});
  });
  res.status(200).send(JSON.stringify(products));
});

app.get("/transactions", async (req, res) => {
  const snapshot = await db.collection("transactions").get();

  const transactions = [];
  snapshot.forEach((doc) => {
    const id = doc.id;
    const data = doc.data();

    transactions.push({id, ...data});
  });
  res.status(200).send(JSON.stringify(transactions));
});

app.get("/user/:id", async (req, res) => {
  const snapshot = await db.collection("users")
      .doc(req.params.id).get();

  const userId = snapshot.id;
  const userData = snapshot.data();

  res.status(200).send(JSON.stringify({id: userId, ...userData}));
});

app.get("/store/:id", async (req, res) => {
  const snapshot = await db.collection("stores")
      .doc(req.params.id).get();

  const userId = snapshot.id;
  const userData = snapshot.data();

  res.status(200).send(JSON.stringify({id: userId, ...userData}));
});

app.get("/product/:id", async (req, res) => {
  const snapshot = await db.collection("products")
      .doc(req.params.id).get();

  const userId = snapshot.id;
  const userData = snapshot.data();

  res.status(200).send(JSON.stringify({id: userId, ...userData}));
});

// app.get("/transaction/:id", middleware_function, async (req, res) => {
app.get("/transaction/:id", async (req, res) => {
  const snapshot = await db.collection("transactions")
      .doc(req.params.id).get();

  const userId = snapshot.id;
  const userData = snapshot.data();

  res.status(200).send(JSON.stringify({id: userId, ...userData}));
});

// still developing the correct method to search by name
app.get("/users/:name", async (req, resp) => {
  const name = req.params.name.toLowerCase();

  const snapshot = await db.collection("users")
      .orderBy("user_name")
      .startAt(name)
      .endAt(name + "\uf8ff")
      .get();

  const users = [];
  snapshot.forEach((doc) => {
    const id = doc.id;
    const data = doc.data();
    users.push({id, ...data});
  });
  res.status(200).send(JSON.stringify(users));
});

app.get("/stores/:name", async (req, resp) => {
  const name = req.params.name;

  try {
    const snapshot = await db.collection("stores")
        .where("store_name", ">=", name)
        .where("store_name", "<=", name + "\uf8ff")
        .get();

    const data = snapshot.docs.map((doc) => doc.data());
    resp.send(data);
  } catch (error) {
    console.error("Error fetching documents:", error);
    resp.status(500).send("Error fetching documents");
  }
});

app.get("/products/:name", async (req, resp) => {
  const name = req.params.name;

  try {
    const snapshot = await db.collection("products")
        .where("product_name", ">=", name)
        .where("product_name", "<=", name + "\uf8ff")
        .get();

    const data = snapshot.docs.map((doc) => doc.data());
    resp.send(data);
  } catch (error) {
    console.error("Error fetching documents:", error);
    resp.status(500).send("Error fetching documents");
  }
});

app.get("/transactions/:user_id", async (req, resp) => {
  const user_id = req.params.user_id;

  try {
    const snapshot = await db.collection("transactions")
        .where("transaction_name", "==", user_id)
        .get();

    const data = snapshot.docs.map((doc) => doc.data());
    resp.send(data);
  } catch (error) {
    console.error("Error fetching documents:", error);
    resp.status(500).send("Error fetching documents");
  }
});

app.post("/user", async (req, res) => {
  const {
    user_name,
    user_email,
    user_password,
    user_phone_number,
    user_address,
    user_role,
    user_photo,
  } = req.body;

  try {
    const user = {
      user_name,
      user_email,
      user_password,
      user_phone_number,
      user_address,
      user_role,
      user_photo,
    };
    const docRef = await db.collection("users").add(user);
    res.status(201).send({message: "User Added!", user_id: docRef.id});
  } catch (error) {
    console.error("Error adding user:", error);
    res.status(500).send("Error adding user");
  }
});

app.post("/store", async (req, res) => {
  const {
    store_name,
    store_product,
    store_location,
    store_address,
    store_photo,
    store_description,
  } = req.body;

  try {
    const store = {
      store_name,
      store_product,
      store_location,
      store_address,
      store_photo,
      store_description,
    };
    const docRef = await db.collection("stores").add(store);
    res.status(201).send({message: "Store Added!", store_id: docRef.id});
  } catch (error) {
    console.error("Error adding store:", error);
    res.status(500).send("Error adding store");
  }
});

app.post("/product", async (req, res) => {
  const {
    product_name,
    product_unit_price,
    product_stock,
    product_photo,
    product_category,
    product_description,
    product_rating,
  } = req.body;

  try {
    const product = {
      product_name,
      product_unit_price,
      product_stock,
      product_photo,
      product_category,
      product_description,
      product_rating,
    };
    const docRef = await db.collection("products").add(product);
    res.status(201).send({message: "Product Added", product_id: docRef.id});
  } catch (error) {
    console.error("Error adding product:", error);
    res.status(500).send("Error adding product");
  }
});

app.post("/transaction", async (req, res) => {
  const {
    id_user,
    id_product,
    transaction_date,
    product_unit_price,
    total_product,
    total_price,
    payment_method,
    transaction_status,
    shipping_address,
    transaction_notes,
  } = req.body;

  try {
    const transaction = {
      id_user,
      id_product,
      transaction_date,
      product_unit_price,
      total_product,
      total_price,
      payment_method,
      transaction_status,
      shipping_address,
      transaction_notes,
    };
    const docRef = await db.collection("transactions").add(transaction);
    res.status(201)
        .send({message: "Transaction Added!", transaction_id: docRef.id});
  } catch (error) {
    console.error("Error adding transaction:", error);
    res.status(500).send("Error adding transaction");
  }
});

app.put("/user/:id", async (req, res) => {
  const body = req.body;

  await db.collection("users").doc(req.params.id).update(body);

  res.status(200).send();
});

app.put("/store/:id", async (req, res) => {
  const body = req.body;

  await db.collection("stores").doc(req.params.id).update(body);

  res.status(200).send();
});

app.put("/product/:id", async (req, res) => {
  const body = req.body;

  await db.collection("products").doc(req.params.id).update(body);

  res.status(200).send();
});

app.put("/transaction/:id", async (req, res) => {
  const body = req.body;

  await db.collection("transactions").doc(req.params.id).update(body);

  res.status(200).send();
});

app.delete("/user/:id", async (req, res) => {
  await admin.firestore().collection("users").doc(req.params.id).delete();

  res.status(200).send();
});

app.delete("/store/:id", async (req, res) => {
  await admin.firestore().collection("stores").doc(req.params.id).delete();

  res.status(200).send();
});

app.delete("/product/:id", async (req, res) => {
  await admin.firestore().collection("products").doc(req.params.id).delete();

  res.status(200).send();
});

app.delete("/transaction/:id", async (req, res) => {
  await admin.firestore().collection("transaction").doc(req.params.id).delete();

  res.status(200).send();
});

app.get("/fatsecret/product/:id", async (req, res) => {
  const foodId = req.params.id;
  const url = `https://platform.fatsecret.com/rest/server.api?method=food.get.v3&food_id=${foodId}&format=json`;
  const config = {
    headers: {
      Authorization: `Bearer ${apiKey}`,
    },
  };
  axios
      .get(url, config)
      .then((response) => {
        res.status(200).json(response.data);
      })
      .catch((error) => {
        console.error("Error fetching product:", error.message);
        res.status(500).json({error: "Failed to fetch product"});
      });
});

app.get("/fatsecret/products/:name", async (req, res) => {
  const foodName = req.params.name;
  const url = `https://platform.fatsecret.com/rest/server.api?method=food.search.v2&search_expression=${foodName}&format=json`;
  const config = {
    headers: {
      Authorization: `Bearer ${apiKey}`,
    },
  };
  axios
      .get(url, config)
      .then((response) => {
      // Process the response data
        res.status(200).json(response.data);
      })
      .catch((error) => {
        console.error("Error fetching products:", error.message);
        res.status(500).json({error: "Failed to fetch products"});
      });
});

exports.freshGrocie = functions
    .region("asia-southeast2")
    .https.onRequest(app);
