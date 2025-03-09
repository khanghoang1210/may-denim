import React from 'react'
import Image from "next/image";
import CartBtn from './CartBtn'
import AccountBtn from './AccountBtn'
import InputGroup from "@/components/ui/input-group";
import { NavigationMenu, NavigationMenuList } from '@/components/ui/navigation-menu';
import { MenuItem } from './MenuItem';
import { MenuList } from './MenuList';

const data = [
    {
        id: 1,
        label: "Shop",
        type: "MenuList",
        children: [
          {
            id: 11,
            label: "Men's clothes",
            url: "/shop#men-clothes",
            description: "In attractive and spectacular colors and designs",
          },
          {
            id: 12,
            label: "Women's clothes",
            url: "/shop#women-clothes",
            description: "Ladies, your style and tastes are important to us",
          },
          {
            id: 13,
            label: "Kids clothes",
            url: "/shop#kids-clothes",
            description: "For all ages, with happy and beautiful colors",
          },
          {
            id: 14,
            label: "Bags and Shoes",
            url: "/shop#bag-shoes",
            description: "Suitable for men, women and all tastes and styles",
          },
        ],
      },
    {
      id: 2,
      type: "MenuItem",
      label: "On Sale",
      url: "/shop#on-sale",
      children: [],
    },
    {
      id: 3,
      type: "MenuItem",
      label: "New Arrivals",
      url: "/shop#new-arrivals",
      children: [],
    },
    {
      id: 4,
      type: "MenuItem",
      label: "Brands",
      url: "/shop#brands",
      children: [],
    },
  ];
const Navbar = () => {
  return (
    <nav className='top-0 z-20 sticky'>
        <div className='flex relative max-w-7xl mx-auto justify-between items-center  py-5  px-4 '>
            <p>May Denim</p>

            <NavigationMenu className="hidden md:flex mr-5 lg:mr-7">
                <NavigationMenuList>
                {data.map((item) => (
                    <React.Fragment key={item.id}>
                        <MenuItem label={item.label} url={item.url} />
                    </React.Fragment>
                ))}
                </NavigationMenuList>
            </NavigationMenu>
            <InputGroup className="hidden md:flex bg-gray-10 mr-3 lg:mr-10">
                <InputGroup.Text>
                    <Image
                    priority
                    src="/icons/search.svg"
                    height={20}
                    width={20}
                    alt="search"
                    className="min-w-5 min-h-5"
                    />
                </InputGroup.Text>
                <InputGroup.Input
                    type="search"
                    name="search"
                    placeholder="Search"
                    className="bg-transparent placeholder:text-black/40"
                />
            </InputGroup>
            <div className='flex items-end'>
                <AccountBtn/>
                <CartBtn/>
            </div>
        </div>
    </nav>
  )
}

export default Navbar