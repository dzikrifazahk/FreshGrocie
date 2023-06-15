import React from 'react';

const AppFeature = () => {
  return (
    <div className="dark:bg-gray-800 dark:text-gray-100 bg-green-50">
  <div className="container max-w-xl p-6 py-12 mx-auto space-y-24 lg:px-8 lg:max-w-7xl">
    <div>
      <h2 className="text-3xl font-bold tracking-wide text-center sm:text-5xl dark:text-gray-50">Our Features</h2>
      <p className="max-w-3xl mx-auto mt-4 text-xl text-center dark:text-gray-400">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    </div>
    <div className="grid lg:gap-8 lg:grid-cols-2 lg:items-center">
      <div>
        <h3 className="text-2xl font-bold tracking-wide sm:text-3xl dark:text-gray-50">Lorem ipsum dolor sit amet, consectetur</h3>
        <p className="mt-3 text-lg dark:text-gray-400">Lorem ipsum dolor sit amet, consectetur persius eripuit quo id. Sit te euismod tacimates.</p>
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
              <h4 className="text-lg font-medium leading-none dark:text-gray-50">Lorem ipsum dolor sit amet, consectetur</h4>
              <p className="mt-2 dark:text-gray-400">Lorem ipsum dolor sit amet, consectetur</p>
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
              <h4 className="text-lg font-medium leading-none dark:text-gray-50">Lorem ipsum dolor sit amet, consectetur</h4>
              <p className="mt-2 dark:text-gray-400">Lorem ipsum dolor sit amet, consectetur.</p>
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
              <h4 className="text-lg font-medium leading-none dark:text-gray-50">Lorem ipsum dolor sit amet, consectetur</h4>
              <p className="mt-2 dark:text-gray-400">Lorem ipsum dolor sit amet, consecteturx. Ut eos iudico quando soleat, nam modus.</p>
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