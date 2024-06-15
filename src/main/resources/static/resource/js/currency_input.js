let selectedCurrency = document.getElementById("CurrencyDropdownMenu");
let elements = document.getElementsByClassName("currencySign");

selectedCurrency.addEventListener('change', () => {
    let selectedIndex = selectedCurrency.selectedIndex;
    console.log(selectedIndex)
    for(let i = 0; i<elements.length; i++) {
        var selectedCurrencyString = "";
        switch (selectedCurrency.options[selectedIndex].value) {
            case "BDT" :
                selectedCurrencyString = "৳";
                break;
            case "US_DOLLAR":
                selectedCurrencyString = "$";
                break;
        }

        elements[i].innerHTML = selectedCurrencyString;
    }
})
