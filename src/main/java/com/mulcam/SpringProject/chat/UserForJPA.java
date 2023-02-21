package com.mulcam.SpringProject.chat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_forjpa")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "uid")
public class UserForJPA {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String uid;
	private String email;
	private String uname;
	private String pwd;
}
