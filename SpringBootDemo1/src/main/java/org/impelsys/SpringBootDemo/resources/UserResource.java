package org.impelsys.SpringBootDemo.resources;

import javax.ws.rs.GET;

//import java.net.URISyntaxException;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.impelsys.SpringBootDemo.dao.UserDao;
import org.impelsys.SpringBootDemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Path("/users")
@XmlRootElement(name="User")
public class UserResource {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	@Qualifier("userDao")
	UserDao userDao;
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserById(@PathParam("id") int id){
		// db call
		System.out.println("In getUserById");
//		Session session = sessionFactory.openSession();
		User user = userDao.viewUser(id);
//		User u1 = new User();
//		u1.setId(2);
//		u1.setUserEmail("asjhsa@gmail.com");
//		u1.setUserName("akash");
//		int r = userDao.addUser(u1);
//		System.out.println(r+" have been affected");
		Response.ResponseBuilder builder = Response.ok(Status.OK);
		Response response = builder.entity(user).build();
		//return Response.status(200).entity(user).build();
//		session.close();
		return response;
	}

}
