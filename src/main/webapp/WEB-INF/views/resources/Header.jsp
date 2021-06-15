 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <nav class="navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
      <div class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-center">
        <a class="navbar-brand brand-logo mr-5" href='<c:url value="/"></c:url>'><img src="./resources/images/logo.svg" class="mr-2" alt="logo"/></a>
        <a class="navbar-brand brand-logo-mini" href='<c:url value="/"></c:url>'><img src="./resources/images/logo-mini.svg" alt="logo"/></a>
      </div>
      <div class="navbar-menu-wrapper d-flex align-items-center justify-content-end">
        <button class="navbar-toggler navbar-toggler align-self-center" type="button" data-toggle="minimize">
          <span class="icon-menu"></span>
        </button>
        <ul class="navbar-nav mr-lg-2">
          <li class="nav-item nav-search d-none d-lg-block">
            <div class="input-group">
              <div class="input-group-prepend hover-cursor" id="navbar-search-icon">
                <span class="input-group-text" id="search">
                  <i class="icon-search"></i>
                </span>
              </div>
              <input type="text" class="form-control" id="navbar-search-input" placeholder="Search now" aria-label="search" aria-describedby="search">
            </div>
          </li>
        </ul>
        <ul class="navbar-nav navbar-nav-right">
          <li class="nav-item dropdown">
            <a class="nav-link count-indicator dropdown-toggle" id="notificationDropdown" href="#" data-toggle="dropdown">
              <i class="icon-bell mx-0"></i>
              <span class="count"></span>
            </a>
            <div class="dropdown-menu dropdown-menu-right navbar-dropdown preview-list" aria-labelledby="notificationDropdown">
              <p class="mb-0 font-weight-normal float-left dropdown-header">Notifications</p>
              <a class="dropdown-item preview-item">
                <div class="preview-thumbnail">
                  <div class="preview-icon bg-success">
                    <i class="ti-info-alt mx-0"></i>
                  </div>
                </div>
                <div class="preview-item-content">
                  <h6 class="preview-subject font-weight-normal">Application Error</h6>
                  <p class="font-weight-light small-text mb-0 text-muted">
                    Just now
                  </p>
                </div>
              </a>
              <a class="dropdown-item preview-item">
                <div class="preview-thumbnail">
                  <div class="preview-icon bg-warning">
                    <i class="ti-settings mx-0"></i>
                  </div>
                </div>
                <div class="preview-item-content">
                  <h6 class="preview-subject font-weight-normal">Settings</h6>
                  <p class="font-weight-light small-text mb-0 text-muted">
                    Private message
                  </p>
                </div>
              </a>
              <a class="dropdown-item preview-item">
                <div class="preview-thumbnail">
                  <div class="preview-icon bg-info">
                    <i class="ti-user mx-0"></i>
                  </div>
                </div>
                <div class="preview-item-content">
                  <h6 class="preview-subject font-weight-normal">New user registration</h6>
                  <p class="font-weight-light small-text mb-0 text-muted">
                    2 days ago
                  </p>
                </div>
              </a>
            </div>
          </li>
         <c:choose>
         	<c:when test="${User!=null}">
         		 <li class="nav-item nav-profile dropdown">
            <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" id="profileDropdown">
              <img src="/resources/images/face28.jpg" alt="profile"/>
            </a>
<!--             <div class="dropdown-menu dropdown-menu-right navbar-dropdown" aria-labelledby="profileDropdown"> -->
<!--               <a class="dropdown-item"> -->
<!--                 <i class="ti-settings text-primary"></i> -->
<!--                 Settings -->
<!--               </a> -->
<!--               <a class="dropdown-item"  onclick="if (!(confirm('Are you sure you want logout ?'))) return false"> -->
<!--                 <i class="ti-power-off text-primary"></i> -->
<!--                 Logout -->
<!--               </a> -->
<!--             </div> -->
          </li>
          	 <li class="nav-item nav-settings d-none d-lg-flex">
	             <a class="nav-link"  onclick="if (!(confirm('Are you sure you want logout ?'))) return false" href='<c:url  value="/logout"></c:url>'>
                	<i class="ti-power-off text-primary"></i> Logout
             	 </a>
	          </li>
         	</c:when>
         	<c:otherwise>
         		 <li class="nav-item nav-settings d-none d-lg-flex">
            <a class="nav-link" href='<c:url  value="/login"></c:url>'>
              <i class="icon-ellipsis">Login</i>
            </a>
          </li>
         	</c:otherwise>
         </c:choose>
          <li class="nav-item nav-settings d-none d-lg-flex">
            <a class="nav-link" href="#">
              <i class="icon-ellipsis"></i>
            </a>
          </li>
        </ul>
        <button class="navbar-toggler navbar-toggler-right d-lg-none align-self-center" type="button" data-toggle="offcanvas">
          <span class="icon-menu"></span>
        </button>
      </div>
    </nav>	