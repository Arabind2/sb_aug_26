import React from 'react'

const Expenseform = () => {
  return (
    <div className='bg-white rounded-2xl shadow-md  p-6 mb-6'>
    <h2 className='text-xl font-semibold text-gray-700 mb-4'> Add Expense</h2>

    <form action="#" className='grid grid-cols-1 md:grid-cols-2 gap-4'>
        <div>
            <label htmlFor="" className='block font-medium text-gray-600 mb-1' >Title</label>
            <input type="text" className='border w-full border-gray-300 rounded-lg px-3 py-2 focus:outline-none focus:border-blue-500' />
        </div>

        <div>
            <label htmlFor="" className='block font-medium text-gray-600 mb-1'>Category</label>
            <select type="text" className='border w-full border-gray-300 rounded-lg px-3 py-2 focus:outline-none focus:border-blue-500' >
                <option value="" selected>---Select category---</option>
                <option value="food">Food</option>
                <option value="travel">Travel</option>
                <option value="utilities">Utilities</option>
                <option value="shopping">Shopping</option>
                <option value="entertainment">Entertainment</option>
                <option value="health">Health</option>
                <option value="education">Education</option>
                <option value="others">Others</option>
                </select>
        </div>
     <div>
            <label htmlFor="" className='block font-medium text-gray-600 mb-1' >Price</label>
            <input type="text" className='border w-full border-gray-300 rounded-lg px-3 py-2 focus:outline-none focus:border-blue-500' />
        </div>

  <div>
            <label htmlFor="" className='block font-medium text-gray-600 mb-1' >Date</label>
            <input type="date" className='border w-full border-gray-300 rounded-lg px-3 py-2 focus:outline-none focus:border-blue-500' />
        </div>

    <div className='mt-5'>
        <button className='bg-blue-400 hover:bg-blue-500 px-3 py-2 rounded-lg text-white text-lg font-medium transition-colors-200'>Add Expense</button>
    </div>
    </form>


    </div>
  )
}

export default Expenseform