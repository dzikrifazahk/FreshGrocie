import React from 'react';
import Product1 from '../assets/vercel.png';
import Product2 from '../assets/vercel.png';
import Product3 from '../assets/facebook.png';

const BestSelling = () => {
    return (
      <div className="h-screen overflow-hidden flex items-center justify-center bg-green-100">
      <div className="py-16 bg-white">
        <div className="container m-auto px-6 space-y-8 md:px-12 lg:px-56">
          <div className="m-auto text-center lg:w-7/12">
            <h2 className="text-2xl text-green-800 font-bold md:text-4xl">Our Partners.</h2>
          </div>
          <div className="grid grid-cols-2 sm:grid-cols-3 md:grid-cols-4 gap-4">
            <div className="p-4">
              <img src="https://tailus.io/sources/blocks/company-site/preview/images/clients/airbnb.svg" className="" alt="" />
            </div>
            <div className="p-4">
              <img src="https://tailus.io/sources/blocks/company-site/preview/images/clients/client-8.png" className="w-32" alt="" />
            </div>
            <div className="p-4">
              <img src="https://tailus.io/sources/blocks/company-site/preview/images/clients/client-3.png" className="w-32" alt="" />
            </div>
            <div className="p-4">
              <img src="https://tailus.io/sources/blocks/company-site/preview/images/clients/client-1.png" className="w-32" alt="" />
            </div>
            <div className="p-4">
              <img src="https://tailus.io/sources/blocks/company-site/preview/images/clients/tailus.svg" className="w-32" alt="" />
            </div>
            <div className="p-4">
              <img src="https://tailus.io/sources/blocks/company-site/preview/images/clients/microsoft.svg" className="w-32" alt="" />
            </div>
            <div className="p-4">
              <img src="https://tailus.io/sources/blocks/company-site/preview/images/clients/coty.svg" className="w-20" alt="" />
            </div>
            <div className="p-4">
              <img src="https://tailus.io/sources/blocks/company-site/preview/images/clients/client-4.png" className="w-24" alt="" />
            </div>
          </div>
        </div>
      </div>
    </div>
    
    
    );
  };
  
  export default BestSelling;
  
