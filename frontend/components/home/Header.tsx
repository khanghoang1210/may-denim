import React from "react";
import * as motion from "framer-motion/client";
import Link from "next/link";
import { cn } from "@/lib/utils";

const Header = () => {
  return (
    <header className="relative w-full h-[600px] md:h-[650px] lg:h-[700px] overflow-hidden">
      {/* Background Image */}
      <motion.div
        initial={{ opacity: 0 }}
        whileInView={{ opacity: 1 }}
        viewport={{ once: true }}
        transition={{ duration: 1 }}
        className="absolute inset-0 w-full h-full bg-cover bg-top  bg-no-repeat"
        style={{ backgroundImage: "url('/images/hero1.png')" }}
      ></motion.div>

      {/* Remove dark overlay to match Image 1 */}
      {/* <div className="absolute inset-0 bg-black/40"></div> */}

      {/* Content Layout */}
      <div className="relative z-10 flex flex-col md:flex-row justify-center mr-10 items-center h-full px-6 md:px-12 lg:px-16">
        {/* Left Content */}
        <motion.div
          initial={{ x: "-100px", opacity: 0 }}
          whileInView={{ x: "0", opacity: 1 }}
          viewport={{ once: true }}
          transition={{ duration: 0.6 }}
          className="max-w-7xl text-left"
        >
          <h1 className="text-white text-3xl mb-10">T-Shirt / Tops</h1>
          <h2 className="text-white text-7xl md:text-5xl lg:text-6xl font-bold mb-10">
            Summer
            <p>Value Pack</p>
          </h2>
          <p className="text-white text-3xl  mb-10 lg:mb-8">
            cool / corlorful / comfy
          </p>
          <Link
            href="/shop"
            className="inline-block bg-white text-black font-semibold px-16 py-3 rounded-lg hover:bg-gray-200 transition"
          >
            Shop Now
          </Link>
        </motion.div>

        {/* Right Image - Keep character aligned properly */}
        <motion.div
          initial={{ x: "100px", opacity: 0 }}
          whileInView={{ x: "0", opacity: 1 }}
          viewport={{ once: true }}
          transition={{ delay: 0.3, duration: 0.6 }}
          className="w-full md:w-1/2 h-full flex justify-center items-center"
        ></motion.div>
      </div>
    </header>
  );
};

export default Header;
