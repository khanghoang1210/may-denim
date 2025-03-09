import React from 'react'
import CartBtn from './CartBtn'
import AccountBtn from './AccountBtn'

const Navbar = () => {
  return (
    <nav className='top-0 z-20 sticky'>
        <div className='flex relative max-w-frame mx-auto justify-between px-4 py-5 items-center'>
            <p>May Denim</p>
            <div className='flex items-end'>
                <AccountBtn/>
                <CartBtn/>
            </div>
        </div>
    </nav>
  )
}

export default Navbar