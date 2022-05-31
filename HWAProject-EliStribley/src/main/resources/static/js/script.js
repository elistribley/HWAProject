'use strict';

let resultsDiv = document.querySelector("#resultDiv");

let nameDiv = document.querySelector("#inputOne");
let typeDiv = document.querySelector("#inputTwo");
let moveOneDiv = document.querySelector("#inputThree");
let moveTwoDiv = document.querySelector("#inputFour");


let postBtn = document.querySelector("#post");
let getBtn = document.querySelector("#get");
let putBtn = document.querySelector("#put");
let deleteBtn = document.querySelector("#delete");


let add = () => {
    let valueOne = inputOne.value;
    let valueTwo = inputTwo.value;
    let valueThree = inputThree.value;
    let valueFour = inputFour.value;

    let valueOneDiv = document.createElement("div");
    let myValue = document.createTextNode(`${valueOne} ${valueTwo} ${valueThree} ${valueFour}`)

    valueOneDiv.appendChild(myValue);
    resultsDiv.appendChild(valueOneDiv);
}



let creReq = () => {

    let obj = {
        "name":inputOne.value,
        "type":inputTwo.value,
        "moveOne":inputThree.value,
        "moveTwo":inputFour.value
    }
    axios.post("https://localhost:8999/pokemon/create", obj)
        .then((response) => {
            
            displayResult(response.data);
        } )
        .catch((error) => {
            console.error(error);
        });
    }
    



let getReq = () => {
    axios.get("https://localhost:8999/pokemon/getAll")
        .then((response) => {
            
            displayResult(response.data);
        } )
        .catch((error) => {
            console.error(error);
        });
    }



let updReq = () => {
    axios.put("https://localhost:8999/pokemon/update")
        .then((response) => {
            
            console.log(response);
        } )
        .catch((error) => {
            console.error(error);
        });
    }
let delReq = () => {
    axios.delete("https://localhost:8999/pokemon/delete")
        .then((response) => {
            
            console.log(response);
        } )
        .catch((error) => {
            console.error(error);
        });
    }



let displayResults = (data) => {
    for (let entry of data) {
        const p = document.createElement("p");
        const text = document.createTextNode(`${entry.id} | Name: ${entry.name} | Type: ${entry.type} | Move One: ${entry.moveOne} | Move Two: ${entry.moveTwo}`);

        p.appendChild(text);
        resultsDiv.appendChild(p);
    }
}  

    getBtn.addEventListener("click", creReq);
    postBtn.addEventListener("click", getReq);
    putBtn.addEventListener("click", updReq);
    deleteBtn.addEventListener("click", delReq);