"use strict";
const {Storage} = require("@google-cloud/storage");
// const fs = require("fs");
const {format} = require("date-fns");
const path = require("path");

const pathKey = path.resolve("./object_creator.json");

// TODO: Sesuaikan konfigurasi Storage
const gcs = new Storage({
  projectId: "freshgrocie-capstone",
  keyFilename: pathKey,
});

// TODO: Tambahkan nama bucket yang digunakan
const bucketName = "freshgrocie-image-upload";
const bucket = gcs.bucket(bucketName);

// eslint-disable-next-line require-jsdoc
function getPublicUrl(filename) {
  return "https://storage.googleapis.com/" + bucketName + "/" + filename;
}

const ImgUpload = {};

ImgUpload.uploadToGcs = (req, res, next) => {
  if (!req.file) return next();

  const currentDate = new Date();
  const gcsname = format(currentDate, "yyyyMMdd-HHmmss") + "-" + req.file.originalname;
  const file = bucket.file(gcsname);

  const stream = file.createWriteStream({
    metadata: {
      contentType: req.file.mimetype,
    },
  });

  stream.on("error", (err) => {
    req.file.cloudStorageError = err;
    next(err);
  });

  stream.on("finish", () => {
    req.file.cloudStorageObject = gcsname;
    req.file.cloudStoragePublicUrl = getPublicUrl(gcsname);
    next();
  });

  stream.end(req.file.buffer);
};

module.exports = ImgUpload;
