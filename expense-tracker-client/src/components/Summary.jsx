import React from 'react'

const Summary = () => {
  return (
    
    // Summary
        <div className='bg-white rounded-2xl shadow-md  p-6 mb-6'>
    <h2 className='text-xl font-semibold text-gray-700 mb-4'> Summary</h2>

{/* Total Expense */}
<div className='grid grid-cols-1 md:grid-cols-2 gap-4 '>
   <div className='bg-blue-50 border-blue-200 rounded-xl p-4'>
  <div className='text-3xl'>💶</div>
  <div>
    
      <p className=' font-medium text-gray-500 text-sm'>Total Expenses</p>
      <p className='text-2xl font-bold text-blue-600'>10000</p>
      </div>
    </div>
    
    {/* Entries */}

     <div className='bg-green-50 border-green-200 rounded-xl p-4'>
      <div className='text-3xl'>📓</div>
      <div>
      <p className=' font-medium text-gray-500 text-sm'>Total Entries</p>
      <p className='text-2xl font-bold text-green-600'>15</p>
      </div>
    </div>
</div>
    </div>
  )
}

export default Summary