
import Link from 'next/link'
import Image from "next/image";
import React from 'react'

const AccountBtn = () => {
  return (
    <Link href={"/account"} className='bg-gray-10 p-3 rounded-lg mr-3'>
        <Image
        priority
        src="/icons/account.svg"
        height={100}
        width={100}
        alt="account"
        className="max-w-[16px] max-h-[16px]"
      />
    </Link>
  )
}

export default AccountBtn