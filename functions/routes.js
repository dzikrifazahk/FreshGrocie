// Routing configuration

/* eslint-disable new-cap */
const express = require("express");
const admin = require("firebase-admin");
const axios = require("axios");
const Multer = require("multer");
const moment = require("moment");

const router = express.Router();

const {db, orderedFields, orderFields} = require("./database");
const imgUpload = require("./imgUpload");

// API key renew every 24 hours
const apiKey = "eyJhbGciOiJSUzI1NiIsImtpZCI6IjVGQUQ4RTE5MjMwOURFRUJCNzBCMzU5M0E2MDU3OUFEMUM5NjgzNDkiLCJ0eXAiOiJhdCtqd3QiLCJ4NXQiOiJYNjJPR1NNSjN1dTNDeldUcGdWNXJSeVdnMGsifQ.eyJuYmYiOjE2ODU5NTMyNzIsImV4cCI6MTY4NjAzOTY3MiwiaXNzIjoiaHR0cHM6Ly9vYXV0aC5mYXRzZWNyZXQuY29tIiwiYXVkIjoicHJlbWllciIsImNsaWVudF9pZCI6IjQ3NTM2ZTZkZGRhZDQwMjlhNTM4MDNlNjQ3ZjYxN2ExIiwic2NvcGUiOlsicHJlbWllciJdfQ.B2GXPihvzK_-WBIVgp9V44hTQiYfpkmCoLqjQCFEYzALLVQSN5BLNxEACX4vtCdFt1AadhZD7xAZY2KRVg4ZNDXCDC7RzhqY5BM8D4Yuvv4kYDp7FxZf9y_0CKh0CrkfBUUetNYx0MSnw7pRLmwMray7UdfQCgHcqj4cx2UN70iaAZsy5kgdVYs8niGMGbP-tC9V3GefvOBvCsHUepmF6sOa1S4el_sDtzd7WiTWtS2TlKBkb3BO8_9dNxjiO9MPHr-Lug83qpmLq1UMjUE_obdqUNNmYqYxRdJpsaw3B04jOETfiF2dan-4LbSo8rFXm-fwIU_bdOAlBG3RgfA13A";

const multer = Multer({
  storage: Multer.MemoryStorage,
  fileSize: 5 * 1024 * 1024,
});

// All the main route
router.get("/users", async (req, res) => {
  try {
    const snapshot = await db.collection("users").get();

    const users = await Promise.all(
        snapshot.docs.map(async (doc) => {
          const userId = doc.id;
          const userData = doc.data();

          const chartSnapshot = await doc.ref.collection("chart").get();
          const chartData = chartSnapshot.empty ? [] : chartSnapshot.docs.map((chartDoc) => chartDoc.data());
          const orderedChartData = chartData.map((chartItem) =>
            orderFields(chartItem, orderedFields.chart),
          );


          const transactionSnapshot = await doc.ref.collection("transaction").get();
          const transactionData = transactionSnapshot.empty ? [] : transactionSnapshot.docs.map((transactionDoc) => transactionDoc.data());
          const orderedTransactionData = transactionData.map((transactionItem) =>
            orderFields(transactionItem, orderedFields.transaction),
          );

          const orderedData = orderFields(userData, orderedFields.user);
          const userWithChart = {id: userId, ...orderedData, chart: orderedChartData, transaction: orderedTransactionData};

          return userWithChart;
        }),
    );
    res.status(200).send(JSON.stringify(users));
  } catch (error) {
    console.error("Error fetching users:", error);
    res.status(500).json({error: "Failed to fetch users"});
  }
});

router.get("/stores", async (req, res) => {
  const snapshot = await db.collection("stores").get();

  const stores = [];
  snapshot.forEach((doc) => {
    const id = doc.id;
    const data = doc.data();
    const orderedData = orderFields(data, orderedFields.store);

    stores.push({id, ...orderedData});
  });
  res.status(200).send(JSON.stringify(stores));
});

router.get("/products", async (req, res) => {
  const snapshot = await db.collection("products").get();

  const products = [];
  snapshot.forEach((doc) => {
    const id = doc.id;
    const data = doc.data();
    const orderedData = orderFields(data, orderedFields.product);

    products.push({id, ...orderedData});
  });
  res.status(200).send(JSON.stringify(products));
});

router.get("/transactions", async (req, res) => {
  const snapshot = await db.collection("transactions").get();

  const transactions = [];
  snapshot.forEach((doc) => {
    const id = doc.id;
    const data = doc.data();
    const orderedData = orderFields(data, orderedFields.transaction);

    transactions.push({id, ...orderedData});
  });
  res.status(200).send(JSON.stringify(transactions));
});

router.get("/user/:id", async (req, res) => {
  try {
    const userId = req.params.id;

    const userRef = db.collection("users").doc(userId);
    const userSnapshot = await userRef.get();

    if (!userSnapshot.exists) {
      return res.status(404).json({error: "User not found"});
    }

    const userData = userSnapshot.data();

    const chartSnapshot = await userRef.collection("chart").get();
    const chartData = chartSnapshot.docs.map((doc) => doc.data());

    const responseData = orderFields(userData, orderedFields.user);

    orderedFields.user.forEach((field) => {
      responseData[field] = field === "chart" ? chartData : userData[field];
    });
    return res.status(200).json(responseData);
  } catch (error) {
    console.error("Error fetching user data:", error);
    return res.status(500).json({error: "Failed to fetch user data"});
  }
});

router.get("/store/:id", async (req, res) => {
  try {
    const storeId = req.params.id;

    const storeRef = db.collection("stores").doc(storeId);
    const storeSnapshot = await storeRef.get();

    if (!storeSnapshot.exists) {
      return res.status(404).json({error: "store not found"});
    }

    const storeData = storeSnapshot.data();

    const responseData = orderFields(storeData, orderedFields.store);
    orderedFields.store.forEach((field) => {
      responseData[field] = field === "marker" ? storeData.marker : storeData[field];
    });

    return res.status(200).json(responseData);
  } catch (error) {
    console.error("Error fetching store data:", error);
    return res.status(500).json({error: "Failed to fetch store data"});
  }
});

router.get("/product/:id", async (req, res) => {
  try {
    const productId = req.params.id;

    const productRef = db.collection("products").doc(productId);
    const productSnapshot = await productRef.get();

    if (!productSnapshot.exists) {
      return res.status(404).json({error: "product not found"});
    }

    const productData = productSnapshot.data();

    const responseData = orderFields(productData, orderedFields.product);

    return res.status(200).json(responseData);
  } catch (error) {
    console.error("Error fetching product data:", error);
    return res.status(500).json({error: "Failed to fetch product data"});
  }
});

// router.get("/transaction/:id", middleware_function, async (req, res) => {
router.get("/transaction/:id", async (req, res) => {
  try {
    const transactionId = req.params.id;

    const transactionRef = db.collection("transactions").doc(transactionId);
    const transactionSnapshot = await transactionRef.get();

    if (!transactionSnapshot.exists) {
      return res.status(404).json({error: "transaction not found"});
    }

    const transactionData = transactionSnapshot.data();

    // Build the ordered response data
    const responseData = orderFields(transactionData, orderedFields.transaction);

    return res.status(200).json(responseData);
  } catch (error) {
    console.error("Error fetching transaction data:", error);
    return res.status(500).json({error: "Failed to fetch transaction data"});
  }
});

router.post("/user", multer.single("photo"), imgUpload.uploadToGcs("Users"), async (req, res) => {
  const {
    user_name,
    user_email,
    user_password,
    user_phone_number,
    user_address,
    user_role,
  } = req.body;

  let user_imageUrl = "";

  if (req.file && req.file.cloudStoragePublicUrl) {
    user_imageUrl = req.file.cloudStoragePublicUrl;
  }

  try {
    const user = {
      user_name,
      user_email,
      user_password,
      user_phone_number,
      user_address,
      user_role,
      user_imageUrl,
    };
    const docRef = await db.collection("users").add(user);
    res.status(201).send({message: "User Added!", user_id: docRef.id});
  } catch (error) {
    console.error("Error adding user:", error);
    res.status(500).send("Error adding user");
  }
});

router.post("/store", multer.single("photo"), imgUpload.uploadToGcs("Stores"), async (req, res) => {
  const {
    store_name,
    store_product,
    store_location,
    store_address,
    store_description,
  } = req.body;

  let store_imageUrl = "";

  if (req.file && req.file.cloudStoragePublicUrl) {
    store_imageUrl = req.file.cloudStoragePublicUrl;
  }

  try {
    const store = {
      store_name,
      store_product,
      store_location,
      store_address,
      store_imageUrl,
      store_description,
    };
    const docRef = await db.collection("stores").add(store);
    res.status(201).send({message: "Store Added!", store_id: docRef.id});
  } catch (error) {
    console.error("Error adding store:", error);
    res.status(500).send("Error adding store");
  }
});

router.post("/product", multer.single("photo"), imgUpload.uploadToGcs("Products"), async (req, res) => {
  const {
    product_name,
    product_unit_price,
    product_stock,
    product_category,
    product_description,
    product_rating,
  } = req.body;

  let product_imageUrl = "";

  if (req.file && req.file.cloudStoragePublicUrl) {
    product_imageUrl = req.file.cloudStoragePublicUrl;
  }

  try {
    const product = {
      product_name,
      product_unit_price,
      product_stock,
      product_imageUrl,
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

router.post("/transaction", async (req, res) => {
  const {
    id_user,
    id_product,
    product_unit_price,
    total_product,
    payment_method,
    transaction_status,
    shipping_address,
    transaction_notes,
  } = req.body;

  const transaction_date = moment().format("YYYY-MM-DD HH:mm:ss");
  const total_price = product_unit_price * total_product;

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

router.put("/user/:id", async (req, res) => {
  const body = req.body;

  try {
    await db.collection("users").doc(req.params.id).update(body);
    const user_id = req.params.id;
    res.status(200).send({message: `User id : ${user_id} updated!`});
  } catch (error) {
    console.error("Error updating user:", error);
    res.status(400).send("Error updating user");
  }
});

router.put("/store/:id", async (req, res) => {
  const body = req.body;

  try {
    await db.collection("stores").doc(req.params.id).update(body);
    const store_id = req.params.id;
    res.status(200).send({message: `Store id : ${store_id} updated!`});
  } catch (error) {
    console.error("Error updating store:", error);
    res.status(400).send("Error updating store");
  }
});

router.put("/product/:id", async (req, res) => {
  const body = req.body;

  try {
    await db.collection("products").doc(req.params.id).update(body);
    const product_id = req.params.id;
    res.status(200).send({message: `product id : ${product_id} updated!`});
  } catch (error) {
    console.error("Error updating product:", error);
    res.status(400).send("Error updating product");
  }
});

router.put("/transaction/:id", async (req, res) => {
  const body = req.body;
  try {
    await db.collection("transactions").doc(req.params.id).update(body);
    const transaction_id = req.params.id;
    res.status(200).send({message: `transaction id : ${transaction_id} updated!`});
  } catch (error) {
    console.error("Error updating transaction:", error);
    res.status(400).send("Error updating transaction");
  }
});

router.delete("/user/:id", async (req, res) => {
  try {
    await admin.firestore().collection("users").doc(req.params.id).delete();
    const user_id = req.params.id;
    res.status(200).send({message: `User id : ${user_id} deleted!`});
  } catch (error) {
    console.error("Error deleting user", error);
    res.status(400).send("error deleting user");
  }
});

router.delete("/store/:id", async (req, res) => {
  try {
    await admin.firestore().collection("stores").doc(req.params.id).delete();
    const store_id = req.params.id;
    res.status(200).send({message: `Store id : ${store_id} deleted!`});
  } catch (error) {
    console.error("Error deleting user", error);
    res.status(400).send("error deleting user");
  }
});

router.delete("/product/:id", async (req, res) => {
  try {
    await admin.firestore().collection("products").doc(req.params.id).delete();
    const product_id = req.params.id;
    res.status(200).send({message: `Product id : ${product_id} deleted!`});
  } catch (error) {
    console.error("Error deleting product", error);
    res.status(400).send("error deleting product");
  }
});

router.delete("/transaction/:id", async (req, res) => {
  try {
    await admin.firestore().collection("transactions").doc(req.params.id).delete();
    const transaction_id = req.params.id;
    res.status(200).send({message: `transaction id : ${transaction_id} deleted!`});
  } catch (error) {
    console.error("Error deleting transaction", error);
    res.status(400).send("error deleting transaction");
  }
});

// Adding Chart & Transaction collection inside users collection
router.post("/user/:userId/chart", async (req, res) => {
  try {
    const userId = req.params.userId;
    const {product_id, quantity, payment_method} = req.body;

    const productDoc = await db.collection("products").doc(product_id).get();
    if (!productDoc.exists) {
      return res.status(404).send("Product not found");
    }

    const productData = productDoc.data();
    const unitPrice = productData.product_unit_price;
    const totalPrice = unitPrice * quantity;

    const userRef = db.collection("users").doc(userId);
    const chartRef = userRef.collection("chart").doc();

    const chartData = {
      product_id,
      product_name: productData.product_name,
      product_unit_price: productData.product_unit_price,
      product_rating: productData.product_rating,
      product_description: productData.product_description,
      quantity,
      payment_method,
      total_price: totalPrice,
    };

    await chartRef.set(chartData);

    return res.status(201).json({message: "Chart created successfully"});
  } catch (error) {
    console.error("Error creating chart:", error);
    return res.status(500).json({error: "Failed to create chart"});
  }
});

router.get("/user/:userId/chart", async (req, res) => {
  try {
    const userId = req.params.userId;

    const userRef = db.collection("users").doc(userId);
    const chartQuerySnapshot = await userRef.collection("chart").get();

    const chartData = [];
    chartQuerySnapshot.forEach((doc) => {
      chartData.push(doc.data());
    });
    const orderedChartData = chartData.map((chartItem) =>
      orderFields(chartItem, orderedFields.chart),
    );

    return res.status(200).json(orderedChartData);
  } catch (error) {
    console.error("Error fetching chart data:", error);
    return res.status(500).json({error: "Failed to fetch chart data"});
  }
});

router.post("/user/:userId/transaction", async (req, res) => {
  try {
    const userId = req.params.userId;
    const {
      product_id,
      quantity,
      payment_method,
      transaction_status,
      shipping_address,
      transaction_notes,
    } = req.body;

    const productDoc = await db.collection("products").doc(product_id).get();
    if (!productDoc.exists) {
      return res.status(404).send("Product not found");
    }

    const productData = productDoc.data();
    const unitPrice = productData.product_unit_price;
    const totalPrice = unitPrice * quantity;

    const userRef = db.collection("users").doc(userId);
    const transactionRef = userRef.collection("transaction").doc();

    const transactionData = {
      user_id: userId,
      product_id,
      product_name: productData.product_name,
      product_unit_price: productData.product_unit_price,
      product_description: productData.product_description,
      quantity,
      payment_method,
      total_price: totalPrice,
      transaction_status,
      shipping_address,
      transaction_notes,
    };

    await transactionRef.set(transactionData);

    return res.status(201).json({message: "transaction created successfully"});
  } catch (error) {
    console.error("Error creating transaction:", error);
    return res.status(500).json({error: "Failed to create transaction"});
  }
});

router.get("/user/:userId/transaction", async (req, res) => {
  try {
    const userId = req.params.userId;

    const userRef = db.collection("users").doc(userId);
    const transactionQuerySnapshot = await userRef.collection("transaction").get();

    const transactionData = [];
    transactionQuerySnapshot.forEach((doc) => {
      transactionData.push(doc.data());
    });
    const orderedTransactionData = transactionData.map((transactionItem) =>
      orderFields(transactionItem, orderedFields.transaction),
    );

    return res.status(200).json(orderedTransactionData);
  } catch (error) {
    console.error("Error fetching transaction data:", error);
    return res.status(500).json({error: "Failed to fetch transaction data"});
  }
});

// Accessing fatsecret API (Testing)
router.get("/fatsecret/product/:id", async (req, res) => {
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

router.get("/fatsecret/products/:name", async (req, res) => {
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
        res.status(200).json(response.data);
      })
      .catch((error) => {
        console.error("Error fetching products:", error.message);
        res.status(500).json({error: "Failed to fetch products"});
      });
});

module.exports = router;
