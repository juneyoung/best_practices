package org.owls.tfarm.mongo.documents;

import java.security.NoSuchAlgorithmException;

import org.owls.tfarm.utils.crypto.CryptoUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/*
 * POJO representing User
 * - @Id annotation will automatically mapping with ObjectId(_id), not custom field
 * - use @Field to mapping a field has different DB column
 * */
@Document(collection = "user")
public class User {
	
	@Id
	@Field(value="_id")
	private String id;

	@Field(value="name")
	private String name;

	@Field(value="password")
	private String password;

	@Field(value="professional")
	private String professional;

	@Field(value="email")
	private String email;

	@Field(value="gravatar")
	private String gravatar;
	
	@PersistenceConstructor
	public User(String id, String name, String password, String professional, String email, String gravatar) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.professional = professional;
		this.email = email;
		this.gravatar = gravatar;
	}
	
	public User(String id, String name, String password, String professional, String email) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.professional = professional;
		this.email = email;
		try {
			this.gravatar = CryptoUtils.MD5(email);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

//	public ObjectId get_id() {
//		return _id;
//	}
//
//	public void set_id(ObjectId _id) {
//		this._id = _id;
//	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfessional() {
		return professional;
	}

	public void setProfessional(String professional) {
		this.professional = professional;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGravatar() {
		return gravatar;
	}

	public void setGravatar(String gravatar) {
		this.gravatar = gravatar;
	}
};