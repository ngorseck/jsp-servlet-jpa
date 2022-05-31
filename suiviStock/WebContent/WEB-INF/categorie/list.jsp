<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../../header.jsp"></jsp:include>
	<div class="content">
    	<div class="container-fluid">
    	<div class="row">
             <div class="col-md-4">
                  <div class="card ">
                       <div class="card-header ">
                             <h4 class="card-title">Formulaire de gestion des categories</h4>
                       </div>
                       <div class="card-body ">
                           <form action="Categorie" method="post">
                           		<div class="form-group">
                           			<label class="control-label">Reference</label>
                           			<input class="form-control" type="text" name="ref" required="required"/>
                           		</div>
                           		<div class="form-group">
                           			<label class="control-label">Nom</label>
                           			<input class="form-control" type="text" name="nom" required="required"/>
                           		</div>
                           		<div class="form-group">
                           			<input class="btn btn-success" type="submit" name="envoyer" value="Envoyer"/>
                           			<input class="btn btn-danger" type="reset" name="annuler" value="Annuler"/>
                           		</div>
                           </form>
                           <hr>
                           <div class="stats">
                                <i class="fa fa-clock-o"></i> Categories
                           </div>
                        </div>
                   </div>
              </div>
              <div class="col-md-8">
                   <div class="card ">
                      <div class="card-header ">
                         <h4 class="card-title">Liste des categories</h4>
                      </div>
                      <div class="card-body ">
                          <table class="table table-striped table-bordered">
                          	<tr>
                          		<th>Reference</th>
                          		<th>Nom</th>
                          		<th>Utilisateur</th>
                          		<th>Action</th>
                          		<th>Action</th>
                          		<th>Action</th>
                          	</tr>
                          	<c:forEach items="${list_categories}" var="c">
                          		<tr>
                          			<td>${c.ref}</td>
                          			<td>${c.nom}</td>
                          			<td>${c.id}</td>
                          			<td>Editer</td>
                          			<td>Supprimer</td>
                          			<td>Visualiser</td>
                          		</tr>
                          	</c:forEach>
                          </table>
                      </div>
                      <div class="card-footer ">
                        <div class="stats">
                            <i class="fa fa-history"></i> Liste des categories
                        </div>
                      </div>
                   </div>
              </div>
          </div>
    	</div>     
    </div>
<jsp:include page="../../footer.jsp"></jsp:include>