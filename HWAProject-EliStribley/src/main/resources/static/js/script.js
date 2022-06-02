'use strict';

let resultsDiv = document.querySelector("#resultDiv");
let introDiv = document.querySelector("#introDiv")

let idDiv = document.querySelector('#inputZero');
let nameDiv = document.querySelector("#inputOne");
let typeDiv = document.querySelector("#inputTwo");
let moveOneDiv = document.querySelector("#inputThree");
let moveTwoDiv = document.querySelector("#inputFour");


let postBtn = document.querySelector("#post");
let getBtn = document.querySelector("#get");
let putBtn = document.querySelector("#put");
let deleteBtn = document.querySelector("#delete");


/*let add = () => {
    let valueOne = inputOne.value;
    let valueTwo = inputTwo.value;
    let valueThree = inputThree.value;
    let valueFour = inputFour.value;

    let valueOneDiv = document.createElement("div");
    let myValue = document.createTextNode(`${valueOne} ${valueTwo} ${valueThree} ${valueFour}`)

    valueOneDiv.appendChild(myValue);
    resultsDiv.appendChild(valueOneDiv);
}*/



let creReq = () => {
    let obj = {
        "name":inputOne.value,
        "type":inputTwo.value,
        "moveOne":inputThree.value,
        "moveTwo":inputFour.value
    }
    axios.post("http://localhost:8999/pokemon/create", obj)
        .then((response) => {
            
            getReq();
        } )
        .catch((error) => {
            console.error(error);
        });
    }
    



let getReq = () => {
    resultsDiv.innerHTML="";
    axios.get("http://localhost:8999/pokemon/getAll")
        .then((response) => {
            displayResults(response.data);
            
        } )
        .catch((error) => {
            console.error(error);
        });
    }

let getIdReq = (getById) => {
    axios.get(`http://localhost:8999/pokemon/getById/${idDiv.value}`)
    .then((response) => {
        id="";
        name="";
        type="";
        moveOne="";
        moveTwo="";
        displayResults;
    })
    .catch((error)=>{
        console.error(error);
    })
}

let updReq = () => {
    let obj = {
        "id":parseInt(inputZero.value),
        "name":inputOne.value,
        "type":inputTwo.value,
        "moveOne":inputThree.value,
        "moveTwo":inputFour.value
    }

    axios.put(`http://localhost:8999/pokemon/update/${idDiv.value}`, obj)
        .then((response) => {
            displayResults(response);
            getReq();
        }).catch((error)=>{
            console.error(error);
        })
}
let delReq = () => {
    
    axios.delete(`http://localhost:8999/pokemon/delete/${idDiv.value}`)
        .then((response) => {
            displayResults(response);
            getReq();
        } )
        .catch((error) => {
            console.error(error);
        });
    }



let displayResults = (data) => {
    getReq.innerHTML="";
    for (let entry of data) {
        const p = document.createElement("p");
        const text = document.createTextNode(`${entry.id} | Name: ${entry.name} | Type: ${entry.type} | Move One: ${entry.moveOne} | Move Two: ${entry.moveTwo}`);
        

        p.appendChild(text)
        resultsDiv.appendChild(p);
    }
}  



    postBtn.addEventListener("click", creReq);
    getBtn.addEventListener("click", getReq);
    putBtn.addEventListener("click", updReq);
    deleteBtn.addEventListener("click", delReq);