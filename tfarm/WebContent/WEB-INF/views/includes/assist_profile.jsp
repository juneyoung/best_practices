<%@page import="org.owls.tfarm.common.session.SessionManager"%>
<%@page import="org.owls.tfarm.mongo.documents.User"%>
<%
	if(session == null){ response.sendRedirect("/"); return; }
	String session_id = String.valueOf(session.getAttribute("session_id"));	
	User user = SessionManager.getSessionUser(session_id);
	if(user == null) { response.sendRedirect("/"); return;}
	System.out.println(user);
%>
<script>
	function logout(){
		ajax('/member/logout', {}, function(result){
			if(result.result != 'S') {
				alert('ERROR >>> ', result.result_msg);
				return;
			} else {
				alert('Sign out success');
				location.href = '/';
			}
		});
	}
</script>
<li class="dropdown user user-menu">
  <a href="#" class="dropdown-toggle" data-toggle="dropdown">
    <img src="http://www.gravatar.com/avatar/<%= user.getGravatar() %>" class="user-image" alt="User Image">
    <span class="hidden-xs"><%= user.getName() %></span>
  </a>
  <ul class="dropdown-menu">
    <!-- User image -->
    <li class="user-header">
      <img src="http://www.gravatar.com/avatar/<%= user.getGravatar() %>" class="img-circle" alt="User Image">

      <p>
        <%= user.getName() %> - <%= user.getProfessional() %>
        <small>Member since Nov. 2012</small>
      </p>
    </li>
    <!-- Menu Body -->
    <li class="user-body">
      <div class="row">
        <div class="col-xs-4 text-center">
          <a href="#">Followers</a>
        </div>
        <div class="col-xs-4 text-center">
          <a href="#">Sales</a>
        </div>
        <div class="col-xs-4 text-center">
          <a href="#">Friends</a>
        </div>
      </div>
      <!-- /.row -->
    </li>
    <!-- Menu Footer-->
    <li class="user-footer">
      <div class="pull-left">
        <a href="#" class="btn btn-default btn-flat">Profile</a>
      </div>
      <div class="pull-right">
        <a href="javascript:logout();" class="btn btn-default btn-flat">Sign out</a>
      </div>
    </li>
  </ul>
</li>