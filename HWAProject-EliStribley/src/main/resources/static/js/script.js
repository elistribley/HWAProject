'use strict';



let creReq = () => {
    axios.get("https://localhost:8999/pokemon/create")
        .then((response) => {
            
            results(response.data.data);
        } )
        .catch((error) => {
            console.error(error);
        });
    }
let getReq = () => {
    axios.get("https://localhost:8999/pokemon/getAll")
        .then((response) => {
            
            console.log(response);
        } )
        .catch((error) => {
            console.error(error);
        });
    }
let updReq = () => {
    axios.get("https://localhost:8999/pokemon/update")
        .then((response) => {
            
            console.log(response);
        } )
        .catch((error) => {
            console.error(error);
        });
    }
let delReq = () => {
    axios.get("https://localhost:8999/pokemon/delete")
        .then((response) => {
            
            console.log(response);
        } )
        .catch((error) => {
            console.error(error);
        });
    }