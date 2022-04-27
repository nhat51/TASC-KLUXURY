<template>
  <div>
    <!-- header area end-->
    <div class="page-head">
      <div class="container">
        <div class="row">
          <div class="col-12">
            <div class="shop-banner">
              <h2>Shop</h2>
              <span><a href="Index.html">Home</a></span>
              <span class="content">Shop</span>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- search area -->
    <div class="search-area">
      <div class="container">
        <div class="row">
          <div class="col-12">
            <div class="search-catagory">
              <form>
                <div class="select-style">
                  <select class="select-optn ">
                    <option class="first-option">all catagory </option>
                    <option> catagory 1</option>
                    <option> catagory 2</option>
                    <option> catagory 3</option>
                    <option> catagory 4 ff</option>
                  </select>
                </div>
                <input class="input-text-box" spellcheck="false" value="" placeholder="Search product...">
                <button class="btn search-button"><i class="fa fa-search"></i></button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- search area  end-->
    <!-- Main content  -->
    <div class="main-content">
      <div class="container">
        <div class="row">
          <div class="col-lg-3 order-2 order-lg-1">
            <div class="widget">
              <h3>Categories</h3>
              <ul>
                <li><a href="#">Bags</a></li>
                <li><a href="#">Beauty</a></li>
                <li><a href="#">Cost & Jackets</a></li>
                <li><a href="#">Dress</a></li>
                <li><a href="#">Jewellery</a></li>
                <li><a href="#">Jumpers & Cardigans</a></li>
                <li><a href="#">Nightwear</a></li>
              </ul>
            </div>
            <div class="widget">
              <h3>Brands</h3>
              <ul>
                <li><a href="#">Apple span</a><span>(3)</span></li>
                <li><a href="#">D&G</a><span>(1)</span></li>
                <li><a href="#">Nokia</a><span>(2)</span></li>
                <li><a href="#">Dress</a><span>(5)</span></li>
                <li><a href="#">Sam Sung</a><span> (2)</span></li>
                <li><a href="#">Sony</a><span> (4)</span></li>
              </ul>
            </div>
            <div class="widget">
              <div class="widget shop-filter">
                <h3>Price</h3>
                <div class="info_widget">
                  <div class="price_filter">
                    <div id="slider-range"></div>
                    <div class="price_slider_amount">
                      <input type="text" id="amount" name="price" placeholder="Add Your Price" />
                      <input type="submit" value="Filter" />
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="widget">
              <h3>Color</h3>
              <ul>
                <li><a href="#">Black</a><span>(9)</span></li>
                <li><a href="#">Blue</a><span>(8)</span></li>
                <li><a href="#">Brown</a><span>(6)</span></li>
                <li><a href="#">Orange</a><span>(8)</span></li>
                <li><a href="#">White</a><span> (6)</span></li>
                <li><a href="#">Yelow</a><span> (6)</span></li>
              </ul>
            </div>
            <div class="widget compare">
              <h3>Compare Products</h3>
              <ul>
                <li>
                  <a href="#"> Exercitation ullamco</a>
                  <a class="remove" href="#"> X</a>
                </li>
                <li>
                  <a href="#">Fashion double</a>
                  <a class="remove" href="#"> X</a>
                </li>
              </ul>
              <a class="lixury-btn" href="#"> shop now </a>
              <a class="lixury-btn right" href="#"> shop now </a>
            </div>
          </div>
          <div class="col-lg-9 order-1 order-lg-2">
            <div class="shop-setting">
              <div class="show-style">
                <p class="setting-p">View as: </p>
                <!-- Nav tabs -->
                <ul class="nav" role="tablist">
                  <li role="presentation"><a class="active" href="#home" aria-controls="home"
                                             role="tab" data-bs-toggle="tab"><i class="fa fa-th"></i></a></li>
                  <li role="presentation"><a href="#profile" aria-controls="profile" role="tab"
                                             data-bs-toggle="tab"><i class="fa fa-th-list"></i></a></li>
                </ul>
              </div>
              <div class="show-product hidden-sm hidden-xs ">
                <form>
                  <select name="orderby" class="orderby ">
                    <option value="menu_order" selected="selected">Default</option>
                    <option value="popularity">Popularity</option>
                    <option value="rating">Rating</option>
                    <option value="date">Newness</option>
                    <option value="price">Price</option>
                  </select>
                </form>
              </div>
              <div class="show-product hidden-sm hidden-xs ">
                <form>
                  <span>Show:</span>
                  <select class="orderby number" name="page_size">
                    <option value="9" selected="selected">9</option>
                    <option value="12">12</option>
                    <option value="24">24</option>
                    <option value="36">36</option>
                    <option value="48">48</option>
                    <option value="60">60</option>
                    <option value="90">90</option>
                    <option value="100">100</option>
                  </select>
                </form>
              </div>
              <div class="show-pagination">
                <ul class="pagination pagi-style">
                  <li><a href="#" class="current page-numbers">1</a></li>
                  <li><a href="#" class="page-numbers">2</a></li>
                  <li><a href="#" class="page-numbers"><i class="fa fa-angle-right"></i></a></li>
                </ul>
              </div>
            </div>
            <!-- Tab panes -->
            <div class="tab-content">
              <div role="tabpanel" class="tab-pane active" id="home">
                <div class="product-area row">
                  <div class="col-md-4 col-sm-4 col-xs-12">
                    <div class="single-product">
                      <div class="product-image fix">
                        <a href="product-details.html">
                          <img src="img/product/1.jpg" alt="">
                          <img class="primary-2" src="img/product/2.jpg" alt="">
                        </a>
                        <div class="product-action">
                          <a href="#" data-bs-toggle="modal" data-bs-target="#myModal"
                             title="Quick view"><i class="fa fa-eye"></i></a>
                          <a href="#" data-bs-toggle="tooltip" title="Wishlist"><i
                              class="fa fa-heart"></i></a>
                          <a href="#" data-bs-toggle="tooltip" data-placement="top"
                             title="Compare"><i class="fa fa-retweet"></i></a>
                        </div>
                        <div class="new-area">
                          <div class="new">
                            <span class="text-new"><span>new</span></span>
                          </div>
                        </div>
                      </div>
                      <h4 class="name"><a href="#">Ullamco laboris nisi</a></h4>
                      <span class="amount">
											<del><span class="amount-del">$170.00</span></del>
											$185.00
										</span>
                      <div class="add-to-cart">
                        <a href="#"><i class="fa fa-shopping-cart"></i></a>
                      </div>
                    </div>
                  </div>
                  <div class="col-md-4 col-sm-4 col-xs-12">
                    <div class="single-product">
                      <div class="product-image fix">
                        <a href="product-details.html">
                          <img src="img/product/3.jpg" alt="">
                          <img class="primary-2" src="img/product/2.jpg" alt="">
                        </a>
                        <div class="product-action">
                          <a href="#" data-bs-toggle="modal" data-bs-target="#myModal"
                             title="Quick view"><i class="fa fa-eye"></i></a>
                          <a href="#" data-bs-toggle="tooltip" title="Wishlist"><i
                              class="fa fa-heart"></i></a>
                          <a href="#" data-bs-toggle="tooltip" data-placement="top"
                             title="Compare"><i class="fa fa-retweet"></i></a>
                        </div>
                        <div class="new-area sell-area">
                          <div class="new">
                            <span class="text-new"><span>sell</span></span>
                          </div>
                        </div>
                        <div class="color">
                          <ul class="color-list">
                            <li class="bk"><span>bk</span></li>
                            <li class="rd"><span>rd</span></li>
                            <li class="yl"><span>yl</span></li>
                          </ul>
                        </div>
                      </div>
                      <h4 class="name"><a href="#">Ullamco laboris nisi</a></h4>
                      <span class="amount">
											<del><span class="amount-del">$170.00</span></del>
											$185.00
										</span>
                      <div class="add-to-cart">
                        <a href="#"><i class="fa fa-shopping-cart"></i></a>
                      </div>
                    </div>
                  </div>
                  <div class="col-md-4 col-sm-4 col-xs-12">
                    <div class="single-product">
                      <div class="product-image fix">
                        <a href="product-details.html">
                          <img src="img/product/3.jpg" alt="">
                          <img class="primary-2" src="img/product/1.jpg" alt="">
                        </a>
                        <div class="product-action">
                          <a href="#" data-bs-toggle="modal" data-bs-target="#myModal"
                             title="Quick view"><i class="fa fa-eye"></i></a>
                          <a href="#" data-bs-toggle="tooltip" title="Wishlist"><i
                              class="fa fa-heart"></i></a>
                          <a href="#" data-bs-toggle="tooltip" data-placement="top"
                             title="Compare"><i class="fa fa-retweet"></i></a>
                        </div>
                        <div class="new-area sell-area">
                          <div class="new">
                            <span class="text-new"><span>sell</span></span>
                          </div>
                        </div>
                        <div class="color">
                          <ul class="color-list">
                            <li class="bk"><span>bk</span></li>
                            <li class="rd"><span>rd</span></li>
                            <li class="yl"><span>yl</span></li>
                          </ul>
                        </div>
                      </div>
                      <h4 class="name"><a href="#">Ullamco laboris nisi</a></h4>
                      <span class="amount">
											<del><span class="amount-del">$170.00</span></del>
											$185.00
										</span>
                      <div class="add-to-cart">
                        <a href="#"><i class="fa fa-shopping-cart"></i></a>
                      </div>
                    </div>
                  </div>
                  <div class="col-md-4 col-sm-4 col-xs-12">
                    <div class="single-product">
                      <div class="product-image fix">
                        <a href="product-details.html">
                          <img src="img/product/4.jpg" alt="">
                          <img class="primary-2" src="img/product/5.jpg" alt="">
                        </a>
                        <div class="product-action">
                          <a href="#" data-bs-toggle="modal" data-bs-target="#myModal"
                             title="Quick view"><i class="fa fa-eye"></i></a>
                          <a href="#" data-bs-toggle="tooltip" title="Wishlist"><i
                              class="fa fa-heart"></i></a>
                          <a href="#" data-bs-toggle="tooltip" data-placement="top"
                             title="Compare"><i class="fa fa-retweet"></i></a>
                        </div>
                        <div class="new-area">
                          <div class="new">
                            <span class="text-new"><span>new</span></span>
                          </div>
                        </div>
                      </div>
                      <h4 class="name"><a href="#">Ullamco laboris nisi</a></h4>
                      <span class="amount">
											<del><span class="amount-del">$170.00</span></del>
											$185.00
										</span>
                      <div class="add-to-cart">
                        <a href="#"><i class="fa fa-shopping-cart"></i></a>
                      </div>
                    </div>
                  </div>
                  <div class="col-md-4 col-sm-4 col-xs-12">
                    <div class="single-product">
                      <div class="product-image fix">
                        <a href="product-details.html">
                          <img src="img/product/5.jpg" alt="">
                          <img class="primary-2" src="img/product/6.jpg" alt="">
                        </a>
                        <div class="product-action">
                          <a href="#" data-bs-toggle="modal" data-bs-target="#myModal"
                             title="Quick view"><i class="fa fa-eye"></i></a>
                          <a href="#" data-bs-toggle="tooltip" title="Wishlist"><i
                              class="fa fa-heart"></i></a>
                          <a href="#" data-bs-toggle="tooltip" data-placement="top"
                             title="Compare"><i class="fa fa-retweet"></i></a>
                        </div>
                        <div class="new-area sell-area">
                          <div class="new">
                            <span class="text-new"><span>sell</span></span>
                          </div>
                        </div>
                        <div class="color">
                          <ul class="color-list">
                            <li class="bk"><span>bk</span></li>
                            <li class="rd"><span>rd</span></li>
                            <li class="yl"><span>yl</span></li>
                          </ul>
                        </div>
                      </div>
                      <h4 class="name"><a href="#">Ullamco laboris nisi</a></h4>
                      <span class="amount">
											<del><span class="amount-del">$170.00</span></del>
											$185.00
										</span>
                      <div class="add-to-cart">
                        <a href="#"><i class="fa fa-shopping-cart"></i></a>
                      </div>
                    </div>
                  </div>
                  <div class="col-md-4 col-sm-4 col-xs-12">
                    <div class="single-product">
                      <div class="product-image fix">
                        <a href="product-details.html">
                          <img src="img/product/6.jpg" alt="">
                          <img class="primary-2" src="img/product/7.jpg" alt="">
                        </a>
                        <div class="product-action">
                          <a href="#" data-bs-toggle="modal" data-bs-target="#myModal"
                             title="Quick view"><i class="fa fa-eye"></i></a>
                          <a href="#" data-bs-toggle="tooltip" title="Wishlist"><i
                              class="fa fa-heart"></i></a>
                          <a href="#" data-bs-toggle="tooltip" data-placement="top"
                             title="Compare"><i class="fa fa-retweet"></i></a>
                        </div>
                        <div class="new-area sell-area">
                          <div class="new">
                            <span class="text-new"><span>sell</span></span>
                          </div>
                        </div>
                        <div class="color">
                          <ul class="color-list">
                            <li class="bk"><span>bk</span></li>
                            <li class="rd"><span>rd</span></li>
                            <li class="yl"><span>yl</span></li>
                          </ul>
                        </div>
                      </div>
                      <h4 class="name"><a href="#">Ullamco laboris nisi</a></h4>
                      <span class="amount">
											<del><span class="amount-del">$170.00</span></del>
											$185.00
										</span>
                      <div class="add-to-cart">
                        <a href="#"><i class="fa fa-shopping-cart"></i></a>
                      </div>
                    </div>
                  </div>
                  <div class="col-md-4 col-sm-4 col-xs-12">
                    <div class="single-product">
                      <div class="product-image fix">
                        <a href="product-details.html">
                          <img src="img/product/7.jpg" alt="">
                          <img class="primary-2" src="img/product/2.jpg" alt="">
                        </a>
                        <div class="product-action">
                          <a href="#" data-bs-toggle="modal" data-bs-target="#myModal"
                             title="Quick view"><i class="fa fa-eye"></i></a>
                          <a href="#" data-bs-toggle="tooltip" title="Wishlist"><i
                              class="fa fa-heart"></i></a>
                          <a href="#" data-bs-toggle="tooltip" data-placement="top"
                             title="Compare"><i class="fa fa-retweet"></i></a>
                        </div>
                        <div class="new-area">
                          <div class="new">
                            <span class="text-new"><span>new</span></span>
                          </div>
                        </div>
                      </div>
                      <h4 class="name"><a href="#">Ullamco laboris nisi</a></h4>
                      <span class="amount">
											<del><span class="amount-del">$170.00</span></del>
											$185.00
										</span>
                      <div class="add-to-cart">
                        <a href="#"><i class="fa fa-shopping-cart"></i></a>
                      </div>
                    </div>
                  </div>
                  <div class="col-md-4 col-sm-4 col-xs-12">
                    <div class="single-product">
                      <div class="product-image fix">
                        <a href="product-details.html">
                          <img src="img/product/8.jpg" alt="">
                          <img class="primary-2" src="img/product/9.jpg" alt="">
                        </a>
                        <div class="product-action">
                          <a href="#" data-bs-toggle="modal" data-bs-target="#myModal"
                             title="Quick view"><i class="fa fa-eye"></i></a>
                          <a href="#" data-bs-toggle="tooltip" title="Wishlist"><i
                              class="fa fa-heart"></i></a>
                          <a href="#" data-bs-toggle="tooltip" data-placement="top"
                             title="Compare"><i class="fa fa-retweet"></i></a>
                        </div>
                        <div class="new-area sell-area">
                          <div class="new">
                            <span class="text-new"><span>sell</span></span>
                          </div>
                        </div>
                        <div class="color">
                          <ul class="color-list">
                            <li class="bk"><span>bk</span></li>
                            <li class="rd"><span>rd</span></li>
                            <li class="yl"><span>yl</span></li>
                          </ul>
                        </div>
                      </div>
                      <h4 class="name"><a href="#">Ullamco laboris nisi</a></h4>
                      <span class="amount">
											<del><span class="amount-del">$170.00</span></del>
											$185.00
										</span>
                      <div class="add-to-cart">
                        <a href="#"><i class="fa fa-shopping-cart"></i></a>
                      </div>
                    </div>
                  </div>
                  <div class="col-md-4 col-sm-4 col-xs-12">
                    <div class="single-product">
                      <div class="product-image fix">
                        <a href="product-details.html">
                          <img src="img/product/8.jpg" alt="">
                          <img class="primary-2" src="img/product/9.jpg" alt="">
                        </a>
                        <div class="product-action">
                          <a href="#" data-bs-toggle="modal" data-bs-target="#myModal"
                             title="Quick view"><i class="fa fa-eye"></i></a>
                          <a href="#" data-bs-toggle="tooltip" title="Wishlist"><i
                              class="fa fa-heart"></i></a>
                          <a href="#" data-bs-toggle="tooltip" data-placement="top"
                             title="Compare"><i class="fa fa-retweet"></i></a>
                        </div>
                        <div class="new-area sell-area">
                          <div class="new">
                            <span class="text-new"><span>sell</span></span>
                          </div>
                        </div>
                        <div class="color">
                          <ul class="color-list">
                            <li class="bk"><span>bk</span></li>
                            <li class="rd"><span>rd</span></li>
                            <li class="yl"><span>yl</span></li>
                          </ul>
                        </div>
                      </div>
                      <h4 class="name"><a href="#">Ullamco laboris nisi</a></h4>
                      <span class="amount">
											<del><span class="amount-del">$170.00</span></del>
											$185.00
										</span>
                      <div class="add-to-cart">
                        <a href="#"><i class="fa fa-shopping-cart"></i></a>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div role="tabpanel" class="tab-pane" id="profile">
                <div class="show-as-list">
                  <div class="single-product">
                    <div class="product-image fix">
                      <a href="product-details.html">
                        <img src="img/product/8.jpg" alt="">
                        <img class="primary-2" src="img/product/9.jpg" alt="">
                      </a>
                      <div class="color">
                        <ul class="color-list">
                          <li class="bk"><span>bk</span></li>
                          <li class="rd"><span>rd</span></li>
                          <li class="yl"><span>yl</span></li>
                        </ul>
                      </div>
                      <div class="new-area sell-area">
                        <div class="new">
                          <span class="text-new"><span>sell</span></span>
                        </div>
                      </div>
                    </div>
                    <div class="product-details-shop ">
                      <h4 class="name"><a href="#">Adipisicing sed do</a></h4>
                      <div class="rating">
											<span class="star-rating">
												<i class="fa fa-star" aria-hidden="true"></i>
												<i class="fa fa-star" aria-hidden="true"></i>
												<i class="fa fa-star" aria-hidden="true"></i>
												<i class="fa fa-star" aria-hidden="true"></i>
												<i class="fa fa-star" aria-hidden="true"></i>
												<a href="#">0 Review(s) / Add Your Review </a>
											</span>
                      </div>
                      <span class="amount">
											<del><span class="amount-del">$170.00</span></del>
											$185.00
										</span>
                      <p>Lorem ipsum dolor sit amete, consectetur news adipisicing sed do new fashion
                        eiusmod tempor incididunt ut labore etel dolore magna aliqua. Ut enim news
                        minimveniam, quis nostrud exercitation new ullamco laboris nisi news commodo
                        consequat consectetur adipisicing. Fashion double layering. Lorem ipsum
                        dolor sit amete, consectetur adipisicing sed do new eiusmod tempor
                        incididunt ut labore etel dolore magna aliqua.</p>
                      <div class="product-action">
                        <a href="#" data-bs-toggle="tooltip" data-placement="top"
                           title="Add To Cart"><i>Add To Cart</i></a>
                        <a href="#" data-bs-toggle="modal" data-bs-target="#myModal"
                           title="Quick view"><i class="fa fa-eye"></i></a>
                        <a href="#" data-bs-toggle="tooltip" title="Wishlist"><i
                            class="fa fa-heart"></i></a>
                        <a href="#" data-bs-toggle="tooltip" data-placement="top" title="Compare"><i
                            class="fa fa-retweet"></i></a>
                      </div>
                    </div>
                  </div>
                  <div class="single-product">
                    <div class="product-image fix">
                      <a href="product-details.html">
                        <img src="img/product/1.jpg" alt="">
                        <img class="primary-2" src="img/product/2.jpg" alt="">
                      </a>
                      <div class="color">
                        <ul class="color-list">
                          <li class="bk"><span>bk</span></li>
                          <li class="rd"><span>rd</span></li>
                          <li class="yl"><span>yl</span></li>
                        </ul>
                      </div>
                      <div class="new-area sell-area">
                        <div class="new">
                          <span class="text-new"><span>sell</span></span>
                        </div>
                      </div>
                    </div>
                    <div class="product-details-shop ">
                      <h4 class="name"><a href="#">Adipisicing sed do</a></h4>
                      <div class="rating">
											<span class="star-rating">
												<i class="fa fa-star" aria-hidden="true"></i>
												<i class="fa fa-star" aria-hidden="true"></i>
												<i class="fa fa-star" aria-hidden="true"></i>
												<i class="fa fa-star" aria-hidden="true"></i>
												<i class="fa fa-star" aria-hidden="true"></i>
												<a href="#">0 Review(s) / Add Your Review </a>
											</span>
                      </div>
                      <span class="amount">
											<del><span class="amount-del">$170.00</span></del>
											$185.00
										</span>
                      <p>Lorem ipsum dolor sit amete, consectetur news adipisicing sed do new fashion
                        eiusmod tempor incididunt ut labore etel dolore magna aliqua. Ut enim news
                        minimveniam, quis nostrud exercitation new ullamco laboris nisi news commodo
                        consequat consectetur adipisicing. Fashion double layering. Lorem ipsum
                        dolor sit amete, consectetur adipisicing sed do new eiusmod tempor
                        incididunt ut labore etel dolore magna aliqua.</p>
                      <div class="product-action">
                        <a href="#" data-bs-toggle="tooltip" data-placement="top"
                           title="Add To Cart"><i>Add To Cart</i></a>
                        <a href="#" data-bs-toggle="modal" data-bs-target="#myModal"
                           title="Quick view"><i class="fa fa-eye"></i></a>
                        <a href="#" data-bs-toggle="tooltip" title="Wishlist"><i
                            class="fa fa-heart"></i></a>
                        <a href="#" data-bs-toggle="tooltip" data-placement="top" title="Compare"><i
                            class="fa fa-retweet"></i></a>
                      </div>
                    </div>
                  </div>
                  <div class="single-product">
                    <div class="product-image fix">
                      <a href="product-details.html">
                        <img src="img/product/5.jpg" alt="">
                        <img class="primary-2" src="img/product/6.jpg" alt="">
                      </a>
                      <div class="color">
                        <ul class="color-list">
                          <li class="bk"><span>bk</span></li>
                          <li class="rd"><span>rd</span></li>
                          <li class="yl"><span>yl</span></li>
                        </ul>
                      </div>
                      <div class="new-area sell-area">
                        <div class="new">
                          <span class="text-new"><span>sell</span></span>
                        </div>
                      </div>
                    </div>
                    <div class="product-details-shop ">
                      <h4 class="name"><a href="#">Adipisicing sed do</a></h4>
                      <div class="rating">
											<span class="star-rating">
												<i class="fa fa-star" aria-hidden="true"></i>
												<i class="fa fa-star" aria-hidden="true"></i>
												<i class="fa fa-star" aria-hidden="true"></i>
												<i class="fa fa-star" aria-hidden="true"></i>
												<i class="fa fa-star" aria-hidden="true"></i>
												<a href="#">0 Review(s) / Add Your Review </a>
											</span>
                      </div>
                      <span class="amount">
											<del><span class="amount-del">$170.00</span></del>
											$185.00
										</span>
                      <p>Lorem ipsum dolor sit amete, consectetur news adipisicing sed do new fashion
                        eiusmod tempor incididunt ut labore etel dolore magna aliqua. Ut enim news
                        minimveniam, quis nostrud exercitation new ullamco laboris nisi news commodo
                        consequat consectetur adipisicing. Fashion double layering. Lorem ipsum
                        dolor sit amete, consectetur adipisicing sed do new eiusmod tempor
                        incididunt ut labore etel dolore magna aliqua.</p>
                      <div class="product-action">
                        <a href="#" data-bs-toggle="tooltip" data-placement="top"
                           title="Add To Cart"><i>Add To Cart</i></a>
                        <a href="#" data-bs-toggle="modal" data-bs-target="#myModal"
                           title="Quick view"><i class="fa fa-eye"></i></a>
                        <a href="#" data-bs-toggle="tooltip" title="Wishlist"><i
                            class="fa fa-heart"></i></a>
                        <a href="#" data-bs-toggle="tooltip" data-placement="top" title="Compare"><i
                            class="fa fa-retweet"></i></a>
                      </div>
                    </div>
                  </div>
                  <div class="single-product">
                    <div class="product-image fix">
                      <a href="product-details.html">
                        <img src="img/product/9.jpg" alt="">
                        <img class="primary-2" src="img/product/8.jpg" alt="">
                      </a>
                      <div class="color">
                        <ul class="color-list">
                          <li class="bk"><span>bk</span></li>
                          <li class="rd"><span>rd</span></li>
                          <li class="yl"><span>yl</span></li>
                        </ul>
                      </div>
                      <div class="new-area sell-area">
                        <div class="new">
                          <span class="text-new"><span>sell</span></span>
                        </div>
                      </div>
                    </div>
                    <div class="product-details-shop ">
                      <h4 class="name"><a href="#">Adipisicing sed do</a></h4>
                      <div class="rating">
											<span class="star-rating">
												<i class="fa fa-star" aria-hidden="true"></i>
												<i class="fa fa-star" aria-hidden="true"></i>
												<i class="fa fa-star" aria-hidden="true"></i>
												<i class="fa fa-star" aria-hidden="true"></i>
												<i class="fa fa-star" aria-hidden="true"></i>
												<a href="#">0 Review(s) / Add Your Review </a>
											</span>
                      </div>
                      <span class="amount">
											<del><span class="amount-del">$170.00</span></del>
											$185.00
										</span>
                      <p>Lorem ipsum dolor sit amete, consectetur news adipisicing sed do new fashion
                        eiusmod tempor incididunt ut labore etel dolore magna aliqua. Ut enim news
                        minimveniam, quis nostrud exercitation new ullamco laboris nisi news commodo
                        consequat consectetur adipisicing. Fashion double layering. Lorem ipsum
                        dolor sit amete, consectetur adipisicing sed do new eiusmod tempor
                        incididunt ut labore etel dolore magna aliqua.</p>
                      <div class="product-action">
                        <a href="#" data-bs-toggle="tooltip" data-placement="top"
                           title="Add To Cart"><i>Add To Cart</i></a>
                        <a href="#" data-bs-toggle="modal" data-bs-target="#myModal"
                           title="Quick view"><i class="fa fa-eye"></i></a>
                        <a href="#" data-bs-toggle="tooltip" title="Wishlist"><i
                            class="fa fa-heart"></i></a>
                        <a href="#" data-bs-toggle="tooltip" data-placement="top" title="Compare"><i
                            class="fa fa-retweet"></i></a>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-12">
                <div class="shop-pagination">
                  <div class="show-pagination">
                    <ul class="pagination pagi-style">
                      <li><a href="#" class="current page-numbers">1</a></li>
                      <li><a href="#" class="page-numbers">2</a></li>
                      <li><a href="#" class="page-numbers"><i class="fa fa-angle-right"></i></a></li>
                    </ul>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Main content end --><!-- modal design  -->
    <div class="modal-design">
      <!-- Modal -->
      <div id="myModal" class="modal fade" role="dialog">
        <div class="modal-dialog">
          <!-- Modal content-->
          <div class="modal-content">
            <button type="button" class="close" data-bs-dismiss="modal">&times;</button>
            <div class="modal-body">
              <div class="row">
                <div class="col-md-5">
                  <div class="main-img">
                    <div class="item">
                      <img src="img/porduct-details/1.jpg" alt="" />
                    </div>
                  </div>
                </div>
                <div class="col-md-7">
                  <div class="single-pro-details">
                    <div class="product-details-shop ">
                      <h4 class="name">Adipisicing sed do</h4>
                      <div class="rating">
											<span class="star-rating">
												<i class="fa fa-star" aria-hidden="true"></i>
												<i class="fa fa-star" aria-hidden="true"></i>
												<i class="fa fa-star" aria-hidden="true"></i>
												<i class="fa fa-star" aria-hidden="true"></i>
												<i class="fa fa-star" aria-hidden="true"></i>
												<a href="#">0 Review(s) / Add Your Review </a>
											</span>
                      </div>
                      <span class="amount">
											$185.00
										</span>
                      <p>Lorem ipsum dolor sit amete, consectetur news adipisicing sed do new fashion
                        eiusmod tempor incididunt ut labore etel dolore magna aliqua. Ut enim news
                        minimveniam, quis nostrud exercitation new ullamco laboris nisi news commodo
                        consequat consectetur adipisicing. Fashion double layering. Lorem ipsum
                        dolor
                        sit amete, consectetur adipisicing sed do new eiusmod tempor incididunt ut
                        labore etel dolore magna aliqua.</p>
                      <div id=field1>
                        <span>Qty</span>
                        <button type="button" id="sub" class=sub>-</button>
                        <input type="text" id="1" value=1 class=field>
                        <button type="button" id="add" class=add>+</button>
                      </div>
                      <div class="product-action">
                        <a class="add-tocart" href="#" data-bs-toggle="tooltip" data-placement="top"
                           title="Add To Cart">Add To Cart</a>
                        <a href="#" data-bs-toggle="tooltip" title="Quick view"><i
                            class="fa fa-eye"></i></a>
                        <a href="#" data-bs-toggle="tooltip" title="Wishlist"><i
                            class="fa fa-heart"></i></a>
                        <a href="#" data-bs-toggle="tooltip" data-placement="top" title="Compare"><i
                            class="fa fa-retweet"></i></a>
                      </div>
                    </div>
                  </div>
                  <div class="product-meta">
                    <div class="posted-in">
                      Category:
                      <a href="#"> Jumpers & Cardigans.</a>
                    </div>
                    <div class="tagged-as">
                      Tags:
                      <a href="#">Collection Women</a>,
                      <a href="#"> Fashion</a>,
                      <a href="#"> New</a>,
                      <a href="#"> Theme</a>,
                      <a href="#"> Top</a>.
                      <a href="#"> Wordpress</a>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- all js here -->
  </div>
</template>

<script>
export default {
  name: "shop"
}
</script>

<style scoped>

</style>