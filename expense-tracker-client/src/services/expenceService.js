import axios from "axios"

const BASE_URL='http://localhost:8080/expenses'

const expenceService={
     getExpences: ()=>{
    return axios.get(BASE_URL)
},
deleteExpense: (id)=>{
    return axios.delete(BASE_URL + `/${id}`)
},
createExpense:(expence)=>{
    return axios.post(BASE_URL, expence)
},
updateExpense: (expence)=>{
    return axios.put(BASE_URL,expence)
}
}


export default expenceService