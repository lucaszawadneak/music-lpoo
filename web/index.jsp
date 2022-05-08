
<%-- 
    Document   : index
    Created on : May 2, 2022, 4:20:47 PM
    Authors     : Gustavo Schwanka GRR20193748
                  Leonardo Xavier da Silva Moraes GRR20204488
                  Lucas Cassilha Zawadneak GRR20200141
                  Ludimilla Krautzuk GRR20204467
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Músicas</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body id="page-top">
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
            <div class="container">
                <a class="navbar-brand"  width="400" 
                   height="500" href="#page-top"><img src="assets/img/logo.png" alt="..." /></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars ms-1"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav text-uppercase ms-auto py-4 py-lg-0">
                        <li class="nav-item"><a class="nav-link" href="#portfolio">Ranking de Músicas</a></li>
                        <li class="nav-item"><a class="nav-link" href="#ranking">Ranking de Album</a></li>
                        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/RecordController?action=search&searchParam=">Mostrar Albuns</a></li>
                        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/ArtistController?action=search&searchParam=">Mostrar Artistas</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- Masthead-->
        <header class="masthead">
            <div class="container">
                <div class="masthead-subheading">Você gosta de música? Você quer ser ouvido por várias pessoas?</div>
                <div class="masthead-heading text-uppercase">Registre sua música</div>
                <a class="btn btn-primary btn-xl text-uppercase" href="album/register.jsp">Registrar Album</a>
                <a class="btn btn-primary btn-xl text-uppercase" href="music/register.jsp">Registrar Música</a>
                <a class="btn btn-primary btn-xl text-uppercase" href="artist/register.jsp">Registrar Artista</a>
            </div>
        </header>

        <!-- Portfolio Grid-->
        <section class="page-section bg-light" id="portfolio">
            <div class="container">
                <div class="text-center">
                    <h2 class="section-heading text-uppercase">Músicas</h2>
                    <h3 class="section-subheading text-muted">Músicas mais ouvidas</h3>
                </div>
                <div class="row">
                    <c:forEach var = "i" begin = "1" end = "6">
                        <div class="col-lg-4 col-sm-6 mb-4">
                            <!-- Portfolio item 1-->
                            <div class="portfolio-item">
                                <a class="portfolio-link" data-bs-toggle="modal" href="#portfolioModal1">
                                    <div class="portfolio-hover">
                                        <div class="portfolio-hover-content"><i class="fas fa-plus fa-3x"></i></div>
                                    </div>
                                    <img class="img-fluid" src="assets/img/portifolio/${i}.0.jpeg" alt="..." />
                                </a>
                                <div class="portfolio-caption">
                                    <div class="portfolio-caption-heading">Threads</div>
                                    <div class="portfolio-caption-subheading text-muted">Illustration</div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </section>
    <!-- Portfolio Grid-->
    <section class="page-section bg-light" id="ranking">
        <div class="container">
            <div class="text-center">
                <h2 class="section-heading text-uppercase">Albuns</h2>
                <h3 class="section-subheading text-muted">Albuns mais ouvidos</h3>
            </div>

            <div class="row">
                <c:forEach var = "i" begin = "1" end = "6">
                    <div class="col-lg-4 col-sm-6 mb-4">
                        <!-- Portfolio item 1-->
                        <div class="ranking-item">
                            <a class="ranking-link" data-bs-toggle="modal" href="#rankingModal1">
                                <div class="ranking-hover">
                                    <div class="ranking-hover-content"><i class="fas fa-plus fa-3x"></i></div>
                                </div>
                                <img class="img-fluid" src="assets/img/portifolio1/${i}.0.jpg" alt="..." />
                            </a>
                            <div class="ranking-caption">
                                <div class="ranking-caption-heading">Threads</div>
                                <div class="ranking-caption-subheading text-muted">Illustration</div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</section>
<!-- Team-->
<section class="page-section bg-light" id="team">
    <div class="container">
        <div class="text-center">
            <h2 class="section-heading text-uppercase">Equipe</h2>
            <h3 class="section-subheading text-muted">Trabalho de LPOO2</h3>
        </div>
        <div class="row">
            <div class="col-lg-3">
                <div class="team-member">
                    <img class="mx-auto rounded-circle" src="assets/img/team/Gustavo.jpeg" alt="..." />
                    <h4>Gustavo Schwanka</h4>
                    <p class="text-muted">Desenvolvedor</p>
                    <a class="btn btn-dark btn-social mx-2" href="#!" aria-label="Parveen Anand Twitter Profile"><i class="fab fa-twitter"></i></a>
                    <a class="btn btn-dark btn-social mx-2" href="#!" aria-label="Parveen Anand Facebook Profile"><i class="fab fa-facebook-f"></i></a>
                    <a class="btn btn-dark btn-social mx-2" href="#!" aria-label="Parveen Anand LinkedIn Profile"><i class="fab fa-linkedin-in"></i></a>
                </div>
            </div>
            <div class="col-lg-3">
                <div class="team-member">
                    <img class="mx-auto rounded-circle" src="assets/img/team/Leonardo.jpeg" alt="..." />
                    <h4>Leonardo Xavier da Silva Moraes</h4>
                    <p class="text-muted">Desenvolvedor</p>
                    <a class="btn btn-dark btn-social mx-2" href="#!" aria-label="Diana Petersen Twitter Profile"><i class="fab fa-twitter"></i></a>
                    <a class="btn btn-dark btn-social mx-2" href="#!" aria-label="Diana Petersen Facebook Profile"><i class="fab fa-facebook-f"></i></a>
                    <a class="btn btn-dark btn-social mx-2" href="#!" aria-label="Diana Petersen LinkedIn Profile"><i class="fab fa-linkedin-in"></i></a>
                </div>
            </div>
            <div class="col-lg-3">
                <div class="team-member">
                    <img class="mx-auto rounded-circle" src="assets/img/team/Lucas.jpeg" alt="..." />
                    <h4>Lucas Cassilha Zawadneak</h4>
                    <p class="text-muted">Desenvolvedor</p>
                    <a class="btn btn-dark btn-social mx-2" href="#!" aria-label="Larry Parker Twitter Profile"><i class="fab fa-twitter"></i></a>
                    <a class="btn btn-dark btn-social mx-2" href="#!" aria-label="Larry Parker Facebook Profile"><i class="fab fa-facebook-f"></i></a>
                    <a class="btn btn-dark btn-social mx-2" href="#!" aria-label="Larry Parker LinkedIn Profile"><i class="fab fa-linkedin-in"></i></a>
                </div>
            </div>
            <div class="col-lg-3">
                <div class="team-member">
                    <img class="mx-auto rounded-circle" src="assets/img/team/Ludimilla.jpg" alt="..." />
                    <h4>Ludimilla Krautzuk</h4>
                    <p class="text-muted">Desenvolvedora</p>
                    <a class="btn btn-dark btn-social mx-2" href="https://twitter.com/Sis_ludi?t=0MgZYq4ntXpp-pdJYBJ6YA&s=09" aria-label="Ludimilla Twitter Profile"><i class="fab fa-twitter"></i></a>
                    <a class="btn btn-dark btn-social mx-2" href="https://www.facebook.com/sisludimillakrautzuk/" aria-label="Ludimilla Facebook Profile"><i class="fab fa-facebook-f"></i></a>
                    <a class="btn btn-dark btn-social mx-2" href="https://www.linkedin.com/in/ludimillakrautzuk/" aria-label="Larry Parker LinkedIn Profile"><i class="fab fa-linkedin-in"></i></a>
                </div>
            </div>
        </div>
    </div>
</section>
<!--  Footer-->
<footer class="footer py-4">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-lg-4 text-lg-start">Copyright &copy; Your Website 2022</div>
            <div class="col-lg-4 text-lg-end">
                <a class="link-dark text-decoration-none me-3" href="#!">Privacy Policy</a>
                <a class="link-dark text-decoration-none" href="#!">Terms of Use</a>
            </div>
        </div>
    </div>
</footer>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="js/scripts.js"></script>
<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>
