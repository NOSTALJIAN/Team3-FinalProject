package com.mulcam.SpringProject.chatting.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IProjectSummaryMapper {
	Map<String, Object> selectJoinMemberListWithProfileImgByGroupNo(int groupNo);
}
