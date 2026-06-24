let counter = 1;
setInterval(() => {
  document.getElementById('slide' + counter).checked = true;
  counter++;
  if (counter > 3) counter = 1;
}, 3000); 