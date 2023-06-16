import React, {useState} from 'react'


const OurTeam = () => {
 
  
    return (
//   <div className='bg-wblue mb-[1000px]'></div>
<div className="bg-white dark:bg-gray-900">
      <div className="py-8 px-4 mx-auto max-w-screen-xl text-center lg:py-16 lg:px-6">
        <div className="mx-auto mb-8 max-w-screen-sm lg:mb-16">
          <h2 className="mb-4 text-6xl tracking-tight font-extrabold text-gray-900 dark:text-white">Our team</h2>
          
        </div>
        <div className="grid gap-8 lg:gap-16 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-3">
          {/* Repeat the following div block for each team member */}
          <div className="text-center text-gray-500 dark:text-gray-400">
            <img className="mx-auto mb-4 w-36 h-36 rounded-full" src="/dzikri.jpg" alt="Bonnie Avatar" />
            <h3 className="mb-1 text-2xl font-bold tracking-tight text-gray-900 dark:text-white">
              <a href="#">Dzikri Faza Fauna Kusnadi</a>
            </h3>
            <p>Mobile Development</p>
            <p>Politeknik Negeri Indramayu</p>

            <ul className="flex justify-center mt-4 space-x-4">
              {/* Add list items for each social link */}
            </ul>
          </div>
          {/* End of team member div block */}
          <div className="text-center text-gray-500 dark:text-gray-400">
            <img className="mx-auto mb-4 w-36 h-36 rounded-full" src="/filemon.jpg" alt="Bonnie Avatar" />
            <h3 className="mb-1 text-2xl font-bold tracking-tight text-gray-900 dark:text-white">
              <a href="#">Filemon Sitanggang</a>
              
            </h3>
            <p>Mobile Development</p>
            <p>Politeknik Negeri Indramayu</p>
            <ul className="flex justify-center mt-4 space-x-4">
              {/* Add list items for each social link */}
            </ul>
          </div>
          <div className="text-center text-gray-500 dark:text-gray-400">
            <img className="mx-auto mb-4 w-36 h-36 rounded-full" src="/aditya.png" alt="Bonnie Avatar" />
            <h3 className="mb-1 text-2xl font-bold tracking-tight text-gray-900 dark:text-white">
              <a href="#">Aditya Hadi Wijaya</a>
            </h3>
            <p>Cloud Computing</p>
            <p>Politeknik Negeri Indramayu</p>
            <ul className="flex justify-center mt-4 space-x-4">
              {/* Add list items for each social link */}
            </ul>
          </div>
          <div className="text-center text-gray-500 dark:text-gray-400">
            <img className="mx-auto mb-4 w-36 h-36 rounded-full" src="/samuel.png" alt="Bonnie Avatar" />
            <h3 className="mb-1 text-2xl font-bold tracking-tight text-gray-900 dark:text-white">
              <a href="#">Samuel Djodi</a>
            </h3>
            <p>Cloud Computing</p>
            <p>Universitas Brawijaya</p>
            <ul className="flex justify-center mt-4 space-x-4">
              {/* Add list items for each social link */}
            </ul>
          </div>
          <div className="text-center text-gray-500 dark:text-gray-400">
            <img className="mx-auto mb-4 w-36 h-36 rounded-full" src="/diana.jpg" alt="Bonnie Avatar" />
            <h3 className="mb-1 text-2xl font-bold tracking-tight text-gray-900 dark:text-white">
              <a href="#">Diana Ayu Sukma Putri</a>
            </h3>
            <p>Machine Learning</p>
            <p>Universitas Brawijaya</p>
            <ul className="flex justify-center mt-4 space-x-4">
              {/* Add list items for each social link */}
            </ul>
          </div>
          <div className="text-center text-gray-500 dark:text-gray-400">
            <img className="mx-auto mb-4 w-36 h-36 rounded-full" src="/rahma.jpg" alt="Bonnie Avatar" />
            <h3 className="mb-1 text-2xl font-bold tracking-tight text-gray-900 dark:text-white">
              <a href="#">Rahma Nur Fitriyani</a>
            </h3>
            <p>Machine Learning</p>
            <p>Universitas Brawijaya</p>
            <ul className="flex justify-center mt-4 space-x-4">
              {/* Add list items for each social link */}
            </ul>
          </div>
        </div>
      </div>
    </div>

    
  )
}



export default OurTeam