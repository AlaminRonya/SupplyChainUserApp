<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand 'Oswald', sans-serif !important text-capitalize font-weight-bold" href="#">
<%--            Rejection is free learning--%>
            <i class="fa-brands fa-java"></i>
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto"></ul>
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="#" >Home</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link"  href="${pageContext.request.contextPath}/page/v1/user/nav_bar_dealer/accountManager">Account Manager</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link"  href="${pageContext.request.contextPath}/page/v1/user/nav_bar_dealer/dealer">Dealer</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link"  href="${pageContext.request.contextPath}/page/v1/user/nav_bar_dealer/delivery">Delivery</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link"  href="${pageContext.request.contextPath}/page/v1/user/addDealer">Dealer Registration</a>
                </li>
            </ul>

        </div>
    </div>
</nav>