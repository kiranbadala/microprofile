package com.kiran.practice.microprofile.micro.profile;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.kiran.practice.microprofile.micro.profile.dao.PostDao;

@ApplicationScoped
@Path("/post")
public class PostController {

	@Inject
	private PostDao dao;

	@GET
	@Path("/datasource")
	public String getRecord() {
		return dao.fetchTopRecord();
	}

	@GET
	@Path("/hikari/datasource")
	public String getRecordUsingCPDataSource() {
		return dao.fetchTopRecordUsingHKDataSource();
	}
}
