const admin = require("firebase-admin");

admin.initializeApp({
  ignoreUndefinedProperties: true,
});

const db = admin.firestore();

const orderedFields = {
  product: [
    "product_name",
    "product_category",
    "product_stock",
    "product_unit_price",
    "product_rating",
    "product_description",
    "product_photo",
  ],
  user: [
    "user_name",
    "user_email",
    "user_password",
    "user_role",
    "user_phone_number",
    "user_address",
    "user_imageUrl",
    "user_photo",
    "chart",
  ],
  chart: [
    "product_id",
    "product_name",
    "product_unit_price",
    "product_rating",
    "product_description",
    "quantity",
    "payment_method",
    "total_price",
  ],
  store: [
    "store_name",
    "store_product",
    "store_category",
    "store_description",
    "store_rating",
    "store_location",
    "store_address",
    "store_photo",
    "marker",
  ],
  transaction: [
    "user_id",
    "product_id",
    "transaction_date",
    "product_unit_price",
    "total_product",
    "total_price",
    "payment_method",
    "transaction_status",
    "shipping_address",
    "transaction_notes",
  ],
};

const orderFields = (data, order) => {
  const orderedData = {};

  order.forEach((field) => {
    orderedData[field] = data[field];
  });

  return orderedData;
};

module.exports = {
  db,
  orderedFields,
  orderFields,
};
