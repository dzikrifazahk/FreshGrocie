import React from 'react';
import Ilustration1 from '/banner.jpg';

const Hero = () => {
  return (
    <div className="flex flex-col items-center my-20 font-poppins lg:my-[0px">
  <div className="container max-w-5xl mx-auto grid grid-cols-1 lg:grid-cols-2 py-24">
    <div className="pb-24 lg:pb-0 lg:pr-24">
      <h1 className="font-bold text-4xl pt-12 text-center lg:text-left py-8 text-black">
      Your Gateway to Garden-Fresh Goodness!
      </h1>

      
      
      <div className="flex space-x-8">
        <a href="#">
          <img src="/appstore.svg" alt="App Store" />
        </a>
        <a href="#">
          <img src="/googleplay.svg" alt="Google Play" />
        </a>
      </div>
    </div>
    <div className="flex justify-center my-18">
      <img src={Ilustration1} alt="" className="max-w-full h-auto" />
    </div>
  </div>
</div>

  );
};

export default Hero;
