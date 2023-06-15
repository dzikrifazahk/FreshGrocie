import React from 'react'
import Button from './components/Button'
import Navbar from './components/Navbar'
import Hero from './pages/Hero'
import OurTeam from './pages/OurTeam'
import OurPartner from './pages/OurPartners'
import FeaturedProduct from './pages/FeaturedProduct'
import AboutUs from './pages/AboutUs'
import AppFeature from './pages/AppFeature'
import Footer from './components/Footer'


function App() {
  return (
    <div>
      
        <Navbar />
        <Hero />
        <FeaturedProduct />
        <AppFeature />
        <AboutUs />
        <OurPartner />
        <OurTeam />
        <Footer />
       
       
        
        
      
      
    </div>
  )
}

export default App
