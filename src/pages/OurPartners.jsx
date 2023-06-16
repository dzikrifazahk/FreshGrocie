import React from 'react';


const BestSelling = () => {
    return (
  <div className="overflow-hidden flex items-center justify-center bg-green-100">
  <div className="py-8 mx-auto bg-green-100">
    <div className="container mx-auto px-4 space-y-8 md:px-8 lg:px-20">
      <div className="text-center">
        <h2 className="text-3xl text-black font-bold md:text-5xl">Our Partners</h2>
      </div>
      <div className="grid grid-cols-8 sm:grid-cols-3 md:grid-cols-3 gap-3 justify-center">
        <div className="flex items-center justify-center p-8">
          <img src="/google.svg" className="" alt="" />
        </div>
        <div className="flex items-center justify-center p-8">
          <img src="/bangkitt.svg" className="" alt="" />
        </div>
        <div className="flex items-center justify-center p-8">
          <img src="kampus.png" className="w-32" alt="" />
        </div>
      </div>
    </div>
  </div>
</div>

    
    
    
    );
  };
  
  export default BestSelling;
  
