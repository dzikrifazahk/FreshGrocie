import React from 'react';
import Figma from '../assets/figma.png';
import Facebook from '../assets/facebook.png';
import Vercel from '../assets/vercel.png';
import Cardhero from '../components/Cardhero';
import Ilustration1 from '../assets/banner.jpg';

const Hero = () => {
  return (
    <div className="flex flex-col items-center my-20 font-poppins lg:my-[20px] bg-green-200">
  <div className="container max-w-5xl mx-auto grid grid-cols-1 lg:grid-cols-2 py-24">
    <div className="pb-24 lg:pb-0 lg:pr-24">
      <h1 className="font-bold text-4xl pt-12 text-center lg:text-left py-8 text-green-800">
      Lorem ipsum dolor sit amet, consectetur
        <br />
        Lorem ipsum dolor sit amet, consectetur adipiscing elit.
      </h1>
      <div className="font-bold text-xl pb-12 text-center lg:text-left text-green-700">
      Lorem ipsum dolor sit amet, consectetur adipiscing elit.
      </div>
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
      <img src={Ilustration1} alt="Illustration LaslesVPN" className="max-w-full h-auto" />
    </div>
  </div>
</div>

  );
};

export default Hero;
