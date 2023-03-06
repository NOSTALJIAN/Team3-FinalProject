package com.mulcam.SpringProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.mulcam.SpringProject.entity.Reply;


	@Mapper
	public interface ReplyDao {

	@Select("SELECT r.rid, r.bid, r.uid, r.rContent, r.rRegTime, r.rIsMine, u.nickname "
			+ "	FROM boardReply AS r"
			+ "	JOIN users AS u"
			+ "	ON r.uid=u.uid"
			+ "	WHERE r.bid=#{bid}")
	public List<Reply> getReplyList(int bid);
	
	@Insert("INSERT INTO boardReply"
			+ " VALUES (default, #{bid}, #{uid}, #{rContent}, default, #{rIsMine})")
	public void insertReply(Reply reply);

	@Update("UPDATE boardReply SET rContent=#{rContent}, rRegTime=NOW() WHERE rid=#{rid}")
	void updateReply(Reply reply);

	@Delete("Delete from boardReply WHERE rid=#{rid} ")
	void deleteReply(int rid);
}
