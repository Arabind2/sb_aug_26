import Header from "./components/Header";
import ExpenseForm from "./components/Expenseform";
import Summary from "./components/Summary";
import ExpenseList from "./components/ExpenseList";
import Footer from "./components/Footer";
import { useEffect, useState } from "react";
import axios from "axios";
import expenceService from "./services/expenceService";

export default function App() {
  const [expenses, setExpenses] = useState([])

  const [editingExpence , setEditingExpence]=useState(null)
  const getExpenses = async () => {
    try {
      const response = await expenceService.getExpences()
      setExpenses(response.data)
    } catch(err) {
      console.log("Some Error occurred:-", err)
    }
  }

  useEffect(() => {
    getExpenses()
  }, [])

  return (
    <div className="min-h-screen bg-gray-100">
      <Header />

      <main className="max-w-4xl mx-auto py-4 mt-4">
        <ExpenseForm 
        getExpenses={getExpenses} 
        editingExpence={editingExpence} 
        setEditingExpence={setEditingExpence}
        />
        <Summary expenses={expenses} />
<ExpenseList 
  expenses={expenses} 
    getExpenses={getExpenses} 
    setEditingExpence={setEditingExpence}
    />    
      </main>

      {/* Footer */}
      <Footer />
    </div>
  )
}