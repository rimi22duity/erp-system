let presentAddressRoad = document.getElementById("presentAddressRoad");
let presentAddressThana = document.getElementById("presentAddressThana");
let presentAddressCity = document.getElementById("presentAddressCity");
let presentAddressDistrict = document.getElementById("presentAddressDistrict");
let presentAddressCode = document.getElementById("presentAddressCode");

let permanentAddressRoad = document.getElementById("permanentAddressRoad");
let permanentAddressThana = document.getElementById("permanentAddressThana");
let permanentAddressCity = document.getElementById("permanentAddressCity");
let permanentAddressDistrict = document.getElementById("permanentAddressDistrict");
let permanentAddressCode = document.getElementById("permanentAddressCode");

let sameAddressCheckBox = document.getElementById("sameAddressCheckBox");

console.log(presentAddressThana.innerHTML);

sameAddressCheckBox.addEventListener('change', () => {
    let isChecked = sameAddressCheckBox.checked;
    console.log(isChecked);
    console.log(presentAddressThana.innerText)
    permanentAddressRoad.value = isChecked ? presentAddressRoad.value : "";
    permanentAddressThana.value = isChecked ? presentAddressThana.value : "";
    permanentAddressCity.value = isChecked ? presentAddressCity.value : "";
    permanentAddressDistrict.value = isChecked ? presentAddressDistrict.value : "";
    permanentAddressCode.value = isChecked ? presentAddressCode.value : "";
})