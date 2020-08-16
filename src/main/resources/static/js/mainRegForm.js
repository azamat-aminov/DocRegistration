function validateRegNum() {
    const x = document.forms["myForm"]["registerNumber"].value;
    let hasDigit = false;
    hasDigit = new RegExp("\\d").test(x);
    console.log("ValidateRegNum works too");
    if (!hasDigit) {
        alert("Регистрационный номер не может состоять только из букв или специальных символов!")
    }
    return hasDigit;
}

function compareDate() {
    let periodOfExecution = document.getElementById("executionPeriod").value;
    if (periodOfExecution) {
        let dateRegistration = document.getElementById("registerDate").value;
        let isValidDeadLine = new Date(periodOfExecution) > new Date(dateRegistration);
        if (!isValidDeadLine) {
            alert("Срок исполнения не может быть раньше даты регистрации документа!")
        }
        return isValidDeadLine;
    } else {
        return true;
    }
}

function validateSize(file) {
    console.log("validateSize()");
    const fileSize = file.files[0].size / 1024 / 1024; // in MB
    if (fileSize > 1) {
        alert("Размер файла превышает 1 МБ. Пожалуйста, выберите файл размером менее 1 МБ!");
        file.value = "";
        return false;
    } else {
        return true;
    }
}

function validateExtension() {
    console.log("validateExtension()");
    const fileName = document.getElementById("file");
    if (fileName.value.endsWith(".doc") || fileName.value.endsWith(".pdf") || fileName.value.endsWith(".docx")) {
        return true;
    } else {
        alert("Неправильное расширение файла!")
        fileName.value = "";
        return false;
    }
}

function validateAll() {
    let isValidRegistrationNumber = validateRegNum();
    let isValidDeadLine = compareDate();

    return isValidDeadLine && isValidRegistrationNumber;
}

function validateFile(file) {
    let isValidExtension = validateExtension()
    let isValidFileSize = validateSize(file);

    return isValidExtension && isValidFileSize;
}