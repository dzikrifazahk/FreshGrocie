import React from 'react'
function Footer() {
    return (
<div className="relative z-10 bg-green-100 pt-20 pb-10 lg:pt-[120px] lg:pb-20">
  <div className="p-2 md:mx-[120px]">
    <div className="-mx-4 flex flex-wrap">
      <div className="w-full px-4 sm:w-2/3 lg:w-3/12">
        <div className="mb-10 w-full">
          <a href="javascript:void(0)" className="mb-6 inline-block max-w-[160px]">
            <img
              src="/FG.svg"
              alt="logo"
              className="max-w-full"
            />
          </a>
          <p className="text-body-color mb-7 text-base">
            Sed ut perspiciatis undmnis is iste natus error sit amet voluptatem totam rem aperiam.
          </p>
          <p className="text-dark flex items-center text-sm font-medium">
            <span className="text-primary mr-3"></span>
            <span>+012 (345) 678 99</span>
          </p>
        </div>
      </div>
      <div className="w-full px-4 sm:w-1/2 lg:w-2/12">
        <div className="mb-10 w-full">
          <h4 className="text-dark mb-9 text-lg font-semibold">Resources</h4>
          <ul>
            <li>
              <a
                href="javascript:void(0)"
                className="text-body-color hover:text-primary mb-2 inline-block text-base leading-loose"
              >
                SaaS Development
              </a>
            </li>
            <li>
              <a
                href="javascript:void(0)"
                className="text-body-color hover:text-primary mb-2 inline-block text-base leading-loose"
              >
                Our Products
              </a>
            </li>
            <li>
              <a
                href="javascript:void(0)"
                className="text-body-color hover:text-primary mb-2 inline-block text-base leading-loose"
              >
                User Flow
              </a>
            </li>
            <li>
              <a
                href="javascript:void(0)"
                className="text-body-color hover:text-primary mb-2 inline-block text-base leading-loose"
              >
                User Strategy
              </a>
            </li>
          </ul>
        </div>
      </div>
      <div className="w-full px-4 sm:w-1/2 lg:w-2/12">
        <div className="mb-10 w-full">
          <h4 className="text-dark mb-9 text-lg font-semibold">Company</h4>
          <ul>
            <li>
              <a
                href="javascript:void(0)"
                className="text-body-color hover:text-primary mb-2 inline-block text-base leading-loose"
              >
                About TailGrids
              </a>
            </li>
            <li>
              <a
                href="javascript:void(0)"
                className="text-body-color hover:text-primary mb-2 inline-block text-base leading-loose"
              >
                Contact & Support
              </a>
            </li>
            <li>
              <a
                href="javascript:void(0)"
                className="text-body-color hover:text-primary mb-2 inline-block text-base leading-loose"
              >
                Success History
              </a>
            </li>
            <li>
              <a
                href="javascript:void(0)"
                className="text-body-color hover:text-primary mb-2 inline-block text-base leading-loose"
              >
                Setting & Privacy
              </a>
            </li>
          </ul>
        </div>
      </div>
      <div className="w-full px-4 sm:w-1/2 lg:w-2/12">
        <div className="mb-10 w-full">
          <h4 className="text-dark mb-9 text-lg font-semibold">Quick Links</h4>
          <ul>
            <li>
              <a
                href="javascript:void(0)"
                className="text-body-color hover:text-primary mb-2 inline-block text-base leading-loose"
              >
                Premium Support
              </a>
            </li>
            <li>
              <a
                href="javascript:void(0)"
                className="text-body-color hover:text-primary mb-2 inline-block text-base leading-loose"
              >
                Our Services
              </a>
            </li>
            <li>
              <a
                href="javascript:void(0)"
                className="text-body-color hover:text-primary mb-2 inline-block text-base leading-loose"
              >
                Know Our Team
              </a>
            </li>
            <li>
              <a
                href="javascript:void(0)"
                className="text-body-color hover:text-primary mb-2 inline-block text-base leading-loose"
              >
                Download App
              </a>
            </li>
          </ul>
        </div>
      </div>
      <div className="w-full px-4 sm:w-1/2 lg:w-3/12">
        <div className="mb-10 w-full">
          <h4 className="text-dark mb-9 text-lg font-semibold">Follow Us On</h4>
          <div className="mb-6 flex items-center"></div>
          <p className="text-body-color text-base">&copy; 2023 FreshGrocie</p>
        </div>
      </div>
    </div>
  </div>
  <div>
    <span className="absolute top-10 right-10 z-[-1] bg-green-100"></span>
  </div>
</div>

    );
  }
  
  export default Footer;
  