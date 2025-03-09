
import Link from 'next/link'
import Image from "next/image";
import React from 'react'

const CartBtn = () => {
  return (
    <Link href={"/cart"} className='bg-gray-10 p-3 rounded-lg'>
        <Image
        priority
        src="/icons/cart.svg"
        height={100}
        width={100}
        alt="cart"
        className="max-w-[16px] max-h-[16px]"
      />
    </Link>
  )
}

export default CartBtn