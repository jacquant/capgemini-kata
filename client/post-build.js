const fs = require("fs-extra");
fs.move("dist/client/browser", "../src/main/resources/public", (err) => {
  if (err) {
    return console.error(err);
  }
});
