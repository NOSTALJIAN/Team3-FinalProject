package com.mulcam.SpringProject.chat;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "User")
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class ChatUser {
	
    @EqualsAndHashCode.Include
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "pwd")
    private String pwd;
    
    @Column(name = "uname")
    private String uname;
    
    @Column(name = "uImage")
    private String uImage;
    
    @Column(name = "phoneNum")
    private String phoneNum;
    
    @Column(name = "email")
    private String email;

    @Column(name = "emailcheck")
    private int emailcheck;
    
    @Column(name = "role")
    private int role;
    
    @Column(name = "uRegDate")
    private LocalDate uRegDate;
    
    @Column(name = "uIsDeleted")
    private int uIsDeleted;
}
