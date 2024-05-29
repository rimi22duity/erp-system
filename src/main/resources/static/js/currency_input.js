let selectedCurrency = document.getElementById("CurrencyDropdownMenu");
let elements = document.getElementsByClassName("currencySign");

selectedCurrency.addEventListener('change', () => {
    let selectedIndex = selectedCurrency.selectedIndex;
    console.log(selectedIndex)
    for(let i = 0; i<elements.length; i++) {
        elements[i].innerHTML = selectedCurrency.options[selectedIndex].value;
    }
})
