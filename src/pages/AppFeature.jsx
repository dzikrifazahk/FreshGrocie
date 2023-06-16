import React from 'react';

const AppFeature = () => {
  return (
    <div className="dark:bg-gray-800 dark:text-gray-100 bg-green-50">
    <div className="container max-w-xl p-6 py-12 mx-auto space-y-24 lg:px-8 lg:max-w-7xl">
      <div>
        <h2 className="text-3xl font-bold tracking-wide text-center sm:text-5xl dark:text-gray-50">Our Features</h2>
       
      </div>
      <div className="grid lg:gap-8 lg:grid-cols-2 lg:items-center">
        <div>
         
          
          <div className="mt-12 space-y-12">
            <div className="flex">
              <div className="flex-shrink-0">
                <div className="flex items-center justify-center w-12 h-12 rounded-md bg-green-300 dark:bg-green-700 dark:text-gray-900">
                  <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor" className="w-7 h-7">
                    <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M5 13l4 4L19 7"></path>
                  </svg>
                </div>
              </div>
              <div className="ml-4">
                <h4 className="text-lg font-medium leading-none dark:text-gray-50">Detect Freshness</h4>
                
              </div>
            </div>
            <div className="flex">
              <div className="flex-shrink-0">
                <div className="flex items-center justify-center w-12 h-12 rounded-md bg-green-300 dark:bg-green-700 dark:text-gray-900">
                  <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor" className="w-7 h-7">
                    <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M5 13l4 4L19 7"></path>
                  </svg>
                </div>
              </div>
              <div className="ml-4">
                <h4 className="text-lg font-medium leading-none dark:text-gray-50">Fast Delivery</h4>
                
              </div>
            </div>
            <div className="flex">
              <div className="flex-shrink-0">
                <div className="flex items-center justify-center w-12 h-12 rounded-md bg-green-300 dark:bg-green-700 dark:text-gray-900">
                  <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor" className="w-7 h-7">
                    <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M5 13l4 4L19 7"></path>
                  </svg>
                </div>
              </div>
              <div className="ml-4">
                <h4 className="text-lg font-medium leading-none dark:text-gray-50">Multiple payment option</h4>
                
              </div>
              
            </div>
            <div className="flex">
              <div className="flex-shrink-0">
                <div className="flex items-center justify-center w-12 h-12 rounded-md bg-green-300 dark:bg-green-700 dark:text-gray-900">
                  <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor" className="w-7 h-7">
                    <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M5 13l4 4L19 7"></path>
                  </svg>
                </div>
              </div>
              <div className="ml-4">
                <h4 className="text-lg font-medium leading-none dark:text-gray-50">Show Nutrients</h4>
                
              </div>
              
            </div>
          </div>
        </div>
        <div aria-hidden="true" className="mt-10 lg:mt-0">
          <img src="/banner.jpg" alt="" className="mx-auto rounded-lg shadow-lg" />
        </div>
      </div>
    </div>
  </div>

  );
}

export default AppFeature;