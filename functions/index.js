const functions = require("firebase-functions");
const express = require("express");
const cors = require("cors");

const admin = require("firebase-admin");
admin.initializeApp();
const db = admin.firestore();

const app = express();

app.use(cors({origin: true}));

//Signup route
app.post('/signup', async (req, res) => {
  const { user_email, user_password } = req.body;
  
  try {
    const userRecord = await admin.auth().createUser({
      email: user_email,
      password: user_password,
    });
    
    const user = {
      uid: userRecord.uid,
      user_email: userRecord.email,
      
    };

    await db.collection('users').doc(user.uid).set(user);
    
    res.json({ message: 'Signup successful!', user });
  } catch (error) {
    res.status(400).json({ message: 'Signup failed!', error });
  }
});









//Signin route
app.post('/signin', async (req, res) => {
  const { user_email, user_password } = req.body;
  
  try {
    const { user } = await admin.auth().signInWithEmailAndPassword(user_email, user_password);
    
    const userDoc = await db.collection('users').doc(user.uid).get();
    const userData = userDoc.data();
    
    res.json({ message: 'Signin successful!', user: userData });
  } catch (error) {
    res.status(400).json({ message: 'Signin failed!', error });
  }
});

// ...

// Profile route
// app.put('/profile', async (req, res) => {
//   const { user_password, user_email, user_name, user_address, user_phone_number } = req.body;

//   try {
//     const username = email.split('@')[0]; // Extract username from email
    
//     const profileData = {
//       user_email,
//       username,
//       user_name,
//       user_address,
//       user_phone_number,
//     };

//     await db.collection('users').doc(user_password).update(profileData);
//     res.json({ message: 'Profile updated successfully!' });
//   } catch (error) {
//     res.status(400).json({ message: 'Failed to update profile!', error });
//   }
// });

// ...





app.get("/", async (req, res) => {
  res.json({ status: "Fresh Grocie API ready!" });
});

app.get("/users", async (req, res) => {
  const snapshot = await db.collection("users").get();

  const users = [];
  snapshot.forEach((doc) => {
    const id = doc.id;
    const data = doc.data();

    users.push({ id, ...data });
  });
  res.status(200).send(JSON.stringify(users));
});

app.get("/stores", async (req, res) => {
  const snapshot = await db.collection("stores").get();

  const stores = [];
  snapshot.forEach((doc) => {
    const id = doc.id;
    const data = doc.data();

    stores.push({ id, ...data });
  });
  res.status(200).send(JSON.stringify(stores));
});

app.get("/products", async (req, res) => {
  const snapshot = await db.collection("products").get();

  const products = [];
  snapshot.forEach((doc) => {
    const id = doc.id;
    const data = doc.data();

    products.push({ id, ...data });
  });
  res.status(200).send(JSON.stringify(products));
});

app.get("/transactions", async (req, res) => {
  const snapshot = await db.collection("transactions").get();

  const transactions = [];
  snapshot.forEach((doc) => {
    const id = doc.id;
    const data = doc.data();

    transactions.push({ id, ...data });
  });
  res.status(200).send(JSON.stringify(transactions));
});

app.get("/user/:id", async (req, res) => {
  const snapshot = await db.collection("users").doc(req.params.id).get();

  const userId = snapshot.id;
  const userData = snapshot.data();

  res.status(200).send(JSON.stringify({ id: userId, ...userData }));
});

app.get('/users/:key', async (req, resp) => {
  const key = req.params.key;

  try {
    const snapshot = await db.collection('users')
      .where('user_name', '>=', key)
      .where('user_name', '<=', key + '\uf8ff')
      .get();

    const data = snapshot.docs.map((doc) => doc.data());
    resp.send(data);
  } catch (error) {
    console.error('Error fetching documents:', error);
    resp.status(500).send('Error fetching documents');
  }
});

app.get("/store/:id", async (req, res) => {
  const snapshot = await db.collection("stores").doc(req.params.id).get();

  const userId = snapshot.id;
  const userData = snapshot.data();

  res.status(200).send(JSON.stringify({ id: userId, ...userData }));
});

app.get('/stores/:key', async (req, resp) => {
  const key = req.params.key;

  try {
    const snapshot = await db.collection('stores')
      .where('store_name', '>=', key)
      .where('store_name', '<=', key + '\uf8ff')
      .get();

    const data = snapshot.docs.map((doc) => doc.data());
    resp.send(data);
  } catch (error) {
    console.error('Error fetching documents:', error);
    resp.status(500).send('Error fetching documents');
  }
});

app.get("/product/:id", async (req, res) => {
  const snapshot = await db.collection("products").doc(req.params.id).get();

  const userId = snapshot.id;
  const userData = snapshot.data();

  res.status(200).send(JSON.stringify({ id: userId, ...userData }));
});

app.get('/products/:key', async (req, resp) => {
  const key = req.params.key;

  try {
    const snapshot = await db.collection('products')
      .where('product_name', '>=', key)
      .where('product_name', '<=', key + '\uf8ff')
      .get();

    const data = snapshot.docs.map((doc) => doc.data());
    resp.send(data);
  } catch (error) {
    console.error('Error fetching documents:', error);
    resp.status(500).send('Error fetching documents');
  }
});

app.get("/transaction/:id", async (req, res) => {
  const snapshot = await db.collection("transactions").doc(req.params.id).get();

  const userId = snapshot.id;
  const userData = snapshot.data();

  res.status(200).send(JSON.stringify({ id: userId, ...userData }));
});

app.get('/transactions/:key', async (req, resp) => {
  const key = req.params.key;

  try {
    const snapshot = await db.collection('transactions')
      .where('transaction_name', '>=', key)
      .where('transaction_name', '<=', key + '\uf8ff')
      .get();

    const data = snapshot.docs.map((doc) => doc.data());
    resp.send(data);
  } catch (error) {
    console.error('Error fetching documents:', error);
    resp.status(500).send('Error fetching documents');
  }
});

app.post("/user", async (req, res) => {
  const user = req.body;

  await db.collection("users").add(user);

  res.status(201).send();
});

app.post("/store", async (req, res) => {
  const store = req.body;

  await db.collection("stores").add(store);

  res.status(201).send();
});

app.post("/product", async (req, res) => {
  const product = req.body;

  await db.collection("products").add(product);

  res.status(201).send();
});

app.post("/transaction", async (req, res) => {
  const transaction = req.body;

  await db.collection("transactions").add(transaction);

  res.status(201).send();
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
  await db.collection("users").doc(req.params.id).delete();

  res.status(200).send();
});








app.delete("/store/:id", async (req, res) => {
  await db.collection("stores").doc(req.params.id).delete();

  res.status(200).send();
});

app.delete("/product/:id", async (req, res) => {
  await db.collection("products").doc(req.params.id).delete();

  res.status(200).send();
});

app.delete("/transaction/:id", async (req, res) => {
  await db.collection("transaction").doc(req.params.id).delete();

  res.status(200).send();
});

exports.user = functions.https.onRequest(app);
