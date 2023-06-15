import React from 'react';
import StarRatingComponent from 'react-star-rating-component';


const ProductGrid = () => {
    return (
   <div>
      <div className="text-center p-10">
        <h1 className="font-bold text-4xl mb-4">Featured Products</h1>
        
      </div>
<div className="w-fit mx-auto grid grid-cols-1 lg:grid-cols-3 md:grid-cols-2 justify-items-center justify-center gap-y-20 gap-x-14 mt-10 mb-5">
      {/* Product card 1 */}
      <div className="w-72 bg-white shadow-md rounded-xl duration-500 hover:scale-105 hover:shadow-xl">
        <a href="#">
          <img src="/banner.jpg" alt="Product" className="h-80 w-72 object-cover rounded-t-xl" />
          <div className="px-4 py-3 w-72">
            <span className="text-gray-400 mr-3 uppercase text-xs">Brand</span>
            <p className="text-lg font-bold text-black truncate block capitalize">Product Name</p>
            <div className="flex items-center">
              <p className="text-lg font-semibold text-black cursor-auto my-3">$149</p>
              <del>
                <p className="text-sm text-gray-600 cursor-auto ml-2">$199</p>
              </del>
              <div className="ml-auto">
              <StarRatingComponent
    name="productRating"
    starCount={5} // Number of stars
    value={3.5} // Rating value
    editing={false} // Disable rating input
  />

              </div>
            </div>
          </div>
        </a>
      </div>

      {/* Product card 2 */}
      <div className="w-72 bg-white shadow-md rounded-xl duration-500 hover:scale-105 hover:shadow-xl">
        <a href="#">
          <img src="/banner.jpg" alt="Product" className="h-80 w-72 object-cover rounded-t-xl" />
          <div className="px-4 py-3 w-72">
            <span className="text-gray-400 mr-3 uppercase text-xs">Brand</span>
            <p className="text-lg font-bold text-black truncate block capitalize">Product Name</p>
            <div className="flex items-center">
              <p className="text-lg font-semibold text-black cursor-auto my-3">$149</p>
              <del>
                <p className="text-sm text-gray-600 cursor-auto ml-2">$199</p>
              </del>
              <div className="ml-auto">
                {/* Add any additional content */}
              </div>
            </div>
          </div>
        </a>
      </div>

      {/* Product card 3 */}
      <div className="w-72 bg-white shadow-md rounded-xl duration-500 hover:scale-105 hover:shadow-xl">
        <a href="#">
          <img src="/banner.jpg" alt="Product" className="h-80 w-72 object-cover rounded-t-xl" />
          <div className="px-4 py-3 w-72">
            <span className="text-gray-400 mr-3 uppercase text-xs">Brand</span>
            <p className="text-lg font-bold text-black truncate block capitalize">Product Name</p>
            <div className="flex items-center">
              <p className="text-lg font-semibold text-black cursor-auto my-3">$149</p>
              <del>
                <p className="text-sm text-gray-600 cursor-auto ml-2">$199</p>
              </del>
              <div className="ml-auto"></div>
            </div>
          </div>
        </a>
      </div>

      {/* Product card 4 */}
      <div className="w-72 bg-white shadow-md rounded-xl duration-500 hover:scale-105 hover:shadow-xl">
        <a href="#">
          <img src="/banner.jpg" alt="Product" className="h-80 w-72 object-cover rounded-t-xl" />
          <div className="px-4 py-3 w-72">
            <span className="text-gray-400 mr-3 uppercase text-xs">Brand</span>
            <p className="text-lg font-bold text-black truncate block capitalize">Product Name</p>
            <div className="flex items-center">
              <p className="text-lg font-semibold text-black cursor-auto my-3">$149</p>
              <del>
                <p className="text-sm text-gray-600 cursor-auto ml-2">$199</p>
              </del>
              <div className="ml-auto"></div>
            </div>
          </div>
        </a>
      </div>

      {/* Product card 5 */}
      <div className="w-72 bg-white shadow-md rounded-xl duration-500 hover:scale-105 hover:shadow-xl">
        <a href="#">
          <img src="/banner.jpg" alt="Product" className="h-80 w-72 object-cover rounded-t-xl" />
          <div className="px-4 py-3 w-72">
            <span className="text-gray-400 mr-3 uppercase text-xs">Brand</span>
            <p className="text-lg font-bold text-black truncate block capitalize">Product Name</p>
            <div className="flex items-center">
              <p className="text-lg font-semibold text-black cursor-auto my-3">$149</p>
              <del>
                <p className="text-sm text-gray-600 cursor-auto ml-2">$199</p>
              </del>
              <div className="ml-auto"></div>
            </div>
          </div>
        </a>
      </div>

      {/* Product card 6 */}
      <div className="w-72 bg-white shadow-md rounded-xl duration-500 hover:scale-105 hover:shadow-xl">
        <a href="#">
          <img src="/banner.jpg" alt="Product" className="h-80 w-72 object-cover rounded-t-xl" />
          <div className="px-4 py-3 w-72">
            <span className="text-gray-400 mr-3 uppercase text-xs">Brand</span>
            <p className="text-lg font-bold text-black truncate block capitalize">Product Name</p>
            <div className="flex items-center">
              <p className="text-lg font-semibold text-black cursor-auto my-3">$149</p>
              <del>
                <p className="text-sm text-gray-600 cursor-auto ml-2">$199</p>
              </del>
              <div className="ml-auto"></div>
            </div>
          </div>
        </a>
      </div>
</div>
   </div>     

     
    );
  }
  
  export default ProductGrid;





  