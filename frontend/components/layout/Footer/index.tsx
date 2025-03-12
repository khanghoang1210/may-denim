import { cn } from "@/lib/utils";
import Link from "next/link";
import Image from "next/image";
import React from "react";
import { url } from "inspector";
import LinksSection from "./LinksSection";

const socialsData = [
  {
    id: 1,
    icon: "/icons/fb.svg",
    url: "https://www.facebook.com",
  },
  {
    id: 2,
    icon: "icons/insta.svg",
    url: "https://www.instagram.com",
  },
  {
    id: 3,
    icon: "/icons/linkedin.svg",
    url: "https://www.linkedin.com",
  },
];
const Footer = () => {
  return (
    <footer className="bg-gray-50 text-gray-10 bottom-0 ">
      <div className="pt-8 md:pt-[50px] text-gray-10 px-4 pb-4">
        <div className="max-w-7xl mx-auto">
          <nav className="lg:grid lg:grid-cols-12 mb-8">
            <div className="flex flex-col lg:col-span-3 lg:max-w-[248px]">
              <h1 className="text-2xl mb-5">May Denim</h1>
              <p className="text-sm mb-9">
                We have clothes that suits your style and which you’re proud to
                wear. From women to men.
              </p>
              <div className="flex items-center">
                {socialsData.map((social) => (
                  <Link
                    href={social.url}
                    key={social.id}
                    className="bg-gray-10 hover:bg-gray-30 hover:text-white transition-all mr-3 w-9 h-9 rounded-lg flex items-center justify-center p-1.5"
                  >
                    <Image
                      priority
                      src={social.icon}
                      width={33}
                      height={100}
                      alt="user"
                      className="max-h-[16px]"
                    />
                  </Link>
                ))}
              </div>
            </div>
            <div className="hidden lg:grid col-span-9 lg:grid-cols-4 lg:pl-10">
              <LinksSection />
            </div>
            <div className="grid lg:hidden grid-cols-2 sm:grid-cols-4">
              <LinksSection />
            </div>
          </nav>

          <div className="flex text-center justify-center items-center mb-2 ">
            <p className="text-sm text-center sm:text-left  mb-4 sm:mb-0 sm:mr-1">
              Copyright © 2025{" "}
              <Link
                href="https://github.com/mohammadoftadeh"
                className="font-medium"
              >
                May Denim
              </Link>
              {". "}
              Alls rights reserved.
            </p>
          </div>
        </div>
      </div>
    </footer>
  );
};

export default Footer;
