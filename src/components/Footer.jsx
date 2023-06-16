import React from 'react'
function Footer() {
    return (
<footer className="bg-white dark:bg-gray-900">
  <div className="mx-auto w-full max-w-screen-xl p-4 py-6 lg:py-8">
    <div className="md:flex md:justify-between">
      <div className="mb-6 md:mb-0">
        <a href="" className="flex items-center">
          <img
            src="/FG.svg"
            className="w-24"
            alt=""
          />
          <span className="self-center text-2xl font-semibold whitespace-nowrap dark:text-white">
            FreshGrocie
          </span>
        </a>
      </div>
      <div className="grid grid-cols-2 gap-8 sm:gap-6 sm:grid-cols-3">
        <div>
          <h2 className="mb-6 text-sm font-semibold text-gray-900 uppercase dark:text-white">
            FreshGrocie
          </h2>
          <ul className="text-gray-600 dark:text-gray-400 font-medium">
            <li className="mb-4">
              <a href="https://flowbite.com/" className="hover:underline">
                Our Partmers
              </a>
            </li>
            <li>
              <a href="https://tailwindcss.com/" className="hover:underline">
                Features
              </a>
            </li>
          </ul>
        </div>
        <div>
          <h2 className="mb-6 text-sm font-semibold text-gray-900 uppercase dark:text-white">
            Follow us
          </h2>
          <ul className="text-gray-600 dark:text-gray-400 font-medium">
            <li className="mb-4">
              <a
                href="https://github.com/themesberg/flowbite"
                className="hover:underline"
              >
                Github
              </a>
            </li>
            <li>
              <a href="https://discord.gg/4eeurUVvTy" className="hover:underline">
                Discord
              </a>
            </li>
          </ul>
        </div>
        <div>
          <h2 className="mb-6 text-sm font-semibold text-gray-900 uppercase dark:text-white">
            Legal
          </h2>
          <ul className="text-gray-600 dark:text-gray-400 font-medium">
            <li className="mb-4">
              <a href="#" className="hover:underline">
                Privacy Policy
              </a>
            </li>
            <li>
              <a href="#" className="hover:underline">
                Terms &amp; Conditions
              </a>
            </li>
          </ul>
        </div>
      </div>
    </div>
    <hr className="my-6 border-gray-200 sm:mx-auto dark:border-gray-700 lg:my-8" />
    <div className="sm:flex sm:items-center sm:justify-between">
      <span className="text-sm text-gray-500 sm:text-center dark:text-gray-400">
        © 2023{" "}
        <a href="https://flowbite.com/" className="hover:underline">
          FreshGrocie™
        </a>
        . All Rights Reserved.
      </span>
      <div className="flex mt-4 space-x-6 sm:justify-center sm:mt-0">
        
      </div>
    </div>
  </div>
</footer>


    );
  }
  
  export default Footer;
  