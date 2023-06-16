import React from 'react';


const AboutUs = () => {
  return (
<div className="p-4 lg:p-8 dark:bg-gray-800 dark:text-gray-100">
  <div>
    <h2 className="text-3xl font-bold tracking-wide text-center sm:text-5xl dark:text-gray-50">About Us</h2>
  </div>
  
  <div className="container max-w-5xl mx-auto py-24">
    <div className="flex flex-col overflow-hidden rounded-md shadow-sm lg:flex-row py-12 bg-green-100 dark:bg-gray-900">
      
      <img src="/banner.jpg" alt="" className="h-80 dark:bg-gray-500 aspect-video" />
      <div className="flex flex-col justify-center flex-1 p-6">
        <span className="text-xs uppercase text-green-700 dark:text-gray-400">Join, it's free</span>
        <h3 className="text-3xl font-bold text-green-900">We're not reinventing the wheel</h3>
        <p className="my-6 text-green-800 dark:text-gray-400">Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolor aliquam possimus quas, error esse quos.</p>
      
      </div>
    </div>
    <div className="flex flex-col overflow-hidden rounded-md shadow-sm lg:flex-row-reverse py-12 bg-green-200 dark:bg-gray-900">
      <img src="/banner.jpg" alt="" className="h-80 dark:bg-gray-500 aspect-video" />
      <div className="flex flex-col justify-center flex-1 p-6">
        <span className="text-xs uppercase text-green-700 dark:text-gray-400">Join, it's free</span>
        <h3 className="text-3xl font-bold text-green-900">We're not reinventing the wheel</h3>
        <p className="my-6 text-green-800 dark:text-gray-400">Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolor aliquam possimus quas, error esse quos.</p>
       
      </div>
    </div>
    <div className="flex flex-col overflow-hidden rounded-md shadow-sm lg:flex-row py-12 bg-green-100 dark:bg-gray-900">
      <img src="/banner.jpg" alt="" className="h-80 dark:bg-gray-500 aspect-video" />
      <div className="flex flex-col justify-center flex-1 p-6">
        <span className="text-xs uppercase text-green-700 dark:text-gray-400">Join, it's free</span>
        <h3 className="text-3xl font-bold text-green-900">We're not reinventing the wheel</h3>
        <p className="my-6 text-green-800 dark:text-gray-400">Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolor aliquam possimus quas, error esse quos.</p>
       
      </div>
    </div>
  </div>
</div>


  );
};

export default AboutUs;
