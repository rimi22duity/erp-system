let salaryInputRange = document.getElementById("salaryRange");
let currentSalaryLabel = document.getElementById("currentSalary");

currentSalaryLabel.innerText = "৳" + salaryInputRange.valueAsNumber + "K";

salaryInputRange.addEventListener('change', () => {
    currentSalaryLabel.innerText = "৳" + salaryInputRange.valueAsNumber + "K";
})