package com.cos.costagram.domain.follow;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;

import com.cos.costagram.domain.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="follow", uniqueConstraints = {@UniqueConstraint(name="follow_uk", columnNames= {"fromUserId", "toUserId"})} )
public class Follow {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JsonIgnoreProperties({"images"})
	@JoinColumn(name = "fromUserId")
	@ManyToOne
	private User fromUser; // ~~로부터
	
	@JsonIgnoreProperties({"images"})
	@JoinColumn(name = "toUserId")
	@ManyToOne
	private User toUser; // ~~를
	
	@CreationTimestamp
	private Timestamp createDate;
}
