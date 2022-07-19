<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 7/20/2022
  Time: 1:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Login Page</title>
        <jsp:include page="../include/css.jsp"/>
    </head>

    <body>
        <section class="vh-100 gradient-custom">
        <div class="container py-5 h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                    <div class="card bg-dark text-white" style="border-radius: 1rem;">
                        <div class="card-body p-5 text-center">

                            <div class="mb-md-5 mt-md-4 pb-5">
                                <h2 class="fw-bold mb-2 text-uppercase">Login</h2>
                                <p class="text-white-50 mb-5">Please enter your login and password!</p>


                                <form action="/login-process" method="post">

                                    <div class="form-outline form-white mb-4">
                                        <input type="email" id="typeEmailX" name="username" class="form-control form-control-lg" />
                                        <label class="form-label" for="typeEmailX">Email</label>
                                    </div>

                                    <div class="form-outline form-white mb-4">
                                        <input type="password" id="typePasswordX" name="password" class="form-control form-control-lg" />
                                        <label class="form-label" for="typePasswordX">Password</label>
                                    </div>


                                    <button class="btn btn-outline-light btn-lg px-5" type="submit">Login</button>

                                </form>


                            </div>

                            <div>
                                <p class="mb-0">Don't have an account? <a href="${pageContext.request.contextPath}/page/v1/registration/add" class="text-white-50 fw-bold">Sign Up</a>
                                </p>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    </body>

</html>
