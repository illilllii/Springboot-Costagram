package com.cos.costagram.domain.image;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ImageRepository extends JpaRepository<Image, Integer>{

	@Query(value="SELECT * FROM image WHERE userId in (SELECT toUserId From follow WHERE fromUserId=:principalId) order by id desc", nativeQuery = true)
	List<Image> mFeed(int principalId);

}
